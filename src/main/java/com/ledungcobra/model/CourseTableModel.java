package com.ledungcobra.model;

import com.ledungcobra.entites.Course;
import lombok.val;

import java.util.List;

public class CourseTableModel extends AbsTableModel<Course> {

    public CourseTableModel(List<Course> courseList) {
        super(courseList);
        this.types = new Class[]{
                String.class,
                String.class,
                String.class,
                String.class,
                String.class,
                String.class,
                String.class,
                String.class
        };
        this.canEdit = new boolean[]{
                false,
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
    public String[] getColumns() {
        return new String[]{"Course ID", "Subject ", "Course Credit", "Theory teacher name",
                "Day to study in week", "Classroom", "Shift", "Number of slot"};
    }

    @Override
    public Object[][] getRecords(List<Course> courseList) {
        val records = new String[courseList.size()][getColumns().length];

        for (int i = 0; i < records.length; i++) {
            val course = courseList.get(i);
            if(course == null) continue;
            records[i][0] =course.getId();
            val subject = course.getSubject();
            records[i][1] = subject.getName();
            records[i][2] = String.valueOf(course.getCredit());
            records[i][3] = course.getTeacherName();
            records[i][4] = course.getDayToStudyInWeek();
            records[i][5] = course.getClassroomName();
            records[i][6] = course.getShiftToStudyInDay();
            records[i][7] = String.valueOf(course.getNumberOfSlot());
        }

        return records;
    }
}
