package com.ledungcobra.dao;

import com.ledungcobra.entites.TeachingManager;
import lombok.val;
import org.hibernate.Session;

import java.util.List;

public class TeachingManagerDao extends BaseDao<TeachingManager, String> implements UserDao<TeachingManager> {

    public TeachingManagerDao(Session session) {
        super(session);
    }

    @Override
    public TeachingManager findUserByUserId(String username) {
        return (TeachingManager) session.createQuery("from TeachingManager t where t.id=:username").setParameter("username", username).getSingleResult();
    }

    public List<TeachingManager> findTeachingManager(String keyword) {
        val query = session.createQuery("select distinct tm from TeachingManager tm where tm.id like :k or tm.userName like :k or tm.fullName like :k");
        query.setParameter("k", "%" + keyword + "%");
        return (List<TeachingManager>) query.getResultList();
    }
}
