/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bloodbank.dao;

import bloodbank.entites.BloodStock;
import bloodbank.main_dao.AbstractDao;
import java.util.List;
import org.hibernate.Query;

/**
 *
 * @author Ahmed
 */
public class BloodStock_DAO<T> extends AbstractDao<T> {
    public List<BloodStock> GetAllBags() {
    Query query = session.createQuery("SELECT b FROM BloodStock b ORDER BY b.bagId");
    List<BloodStock> bsList = query.getResultList();
    return bsList;
    }
    public List<BloodStock> GetAvaliableBags() {
    Query query = session.createQuery("SELECT b FROM BloodStock b WHERE b.bagId NOT IN (SELECT b.bloodStock  FROM BloodTransactions b WHERE b.patients IS NOT NULL) ORDER BY b.bagId");
    //Query query = session.createQuery("SELECT bs FROM BloodStock bs, BloodTransactions bt WHERE bs.bagId = bt.bloodStock AND bt.donors IS NOT NULL ORDER BY bs.bagId");
    List<BloodStock> bsList = query.getResultList();
    return bsList;
    }
 public List<BloodStock> GetBagById(String bag_id) {
        Query query = session.createQuery("SELECT b FROM BloodStock b WHERE b.bagId=:bag_id");
        query.setString("bag_id", bag_id);
        List<BloodStock> bsList = query.getResultList();
        return bsList;
    }
    
}
