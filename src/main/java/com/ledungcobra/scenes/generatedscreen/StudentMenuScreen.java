/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ledungcobra.scenes.generatedscreen;

import com.ledungcobra.entites.User;
import com.ledungcobra.scenes.Screen;
import com.ledungcobra.scenes.ScreenStackManager;

import javax.swing.*;

import static com.ledungcobra.scenes.LoginScreen.USER_KEY;


public class StudentMenuScreen extends Screen {


    private JButton logoutBtn;

    @Override
    public void onCreateView() {
        initComponents();

        if (this.data != null) {
            usernameLbl.setText(((User) data.get(USER_KEY)).getFullName());
        }
    }


    @SuppressWarnings("unchecked")

    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        registerCoursesBtn = new javax.swing.JButton();
        listAllRegisteredCourses = new javax.swing.JButton();
        usernameLbl = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        logoutBtn = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setText("Menu");

        registerCoursesBtn.setText("Register courses");
        registerCoursesBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                registerCoursesBtnActionPerformed(evt);
            }
        });

        listAllRegisteredCourses.setText("List all registered courses");
        listAllRegisteredCourses.addActionListener(evt -> listAllRegisteredCoursesActionPerformed(evt));
        logoutBtn.addActionListener(evt->logout());

        usernameLbl.setText("jLabel2");

        jLabel3.setFont(new java.awt.Font("Tahoma", 3, 14)); // NOI18N
        jLabel3.setText("Hello");

        logoutBtn.setText("Logout");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(75, 75, 75)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addComponent(jLabel1)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18)
                                                .addComponent(usernameLbl)
                                                .addGap(25, 25, 25)
                                                .addComponent(logoutBtn))
                                        .addGroup(layout.createSequentialGroup()
                                                .addComponent(registerCoursesBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 316, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 119, Short.MAX_VALUE)
                                                .addComponent(listAllRegisteredCourses, javax.swing.GroupLayout.PREFERRED_SIZE, 297, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(78, 78, 78))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(96, 96, 96)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel1)
                                        .addComponent(usernameLbl)
                                        .addComponent(jLabel3)
                                        .addComponent(logoutBtn))
                                .addGap(40, 40, 40)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(registerCoursesBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 296, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(listAllRegisteredCourses, javax.swing.GroupLayout.PREFERRED_SIZE, 296, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addContainerGap(122, Short.MAX_VALUE))
        );

        pack();
    }

    private void logout() {
        ScreenStackManager.getInstance().popTopScreen();
    }

    private void listAllRegisteredCoursesActionPerformed(java.awt.event.ActionEvent evt) {

    }

    private void registerCoursesBtnActionPerformed(java.awt.event.ActionEvent evt) {

    }


    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JButton listAllRegisteredCourses;
    private javax.swing.JButton registerCoursesBtn;
    private javax.swing.JLabel usernameLbl;

}
