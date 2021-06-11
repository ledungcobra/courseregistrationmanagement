/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ledungcobra.scenes;

import com.ledungcobra.anotations.BackButton;
import com.ledungcobra.applicationcontext.AppContext;
import com.ledungcobra.entites.StudentAccount;
import com.ledungcobra.entites.User;
import com.ledungcobra.services.UserService;
import lombok.val;

import javax.swing.*;

import static com.ledungcobra.scenes.LoginScreen.USER_KEY;
import static com.ledungcobra.utils.Constants.HIDE;
import static com.ledungcobra.utils.Constants.SHOW;

/**
 * @author ledun
 */
public class ChangePasswordScreen extends Screen
{

    // Variables declaration - do not modify
    private javax.swing.JButton backBtn;
    private javax.swing.JButton btnProcess;
    private javax.swing.JButton cancelBtn;
    private javax.swing.JPasswordField confirmPasswordTextField;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPasswordField newPasswordTextField;
    private javax.swing.JPasswordField oldPasswordTextField;
    private javax.swing.JButton showConfirmPasswordBtn;
    private javax.swing.JButton showNewPasswordBtn;
    private javax.swing.JButton showOldPasswordBtn;
    // End of variables declaration

    @Override
    public void onCreateView()
    {
        if (this.data == null) throw new IllegalStateException();
        initComponents();
    }

    // </editor-fold>
    @Override
    public void addEventListener()
    {

        showConfirmPasswordBtn.addActionListener(e -> toggleConfirmPassword());

        showNewPasswordBtn.addActionListener(e -> toggleNewPassword());

        showOldPasswordBtn.addActionListener(e -> toggleShowOldPassword());

        btnProcess.addActionListener(e -> processChangePassword());
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        confirmPasswordTextField = new javax.swing.JPasswordField();
        jLabel3 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        newPasswordTextField = new javax.swing.JPasswordField();
        jLabel1 = new javax.swing.JLabel();
        oldPasswordTextField = new javax.swing.JPasswordField();
        showOldPasswordBtn = new javax.swing.JButton();
        showNewPasswordBtn = new javax.swing.JButton();
        showConfirmPasswordBtn = new javax.swing.JButton();
        btnProcess = new javax.swing.JButton();
        cancelBtn = new javax.swing.JButton();
        backBtn = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(1042, 545));

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createTitledBorder("Change password"), "Change password", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 3, 14))); // NOI18N
        jPanel1.setForeground(new java.awt.Color(255, 255, 0));

        jLabel3.setText("Confirm password");

        jLabel2.setText("New password");

        jLabel1.setText("Old password");

        showOldPasswordBtn.setText("Show");

        showNewPasswordBtn.setText("Show");

        showConfirmPasswordBtn.setText("Show");

        btnProcess.setBackground(new java.awt.Color(0, 255, 255));
        btnProcess.setText("Process");

        cancelBtn.setText("Cancel");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                                .addGap(18, 18, 18)
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(jLabel3)
                                                        .addComponent(jLabel2)
                                                        .addComponent(jLabel1))
                                                .addGap(18, 18, 18)
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                        .addComponent(confirmPasswordTextField, javax.swing.GroupLayout.DEFAULT_SIZE, 546, Short.MAX_VALUE)
                                                        .addComponent(newPasswordTextField)
                                                        .addComponent(oldPasswordTextField))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 33, Short.MAX_VALUE)
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(showOldPasswordBtn)
                                                        .addComponent(showNewPasswordBtn)
                                                        .addComponent(showConfirmPasswordBtn)))
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(cancelBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(btnProcess, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(23, 23, 23))
        );
        jPanel1Layout.setVerticalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addContainerGap(62, Short.MAX_VALUE)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                .addComponent(oldPasswordTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(showOldPasswordBtn)))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel2)
                                        .addComponent(newPasswordTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(showNewPasswordBtn))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel3)
                                        .addComponent(confirmPasswordTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(showConfirmPasswordBtn))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(btnProcess, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(cancelBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(9, 9, 9))
        );

        backBtn.setText("Back");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(31, 31, 31)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(backBtn)
                                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addContainerGap(34, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(24, 24, 24)
                                .addComponent(backBtn)
                                .addGap(18, 18, 18)
                                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(27, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>

    private void processChangePassword()
    {
        val oldPassword = oldPasswordTextField.getText();
        val newPassword = newPasswordTextField.getText();
        val confirmPassword = confirmPasswordTextField.getText();

        User user = (User) this.data.get(USER_KEY);

        if (user.getPassword().equals(oldPassword))
        {
            if (newPassword.equals(confirmPassword))
            {
                UserService userService = user instanceof StudentAccount ? AppContext.studentService : AppContext.teachingManagerService;

                try
                {
                    userService.changePassword(user.getUserId(), oldPassword, newPassword, confirmPassword);
                    JOptionPane.showMessageDialog(this, "Change Password Successfully");
                } catch (Exception exception)
                {
                    JOptionPane.showMessageDialog(this, exception.getMessage());
                }


            } else
            {
                JOptionPane.showMessageDialog(this, "New Password and Confirm Password do not match");
            }
        } else
        {
            JOptionPane.showMessageDialog(this, "Old password does not match");
        }
    }

    private void toggleShowOldPassword()
    {

        if (SHOW.equals(showOldPasswordBtn.getText()))
        {
            oldPasswordTextField.setEchoChar((char) 0);
            showOldPasswordBtn.setText(HIDE);
        } else if (HIDE.equals(showOldPasswordBtn.getText()))
        {
            oldPasswordTextField.setEchoChar('*');
            showOldPasswordBtn.setText(SHOW);
        }
    }

    private void toggleNewPassword()
    {
        if (SHOW.equals(showNewPasswordBtn.getText()))
        {
            newPasswordTextField.setEchoChar((char) 0);
            showNewPasswordBtn.setText(HIDE);
        } else if (HIDE.equals(showNewPasswordBtn.getText()))
        {
            newPasswordTextField.setEchoChar('*');
            showNewPasswordBtn.setText(SHOW);
        }
    }

    private void toggleConfirmPassword()
    {
        if (SHOW.equals(showConfirmPasswordBtn.getText()))
        {
            confirmPasswordTextField.setEchoChar((char) 0);
            showConfirmPasswordBtn.setText(HIDE);
        } else if (HIDE.equals(showConfirmPasswordBtn.getText()))
        {
            confirmPasswordTextField.setEchoChar('*');
            showConfirmPasswordBtn.setText(SHOW);
        }
    }
}
