/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service.Implementation;

import Dao.IntentDao;
import Model.Intent;
import Service.IntentService;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

/**
 *
 * @author Naome
 */
public class IntentImpl extends UnicastRemoteObject implements IntentService{

    public IntentImpl() throws RemoteException{
    }
    IntentDao dao=new IntentDao();
    @Override
    public Intent RegisterIntent(Intent intentObj) throws RemoteException {
     return  dao.RegisterIntent(intentObj);
    }

    @Override
    public Intent UpdateIntent(Intent intentObj) throws RemoteException {
     return dao.UpdateIntent(intentObj);
    }

    @Override
    public Intent DeleteIntent(Intent intentObj) throws RemoteException {
        return dao.DeleteIntent(intentObj);
    }

    @Override
    public Intent SearchIntent(Intent intentObj) throws RemoteException {
        return  dao.searching(intentObj);
    }

    @Override
    public List<Intent> Allintents() throws RemoteException {
   return dao.allIntent();
    }
    
}
