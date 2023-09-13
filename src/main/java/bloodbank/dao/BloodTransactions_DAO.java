/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bloodbank.dao;

import bloodbank.entites.BloodTransactions;
import bloodbank.main_dao.AbstractDao;
import java.util.List;
import org.hibernate.Query;

/**
 *
 * @author Ahmed
 */
public class BloodTransactions_DAO<T> extends AbstractDao<T> {
   public List<BloodTransactions> GetDonorsTransactions() {
    Query query = session.createQuery("SELECT b FROM BloodTransactions b WHERE b.patients IS NULL ORDER BY b.transactionId");
    List<BloodTransactions> btList = query.getResultList();
    return btList;
    }  
    public List<BloodTransactions> GetPatientsTransactions() {
    Query query = session.createQuery("SELECT b FROM BloodTransactions b WHERE b.donors IS NULL ORDER BY b.transactionId");
    List<BloodTransactions> btList = query.getResultList();
    return btList;
    }  
   public List<BloodTransactions> GetTransactionById(String transaction_id) {
        Query query = session.createQuery("SELECT b FROM BloodTransactions b WHERE b.transactionId:tranasction_id");
        query.setString("bag_id", transaction_id);
        List<BloodTransactions> btList = query.getResultList();
        return btList;
    }
}
