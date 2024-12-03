/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service.Implementation;

import Dao.VisaDao;
import Model.Visa;
import Service.VisaService;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

/**
 *
 * @author Naome
 */
public class VisaImpl extends UnicastRemoteObject implements VisaService{

    public VisaImpl() throws RemoteException {
    }
    VisaDao dao=new VisaDao();
    @Override
    public Visa RegVisa(Visa visaObj) throws RemoteException {
    return dao.RegisterVisa(visaObj);
    }

    @Override
    public Visa updaVisa(Visa visaObj) throws RemoteException {
       return dao.UpdateVisa(visaObj);
    }

    @Override
    public Visa delVisa(Visa visaObj) throws RemoteException {
     return dao.DeleteVisa(visaObj);
    }

    @Override
    public Visa searchByVisa(Visa visaObj) throws RemoteException {
   return dao.searching(visaObj);
    }

    @Override
    public List<Visa> AllgivenVisa() throws RemoteException {
     return dao.allVisa();
    }
    
}
