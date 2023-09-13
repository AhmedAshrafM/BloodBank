/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jsonFiles;

import java.util.Date;

/**
 *
 * @author Ahmed
 */
public class patient_json {
   private Integer patient_id;
    private String patient_first_name;
    private String patient_last_name;
    private String gender;
    private String address;
    private String blood_type;
    private String nat_id;
    private Date date_of_birth;
    private String primary_number;
    private String secondary_number;
    private String doctor_id;

    public patient_json(){
        
    }
    public patient_json(String patient_first_name, String patient_last_name, String gender, String address, 
String blood_type, String nat_id, Date date_of_birth, String primary_number, String secondary_number, String doctor_id) {
                this.patient_id = patient_id;
                this.patient_first_name = patient_first_name;
                this.patient_last_name = patient_last_name;
                this.gender = gender;
		this.address = address;
		this.blood_type = blood_type;
		this.nat_id = nat_id;
		this.date_of_birth = date_of_birth;
		this.primary_number = primary_number;
		this.secondary_number = secondary_number;
		this.doctor_id = doctor_id;
    }
    public Integer getPatientId() {
        return patient_id;
    }

    public void setPatientId(Integer patient_id) {
        this.patient_id = patient_id;
    }

    public String getPatientFirstName() {
        return patient_first_name;
    }

    public void setPatientFirstName(String patient_first_name) {
        this.patient_first_name = patient_first_name;
    }

    public String getPatientLastName() {
        return patient_last_name;
    }

    public void setPatientLastName(String patient_last_name) {
        this.patient_last_name = patient_last_name;
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
