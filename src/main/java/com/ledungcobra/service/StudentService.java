package com.ledungcobra.service;

import com.ledungcobra.applicationcontext.AppContext;
import com.ledungcobra.dao.*;
import com.ledungcobra.entites.*;
import com.ledungcobra.utils.DatetimeUtil;
import lombok.val;

import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

public class StudentService extends UserService<StudentAccount> {


    private CourseDao courseDao = AppContext.courseDao;
    private CourseRegistrationSessionDao courseRegistrationSessionDao = AppContext.courseRegistrationDao;
    private SemesterDao semesterDao = AppContext.semesterDao;
    private StudentCourseDao studentCourseDao = AppContext.studentCourseDao;

    public StudentInfo saveStudentInfo(StudentInfo s) {
        if (userDao instanceof StudentDao) {
            return AppContext.studentInfoDao.save(s);
        } else {
            throw new IllegalStateException();
        }
    }

    public List<Course> getCoursesOpenedInActiveSemester() {
        List<Course> courses = courseDao.getCourseOpenedInActiveSemester(getActiveSemester());
        return courses;
    }

    public Semester getActiveSemester() {
        return semesterDao.getActiveSemester();
    }

    public CourseRegistrationSession getValidCourseRegistrationSession() throws Exception {

        val currentSession = courseRegistrationSessionDao.getSessionInclude(DatetimeUtil.getCurrentDate());

        if (currentSession == null) {
            throw new Exception("Valid session not found");
        }

        return currentSession;
    }

    public void registerCourses(HashSet<Course> tempCourseList, StudentAccount studentAccount, CourseRegistrationSession courseSession, Semester activeSemester) {
        doTransaction(() -> {
            tempCourseList.forEach(course -> {
                studentCourseDao.save(new StudentCourse(courseSession, course, studentAccount, activeSemester));
            });
        });
    }

    public List<Course> getRegisteredCourses(Semester activeSemester, StudentAccount studentAccount) {
        AppContext.session.refresh(studentAccount);
        return studentAccount.getCourses().stream()
                .filter(c -> c.getCourseInfo().getSemester().equals(activeSemester))
                .collect(Collectors.toList());
    }

    public void removeCourses(HashSet<Course> removedCoursesSet, StudentAccount studentAccount, Semester semester) {
        doTransaction(() -> {
                this.studentCourseDao.deleteStudentCourse(removedCoursesSet, studentAccount, semester);
        });
    }
}
