package com.ledungcobra.models;

import com.ledungcobra.entites.Class;
import com.ledungcobra.entites.StudentAccount;
import lombok.val;

import java.util.List;

public class ClassTableModel extends AbsTableModel<Class>
{

    public ClassTableModel(List<Class> classes)
    {
        super(classes);

        this.types = new java.lang.Class[]{
                String.class,
                Long.class,
                Long.class
        };

        this.canEdit = new boolean[]{
                false,
                false, false
        };
    }

    @Override
    public Object[][] getRecords(List<Class> classes)
    {
        val records = new String[classes.size()][getColumns().length];

        for (int i = 0; i < classes.size(); i++)
        {

            if (classes.get(i) == null) continue;

            records[i][0] = classes.get(i).getClassName();
            long numberOfBoys = countBoys(classes.get(i).getStudents());
            records[i][1] = String.valueOf(numberOfBoys);
            records[i][2] = String.valueOf(countGirls(classes.get(i).getStudents()));
        }
        return records;

    }

    @Override
    public String[] getColumns()
    {
        return new String[]{"Class Name",
                "Number of boys", "Number of girls"};
    }

    private long countBoys(List<StudentAccount> studentAccounts)
    {
        if (studentAccounts == null) return 0;
        return studentAccounts.stream().filter(s -> "boy".equalsIgnoreCase(s.getStudentInfo().getGender())).count();
    }

    private long countGirls(List<StudentAccount> studentAccounts)
    {
        if (studentAccounts == null) return 0;
        return studentAccounts.stream().filter(s -> "girl".equalsIgnoreCase(s.getStudentInfo().getGender())).count();
    }

}
