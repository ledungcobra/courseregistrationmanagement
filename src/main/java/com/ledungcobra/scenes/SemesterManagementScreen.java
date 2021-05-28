/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ledungcobra.scenes;

import com.ledungcobra.anotations.BackButton;
import com.ledungcobra.anotations.SearchTextField;
import com.ledungcobra.applicationcontext.AppContext;
import com.ledungcobra.entites.Semester;
import com.ledungcobra.interfaces.Searchable;
import com.ledungcobra.scenes.Screen;
import com.ledungcobra.model.SemesterTableModel;
import com.ledungcobra.service.TeachingManagerService;
import lombok.val;
import org.hibernate.exception.ConstraintViolationException;

import javax.persistence.PersistenceException;
import javax.swing.*;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import static com.ledungcobra.utils.Constants.SEMESTER;

/**
 * @author ledun
 */
public class SemesterManagementScreen extends Screen implements Searchable {

    // <editor-fold defaultstate="collapsed desc="Class fields">
    @BackButton
    private javax.swing.JButton backBtn;
    private javax.swing.JCheckBox activeCheckBox;
    private javax.swing.JButton clearBtn;
    private javax.swing.JButton deleteBtn;
    private javax.swing.JButton editBtn;
    private com.toedter.calendar.JDateChooser endDatePicker;
    private javax.swing.JButton insertBtn;
    private javax.swing.JButton setActiveBtn;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton searchBtn;

