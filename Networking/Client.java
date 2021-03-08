package com.mphasis.main;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;

public class Client {
    public static void main(String[] args) {
        try {
           Socket server= new Socket("LOCALHOST", 7458);
            InputStream is=server.getInputStream();
            DataInputStream dis=new DataInputStream(is);
            System.out.println(dis.readUTF());
            dis.close();
            server.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
