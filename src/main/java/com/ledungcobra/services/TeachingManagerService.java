package com.ledungcobra.services;

import com.ledungcobra.applicationcontext.AppContext;
import com.ledungcobra.daos.*;
import com.ledungcobra.entites.Class;
import com.ledungcobra.entites.*;
import lombok.NonNull;
import lombok.val;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@FunctionalInterface
interface DoWork
{
    void run() throws Exception;
}

public class TeachingManagerService extends UserService<TeachingManager>
{

    private CourseDao courseDao;
    private TeachingManagerDao teachingManagerDao;
    private SemesterDao semesterDao;
    private StudentDao studentDao;
    private CourseRegistrationSessionDao courseRegistrationSessionDao;
    private ClassDao classDao;
    private StudentCourseDao studentCourseDao;
    private SubjectDao subjectDao;
    private CourseInfoDao courseInfoDao;


    public TeachingManagerService()
    {

        courseDao = AppContext.courseDao;
        teachingManagerDao = AppContext.teachingManagerDao;
        semesterDao = AppContext.semesterDao;
        studentDao = AppContext.studentAccountDao;
        courseRegistrationSessionDao = AppContext.courseRegistrationDao;
        classDao = AppContext.classDao;
        studentCourseDao = AppContext.studentCourseDao;
        subjectDao = AppContext.subjectDao;
        courseInfoDao = AppContext.courseInfoDao;
    }

    // Course Manager
    public List<Course> getCourseList()
    {
        return courseDao.findAll();
    }

    public Course addNewCourse(Course course) throws Exception
    {
        doTransaction(() -> courseDao.save(course));
        return course;
    }

    public Course updateCourse(Course course) throws Exception
    {

        doTransaction(() -> courseDao.update(course));
        return course;
    }

    public void deleteCourse(Course course) throws Exception
    {
        doTransaction(() -> courseDao.deleteByObject(course));
    }

    // Teaching Manager
    public List<TeachingManager> getTeachingManagerList()
    {
        return teachingManagerDao.findAll();
    }

    public TeachingManager addNewTeachingManager(TeachingManager teachingManager) throws Exception
    {
        doTransaction(() -> teachingManagerDao.save(teachingManager));
        return teachingManager;
    }

    public TeachingManager updateTeachingManager(TeachingManager teachingManager) throws Exception
    {
        doTransaction(() -> teachingManagerDao.update(teachingManager));
        return teachingManager;
    }

    public TeachingManager updateTeachingManagerPassword(@NonNull String id) throws Exception
    {
        val teachingManager = teachingManagerDao.findById(id);
        teachingManager.setPassword(teachingManager.getId());
        doTransaction(() -> teachingManagerDao.update(teachingManager));
        return teachingManager;
    }

    public void deleteTeachingManagers(String... ids) throws Exception
    {
        doTransaction(() -> {
            for (String id : ids)
            {
                teachingManagerDao.deleteById(id);
            }
        });
    }

    // Semester
    public List<Semester> getSemesterList()
    {
        return semesterDao.findAll();
    }

    public Semester addNewSemester(Semester semester) throws Exception
    {
        doTransaction(() -> semesterDao.save(semester));
        return semester;
    }

    public void deleteSemester(Semester semester) throws Exception
    {
        doTransaction(() -> semesterDao.deleteByObject(semester));
    }

    public void setSemesterAsActive(@NonNull Semester semester) throws Exception
    {

        semester.setActive(true);
        doTransaction(() -> semesterDao.setSemesterActive(semester));
    }

    // Student management
    public List<StudentAccount> getListStudentInClass(@NonNull Class classEntity)
    {
        if (AppContext.session != null)
        {
            AppContext.session.refresh(classEntity);
        }
        return classEntity.getStudents();
    }

    public List<StudentAccount> searchStudent(@NonNull Class classEntity, @NonNull String keyword)
    {
        return studentDao.searchStudent(classEntity, keyword);
    }

    public void addStudentToClass(@NonNull StudentAccount student, @NonNull Class classEntity) throws Exception
    {
        doTransaction(() -> studentDao.addStudentToClass(student, classEntity));
    }

    public StudentAccount updateStudentAccount(@NonNull StudentAccount student) throws Exception
    {
        doTransaction(() -> studentDao.update(student));
        return student;
    }

    public StudentAccount resetStudentPassword(@NonNull StudentAccount student) throws Exception
    {
        student.setPassword(student.getUserId());
        doTransaction(() -> studentDao.update(student));
        return student;
    }

    public List<CourseRegistrationSession> getCourseRegistrationSessionList()
    {
        return courseRegistrationSessionDao.findAll();
    }

    public CourseRegistrationSession addCourseRegistrationSession(@NonNull CourseRegistrationSession courseRegistrationSession) throws Exception
    {
        val semester = semesterDao.getActiveSemester();
        if (semester == null)
        {
            throw new Exception("Active semester haven't set");
        }
        courseRegistrationSession.setSemester(semester);
        doTransaction(() -> courseRegistrationSessionDao.save(courseRegistrationSession));
        return courseRegistrationSession;
    }

