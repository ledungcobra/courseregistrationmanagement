package com.ledungcobra.dto;

import com.ledungcobra.anotations.BackButton;
import com.ledungcobra.anotations.SearchTextField;
import com.ledungcobra.interfaces.Searchable;
import com.ledungcobra.scenes.Screen;
import com.ledungcobra.utils.ScreenStackManager;
import lombok.SneakyThrows;

import javax.swing.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.Map;

public class Intent<T extends Screen> {

    private Class<T> clazz;
    private T screen;

    @SneakyThrows
    public Intent(T... t) {
        clazz = (Class<T>) t.getClass().getComponentType();
        screen = clazz.newInstance();
    }

    @SneakyThrows
    private void addGoBackListener() {
        try {
            for (Field field : screen.getClass().getDeclaredFields()) {
                field.setAccessible(true);

                Annotation[] annotations = field.getDeclaredAnnotations();
                for (Annotation annotation : annotations) {
                    if (annotation instanceof BackButton) {
                        JButton button = (JButton) field.get(screen);
                        button.addActionListener(e -> ScreenStackManager.getInstance().popTopScreen());
                        break;
                    }
                }
            }


        } catch (Exception e) {
        }
    }

    @SneakyThrows
    private void addOnEnterPressSearch() {
        try {
            for (Field field : screen.getClass().getDeclaredFields()) {
                field.setAccessible(true);
                Annotation[] annotations = field.getDeclaredAnnotations();
                for (Annotation annotation : annotations) {
                    if (annotation instanceof SearchTextField) {
                        JTextField searchField = (JTextField) field.get(screen);
                        searchField.addKeyListener(new KeyListener() {
                            @Override
                            public void keyTyped(KeyEvent e) {
                            }

                            @Override
                            public void keyPressed(KeyEvent e) {

                            }

                            @Override
                            public void keyReleased(KeyEvent e) {
                                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                                    if (screen instanceof Searchable) {
                                        ((Searchable) screen).searchBtnActionPerformed(null);
                                    }
                                }
                            }
                        });
                        break;
                    }
                }
            }


        } catch (Exception e) {
        }
    }

    private void registerAnnotationProcessing(){
        addGoBackListener();
        addOnEnterPressSearch();
    }

    public void navigate(int width, int height, Map<String, Object> data) {
        screen.setSize(width, height);
        screen.setData(data);
        screen.onCreateView();
        screen.addEventListener();
        registerAnnotationProcessing();

        ScreenStackManager.getInstance().pushScreen(screen);
    }

    public void navigate(Map<String, Object> data) {
        screen.setData(data);
        screen.onCreateView();
        screen.addEventListener();
        registerAnnotationProcessing();

        ScreenStackManager.getInstance().pushScreen(screen);
    }

    public void navigate() {
        screen.onCreateView();
        screen.addEventListener();
        registerAnnotationProcessing();

        ScreenStackManager.getInstance().pushScreen(screen);
    }


}
