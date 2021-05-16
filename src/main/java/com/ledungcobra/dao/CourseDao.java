package com.ledungcobra.dao;

import com.ledungcobra.entites.Course;
import org.hibernate.Session;

public class CourseDao extends BaseDao<Course, String>{

    public CourseDao(Session session) {
        super(session);
    }

}
