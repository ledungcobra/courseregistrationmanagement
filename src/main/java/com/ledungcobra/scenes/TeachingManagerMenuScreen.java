/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ledungcobra.scenes;

import com.ledungcobra.dto.Intent;
import com.ledungcobra.entites.User;
import com.ledungcobra.utils.ScreenStackManager;

import javax.swing.*;

import static com.ledungcobra.scenes.LoginScreen.USER_KEY;

public class TeachingManagerMenuScreen extends Screen {

    // Variables declaration - do not modify
    private javax.swing.JButton changePasswordBtn;
    private javax.swing.JButton classMngBtn;
    private javax.swing.JButton courseMngBtn;
    private javax.swing.JButton courseRegSessionMngBtn;
    private javax.swing.JButton studentRegCourse;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JButton logoutBtn;
    private javax.swing.JButton semesterMngBtn;
    private javax.swing.JButton studentMngBtn;
    private javax.swing.JButton subjectMngBtn;
    private javax.swing.JButton teachingMngBtn;
    private JButton userIfoMngBtn;
    // End of variables declaration

    @Override
    public void onCreateView() {
        initComponents();
        if (this.data != null) {
            this.userIfoMngBtn.setText(((User) this.data.get(USER_KEY)).getFullName());
        }
    }

    // <editor-fold defaultstate="collapsed>
    private void initComponents() {

        classMngBtn = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        teachingMngBtn = new javax.swing.JButton();
        courseMngBtn = new javax.swing.JButton();
        semesterMngBtn = new javax.swing.JButton();
        studentMngBtn = new javax.swing.JButton();
        courseRegSessionMngBtn = new javax.swing.JButton();
        changePasswordBtn = new javax.swing.JButton();
        subjectMngBtn = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        userIfoMngBtn = new JButton();
        logoutBtn = new javax.swing.JButton();

        jLabel1.setFont(new java.awt.Font("Tahoma", 3, 18));
        jLabel1.setText("Menu");

        studentRegCourse = new JButton("View Student Register A Course");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        classMngBtn.setText("Class management");


        teachingMngBtn.setText("Teaching Management");


        courseMngBtn.setText("Course Management");

        semesterMngBtn.setText("Semester Management");

        studentMngBtn.setText("Student Management");

        courseRegSessionMngBtn.setText("Course Registration Session Management");

        changePasswordBtn.setText("Change Password");

        subjectMngBtn.setText("Subject Management");


        jLabel2.setText("Hi");
        userIfoMngBtn.setText("UserName");
        logoutBtn.setText("Logout");


        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(61, 61, 61)
                                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(163, 163, 163))
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(53, 53, 53)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(teachingMngBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(classMngBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(studentMngBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGap(71, 71, 71)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                                .addComponent(subjectMngBtn, javax.swing.GroupLayout.DEFAULT_SIZE, 271, Short.MAX_VALUE)
                                                                .addComponent(courseMngBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                                        .addComponent(semesterMngBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 271, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGap(0, 0, Short.MAX_VALUE)))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(0, 0, Short.MAX_VALUE)
                                                .addComponent(jLabel2)
                                                .addGap(31, 31, 31)
                                                .addComponent(userIfoMngBtn)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(logoutBtn)
                                                .addGap(55, 55, 55))
                                        .addGroup(layout.createSequentialGroup()
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 76, Short.MAX_VALUE)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                        .addComponent(courseRegSessionMngBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 271, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(changePasswordBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 271, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(studentRegCourse, javax.swing.GroupLayout.PREFERRED_SIZE, 271, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGap(44, 44, 44))))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(55, 55, 55)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(userIfoMngBtn)
                                        .addComponent(jLabel1)
                                        .addComponent(jLabel2)
                                        .addComponent(logoutBtn))
                                .addGap(57, 57, 57)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(teachingMngBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(courseRegSessionMngBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(subjectMngBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(51, 51, 51)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(studentRegCourse, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                .addComponent(classMngBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(semesterMngBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(61, 61, 61)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(studentMngBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(courseMngBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(changePasswordBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addContainerGap(105, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>

    private void logout() {
        ScreenStackManager.getInstance().popTopScreen();
    }

    @Override
    public void addEventListener() {
        classMngBtn.addActionListener(evt -> {
            new Intent<ClassManagementScreen>().navigate();
        });
        teachingMngBtn.addActionListener(e -> {
            new Intent<TeachingManagerManagementScreen>().navigate();
        });
        courseMngBtn.addActionListener(e -> new Intent<CourseManagementScreen>().navigate());
        semesterMngBtn.addActionListener(e -> new Intent<SemesterManagementScreen>().navigate());
        studentMngBtn.addActionListener(e -> new Intent<StudentManagementScreen>().navigate());
        userIfoMngBtn.addActionListener(e -> new Intent<UserInfoScreen>().navigate(this.data));
        courseRegSessionMngBtn.addActionListener(e -> new Intent<CourseRegSessionManagementScreen>().navigate());
        changePasswordBtn.addActionListener(e -> new Intent<ChangePasswordScreen>().navigate(this.data));
        subjectMngBtn.addActionListener(e -> new Intent<SubjectManagementScreen>().navigate(this.data));
        logoutBtn.addActionListener(e -> logout());
        studentRegCourse.addActionListener((e)->new Intent<StudentRegisteredACourse>().navigate());
    }

}
