/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service.Implementation;

import Dao.ImmigrantDao;
import Model.Immigrant;
import Model.Visa;
import Service.ImmigrantService;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

/**
 *
 * @author Naome
 */
public class ImmigrantImmplementation extends UnicastRemoteObject implements ImmigrantService {

    public ImmigrantImmplementation() throws RemoteException {
    }
    ImmigrantDao dao=new ImmigrantDao();
    @Override
    public Immigrant RegisterImmigra(Immigrant immigraObj) throws RemoteException {
      return dao.RegisterImmigrant(immigraObj);
    }

    @Override
    public Immigrant UpdateImmigra(Immigrant immigraObj) throws RemoteException {
      return dao.UpdateImmigrant(immigraObj);
    }

    @Override
    public Immigrant DeleteImmigra(Immigrant immigraObj) throws RemoteException {
      return dao.DeleteImmigrant(immigraObj);
    }

    @Override
    public Immigrant SearchImmigra(Immigrant immigraObj) throws RemoteException {
   return dao.searching(immigraObj);
    }

    @Override
    public List<Immigrant> Allimmigrants() throws RemoteException {
      return dao.allImmigrant();
    }
     @Override
    public int getnbrImmigrants() throws RemoteException {
       return dao.countImmigrants();
    }
     @Override
    public List<Visa> getFromALL(int immigrantId) throws RemoteException {
        return dao.getVisasByImmigrantId(immigrantId);
    }
      @Override
    public int countPassport(String  passportNumber) throws RemoteException {
       return dao.countPassportOccurrences( passportNumber);
    }
}
