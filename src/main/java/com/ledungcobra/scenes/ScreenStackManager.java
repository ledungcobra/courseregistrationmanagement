package com.ledungcobra.scenes;

import lombok.NonNull;
import lombok.val;

import javax.swing.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Stack;

public class ScreenStackManager {

    private static ScreenStackManager INSTANCE;

    public static ScreenStackManager getInstance() {
        if (Objects.isNull(INSTANCE)) {
            INSTANCE = new ScreenStackManager();
        }
        return INSTANCE;
    }

    private Stack<Screen> screensStack;

    private ScreenStackManager() {
        screensStack = new Stack<>();
    }

    public void pushScreen(@NonNull Screen screen) {

        if (!screensStack.isEmpty()) {
            hideScreen(screensStack.peek());
        }
        screensStack.push(screen);
        showScreen(screen);

    }

    private void showScreen(@NonNull Screen screen) {
        screen.setVisible(true);
        screen.show();
    }

    private void hideScreen(@NonNull Screen screen) {
        screen.setVisible(false);
        screen.hide();
    }

    public void popTopScreen() {
        if (screensStack.size() > 1) {
            screensStack.pop();
        }
        val elements = screensStack.elements();
        while (elements.hasMoreElements()) {
            val currentScreen = elements.nextElement();
            hideScreen(currentScreen);
        }
        if (!screensStack.isEmpty()) {
            showScreen(screensStack.peek());
        }

    }


}