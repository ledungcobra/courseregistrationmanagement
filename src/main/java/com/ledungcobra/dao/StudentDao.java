package com.ledungcobra.dao;

import com.ledungcobra.entites.Class;
import com.ledungcobra.entites.StudentAccount;
import lombok.val;
import org.hibernate.Session;

import java.util.List;

public class StudentDao extends BaseDao<StudentAccount, String> implements UserDao<StudentAccount> {

    public StudentDao(Session session) {
        super(session);
    }

    @Override
    public StudentAccount findUserByUserId(String username) {
        return (StudentAccount) session
                .createQuery("from StudentAccount sa where sa.studentCardId=:username")
                .setParameter("username", username).getSingleResult();
    }

    public List<StudentAccount> searchStudent(Class classEntity, String keyword) {
        val query = this.session.createQuery("select distinct s from " +
                "StudentAccount s where s.class=:className and (s.userName like :k or s.userName like :k or s.id like :k)");
        query.setParameter("className", classEntity);
        query.setParameter("k", keyword);
        return (List<StudentAccount>) query.getResultList();
    }

    public void addStudentToClass(StudentAccount student, Class classEntity) {
//        student.setStudiedClass(classEntity);
        session.update(student);
    }
}
