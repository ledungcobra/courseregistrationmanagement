package com.ledungcobra.scenes;

import com.ledungcobra.anotations.BackButton;
import com.ledungcobra.applicationcontext.AppContext;
import com.ledungcobra.entites.Course;
import com.ledungcobra.entites.CourseRegistrationSession;
import com.ledungcobra.entites.Semester;
import com.ledungcobra.entites.StudentAccount;
import com.ledungcobra.model.CourseTableModel;
import com.ledungcobra.service.StudentService;
import lombok.SneakyThrows;
import lombok.val;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

import static com.ledungcobra.scenes.LoginScreen.USER_KEY;

public class StudentRegisterCoursesScreen extends Screen
{

    // <editor-fold defaultstate="collapsed desc="Field declarations">
    private javax.swing.JButton addBtn;

    @BackButton
    private javax.swing.JButton backBtn;

    private javax.swing.JButton editRegisteredCourseListBtn;
    private javax.swing.JLabel endDateLbl;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable openedCourseListTable;
    private javax.swing.JTable previewCourses;
    private javax.swing.JButton registerBtn;
    private javax.swing.JButton removeBtn;
    private javax.swing.JLabel semesterLbl;
    private javax.swing.JLabel startDateLbl;

    private HashSet<Course> tempCourseSet;
    private List<Course> loadedCourseList;
    private final StudentService service = AppContext.studentService;
    private CourseRegistrationSession currentSession;
    private Semester activeSemester;
    private HashSet<Course> removedCoursesSet;
    private StudentAccount studentAccount;
    private boolean firstLoad = true;


    @SneakyThrows
    @Override
    public void onCreateView()
    {
        initComponents();

        if (this.data == null) throw new Exception("Data should not be null");
        this.studentAccount = (StudentAccount) this.data.get(USER_KEY);
        removedCoursesSet = new HashSet<>();

        try
        {
            this.currentSession = service.getValidCourseRegistrationSession();
            this.activeSemester = service.getActiveSemester();

            this.semesterLbl.setText(this.currentSession.getSemester().toString());
            this.startDateLbl.setText(this.currentSession.getStartDate().toString());
            this.endDateLbl.setText(this.currentSession.getEndDate().toString());

        } catch (Exception e)
        {
            JOptionPane.showMessageDialog(this, e.getMessage());
            finish();
            return;
        }

        loadData();
        updateLoadedCourseList();
        updateTempCourseList();
    }

    void loadData()
    {
        this.tempCourseSet = new HashSet<>(service.getRegisteredCourses(activeSemester, this.studentAccount));
    }

    private void updateTempCourseList()
    {
        this.previewCourses.setModel(new CourseTableModel(new ArrayList<>(this.tempCourseSet)));
    }

    private void updateLoadedCourseList()
    {
        this.openedCourseListTable.setModel(new CourseTableModel(new ArrayList<>()));
        this.loadedCourseList = service.getCoursesOpenedInActiveSemester();
        this.openedCourseListTable.setModel(new CourseTableModel(this.loadedCourseList));
    }

    @Override
    protected void finish()
    {
        AppContext.executorService.submit(() -> {
            try
            {
                Thread.sleep(400);

                SwingUtilities.invokeAndWait(super::finish);
            } catch (InterruptedException | InvocationTargetException e)
            {
                e.printStackTrace();
            }
        });
    }

    @Override
    public void addEventListener()
    {
        addBtn.addActionListener(this::addCourseToTempListActionPerform);
        removeBtn.addActionListener(this::removeCourseFromTempListActionPerform);
        editRegisteredCourseListBtn.addActionListener(this::onEditCourseListBtnPerform);
        registerBtn.addActionListener(this::onRegisterBtnActionPerformed);
    }

    private void onRegisterBtnActionPerformed(ActionEvent e)
    {
        if (checkBeforeSubmit())
        {
            service.removeCourses(removedCoursesSet, studentAccount, activeSemester);
            service.registerCourses(tempCourseSet, studentAccount, this.currentSession, activeSemester);
            loadData();
            updateTempCourseList();
            updateLoadedCourseList();

        } else
        {
            JOptionPane.showMessageDialog(this, "You are allowed to register 8 courses or you have a conflict in time between courses in your temp list");
        }
    }

    boolean checkBeforeSubmit()
    {
        if (tempCourseSet.size() > 8) return false;
        val courses = new ArrayList<>(tempCourseSet);
        for (int i = 0; i < courses.size(); i++)
        {
            val currentCourse = courses.get(i);
            for (int j = 0; j < courses.size(); j++)
            {
                if (i != j &&
                        currentCourse.getShiftToStudyInDay()
                                .equals(courses.get(j).getShiftToStudyInDay()) &&
                        currentCourse.getDayToStudyInWeek().equals(courses.get(j).getDayToStudyInWeek())
                )
                {
                    return false;
                }
            }
        }
        return true;
    }

    private void onEditCourseListBtnPerform(ActionEvent e)
    {

    }

    private void removeCourseFromTempListActionPerform(ActionEvent e)
    {
        int[] coursesIndices = previewCourses.getSelectedRows();
        if (coursesIndices != null || coursesIndices.length > 0)
        {
            List<Course> courses = new ArrayList<>(this.tempCourseSet);

            Arrays.stream(coursesIndices).forEach(i -> {
                this.removedCoursesSet.add(courses.get(i));
                this.tempCourseSet.remove(courses.get(i));
            });

            updateTempCourseList();
        } else
        {
            JOptionPane.showMessageDialog(this, "You have to choose any course to add to your temp course list");
        }
    }

