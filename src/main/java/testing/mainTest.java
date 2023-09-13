/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testing;

import bloodbank.entites.BloodStock;
import bloodbank.entites.Staff;
import bloodbank.main_dao.HibernateSessionCon;
import java.util.Date;

/**
 *
 * @author Ahmed
 */
public class mainTest {
    public static void main(String[] args){
        HibernateSessionCon con = new HibernateSessionCon();
        try{
        String Blood_Type = "A-";
        Date Donation_Date = new Date();
        int Doctor_id = 13;
       
        BloodStock b = new BloodStock();
        Staff staff = con.getSession().get(Staff.class,Doctor_id);
        
        b.setBloodType(Blood_Type);
        b.setDonationDate(Donation_Date);
        b.setStaff(staff);
        
              
        
        con.beginTrans();
        
        con.commitTrans();
        }
        catch (Exception e){
        con.rollBack();
        System.out.println("Error !");
        }
        
    }
    
}
