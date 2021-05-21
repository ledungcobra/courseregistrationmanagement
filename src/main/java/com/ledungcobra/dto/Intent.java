package com.ledungcobra.dto;

import com.ledungcobra.anotations.BackButton;
import com.ledungcobra.interfaces.Backable;
import com.ledungcobra.scenes.Screen;
import com.ledungcobra.scenes.ScreenStackManager;
import lombok.SneakyThrows;
import lombok.val;

import javax.swing.*;
import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.Map;

public class Intent<T extends Screen> implements Backable {

    private Class<T> clazz;
    private T screen;

    @SneakyThrows
    public Intent(T... t) {
        clazz = (Class<T>) t.getClass().getComponentType();
        screen = clazz.newInstance();
    }

    @SneakyThrows
    public void addGoBackListener() {
        try{
            for (Field field : screen.getClass().getDeclaredFields()) {
                field.setAccessible(true);

                Annotation[] annotations = field.getDeclaredAnnotations();
                for (Annotation annotation : annotations) {
                    if(annotation instanceof  BackButton){
                        JButton button = (JButton) field.get(screen);
                        button.addActionListener(e -> ScreenStackManager.getInstance().popTopScreen());
                        break;
                    }
                }
            }
        }catch (Exception e){

        }


    }

    public void navigate(int width, int height, Map<String, Object> data) {
        screen.setSize(width, height);
        screen.setData(data);
        screen.onCreateView();
        screen.addEventListener();
        addGoBackListener();

        ScreenStackManager.getInstance().pushScreen(screen);
    }

    public void navigate(Map<String, Object> data) {
        screen.setData(data);
        screen.onCreateView();
        screen.addEventListener();
        addGoBackListener();

        ScreenStackManager.getInstance().pushScreen(screen);
    }

    public void navigate() {
        screen.onCreateView();
        screen.addEventListener();
        addGoBackListener();

        ScreenStackManager.getInstance().pushScreen(screen);
    }


}
