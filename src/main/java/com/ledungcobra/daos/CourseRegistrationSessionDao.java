package com.ledungcobra.daos;

import com.ledungcobra.entites.CourseRegistrationSession;
import lombok.val;
import org.hibernate.Session;
import org.hibernate.query.NativeQuery;
import org.hibernate.query.Query;

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

    public CourseRegistrationSession getGetRecentSession() throws Exception
    {
        try
        {
            return session
                    .createNativeQuery(" SELECT from course_registration_session s " +
                            " inner join (SELECT s1.CSR_ID, max(s1.START_DATE) FROM course_registration_session s1)) " +
                            " s2 on s2.CSR_ID=s.CSR_ID limit 1 ", CourseRegistrationSession.class)
                    .getSingleResult();
        } catch (Exception e)
        {
            e.printStackTrace();
            throw new Exception("There is no course registration session opened");
        }

    }
}
