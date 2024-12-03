/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;

import Model.Intent;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

/**
 *
 * @author Naome
 */
public interface IntentService extends Remote{
   Intent RegisterIntent(Intent intentObj)throws RemoteException;
   Intent UpdateIntent(Intent intentObj)throws RemoteException;
   Intent DeleteIntent(Intent intentObj)throws RemoteException;
    Intent SearchIntent(Intent intentObj)throws RemoteException;
    List<Intent>Allintents()throws RemoteException;
}
