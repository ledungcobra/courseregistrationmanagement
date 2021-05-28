package com.ledungcobra.dao;

import com.ledungcobra.entites.Class;
import com.ledungcobra.entites.StudentAccount;
import com.ledungcobra.entites.StudentInfo;
import lombok.val;
import org.hibernate.Session;

import java.util.List;

public class StudentDao extends BaseDao<StudentAccount, String> implements UserDao<StudentAccount> {

    public StudentDao(Session session) {
        super(session);
    }

    @Override
    public StudentAccount findByUserName(String studentCardId) {
        return (StudentAccount) session
                .createQuery("from StudentAccount sa where sa.studentCardId=:val")
                .setParameter("val", studentCardId).getSingleResult();
    }

    public List<StudentAccount> searchStudent(Class classEntity, String keyword) {

        val query = this.session.createQuery("select distinct s from StudentAccount s where s.class=:className " +
                "and (s.fullName like :k or s.studentCardId like :k or s?.id?.studentInfo?.id like :k)");

        query.setParameter("className", classEntity);
        query.setParameter("k", keyword);

        return (List<StudentAccount>) query.getResultList();
    }

    public void addStudentToClass(StudentAccount student, Class classEntity) {
        student.setStudiedClass(classEntity);
        session.saveOrUpdate(student);
    }

}
