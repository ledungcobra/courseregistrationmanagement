/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ledungcobra.scenes;

import com.ledungcobra.anotations.BackButton;
import com.ledungcobra.anotations.SearchTextField;
import com.ledungcobra.applicationcontext.AppContext;
import com.ledungcobra.entites.Course;
import com.ledungcobra.entites.CourseInfo;
import com.ledungcobra.entites.Semester;
import com.ledungcobra.entites.Subject;
import com.ledungcobra.interfaces.Searchable;
import com.ledungcobra.models.AbsComboModel;
import com.ledungcobra.models.CourseTableModel;
import com.ledungcobra.models.SubjectComboModel;
import com.ledungcobra.services.TeachingManagerService;
import lombok.val;
import org.hibernate.exception.ConstraintViolationException;

import javax.persistence.PersistenceException;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.util.List;

import static com.ledungcobra.utils.Constants.DAY_IN_WEEK;
import static com.ledungcobra.utils.Constants.SHIFTS_IN_DAY;

/**
 * @author ledun
 */
public class CourseManagementScreen extends Screen implements Searchable
{

    // <editor-fold defaultstate="collapsed>

    @BackButton
    private javax.swing.JButton backBtn;
    private javax.swing.JTextField classRoomNameTextField;
    private javax.swing.JButton clearBtn;
    private javax.swing.JTable courseListTable;
    private javax.swing.JComboBox<String> dayToStudyInWeekCombobox;
    private javax.swing.JButton deleteBtn;
    private javax.swing.JButton editBtn;
    private javax.swing.JButton insertBtn;
    private javax.swing.JButton addACourseInfoBtn;
    private javax.swing.JComboBox<CourseInfo> courseInfoComboBox;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField numberOfSlotTextField;
    private javax.swing.JButton searchBtn;
    private javax.swing.JButton removeCourseInfoBtn;

    @SearchTextField
    private javax.swing.JTextField searchTextField;
    private javax.swing.JComboBox<String> shiftToStudyInDay;
    private javax.swing.JComboBox<Subject> subjectCombobox;
    private javax.swing.JTextField theoryTeacherNameTextField;

    // Custom code
    private List<Course> courseList;
    private Course editingCourse;
    private Semester activeSemester;

    private TeachingManagerService service = AppContext.teachingManagerService;
    private JLayeredPane jLayeredPane1;
    private JPanel jPanel1;
    private JPanel jPanel2;
    private JPanel jPanel3;

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">
    private void initComponents()
    {


        backBtn = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        courseListTable = new javax.swing.JTable();
        jLabel7 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        theoryTeacherNameTextField = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        dayToStudyInWeekCombobox = new javax.swing.JComboBox<>();
        jLabel9 = new javax.swing.JLabel();
        classRoomNameTextField = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        shiftToStudyInDay = new javax.swing.JComboBox<>();
        jLabel11 = new javax.swing.JLabel();
        numberOfSlotTextField = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        courseInfoComboBox = new javax.swing.JComboBox<>();
        removeCourseInfoBtn = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        editBtn = new javax.swing.JButton();
        deleteBtn = new javax.swing.JButton();
        jLayeredPane1 = new javax.swing.JLayeredPane();
        clearBtn = new javax.swing.JButton();
        insertBtn = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        searchBtn = new javax.swing.JButton();
        searchTextField = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        subjectCombobox = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        addACourseInfoBtn = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        backBtn.setText("Back");


        jScrollPane1.setViewportView(courseListTable);

        jLabel7.setFont(new java.awt.Font("Tahoma", 3, 14)); // NOI18N
        jLabel7.setText("Opened courses in this season");

        jLabel1.setText("Theory teacher name");

        jLabel8.setText("Day to study in week");


        jLabel9.setText("Class room name");

        jLabel10.setText("Shift to study in day");

        jLabel11.setText("Number of slot");

        jLabel2.setText("Course info");


        removeCourseInfoBtn.setText("Remove course info");

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Manage Course", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 3, 14))); // NOI18N

        editBtn.setText("Edit");

        deleteBtn.setBackground(new java.awt.Color(255, 51, 51));
        deleteBtn.setText("Delete");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(editBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(deleteBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(editBtn)
                                        .addComponent(deleteBtn))
                                .addContainerGap())
        );

        jLayeredPane1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Actions", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 3, 14))); // NOI18N

        clearBtn.setText("Clear");

        insertBtn.setText("Insert");

