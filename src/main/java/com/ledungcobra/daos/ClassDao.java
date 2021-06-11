package com.ledungcobra.daos;

import com.ledungcobra.entites.Class;
import org.hibernate.Session;

import java.util.List;


public class ClassDao extends BaseDao<Class, Long>
{
    public ClassDao(Session session)
    {
        super(session);
    }

    public List<Class> search(String keyword)
    {
        List<Class> result;

        try
        {
            result = session.createQuery("from Class  c where c.className like :keyword", Class.class)
                    .setParameter("keyword", "%" + keyword + "%")
                    .getResultList();
        } catch (Exception e)
        {
            result = null;
        }
        return result;
    }
}
