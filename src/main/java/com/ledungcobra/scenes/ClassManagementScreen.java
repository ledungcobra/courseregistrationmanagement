/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ledungcobra.scenes;

import com.ledungcobra.anotations.BackButton;
import com.ledungcobra.applicationcontext.AppContext;
import com.ledungcobra.entites.Class;
import com.ledungcobra.model.ClassTableModel;
import com.ledungcobra.scenes.Screen;
import com.ledungcobra.service.TeachingManagerService;
import lombok.val;
import org.hibernate.exception.ConstraintViolationException;

import javax.persistence.PersistenceException;
import javax.swing.*;
import java.util.List;

/**
 * @author ledun
 */
public class ClassManagementScreen extends Screen {

    @BackButton
    private javax.swing.JButton backBtn;
    private javax.swing.JButton clearBtn;
    private javax.swing.JButton deleteBtn;
    private javax.swing.JButton editBtn;
    private javax.swing.JButton insertBtn;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel addAClassLbl;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JButton searchBtn;
    private javax.swing.JTextField classNameTextField;
    private javax.swing.JTable classListTable;
    private TeachingManagerService service = AppContext.teachingManagerService;
    private List<Class> classList;

    private Class currentEditingClass;

    // <editor-fold defaultstate="collapsed>
    private void initComponents() {

        backBtn = new javax.swing.JButton();
        jTextField1 = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        searchBtn = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        classListTable = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        addAClassLbl = new javax.swing.JLabel();
        classNameTextField = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        editBtn = new javax.swing.JButton();
        insertBtn = new javax.swing.JButton();
        clearBtn = new javax.swing.JButton();
        deleteBtn = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        backBtn.setText("Back");
        jLabel1.setText("Keyword");
        searchBtn.setText("Search");


        jScrollPane1.setViewportView(classListTable);

        jLabel2.setText("Class name");

        addAClassLbl.setFont(new java.awt.Font("Tahoma", 3, 14)); // NOI18N
        addAClassLbl.setText("Add new class");


        jLabel6.setFont(new java.awt.Font("Tahoma", 3, 14)); // NOI18N
        jLabel6.setText("Manage class");

        editBtn.setText("Edit");


        insertBtn.setText("Insert");

        clearBtn.setText("Clear");


        deleteBtn.setBackground(new java.awt.Color(255, 51, 51));
        deleteBtn.setText("Delete");


        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(backBtn)
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(68, 68, 68)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                        .addComponent(jLabel2)
                                                                        .addComponent(addAClassLbl))
                                                                .addGap(14, 14, 14)
                                                                .addComponent(classNameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 750, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addComponent(jLabel6)
                                                                .addGap(768, 768, 768))
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addComponent(clearBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addGap(29, 29, 29)
                                                                .addComponent(insertBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addComponent(editBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addGap(30, 30, 30)
                                                                .addComponent(deleteBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 861, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addContainerGap(107, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(backBtn)
                                .addGap(54, 54, 54)
                                .addComponent(addAClassLbl)
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel2)
                                        .addComponent(classNameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(clearBtn)
                                        .addComponent(insertBtn))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 41, Short.MAX_VALUE)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel6)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(editBtn)
                                        .addComponent(deleteBtn))
                                .addGap(18, 18, 18))
        );


        pack();
    }
    // </editor-fold>

    private void subjectIDTextFieldActionPerformed(java.awt.event.ActionEvent evt) {

    }

    private void deleteBtnActionPerformed(java.awt.event.ActionEvent evt) {
        val selectedRowIndex = classListTable.getSelectedRow();
        if (selectedRowIndex == -1) {
            JOptionPane.showMessageDialog(this, "You must select a row to delete");
            return;
        }
        val row = this.classList.get(selectedRowIndex);
        try {
            service.deleteAnClass(row);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "A class have students in it you have to delete students first then perform this action latter");
            return;
        }
        updateTableData();
    }

    private void editBtnActionPerformed(java.awt.event.ActionEvent evt) {

        val selectedRowIndex = classListTable.getSelectedRow();

        if (selectedRowIndex == -1) {
            JOptionPane.showMessageDialog(this, "You must choose a record to edit");
            return;
        }
        currentEditingClass = this.classList.get(selectedRowIndex);

        this.classNameTextField.setText(currentEditingClass.getClassName());
        this.insertBtn.setText("Update");
        addAClassLbl.setText("Edit a class");

    }

    private void clearBtnActionPerformed(java.awt.event.ActionEvent evt) {
        classNameTextField.setText("");
        this.currentEditingClass = null;
    }

    private void insertBtnActionPerformed(java.awt.event.ActionEvent evt) {

        try {
            val className = classNameTextField.getText();

            if ("".equals(className)) {
                JOptionPane.showMessageDialog(this, "Class name should not be empty");
            } else {

                if (currentEditingClass != null) {
                    currentEditingClass.setClassName(className);
                    service.updateClass(currentEditingClass);
                    currentEditingClass = null;
                } else {
                    val clazz = new Class();
                    clazz.setClassName(className);
                    service.addNewClass(clazz);
                    JOptionPane.showMessageDialog(this, "Add class name " + className + " done");
                }
                updateTableData();

            }
        } catch (ConstraintViolationException e) {
            JOptionPane.showMessageDialog(this, "Class name already exists");
        } catch (PersistenceException e) {
            JOptionPane.showMessageDialog(this, "Class name already exists");
        } finally {
            this.insertBtn.setText("Insert");
            this.addAClassLbl.setText("Add new class");
            this.classNameTextField.setText("");
        }


    }

    private void searchBtnActionPerformed(java.awt.event.ActionEvent evt) {
    }


    @Override
    public void onCreateView() {
        initComponents();
        updateTableData();
    }

    public void updateTableData() {
        this.classList = AppContext.teachingManagerService.getClasses();
        classListTable
                .setModel(new ClassTableModel(this.classList));
    }

    @Override
    public void addEventListener() {
        searchBtn.addActionListener(evt -> searchBtnActionPerformed(evt));
        classNameTextField.addActionListener(evt -> subjectIDTextFieldActionPerformed(evt));
        editBtn.addActionListener(evt -> editBtnActionPerformed(evt));
        insertBtn.addActionListener(evt -> insertBtnActionPerformed(evt));
        clearBtn.addActionListener(evt -> clearBtnActionPerformed(evt));
        deleteBtn.addActionListener(evt -> deleteBtnActionPerformed(evt));
    }
}
