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
import com.ledungcobra.model.AbsComboModel;
import com.ledungcobra.model.CourseTableModel;
import com.ledungcobra.model.SubjectComboModel;
import com.ledungcobra.service.TeachingManagerService;
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

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">
    private void initComponents()
    {

        backBtn = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        courseListTable = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        editBtn = new javax.swing.JButton();
        insertBtn = new javax.swing.JButton();
        clearBtn = new javax.swing.JButton();
        deleteBtn = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        subjectCombobox = new javax.swing.JComboBox<>();
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
        jLabel12 = new javax.swing.JLabel();
        searchTextField = new javax.swing.JTextField();
        searchBtn = new javax.swing.JButton();
        addACourseInfoBtn = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        courseInfoComboBox = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        backBtn.setText("Back");

        courseListTable.setModel(new javax.swing.table.DefaultTableModel(
                new Object[][]{

                },
                new String[]{
                        "ID", "Full name", "Password"
                }
        )
        {
            Class[] types = new Class[]{
                    java.lang.String.class, java.lang.Integer.class, java.lang.Integer.class
            };
            boolean[] canEdit = new boolean[]{
                    false, true, false
            };

            public Class getColumnClass(int columnIndex)
            {
                return types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex)
            {
                return canEdit[columnIndex];
            }
        });
        jScrollPane1.setViewportView(courseListTable);

        jLabel3.setFont(new java.awt.Font("Tahoma", 3, 14)); // NOI18N
        jLabel3.setText("Add new course");

        jLabel4.setText("Subject");

        jLabel6.setFont(new java.awt.Font("Tahoma", 3, 14)); // NOI18N
        jLabel6.setText("Manage course");

        editBtn.setText("Edit");

        insertBtn.setText("Insert");

        clearBtn.setText("Clear");

        deleteBtn.setBackground(new java.awt.Color(255, 51, 51));
        deleteBtn.setText("Delete");

        jLabel7.setFont(new java.awt.Font("Tahoma", 3, 14)); // NOI18N
        jLabel7.setText("Opened courses in this season");

        jLabel1.setText("Theory teacher name");

        jLabel8.setText("Day to study in week");

        jLabel9.setText("Class room name");

        jLabel10.setText("Shift to study in day");

        jLabel11.setText("Number of slot");

        jLabel12.setText("Keyword");

        searchBtn.setText("Search");

        addACourseInfoBtn.setText("Add a course info");

        jLabel2.setText("Course info");
        removeCourseInfoBtn = new JButton();
        removeCourseInfoBtn.setText("Remove course info");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(68, 68, 68)
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
                                                                        .addComponent(subjectCombobox, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                                                                .addComponent(courseInfoComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 602, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                .addGap(11, 11, 11)
                                                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                                        .addComponent(addACourseInfoBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                                                        .addComponent(removeCourseInfoBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                        .addGroup(layout.createSequentialGroup()
                                                                                .addGap(549, 549, 549)
                                                                                .addComponent(editBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                .addGap(18, 18, 18)
                                                                                .addComponent(deleteBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 241, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                .addGap(0, 0, Short.MAX_VALUE)))
                                                .addGap(106, 106, 106))
                                        .addGroup(layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(backBtn)
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addComponent(jLabel12)
                                                                .addGap(18, 18, 18)
                                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                        .addGroup(layout.createSequentialGroup()
                                                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                        .addComponent(jLabel4))
                                                                                .addGap(0, 0, Short.MAX_VALUE))
                                                                        .addGroup(layout.createSequentialGroup()
                                                                                .addComponent(searchTextField)
                                                                                .addGap(18, 18, 18)
                                                                                .addComponent(searchBtn)))))
                                                .addGap(20, 20, 20))))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(80, 80, 80)
                                                .addComponent(jScrollPane1))
                                        .addGroup(layout.createSequentialGroup()
                                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(clearBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(insertBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(106, 106, 106))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(backBtn)
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel12)
                                        .addComponent(searchTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(searchBtn))
                                .addGap(18, 18, 18)
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel4)
                                        .addComponent(subjectCombobox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(addACourseInfoBtn)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 20, Short.MAX_VALUE)
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
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(clearBtn)
                                        .addComponent(insertBtn))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel7)
                                .addGap(13, 13, 13)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel6)
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(editBtn)
                                        .addComponent(deleteBtn))
                                .addGap(18, 18, 18))
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
                }

                updateTableData();
            }
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
            e.printStackTrace();
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
            ex.printStackTrace();
        }

    }

    @Override
    public void searchBtnActionPerformed(ActionEvent evt)
    {
        val keyword = searchTextField.getText();

        if ("".equals(keyword))
        {
            JOptionPane.showMessageDialog(this, "You must enter some thing to search");
            return;
        }

        val courses = service.searchCourse(keyword);
        updateTableData(courses);
    }

}
