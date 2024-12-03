/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;

import Model.Immigrant;
import Model.Visa;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

/**
 *
 * @author Naome
 */
public interface ImmigrantService extends Remote{
    Immigrant RegisterImmigra(Immigrant immigraObj)throws RemoteException;
    Immigrant UpdateImmigra(Immigrant immigraObj)throws RemoteException;
    Immigrant DeleteImmigra(Immigrant immigraObj)throws RemoteException;
    Immigrant SearchImmigra(Immigrant immigraObj)throws RemoteException;
    List<Immigrant> Allimmigrants() throws RemoteException;
    <Immigrant>int getnbrImmigrants()throws RemoteException;
     List<Visa> getFromALL(int immigrantId) throws RemoteException;
     int countPassport(String  passportNumber)throws RemoteException;
}
