/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Model.Embassy;
import java.util.Collections;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author Naome
 */
public class EmbassyDao {
  public Embassy RegisterEmbassy(Embassy embassObj){
        
        try {
            Session ss=HibernateUtil.getSessionFactory().openSession();
            ss.save(embassObj);
            ss.beginTransaction().commit();
            ss.close();
            return embassObj;
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        
        
        return null;
    }
    

    public Embassy UpdateEmbassy(Embassy embassObj){
        
        try {
            Session ss=HibernateUtil.getSessionFactory().openSession();
            ss.update(embassObj);
            ss.beginTransaction().commit();
            ss.close();
            return embassObj;
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        
        
        return null;
    }
  
    public Embassy DeleteEmbassy(Embassy embassObj){
        
        try {
            Session ss=HibernateUtil.getSessionFactory().openSession();
            ss.delete(embassObj);
            ss.beginTransaction().commit();
            ss.close();
            return embassObj;
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        
        
        return null;
    }
    
    public Embassy searching(Embassy embassObj){
        try {
            Session ss=HibernateUtil.getSessionFactory().openSession();
            
            Embassy dataembass=(Embassy) ss.get(Embassy.class,embassObj.getEmbassyId());
            return dataembass;
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return null;
    }
    
     public List<Embassy> allEmbassy(){
        try {
            Session ss=HibernateUtil.getSessionFactory().openSession(); 
            List<Embassy> listembass= ss.createQuery("select theembass from Embassy theembass").list();
            return listembass;
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return null;
    } 
     //to get embassy by its id
     public Embassy getEmbassyById(int embassyId) {
        try {
            Session ss = HibernateUtil.getSessionFactory().openSession();
            Embassy embassy = (Embassy) ss.get(Embassy.class, embassyId);
            ss.close();
            return embassy;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }
 public List<Embassy> getEmbassiesByCountry(int country_id) {
    try {
        Session session = HibernateUtil.getSessionFactory().openSession();

        String hql = "FROM Embassy E WHERE E.country.id = :country_id";
        Query query = session.createQuery(hql);
        query.setParameter("country_id", country_id);

        List<Embassy> embassies = (List<Embassy>) query.list();
        session.close();

        return embassies;
    } catch (Exception e) {
        e.printStackTrace();
    }

    return Collections.emptyList();
}

}
