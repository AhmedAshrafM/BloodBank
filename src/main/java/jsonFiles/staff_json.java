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
public class staff_json {
    private Integer emp_id;
    private String staff_first_name;
    private String staff_last_name;
    private String gender;
    private String address;
    private String blood_type;
    private String nat_id;
    private Date date_of_birth;
    private String primary_number;
    private String secondary_number;
    private String salary;
    private String job_id;

    public staff_json(){
        
    }
    public staff_json(Integer emp_id, String staff_first_name, String staff_last_name, String gender, String address, 
String blood_type, String nat_id, Date date_of_birth, String primary_number, String secondary_number, String salary, String job_id) {
                this.emp_id = emp_id;
                this.staff_first_name = staff_first_name;
                this.staff_last_name = staff_last_name;
                this.gender = gender;
		this.address = address;
		this.blood_type = blood_type;
		this.nat_id = nat_id;
		this.date_of_birth = date_of_birth;
		this.primary_number = primary_number;
		this.secondary_number = secondary_number;
		this.salary = salary;
		this.job_id = job_id;
    }
    public Integer getEmpId() {
        return emp_id;
    }

    public void setEmpId(Integer emp_id) {
        this.emp_id = emp_id;
    }
    public String getStaffFirstName() {
        return staff_first_name;
    }

    public void setStaffFirstName(String staff_first_name) {
        this.staff_first_name = staff_first_name;
    }

    public String getStaffLastName() {
        return staff_last_name;
    }

    public void setStaffLastName(String staff_last_name) {
        this.staff_last_name = staff_last_name;
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
    }
	public String getSalary() {
        return salary;
    }
    public void setSalary(String salary) {
        this.salary = salary;
    }
	public String getJobId() {
        return job_id;
    }

    public void setJobId(String job_id) {
        this.job_id = job_id;
    }
}
