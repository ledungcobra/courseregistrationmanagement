/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ledungcobra.scenes;

import com.ledungcobra.anotations.BackButton;
import com.ledungcobra.applicationcontext.AppContext;
import com.ledungcobra.entites.StudentAccount;
import com.ledungcobra.entites.StudentInfo;
import com.ledungcobra.entites.TeachingManager;
import com.ledungcobra.entites.User;
import com.ledungcobra.services.UserService;
import lombok.val;
import sun.security.krb5.internal.KDCOptions;

import javax.swing.*;
import java.awt.event.ActionEvent;

import static com.ledungcobra.scenes.LoginScreen.USER_KEY;


public class UserInfoScreen extends Screen
{
    // <editor-fold defaultstate="collapsed desc="Class fields">
    @BackButton
    private JButton backBtn;
    private javax.swing.JComboBox<String> genderComboBox;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;

    private JPasswordField passwordTextField;
    private javax.swing.JTextField userIdTextField;
    private javax.swing.JTextField usernameTextField;
    private JPanel jPanel1;
    private JButton updateBtn;
    // </editor-fold>

    private boolean isStudent;

    private User user;

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">
    private void initComponents()
    {
        backBtn = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        passwordTextField = new JPasswordField();
        jLabel3 = new javax.swing.JLabel();
        userIdTextField = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        usernameTextField = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        genderComboBox = new javax.swing.JComboBox<>();
        updateBtn = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        backBtn.setText("Back");

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "User info", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 3, 14))); // NOI18N

        jLabel3.setText("Gender");

        userIdTextField.setEditable(false);
        userIdTextField.setText("ID");

        jLabel4.setText("ID");

        jLabel1.setText("Full name");

        jLabel2.setText("Password");

        genderComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[]{"Boy", "Girl"}));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel1)
                                        .addComponent(jLabel2)
                                        .addComponent(jLabel3)
                                        .addComponent(jLabel4))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 17, Short.MAX_VALUE)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(genderComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                .addComponent(usernameTextField)
                                                .addComponent(passwordTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 642, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addComponent(userIdTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(userIdTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel4))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(usernameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel1))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel2)
                                        .addComponent(passwordTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel3)
                                        .addComponent(genderComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addContainerGap())
        );

        updateBtn.setText("Update");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(23, 23, 23)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(updateBtn)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(backBtn)))
                                .addContainerGap(19, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(22, 22, 22)
                                .addComponent(backBtn)
                                .addGap(18, 18, 18)
                                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(updateBtn)
                                .addContainerGap(20, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>


    @Override
    public void onCreateView()
    {
        initComponents();


        this.user = (User) this.data.get(USER_KEY);
        this.isStudent = user instanceof StudentAccount;
        if (user != null)
        {
            this.usernameTextField.setText(user.getFullName());
            this.userIdTextField.setText(user.getUserId());
            this.passwordTextField.setText(user.getPassword());

            if (isStudent)
            {
                this.genderComboBox.setVisible(true);
                jLabel3.setVisible(true);
                this.genderComboBox.setSelectedItem(((StudentAccount) user).getStudentInfo().getGender());
            } else
            {
                this.genderComboBox.setVisible(false);
                jLabel3.setVisible(false);
            }
        }


    }

    @Override
    public void addEventListener()
    {
        this.updateBtn.addActionListener(e -> onUpdateBtnActionPerformed(e));
    }

    private void onUpdateBtnActionPerformed(ActionEvent e)
    {

        String username = usernameTextField.getText();
        if (username == null || username.isEmpty())
        {
            JOptionPane.showMessageDialog(this, "Username cannot be empty");
            return;

        }

        String password = new String(passwordTextField.getPassword());
        if (password == null || password.isEmpty())
        {
            JOptionPane.showMessageDialog(this, "Password cannot be empty");
            return;
        }

        try
        {
            if (this.isStudent)
            {
                String gender = (String) genderComboBox.getSelectedItem();
                StudentInfo studentInfo = ((StudentAccount) user).getStudentInfo();
                studentInfo.setGender(gender);
                studentInfo.setFullName(username);
                user.setPassword(password);

                AppContext.studentService.updateInfo(user);

            } else
            {
                TeachingManager teachingManager = (TeachingManager) user;
                teachingManager.setPassword(password);
                teachingManager.setFullName(username);
                AppContext.teachingManagerService.updateInfo(teachingManager);

            }

            JOptionPane.showMessageDialog(this, "Update user info success");
        } catch (Exception ex)
        {
            JOptionPane.showMessageDialog(this, "Update user info fail");
        }

    }
}
