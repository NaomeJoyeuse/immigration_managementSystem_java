/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

import Service.Implementation.CountryImpl;
import Service.Implementation.EmbassyImpl;
import Service.Implementation.ImmigrantImmplementation;
import Service.Implementation.IntentImpl;
import Service.Implementation.UserImplementation;
import Service.Implementation.VisaImpl;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import org.omg.CORBA.REBIND;

/**
 *
 * @author Naome
 */
public class Server {
      public static void main(String[] args) {
    
          try {
            System.setProperty("java.rmi.server.hostname", "127.0.0.1");
            Registry regist=LocateRegistry.createRegistry(5000);
            regist.rebind("usa", new UserImplementation());
            regist.rebind("pais", new CountryImpl());
            regist.rebind("vista",new VisaImpl());
            regist.rebind("immigra", new ImmigrantImmplementation());
            regist.rebind("intention", new IntentImpl());
            regist.rebind("emba",new EmbassyImpl());
           
            System.out.println("Server Is Ranning on Port 5000");
             Thread.currentThread().join();
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        
    }
}
