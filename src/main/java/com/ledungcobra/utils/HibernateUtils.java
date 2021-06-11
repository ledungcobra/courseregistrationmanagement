package com.ledungcobra.utils;

import lombok.val;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.Objects;

import static com.ledungcobra.utils.Constants.*;

public class HibernateUtils
{

    private static SessionFactory sessionFactory;
    private static Session session;


    public static void buildSessionFactory(String connectionString, String username, String password)
    {
        Configuration cfg = new Configuration().configure("hibernate.cfg.xml");
        cfg.setProperty("hibernate.connection.url", connectionString);
        cfg.setProperty("hibernate.connection.username", username);
        cfg.setProperty("hibernate.connection.password", password);

        sessionFactory = cfg.buildSessionFactory();
    }

    public static void sql(String sql)
    {
        val session = openSession();

        val trans = session.beginTransaction();
        try
        {
            val query = session.createSQLQuery(sql);
            query.executeUpdate();
            session.clear();
            trans.commit();
        } finally
        {
            if (trans != null && trans.isActive())
            {
                trans.rollback();
            }
        }
    }


    public static Session openSession()
    {
        if (sessionFactory == null) buildSessionFactory(DEFAULT_CONNECTION_STRING, DEFAULT_USER_NAME, DEFAULT_PASSWORD);
        if (Objects.isNull(session))
        {
            session = sessionFactory.openSession();
        }

        return session;
    }

    public static void closeSession()
    {
        if (Objects.nonNull(session))
        {
            session.close();
        }
    }

}
