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
public class transaction_json {
    private Integer transaction_id;
    private String bag_id;
    private Integer patient_id;
    private Integer donor_id;
    private Date transaction_date;
    private String doctor_id;

    public transaction_json(){
        
    }
    public transaction_json(Integer transaction_id, String bag_id, Integer patient_id, Integer donor_id,Date transaction_date, String doctor_id) {
		this.transaction_id = transaction_id;
		this.bag_id = bag_id;
		this.patient_id = patient_id;
		this.donor_id = donor_id;
		this.transaction_date = transaction_date;
		this.doctor_id = doctor_id;
    }
	public Integer getTransactionId() {
        return transaction_id;
    }

    public void setTransactionId(Integer transaction_id) {
        this.transaction_id = transaction_id;
    }
    public String getBagId() {
        return bag_id;
    }

    public void setBagId(String bag_id) {
        this.bag_id = bag_id;
    }
    public Integer getPatientId() {
        return patient_id;
    }

    public void setPatientId(Integer patient_id) {
        this.patient_id = patient_id;
 
    } public Integer getDonorId() {
        return donor_id;
    }

    public void setDonorId(Integer donor_id) {
        this.donor_id = donor_id;
 
    }
	public Date getTransactionDate() {
        return transaction_date;
    }

    public void setTransactionDate(Date transaction_date) {
        this.transaction_date = transaction_date;
	}	
	public String getDoctorId() {
        return doctor_id;
    }

    public void setDoctorId(String doctor_id) {
        this.doctor_id = doctor_id;
    }
}
