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
    @BackButton
    private javax.swing.JButton backBtn;
    private javax.swing.JButton btnProcess;
    private javax.swing.JButton cancelBtn;
    private javax.swing.JPasswordField confirmPasswordTextField;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPasswordField newPasswordTextField;
    private javax.swing.JPasswordField oldPasswordTextField;
    private javax.swing.JButton showConfirmPasswordBtn;
    private javax.swing.JButton showNewPasswordBtn;
    private javax.swing.JButton showOldPasswordBtn;
    private JPanel jPanel2;
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

        backBtn = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        oldPasswordTextField = new javax.swing.JPasswordField();
        showConfirmPasswordBtn = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        showOldPasswordBtn = new javax.swing.JButton();
        newPasswordTextField = new javax.swing.JPasswordField();
        jLabel1 = new javax.swing.JLabel();
        showNewPasswordBtn = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        btnProcess = new javax.swing.JButton();
        confirmPasswordTextField = new javax.swing.JPasswordField();
        cancelBtn = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(860, 330));

        backBtn.setText("Back");

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Change password", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 3, 14))); // NOI18N

        showConfirmPasswordBtn.setText("Show");

        jLabel2.setText("New password");

        showOldPasswordBtn.setText("Show");

        jLabel1.setText("Old password");

        showNewPasswordBtn.setText("Show");

        jLabel3.setText("Confirm password");

        btnProcess.setBackground(new java.awt.Color(0, 255, 255));
        btnProcess.setText("Process");

        cancelBtn.setText("Cancel");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
                jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addGroup(jPanel2Layout.createSequentialGroup()
                                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(jLabel3)
                                                        .addComponent(jLabel2)
                                                        .addComponent(jLabel1))
                                                .addGap(18, 18, 18)
                                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                        .addComponent(confirmPasswordTextField)
                                                        .addComponent(newPasswordTextField)
                                                        .addComponent(oldPasswordTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 546, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGap(28, 28, 28)
                                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(showNewPasswordBtn)
                                                        .addComponent(showOldPasswordBtn)
                                                        .addComponent(showConfirmPasswordBtn))
                                                .addGap(0, 0, Short.MAX_VALUE))
                                        .addGroup(jPanel2Layout.createSequentialGroup()
                                                .addGap(0, 0, Short.MAX_VALUE)
                                                .addComponent(cancelBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(btnProcess, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
                jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                .addComponent(oldPasswordTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(showOldPasswordBtn)))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel2)
                                        .addComponent(newPasswordTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(showNewPasswordBtn))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel3)
                                        .addComponent(confirmPasswordTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(showConfirmPasswordBtn))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(btnProcess, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(cancelBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(31, 31, 31)
                                                .addComponent(backBtn))
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(21, 21, 21)
                                                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addContainerGap(23, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(24, 24, 24)
                                .addComponent(backBtn)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(23, 23, 23))
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
