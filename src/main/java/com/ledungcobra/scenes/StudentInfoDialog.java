package com.ledungcobra.scenes;

import com.ledungcobra.applicationcontext.AppContext;
import com.ledungcobra.entites.StudentInfo;
import com.ledungcobra.services.TeachingManagerService;
import lombok.NonNull;
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
        }

    }

    public static final String STUDENT_INFO = "STUDENT_INFO";
    private String identityNumber;
    private TeachingManagerService service = AppContext.teachingManagerService;
    private Screen prevScreen;

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

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">
    private void initComponents()
    {

        backBtn = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        fullNameTextField = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        birthDateChooser = new com.toedter.calendar.JDateChooser();
        jLabel4 = new javax.swing.JLabel();
        genderComboBox = new javax.swing.JComboBox<>();
        doneBtn = new javax.swing.JButton();
        updateBtn = new javax.swing.JButton();

        backBtn.setText("Back");

        jLabel1.setText("Full name");

        jLabel3.setText("Birthdate");

        jLabel4.setText("Gender");

        genderComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[]{"Boy", "Girl"}));

        doneBtn.setText("Done");

        updateBtn.setText("Update");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addContainerGap()
                                                .addComponent(backBtn))
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(70, 70, 70)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(jLabel2)
                                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                                .addGroup(layout.createSequentialGroup()
                                                                        .addComponent(updateBtn)
                                                                        .addGap(18, 18, 18)
                                                                        .addComponent(doneBtn))
                                                                .addGroup(layout.createSequentialGroup()
                                                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                                .addComponent(jLabel1)
                                                                                .addComponent(jLabel3)
                                                                                .addComponent(jLabel4))
                                                                        .addGap(18, 18, 18)
                                                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                                                .addComponent(fullNameTextField)
                                                                                .addComponent(birthDateChooser, javax.swing.GroupLayout.DEFAULT_SIZE, 673, Short.MAX_VALUE)
                                                                                .addComponent(genderComboBox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))))
                                .addContainerGap(47, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(backBtn)
                                .addGap(47, 47, 47)
                                .addComponent(jLabel2)
                                .addGap(107, 107, 107)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel1)
                                        .addComponent(fullNameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(14, 14, 14)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel3)
                                        .addComponent(birthDateChooser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel4)
                                        .addComponent(genderComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(doneBtn)
                                        .addComponent(updateBtn))
                                .addContainerGap(160, Short.MAX_VALUE))
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
