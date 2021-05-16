package com.ledungcobra;

import com.ledungcobra.applicationcontext.AppContext;
import com.ledungcobra.dto.Intent;
import com.ledungcobra.scenes.MenuScreen;
import lombok.val;

public class AppRunner {
    public static void main(String[] args) throws ClassNotFoundException {



        // Load app context
        Class.forName(AppContext.class.getName());

        val intent = new Intent<MenuScreen>();
        intent.navigate(700,500,null);


    }
}
