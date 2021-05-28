package com.ledungcobra.dao;

import com.ledungcobra.applicationcontext.AppContext;
import com.ledungcobra.entites.Semester;
import lombok.val;
import org.hibernate.Session;

import javax.persistence.NoResultException;
import java.text.DateFormat;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

public class SemesterDao extends BaseDao<Semester, Long> {

    public SemesterDao(Session session) {
        super(session);
    }

    public void setSemesterActive(Semester semester) {
        val query1 = session.createQuery("UPDATE Semester s SET s.active=false where s.id != :id");
        query1.setParameter("id", semester.getId());
        query1.executeUpdate();
        val query2 = session.createQuery("UPDATE Semester s SET s.active=true where s.id = :id");
        query2.setParameter("id", semester.getId());
        query2.executeUpdate();
        session.clear();
    }

    public Semester getActiveSemester() {

        Semester semester = null;
        try {
            semester = (Semester) session.createQuery("from Semester where active = true").getSingleResult();
        } catch (NoResultException e) {
            semester = null;
        }
        return semester;
    }

    public List<Semester> searchSemester(String text) {
        boolean isNumber = text.matches("\\d+");
        boolean isDate = true;

        try {
            DateFormat.getDateInstance(DateFormat.DEFAULT, new Locale("vi", "VN")).parse(text);
        } catch (ParseException e) {
            isDate = false;
        }


        List<Semester> semesters = null;
        try {
            StringBuilder queryBuilder = new StringBuilder();
            queryBuilder.append("select distinct s from Semester s where (s.semesterName like :keyword)");

            if (isNumber) {
                queryBuilder.append(" or (s.id = :id) or (s.year = :year)");
            }

            if (isDate) {
                queryBuilder.append(" or (s.startDate = :startDate) or (s.endDate = :endDate)");
            }

            val query = session.createQuery(queryBuilder.toString());
            query.setParameter("keyword", "%" + text + "%");


            if (isDate) {
                try {
                    query.setParameter("startDate", AppContext.dateFormat.parse(text));
                    query.setParameter("endDate", AppContext.dateFormat.parse(text));
                } catch (ParseException e) {
                    e.printStackTrace();
                }
            }

            if (isNumber) {
                query.setParameter("id", Long.parseLong(text));
                query.setParameter("year", Integer.parseInt(text));
            }

            semesters = query.getResultList();

        } catch (NoResultException e) {
            semesters = new ArrayList<>();
        }
        return semesters;
    }

    @Override
    public Semester save(Semester obj) {
        if (obj.getActive()) {
            val id = session.save(obj);
            val query = session.createQuery("update Semester s set s.active = false where s.id != :id");
            query.setParameter("id", id);
            query.executeUpdate();
            session.clear();

            return obj;
        } else {
            return super.save(obj);
        }
    }

    @Override
    public Semester update(Semester obj) {
        if (obj.getActive()) {
            session.update(obj);
            val query = session.createQuery("update Semester s set s.active = false where s.id != :id");
            query.setParameter("id", obj.getId());
            query.executeUpdate();
            session.clear();
            return obj;
        }
        return super.update(obj);
    }
}
