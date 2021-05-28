/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ledungcobra.scenes;

import com.ledungcobra.anotations.BackButton;
import com.ledungcobra.applicationcontext.AppContext;
import com.ledungcobra.entites.CourseRegistrationSession;
import com.ledungcobra.entites.Semester;
import com.ledungcobra.model.AbsComboModel;
import com.ledungcobra.model.CourseRegistrationSessionTableModel;
import com.ledungcobra.service.TeachingManagerService;
import com.toedter.calendar.JDateChooser;
import jdk.nashorn.internal.scripts.JO;
import lombok.val;

import javax.persistence.criteria.Join;
import javax.swing.*;
import java.util.List;

public class CourseRegSessionManagementScreen extends Screen {
    // <editor-fold defaultstate="collapsed>
    @BackButton
    private javax.swing.JButton backBtn;
    private javax.swing.JButton clearBtn;
    private javax.swing.JButton insertBtn;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JButton searchBtn;
    private javax.swing.JTable courseRegSessionListTable;
    private JDateChooser startDateChooser;
    private JDateChooser endDateChooser;

    private TeachingManagerService service = AppContext.teachingManagerService;
    private List<CourseRegistrationSession> sessionList;

    // </editor-fold>
    @Override
    public void onCreateView() {
        initComponents();
        val teachingManagerService = AppContext.teachingManagerService;
        courseRegSessionListTable.setModel(new CourseRegistrationSessionTableModel(
                teachingManagerService.getCourseRegistrationSessionList()
        ));

        updateTableData();
    }

    @Override
    public void addEventListener() {
        clearBtn.addActionListener(evt -> clearBtnActionPerformed(evt));
        searchBtn.addActionListener(evt -> searchBtnActionPerformed(evt));
        insertBtn.addActionListener(evt -> insertBtnActionPerformed(evt));
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">
    private void initComponents() {

        JScrollPane jScrollPane2 = new JScrollPane();
        JTextArea jTextArea1 = new JTextArea();
        backBtn = new javax.swing.JButton();
        jTextField1 = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        searchBtn = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        courseRegSessionListTable = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        insertBtn = new javax.swing.JButton();
        clearBtn = new javax.swing.JButton();
        startDateChooser = new com.toedter.calendar.JDateChooser();
        endDateChooser = new com.toedter.calendar.JDateChooser();

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane2.setViewportView(jTextArea1);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        backBtn.setText("Back");

        jLabel1.setText("Keyword");

        searchBtn.setText("Search");

        jScrollPane1.setViewportView(courseRegSessionListTable);
        if (courseRegSessionListTable.getColumnModel().getColumnCount() > 0) {
            courseRegSessionListTable.getColumnModel().getColumn(0).setHeaderValue("ID");
            courseRegSessionListTable.getColumnModel().getColumn(1).setHeaderValue("Start Date");
            courseRegSessionListTable.getColumnModel().getColumn(2).setHeaderValue("End Date");
            courseRegSessionListTable.getColumnModel().getColumn(3).setHeaderValue("Semester");
        }

        jLabel2.setText("Start Date");

        jLabel3.setFont(new java.awt.Font("Tahoma", 3, 14)); // NOI18N
        jLabel3.setText("Add new course registration session");

        jLabel4.setText("End Date");

        insertBtn.setText("Insert");


        clearBtn.setText("Clear");


        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addComponent(jLabel1)
                                                .addGap(19, 19, 19)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                                                                .addGap(85, 85, 85))
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                                                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 861, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                                        .addComponent(jLabel2)
                                                                                        .addComponent(jLabel4))
                                                                                .addGap(134, 134, 134)
                                                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                                        .addComponent(startDateChooser, javax.swing.GroupLayout.DEFAULT_SIZE, 687, Short.MAX_VALUE)
                                                                                        .addComponent(endDateChooser, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                                                        .addGroup(layout.createSequentialGroup()
                                                                                .addComponent(clearBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                .addGap(18, 18, 18)
                                                                                .addComponent(insertBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                        .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 354, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 25, Short.MAX_VALUE)
                                                                .addComponent(searchBtn))))
                                        .addGroup(layout.createSequentialGroup()
                                                .addComponent(backBtn)
                                                .addGap(0, 0, Short.MAX_VALUE)))
                                .addContainerGap())
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(backBtn)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                        .addComponent(jLabel1)
                                                                        .addComponent(searchBtn))
                                                                .addGap(20, 20, 20)
                                                                .addComponent(jLabel3)
                                                                .addGap(18, 18, 18)
                                                                .addComponent(jLabel2))
                                                        .addComponent(startDateChooser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(jLabel4))
                                        .addComponent(endDateChooser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(21, 21, 21)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(insertBtn)
                                        .addComponent(clearBtn))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 348, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(70, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>

    private void clearBtnActionPerformed(java.awt.event.ActionEvent evt) {
        this.startDateChooser.setDate(null);
        this.endDateChooser.setDate(null);
    }

    private void insertBtnActionPerformed(java.awt.event.ActionEvent evt) {
        val startDate = startDateChooser.getDate();
        val endDate = endDateChooser.getDate();

        if (startDate == null) {
            JOptionPane.showMessageDialog(this, "You have to choose start date to continue");
            return;
        }
        if (endDate == null) {
            JOptionPane.showMessageDialog(this, "You have to choose end date to continue");
            return;
        }

        if (startDate.after(endDate)) {
            JOptionPane.showMessageDialog(this, "The start date can not after the end date");
            return;
        }

        try {
            service.addCourseRegistrationSession(new CourseRegistrationSession(startDate, endDate));
            updateTableData();
        } catch (Exception e) {
            if (e.getCause() != null) {
                JOptionPane.showMessageDialog(this, e.getCause().getMessage());
            } else {
                JOptionPane.showMessageDialog(this, e.getMessage());
            }
        }
    }

    private void searchBtnActionPerformed(java.awt.event.ActionEvent evt) {

    }

    public void updateTableData() {
        this.sessionList = service.getCourseRegistrationSessionList();
        this.courseRegSessionListTable.setModel(new CourseRegistrationSessionTableModel(sessionList));
    }


}
