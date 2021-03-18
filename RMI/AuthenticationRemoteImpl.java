package com.mphasis.main;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class AuthenticationRemoteImpl extends UnicastRemoteObject implements AuthenticationRemote {
    protected AuthenticationRemoteImpl() throws RemoteException {
    }

    @Override
    public Person loginValidation(String userName, String password) throws RemoteException {
        if(userName !=null && password!=null){
            if(userName.equals("inchara")&&password.equals("pass")){
                return new Person(" inchara","gowda");
            }
        }
        return null;
    }
}
