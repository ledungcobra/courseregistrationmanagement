package com.ledungcobra.dao;

import com.ledungcobra.entites.StudentCourse;
import com.ledungcobra.entites.embedable.StudentCourseId;
import org.hibernate.Session;

public class StudentCourseDao extends BaseDao<StudentCourse, StudentCourseId> {
    public StudentCourseDao(Session session) {
        super(session);
    }
}
