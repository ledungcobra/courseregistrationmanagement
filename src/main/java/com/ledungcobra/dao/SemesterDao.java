package com.ledungcobra.dao;

import com.ledungcobra.entites.Semester;
import lombok.val;
import org.hibernate.Session;

import javax.persistence.NoResultException;

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
}
