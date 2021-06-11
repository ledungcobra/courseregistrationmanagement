package com.ledungcobra.models;

import com.ledungcobra.entites.StudentCourse;
import lombok.val;

import java.util.List;

public class StudentRegCourseTableModel extends AbsTableModel<StudentCourse>
{


    public StudentRegCourseTableModel(List<StudentCourse> t)
    {
        super(t);
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
    public Object[][] getRecords(List<StudentCourse> students)
    {

        val records = new Object[students.size()][getColumns().length];


        for (int i = 0; i < students.size(); i++)
        {

            val studentCourse = students.get(i);
            val studentAccount = studentCourse.getStudentCourseId().getStudentAccount();
            val course = studentCourse.getStudentCourseId().getCourse();

            records[i][0] = studentAccount.getStudentCardId();
            records[i][1] = studentAccount.getStudentInfo().getFullName();
            records[i][2] = course.getSubject().getId();
            records[i][3] = course.getSubjectName();
            records[i][4] = course.getTeacherName();
            records[i][5] = course.getDayToStudyInWeek() + " - " + course.getShiftToStudyInDay();
            records[i][6] = studentCourse == null ? "" : studentCourse.getCreatedDate().toString();

        }
        return records;
    }

    @Override
    public String[] getColumns()
    {

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
