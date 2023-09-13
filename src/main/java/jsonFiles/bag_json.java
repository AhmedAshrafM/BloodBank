/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jsonFiles;

import bloodbank.entites.Staff;
import java.util.Date;

/**
 *
 * @author Ahmed
 */
public class bag_json {
    private String bag_id;
    private String blood_type;
    private Date donation_date;
    private String doctor_id;

    public bag_json(){
        
    }
    public bag_json(String bag_id, String blood_type,Date donation_date, String doctor_id) {
		this.bag_id = bag_id;
		this.blood_type = blood_type;
		this.donation_date = donation_date;
		this.doctor_id = doctor_id;
    }

    public String getBagId() {
        return bag_id;
    }

    public void setBagId(String bag_id) {
        this.bag_id = bag_id;
    }
    public String getBloodType() {
        return blood_type;
    }

    public void setBloodType(String blood_type) {
        this.blood_type = blood_type;
 
    }public Date getDonationDate() {
        return donation_date;
    }

    public void setDonationDate(Date donation_date) {
        this.donation_date = donation_date;
	}	
	public String getDoctorId() {
        return doctor_id;
    }

    public void setDoctorId(String doctor_id) {
        this.doctor_id = doctor_id;
    }
}
