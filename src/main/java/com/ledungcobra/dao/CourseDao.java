package com.ledungcobra.dao;

import com.ledungcobra.entites.Course;
import com.ledungcobra.entites.Semester;
import lombok.val;
import org.hibernate.Session;

import javax.persistence.NoResultException;
import java.util.ArrayList;
import java.util.List;

public class CourseDao extends BaseDao<Course, String>
{

    public CourseDao(Session session)
    {
        super(session);
    }

    public List<Course> search(String text)
    {

        List<Course> courses = null;
        String extension = "";
        if (text.matches("\\d+"))
        {
            extension = " or c.numberOfSlot = :slot or c.credit = :credit or c.id = :id  ";

        }
        try
        {
            val query = session.createQuery("select distinct  c from Course c" +
                    " where " +
                    "c.courseInfo.subject.name like :keyword or " +
                    "c.teacherName like :keyword or " +
                    "c.dayToStudyInWeek like :keyword or " +
                    "c.classroomName like :keyword or " +
                    "c.shiftToStudyInDay like :keyword" + extension);
            if (text.matches("\\d+"))
            {
                query.setParameter("slot", Integer.parseInt(text));
                query.setParameter("credit", Integer.parseInt(text));
                query.setParameter("id", Integer.parseInt(text));
            }
            query.setParameter("keyword", "%" + text + "%");
            courses = query.getResultList();
        } catch (NoResultException e)
        {
            courses = new ArrayList<>();
        }

        return courses;
    }

    public List<Course> getCourseOpenedInActiveSemester(Semester semester)
    {
        val query = session.createQuery("from Course c where c.courseInfo.semester=:semester");
        query.setParameter("semester", semester);
        return query.getResultList();
    }
}
