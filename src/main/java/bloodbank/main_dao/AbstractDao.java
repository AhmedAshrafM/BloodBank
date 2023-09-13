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
 * @param <T>
 */
public abstract class AbstractDao<T> {
    
    HibernateSessionCon conn;
    public Session session;
    public AbstractDao() {
        conn = new HibernateSessionCon();
        session = conn.getSession();
    }
    
    public void insert(T s){
        conn.INSERT(s);
    }
    public void update(T s){
        conn.UPDATE(s);
    }
    public void delete(T s){
        conn.DELETE(s);
    }

}
