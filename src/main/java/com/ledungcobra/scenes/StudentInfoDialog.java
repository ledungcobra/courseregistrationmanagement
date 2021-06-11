package com.ledungcobra.scenes;

import com.ledungcobra.applicationcontext.AppContext;
import com.ledungcobra.entites.StudentInfo;
import com.ledungcobra.services.TeachingManagerService;
import lombok.NonNull;
import lombok.SneakyThrows;
import lombok.val;

import javax.swing.*;
import java.util.Map;
import java.util.function.Consumer;

import static com.ledungcobra.scenes.StudentManagementScreen.IDENTITY_NUMBER;

public class StudentInfoDialog extends JDialog
{

    private Map<String, Object> data;
    private StudentInfo studentInfo;
    private Consumer<StudentInfo> consumer;
    private JPanel jPanel1;
    private JPanel jPanel2;

    public static final String STUDENT_INFO = "STUDENT_INFO";
    private String identityNumber;
    private TeachingManagerService service = AppContext.teachingManagerService;
    private Screen prevScreen;


    public StudentInfoDialog(Map<String, Object> data, @NonNull Consumer<StudentInfo> run)
    {
        this.consumer = run;

        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        this.data = data;
        initComponents();
        this.setLocationRelativeTo(null);
        identityNumber = (String) getData().get(IDENTITY_NUMBER);

        prevScreen = (Screen) getData().get(StudentManagementScreen.class.getSimpleName());

        if (identityNumber == null || "".equals(identityNumber))
        {
            JOptionPane.showMessageDialog(this, "You have to add student info");
            throw new IllegalStateException("identity number must be passed from the previous screen");
        }


        addEventListener();
        studentInfo = service.findStudentInfoByIdentityNo(this.identityNumber);

        if (studentInfo != null)
        {
            this.fullNameTextField.setText(studentInfo.getFullName());
            this.birthDateChooser.setDate(studentInfo.getCreatedDate());
            this.genderComboBox.setSelectedItem(studentInfo.getGender());
        } else
        {
            this.updateBtn.setEnabled(false);
        }

    }

    public Map<String, Object> getData()
    {
        return data;
    }

    public void setData(Map<String, Object> data)
    {
        this.data = data;
    }


    public void addEventListener()
    {

        updateBtn.addActionListener(e -> updateBtnActionPerformed());
        doneBtn.addActionListener(e -> doneBtnPerformed());
        backBtn.addActionListener(e -> backBtnPerformed());

    }

    private void backBtnPerformed()
    {

        if (studentInfo != null)
        {
            prevScreen.getData().put(STUDENT_INFO, studentInfo);
            prevScreen.getData().put(StudentInfoDialog.class.getSimpleName(), true);
        } else
        {
            prevScreen.getData().put(StudentInfoDialog.class.getSimpleName(), false);
        }
        finish();
    }

    protected void finish()
    {
        this.setVisible(false);
        this.dispose();
    }

    @SneakyThrows
    private void doneBtnPerformed()
    {
        val fullName = fullNameTextField.getText();
        if (fullName == null || "".equals(fullName))
        {
            JOptionPane.showMessageDialog(this, "You have to enter full name to continue");
            return;
        }

        val birthdate = birthDateChooser.getDate();
        if (birthdate == null)
        {
            JOptionPane.showMessageDialog(this, "You have to choose birth date to continue");
            return;
        }

        val gender = (String) genderComboBox.getSelectedItem();
        if (gender == null || "".equals(gender))
        {
            JOptionPane.showMessageDialog(this, "You have to select gender to continue");
            return;
        }


        if (studentInfo != null)
        {
            // Update data
            studentInfo.setFullName(fullName);
            studentInfo.setBirthdate(birthdate);
            studentInfo.setGender(gender);
            prevScreen.getData().put(STUDENT_INFO, studentInfo);
            prevScreen.getData().put(StudentInfoDialog.class.getSimpleName(), true);
            service.updateStudentInfo(studentInfo);

        } else
        {
            this.studentInfo = new StudentInfo(gender, birthdate, identityNumber, fullName);
            service.addStudentInfo(this.studentInfo);
        }

        consumer.accept(studentInfo);
        finish();

    }

    private void updateBtnActionPerformed()
    {
        try
        {
            if (this.studentInfo.getIdentityCardNumber() != null)
            {
                service.updateStudentInfo(this.studentInfo);
                JOptionPane.showMessageDialog(this, "Update student info done");
            }
        } catch (Exception e)
        {
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">
    private void initComponents()
    {

        backBtn = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        birthDateChooser = new com.toedter.calendar.JDateChooser();
        jLabel4 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        fullNameTextField = new javax.swing.JTextField();
        genderComboBox = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        doneBtn = new javax.swing.JButton();
        updateBtn = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        backBtn.setText("Back");

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Student Info", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 3, 14))); // NOI18N

        jLabel4.setText("Gender");

        jLabel3.setText("Birthdate");

        jLabel1.setText("Full name");

        genderComboBox.setModel(new DefaultComboBoxModel<>(new String[]{"Boy", "Girl"}));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel1)
                                        .addComponent(jLabel3)
                                        .addComponent(jLabel4))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(fullNameTextField)
                                        .addComponent(birthDateChooser, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(genderComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 673, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel1)
                                        .addComponent(fullNameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(14, 14, 14)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel3)
                                        .addComponent(birthDateChooser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel4)
                                        .addComponent(genderComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addContainerGap())
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Actions", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 3, 14))); // NOI18N

        doneBtn.setText("Done");

        updateBtn.setText("Update");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
                jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(updateBtn)
                                .addGap(18, 18, 18)
                                .addComponent(doneBtn)
                                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
                jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(doneBtn)
                                        .addComponent(updateBtn))
                                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(16, 16, 16)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(backBtn)
                                        .addComponent(jLabel2))
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap())
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(23, 23, 23)
                                .addComponent(backBtn)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel2)
                                .addGap(20, 20, 20)
                                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(19, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>


    // Variables declaration - do not modify
    private javax.swing.JButton backBtn;
    private com.toedter.calendar.JDateChooser birthDateChooser;

    private javax.swing.JButton doneBtn;
    private javax.swing.JTextField fullNameTextField;
    private javax.swing.JComboBox<String> genderComboBox;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;

    private javax.swing.JButton updateBtn;
    // End of variables declaration
}
