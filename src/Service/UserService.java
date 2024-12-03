/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;

import Model.User;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

/**
 *
 * @author Naome
 */
public interface UserService  extends Remote{
    User RegisterUsers(User userObj)throws RemoteException;
     User UpdateUsers(User userObj)throws RemoteException;
      User DelUsers(User userObj)throws RemoteException;
       User SearchUsers(User userObj)throws RemoteException;
       List<User>AllUsers() throws RemoteException;
       User loginMyUser(String email, String pass) throws RemoteException;
       Long countEmail(String email) throws RemoteException;
       
}
