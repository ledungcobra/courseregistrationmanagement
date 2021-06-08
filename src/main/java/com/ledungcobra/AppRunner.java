package com.ledungcobra;

import com.ledungcobra.applicationcontext.AppContext;
import com.ledungcobra.dto.Navigator;
import com.ledungcobra.scenes.LoginScreen;
import lombok.val;

public class AppRunner {
    public static void main(String[] args) throws ClassNotFoundException {

        // Load app context
        Class.forName(AppContext.class.getName());

        val intent = new Navigator<LoginScreen>();
        intent.navigate(700, 300, null);
    }
}
