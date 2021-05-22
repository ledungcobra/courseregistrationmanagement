package com.ledungcobra.dao;

import com.ledungcobra.entites.Subject;
import lombok.val;
import org.hibernate.Session;

import java.util.ArrayList;
import java.util.List;

public class SubjectDao extends BaseDao<Subject, String> {
    public SubjectDao(Session session) {
        super(session);
    }

    public List<Subject> search(String keyword) {

        List<Subject> subjects = null;
        try {

            boolean isNumber = keyword.matches("\\d+");
            StringBuilder queryStringBuilder = new StringBuilder();
            queryStringBuilder.append("select distinct s from Subject s where (s.name like :k) or (s.id like :k)");

            if (isNumber) {
                queryStringBuilder.append("or (s.credit = :key)");
            }
            val query = this.session.createQuery(queryStringBuilder.toString());
            query.setParameter("k", "%" + keyword + "%");

            if (isNumber) {
                query.setParameter("key", Integer.parseInt(keyword));
            }
            subjects = query.getResultList();
        } catch (Exception e) {
            subjects = new ArrayList<>();
        }

        return subjects;
    }

}
