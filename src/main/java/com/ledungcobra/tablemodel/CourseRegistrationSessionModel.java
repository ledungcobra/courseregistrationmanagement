package com.ledungcobra.tablemodel;

import com.ledungcobra.entites.CourseRegistrationSession;
import lombok.val;

import java.util.List;

public class CourseRegistrationSessionModel extends AbstractModel<CourseRegistrationSession> {

    public CourseRegistrationSessionModel(List<CourseRegistrationSession> t) {
        super(t);
    }

    @Override
    public Object[][] getRecords(List<CourseRegistrationSession> courseRegistrationSessionList) {

        val records = new String[courseRegistrationSessionList.size()][getColumns().length];

        for (int i = 0; i < courseRegistrationSessionList.size(); i++) {

            val courseRegistrationSession = courseRegistrationSessionList.get(i);
            if (courseRegistrationSession == null) continue;

            records[i][0] = String.valueOf(courseRegistrationSession.getId());
            records[i][1] = courseRegistrationSession.getStartDate().toString();
            records[i][2] = courseRegistrationSession.getEndDate().toString();
            records[i][3] = courseRegistrationSession.getSemester().getId().getSemesterName() +
                    courseRegistrationSession.getSemester().getId().getYear();
        }

        return records;
    }

    @Override
    public String[] getColumns() {
        return new String[]{"ID", "Start Date", "End Date", "Semester"};
    }
}
