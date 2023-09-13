/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bloodbank.dao;

import bloodbank.entites.Staff;
import bloodbank.main_dao.AbstractDao;
import java.util.List;
import org.hibernate.Query;

/**
 *
 * @author Ahmed
 */
public class Staff_DAO<T> extends AbstractDao<T> {
    public List<Staff> GetAllStaff() {
        Query query = session.createQuery("SELECT s FROM Staff s ORDER BY s.empId");
        List<Staff> sList = query.getResultList();
        return sList;
    }
    public List<Staff> GetStaffByNatId(String nat_id) {
        Query query = session.createQuery("SELECT s FROM Staff s WHERE s.natId=:nat_id");
        query.setString("nat_id", nat_id);
        List<Staff> sList = query.getResultList();
        return sList;
    }
}
