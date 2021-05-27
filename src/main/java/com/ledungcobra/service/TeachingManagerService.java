package com.ledungcobra.service;

import com.ledungcobra.applicationcontext.AppContext;
import com.ledungcobra.dao.*;
import com.ledungcobra.entites.Class;
import com.ledungcobra.entites.*;
import lombok.NonNull;
import lombok.val;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@FunctionalInterface
interface DoWork {
    void run();
}

public class TeachingManagerService extends UserService<TeachingManager> {

    private CourseDao courseDao;
    private TeachingManagerDao teachingManagerDao;
    private SemesterDao semesterDao;
    private StudentDao studentDao;
    private CourseRegistrationSessionDao courseRegistrationSessionDao;
    private ClassDao classDao;
    private StudentCourseDao studentCourseDao;
    private SubjectDao subjectDao;

    public TeachingManagerService() {

        courseDao = AppContext.courseDao;
        teachingManagerDao = AppContext.teachingManagerDao;
        semesterDao = AppContext.semesterDao;
        studentDao = AppContext.studentDao;
        courseRegistrationSessionDao = AppContext.courseRegistrationDao;
        classDao = AppContext.classDao;
        studentCourseDao = AppContext.studentCourseDao;
        subjectDao = AppContext.subjectDao;
    }

    // Course Manager
    public List<Course> getCourseList() {
        return courseDao.findAll();
    }

    public Course addNewCourse(Course course) {
        doTransaction(() -> courseDao.save(course));
        return course;
    }

    public Course updateCourse(Course course) {

        doTransaction(() -> courseDao.update(course));
        return course;
    }

    public void deleteCourse(Course course) {
        doTransaction(() -> courseDao.deleteByObject(course));
    }

    // Teaching Manager
    public List<TeachingManager> getTeachingManagerList() {
        return teachingManagerDao.findAll();
    }

    public TeachingManager addNewTeachingManager(TeachingManager teachingManager) {
        doTransaction(() -> teachingManagerDao.save(teachingManager));
        return teachingManager;
    }

    public TeachingManager updateTeachingManager(TeachingManager teachingManager) {
        doTransaction(() -> teachingManagerDao.update(teachingManager));
        return teachingManager;
    }

    public TeachingManager updateTeachingManagerPassword(@NonNull String id) {
        val teachingManager = teachingManagerDao.findById(id);
        teachingManager.setPassword(teachingManager.getId());
        doTransaction(() -> teachingManagerDao.update(teachingManager));
        return teachingManager;
    }

    public void deleteTeachingManagers(String... ids) {
        doTransaction(() -> {
            for (String id : ids) {
                teachingManagerDao.deleteById(id);
            }
        });
    }

    // Semester
    public List<Semester> getSemesterList() {
        return semesterDao.findAll();
    }

    public Semester addNewSemester(Semester semester) {
        doTransaction(() -> semesterDao.save(semester));
        return semester;
    }

    public void deleteSemester(Semester semester) {
        doTransaction(() -> semesterDao.deleteByObject(semester));
    }

    public void setSemesterAsActive(@NonNull Semester semester) {

        semester.setActive(true);
        doTransaction(() -> semesterDao.setSemesterActive(semester));
    }

    // Student management
    public List<StudentAccount> getListStudentInClass(@NonNull Class classEntity) {
        return classEntity.getStudents();
    }

    public List<StudentAccount> searchStudent(@NonNull Class classEntity, @NonNull String keyword) {
        return studentDao.searchStudent(classEntity, keyword);
    }

    public void addStudentToClass(@NonNull StudentAccount student, @NonNull Class classEntity) {
        doTransaction(() -> studentDao.addStudentToClass(student, classEntity));
    }

    public StudentAccount updateStudentInfo(@NonNull StudentAccount student) {

        doTransaction(() -> studentDao.update(student));
        return student;
    }

    public StudentAccount resetStudentPassword(@NonNull StudentAccount student) {
        val transaction = beginTransaction();
        student.setPassword(student.getUserName());
        doTransaction(() -> studentDao.update(student));
        return student;
    }

    public List<CourseRegistrationSession> getCourseRegistrationSessionList() {
        return courseRegistrationSessionDao.findAll();
    }

    public CourseRegistrationSession addCourseRegistrationSession(@NonNull CourseRegistrationSession courseRegistrationSession) {
        val semester = semesterDao.getActiveSemester();
        courseRegistrationSession.setSemester(semester);
        doTransaction(() -> courseRegistrationSessionDao.save(courseRegistrationSession));
        return courseRegistrationSession;
    }

    // Course
    public List<Course> getCourseListInActiveSemester() {
        AppContext.session.clear();
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
        doTransaction(() -> classDao.save(newClass));
        return newClass;
    }

    public void deleteAnClass(Class clazz) {
        doTransaction(() -> classDao.deleteByObject(clazz));
    }

    // Course Student
    public List<StudentCourseSemester> getListStudentCourse() {
        return studentCourseDao.findAll();
    }

    public List<Subject> getSubjectList() {
        return AppContext.subjectDao.findAll();
    }


    public void updateClass(Class currentRow) {
        doTransaction(() -> classDao.update(currentRow));
    }

    public void deleteSubject(Subject subject) {
        doTransaction(() -> subjectDao.deleteByObject(subject));

    }

    public void addNewSubject(Subject subject) {
        doTransaction(() -> subjectDao.save(subject));
    }

    public void updateSubject(Subject semester) {
        doTransaction(() -> subjectDao.update(semester));
    }

    public List<Subject> searchSubject(String keyword) {
        return subjectDao.search(keyword);
    }

    public void updateSemester(Semester semester) {
        doTransaction(() -> semesterDao.update(semester));
    }

    public List<Semester> searchSemester(String text) {
        return semesterDao.searchSemester(text);
    }

    public void deleteTeachingManager(TeachingManager teachingManager) {
        doTransaction(() -> teachingManagerDao.deleteByObject(teachingManager));
    }

    public void resetTeachingManagerPassword(TeachingManager teachingManager) {
        teachingManager.setPassword(teachingManager.getId());
        doTransaction(() -> teachingManagerDao.update(teachingManager));
    }

    public List<TeachingManager> searchTeachingManager(String keyword) {
        return teachingManagerDao.search(keyword);
    }

    public Semester getActiveSemester() {
        return semesterDao.getActiveSemester();
    }

    public List<Course> searchCourse(String text) {
        return courseDao.search(text);
    }
}
