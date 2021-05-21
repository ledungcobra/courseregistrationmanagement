package com.ledungcobra.service;

import com.ledungcobra.applicationcontext.AppContext;
import com.ledungcobra.dao.*;
import com.ledungcobra.entites.*;
import com.ledungcobra.entites.Class;
import lombok.NonNull;
import lombok.val;
import org.hibernate.Transaction;
import org.hibernate.exception.ConstraintViolationException;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class TeachingManagerService extends UserService<TeachingManager> {

    private CourseDao courseDao;
    private TeachingManagerDao teachingManagerDao;
    private SemesterDao semesterDao;
    private StudentDao studentDao;
    private CourseRegistrationSessionDao courseRegistrationSessionDao;
    private ClassDao classDao;
    private StudentCourseDao studentCourseDao;

    public TeachingManagerService() {
        courseDao = AppContext.courseDao;
        teachingManagerDao = AppContext.teachingManagerDao;
        semesterDao = AppContext.semesterDao;
        studentDao = AppContext.studentDao;
        courseRegistrationSessionDao = AppContext.courseRegistrationDao;
        classDao = AppContext.classDao;
        studentCourseDao = AppContext.studentCourseDao;
    }

    // Course Manager

    public List<Course> getCourseList() {
        return courseDao.findAll();
    }

    public Course addNewCourse(Course course) {

        val transaction = beginTransaction();
        courseDao.save(course);
        transaction.commit();

        return course;
    }

    public Course updateCourse(Course course) {

        val transaction = beginTransaction();
        courseDao.update(course);
        transaction.commit();

        return course;
    }

    public void deleteCourse(Course course) {

        val transaction = beginTransaction();
        courseDao.deleteByObject(course);
        transaction.commit();

    }

    // Teaching Manager

    public List<TeachingManager> getTeachingManagerList() {
        return teachingManagerDao.findAll();
    }

    public List<TeachingManager> findTeachingManager(String keyword) {
        return teachingManagerDao.findTeachingManager(keyword);
    }

    public TeachingManager addNewTeachingManager(TeachingManager teachingManager) {

        val transaction = beginTransaction();
        teachingManagerDao.save(teachingManager);
        transaction.commit();

        return teachingManager;
    }

    public TeachingManager updateTeachingManager(TeachingManager teachingManager) {

        val transaction = beginTransaction();
        teachingManagerDao.update(teachingManager);
        transaction.commit();

        return teachingManager;
    }

    public TeachingManager updateTeachingManagerPassword(@NonNull String id) {

        val transaction = beginTransaction();
        val teachingManager = teachingManagerDao.findById(id);
        teachingManager.setPassword(teachingManager.getId());
        teachingManagerDao.update(teachingManager);
        transaction.commit();
        return teachingManager;
    }

    public void deleteTeachingManager(String... ids) {

        val transaction = beginTransaction();

        for (String id : ids) {
            teachingManagerDao.deleteById(id);
        }

        transaction.commit();
    }

    // Semester

    public List<Semester> getSemesterList() {
        return semesterDao.findAll();
    }

    public Semester addNewSemester(Semester semester) {
        val transaction = beginTransaction();
        semesterDao.save(semester);
        transaction.commit();
        return semester;
    }

    public void deleteSemester(Semester semester) {
        val transaction = beginTransaction();
        semesterDao.deleteByObject(semester);
        transaction.commit();
    }

    public void setSemesterAsActive(@NonNull Semester semester) {
        semester.setActive(true);
        semesterDao.setSemesterActive(semester);
    }

    // Student management

    public List<StudentAccount> getListStudentInClass(@NonNull Class classEntity) {

        Transaction transaction = beginTransaction();
        val students = classEntity.getStudents();
        transaction.commit();

        return students;
    }

    public List<StudentAccount> searchStudent(@NonNull Class classEntity, @NonNull String keyword) {

        val transaction = beginTransaction();
        val students = studentDao.searchStudent(classEntity, keyword);
        transaction.commit();

        return students;
    }

    public void addStudentToClass(@NonNull StudentAccount student, @NonNull Class classEntity) {
        val transaction = beginTransaction();
        studentDao.addStudentToClass(student, classEntity);
        transaction.commit();
    }

    public StudentAccount updateStudentInfo(@NonNull StudentAccount student) {

        val transaction = beginTransaction();
        studentDao.update(student);
        transaction.commit();

        return student;
    }

    public StudentAccount resetStudentPassword(@NonNull StudentAccount student) {

        val transaction = beginTransaction();
        student.setPassword(student.getUserName());
        studentDao.update(student);
        transaction.commit();

        return student;
    }

    public List<CourseRegistrationSession> getCourseRegistrationSessionList() {
        return courseRegistrationSessionDao.findAll();
    }

    public CourseRegistrationSession addCourseRegistrationSession(@NonNull CourseRegistrationSession courseRegistrationSession) {

        //TODO
        val transaction = beginTransaction();
        val semester = semesterDao.getActiveSemester();

        courseRegistrationSession.setSemester(semester);
        courseRegistrationSessionDao.save(courseRegistrationSession);

        transaction.commit();
        return courseRegistrationSession;
    }

    // Course
    public List<Course> getCourseListInActiveSemester() {
        val activeSemester = semesterDao.getActiveSemester();
        if (Objects.nonNull(activeSemester)) {
            return activeSemester.getCourses();
        } else {
            return new ArrayList<>();
        }
    }

    // Class
    public List<Class> getClasses() {
        return classDao.findAll();
    }


    public Class addNewClass(Class newClass) {
        Transaction trans = null;
        try {
            trans = beginTransaction();
            classDao.save(newClass);
            trans.commit();
        } finally {
            if (trans != null && trans.isActive()) {
                trans.rollback();
            }
        }

        return newClass;
    }

    public void deleteAnClass(Class clazz) {

        Transaction transaction = null;

        try {
            transaction = beginTransaction();
            classDao.deleteByObject(clazz);
            transaction.commit();
        } finally {
            if (transaction != null && transaction.isActive()) {
                transaction.rollback();
            }
        }

    }

    // Course Student

    public List<StudentCourseSemester> getListStudentCourse() {
        return studentCourseDao.findAll();
    }

    //
    public List<Subject> getSubjectList() {
        return AppContext.subjectDao.findAll();
    }


    public void updateClass(Class currentRow) {

        Transaction trans = null;

        try {
            trans = beginTransaction();
            classDao.update(currentRow);
            trans.commit();
        } finally {
            if (trans != null && trans.isActive()) {
                trans.rollback();
            }
        }

    }
}
