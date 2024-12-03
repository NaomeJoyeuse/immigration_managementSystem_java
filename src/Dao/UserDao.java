/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Model.User;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author Naome
 */
public class UserDao {
     public User RegisterUser(User userObj){
        
        try {
            Session ss=HibernateUtil.getSessionFactory().openSession();
            ss.save(userObj);
            ss.beginTransaction().commit();
            ss.close();
            return userObj;
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        
        
        return null;
    }
 
    public User UpdateUser(User userObj){
        
        try {
            Session ss=HibernateUtil.getSessionFactory().openSession();
            ss.update(userObj);
            ss.beginTransaction().commit();
            ss.close();
            return userObj;
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        
        
        return null;
    }
   
    public User DeleteUser(User userObj){
        
        try {
            Session ss=HibernateUtil.getSessionFactory().openSession();
            ss.delete(userObj);
            ss.beginTransaction().commit();
            ss.close();
            return userObj;
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        
        
        return null;
    }
    
    public User searching(User userObj){
        try {
            Session ss=HibernateUtil.getSessionFactory().openSession();
            
            User datauser=(User) ss.get(User.class,userObj.getId());
            return datauser;
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return null;
    }
    
     public List<User> allUser(){
        try {
            Session ss=HibernateUtil.getSessionFactory().openSession(); 
            List<User> listuser= ss.createQuery("select theuser from User theuser").list();
            return listuser;
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return null;
    } 
         public User loginUser(String email, String pass) {
        try {
            Session ss = HibernateUtil.getSessionFactory().openSession();

          
            String hql = "FROM User WHERE email = :email AND pass = :pass";
            Query query = ss.createQuery(hql);
            query.setParameter("email", email);
            query.setParameter("pass", pass);

            User user = (User) query.uniqueResult();
            
            ss.close();
            
            return user;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }
         public Long countEmailOccurrences(String email) {
        try {
            Session ss = HibernateUtil.getSessionFactory().openSession();

            String hql = "SELECT COUNT(*) FROM User WHERE email = :email";
            Query query = ss.createQuery(hql);
            query.setParameter("email", email);

            Long count = (Long) query.uniqueResult();

            ss.close();

            return count;
        } catch (Exception e) {
            e.printStackTrace();
        }

        
        return -1L; 
    }

}
