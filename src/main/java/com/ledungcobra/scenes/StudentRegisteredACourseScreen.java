/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ledungcobra.scenes;

import com.ledungcobra.anotations.BackButton;
import com.ledungcobra.anotations.SearchTextField;
import com.ledungcobra.applicationcontext.AppContext;
import com.ledungcobra.entites.*;
import com.ledungcobra.interfaces.Searchable;
import com.ledungcobra.model.AbsComboModel;
import com.ledungcobra.model.StudentRegCourseTableModel;
import com.ledungcobra.service.TeachingManagerService;
import lombok.val;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.lang.Class;
import java.util.List;

/**
 * @author ledun
 */
public class StudentRegisteredACourseScreen extends Screen implements Searchable {


    // <editor-fold defaultstate="collapsed desc="Class fields">
    @BackButton
    private javax.swing.JButton backBtn;
    private javax.swing.JComboBox<CourseInfo> courseComboBox;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton searchBtn;

    @SearchTextField
    private javax.swing.JTextField searchTextField;
    private javax.swing.JTable studentInCourseTable;

    private TeachingManagerService service = AppContext.teachingManagerService;
    private List<StudentAccount> students;
    // End of variables declaration

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        studentInCourseTable = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        backBtn = new javax.swing.JButton();
        courseComboBox = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        searchTextField = new javax.swing.JTextField();
        searchBtn = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        studentInCourseTable.setModel(new javax.swing.table.DefaultTableModel(
                new Object[][]{

                },
                new String[]{
                        "Student ID", "Full name", "Subject ID", "Subject name", "Theory Teacher Name", "Time", "Registerd Time"
                }
        ) {
            Class[] types = new Class[]{
                    java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean[]{
                    false, false, false, false, true, false, true
            };

            public Class getColumnClass(int columnIndex) {
                return types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit[columnIndex];
            }
        });
        jScrollPane1.setViewportView(studentInCourseTable);

        jLabel1.setText("Course");

        backBtn.setText("Back");

        jLabel2.setText("Keyword");

        searchBtn.setText("Search");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(20, 20, 20)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addComponent(jLabel2)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(searchTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 850, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(searchBtn))
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                .addComponent(backBtn)
                                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 999, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGroup(layout.createSequentialGroup()
                                                        .addComponent(jLabel1)
                                                        .addGap(18, 18, 18)
                                                        .addComponent(courseComboBox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                                .addContainerGap(21, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(backBtn)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 17, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                .addComponent(searchTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(searchBtn)))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel1)
                                        .addComponent(courseComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(42, 42, 42)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 306, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap())
        );

        pack();
    }// </editor-fold>


    @Override
    public void onCreateView() {
        initComponents();
        setUpComboBoxes();
    }

    @Override
    public void addEventListener() {
        searchBtn.addActionListener(e -> searchBtnActionPerformed(e));
        courseComboBox.addItemListener(e -> {
            updateTableData();
        });

    }

    private void setUpComboBoxes() {
        val courses = service.getCourseInfos();
        this.courseComboBox.setModel(new AbsComboModel<CourseInfo>(courses) {
        });
    }

    private void updateTableData() {
        CourseInfo courseInfo = (CourseInfo) this.courseComboBox.getSelectedItem();
        if (courseInfo == null) return;
        Semester activeSemester = service.getActiveSemester();
        List<StudentCourse> studentCourseList = service.getStudentCourseListRegisteredACourseInfo(courseInfo, activeSemester);
        this.studentInCourseTable.setModel(new StudentRegCourseTableModel(studentCourseList));
    }

    @Override
    public void searchBtnActionPerformed(ActionEvent evt) {

        val keyword = searchTextField.getText();
        CourseInfo courseInfo = (CourseInfo) this.courseComboBox.getSelectedItem();

        if (courseInfo == null) {
            JOptionPane.showMessageDialog(this, "There are no course selected");
            return;
        }
        val activeSemester = service.getActiveSemester();
        this.students = service.searchStudentRegACourse(keyword, courseInfo, activeSemester);
        updateTableData();
        
    }
}
