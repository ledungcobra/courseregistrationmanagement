package com.ledungcobra.model;

import com.ledungcobra.applicationcontext.AppContext;
import com.ledungcobra.dao.CourseDao;
import com.ledungcobra.entites.Course;
import com.ledungcobra.entites.Semester;
import com.ledungcobra.entites.StudentAccount;
import com.ledungcobra.entites.StudentCourse;
import lombok.val;

import java.util.List;

public class StudentRegCourseTableModel extends AbsTableModel<StudentAccount> {
    private Course course;
    private Semester activeSemester;

    public StudentRegCourseTableModel(List<StudentAccount> t, Course course, Semester activeSemester) {
        super(t);
        this.activeSemester = activeSemester;

        this.course = course;
        this.types = new Class[]{
                String.class,
                String.class,
                String.class,
                String.class,
                String.class,
                String.class,
                String.class,
        };

        this.canEdit = new boolean[]{
                false,
                false,
                false,
                false,
                false,
                false,
                false
        };
    }

    @Override
    public Object[][] getRecords(List<StudentAccount> students) {
        val records = new Object[students.size()][getColumns().length];


        for (int i = 0; i < students.size(); i++) {
            val student = students.get(i);

            StudentCourse studentCourse = student.getListStudentCourses()
                    .stream().filter(s -> s.getStudentCourseSemesterId()
                    .getCourse().equals(this.course) &&
                            s.getStudentCourseSemesterId().getSemester().equals(activeSemester))
                    .findFirst().orElse(null);

            records[i][0] = student.getStudentCardId();
            records[i][1] = student.getStudentInfo().getFullName();
            records[i][2] = course.getSubject().getId();
            records[i][3] = course.getSubjectName();
            records[i][4] = course.getTeacherName();
            records[i][5] = course.getDayToStudyInWeek() + " - " + course.getShiftToStudyInDay();
            records[i][6] = studentCourse == null ? "" : studentCourse.getCreatedDate().toString();

        }
        return records;
    }

    @Override
    public String[] getColumns() {

        return new String[]{
                "Student ID",
                "Full name",
                "Subject Id",
                "Subject name",
                "Theory teacher name",
                "Time",
                "Register date"
        };

    }
}
