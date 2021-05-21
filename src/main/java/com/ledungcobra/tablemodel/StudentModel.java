package com.ledungcobra.tablemodel;

import com.ledungcobra.entites.StudentAccount;
import lombok.val;

import java.util.List;

public class StudentModel extends AbstractModel<StudentAccount> {

    public StudentModel(List<StudentAccount> t) {
        super(t);
    }

    @Override
    public Object[][] getRecords(List<StudentAccount> l) {
        val records = new Object[l.size()][getColumns().length];

        for (int i = 0; i < l.size(); i++) {
            val studentAccount = l.get(i);
            records[i][0] = studentAccount.getStudentCardId();
            records[i][1] = studentAccount.getFullName();
            records[i][2] = studentAccount.getStudiedClass().getClassName();
            records[i][3] = studentAccount.getPassword();
            records[i][4] = studentAccount.getStudentInfo().getGender();
            records[i][5] = studentAccount.getStudentInfo().getBirthdate();
            records[i][6] = studentAccount.getStudyingCourses();
        }

        return records;
    }

    @Override
    public String[] getColumns() {
        return new String[]{
                "Student ID",
                "Full name",
                "Class name",
                "Password",
                "Gender",
                "Date of birth",
                "Courses"
        };
    }

}
