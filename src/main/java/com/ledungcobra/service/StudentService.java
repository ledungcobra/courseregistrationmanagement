package com.ledungcobra.service;

import com.ledungcobra.dao.StudentDao;
import com.ledungcobra.entites.StudentAccount;
import com.ledungcobra.entites.StudentInfo;

public class StudentService extends UserService<StudentAccount> {

    public StudentInfo saveStudentInfo(StudentInfo s){
        if(userDao instanceof StudentDao){
            return ((StudentDao) userDao).saveStudentInfo(s);
        }else{
            throw new IllegalStateException();
        }
    }
}
