package com.ledungcobra.dao;

import com.ledungcobra.entites.CourseRegistrationSession;
import org.hibernate.Session;

public class CourseRegistrationSessionDao extends BaseDao<CourseRegistrationSession,Long> {

    public CourseRegistrationSessionDao(Session session) {
        super(session);
    }

}
