package com.ledungcobra.scenes;

import com.ledungcobra.anotations.BackButton;
import com.ledungcobra.applicationcontext.AppContext;
import com.ledungcobra.entites.Course;
import com.ledungcobra.entites.CourseRegistrationSession;
import com.ledungcobra.entites.Semester;
import com.ledungcobra.entites.StudentAccount;
import com.ledungcobra.models.CourseTableModel;
import com.ledungcobra.services.StudentService;
import com.ledungcobra.utils.Navigator;
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
    private HashSet<Course> registeredCourse;

    private List<Course> loadedCourseList;
    private final StudentService service = AppContext.studentService;
    private CourseRegistrationSession currentSession;
    private Semester activeSemester;
    private HashSet<Course> removedCoursesSet;
    private StudentAccount studentAccount;
    private JPanel jPanel1;
    private JPanel jPanel3;
    private JPanel jPanel2;
    private JPanel jPanel4;


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

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">
    private void initComponents()
    {

        jScrollPane1 = new javax.swing.JScrollPane();
        openedCourseListTable = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        previewCourses = new javax.swing.JTable();
        backBtn = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        endDateLbl = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        startDateLbl = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        semesterLbl = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        addBtn = new javax.swing.JButton();
        editRegisteredCourseListBtn = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        removeBtn = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        registerBtn = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jScrollPane1.setViewportView(openedCourseListTable);

        jScrollPane2.setViewportView(previewCourses);

        backBtn.setText("Back");

        jLabel7.setFont(new java.awt.Font("Tahoma", 3, 13)); // NOI18N
        jLabel7.setText("Opened Courses ");

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Info", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 3, 14))); // NOI18N

        endDateLbl.setText("12/12/2001");

        jLabel5.setText("End date");

        jLabel2.setText("Semester");

        startDateLbl.setText("12/12/2001");

        jLabel3.setText("Register session:");

        semesterLbl.setText("HK1");

        jLabel4.setText("Start date");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(28, 28, 28)
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
                                .addComponent(endDateLbl)
                                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                .addComponent(semesterLbl)
                                                .addComponent(jLabel3))
                                        .addComponent(jLabel2)
                                        .addComponent(startDateLbl)
                                        .addComponent(jLabel4)
                                        .addComponent(endDateLbl)
                                        .addComponent(jLabel5))
                                .addGap(38, 38, 38))
        );

        jLabel6.setFont(new java.awt.Font("Tahoma", 3, 13)); // NOI18N
        jLabel6.setText("Temporary chose course list");

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Temporary actions", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 3, 14))); // NOI18N

        addBtn.setText("Add");

        editRegisteredCourseListBtn.setText("Edit registerd course list");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
                jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(editRegisteredCourseListBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(addBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
                jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(addBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(editRegisteredCourseListBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap())
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Temporary Action", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 3, 14))); // NOI18N

        removeBtn.setBackground(new java.awt.Color(255, 0, 0));
        removeBtn.setText("Remove");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
                jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel3Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(removeBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
                jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel3Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(removeBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap())
        );

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Persistent Action", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 3, 14))); // NOI18N

        registerBtn.setBackground(new java.awt.Color(51, 255, 51));
        registerBtn.setText("Register");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
                jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel4Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(registerBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
                jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel4Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(registerBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 1469, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(27, 27, 27)
                                                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addComponent(backBtn)
                                        .addComponent(jLabel7)
                                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel6)
                                        .addGroup(layout.createSequentialGroup()
                                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1469, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(27, 27, 27)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(backBtn)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel6)
                                .addGap(5, 5, 5)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addComponent(jLabel7)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(layout.createSequentialGroup()
                                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 305, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(0, 0, Short.MAX_VALUE)))
                                .addContainerGap())
        );

        pack();
    }// </editor-fold>

    void loadData()
    {
        this.registeredCourse = new HashSet<>(service.getRegisteredCourses(activeSemester, this.studentAccount));
        this.tempCourseSet = new HashSet<>(this.registeredCourse);
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
                JOptionPane.showMessageDialog(null, "An error occur");
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
        try
        {
            if (checkBeforeSubmit())
            {
                service.removeCourses(removedCoursesSet, studentAccount, activeSemester);

                registeredCourse.forEach(c -> {
                    tempCourseSet.remove(c);
                });

                service.registerCourses(tempCourseSet, studentAccount, this.currentSession, activeSemester);
                loadData();
                updateTempCourseList();
                updateLoadedCourseList();

                JOptionPane.showMessageDialog(this, "Register success");

            } else
            {
                JOptionPane.showMessageDialog(this, "You have a conflict in time between courses in your temp list");
            }


        } catch (Exception ex)
        {
            JOptionPane.showMessageDialog(this, ex.getMessage());
        }

    }

    boolean checkBeforeSubmit()
    {
        if (tempCourseSet.size() > 8)
        {
            JOptionPane.showMessageDialog(this, "You are allowed to register maximum 8 course");
            return false;
        }

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
        new Navigator<ListAllRegisteredCoursesScreen>().navigate(this.data);
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


}