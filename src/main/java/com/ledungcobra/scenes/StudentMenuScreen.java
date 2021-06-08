/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ledungcobra.scenes;

import com.ledungcobra.entites.User;
import com.ledungcobra.utils.Navigator;
import com.ledungcobra.utils.ScreenStackManager;

import java.awt.event.ActionEvent;

import static com.ledungcobra.scenes.LoginScreen.USER_KEY;


public class StudentMenuScreen extends Screen {

    // <editor-fold defaultstate="collapsed desc="Class fields">
    private javax.swing.JButton changePasswordBtn;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JButton listAllRegisteredCourses;
    private javax.swing.JButton logoutBtn;
    private javax.swing.JButton registerCoursesBtn;
    private javax.swing.JButton userInfoBtn;
    private javax.swing.JLabel usernameLbl;
    // </editor-fold>


    @Override
    public void onCreateView() {
        initComponents();

        if (this.data != null) {
            usernameLbl.setText(((User) data.get(USER_KEY)).getFullName());
        }
    }

    @Override
    public void addEventListener() {
        registerCoursesBtn.addActionListener(evt -> registerCoursesBtnActionPerformed(evt));
        listAllRegisteredCourses.addActionListener(evt -> listAllRegisteredCoursesActionPerformed(evt));
        logoutBtn.addActionListener(evt -> logout());
        changePasswordBtn.addActionListener(e -> changePasswordBtnPerformed(e));
        userInfoBtn.addActionListener(e -> userInfoBtnPerformed(e));
    }

    private void userInfoBtnPerformed(ActionEvent e) {
        new Navigator<UserInfoScreen>().navigate(this.data);
    }

    private void changePasswordBtnPerformed(ActionEvent e) {
        new Navigator<ChangePasswordScreen>().navigate(this.data);
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        registerCoursesBtn = new javax.swing.JButton();
        listAllRegisteredCourses = new javax.swing.JButton();
        usernameLbl = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        logoutBtn = new javax.swing.JButton();
        changePasswordBtn = new javax.swing.JButton();
        userInfoBtn = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setText("Menu");

        registerCoursesBtn.setText("Register courses");

        listAllRegisteredCourses.setText("List all registered courses");

        usernameLbl.setText("jLabel2");

        jLabel3.setFont(new java.awt.Font("Tahoma", 3, 14)); // NOI18N
        jLabel3.setText("Hello");

        logoutBtn.setText("Logout");

        changePasswordBtn.setText("Change password");

        userInfoBtn.setText("User Info");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(42, 42, 42)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addComponent(jLabel1)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(usernameLbl)
                                                .addGap(25, 25, 25)
                                                .addComponent(logoutBtn))
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                .addComponent(registerCoursesBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18)
                                                .addComponent(listAllRegisteredCourses)
                                                .addGap(18, 18, 18)
                                                .addComponent(changePasswordBtn, javax.swing.GroupLayout.DEFAULT_SIZE, 167, Short.MAX_VALUE)
                                                .addGap(18, 18, 18)
                                                .addComponent(userInfoBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(39, 39, 39))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(75, 75, 75)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel1)
                                        .addComponent(usernameLbl)
                                        .addComponent(jLabel3)
                                        .addComponent(logoutBtn))
                                .addGap(61, 61, 61)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(userInfoBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                .addComponent(registerCoursesBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(listAllRegisteredCourses, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(changePasswordBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addContainerGap(88, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>

    private void logout() {
        ScreenStackManager.getInstance().popTopScreen();
    }

    private void listAllRegisteredCoursesActionPerformed(java.awt.event.ActionEvent evt) {
        new Navigator<ListAllRegisteredCoursesScreen>().navigate(this.data);
    }

    private void registerCoursesBtnActionPerformed(java.awt.event.ActionEvent evt) {
        new Navigator<StudentRegisterCoursesScreen>().navigate(this.data);
    }

}
