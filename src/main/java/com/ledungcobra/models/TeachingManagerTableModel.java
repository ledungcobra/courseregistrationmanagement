package com.ledungcobra.models;

import com.ledungcobra.entites.TeachingManager;
import lombok.val;

import java.util.List;

public class TeachingManagerTableModel extends AbsTableModel<TeachingManager>
{
    public TeachingManagerTableModel(List<TeachingManager> t)
    {
        super(t);
        this.types = new Class[]{
                String.class,
                String.class,
                String.class,
        };

        this.canEdit = new boolean[]{
                false,
                false,
                false
        };
    }

    @Override
    public Object[][] getRecords(List<TeachingManager> l)
    {
        val records = new Object[l.size()][getColumns().length];

        for (int i = 0; i < l.size(); i++)
        {

            val teachingManager = l.get(i);
            records[i][0] = teachingManager.getId();
            records[i][1] = teachingManager.getFullName();
            records[i][2] = teachingManager.getPassword();
        }

        return records;
    }

    @Override
    public String[] getColumns()
    {
        return new String[]{
                "Teaching Manager ID",
                "Full name",
                "Password"
        };
    }
}
