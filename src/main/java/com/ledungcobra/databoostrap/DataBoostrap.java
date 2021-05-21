package com.ledungcobra.databoostrap;

import com.ledungcobra.applicationcontext.AppContext;
import com.ledungcobra.entites.EducationType;
import com.ledungcobra.entites.StudentAccount;
import com.ledungcobra.entites.StudentInfo;
import com.ledungcobra.entites.TeachingManager;
import com.ledungcobra.entites.embedable.StudentAccountId;
import lombok.val;

import java.util.Date;

public class DataBoostrap {
    public  void run(){

        try{
            val studentInfo = new StudentInfo("BOY",new Date(),"281160359");
            val educationType =  new EducationType("CQ");

            AppContext.studentService.saveStudentInfo(studentInfo);
            AppContext.educationTypeDao.save(educationType);

            val account = new StudentAccount(new StudentAccountId(studentInfo,educationType),"18120331","Lê Quốc Dũng");
            AppContext.studentService.save(account);

            val teachingService = AppContext.teachingManagerService;
            val teachingManager = new TeachingManager("Nguyễn Văn A","123");
            teachingService.save(teachingManager);
        }catch (Exception e){
            System.out.println("OK");
        }


    }
}
