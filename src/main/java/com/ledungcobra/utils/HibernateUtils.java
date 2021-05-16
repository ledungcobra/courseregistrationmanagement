package com.ledungcobra.utils;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.Objects;

public class HibernateUtils {

    private static SessionFactory sessionFactory;
    private static Session session;


    public static void buildSessionFactory() {
        sessionFactory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
    }

    public static Session getCurrentSession() {
        return sessionFactory.getCurrentSession();
    }

    public static Session openSession() {

        if (Objects.isNull(session)) {
            session = sessionFactory.openSession();
        }
        return session;
    }

    public static void closeSession() {
        if (Objects.nonNull(session)) {
            session.close();
        }
    }

}
