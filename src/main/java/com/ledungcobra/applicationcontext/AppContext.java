package com.ledungcobra.applicationcontext;

import com.ledungcobra.dao.*;
import com.ledungcobra.databoostrap.DataBoostrap;
import com.ledungcobra.service.StudentService;
import com.ledungcobra.service.TeachingManagerService;
import com.ledungcobra.utils.HibernateUtils;
import org.hibernate.Session;

import java.text.DateFormat;
import java.util.Locale;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class AppContext
{

    public static Session session;
    public static final ClassDao classDao;
    public static final CourseDao courseDao;
    public static final CourseRegistrationSessionDao courseRegistrationDao;
    public static final SemesterDao semesterDao;
    public static final StudentCourseDao studentCourseDao;
    public static final StudentDao studentAccountDao;
    public static final SubjectDao subjectDao;
    public static final TeachingManagerDao teachingManagerDao;
    public static final EducationTypeDao educationTypeDao;
    public static final StudentService studentService;
    public static final TeachingManagerService teachingManagerService;
    public static final DateFormat dateFormat = DateFormat.getDateInstance(DateFormat.DEFAULT, new Locale("vi", "VN"));
    public static final StudentInfoDao studentInfoDao;
    public static final CourseInfoDao courseInfoDao;

    public static final ExecutorService executorService;


    static
    {

        HibernateUtils.buildSessionFactory();

        session = HibernateUtils.openSession();
        classDao = new ClassDao(session);
        courseDao = new CourseDao(session);
        courseRegistrationDao = new CourseRegistrationSessionDao(session);
        semesterDao = new SemesterDao(session);
        studentCourseDao = new StudentCourseDao(session);
        studentAccountDao = new StudentDao(session);
        subjectDao = new SubjectDao(session);
        teachingManagerDao = new TeachingManagerDao(session);
        educationTypeDao = new EducationTypeDao(session);
        studentInfoDao = new StudentInfoDao(session);
        courseInfoDao = new CourseInfoDao(session);

        studentService = new StudentService();
        teachingManagerService = new TeachingManagerService();
        executorService = Executors.newFixedThreadPool(3);

        new DataBoostrap().run();

    }

    public static void closeSession()
    {
        HibernateUtils.closeSession();
    }


}
