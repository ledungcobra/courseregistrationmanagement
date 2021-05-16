package com.ledungcobra.dao;

import com.ledungcobra.entites.StudentCourseSemester;
import com.ledungcobra.entites.embedable.StudentCourseSemesterId;
import org.hibernate.Session;

public class StudentCourseDao extends BaseDao<StudentCourseSemester, StudentCourseSemesterId> {
    public StudentCourseDao(Session session) {
        super(session);
    }
}
