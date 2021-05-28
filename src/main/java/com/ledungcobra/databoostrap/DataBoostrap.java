package com.ledungcobra.databoostrap;

import com.ledungcobra.applicationcontext.AppContext;
import com.ledungcobra.entites.*;
import lombok.val;

import java.util.Date;

import static com.ledungcobra.utils.HibernateUtils.sql;

public class DataBoostrap {
    public void run() {

        try {

            val studentInfo = new StudentInfo("Boy", new Date(), "281160359", "Lê Quốc Dũng");

            val educationType = new EducationType("CQ");

            AppContext.studentService.saveStudentInfo(studentInfo);
            AppContext.educationTypeDao.save(educationType);

            val account = new StudentAccount("18120331", "18120331", studentInfo, educationType, null);
            AppContext.studentService.save(account);


        } catch (Exception e) {
            System.out.println("OK");
        }

        try {
            val teachingService = AppContext.teachingManagerService;
            val teachingManager = new TeachingManager("18120331", "Nguyễn Văn A", "18120331");
            teachingService.save(teachingManager);
        } catch (Exception e) {
            System.out.println("OK");

        }


    }
}
