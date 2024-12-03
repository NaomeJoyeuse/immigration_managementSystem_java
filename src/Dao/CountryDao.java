/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Model.Country;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.Projections;

/**
 *
 * @author Naome
 */
public class CountryDao {
   public Country RegisterCountry(Country countryObj){
        
        try {
            Session ss=HibernateUtil.getSessionFactory().openSession();
            ss.save(countryObj);
            ss.beginTransaction().commit();
            ss.close();
            return countryObj;
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        
        
        return null;
    }
    

    public Country UpdateCountry(Country countryObj){
        
        try {
            Session ss=HibernateUtil.getSessionFactory().openSession();
            ss.update(countryObj);
            ss.beginTransaction().commit();
            ss.close();
            return countryObj;
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        
        
        return null;
    }
  
    public Country DeleteCountry(Country countryObj){
        
        try {
            Session ss=HibernateUtil.getSessionFactory().openSession();
            ss.delete(countryObj);
            ss.beginTransaction().commit();
            ss.close();
            return countryObj;
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        
        
        return null;
    }
    
    public Country searching(Country countryObj){
        try {
            Session ss=HibernateUtil.getSessionFactory().openSession();
            
            Country dataCountries=(Country) ss.get(Country.class,countryObj.getCountryId());
            return dataCountries;
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return null;
    }
    
     public List<Country> allCountry(){
        try {
            Session ss=HibernateUtil.getSessionFactory().openSession(); 
            List<Country> listCountries= ss.createQuery("select theimmigra from Country theimmigra").list();
            return listCountries;
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return null;
    }  

//to count all countries in database
public int countAllCountries() {
    try {
        Session ss = HibernateUtil.getSessionFactory().openSession();

        // Use Criteria to count all registered countries
        Criteria criteria = ss.createCriteria(Country.class);
        criteria.setProjection(Projections.rowCount());
        Long count = (Long) criteria.uniqueResult();

        ss.close();

        return count != null ? count.intValue() : 0;
    } catch (Exception e) {
        e.printStackTrace();
    }

    return 0;
}


  


}





