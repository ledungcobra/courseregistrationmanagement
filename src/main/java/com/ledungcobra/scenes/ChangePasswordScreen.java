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
import com.ledungcobra.service.UserService;
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

    // <editor-fold defaultstate="collapsed>
    @BackButton
    private javax.swing.JButton backBtn;
    @BackButton
    private javax.swing.JButton cancelBtn;

    private JButton showOldPasswordBtn;
    private JButton showNewPasswordBtn;
    private JButton showConfirmPasswordBtn;
    private javax.swing.JButton btnProcess;
    private javax.swing.JPasswordField confirmPasswordTextField;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPasswordField newPasswordTextField;
    private javax.swing.JPasswordField oldPasswordTextField;

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

    // <editor-fold defaultstate="collapsed" desc="Generated Code">
    private void initComponents()
    {

        backBtn = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        btnProcess = new javax.swing.JButton();
        cancelBtn = new javax.swing.JButton();

        showOldPasswordBtn = new javax.swing.JButton();
        showNewPasswordBtn = new javax.swing.JButton();
        showConfirmPasswordBtn = new javax.swing.JButton();

        oldPasswordTextField = new javax.swing.JPasswordField();
        newPasswordTextField = new javax.swing.JPasswordField();
        confirmPasswordTextField = new javax.swing.JPasswordField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(1080, 545));

        backBtn.setText("Back");

        jLabel1.setText("Old password");

        jLabel2.setText("New password");

        jLabel3.setText("Confirm password");

        btnProcess.setText("Process");

        cancelBtn.setText("Cancel");

        showOldPasswordBtn.setText("Show");


        showNewPasswordBtn.setText("Show");

        showConfirmPasswordBtn.setText("Show");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addComponent(cancelBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(29, 29, 29)
                                                .addComponent(btnProcess, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(jLabel1)
                                                        .addComponent(backBtn)
                                                        .addComponent(jLabel2)
                                                        .addComponent(jLabel3))
                                                .addGap(65, 65, 65)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                        .addComponent(oldPasswordTextField)
                                                        .addComponent(newPasswordTextField)
                                                        .addComponent(confirmPasswordTextField, javax.swing.GroupLayout.DEFAULT_SIZE, 773, Short.MAX_VALUE))))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(showNewPasswordBtn)
                                        .addComponent(showOldPasswordBtn)
                                        .addComponent(showConfirmPasswordBtn))
                                .addContainerGap(58, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(backBtn)
                                .addGap(160, 160, 160)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel1)
                                        .addComponent(showOldPasswordBtn)
                                        .addComponent(oldPasswordTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel2)
                                        .addComponent(showNewPasswordBtn)
                                        .addComponent(newPasswordTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel3)
                                        .addComponent(showConfirmPasswordBtn)
                                        .addComponent(confirmPasswordTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(btnProcess, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(cancelBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addContainerGap(280, Short.MAX_VALUE))
        );

        pack();
    } // </editor-fold>

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
