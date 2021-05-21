package com.ledungcobra.tablemodel;

import com.ledungcobra.entites.TeachingManager;
import lombok.val;

import java.util.List;

public class TeachingManagerModel extends AbstractModel<TeachingManager> {
    public TeachingManagerModel(List<TeachingManager> t) {
        super(t);
    }

    @Override
    public Object[][] getRecords(List<TeachingManager> l) {
        val records = new Object[l.size()][getColumns().length];

        for (int i = 0; i < l.size(); i++) {

            val teachingManager = l.get(i);
            records[i][0] = teachingManager.getId();
            records[i][1] = teachingManager.getFullName();
            records[i][2] = teachingManager.getPassword();
        }

        return records;
    }

    @Override
    public String[] getColumns() {
        return new String[]{
                "Teaching Manager ID",
                "Full name",
                "Password"
        };
    }
}
