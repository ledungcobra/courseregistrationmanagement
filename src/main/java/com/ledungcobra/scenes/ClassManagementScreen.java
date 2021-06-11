/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ledungcobra.scenes;

import com.ledungcobra.anotations.BackButton;
import com.ledungcobra.anotations.SearchTextField;
import com.ledungcobra.applicationcontext.AppContext;
import com.ledungcobra.entites.Class;
import com.ledungcobra.interfaces.Searchable;
import com.ledungcobra.models.ClassTableModel;
import com.ledungcobra.services.TeachingManagerService;
import lombok.SneakyThrows;
import lombok.val;
import org.hibernate.exception.ConstraintViolationException;

import javax.persistence.PersistenceException;
import javax.swing.*;
import java.util.List;

/**
 * @author ledun
 */
public class ClassManagementScreen extends Screen implements Searchable
{

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

    @SearchTextField
    private javax.swing.JTextField searchTextField;
    private javax.swing.JButton searchBtn;
    private javax.swing.JTextField classNameTextField;
    private javax.swing.JTable classListTable;
    private TeachingManagerService service = AppContext.teachingManagerService;
    private List<Class> classList;

    private Class currentEditingClass;
    private JPanel jPanel3;
    private JPanel jPanel2;
    private JPanel jPanel1;

    // <editor-fold defaultstate="collapsed>
    private void initComponents()
    {

        jPanel3 = new javax.swing.JPanel();
        insertBtn = new javax.swing.JButton();
        clearBtn = new javax.swing.JButton();
        classNameTextField = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        addAClassLbl = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        searchTextField = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        searchBtn = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        deleteBtn = new javax.swing.JButton();
        editBtn = new javax.swing.JButton();
        backBtn = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        classListTable = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel3.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        insertBtn.setText("Insert");

        clearBtn.setText("Clear");

        jLabel2.setText("Class name");

        addAClassLbl.setFont(new java.awt.Font("Tahoma", 3, 14)); // NOI18N
        addAClassLbl.setText("Add new class");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
                jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel3Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                                                .addComponent(jLabel2)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(classNameTextField)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(clearBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(insertBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(jPanel3Layout.createSequentialGroup()
                                                .addComponent(addAClassLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(0, 0, Short.MAX_VALUE)))
                                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
                jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(addAClassLbl)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 13, Short.MAX_VALUE)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(insertBtn)
                                        .addComponent(clearBtn)
                                        .addComponent(classNameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel2))
                                .addGap(19, 19, 19))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Search", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 3, 14))); // NOI18N

        jLabel1.setText("Keyword");

        searchBtn.setText("Search");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
                jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 51, Short.MAX_VALUE)
                                .addComponent(searchTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 638, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(searchBtn)
                                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
                jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(20, 20, 20)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(searchTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel1)
                                        .addComponent(searchBtn))
                                .addContainerGap(23, Short.MAX_VALUE))
        );

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Manage Class", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 3, 14))); // NOI18N

        deleteBtn.setBackground(new java.awt.Color(255, 51, 51));
        deleteBtn.setText("Delete");

        editBtn.setText("Edit");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(editBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(deleteBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel1Layout.setVerticalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(deleteBtn)
                                        .addComponent(editBtn))
                                .addContainerGap())
        );

        backBtn.setText("Back");

        jScrollPane1.setViewportView(classListTable);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(27, 27, 27)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(backBtn)
                                        .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 858, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addContainerGap(24, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(17, 17, 17)
                                .addComponent(backBtn)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap())
        );

        pack();
    }
    // </editor-fold>

    private void classNameTextFieldActionPerformed(java.awt.event.ActionEvent evt)
    {

    }

    private void deleteBtnActionPerformed(java.awt.event.ActionEvent evt)
    {
        val selectedRowIndex = classListTable.getSelectedRow();
        if (selectedRowIndex == -1)
        {
            JOptionPane.showMessageDialog(this, "You must select a row to delete");
            return;
        }
        val row = this.classList.get(selectedRowIndex);
        try
        {
            service.deleteAnClass(row);
        } catch (Exception e)
        {
            JOptionPane.showMessageDialog(this, "A class have students in it you have to delete students first then perform this action latter");
            return;
        }
        updateTableData();
    }

    private void editBtnActionPerformed(java.awt.event.ActionEvent evt)
    {

        val selectedRowIndex = classListTable.getSelectedRow();

        if (selectedRowIndex == -1)
        {
            JOptionPane.showMessageDialog(this, "You must choose a record to edit");
            return;
        }
        currentEditingClass = this.classList.get(selectedRowIndex);

        this.classNameTextField.setText(currentEditingClass.getClassName());
        this.insertBtn.setText("Update");
        addAClassLbl.setText("Edit a class");

    }

    private void clearBtnActionPerformed(java.awt.event.ActionEvent evt)
    {
        classNameTextField.setText("");
        this.currentEditingClass = null;
    }

    @SneakyThrows
    private void insertBtnActionPerformed(java.awt.event.ActionEvent evt)
    {

        try
        {
            val className = classNameTextField.getText();

            if ("".equals(className))
            {
                JOptionPane.showMessageDialog(this, "Class name should not be empty");
            } else
            {

                if (currentEditingClass != null)
                {
                    currentEditingClass.setClassName(className);
                    service.updateClass(currentEditingClass);
                    currentEditingClass = null;
                } else
                {
                    val clazz = new Class();
                    clazz.setClassName(className);
                    service.addNewClass(clazz);
                    JOptionPane.showMessageDialog(this, "Add class name " + className + " done");
                }
                updateTableData();

            }
        } catch (ConstraintViolationException e)
        {
            JOptionPane.showMessageDialog(this, "Class name already exists");
        } catch (PersistenceException e)
        {
            JOptionPane.showMessageDialog(this, "Class name already exists");
        } finally
        {
            this.insertBtn.setText("Insert");
            this.addAClassLbl.setText("Add new class");
            this.classNameTextField.setText("");
        }


    }

    public void searchBtnActionPerformed(java.awt.event.ActionEvent evt)
    {
        String keyword = searchTextField.getText();
        if (keyword == null)
        {
            JOptionPane.showMessageDialog(this, "Keyword is null cannot perform this action");
            return;
        }
        List<Class> resultClasses = service.searchClass(keyword);
        updateTableData(resultClasses);
    }


    @Override
    public void onCreateView()
    {
        initComponents();
        updateTableData();
    }

    public void updateTableData()
    {
        this.classList = AppContext.teachingManagerService.getClasses();
        classListTable
                .setModel(new ClassTableModel(this.classList));
    }


    public void updateTableData(List<Class> updatedClasses)
    {
        this.classList = updatedClasses;
        classListTable
                .setModel(new ClassTableModel(this.classList));
    }

    @Override
    public void addEventListener()
    {
        searchBtn.addActionListener(evt -> searchBtnActionPerformed(evt));
        classNameTextField.addActionListener(evt -> classNameTextFieldActionPerformed(evt));
        editBtn.addActionListener(evt -> editBtnActionPerformed(evt));
        insertBtn.addActionListener(evt -> insertBtnActionPerformed(evt));
        clearBtn.addActionListener(evt -> clearBtnActionPerformed(evt));
        deleteBtn.addActionListener(evt -> deleteBtnActionPerformed(evt));
    }
}
