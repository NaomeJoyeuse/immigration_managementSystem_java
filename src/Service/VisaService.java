/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;

import Model.Visa;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

/**
 *
 * @author Naome
 */
public interface VisaService extends Remote {
   Visa RegVisa(Visa visaObj)throws RemoteException; 
   Visa updaVisa(Visa visaObj)throws RemoteException; 
   Visa delVisa(Visa visaObj)throws RemoteException; 
   Visa searchByVisa(Visa visaObj)throws RemoteException; 
   List<Visa>AllgivenVisa() throws RemoteException;
}
