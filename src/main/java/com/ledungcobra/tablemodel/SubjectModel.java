package com.ledungcobra.tablemodel;

import com.ledungcobra.entites.Subject;
import lombok.val;

import java.util.List;

public class SubjectModel extends AbstractModel<Subject> {
    public SubjectModel(List<Subject> t) {
        super(t);
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
