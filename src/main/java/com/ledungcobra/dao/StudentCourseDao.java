package com.ledungcobra.dao;

import com.ledungcobra.applicationcontext.AppContext;
import com.ledungcobra.entites.*;
import com.ledungcobra.entites.embedable.StudentCourseId;
import lombok.val;
import org.hibernate.Session;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

public class StudentCourseDao extends BaseDao<StudentCourse, StudentCourseId>
{
    public StudentCourseDao(Session session)
    {
        super(session);
    }

    public List<StudentCourse> getListStudentRegisterACourse(CourseInfo courseInfo, Semester activeSemester)
    {
        try
        {
            val query = AppContext.session.createQuery("from StudentCourse sc where sc.id.course.courseInfo=:courseInfo and sc.id.semester=:activeSemester");
            query.setParameter("courseInfo", courseInfo);
            query.setParameter("activeSemester", activeSemester);
            return query.getResultList();
        } catch (Exception e)
        {
            return new ArrayList<>();
        }
    }

    public void deleteStudentCourse(HashSet<Course> courses, StudentAccount studentAccount, Semester semester)
    {

        val increaseSlot = session.createQuery("update Course c set  numberOfSlot=numberOfSlot+1 where c.id in (:courseIds) and " +
                "c.id in (select s.id.course.id from StudentCourse s where s.id.studentAccount=:studentAccount)");
        increaseSlot.setParameter("courseIds", courses.stream().map(c -> c.getId()).collect(Collectors.toList()));
        increaseSlot.setParameter("studentAccount", studentAccount);
        increaseSlot.executeUpdate();

        val query = session.createQuery("delete  from StudentCourse sc where sc.id.semester = :semester and " +
                "sc.id.studentAccount = :studentAccount and sc.id.course in :courses");

        query.setParameter("semester", semester);
        query.setParameter("studentAccount", studentAccount);
        query.setParameter("courses", courses);
        query.executeUpdate();

        this.session.clear();
    }

    @Override
    public StudentCourse save(StudentCourse obj)
    {
        saveOrUpdate(obj);
        return obj;
    }
}
