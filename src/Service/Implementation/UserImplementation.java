/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service.Implementation;

import Dao.UserDao;
import Model.User;
import Service.UserService;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

/**
 *
 * @author Naome
 */
public class UserImplementation extends UnicastRemoteObject implements UserService{

    public UserImplementation() throws RemoteException{
    }
    UserDao dao =new UserDao();

    @Override
    public User RegisterUsers(User userObj) throws RemoteException {
       return dao.RegisterUser(userObj);
    }

    @Override
    public User UpdateUsers(User userObj) throws RemoteException {
      return dao.UpdateUser(userObj);
    }

    @Override
    public User DelUsers(User userObj) throws RemoteException {
    return dao.DeleteUser(userObj);
    }

    @Override
    public User SearchUsers(User userObj) throws RemoteException {
     return dao.searching(userObj);
    }

    @Override
    public List<User> AllUsers() throws RemoteException {
       return dao.allUser();
    }
     @Override
    public User loginMyUser(String email, String pass)throws RemoteException {
   
        return dao.loginUser(email, pass);
    }
      @Override    
    public Long countEmail(String email) throws RemoteException {
        return dao.countEmailOccurrences(email);
}
}
