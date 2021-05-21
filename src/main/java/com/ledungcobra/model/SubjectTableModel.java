package com.ledungcobra.model;

import com.ledungcobra.entites.Subject;
import lombok.val;

import java.util.List;

public class SubjectTableModel extends AbsTableModel<Subject> {
    public SubjectTableModel(List<Subject> t) {
        super(t);

        this.types = new Class[]{
            String.class,
            String.class,
            String.class
        };
        this.canEdit = new boolean[]{
                false,
                false,
                false
        };

    }

    @Override
    public Object[][] getRecords(List<Subject> l) {
        val records = new Object[l.size()][getColumns().length];

        for (int i = 0; i < l.size(); i++) {
            val subject = l.get(i);
            records[i][0] = subject.getId();
            records[i][1] = subject.getName();
            records[i][2] = subject.getCredit();
        }
        return records;
    }

    @Override
    public String[] getColumns() {
        return new String[]{
                "Subject ID",
                "Subject name",
                "Credit"
        };
    }
}
