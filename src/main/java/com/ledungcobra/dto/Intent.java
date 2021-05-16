package com.ledungcobra.dto;

import com.ledungcobra.scenes.Screen;
import com.ledungcobra.scenes.ScreenStackManager;
import lombok.SneakyThrows;

import java.util.Map;

public class Intent <T extends Screen> {

    private Class<T> clazz;

    public Intent(T ...t) {
        clazz = (Class<T>) t.getClass().getComponentType();
    }

    @SneakyThrows
    public void navigate(int width, int height, Map<String, Object> data){
        T screen = clazz.newInstance();
        screen.setSize(width,height);
        screen.setData(data);
        screen.onCreateView();
        ScreenStackManager.getInstance().pushScreen(screen);

    }
}
