package com.ledungcobra.model;

import com.ledungcobra.entites.Semester;
import lombok.val;

import java.util.List;

public class SemesterTableModel extends AbsTableModel<Semester> {


    public SemesterTableModel(List<Semester> t) {
        super(t);
        this.types = new Class[]{
                String.class,
                String.class,
                String.class,
                String.class,
                String.class,
                Boolean.class
        };

        this.canEdit = new boolean[]{
                false,
                false,
                false,
                false,
                false,
                false
        };
    }

    @Override
    public Object[][] getRecords(List<Semester> semesters) {
        val records = new Object[semesters.size()][getColumns().length];
        for (int i = 0; i < semesters.size(); i++) {
            val semester = semesters.get(i);
            records[i][0] = semester.getId().toString();
            records[i][1] = semester.getId().getSemesterName();
            records[i][2] = semester.getStartDate().toString();
            records[i][3] = semester.getEndDate().toString();
            records[i][4] = semester.getId().getYear();
            records[i][5] = semester.getActive();

        }
        return records;
    }

    @Override
    public String[] getColumns() {
        return new String[]{
                "Semester ID",
                "Name",
                "Start Date",
                "End Date",
                "Year",
                "Active"
        };
    }
}
