package com.ledungcobra.dao;

import com.ledungcobra.entites.Subject;
import org.hibernate.Session;

public class SubjectDao extends BaseDao<Subject, String>{
    public SubjectDao(Session session) {
        super(session);
    }
}
