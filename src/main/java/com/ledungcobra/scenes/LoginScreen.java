package com.ledungcobra.scenes;

import com.ledungcobra.applicationcontext.AppContext;
import com.ledungcobra.dto.Intent;
import com.ledungcobra.exception.UserNotFound;
import com.ledungcobra.service.UserService;
import lombok.val;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

import java.util.HashMap;
import java.util.Objects;

import static com.ledungcobra.utils.Constants.USERNAME;

public class LoginScreen extends Screen {

    public static final String USER_KEY = "USER";
    public static final String ROLE_KEY = "ROLE";

    public enum ROLE {
        STUDENT,
        TEACHING_MANAGER
    }


    private JTextField username;
    private JPasswordField password;
    private ROLE role = ROLE.STUDENT;

    private JRadioButton studentRoleRadioBtn;
    private JRadioButton teachingManagerRoleRadioBtn;
    private JButton loginButton;


    @Override
    public void onCreateView() {

        // Set up title
        val loginLabel = new JLabel("LOGIN", SwingConstants.LEFT);
        loginLabel.setFont(new Font(Font.SERIF, Font.ITALIC, 20));


        // Login pane include username and password
        val loginPane = new JPanel();
        val boxLayout = new BoxLayout(loginPane, BoxLayout.Y_AXIS);

        loginPane.setLayout(boxLayout);
        val userNameLabel = new JLabel("Username(ID)");
        val passwordPanel = new JPanel(new GridLayout(1, 2));


        username = new JTextField(USERNAME);
        val usernamePane = new JPanel(new GridLayout(1, 2));
        usernamePane.add(userNameLabel);
        usernamePane.add(username);

        val passwordText = new JLabel("Password");
        password = new JPasswordField(USERNAME);
        passwordPanel.add(passwordText);
        passwordPanel.add(password);

        val loginBtnPanel = new JPanel(new GridLayout(1, 3));
        loginButton = new JButton("Login");

        loginBtnPanel.add(new JPanel());
        loginBtnPanel.add(new JPanel());
        loginBtnPanel.add(loginButton);

        loginPane.setBorder(new EmptyBorder(10, 30, 10, 30));

        val roleRadioBtnPane = new JPanel(new GridLayout(1, 5));
        teachingManagerRoleRadioBtn = new JRadioButton("Teaching Manager");
        studentRoleRadioBtn = new JRadioButton("Student");

        val radioGroup = new ButtonGroup();


        radioGroup.add(teachingManagerRoleRadioBtn);
        radioGroup.add(studentRoleRadioBtn);
        radioGroup.setSelected(studentRoleRadioBtn.getModel(), true);

        roleRadioBtnPane.add(new JPanel());
        roleRadioBtnPane.add(new JPanel());
        roleRadioBtnPane.add(new JPanel());
        roleRadioBtnPane.add(teachingManagerRoleRadioBtn);
        roleRadioBtnPane.add(studentRoleRadioBtn);


        loginPane.add(new JPanel());
        loginPane.add(new JPanel());
        loginPane.add(new JPanel());
        loginPane.add(loginLabel);
        loginPane.add(new JPanel());
        loginPane.add(new JPanel());
        loginPane.add(usernamePane);
        loginPane.add(new JPanel());
        loginPane.add(new JPanel());
        loginPane.add(passwordPanel);
        loginPane.add(new JPanel());
        loginPane.add(roleRadioBtnPane);
        loginPane.add(new JPanel());
        loginPane.add(loginBtnPanel);
        loginPane.add(new JPanel());
        loginPane.add(new JPanel());
        loginPane.add(new JPanel());

        registerEventListener();

        this.setContentPane(loginPane);
    }

    private void registerEventListener() {
        studentRoleRadioBtn.addActionListener(e -> role = ROLE.STUDENT);
        teachingManagerRoleRadioBtn.addActionListener(e -> role = ROLE.TEACHING_MANAGER);
        loginButton.addActionListener(e -> login());
    }

    private void login() {
        try {

            UserService userService = null;

            if (role.equals(ROLE.STUDENT)) {
                userService = AppContext.studentService;


            } else if (role.equals(ROLE.TEACHING_MANAGER)) {
                userService = AppContext.teachingManagerService;
            }

            if (Objects.nonNull(userService)) {

                if (userService.login(username.getText(), password.getText())) {
                    val intent = new Intent<MenuScreen>();

                    val data = new HashMap<String,Object>();
                    data.put(USER_KEY, userService.findById(username.getText()));
                    data.put(ROLE_KEY,role);
                    intent.navigate(800,500, data);
                } else {
                    // Login fail
                    JOptionPane.showMessageDialog(this, "User name or password does not match");
                }

            } else {
                throw new IllegalStateException("User service is null");
            }

        } catch (UserNotFound e) {
            JOptionPane.showMessageDialog(this, "User not found");
        } catch (IllegalStateException illegalStateException) {
            JOptionPane.showMessageDialog(this, illegalStateException.getMessage());
        }


    }


}
