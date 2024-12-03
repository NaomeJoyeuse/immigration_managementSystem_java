/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Model.Immigrant;
import Model.Visa;
import java.util.List;
import org.hibernate.Session;

/**
 *
 * @author Naome
 */
public class VisaDao {
   public Visa RegisterVisa(Visa visaObj){
        
        try {
            Session ss=HibernateUtil.getSessionFactory().openSession();
            ss.save(visaObj);
            ss.beginTransaction().commit();
            ss.close();
            return visaObj;
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        
        
        return null;
    }
 
    public Visa UpdateVisa(Visa visaObj){
        
        try {
            Session ss=HibernateUtil.getSessionFactory().openSession();
            ss.update(visaObj);
            ss.beginTransaction().commit();
            ss.close();
            return visaObj;
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        
        
        return null;
    }
   
//    public Visa DeleteVisa(Visa visaObj){
//        
//        try {
//            Session ss=HibernateUtil.getSessionFactory().openSession();
//            ss.delete(visaObj);
//            ss.beginTransaction().commit();
//            ss.close();
//            return visaObj;
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        
//        
//        
//        return null;
//    }
    
    /////////////////////////////////////
public Visa DeleteVisa(Visa visaObj) {
    try {
        Session ss = HibernateUtil.getSessionFactory().openSession();

        // Load the Visa entity along with its associated Immigrants
        Visa loadedVisa = (Visa) ss.get(Visa.class, visaObj.getVisaId());

        if (loadedVisa != null) {
            // Remove the association in the immigrant_visa table
            if (loadedVisa.getImmigrants() != null) {
                loadedVisa.getImmigrants().forEach(immigrant -> {
                    if (immigrant.getVisas() != null) {
                        immigrant.getVisas().remove(loadedVisa);
                    }
                });
            }

            // Set the immigrants field to null
            loadedVisa.setImmigrants(null);

            // No need to update the Visa entity, just commit the transaction
            ss.beginTransaction().commit();
        }

        ss.close();

        return visaObj;
    } catch (Exception e) {
        e.printStackTrace();
    }

    return null;
}

    

    
    public Visa searching(Visa visaObj){
        try {
            Session ss=HibernateUtil.getSessionFactory().openSession();
            
            Visa datavisa=(Visa) ss.get(Visa.class,visaObj.getVisaId());
            return datavisa;
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return null;
    }
    
     public List<Visa> allVisa(){
        try {
            Session ss=HibernateUtil.getSessionFactory().openSession(); 
            List<Visa> listvisa= ss.createQuery("select thevisa from Visa thevisa").list();
            return listvisa;
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return null;
    }  
}
