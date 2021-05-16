package com.ledungcobra.dao;

import com.ledungcobra.entites.Class;
import com.ledungcobra.entites.Student;
import lombok.val;
import org.hibernate.Session;

import java.util.List;

public class StudentDao extends BaseDao<Student, String> implements UserDao<Student> {

    public StudentDao(Session session) {
        super(session);
    }

    @Override
    public Student findUserByUserName(String username) {
        return (Student) session.createQuery("from " + Student.class.getSimpleName() + "where username=:username")
                .setParameter("username", username).getSingleResult();
    }

    public List<Student> searchStudent(Class classEntity, String keyword) {
        val query = this.session.createQuery("select distinct s from " +
                "Student s where s.class=:className and (s.userName like :k or s.userName like :k or s.id like :k)");
        query.setParameter("className", classEntity);
        query.setParameter("k", keyword);
        return (List<Student>) query.getResultList();
    }

    public void addStudentToClass(Student student, Class classEntity) {
        student.setStudiedClass(classEntity);
        session.update(student);
    }
}