    private void addCourseToTempListActionPerform(ActionEvent e)
    {
        int[] courseIndices = openedCourseListTable.getSelectedRows();
        if (!checkBeforeAddCourse()) return;

        if (courseIndices != null || courseIndices.length > 0)
        {
            Arrays.stream(courseIndices).forEach(i -> {
                this.tempCourseSet.add(this.loadedCourseList.get(i));
                this.removedCoursesSet.remove(this.loadedCourseList.get(i));
            });

            updateTempCourseList();
        } else
        {
            JOptionPane.showMessageDialog(this, "You have to choose any course to add to your temp course list");
        }
    }

    private boolean checkBeforeAddCourse()
    {
        int[] selectedCourseIndices = openedCourseListTable.getSelectedRows();
        if (selectedCourseIndices == null || selectedCourseIndices.length == 0) return true;
        List<Course> courses = new ArrayList<>(tempCourseSet);

        for (int i = 0; i < selectedCourseIndices.length; i++)
        {
            val currentCourse = loadedCourseList.get(selectedCourseIndices[i]);
            for (int j = 0; j < courses.size(); j++)
            {
                if (currentCourse.getSubject() != null &&
                        currentCourse.getSubject().equals(courses.get(j).getSubject()))
                {
                    return false;
                }
            }
        }
        return true;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents()
    {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        startDateLbl = new javax.swing.JLabel();
        endDateLbl = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        openedCourseListTable = new javax.swing.JTable();
        registerBtn = new javax.swing.JButton();
        editRegisteredCourseListBtn = new javax.swing.JButton();
        semesterLbl = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        previewCourses = new javax.swing.JTable();
        addBtn = new javax.swing.JButton();
        removeBtn = new javax.swing.JButton();
        backBtn = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Tahoma", 3, 13)); // NOI18N
        jLabel1.setText("Info");

        jLabel2.setText("Semester");

        jLabel3.setText("Register session:");

        jLabel4.setText("Start date");

        jLabel5.setText("End date");

        startDateLbl.setText("12/12/2001");

        endDateLbl.setText("12/12/2001");

        openedCourseListTable.setModel(new javax.swing.table.DefaultTableModel(
                new Object[][]{
                        {null, null, null, null},
                        {null, null, null, null},
                        {null, null, null, null},
                        {null, null, null, null}
                },
                new String[]{
                        "Title 1", "Title 2", "Title 3", "Title 4"
                }
        ));
        jScrollPane1.setViewportView(openedCourseListTable);

        registerBtn.setBackground(new java.awt.Color(51, 255, 51));
        registerBtn.setText("Register");

        editRegisteredCourseListBtn.setText("Edit registerd course list");

        semesterLbl.setText("HK1");

        previewCourses.setModel(new javax.swing.table.DefaultTableModel(
                new Object[][]{
                        {null, null, null, null},
                        {null, null, null, null},
                        {null, null, null, null},
                        {null, null, null, null}
                },
                new String[]{
                        "Title 1", "Title 2", "Title 3", "Title 4"
                }
        ));
        jScrollPane2.setViewportView(previewCourses);

        addBtn.setText("Add");

        removeBtn.setBackground(new java.awt.Color(255, 0, 0));
        removeBtn.setText("Remove");

        backBtn.setText("Back");

        jLabel6.setFont(new java.awt.Font("Tahoma", 3, 13)); // NOI18N
        jLabel6.setText("Temporary chose course list");

        jLabel7.setFont(new java.awt.Font("Tahoma", 3, 13)); // NOI18N
        jLabel7.setText("Opened Courses ");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(28, 28, 28)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(jLabel1)
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addComponent(jLabel2)
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(semesterLbl)
                                                                .addGap(103, 103, 103)
                                                                .addComponent(jLabel3)
                                                                .addGap(21, 21, 21)
                                                                .addComponent(jLabel4)
                                                                .addGap(22, 22, 22)
                                                                .addComponent(startDateLbl)
                                                                .addGap(49, 49, 49)
                                                                .addComponent(jLabel5)
                                                                .addGap(18, 18, 18)
                                                                .addComponent(endDateLbl))))
                                        .addGroup(layout.createSequentialGroup()
                                                .addContainerGap()
                                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1469, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                                .addGap(0, 2, Short.MAX_VALUE)
                                                                .addComponent(addBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                        .addComponent(registerBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                        .addComponent(editRegisteredCourseListBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                .addGap(0, 0, Short.MAX_VALUE))))
                                        .addGroup(layout.createSequentialGroup()
                                                .addContainerGap()
                                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 1469, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(removeBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(layout.createSequentialGroup()
                                                .addContainerGap()
                                                .addComponent(backBtn))
                                        .addGroup(layout.createSequentialGroup()
                                                .addContainerGap()
                                                .addComponent(jLabel6))
                                        .addGroup(layout.createSequentialGroup()
                                                .addContainerGap()
                                                .addComponent(jLabel7)))
                                .addContainerGap(13, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(backBtn)
                                .addGap(11, 11, 11)
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                .addComponent(semesterLbl)
                                                .addComponent(jLabel3))
                                        .addComponent(jLabel2)
                                        .addComponent(startDateLbl)
                                        .addComponent(jLabel4)
                                        .addComponent(endDateLbl)
                                        .addComponent(jLabel5))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel6)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(removeBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addComponent(jLabel7)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addGroup(layout.createSequentialGroup()
                                                .addComponent(addBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18)
                                                .addComponent(editRegisteredCourseListBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(registerBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 305, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>                        

}