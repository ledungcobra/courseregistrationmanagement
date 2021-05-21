package com.ledungcobra.service;

import com.ledungcobra.applicationcontext.AppContext;
import com.ledungcobra.dao.BaseDao;
import com.ledungcobra.dao.UserDao;
import com.ledungcobra.entites.StudentAccount;
import com.ledungcobra.entites.TeachingManager;
import com.ledungcobra.entites.User;
import com.ledungcobra.exception.*;
import lombok.NonNull;
import lombok.val;
import org.hibernate.Transaction;

import javax.persistence.NoResultException;
import java.util.Objects;

public abstract class UserService<E extends User> {

    protected UserDao userDao;

    protected UserService(E... e) {

        Class<E> typeClass = (Class<E>) e.getClass().getComponentType();
        if (typeClass.getSimpleName()
                .equals(StudentAccount.class.getSimpleName())) {
            userDao = AppContext.studentDao;
        } else if (typeClass.getSimpleName().equals(TeachingManager.class.getSimpleName())) {
            userDao = AppContext.teachingManagerDao;
        }

    }

    protected Transaction beginTransaction() {
        return AppContext.session.beginTransaction();
    }

    public boolean login(@NonNull String username, @NonNull String password) throws UserNotFound, NoResultException {

        User user = userDao.findUserByUserId(username);

        if (Objects.nonNull(user)) {
            if (password.equals(user.getPassword())) {
                return true;
            } else {
                return false;
            }
        } else {
            throw new UserNotFound("");
        }
    }


    public void changePassword(@NonNull String id,
                               @NonNull String oldPassword,
                               @NonNull String newPassword,
                               @NonNull String confirmPassword)
            throws AccountNotFound, PasswordDoesNotChange, ConfirmPasswordFail, CannotUpdatePassword {

        User user = userDao.findUserByUserId(id);

        if (Objects.isNull(user)) {
            throw new AccountNotFound("The id " + id + " is match with no rows");
        }

        if (oldPassword.equals(newPassword)) {
            throw new PasswordDoesNotChange("The new password must be different from the former password");
        }

        if (!newPassword.equals(confirmPassword)) {
            throw new ConfirmPasswordFail("Password does not match");
        }

        user.setPassword(newPassword);

        try {

            val trans = beginTransaction();
            userDao.update(user);
            trans.commit();

        } catch (Exception exception) {
            throw new CannotUpdatePassword("Update password failed");
        }
    }

    public E findById(String id) {
        return (E) userDao.findUserByUserId(id);
    }

    public E save(E e) {

        val trans = beginTransaction();
        val value = (E) ((BaseDao) userDao).save(e);
        trans.commit();

        return value;
    }

    protected void doTransaction(DoWork work){
        Transaction trans = null;
        try {
            trans = beginTransaction();
            work.run();
            trans.commit();
        } finally {
            if (trans != null && trans.isActive()) {
                trans.rollback();
            }
        }
    }
}
