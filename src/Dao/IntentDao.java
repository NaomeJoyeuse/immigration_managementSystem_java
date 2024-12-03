/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Model.Intent;
import java.util.List;
import org.hibernate.Session;

/**
 *
 * @author Naome
 */
public class IntentDao {
     public Intent RegisterIntent(Intent intentObj){
        
        try {
            Session ss=HibernateUtil.getSessionFactory().openSession();
            ss.save(intentObj);
            ss.beginTransaction().commit();
            ss.close();
            return intentObj;
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        
        
        return null;
    }
    
    /////////////////////////////////////////////////
    public Intent UpdateIntent(Intent intentObj){
        
        try {
            Session ss=HibernateUtil.getSessionFactory().openSession();
            ss.update(intentObj);
            ss.beginTransaction().commit();
            ss.close();
            return intentObj;
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        
        
        return null;
    }
    ////////////////////////////////
    public Intent DeleteIntent(Intent intentObj){
        
        try {
            Session ss=HibernateUtil.getSessionFactory().openSession();
            ss.delete(intentObj);
            ss.beginTransaction().commit();
            ss.close();
            return intentObj;
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        
        
        return null;
    }
    
    public Intent searching(Intent intentObj){
        try {
            Session ss=HibernateUtil.getSessionFactory().openSession();
            
            Intent dataintent=(Intent) ss.get(Intent.class,intentObj.getIntentID());
            return dataintent;
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return null;
    }
    
     public List<Intent> allIntent(){
        try {
            Session ss=HibernateUtil.getSessionFactory().openSession(); 
            List<Intent> listintent= ss.createQuery("select theintent from Intent theintent").list();
            return listintent;
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return null;
    }
}
