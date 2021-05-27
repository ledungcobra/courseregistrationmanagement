package com.ledungcobra;

import com.ledungcobra.applicationcontext.AppContext;
import com.ledungcobra.dto.Intent;
import com.ledungcobra.scenes.LoginScreen;
import lombok.val;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketAddress;

public class AppRunner {
    public static void main(String[] args) throws ClassNotFoundException {

        // Load app context
        Class.forName(AppContext.class.getName());

        val intent = new Intent<LoginScreen>();
        intent.navigate(700, 300, null);
    }
}
