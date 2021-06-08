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

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

import static com.ledungcobra.scenes.LoginScreen.USER_KEY;

public class ListAllRegisteredCoursesScreen extends Screen
{

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
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JButton registerBtn;
    private javax.swing.JButton removeBtn;
    private javax.swing.JTable resultCourseListTable;
    private javax.swing.JLabel semesterLbl;
    private javax.swing.JLabel startDateLbl;
    private HashSet<Course> removedCourses;

    private List<Course> courses;
    private final StudentService service = AppContext.studentService;
    private Semester activeSemester;
    private StudentAccount studentAccount;
    private CourseRegistrationSession currentSession;


    @SneakyThrows
    @Override
    public void onCreateView()
    {
        initComponents();

        if (this.data == null) throw new Exception("The data should not be null");
        this.studentAccount = (StudentAccount) this.data.get(USER_KEY);
        if (this.studentAccount == null) throw new Exception("Student account can not be null");
        removedCourses = new HashSet<>();

        try
        {
            this.currentSession = service.getValidCourseRegistrationSession();
            this.activeSemester = service.getActiveSemester();

            this.semesterLbl.setText(this.currentSession.getSemester().toString());
            this.startDateLbl.setText(this.currentSession.getStartDate().toString());
            this.endDateLbl.setText(this.currentSession.getEndDate().toString());

        } catch (Exception e)
        {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, e.getMessage());
            finish();
            return;
        }


        loadData();
        updateTableData();
    }

    private void loadData()
    {
        this.courses = service.getRegisteredCourses(activeSemester, studentAccount);
    }

    private void updateTableData()
    {
        this.resultCourseListTable.setModel(new CourseTableModel(this.courses));
    }

    @Override
    public void addEventListener()
    {
        removeBtn.addActionListener(this::removeBtnActionPerformed);
        registerBtn.addActionListener(this::registerBtnActionPerformed);
    }

    private void registerBtnActionPerformed(ActionEvent actionEvent)
    {
        try
        {
            this.service.removeCourses(removedCourses, studentAccount, activeSemester);
        } catch (Exception e)
        {
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
    }

    private void removeBtnActionPerformed(ActionEvent e)
    {
        int[] coursesIndices = resultCourseListTable.getSelectedRows();
        if (coursesIndices != null || coursesIndices.length > 0)
        {

            Arrays.stream(coursesIndices).forEach(i -> {
                removedCourses.add(courses.get(i));
            });

            for (Course removedCourse : removedCourses)
            {
                courses.remove(removedCourse);
            }
            updateTableData();
        } else
        {
            JOptionPane.showMessageDialog(this, "You have to choose any course to add to your temp course list");
        }

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
        registerBtn = new javax.swing.JButton();
        semesterLbl = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        resultCourseListTable = new javax.swing.JTable();
        removeBtn = new javax.swing.JButton();
        backBtn = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Tahoma", 3, 13)); // NOI18N
        jLabel1.setText("Info");

        jLabel2.setText("Semester");

        jLabel3.setText("Register session:");

        jLabel4.setText("Start date");

        jLabel5.setText("End date");

        startDateLbl.setText("12/12/2001");

        endDateLbl.setText("12/12/2001");

        registerBtn.setBackground(new java.awt.Color(51, 255, 51));
        registerBtn.setText("Register");

        semesterLbl.setText("HK1");

        jScrollPane2.setViewportView(resultCourseListTable);

        removeBtn.setBackground(new java.awt.Color(255, 0, 0));
        removeBtn.setText("Remove");

        backBtn.setText("Back");

        jLabel6.setFont(new java.awt.Font("Tahoma", 3, 13)); // NOI18N
        jLabel6.setText("Result registered courses in this session ");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
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
                                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 1201, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(layout.createSequentialGroup()
                                                .addContainerGap()
                                                .addComponent(backBtn))
                                        .addGroup(layout.createSequentialGroup()
                                                .addContainerGap()
                                                .addComponent(jLabel6)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 23, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(removeBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(registerBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(17, 17, 17))
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
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGroup(layout.createSequentialGroup()
                                                .addComponent(removeBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(registerBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addContainerGap(24, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>

}
