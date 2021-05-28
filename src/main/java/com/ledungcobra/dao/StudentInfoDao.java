package com.ledungcobra.dao;

import com.ledungcobra.entites.StudentAccount;
import com.ledungcobra.entites.StudentInfo;
import org.hibernate.Session;

import javax.persistence.NoResultException;

public class StudentInfoDao extends BaseDao<StudentInfo, Long> {

    public StudentInfoDao(Session session) {
        super(session);
    }

    public StudentInfo findStudentInfoByIdentityNo(String cardNo) {
        try {
            Object studentInfo = session.createQuery("from StudentInfo si where si.identityCardNumber=:cardNo")
                    .setParameter("cardNo", cardNo)
                    .getSingleResult();
            return (StudentInfo) studentInfo;
        } catch (Exception e) {
            return null;
        }

    }

}
