/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bloodbank.main_dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 *
 * @author Ahmed
 */
public class SessionProvider {
    SessionFactory factory;
    private static SessionProvider provider; // Object of self class

    ThreadLocal <Session> t1 = new ThreadLocal<>();
    
    // Single tone arc.
    public static SessionProvider getSessionProvider(){
        if(provider == null){
        provider = new SessionProvider();
        }
        return provider;
    }
            
            
    public SessionProvider() {
       Configuration config = new Configuration().configure("hibernate.cfg.xml");
       factory = config.buildSessionFactory();
    }
    public Session getSession(){
        Session session = t1.get();
        if(session == null){
            session = factory.openSession();
            t1.set(session);
        }
        return session;
    }
    
    void close(){
     getSession().close();
     t1.set(null);
    }

    void clear(){
        getSession().clear();
    }

    
}
