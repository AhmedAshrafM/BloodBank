/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bloodbank.dao;

import bloodbank.entites.Patients;
import bloodbank.main_dao.AbstractDao;
import java.util.List;
import org.hibernate.Query;

/**
 *
 * @author Ahmed
 */
public class Patients_DAO<T> extends AbstractDao {
    public List<Patients> GetAllPatients() {
        Query query = session.createQuery("SELECT p FROM Patients p ORDER BY p.patientId");
        List<Patients> pList = query.getResultList();
        return pList;
    }
    public List<Patients> GetPatientByNatId(String nat_id) {
        Query query = session.createQuery("SELECT p FROM Patients p WHERE p.natId=:nat_id");
        query.setString("nat_id", nat_id);
        List<Patients> pList = query.getResultList();
        return pList;
    }
    
}
