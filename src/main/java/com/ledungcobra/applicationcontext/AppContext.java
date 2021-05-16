package com.ledungcobra.applicationcontext;

import com.ledungcobra.dao.*;
import com.ledungcobra.service.StudentService;
import com.ledungcobra.service.TeachingManagerService;
import com.ledungcobra.utils.HibernateUtils;
import org.hibernate.Session;

public class AppContext {

    public static Session session;
    public static final ClassDao classDao;
    public static final CourseDao courseDao;
    public static final CourseRegistrationSessionDao courseRegistrationDao;
    public static final SemesterDao semesterDao;
    public static final StudentCourseDao studentCourseDao;
    public static final StudentDao studentDao;
    public static final SubjectDao subjectDao;
    public static final TeachingManagerDao teachingManagerDao;
    public static final StudentService studentService;
    public static final TeachingManagerService teachingManagerService;
    static {

        HibernateUtils.buildSessionFactory();
        session = HibernateUtils.openSession();
        classDao = new ClassDao(session);
        courseDao = new CourseDao(session);
        courseRegistrationDao = new CourseRegistrationSessionDao(session);
        semesterDao= new SemesterDao(session);
        studentCourseDao = new StudentCourseDao(session);
        studentDao = new StudentDao(session);
        subjectDao = new SubjectDao(session);
        teachingManagerDao = new TeachingManagerDao(session);
        studentService = new StudentService();
        teachingManagerService = new TeachingManagerService();


    }

    public static void closeSession() {
        HibernateUtils.closeSession();
    }


}
