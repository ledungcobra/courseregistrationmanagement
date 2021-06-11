package com.ledungcobra.applicationcontext;

import com.ledungcobra.daos.*;
import com.ledungcobra.databoostrap.DataBoostrap;
import com.ledungcobra.services.StudentService;
import com.ledungcobra.services.TeachingManagerService;
import com.ledungcobra.utils.HibernateUtils;
import org.hibernate.Session;

import java.text.DateFormat;
import java.util.Locale;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class AppContext
{

    public static Session session;
    public static ClassDao classDao;
    public static CourseDao courseDao;
    public static CourseRegistrationSessionDao courseRegistrationDao;
    public static SemesterDao semesterDao;
    public static StudentCourseDao studentCourseDao;
    public static StudentDao studentAccountDao;
    public static SubjectDao subjectDao;
    public static TeachingManagerDao teachingManagerDao;
    public static EducationTypeDao educationTypeDao;
    public static StudentService studentService;
    public static TeachingManagerService teachingManagerService;
    public static DateFormat dateFormat = DateFormat.getDateInstance(DateFormat.DEFAULT, new Locale("vi", "VN"));
    public static StudentInfoDao studentInfoDao;
    public static CourseInfoDao courseInfoDao;
    public static ExecutorService executorService;

    public static String connectionString;
    public static String username;
    public static String password;

    public static void build()
    {
        HibernateUtils.buildSessionFactory(connectionString, username, password);

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
