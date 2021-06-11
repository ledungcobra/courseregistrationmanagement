/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ledungcobra.scenes;

import com.ledungcobra.anotations.BackButton;
import com.ledungcobra.anotations.SearchTextField;
import com.ledungcobra.applicationcontext.AppContext;
import com.ledungcobra.entites.TeachingManager;
import com.ledungcobra.interfaces.Searchable;
import com.ledungcobra.models.TeachingManagerTableModel;
import com.ledungcobra.services.TeachingManagerService;
import lombok.NonNull;
import lombok.SneakyThrows;
import lombok.val;
import lombok.var;
import org.hibernate.exception.ConstraintViolationException;

import javax.persistence.PersistenceException;
import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.List;

/**
 * @author ledun
 */
public class TeachingManagerManagementScreen extends Screen implements Searchable
{

    // <editor-fold defaultstate="collapsed desc="Class fields">
    @BackButton
    private javax.swing.JButton backBtn;
    private javax.swing.JButton clearBtn;
    private javax.swing.JTextField passwordTextField;
    private javax.swing.JButton deleteBtn;
    private javax.swing.JButton editBtn;
    private javax.swing.JTextField idTextField;
    private javax.swing.JButton insertBtn;
    private javax.swing.JButton resetPasswordBtn;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;

    @SearchTextField
    private javax.swing.JTextField searchTextField;
    private javax.swing.JButton searchBtn;
    private javax.swing.JTable teachingManagerTableList;
    private javax.swing.JTextField fullnameTextField;

    private TeachingManagerService service = AppContext.teachingManagerService;
    private List<TeachingManager> teachingManagerList;
    private TeachingManager editingTeachingManager;
    private boolean editingMode = false;
    private JPanel jPanel1;
    private JPanel jPanel3;
    private JPanel jPanel5;
    private JPanel jPanel2;

    // </editor-fold>

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">
    private void initComponents()
    {
        backBtn = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        teachingManagerTableList = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        searchBtn = new javax.swing.JButton();
        searchTextField = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        fullnameTextField = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        passwordTextField = new javax.swing.JTextField();
        idTextField = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        resetPasswordBtn = new javax.swing.JButton();
        deleteBtn = new javax.swing.JButton();
        editBtn = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        clearBtn = new javax.swing.JButton();
        insertBtn = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        backBtn.setText("Back");


        jScrollPane1.setViewportView(teachingManagerTableList);

        jLabel3.setFont(new java.awt.Font("Tahoma", 3, 14)); // NOI18N
        jLabel3.setText("Add new teaching manager");

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Search", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 3, 14))); // NOI18N

        jLabel1.setText("Keyword");

        searchBtn.setText("Search");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(searchTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 613, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(searchBtn)
                                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(searchTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel1)
                                        .addComponent(searchBtn))
                                .addContainerGap())
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        jLabel4.setText("Full name");

        jLabel2.setText("ID");

