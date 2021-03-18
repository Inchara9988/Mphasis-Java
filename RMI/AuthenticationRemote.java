package com.mphasis.main;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface AuthenticationRemote extends Remote {
    public Person loginValidation(String userName, String password) throws RemoteException;
}
