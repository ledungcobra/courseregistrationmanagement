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
import com.ledungcobra.entites.EducationType;
import com.ledungcobra.entites.StudentAccount;
import com.ledungcobra.interfaces.Searchable;
import com.ledungcobra.model.AbsComboModel;
import com.ledungcobra.model.ClassComboModel;
import com.ledungcobra.model.StudentTableModel;
import com.ledungcobra.service.TeachingManagerService;
import lombok.SneakyThrows;
import lombok.val;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.ledungcobra.scenes.StudentInfoDialog.STUDENT_INFO;

/**
 * @author ledun
 */
public class StudentManagementScreen extends Screen implements Searchable {

    // <editor-fold defaultstate="collapsed desc="Class Fields">
    @BackButton
    private javax.swing.JButton backBtn;
    private javax.swing.JComboBox<Class> classNameCombobox;

    private javax.swing.JComboBox<Class> classSearchCombobox;
    private javax.swing.JButton clearBtn;
    private javax.swing.JButton deleteBtn;
    private javax.swing.JButton editBtn;
    private javax.swing.JButton insertBtn;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton resetPasswordBtn;
    private javax.swing.JButton searchBtn;

    @SearchTextField
    private javax.swing.JTextField searchStudentTextField;
    private javax.swing.JTextField studentIdTextField;
    private javax.swing.JTable studentListTable;

    private TeachingManagerService service;
    private List<StudentAccount> studentAccounts;
    private Class selectedClass;
    private StudentAccount currentEdittingStudent;
    private JComboBox<EducationType> educationTypeComboBox;
    private JTextField identityCardNumberTextField;
    private JTextField passwordTextField;

    public static final String IDENTITY_NUMBER = "IDENTITY_NUMBER";


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">
    private void initComponents() {

        backBtn = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        studentListTable = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        studentIdTextField = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        editBtn = new javax.swing.JButton();
        insertBtn = new javax.swing.JButton();
        clearBtn = new javax.swing.JButton();
        deleteBtn = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        classNameCombobox = new javax.swing.JComboBox<>();
        classSearchCombobox = new javax.swing.JComboBox<>();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        searchStudentTextField = new javax.swing.JTextField();
        searchBtn = new javax.swing.JButton();
        resetPasswordBtn = new javax.swing.JButton();
        JLabel jLabel1 = new JLabel();
        educationTypeComboBox = new javax.swing.JComboBox<>();
        JLabel jLabel8 = new JLabel();
        identityCardNumberTextField = new javax.swing.JTextField();
        JLabel jLabel11 = new JLabel();
        passwordTextField = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        backBtn.setText("Back");


        jScrollPane1.setViewportView(studentListTable);

        jLabel2.setText("Student Card ID");

        jLabel3.setFont(new java.awt.Font("Tahoma", 3, 14)); // NOI18N
        jLabel3.setText("Add new student account");

        jLabel5.setText("Class name");

        jLabel6.setFont(new java.awt.Font("Tahoma", 3, 14)); // NOI18N
        jLabel6.setText("Manage student in class");

        editBtn.setText("Edit");

        insertBtn.setText("Insert");

        clearBtn.setText("Clear");

        deleteBtn.setBackground(new java.awt.Color(255, 51, 51));
        deleteBtn.setText("Delete");

        jLabel7.setFont(new java.awt.Font("Tahoma", 3, 14)); // NOI18N
        jLabel7.setText("Find all student in class");


        jLabel12.setText("Class name");

        jLabel13.setText("Keyword");

        searchBtn.setText("Search");

        resetPasswordBtn.setText("Reset password");

        jLabel1.setText("Eudcation type");


        jLabel8.setText("Identity card number");

        jLabel11.setText("Password");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(backBtn, javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                                .addGap(62, 62, 62)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 241, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(jLabel13)
                                                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(jScrollPane1)
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addComponent(jLabel12)
                                                                .addGap(18, 18, 18)
                                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                        .addComponent(classSearchCombobox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                                        .addGroup(layout.createSequentialGroup()
                                                                                .addComponent(searchStudentTextField)
                                                                                .addGap(18, 18, 18)
                                                                                .addComponent(searchBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                                .addComponent(resetPasswordBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addGap(18, 18, 18)
                                                                .addComponent(editBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addGap(18, 18, 18)
                                                                .addComponent(deleteBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                        .addComponent(jLabel2)
                                                                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                        .addComponent(jLabel5)
                                                                        .addComponent(jLabel1)
                                                                        .addComponent(jLabel8)
                                                                        .addComponent(jLabel11))
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                        .addComponent(studentIdTextField)
                                                                        .addComponent(classNameCombobox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                                        .addComponent(educationTypeComboBox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                                        .addComponent(identityCardNumberTextField)
                                                                        .addComponent(passwordTextField)))))
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(0, 793, Short.MAX_VALUE)
                                                .addComponent(clearBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(insertBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(60, 60, 60))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(backBtn)
                                .addGap(25, 25, 25)
                                .addComponent(jLabel3)
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(jLabel2)
                                                        .addComponent(studentIdTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(jLabel11))
                                        .addComponent(passwordTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel5)
                                        .addComponent(classNameCombobox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel1)
                                        .addComponent(educationTypeComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel8)
                                        .addComponent(identityCardNumberTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(clearBtn)
                                        .addComponent(insertBtn))
                                .addGap(18, 18, Short.MAX_VALUE)
                                .addComponent(jLabel7)
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel13)
                                        .addComponent(searchStudentTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(searchBtn))
                                .addGap(34, 34, 34)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(classSearchCombobox, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel12, javax.swing.GroupLayout.Alignment.TRAILING))
                                .addGap(18, 18, 18)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel6)
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(editBtn)
                                        .addComponent(deleteBtn)
                                        .addComponent(resetPasswordBtn))
                                .addGap(18, 18, 18))
        );

