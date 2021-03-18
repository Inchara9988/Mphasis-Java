package com.mphasis.main;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

public class ClientApp {
    public static void main(String[] args) {
        try {
            AuthenticationRemote remote=(AuthenticationRemote) Naming.lookup("rmi://localhost/RemoteAuthentication");
            System.out.println(remote.loginValidation("inchara","gowda"));
        } catch (NotBoundException e) {
            e.printStackTrace();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }
}
