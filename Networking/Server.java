package com.mphasis.main;

import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) {
        ServerSocket server;
        try {
            server = new ServerSocket(7458);
            while (true) {
                Socket client = server.accept();
                System.out.println("client connected");
                OutputStream outputStream=client.getOutputStream();

                PrintWriter pw=new PrintWriter(
                        new OutputStreamWriter(outputStream));
                pw.write("hello");
                pw.close();
                client.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
