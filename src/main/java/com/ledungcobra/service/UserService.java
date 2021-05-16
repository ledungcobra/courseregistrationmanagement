package com.ledungcobra.service;

import com.ledungcobra.applicationcontext.AppContext;
import com.ledungcobra.dao.BaseDao;
import com.ledungcobra.dao.UserDao;
import com.ledungcobra.entites.Student;
import com.ledungcobra.entites.TeachingManager;
import com.ledungcobra.entites.User;
import com.ledungcobra.exception.*;
import lombok.NonNull;

import java.util.Objects;

public abstract class UserService<E extends User> {

    protected BaseDao userDao;

    protected UserService(E... e) {

        Class<E> typeClass = (Class<E>) e.getClass().getComponentType();
        if (typeClass.getSimpleName()
                .equals(Student.class.getSimpleName())) {
            userDao = AppContext.studentDao;
        }else if(typeClass.getSimpleName().equals(TeachingManager.class.getSimpleName())){
            userDao = AppContext.teachingManagerDao;
        }

    }

    public boolean login(@NonNull String username, @NonNull String password) throws UserNotFound {

        User student = (User) userDao.findById(username);

        if (Objects.nonNull(student)) {
            if(password.equals(student.getPassword())){
                return true;
            }else{
                return false;
            }
        }else{
             throw new UserNotFound("");
        }

    }


    public void changePassword(@NonNull String id,
                               @NonNull String oldPassword,
                               @NonNull String newPassword,
                               @NonNull String confirmPassword)
            throws AccountNotFound, PasswordDoesNotChange, ConfirmPasswordFail, CannotUpdatePassword {

        User user = (User) userDao.findById(id);

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
            userDao.update(user);
        } catch (Exception exception) {
            throw new CannotUpdatePassword("Update password failed");
        }
    }

    public E findById(String id){
       return (E) userDao.findById(id);
    }


}
