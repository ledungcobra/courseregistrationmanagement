package com.ledungcobra.scenes;

import com.ledungcobra.anotations.BackButton;
import com.ledungcobra.applicationcontext.AppContext;
import com.ledungcobra.entites.Course;
import com.ledungcobra.entites.CourseRegistrationSession;
import com.ledungcobra.entites.Semester;
import com.ledungcobra.entites.StudentAccount;
import com.ledungcobra.models.CourseTableModel;
import com.ledungcobra.services.StudentService;
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
    private JPanel jPanel1;
    private JPanel jPanel2;


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
            try
            {
                this.currentSession = service.getValidCourseRegistrationSession();
            } catch (Exception e)
            {
                System.out.println("Inactive semester");
            }



            this.activeSemester = service.getActiveSemester();

            if (this.currentSession == null)
                return;
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

        if (this.currentSession == null)
        {
            JOptionPane.showMessageDialog(this, "There are no register session or it is expired");
            return;
        }

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

        if (this.currentSession == null)
        {
            JOptionPane.showMessageDialog(this, "There are no register session or it is expired");
            return;
        }

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

        jScrollPane2 = new javax.swing.JScrollPane();
        resultCourseListTable = new javax.swing.JTable();
        backBtn = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        endDateLbl = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        startDateLbl = new javax.swing.JLabel();
        semesterLbl = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        registerBtn = new javax.swing.JButton();
        removeBtn = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jScrollPane2.setViewportView(resultCourseListTable);

        backBtn.setText("Back");

        jLabel6.setFont(new java.awt.Font("Tahoma", 3, 13)); // NOI18N
        jLabel6.setText("Result registered courses in this session ");

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Info", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 3, 14))); // NOI18N

        jLabel3.setText("Register session:");

        jLabel5.setText("End date");

        jLabel4.setText("Start date");

//        endDateLbl.setText("12/12/2001");

        jLabel2.setText("Semester");

//        startDateLbl.setText("12/12/2001");

//        semesterLbl.setText("HK1");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addContainerGap()
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
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                .addComponent(semesterLbl)
                                                .addComponent(jLabel3))
                                        .addComponent(jLabel2)
                                        .addComponent(startDateLbl)
                                        .addComponent(jLabel4)
                                        .addComponent(endDateLbl)
                                        .addComponent(jLabel5))
                                .addContainerGap())
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Actions"));

        registerBtn.setBackground(new java.awt.Color(51, 255, 51));
        registerBtn.setText("Register");

        removeBtn.setBackground(new java.awt.Color(255, 0, 0));
        removeBtn.setText("Remove");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
                jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(removeBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(registerBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
                jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(removeBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(registerBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(25, 25, 25)
                                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 1201, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18)
                                                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(22, 22, 22)
                                                .addComponent(jLabel6))
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(25, 25, 25)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(backBtn))))
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGroup(layout.createSequentialGroup()
                                                .addComponent(backBtn)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(11, 11, 11)
                                                .addComponent(jLabel6)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addContainerGap(14, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>

}