        jLabel5.setText("Password");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
                jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel2)
                                        .addComponent(jLabel4)
                                        .addComponent(jLabel5))
                                .addGap(39, 39, 39)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(passwordTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 707, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                .addComponent(fullnameTextField, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 707, Short.MAX_VALUE)
                                                .addComponent(idTextField, javax.swing.GroupLayout.Alignment.TRAILING)))
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
                jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel2)
                                        .addComponent(idTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel4)
                                        .addComponent(fullnameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel5)
                                        .addComponent(passwordTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addContainerGap())
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Manage teaching manager", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 3, 14))); // NOI18N

        resetPasswordBtn.setText("Reset password");

        deleteBtn.setBackground(new java.awt.Color(255, 51, 51));
        deleteBtn.setText("Delete");

        editBtn.setText("Edit");


        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
                jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel3Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(resetPasswordBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(editBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(deleteBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
                jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel3Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(resetPasswordBtn)
                                        .addComponent(editBtn)
                                        .addComponent(deleteBtn))
                                .addContainerGap())
        );

        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Actions", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 3, 14))); // NOI18N

        clearBtn.setText("Clear");

        insertBtn.setText("Insert");


        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
                jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel5Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(clearBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(insertBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
                jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel5Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(insertBtn)
                                        .addComponent(clearBtn))
                                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(21, 21, 21)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                                        .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addComponent(backBtn, javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(0, 25, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(32, 32, 32)
                                .addComponent(backBtn)
                                .addGap(18, 18, 18)
                                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(20, 20, 20)
                                .addComponent(jLabel3)
                                .addGap(18, 18, 18)
                                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(11, 11, 11)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 112, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap())
        );

        pack(); 
    }// </editor-fold>

    // <editor-fold defaultstate="collapsed desc="Delete btn action">
    @SneakyThrows
    private void deleteBtnActionPerformed(java.awt.event.ActionEvent evt)
    {
        int selectedIndex = this.teachingManagerTableList.getSelectedRow();
        val selectedIndices = this.teachingManagerTableList.getSelectedRows();

        if (selectedIndex == -1)
        {
            JOptionPane.showMessageDialog(this, "You must select a record to perform this action");
            return;
        }
        if (selectedIndices.length == 1)
        {
            int result = JOptionPane.showConfirmDialog(this, "Do you want to delete this teaching manager account", "Confirm", JOptionPane.YES_NO_OPTION);

            if (result == JOptionPane.YES_OPTION)
            {
                val teachingManager = this.teachingManagerList.get(selectedIndex);
                service.deleteTeachingManager(teachingManager);
                updateTableData();
            }
        } else
        {

            int result = JOptionPane.showConfirmDialog(this, "Do you want to delete these teaching manager account", "Confirm", JOptionPane.YES_NO_OPTION);

            if (result == JOptionPane.YES_OPTION)
            {
                for (val index : selectedIndices)
                {
                    service.deleteTeachingManager(teachingManagerList.get(index));
                }
                updateTableData();
            }
        }

    }    // </editor-fold>

    private void updateTableData()
    {
        this.teachingManagerList = service.getTeachingManagerList();
        teachingManagerTableList.setModel(new TeachingManagerTableModel(teachingManagerList));
    }

    private void editBtnActionPerformed(java.awt.event.ActionEvent evt)
    {
        int selectedIndex = this.teachingManagerTableList.getSelectedRow();

        if (selectedIndex == -1)
        {
            JOptionPane.showMessageDialog(this, "You must select a record to perform this action");
            return;
        }
        this.editingTeachingManager = this.teachingManagerList.get(selectedIndex);
        this.idTextField.setText(this.editingTeachingManager.getId());
        this.fullnameTextField.setText(this.editingTeachingManager.getFullName());
        this.passwordTextField.setText(this.editingTeachingManager.getPassword());
        this.jLabel3.setText("Edit a teaching manager account");
        this.insertBtn.setText("Update");
        this.editingMode = true;
        this.idTextField.setEditable(false);

    }

    private void clearBtnActionPerformed(java.awt.event.ActionEvent evt)
    {
        this.idTextField.setText("");
        this.fullnameTextField.setText("");
        this.passwordTextField.setText("");
        this.editingTeachingManager = null;

        this.jLabel3.setText("Add new teaching manager");
        this.insertBtn.setText("Insert");
        this.editingMode = false;
        this.idTextField.setEditable(true);
        this.editingTeachingManager = null;
    }

    @SneakyThrows
    private void resetPassword()
    {

        int selectedIndex = this.teachingManagerTableList.getSelectedRow();
        val selectedIndices = this.teachingManagerTableList.getSelectedRows();
        if (selectedIndex == -1)
        {
            JOptionPane.showMessageDialog(this, "You must select a record to perform this action");
            return;
        }
        if (selectedIndices.length == 1)
        {
            val teachingManager = this.teachingManagerList.get(selectedIndex);
            service.resetTeachingManagerPassword(teachingManager);
            updateTableData();
        } else
        {

            for (val index : selectedIndices)
            {
                service.resetTeachingManagerPassword(teachingManagerList.get(index));
            }
            updateTableData();
        }
    }

    private boolean checkIdExist(@NonNull String id)
    {
        return this.teachingManagerList.stream().anyMatch(t -> t.getId().equals(id));
    }

    private void insertBtnActionPerformed(java.awt.event.ActionEvent evt)
    {

        val teachingManagerId = idTextField.getText();
        val fullname = fullnameTextField.getText();
        var password = passwordTextField.getText();

        if ("".equals(teachingManagerId))
        {
            JOptionPane.showMessageDialog(this, "You have to fill id text field to continue");
            return;
        }

        if ("".equals(fullname))
        {
            JOptionPane.showMessageDialog(this, "You have to enter full name to continue");
            return;
        }

        if ("".equals(password))
        {
            val answer = JOptionPane.showConfirmDialog(this, "Confirm", "Do you want to use id for password", JOptionPane.YES_NO_OPTION);

            if (answer == JOptionPane.YES_OPTION)
            {
                this.passwordTextField.setText(teachingManagerId);
                password = teachingManagerId;
            } else
            {
                JOptionPane.showMessageDialog(this, "Password must be set to continue");
                return;
            }
        }

        try
        {

            if (this.editingTeachingManager == null)
            {
                service.addNewTeachingManager(new TeachingManager(teachingManagerId, fullname, password));
            } else
            {
                this.editingTeachingManager.setPassword(password);
                this.editingTeachingManager.setFullName(fullname);
                this.editingTeachingManager.setId(teachingManagerId);
                service.updateTeachingManager(this.editingTeachingManager);
            }
            updateTableData();

        } catch (ConstraintViolationException e)
        {
            JOptionPane.showMessageDialog(this, e.getMessage());
        } catch (PersistenceException e)
        {
            JOptionPane.showMessageDialog(this, e.getMessage());
        } catch (Exception exception)
        {
            exception.printStackTrace();
        } finally
        {
            clearBtnActionPerformed(null);
        }
    }

    public void searchBtnActionPerformed(java.awt.event.ActionEvent evt)
    {
        val keyword = searchTextField.getText();
        System.out.println(keyword);

        List<TeachingManager> teachingManagerList = service.searchTeachingManager(keyword);
        updateTableData(teachingManagerList);
    }

    private void updateTableData(List<TeachingManager> teachingManagerList)
    {
        this.teachingManagerList = teachingManagerList;
        teachingManagerTableList.setModel(new TeachingManagerTableModel(teachingManagerList));
    }


    @Override
    public void onCreateView()
    {
        initComponents();
        updateTableData();
    }


    @Override
    public void addEventListener()
    {
        searchBtn.addActionListener(evt -> searchBtnActionPerformed(evt));
        editBtn.addActionListener(evt -> editBtnActionPerformed(evt));
        clearBtn.addActionListener(evt -> clearBtnActionPerformed(evt));
        insertBtn.addActionListener(evt -> insertBtnActionPerformed(evt));
        deleteBtn.addActionListener(evt -> deleteBtnActionPerformed(evt));
        resetPasswordBtn.addActionListener(e -> resetPassword());

        idTextField.addKeyListener(new KeyListener()
        {

            @Override
            public void keyTyped(KeyEvent e)
            {
            }

            @Override
            public void keyPressed(KeyEvent e)
            {

            }

            @Override
            public void keyReleased(KeyEvent e)
            {
                if (!editingMode)
                {
                    if (checkIdExist(idTextField.getText()))
                    {
                        idTextField.setBackground(Color.RED);
                    } else
                    {
                        passwordTextField.setText(idTextField.getText());
                        idTextField.setBackground(Color.WHITE);
                    }
                }
            }
        });
    }
}
