package com.ledungcobra.scenes;

import lombok.NonNull;
import lombok.val;

import java.awt.*;
import java.awt.event.WindowEvent;
import java.util.Objects;
import java.util.Stack;

public class ScreenStackManager {

    private static ScreenStackManager INSTANCE;

    public static  ScreenStackManager getInstance() {
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
        screen.setLocationRelativeTo(null);
        screen.setVisible(true);
    }
    private void hideScreen(@NonNull Screen screen){
        screen.setVisible(false);
    }
    private void closeScreen(@NonNull Screen screen) {
        WindowEvent winClosingEvent = new WindowEvent(screen,WindowEvent.WINDOW_CLOSING);
        Toolkit.getDefaultToolkit().getSystemEventQueue().postEvent(winClosingEvent);
    }

    public void popTopScreen() {
        if (screensStack.size() > 1) {
            val currentScreen = screensStack.pop();
            hideScreen(currentScreen);
        }

        if (!screensStack.isEmpty()) {
            showScreen(screensStack.peek());
        }

    }

}