    @SearchTextField
    private javax.swing.JTextField searchTextField;
    private javax.swing.JTable semesterListTable;
    private javax.swing.JComboBox<String> semesterNameComboBox;
    private com.toedter.calendar.JDateChooser startDatePicker;
    private com.toedter.calendar.JYearChooser yearPicker;
    private TeachingManagerService service = AppContext.teachingManagerService;
    private List<Semester> semesterList;
    private Semester currentEditingSemester;
    // </editor-fold>

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">
    private void initComponents() {

        backBtn = new javax.swing.JButton();
        searchTextField = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        searchBtn = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        semesterListTable = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        editBtn = new javax.swing.JButton();
        insertBtn = new javax.swing.JButton();
        clearBtn = new javax.swing.JButton();
        deleteBtn = new javax.swing.JButton();
        setActiveBtn = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        activeCheckBox = new javax.swing.JCheckBox();
        jLabel9 = new javax.swing.JLabel();
        startDatePicker = new com.toedter.calendar.JDateChooser();
        endDatePicker = new com.toedter.calendar.JDateChooser();
        semesterNameComboBox = new javax.swing.JComboBox<>();
        yearPicker = new com.toedter.calendar.JYearChooser();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        backBtn.setText("Back");

        jLabel1.setText("Keyword");

        searchBtn.setText("Search");

        jScrollPane1.setViewportView(semesterListTable);
        if (semesterListTable.getColumnModel().getColumnCount() > 0) {
            semesterListTable.getColumnModel().getColumn(5).setResizable(false);
        }

        jLabel2.setText("Semester name");

        jLabel3.setFont(new java.awt.Font("Tahoma", 3, 14)); // NOI18N
        jLabel3.setText("Add new semester");

        jLabel5.setText("Start date");

        jLabel6.setFont(new java.awt.Font("Tahoma", 3, 14)); // NOI18N
        jLabel6.setText("Manage semester");

        editBtn.setText("Edit");

        insertBtn.setText("Insert");


        clearBtn.setText("Clear");


        deleteBtn.setBackground(new java.awt.Color(255, 51, 51));
        deleteBtn.setText("Delete");

        setActiveBtn.setText("Set Active");

        jLabel7.setText("End date");

        jLabel8.setText("Is Active");

        jLabel9.setText("Year");

        semesterNameComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[]{"Item 1", "Item 2", "Item 3", "Item 4"}));

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
                                                .addComponent(jLabel1)
                                                .addGap(19, 19, 19)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(searchTextField)
                                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                                        .addGroup(layout.createSequentialGroup()
                                                                                .addGap(0, 0, Short.MAX_VALUE)
                                                                                .addComponent(setActiveBtn)
                                                                                .addGap(18, 18, 18)
                                                                                .addComponent(editBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                                                .addComponent(deleteBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                        .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 870, Short.MAX_VALUE)
                                                                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                                        .addComponent(jLabel2)
                                                                                        .addComponent(jLabel5)
                                                                                        .addComponent(jLabel7)
                                                                                        .addComponent(jLabel9))
                                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                                        .addComponent(startDatePicker, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                                                        .addComponent(endDatePicker, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                                                        .addComponent(semesterNameComboBox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                                                        .addComponent(yearPicker, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                                                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                                        .addGroup(layout.createSequentialGroup()
                                                                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                                                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                                        .addGroup(layout.createSequentialGroup()
                                                                                                                .addComponent(jLabel8)
                                                                                                                .addGap(55, 55, 55)
                                                                                                                .addComponent(activeCheckBox)))
                                                                                                .addGap(0, 0, Short.MAX_VALUE))
                                                                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                                                                .addGap(0, 0, Short.MAX_VALUE)
                                                                                                .addComponent(clearBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                                                                .addGap(18, 18, 18)
                                                                                .addComponent(insertBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                                                .addGap(5, 5, 5)))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 8, Short.MAX_VALUE)
                                                .addComponent(searchBtn)))
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
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(searchTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(jLabel1)
                                                        .addComponent(searchBtn))
                                                .addGap(20, 20, 20)
                                                .addComponent(jLabel3)
                                                .addGap(18, 18, 18)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                        .addComponent(jLabel2)
                                                        .addComponent(semesterNameComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(startDatePicker, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addComponent(jLabel5))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(endDatePicker, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(yearPicker, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel9, javax.swing.GroupLayout.Alignment.TRAILING))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(activeCheckBox)
                                        .addComponent(jLabel8))
                                .addGap(12, 12, 12)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(clearBtn)
                                        .addComponent(insertBtn))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 52, Short.MAX_VALUE)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 213, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel6)
                                .addGap(2, 2, 2)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(setActiveBtn)
                                        .addComponent(editBtn)
                                        .addComponent(deleteBtn))
                                .addGap(59, 59, 59))
        );

        pack();
    }// </editor-fold>

    @Override
    public void onCreateView() {
        initComponents();
        updateTableData();
        semesterNameComboBox.setModel(new DefaultComboBoxModel<>(SEMESTER));
    }

    public void updateTableData() {
        this.semesterList = service.getSemesterList();
        semesterListTable.setModel(new SemesterTableModel(this.semesterList));
    }

    public void updateTableData(List<Semester> semesters) {
        this.semesterList = semesters;
        semesterListTable.setModel(new SemesterTableModel(semesters));
    }

    @Override
    public void addEventListener() {
        searchBtn.addActionListener(evt -> searchBtnActionPerformed(evt));
        editBtn.addActionListener(evt -> editBtnActionPerformed(evt));
        insertBtn.addActionListener(evt -> insertBtnActionPerformed(evt));
        clearBtn.addActionListener(evt -> clearBtnActionPerformed(evt));
        deleteBtn.addActionListener(evt -> deleteBtnActionPerformed(evt));
        setActiveBtn.addActionListener(e -> setActiveSemester());
    }

    private void setActiveSemester() {
        int selectedIndex = this.semesterListTable.getSelectedRow();

        if (selectedIndex == -1) {
            JOptionPane.showMessageDialog(this, "You must select a record to perform this action");
            return;
        }

        service.setSemesterAsActive(this.semesterList.get(selectedIndex));
        updateTableData();

    }


    private void deleteBtnActionPerformed(java.awt.event.ActionEvent evt) {

        int selectedIndex = this.semesterListTable.getSelectedRow();
        val selectedIndices = this.semesterListTable.getSelectedRows();

        if (selectedIndex == -1) {
            JOptionPane.showMessageDialog(this, "You must select a record to perform this action");
            return;
        }
        if (selectedIndices.length == 1) {
            int result = JOptionPane.showConfirmDialog(this, "Do you want to delete this semester", "Confirm", JOptionPane.YES_NO_OPTION);

            if (result == JOptionPane.YES_OPTION) {
                val semester = this.semesterList.get(selectedIndex);
                service.deleteSemester(semester);
                updateTableData();
            }
        } else {
            int result = JOptionPane.showConfirmDialog(this, "Do you want to delete these semester", "Confirm", JOptionPane.YES_NO_OPTION);

            if (result == JOptionPane.YES_OPTION) {
                for (val index : selectedIndices) {
                    service.deleteSemester(this.semesterList.get(index));
                }
                updateTableData();
            }
        }
    }

    private void editBtnActionPerformed(java.awt.event.ActionEvent evt) {
        int selectedIndex = this.semesterListTable.getSelectedRow();

        if (selectedIndex == -1) {
            JOptionPane.showMessageDialog(this, "You must select a record to perform this action");
            return;
        }
        this.currentEditingSemester = this.semesterList.get(selectedIndex);

        this.semesterNameComboBox.setSelectedItem(this.currentEditingSemester.getSemesterName());


        this.startDatePicker.setDate(this.currentEditingSemester.getStartDate());
        this.endDatePicker.setDate(this.currentEditingSemester.getEndDate());
        this.yearPicker.setYear(this.currentEditingSemester.getYear());
        this.activeCheckBox.setSelected(this.currentEditingSemester.getActive());

        this.jLabel3.setText("Edit a semester");
        this.insertBtn.setText("Update");

    }

    private void clearBtnActionPerformed(java.awt.event.ActionEvent evt) {
        this.semesterNameComboBox.setSelectedIndex(0);
        this.startDatePicker.setDate(null);
        this.endDatePicker.setDate(null);
        this.yearPicker.setYear(new Date().getYear());
        this.activeCheckBox.setSelected(false);
        this.currentEditingSemester = null;

    }

    private void insertBtnActionPerformed(java.awt.event.ActionEvent evt) {

        val startDate = this.startDatePicker.getDate();
        val endDate = this.endDatePicker.getDate();
        val year = this.yearPicker.getYear();
        if (startDate == null || endDate == null) {
            JOptionPane.showMessageDialog(this, "You must select date to continue");
            return;
        }
        if (startDate.after(endDate)) {
            JOptionPane.showMessageDialog(this, "The end date must be followed by start date");
            return;
        }

        if (startDate == null) {
            JOptionPane.showMessageDialog(this, "You must choose start date to continue");
            return;
        }

        if (endDate == null) {
            JOptionPane.showMessageDialog(this, "You must choose end date to continue");
            return;
        }

        try {

            if (currentEditingSemester == null) {
                service.addNewSemester(new Semester((String) semesterNameComboBox.getSelectedItem(), year, startDate, endDate, activeCheckBox.isSelected()));
            } else {
                this.currentEditingSemester.setActive(this.activeCheckBox.isSelected());
                this.currentEditingSemester.setStartDate(startDate);
                this.currentEditingSemester.setEndDate(endDate);
                this.currentEditingSemester.setYear(year);
                this.currentEditingSemester.setSemesterName((String) semesterNameComboBox.getSelectedItem());
                service.updateSemester(this.currentEditingSemester);
            }
            updateTableData();

        } catch (ConstraintViolationException e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
        } catch (PersistenceException e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
        } finally {
            this.currentEditingSemester = null;
            this.jLabel3.setText("Add new semester");
            this.insertBtn.setText("Insert");
        }
    }

    @Override
    public void searchBtnActionPerformed(java.awt.event.ActionEvent evt) {
        val keyword = searchTextField.getText();
        if ("".equals(keyword)) {
            JOptionPane.showMessageDialog(this, "You must enter some thing to search");
            return;
        }
        val semesters = service.searchSemester(searchTextField.getText());
        updateTableData(semesters);

    }

}
