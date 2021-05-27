package com.ledungcobra.test;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketAddress;

public class Main1 {
    public static void main(String[] args) {
        try {
            Socket socket = new Socket("localhost", 55555);
            SocketAddress socketAddress = new InetSocketAddress("localhost" , 33333);
            socket.connect(socketAddress);



        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
