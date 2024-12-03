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
import org.hibernate.Transaction;

/**
 *
 * @author Naome
 */
public class ImmigrantDao {
     public Immigrant RegisterImmigrant(Immigrant immigraObj){
        
        try {
            Session ss=HibernateUtil.getSessionFactory().openSession();
            ss.save(immigraObj);
            ss.beginTransaction().commit();
            ss.close();
            return immigraObj;
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        
        
        return null;
    }
    

    public Immigrant UpdateImmigrant(Immigrant immigraObj){
        
        try {
            Session ss=HibernateUtil.getSessionFactory().openSession();
            ss.update(immigraObj);
            ss.beginTransaction().commit();
            ss.close();
            return immigraObj;
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        
        
        return null;
    }
  
    public Immigrant DeleteImmigrant(Immigrant immigraObj){
        
        try {
            Session ss=HibernateUtil.getSessionFactory().openSession();
            ss.delete(immigraObj);
            ss.beginTransaction().commit();
            ss.close();
            return immigraObj;
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        
        
        return null;
    }
    
    public Immigrant searching(Immigrant immigraObj){
        try {
            Session ss=HibernateUtil.getSessionFactory().openSession();
            
            Immigrant dataimmigra=(Immigrant) ss.get(Immigrant.class,immigraObj.getImmigrantID());
            return dataimmigra;
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return null;
    }
    
     public List<Immigrant> allImmigrant(){
        try {
            Session ss=HibernateUtil.getSessionFactory().openSession(); 
            List<Immigrant> listimmigra= ss.createQuery("select theimmigra from Immigrant theimmigra").list();
            return listimmigra;
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return null;
    }
         public int countImmigrants() {
        try {
            Session ss = HibernateUtil.getSessionFactory().openSession();
            Integer count = ((Number) ss.createQuery("select count(*) from Immigrant").uniqueResult()).intValue();
            ss.close();
            return count != null ? count : 0;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return 0;
    }
public List<Visa> getVisasByImmigrantId(int immigrantId) {
    List<Visa> visas = null;
    Session session = null;
    Transaction transaction = null;

    try {
        // Open a session
        session = HibernateUtil.getSessionFactory().openSession();
        transaction = session.beginTransaction();

        // Retrieve the Immigrant entity along with its visas within the same session
        Immigrant immigrant = (Immigrant) session.get(Immigrant.class, immigrantId);

        if (immigrant != null) {
            // Access the visas collection within the session
            visas = immigrant.getVisas();
        }

        // Commit the transaction
        transaction.commit();
    } catch (Exception e) {
        // Roll back the transaction in case of an exception
        if (transaction != null) {
            transaction.rollback();
        }
        e.printStackTrace();
    } finally {
        // Close the session in a finally block to ensure it's closed even if an exception occurs
        if (session != null && session.isOpen()) {
            session.close();
        }
    }

    return visas;
}
    public int countPassportOccurrences(String  passportNumber) {
        Session session = null;
        try {
          
            session = HibernateUtil.getSessionFactory().openSession();

            
            Long count = (Long) session.createQuery("select count(*) from Immigrant where passportNumber = :passportNumber")
                    .setParameter("passportNumber",  passportNumber)
                    .uniqueResult();

          
            return count != null ? count.intValue() : 0;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
          
            if (session != null && session.isOpen()) {
                session.close();
            }
        }

        return 0;
    }

}
