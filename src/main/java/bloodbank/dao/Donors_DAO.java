/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bloodbank.dao;

import bloodbank.entites.Donors;
import bloodbank.main_dao.AbstractDao;
import java.util.List;
import org.hibernate.Query;


/**
 *
 * @author Ahmed
 */
public class Donors_DAO<T> extends AbstractDao<T> {

    public List<Donors> GetAllDonors() {
        Query query = session.createQuery("SELECT d FROM Donors d ORDER BY d.donorId");
        List<Donors> dList = query.getResultList();
        return dList;
    }
    public List<Donors> GetDonorByNatId(String nat_id) {
        Query query = session.createQuery("SELECT d FROM Donors d WHERE d.natId=:nat_id");
        query.setString("nat_id", nat_id);
        List<Donors> dList = query.getResultList();
        return dList;
    }
}
