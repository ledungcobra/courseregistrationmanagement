package com.ledungcobra;

import com.ledungcobra.utils.HibernateUtils;
import org.hibernate.Hibernate;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Hello world!
 *
 */
public class Main
{
    public static void main( String[] args ) throws ClassNotFoundException, SQLException {
        HibernateUtils.getCurrentSession();

    }
}
