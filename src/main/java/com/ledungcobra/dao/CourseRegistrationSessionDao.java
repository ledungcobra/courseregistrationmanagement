package com.ledungcobra.dao;

import com.ledungcobra.entites.CourseRegistrationSession;
import lombok.val;
import org.hibernate.Session;

import java.util.Date;

public class CourseRegistrationSessionDao extends BaseDao<CourseRegistrationSession, Long>
{

    public CourseRegistrationSessionDao(Session session)
    {
        super(session);
    }

    public CourseRegistrationSession getSessionInclude(Date currentDate) throws Exception
    {
        try
        {
            val query = session.createQuery("from CourseRegistrationSession s where (:date between s.startDate and s.endDate) and s.semester.active = true");
            query.setParameter("date", currentDate).setMaxResults(1);
            return (CourseRegistrationSession) query.getSingleResult();
        } catch (Exception e)
        {
            e.printStackTrace();
            throw new Exception("Cannot find valid session or the session belongs to the inactive semester");
        }

    }
}
