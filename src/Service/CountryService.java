/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;

import Model.Country;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

/**
 *
 * @author Naome
 */
public interface CountryService extends Remote{
  Country RegisterCountries(Country countryObj)throws RemoteException;
  Country UpdateCountries(Country countryObj)throws RemoteException; 
  Country DeletCountries(Country countryObj)throws RemoteException;
  Country SearchCountries(Country countryObj)throws RemoteException;
  List<Country> AllCountries()throws RemoteException;
   <Country> int getnbrCountries() throws RemoteException;
}