    // Course
    public List<Course> getCourseListInActiveSemester()
    {
        AppContext.session.clear();
        val activeSemester = semesterDao.getActiveSemester();
        if (Objects.nonNull(activeSemester))
        {
            return activeSemester.getCourseInfos()
                    .stream().map(CourseInfo::getCourses)
                    .flatMap(Collection::stream)
                    .collect(Collectors.toList());
        } else
        {
            return new ArrayList<>();
        }
    }

    // Class
    public List<Class> getClasses()
    {
        return classDao.findAll();
    }


    public Class addNewClass(Class newClass) throws Exception
    {
        doTransaction(() -> classDao.save(newClass));
        return newClass;
    }

    public void deleteAnClass(Class clazz) throws Exception
    {
        doTransaction(() -> classDao.deleteByObject(clazz));
    }

    // Course Student
    public List<StudentCourse> getListStudentCourse()
    {
        return studentCourseDao.findAll();
    }

    public List<Subject> getSubjectList()
    {
        return AppContext.subjectDao.findAll();
    }


    public void updateClass(Class currentRow) throws Exception
    {
        doTransaction(() -> classDao.update(currentRow));
    }

    public void deleteSubject(Subject subject) throws Exception
    {
        doTransaction(() -> subjectDao.deleteByObject(subject));

    }

    public void addNewSubject(Subject subject) throws Exception
    {
        doTransaction(() -> subjectDao.save(subject));
    }

    public void updateSubject(Subject semester) throws Exception
    {
        doTransaction(() -> subjectDao.update(semester));
    }

    public List<Subject> searchSubject(String keyword)
    {
        return subjectDao.search(keyword);
    }

    public void updateSemester(Semester semester) throws Exception
    {
        doTransaction(() -> semesterDao.update(semester));
    }

    public List<Semester> searchSemester(String text)
    {
        return semesterDao.searchSemester(text);
    }

    public void deleteTeachingManager(TeachingManager teachingManager) throws Exception
    {
        doTransaction(() -> teachingManagerDao.deleteByObject(teachingManager));
    }

    public void resetTeachingManagerPassword(TeachingManager teachingManager) throws Exception
    {
        teachingManager.setPassword(teachingManager.getId());
        doTransaction(() -> teachingManagerDao.update(teachingManager));
    }

    public List<TeachingManager> searchTeachingManager(String keyword)
    {
        return teachingManagerDao.search(keyword);
    }

    public Semester getActiveSemester()
    {
        return semesterDao.getActiveSemester();
    }

    public List<Course> searchCourse(String text)
    {
        return courseDao.search(text);
    }

    public void deleteStudent(StudentAccount studentAccount) throws Exception
    {
        doTransaction(() -> studentDao.deleteByObject(studentAccount));
    }

    public StudentInfo findStudentInfoByIdentityNo(String identityCardNumber)
    {
        return AppContext.studentInfoDao.findStudentInfoByIdentityNo(identityCardNumber);
    }

    public void addStudentInfo(StudentInfo studentInfo) throws Exception
    {
        doTransaction(() -> AppContext.studentInfoDao.save(studentInfo));
    }

    public void updateStudent(StudentAccount student) throws Exception
    {
        doTransaction(() -> {
            AppContext.studentInfoDao.saveOrUpdate(student.getStudentInfo());
            AppContext.studentAccountDao.update(student);
        });
    }

    public List<EducationType> getEducationTypes()
    {
        return AppContext.educationTypeDao.findAll();
    }

    public void updateStudentInfo(StudentInfo studentInfo) throws Exception
    {
        doTransaction(() -> AppContext.studentInfoDao.update(studentInfo));
    }


    public List<StudentAccount> searchStudentRegACourse(String keyword, CourseInfo courseInfo, Semester activeSemester)
    {
        return studentDao.searchStudentRegACourse(keyword, courseInfo, activeSemester);
    }

    public void addNewCourseInfo(CourseInfo courseInfo) throws Exception
    {
        doTransaction(() -> courseInfoDao.save(courseInfo));
    }

    public List<CourseInfo> getCourseInfos()
    {
        Semester semester = this.getActiveSemester();
        AppContext.session.refresh(semester);
        return semester.getCourseInfos();
    }

    public void deleteCourseInfo(CourseInfo selectedCourseInfo)
    {
        doTransaction(() -> courseInfoDao.deleteByObject(selectedCourseInfo));
    }

    public List<StudentCourse> getStudentCourseListRegisteredACourseInfo(CourseInfo courseInfo, Semester activeSemester)
    {
        return studentCourseDao.getListStudentRegisterACourse(courseInfo, activeSemester);
    }

    public List<Class> searchClass(String keyword)
    {
        return classDao.search(keyword);
    }

    @Override
    public void updateInfo(Object userInfo)
    {
        doTransaction(()-> teachingManagerDao.update((TeachingManager) userInfo));
    }
}
