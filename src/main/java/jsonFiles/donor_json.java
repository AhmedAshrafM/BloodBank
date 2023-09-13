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
public class donor_json {
    private Integer donor_id;
    private String donor_first_name;
    private String donor_last_name;
    private String gender;
    private String address;
    private String blood_type;
    private String nat_id;
    private Date date_of_birth;
    private String primary_number;
    private String secondary_number;
    private String doctor_id;

    public donor_json(){
        
    }
    public donor_json(Integer donor_id,String donor_first_name, String donor_last_name, String gender, String address, 
String blood_type, String nat_id, Date date_of_birth, String primary_number, String secondary_number, String doctor_id) {
                this.donor_id = donor_id;
                this.donor_first_name = donor_first_name;
                this.donor_last_name = donor_last_name;
                this.gender = gender;
		this.address = address;
		this.blood_type = blood_type;
		this.nat_id = nat_id;
		this.date_of_birth = date_of_birth;
		this.primary_number = primary_number;
		this.secondary_number = secondary_number;
		this.doctor_id = doctor_id;
    }
    public Integer getDonorId() {
        return donor_id;
    }

    public void setDonorId(Integer donor_id) {
        this.donor_id = donor_id;
    }
    
    public String getDonorFirstName() {
        return donor_first_name;
    }

    public void setDonorFirstName(String donor_first_name) {
        this.donor_first_name = donor_first_name;
    }

    public String getDonorLastName() {
        return donor_last_name;
    }

    public void setDonorLastName(String donor_last_name) {
        this.donor_last_name = donor_last_name;
    }
    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
    public String getBloodType() {
        return blood_type;
    }

    public void setBloodType(String blood_type) {
        this.blood_type = blood_type;
    }public String getNatId() {
        return nat_id;
    }

    public void setNatId(String nat_id) {
        this.nat_id = nat_id;
    }public Date getDateOfBirth() {
        return date_of_birth;
    }

    public void setDateOfBirth(Date date_of_birth) {
        this.date_of_birth = date_of_birth;
    }public String getPrimaryNumber() {
        return primary_number;
    }
    public void setPrimaryNumber(String primary_number) {
        this.primary_number = primary_number;
    }
    public String getSecondaryNumber() {
        return secondary_number;
    }
    public void setSecondaryNumber(String secondary_number) {
        this.secondary_number = secondary_number;
    }public String getDoctorId() {
        return doctor_id;
    }

    public void setDoctorId(String doctor_id) {
        this.doctor_id = doctor_id;
    }
}
