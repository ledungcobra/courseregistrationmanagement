package com.ledungcobra.daos;

import com.ledungcobra.entites.TeachingManager;
import lombok.val;
import org.hibernate.Session;

import javax.persistence.NoResultException;
import java.util.ArrayList;
import java.util.List;

public class TeachingManagerDao extends BaseDao<TeachingManager, String> implements UserDao<TeachingManager>
{

    public TeachingManagerDao(Session session)
    {
        super(session);
    }

    @Override
    public TeachingManager findByUserName(String username)
    {
        return (TeachingManager) session.createQuery("from TeachingManager t where t.id=:username").setParameter("username", username).getSingleResult();
    }

    public List<TeachingManager> search(String text)
    {
        List<TeachingManager> managers = null;

        try
        {
            val query = session.createQuery("select distinct  t from TeachingManager t" +
                    " where t.id like :keyword or t.fullName like :keyword or t.password like :keyword");
            query.setParameter("keyword", "%" + text + "%");
            managers = query.getResultList();
        } catch (NoResultException e)
        {
            managers = new ArrayList<>();
        }

        return managers;
    }
}
