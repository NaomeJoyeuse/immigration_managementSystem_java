/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service.Implementation;

import Dao.EmbassyDao;
import Model.Embassy;
import Service.EmbassyService;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

/**
 *
 * @author Naome
 */
public class EmbassyImpl extends UnicastRemoteObject implements EmbassyService{

    public EmbassyImpl() throws RemoteException{
    }
    EmbassyDao dao=new EmbassyDao();
    
    @Override
    public Embassy RegisterEmb(Embassy embassObj) throws RemoteException {
   return dao.RegisterEmbassy(embassObj);
    }

    @Override
    public Embassy UpdateEmb(Embassy embassObj) throws RemoteException {
      return dao.UpdateEmbassy(embassObj);
    }

    @Override
    public Embassy DeleteEmb(Embassy embassObj) throws RemoteException {
   return dao.DeleteEmbassy(embassObj);
    }

    @Override
    public Embassy SearchEmb(Embassy embassObj) throws RemoteException {
    return dao.searching(embassObj);
    }

    @Override
    public List<Embassy> AllEmbacies() throws RemoteException {
      return dao.allEmbassy();
    }
      @Override
    public Embassy getAnEmb(int embassyId) throws RemoteException {
    return dao.getEmbassyById(embassyId);
    }
     @Override
    public List<Embassy>checkCountry(int country_id)throws RemoteException {
      return dao.getEmbassiesByCountry(country_id);
    }
    
}
