package com.ledungcobra.dao;

import com.ledungcobra.applicationcontext.AppContext;
import com.ledungcobra.entites.*;
import com.ledungcobra.entites.embedable.StudentCourseId;
import lombok.val;
import org.hibernate.Session;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class StudentCourseDao extends BaseDao<StudentCourse, StudentCourseId> {
    public StudentCourseDao(Session session) {
        super(session);
    }

    public List<StudentCourse> getListStudentRegisterACourse(CourseInfo courseInfo, Semester activeSemester) {
        try {
            val query = AppContext.session.createQuery("from StudentCourse sc where sc.id.course.courseInfo=:courseInfo and sc.id.semester=:activeSemester");
            query.setParameter("courseInfo", courseInfo);
            query.setParameter("activeSemester", activeSemester);
            return query.getResultList();
        } catch (Exception e) {
            return new ArrayList<>();
        }
    }

    public void deleteStudentCourse(HashSet<Course> courses, StudentAccount studentAccount, Semester semester) {

        val query = session.createQuery("delete  from StudentCourse sc where sc.id.semester = :semester and " +
                "sc.id.studentAccount = :studentAccount and sc.id.course in :courses");

        query.setParameter("semester", semester);
        query.setParameter("studentAccount", studentAccount);
        query.setParameter("courses", courses);
        System.out.println(query.executeUpdate() + " rows");
        this.session.clear();
    }

    @Override
    public StudentCourse save(StudentCourse obj) {
        saveOrUpdate(obj);
        return obj;
    }
}