        pack();
    }// </editor-fold>


    private void deleteBtnActionPerformed(java.awt.event.ActionEvent evt) {

        val selectedIndex = this.studentListTable.getSelectedRow();

        if (selectedIndex == -1) {
            JOptionPane.showMessageDialog(this, "You must select a row to delete a student");
            return;
        }

        int result = JOptionPane.showConfirmDialog(this, "Do you want to delete this student account", "Confirm", JOptionPane.YES_NO_OPTION);

        if (result == JOptionPane.YES_OPTION) {
            service.deleteStudent(this.studentAccounts.get(selectedIndex));
            updateTableData();
        }
    }

    // <editor-fold defaultstate="collapsed desc="Update table data">
    private void updateTableData() {

        if (this.selectedClass == null) {
            JOptionPane.showMessageDialog(this, "You must select a class to continue");
            return;
        }

        this.studentAccounts = service.getListStudentInClass(this.selectedClass);
        this.studentListTable.setModel(new StudentTableModel(studentAccounts));

    }
    // </editor-fold>

    private void updateTableData(List<StudentAccount> studentAccounts) {
        this.studentAccounts = studentAccounts;
        this.studentListTable.setModel(new StudentTableModel(studentAccounts));
    }

    private void editBtnActionPerformed(java.awt.event.ActionEvent evt) {
        int selectedIndex = this.studentListTable.getSelectedRow();

        if (selectedIndex == -1) {
            JOptionPane.showMessageDialog(this, "You must select a record to perform this action");
            return;
        }

        this.currentEdittingStudent = this.studentAccounts.get(selectedIndex);
        this.studentIdTextField.setText(this.currentEdittingStudent.getStudentCardId());
        this.classNameCombobox.setSelectedItem(this.currentEdittingStudent.getStudiedClass());
        this.passwordTextField.setText(this.currentEdittingStudent.getPassword());
        this.educationTypeComboBox.setSelectedItem(this.currentEdittingStudent.getEducationType());
        this.identityCardNumberTextField.setText(this.currentEdittingStudent.getStudentInfo().getIdentityCardNumber());

        this.jLabel3.setText("Edit a student account");
        this.insertBtn.setText("Update");


    }

    private void clearBtnActionPerformed(java.awt.event.ActionEvent evt) {

        this.jLabel3.setText("Add new student account");
        this.insertBtn.setText("Insert");

        this.currentEdittingStudent = null;
        this.studentIdTextField.setText("");

        if (this.classNameCombobox.getSelectedItem() != null) {
            this.classNameCombobox.setSelectedIndex(0);
        } else {
            this.classNameCombobox.setSelectedItem(null);
        }


        this.passwordTextField.setText("");

        if (this.educationTypeComboBox.getSelectedItem() != null) {
            this.educationTypeComboBox.setSelectedIndex(0);
        } else {
            this.educationTypeComboBox.setSelectedItem(null);
        }

        this.identityCardNumberTextField.setText("");

    }


    @SneakyThrows
    private void insertBtnActionPerformed(java.awt.event.ActionEvent evt) {

        val studentCardId = this.studentIdTextField.getText();
        val password = this.passwordTextField.getText();
        val clazz = (Class) this.classNameCombobox.getSelectedItem();
        val educationType = (EducationType) educationTypeComboBox.getSelectedItem();
        val identityCardNumber = identityCardNumberTextField.getText();

        if (studentCardId == null || "".equals(studentCardId)) {
            JOptionPane.showMessageDialog(this, "You have to enter student card id to continue");
            return;
        }

        if (password == null || "".equals(password)) {
            JOptionPane.showMessageDialog(this, "You have to enter password to continue");
            return;
        }

        if (clazz == null) {
            JOptionPane.showMessageDialog(this, "You have to select a class to continue");
            return;
        }

        if (educationType == null) {
            JOptionPane.showMessageDialog(this, "You have to select education type to continue");
            return;
        }

        if (identityCardNumber == null || "".equals(identityCardNumber)) {
            JOptionPane.showMessageDialog(this, "You have to enter identity card to continue");
            return;

        }


        val data = new HashMap<String, Object>();
        data.put(IDENTITY_NUMBER, identityCardNumber);
        data.put(StudentManagementScreen.class.getSimpleName(), StudentManagementScreen.this);
        StudentInfoDialog dialog = new StudentInfoDialog(data, (studentInfo) -> {

            try {

                if (currentEdittingStudent == null) {
                    service.addStudentToClass(new StudentAccount(password, studentCardId, studentInfo, educationType, clazz), clazz);
                } else {
                    this.currentEdittingStudent.setStudentInfo(studentInfo);
                    this.currentEdittingStudent.setStudentCardId(studentCardId);
                    this.currentEdittingStudent.setPassword(password);

                    if (!this.currentEdittingStudent.getStudiedClass().equals(clazz)) {
                        this.currentEdittingStudent.getStudiedClass().getStudents().remove(this.currentEdittingStudent);
                        this.currentEdittingStudent.setStudiedClass(clazz);
                    }

                    this.currentEdittingStudent.setEducationType(educationType);
                    service.updateStudent(this.currentEdittingStudent);
                }
                updateTableData();

                this.getData().remove(StudentInfoDialog.class.getSimpleName());
                this.getData().remove(STUDENT_INFO);

            } catch (Exception e) {

                if (e.getCause().toString().contains("UK_STUDENT_ACCOUNT")) {
                    JOptionPane.showMessageDialog(this, "One student can only learn in an education type");
                } else {
                    JOptionPane.showMessageDialog(this, e.getCause().toString());
                }

                e.printStackTrace();
            } finally {
                this.currentEdittingStudent = null;
                this.jLabel3.setText("Add new student account");
                this.insertBtn.setText("Insert");
            }
        });

        dialog.setVisible(true);
    }

    @Override
    public void onCreateView() {
        initComponents();

        service = AppContext.teachingManagerService;
        val classes = service.getClasses();
        this.classSearchCombobox.setModel(new ClassComboModel(classes));
        this.classNameCombobox.setModel(new ClassComboModel(classes));

        setDataComboBoxes();
        updateTableData();
    }

    private void setDataComboBoxes() {

        val educationTypes = service.getEducationTypes();
        val classes = service.getClasses();
        if (classes.size() > 0) {
            this.selectedClass = classes.get(0);
        }
        this.educationTypeComboBox.setModel(new AbsComboModel<EducationType>(educationTypes) {
        });
        this.classNameCombobox.setModel(new ClassComboModel(classes));
        this.classSearchCombobox.setModel(new ClassComboModel(classes));
    }


    private void resetPasswordBtnPerformed() {

        int selectedIndex = this.studentListTable.getSelectedRow();

        if (selectedIndex == -1) {
            JOptionPane.showMessageDialog(this, "You must select a record to perform this action");
            return;
        }
        try {
            val selectedStudent = this.studentAccounts.get(selectedIndex);
            service.resetStudentPassword(selectedStudent);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Cannot reset password for this selected student account");
        }

    }


    @Override
    public void addEventListener() {
        editBtn.addActionListener(evt -> editBtnActionPerformed(evt));
        insertBtn.addActionListener(evt -> insertBtnActionPerformed(evt));
        clearBtn.addActionListener(evt -> clearBtnActionPerformed(evt));
        deleteBtn.addActionListener(evt -> deleteBtnActionPerformed(evt));
        classSearchCombobox.addActionListener(e -> {
            this.selectedClass = (Class) classSearchCombobox.getSelectedItem();
            updateTableData();
        });
        searchBtn.addActionListener(e -> searchBtnActionPerformed(e));
        resetPasswordBtn.addActionListener(e -> resetPasswordBtnPerformed());
        studentIdTextField.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {

            }

            @Override
            public void keyPressed(KeyEvent e) {

            }

            @Override
            public void keyReleased(KeyEvent e) {
                StudentManagementScreen.this.passwordTextField.setText(studentIdTextField.getText());
            }
        });
    }

    @Override
    public Map<String, Object> getData() {
        if (this.data == null) data = new HashMap<String, Object>();
        return this.data;
    }

    @Override
    public void searchBtnActionPerformed(ActionEvent evt) {
        val keyword = searchStudentTextField.getText();

        Class selectedSearchClass = (Class) classSearchCombobox.getSelectedItem();
        this.studentAccounts = service.searchStudent(selectedSearchClass, keyword);
        updateTableData(this.studentAccounts);
    }

}
