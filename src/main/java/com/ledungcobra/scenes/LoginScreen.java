package com.ledungcobra.scenes;

import com.ledungcobra.applicationcontext.AppContext;
import com.ledungcobra.dto.Intent;
import com.ledungcobra.exception.UserNotFound;
import com.ledungcobra.scenes.generatedscreen.StudentMenuScreen;
import com.ledungcobra.scenes.generatedscreen.TeachingManagerMenuScreen;
import com.ledungcobra.service.UserService;
import lombok.val;

import javax.persistence.NoResultException;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
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


    private JTextField usernameTextField;
    private JPasswordField passwordTextField;
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


        usernameTextField = new JTextField(USERNAME);
        val usernamePane = new JPanel(new GridLayout(1, 2));
        usernamePane.add(userNameLabel);
        usernamePane.add(usernameTextField);

        val passwordText = new JLabel("Password");
        passwordTextField = new JPasswordField(USERNAME);
        passwordPanel.add(passwordText);
        passwordPanel.add(passwordTextField);

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
        this.setContentPane(loginPane);
    }

    @Override
    public void addEventListener() {
        studentRoleRadioBtn.addActionListener(e -> role = ROLE.STUDENT);
        teachingManagerRoleRadioBtn.addActionListener(e -> role = ROLE.TEACHING_MANAGER);
        loginButton.addActionListener(e -> login());

        loginButton.setMnemonic(KeyEvent.VK_L);

        val onEnterEvent = new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {

            }

            @Override
            public void keyPressed(KeyEvent e) {

            }

            @Override
            public void keyReleased(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    login();
                }
            }
        };

        usernameTextField.addKeyListener(onEnterEvent);
        passwordTextField.addKeyListener(onEnterEvent);

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
                if (userService.login(usernameTextField.getText(), passwordTextField.getText())) {
                    Intent intent = null;

                    if (role.equals(ROLE.TEACHING_MANAGER)) {
                        intent = new Intent<TeachingManagerMenuScreen>();
                    } else if (role.equals(ROLE.STUDENT)) {
                        intent = new Intent<StudentMenuScreen>();
                    }

                    val data = new HashMap<String, Object>();

                    data.put(USER_KEY, userService.findById(usernameTextField.getText()));
                    data.put(ROLE_KEY, role);

                    intent.navigate(data);
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
        } catch (NoResultException e) {
            JOptionPane.showMessageDialog(this, "User not found");
        }


    }


}
