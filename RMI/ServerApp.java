package com.mphasis.main;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RemoteException;

public class ServerApp {
    public static void main(String[] args) {
        AuthenticationRemoteImpl authenticationService=null;
        try {
             authenticationService=new AuthenticationRemoteImpl();
            Naming.rebind("rmi:///RemoteAuthentication",authenticationService);
            System.out.println("Remote object registered....");
        } catch (RemoteException | MalformedURLException e) {
            e.printStackTrace();
        }
    }
}