        jLayeredPane1.setLayer(clearBtn, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(insertBtn, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout jLayeredPane1Layout = new javax.swing.GroupLayout(jLayeredPane1);
        jLayeredPane1.setLayout(jLayeredPane1Layout);
        jLayeredPane1Layout.setHorizontalGroup(
                jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jLayeredPane1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(clearBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(insertBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap())
        );
        jLayeredPane1Layout.setVerticalGroup(
                jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jLayeredPane1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(clearBtn)
                                        .addComponent(insertBtn))
                                .addContainerGap())
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Search", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 3, 14))); // NOI18N

        searchBtn.setText("Search");

        jLabel12.setText("Keyword");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
                jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel12)
                                .addGap(18, 18, 18)
                                .addComponent(searchTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 696, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(searchBtn)
                                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
                jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                .addComponent(searchTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(searchBtn))
                                        .addComponent(jLabel12, javax.swing.GroupLayout.Alignment.TRAILING))
                                .addContainerGap())
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createTitledBorder("Add Course Info"), "Add Course Info", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 3, 14))); // NOI18N

        jLabel4.setText("Subject");

        addACourseInfoBtn.setText("Add a course info");


        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
                jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addGroup(jPanel3Layout.createSequentialGroup()
                                                .addGap(0, 0, Short.MAX_VALUE)
                                                .addComponent(addACourseInfoBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(jPanel3Layout.createSequentialGroup()
                                                .addComponent(jLabel4)
                                                .addGap(18, 18, 18)
                                                .addComponent(subjectCombobox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
                jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(21, 21, 21)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(subjectCombobox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel4))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(addACourseInfoBtn)
                                .addContainerGap())
        );

        jLabel3.setFont(new java.awt.Font("Tahoma", 3, 14)); // NOI18N
        jLabel3.setText("Add new course");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(45, 45, 45))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(jLayeredPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(59, 59, 59)
                                                .addComponent(jScrollPane1)))
                                .addGap(43, 43, 43))
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addComponent(backBtn)
                                                .addGap(20, 20, 20))
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addGap(53, 53, 53)
                                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                        .addGroup(layout.createSequentialGroup()
                                                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                                        .addComponent(jLabel8)
                                                                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                                                                                .addComponent(jLabel9, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                                                                .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.LEADING))
                                                                                        .addComponent(jLabel10)
                                                                                        .addComponent(jLabel11)
                                                                                        .addComponent(jLabel2))
                                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                                                        .addComponent(dayToStudyInWeekCombobox, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                                                        .addComponent(shiftToStudyInDay, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                                                        .addComponent(classRoomNameTextField, javax.swing.GroupLayout.Alignment.LEADING)
                                                                                        .addComponent(theoryTeacherNameTextField)
                                                                                        .addComponent(numberOfSlotTextField, javax.swing.GroupLayout.Alignment.LEADING)
                                                                                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                                                                                .addComponent(courseInfoComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 602, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                                .addGap(11, 11, 11)
                                                                                                .addComponent(removeCourseInfoBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                                                                        .addGroup(layout.createSequentialGroup()
                                                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 241, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                                .addGap(0, 0, Short.MAX_VALUE))))
                                                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                                                .addGap(58, 58, 58)
                                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                        .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                                        .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                                                .addGap(43, 43, 43))))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(backBtn)
                                .addGap(18, 18, 18)
                                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(17, 17, 17)
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel2)
                                        .addComponent(courseInfoComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(removeCourseInfoBtn))
                                .addGap(19, 19, 19)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel1)
                                        .addComponent(theoryTeacherNameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel8)
                                        .addComponent(dayToStudyInWeekCombobox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel9)
                                        .addComponent(classRoomNameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel10)
                                        .addComponent(shiftToStudyInDay, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel11)
                                        .addComponent(numberOfSlotTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLayeredPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel7)
                                .addGap(13, 13, 13)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap())
        );

        pack();
    }// </editor-fold>

    private void deleteBtnActionPerformed(java.awt.event.ActionEvent evt)
    {

        int selectedIndex = this.courseListTable.getSelectedRow();
        val selectedIndices = this.courseListTable.getSelectedRows();

        if (selectedIndex == -1)
        {
            JOptionPane.showMessageDialog(this, "You must select a record to perform this action");
            return;
        }

        try
        {
            if (selectedIndices.length == 1)
            {
                int result = JOptionPane.showConfirmDialog(this, "Do you want to delete this course", "Confirm", JOptionPane.YES_NO_OPTION);
                if (result == JOptionPane.YES_OPTION)
                {
                    val course = this.courseList.get(selectedIndex);
                    service.deleteCourse(course);
                    updateTableData();

                }
            } else
            {
                int result = JOptionPane.showConfirmDialog(this, "Do you want to delete these courses", "Confirm", JOptionPane.YES_NO_OPTION);

                if (result == JOptionPane.YES_OPTION)
                {

                    for (val index : selectedIndices)
                    {

                        service.deleteCourse(this.courseList.get(index));
                        updateTableData();
                    }
                }
            }

        } catch (Exception exception)
        {
            JOptionPane.showMessageDialog(this, "An error occur when delete this course");
        }
    }

    private void editBtnActionPerformed(java.awt.event.ActionEvent evt)
    {

        int selectedIndex = this.courseListTable.getSelectedRow();

        if (selectedIndex == -1)
        {
            JOptionPane.showMessageDialog(this, "You must select a record to perform this action");
        }
        this.editingCourse = this.courseList.get(selectedIndex);

        this.subjectCombobox.setSelectedItem(this.editingCourse.getSubject());
        this.theoryTeacherNameTextField.setText(this.editingCourse.getTeacherName());
        this.dayToStudyInWeekCombobox.setSelectedItem(this.editingCourse.getDayToStudyInWeek());
        this.classRoomNameTextField.setText(this.editingCourse.getClassroomName());
        this.shiftToStudyInDay.setSelectedItem(this.editingCourse.getShiftToStudyInDay());
        this.numberOfSlotTextField.setText(this.editingCourse.getNumberOfSlot().toString());

        this.jLabel3.setText("Edit a semester");
        this.insertBtn.setText("Update");
    }

    private void clearBtnActionPerformed(java.awt.event.ActionEvent evt)
    {

        this.subjectCombobox.setSelectedItem(null);
        this.theoryTeacherNameTextField.setText("");
        this.dayToStudyInWeekCombobox.setSelectedItem(null);
        this.classRoomNameTextField.setText("");
        this.shiftToStudyInDay.setSelectedItem(null);
        this.numberOfSlotTextField.setText("");

    }

    private void loadDataForComboBoxes()
    {
        try
        {
            subjectCombobox.setModel(new SubjectComboModel(service.getSubjectList()));
            dayToStudyInWeekCombobox.setModel(new DefaultComboBoxModel<>(DAY_IN_WEEK));
            shiftToStudyInDay.setModel(new DefaultComboBoxModel<>(SHIFTS_IN_DAY));
            populateCourseInfoComboBox();
        } catch (Exception e)
        {
            JOptionPane.showMessageDialog(null, "You haven't set a semester as active semester yet");
        }


    }

    private void populateCourseInfoComboBox()
    {
        val courseInfos = service.getCourseInfos();
        courseInfoComboBox.setModel(new AbsComboModel<CourseInfo>(courseInfos)
        {
        });
        courseInfoComboBox.setSelectedIndex(courseInfos.size() - 1);
    }

    private void insertBtnActionPerformed(java.awt.event.ActionEvent evt)
    {

        CourseInfo courseInfo = (CourseInfo) courseInfoComboBox.getSelectedItem();
        val theoryTeacherName = theoryTeacherNameTextField.getText();
        String dayToStudyInWeek = (String) dayToStudyInWeekCombobox.getSelectedItem();
        val classRoomName = classRoomNameTextField.getText();
        String shiftToStudyInDay = (String) this.shiftToStudyInDay.getSelectedItem();
        String numberOfSlot = numberOfSlotTextField.getText();


        if (this.activeSemester == null)
        {
            JOptionPane.showMessageDialog(this, "There is no active semester go back latter");
            return;
        }


        if (courseInfo == null)
        {
            JOptionPane.showMessageDialog(this, "You have to select a course info to continue");
            return;
        }

        if ("".equals(theoryTeacherName))
        {
            JOptionPane.showMessageDialog(this, "You have to enter teacher name to continue");
            return;
        }

        if (dayToStudyInWeek == null || "".equals(dayToStudyInWeek))
        {
            JOptionPane.showMessageDialog(this, "You have to choose teacher name to continue");
            return;
        }

        if ("".equals(classRoomName))
        {
            JOptionPane.showMessageDialog(this, "You have to enter class room name to continue");
            return;
        }

        if (shiftToStudyInDay == null || "".equals(shiftToStudyInDay))
        {
            JOptionPane.showMessageDialog(this, "You have to enter class room name to continue");
            return;
        }

        if (!numberOfSlot.matches("\\d+"))
        {
            JOptionPane.showMessageDialog(this, "The number of slot must be a number");
            return;
        }

        try
        {

            if (this.editingCourse == null)
            {
                val course = new Course(courseInfo, theoryTeacherName, dayToStudyInWeek, classRoomName, shiftToStudyInDay,
                        Integer.parseInt(numberOfSlot));
                service.addNewCourse(course);

            } else
            {

                this.editingCourse.setTeacherName(theoryTeacherName);
                this.editingCourse.setDayToStudyInWeek(dayToStudyInWeek);
                this.editingCourse.setShiftToStudyInDay(shiftToStudyInDay);
                this.editingCourse.setNumberOfSlot(Integer.parseInt(numberOfSlot));

                service.updateCourse(this.editingCourse);
            }
            updateTableData();

        } catch (ConstraintViolationException e)
        {
            JOptionPane.showMessageDialog(this, e.getMessage());
        } catch (PersistenceException e)
        {
            JOptionPane.showMessageDialog(this, e.getMessage());
        } catch (Exception e)
        {
            JOptionPane.showMessageDialog(this, e.getMessage());
        } finally
        {
            this.editingCourse = null;
            this.jLabel3.setText("Add new course");
            this.insertBtn.setText("Insert");
        }


    }

    @Override
    public void onCreateView()
    {
        initComponents();
        updateTableData();
        activeSemester = service.getActiveSemester();
        loadDataForComboBoxes();

    }

    private void updateTableData()
    {
        this.courseList = service.getCourseListInActiveSemester();
        courseListTable
                .setModel(new CourseTableModel(this.courseList));
    }

    private void updateTableData(List<Course> courses)
    {
        this.courseList = courses;
        courseListTable
                .setModel(new CourseTableModel(this.courseList));
    }


    @Override
    public void addEventListener()
    {

        insertBtn.addActionListener(evt -> insertBtnActionPerformed(evt));
        editBtn.addActionListener(evt -> editBtnActionPerformed(evt));
        clearBtn.addActionListener(evt -> clearBtnActionPerformed(evt));
        deleteBtn.addActionListener(evt -> deleteBtnActionPerformed(evt));
        searchBtn.addActionListener(e -> searchBtnActionPerformed(e));
        addACourseInfoBtn.addActionListener(e -> addACourseInfoBtnActionPerformed(e));
        removeCourseInfoBtn.addActionListener(e -> removeCourseInfo(e));
    }

    private void removeCourseInfo(ActionEvent e)
    {
        CourseInfo selectedCourseInfo = (CourseInfo) courseInfoComboBox.getSelectedItem();
        if (selectedCourseInfo == null)
        {
            JOptionPane.showMessageDialog(this, "You have to select a course info to remove");
            return;
        }

        try
        {
            service.deleteCourseInfo(selectedCourseInfo);
            populateCourseInfoComboBox();
        } catch (Exception ex)
        {
            if (selectedCourseInfo.getCourses() == null) return;
            StringBuilder builder = new StringBuilder();
            for (Course course : selectedCourseInfo.getCourses())
            {
                builder.append(course.toString());
                builder.append(", ");
            }
            String result = builder.toString();
            if (selectedCourseInfo.getCourses().size() > 0)
            {
                result = result.substring(0, result.length() - 1);
            }
            JOptionPane.showMessageDialog(this, "You cannot delete this course info because it is used by " + result);
        }
    }

    private void addACourseInfoBtnActionPerformed(ActionEvent event)
    {
        Subject subject = (Subject) subjectCombobox.getSelectedItem();

        if (activeSemester == null)
        {
            JOptionPane.showMessageDialog(this, "The active semester have not set yet");
            return;
        }

        if (subject == null)
        {
            JOptionPane.showMessageDialog(this, "You have to select a subject to add info");
            return;
        }

        CourseInfo courseInfo = new CourseInfo(subject, activeSemester);

        try
        {
            service.addNewCourseInfo(courseInfo);
            populateCourseInfoComboBox();
        } catch (Exception ex)
        {
            JOptionPane.showMessageDialog(this, "Cannot add new course info because it is already exists");
        }

    }

    @Override
    public void searchBtnActionPerformed(ActionEvent evt)
    {
        val keyword = searchTextField.getText();

        if (keyword == null)
        {
            JOptionPane.showMessageDialog(this, "Keyword cannot be null");
            return;
        }

        val courses = service.searchCourse(keyword);
        updateTableData(courses);
    }

}
