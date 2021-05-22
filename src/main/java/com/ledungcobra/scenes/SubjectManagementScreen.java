/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ledungcobra.scenes;

import com.ledungcobra.anotations.BackButton;
import com.ledungcobra.applicationcontext.AppContext;
import com.ledungcobra.entites.Subject;
import com.ledungcobra.model.SubjectTableModel;
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
public class SubjectManagementScreen extends Screen {

    // <editor-fold defaultstate="collapsed desc="Class fields">
    @BackButton
    private javax.swing.JButton backBtn;
    private javax.swing.JButton clearBtn;
    private javax.swing.JTextField creditTextField;
    private javax.swing.JButton deleteBtn;
    private javax.swing.JButton editBtn;
    private javax.swing.JButton insertBtn;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel addNewSubject;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JButton searchBtn;
    private javax.swing.JTextField subjectIDTextField;
    private javax.swing.JTable subjectListTable;
    private javax.swing.JTextField subjectNameTextField;
    private TeachingManagerService service = AppContext.teachingManagerService;
    private List<Subject> listSubjects;
    private Subject currentEditingSubject;
    // </editor-fold>

    @Override
    public void onCreateView() {
        initComponents();
        updateTableData();
    }

    private void updateTableData() {
        this.listSubjects = service.getSubjectList();
        subjectListTable.setModel(new SubjectTableModel(this.listSubjects));
    }

    private void updateTableData(List<Subject> subjects) {
        this.listSubjects = subjects;
        subjectListTable.setModel(new SubjectTableModel(this.listSubjects));
    }


