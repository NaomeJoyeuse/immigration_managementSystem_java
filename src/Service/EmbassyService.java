/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;

import Model.Embassy;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

/**
 *
 * @author Naome
 */
public interface EmbassyService extends Remote{
    Embassy RegisterEmb(Embassy embassObj)throws RemoteException;
    Embassy UpdateEmb(Embassy embassObj) throws RemoteException;
    Embassy DeleteEmb(Embassy embassObj) throws RemoteException;
    Embassy SearchEmb(Embassy embassObj) throws RemoteException;
    List<Embassy>AllEmbacies()throws RemoteException;
    Embassy getAnEmb(int embassyId) throws RemoteException;
    List<Embassy>checkCountry(int country_id)throws   RemoteException;
}
