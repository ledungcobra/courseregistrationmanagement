package com.ledungcobra.daos;

import com.ledungcobra.entites.Class;
import org.hibernate.Session;


public class ClassDao extends BaseDao<Class, Long>
{
    public ClassDao(Session session)
    {
        super(session);
    }
}