    @Override
    public void addEventListener() {
        editBtn.addActionListener(evt -> editBtnActionPerformed(evt));
        insertBtn.addActionListener(evt -> insertBtnActionPerformed(evt));
        clearBtn.addActionListener(evt -> clearBtnActionPerformed(evt));
        deleteBtn.addActionListener(evt -> deleteBtnActionPerformed(evt));
        searchBtn.addActionListener(evt -> searchBtnActionPerformed(evt));
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="UI builder method">
    private void initComponents() {

        backBtn = new javax.swing.JButton();
        jTextField1 = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        searchBtn = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        subjectListTable = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        addNewSubject = new javax.swing.JLabel();
        subjectIDTextField = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        subjectNameTextField = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        creditTextField = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        editBtn = new javax.swing.JButton();
        insertBtn = new javax.swing.JButton();
        clearBtn = new javax.swing.JButton();
        deleteBtn = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        backBtn.setText("Back");

        jLabel1.setText("Keyword");

        searchBtn.setText("Search");


        jScrollPane1.setViewportView(subjectListTable);

        jLabel2.setText("Subject ID");

        addNewSubject.setFont(new java.awt.Font("Tahoma", 3, 14));
        addNewSubject.setText("Add new subject");


        jLabel4.setText("Subject name");

        jLabel5.setText("Credit");

        jLabel6.setFont(new java.awt.Font("Tahoma", 3, 14));
        jLabel6.setText("Manage subject");

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
                                        .addGroup(layout.createSequentialGroup()
                                                .addComponent(backBtn)
                                                .addGap(0, 0, Short.MAX_VALUE))
                                        .addGroup(layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addComponent(jLabel1)
                                                                .addGap(19, 19, 19)
                                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                                                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 861, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                                        .addComponent(jLabel2)
                                                                                        .addComponent(addNewSubject)
                                                                                        .addComponent(jLabel4)
                                                                                        .addComponent(jLabel5))
                                                                                .addGap(14, 14, 14)
                                                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                                        .addComponent(subjectIDTextField)
                                                                                        .addComponent(subjectNameTextField)
                                                                                        .addComponent(creditTextField)))
                                                                        .addGroup(layout.createSequentialGroup()
                                                                                .addComponent(clearBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                .addGap(18, 18, 18)
                                                                                .addComponent(insertBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addComponent(editBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addGap(18, 18, 18)
                                                                .addComponent(deleteBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                .addComponent(jLabel6)
                                                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 858, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 22, Short.MAX_VALUE)
                                                .addComponent(searchBtn)))
                                .addContainerGap())
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(backBtn)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel1)
                                        .addComponent(searchBtn))
                                .addGap(20, 20, 20)
                                .addComponent(addNewSubject)
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel2)
                                        .addComponent(subjectIDTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel4)
                                        .addComponent(subjectNameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel5)
                                        .addComponent(creditTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(35, 35, 35)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(clearBtn)
                                        .addComponent(insertBtn))
                                .addGap(49, 72, Short.MAX_VALUE)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel6)
                                .addGap(9, 9, 9)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(deleteBtn)
                                        .addComponent(editBtn))
                                .addGap(72, 72, 72))
        );

        pack();
    }// </editor-fold>


    private void deleteBtnActionPerformed(java.awt.event.ActionEvent evt) {
        val selectedIndex = this.subjectListTable.getSelectedRow();

        if (selectedIndex == -1) {
            JOptionPane.showMessageDialog(this, "You must select a row to delete a subject");
            return;
        }

        int result = JOptionPane.showConfirmDialog(this, "Do you want to delete this subject", "Confirm", JOptionPane.YES_NO_OPTION);

        if (result == JOptionPane.YES_OPTION) {
            service.deleteSubject(this.listSubjects.get(selectedIndex));
            updateTableData();
        }

    }

    private void editBtnActionPerformed(java.awt.event.ActionEvent evt) {
        val selectedIndex = this.subjectListTable.getSelectedRow();
        if (selectedIndex == -1) {
            JOptionPane.showMessageDialog(this, "You must select a row to edit a subject");
            return;
        }

        this.currentEditingSubject = this.listSubjects.get(selectedIndex);
        addNewSubject.setText("Update a subject");
        insertBtn.setText("Update");
        subjectIDTextField.setText(currentEditingSubject.getId());
        subjectNameTextField.setText(currentEditingSubject.getName());
        creditTextField.setText(String.valueOf(currentEditingSubject.getCredit()));

    }

    private void clearBtnActionPerformed(java.awt.event.ActionEvent evt) {

        subjectIDTextField.setText("");
        subjectNameTextField.setText("");
        creditTextField.setText("");
        this.currentEditingSubject = null;

    }

    private void insertBtnActionPerformed(java.awt.event.ActionEvent evt) {

        val subjectID = subjectIDTextField.getText();
        val subjectName = subjectNameTextField.getText();
        val creditStr = creditTextField.getText();
        Integer creditInt = null;

        if ("".equals(subjectID)) {
            JOptionPane.showMessageDialog(this, "You must fill in subject id");
        }

        if ("".equals(subjectName)) {
            JOptionPane.showMessageDialog(this, "Subject name cannot be empty");
        }

        try {
            creditInt = Integer.parseInt(creditStr);

            if (currentEditingSubject != null) {
                if (subjectID.equals(currentEditingSubject.getId())) {
                    currentEditingSubject.setName(subjectName);
                    currentEditingSubject.setCredit(creditInt);

                    service.updateSubject(currentEditingSubject);
                    updateTableData();
                } else {
                    JOptionPane.showMessageDialog(this, "The id cannot be change because it is primary key for subject");
                }
            } else {
                service.addNewSubject(new Subject(subjectID, subjectName, creditInt));
                updateTableData();
            }
        } catch (NumberFormatException exception) {
            JOptionPane.showMessageDialog(this, "Credit must be number");
        } catch (ConstraintViolationException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage());
        } catch (PersistenceException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage());
        } finally {
            this.addNewSubject.setText("Add new subject");
            this.currentEditingSubject = null;
            this.insertBtn.setText("Insert");
        }


    }

    private void searchBtnActionPerformed(java.awt.event.ActionEvent evt) {
        val keyword = jTextField1.getText();
        if ("".equals(keyword)) {
            JOptionPane.showMessageDialog(this, "Please input subject name for searching");
            return;
        }
        val subjects = service.searchSubject(keyword);
        updateTableData(subjects);
    }


}
