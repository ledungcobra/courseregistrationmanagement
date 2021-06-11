/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ledungcobra.scenes;

import com.ledungcobra.applicationcontext.AppContext;
import com.ledungcobra.utils.Navigator;

import javax.swing.*;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Properties;

import static com.ledungcobra.utils.Constants.*;

/**
 * @author ledun
 */
public class ConfigDatabaseScreen extends Screen
{

    @Override
    public void onCreateView()
    {
        initComponents();
        if (getData() == null) throw new IllegalStateException();

        String connectionString = (String) getData().get(CONNECTION_STRING);
        String username = (String) getData().get(USER_NAME);
        String password = (String) getData().get(PASSWORD);

        this.connectionStringTextField.setText(connectionString);
        this.usernameTextField.setText(username);
        this.passwordTextField.setText(password);

    }

    @Override
    public void addEventListener()
    {
        connectBtn.addActionListener(e -> onConnectBtnActionPerform());
    }

    private void onConnectBtnActionPerform()
    {
        String connectionString = connectionStringTextField.getText();
        String username = usernameTextField.getText();
        String password = new String(passwordTextField.getPassword());

        if (connectionString == null || connectionString.isEmpty())
        {
            JOptionPane.showMessageDialog(this, "You have to input connection string to continue");
            return;
        }

        if (username == null || username.isEmpty())
        {
            JOptionPane.showMessageDialog(this, "You have to input username to continue");
            return;
        }

        if (password == null || password.isEmpty())
        {
            JOptionPane.showMessageDialog(this, "You have to enter password to continue");
            return;
        }

        AppContext.username = username;
        AppContext.password = password;
        AppContext.connectionString = connectionString;

        writeConfigInfoToDatabase(connectionString, username, password);
        try
        {
            AppContext.build();
            new Navigator<LoginScreen>().navigate(700, 300, null);
        } catch (Exception e)
        {
            JOptionPane.showMessageDialog(this, "Cannot establish connection");
        }

    }

    private void writeConfigInfoToDatabase(String connectionString, String username, String password)
    {
        Properties properties = new Properties();
        properties.setProperty(CONNECTION_STRING, connectionString);
        properties.setProperty(USER_NAME, username);
        properties.setProperty(PASSWORD, password);

        try (OutputStream os = new FileOutputStream(CONFIG_FILE_NAME))
        {
            properties.store(os, "Used for login to database");

        } catch (Exception e)
        {
            JOptionPane.showMessageDialog(this, "An error occur when store properties file");
        }
    }


    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">
    private void initComponents()
    {

        jPanel1 = new javax.swing.JPanel();
        usernameTextField = new javax.swing.JTextField();
        connectBtn = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        connectionStringTextField = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        passwordTextField = new javax.swing.JPasswordField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Config", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 3, 14))); // NOI18N

        connectBtn.setText("Connect");

        jLabel3.setText("Password");

        jLabel1.setText("Connection String");

        jLabel2.setText("Username");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(jLabel1)
                                                        .addComponent(jLabel2)
                                                        .addComponent(jLabel3))
                                                .addGap(18, 18, 18)
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(connectionStringTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 429, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                                .addComponent(usernameTextField)
                                                                .addComponent(passwordTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 429, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                        .addComponent(connectBtn, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel1)
                                        .addComponent(connectionStringTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel2)
                                        .addComponent(usernameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel3)
                                        .addComponent(passwordTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(connectBtn)
                                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(15, 15, 15)
                                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(18, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addContainerGap(16, Short.MAX_VALUE)
                                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap())
        );

        pack();
    }// </editor-fold>

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify
    private javax.swing.JButton connectBtn;
    private javax.swing.JTextField connectionStringTextField;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPasswordField passwordTextField;
    private javax.swing.JTextField usernameTextField;
    // End of variables declaration
}
