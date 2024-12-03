/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service.Implementation;

import Dao.CountryDao;
import Model.Country;
import Service.CountryService;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

/**
 *
 * @author Naome
 */
public class CountryImpl  extends UnicastRemoteObject implements CountryService{

    public CountryImpl() throws RemoteException{
    }
    CountryDao dao=new CountryDao();
    @Override
    public Country RegisterCountries(Country countryObj) throws RemoteException {
    return dao.RegisterCountry(countryObj);
    }

    @Override
    public Country UpdateCountries(Country countryObj) throws RemoteException {
    return dao.UpdateCountry(countryObj);
    }

    @Override
    public Country DeletCountries(Country countryObj) throws RemoteException {
    return dao.DeleteCountry(countryObj);
    }

    @Override
    public Country SearchCountries(Country countryObj) throws RemoteException {
     return dao.searching(countryObj);
    }

    @Override
    public List<Country> AllCountries() throws RemoteException {
    return dao.allCountry();
    }
    
    @Override
    public int getnbrCountries() throws RemoteException {
       return dao.countAllCountries();
    }
}
