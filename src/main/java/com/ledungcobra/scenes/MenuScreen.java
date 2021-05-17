package com.ledungcobra.scenes;

import com.ledungcobra.entites.Student;
import com.ledungcobra.entites.TeachingManager;
import com.ledungcobra.entites.User;
import com.ledungcobra.service.StudentService;
import lombok.val;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Map;

import static com.ledungcobra.scenes.LoginScreen.USER_KEY;

public class MenuScreen extends Screen implements ActionListener {


    private JMenuItem userInfo;
    private JMenuItem logout;
    private JPanel mainPanel;
    private JPanel centerPanel;
    private JPanel contentPanel;
    private Map<String, Object> data;
    private User user;
    private LoginScreen.ROLE role;


    @Override
    public void onCreateView() {


        data = getData();
        user = (User) data.get(USER_KEY);


        mainPanel = new JPanel();
        val borderLayout = new BorderLayout();
        mainPanel.setLayout(borderLayout);

        val menuBar = new JMenuBar();
        val jMenu = new JMenu("User");

        userInfo = new JMenuItem("User Info");
        logout = new JMenuItem("Logout");

        userInfo.addActionListener(this);
        logout.addActionListener(this);

        jMenu.add(userInfo);
        jMenu.add(logout);

        menuBar.add(jMenu);

        centerPanel = new JPanel();
        centerPanel.add(new JLabel("Hello " + user.getUserName()));

        // Set up layout
        mainPanel.add(menuBar, BorderLayout.NORTH);
        mainPanel.add(centerPanel, BorderLayout.CENTER);


        this.setContentPane(mainPanel);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource().equals(logout)) {
            logout();
        } else if (e.getSource().equals(userInfo)) {
            viewUserInfo();
        }

    }

    private void logout() {
        finish();
    }

    private void viewUserInfo() {


        contentPanel = new JPanel(new GridLayout(0, 2));
        contentPanel.setBorder(new EmptyBorder(30,30,30,30));
        if (user instanceof Student) {
            Student student = (Student) user;

            contentPanel.add(new JLabel("ID"));
            contentPanel.add(new JLabel(student.getId()));

            contentPanel.add(new JLabel("Username"));
            val username = new JTextField(student.getUserName());
            contentPanel.add(username);


            contentPanel.add(new JLabel("Password"));
            contentPanel.add(new JPasswordField(student.getPassword()));

            contentPanel.add(new JLabel("Gender"));
            ButtonGroup group = new ButtonGroup();
            JRadioButton boy = new JRadioButton("Boy");
            JRadioButton girl = new JRadioButton("Girl");
            group.add(boy);
            group.add(girl);

            group.setSelected(student.getGender().equalsIgnoreCase("Boy") ? boy.getModel() : girl.getModel(), true);

            val genderPanel = new JPanel(new FlowLayout());
            genderPanel.add(boy);
            genderPanel.add(girl);

            contentPanel.add(genderPanel);



        } else if (user instanceof TeachingManager) {
            TeachingManager teachingManager = (TeachingManager) user;
        }
        mainPanel.add(contentPanel);

        SwingUtilities.updateComponentTreeUI(this.mainPanel);
        mainPanel.invalidate();
        mainPanel.validate();
        mainPanel.repaint();
    }


}
