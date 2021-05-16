package com.ledungcobra.scenes;

import lombok.val;

import javax.swing.*;
import java.awt.*;
import java.util.Map;


public abstract class Screen extends JFrame {

    protected Map<String,Object> data;



    public Screen() throws HeadlessException {
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setVisible(false);
        this.hide();

        this.pack();
        this.setLocationRelativeTo(null);

        try {
            UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
            SwingUtilities.updateComponentTreeUI(this);
        } catch (Exception e) {
            System.out.println("Error setting the LAF..." + e);
        }


    }

    @Override
    public void setSize(int width, int height) {

        super.setSize(width, height);

        val x = this.getX();
        val y = this.getY();

        this.setLocation(x-width/2,y-height/2);
    }

    public abstract void onCreateView();

    public void setData(Map<String, Object> data) {
        this.data = data;
    }

    public Map<String, Object> getData() {
        return data;
    }
}
