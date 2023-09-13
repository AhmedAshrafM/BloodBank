/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bloodbank.main_dao;

import org.hibernate.Session;

/**
 *
 * @author Ahmed
 */
public class HibernateSessionCon {

    private SessionProvider provider;
    private Session session;
    
    public HibernateSessionCon() {
    this.provider = SessionProvider.getSessionProvider();
    this.openCon();
    }
    
    public void openCon(){
        session = this.provider.getSession();
    }
    
    public void beginTrans(){
        session.beginTransaction();
    }
    
    public void commitTrans(){
        session.getTransaction().commit();
    }
    public void rollBack(){
        session.getTransaction().rollback();
    }
    public void closeCon(){
        provider.close();
    }
    public void clearCon(){
        provider.clear();
    }
    public void INSERT(Object T){
       session.persist(T); 
    }
    public void UPDATE(Object T){
        session.merge(T);
    }
    public void DELETE(Object T){
        session.delete(T);
    }
    public void SAVEorUpdate(Object T){
        session.saveOrUpdate(T);
    }

    public Session getSession(){
        return session;
    }
    
    
}
