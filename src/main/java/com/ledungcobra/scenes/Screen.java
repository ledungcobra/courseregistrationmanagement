package com.ledungcobra.scenes;

import com.ledungcobra.utils.ScreenStackManager;
import lombok.val;

import javax.swing.*;
import java.awt.*;
import java.util.Map;


public abstract class Screen extends JFrame
{

    protected Map<String, Object> data;


    public Screen() throws HeadlessException
    {
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setVisible(false);

        this.setLocationRelativeTo(null);
        this.pack();

        try
        {
            UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
            SwingUtilities.updateComponentTreeUI(this);
        } catch (Exception e)
        {
            JOptionPane.showMessageDialog(null, "Error when change appearance to windows look and feel");
        }


    }

    @Override
    public void setSize(int width, int height)
    {

        super.setSize(width, height);

        val x = this.getX();
        val y = this.getY();

        this.setLocation(x - width / 2, y - height / 2);
    }

    public abstract void onCreateView();

    public abstract void addEventListener();

    public void setData(Map<String, Object> data)
    {
        this.data = data;
    }

    public Map<String, Object> getData()
    {
        return data;
    }

    protected void finish()
    {
        ScreenStackManager.getInstance().popTopScreen();
    }

}
