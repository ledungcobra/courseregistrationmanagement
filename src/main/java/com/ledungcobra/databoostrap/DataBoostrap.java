package com.ledungcobra.databoostrap;

import com.ledungcobra.applicationcontext.AppContext;
import com.ledungcobra.entites.EducationType;
import com.ledungcobra.entites.StudentAccount;
import com.ledungcobra.entites.StudentInfo;
import com.ledungcobra.entites.TeachingManager;
import lombok.val;

import java.util.Date;

public class DataBoostrap {
    public  void run(){

        try{
            val studentInfo = new StudentInfo("BOY",new Date(),"281160359");
            val educationType =  new EducationType("CQ");

            AppContext.studentService.saveStudentInfo(studentInfo);
            AppContext.educationTypeDao.save(educationType);

            val account = new StudentAccount("18120331","Lê Quốc Dũng",studentInfo,educationType);
            AppContext.studentService.save(account);


        }catch (Exception e){
            System.out.println("OK");
        }

        try{
            val teachingService = AppContext.teachingManagerService;
            val teachingManager = new TeachingManager("Nguyễn Văn A","18120331");
            teachingService.save(teachingManager);
        }catch (Exception e){
            System.out.println("OK");

        }


    }
}
