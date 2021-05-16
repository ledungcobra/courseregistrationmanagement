package com.ledungcobra.scenes;

import com.ledungcobra.applicationcontext.AppContext;
import com.ledungcobra.entites.User;
import lombok.val;

import javax.swing.*;
import java.awt.*;
import java.util.Map;

import static com.ledungcobra.scenes.LoginScreen.USER;
import static javax.swing.SwingConstants.NORTH;
import static javax.swing.SwingConstants.WEST;

public class MenuScreen extends Screen {



    @Override
    public void onCreateView() {
        val data = getData();
        val user = AppContext.studentService.findById("18120331");


        val mainPanel = new JPanel();
        val borderLayout = new BorderLayout();
        mainPanel.setLayout(borderLayout);

        val menuBar = new JMenuBar();
        val jMenu = new JMenu("User");

        val userInfo = new JMenuItem("User Info");
        val logout = new JMenuItem("Logout");

        jMenu.add(userInfo);
        jMenu.add(logout);

        menuBar.add(jMenu);

        val welcomePanel =new JPanel();
        welcomePanel.add(new JLabel("Hello " + user.getUserName()));

        // Set up layout
        mainPanel.add(menuBar,BorderLayout.NORTH);
        mainPanel.add(welcomePanel,BorderLayout.CENTER);


        this.setContentPane(mainPanel);
    }

}
