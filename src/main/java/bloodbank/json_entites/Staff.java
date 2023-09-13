package bloodbank.json_entites;
// Generated May 13, 2022 3:58:33 PM by Hibernate Tools 4.3.1


import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Staff generated by hbm2java
 */
public class Staff  implements java.io.Serializable {


     private Integer empId;
     private EmpJobs empJobs;
     private String firstName;
     private String lastName;
     private String gender;
     private String address;
     private String bloodType;
     private String natId;
     private Date dateOfBirth;
     private String primaryNumber;
     private String secondaryNumber;
     private String salary;
     private Set donorses = new HashSet(0);
     private Set bloodTransactionses = new HashSet(0);
     private Set patientses = new HashSet(0);
     private Set bloodStocks = new HashSet(0);

    public Staff() {
    }

	
    public Staff(EmpJobs empJobs, String firstName, String lastName, String gender, String address, String bloodType, String natId, Date dateOfBirth, String primaryNumber, String salary) {
        this.empJobs = empJobs;
        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;
        this.address = address;
        this.bloodType = bloodType;
        this.natId = natId;
        this.dateOfBirth = dateOfBirth;
        this.primaryNumber = primaryNumber;
        this.salary = salary;
    }
    public Staff(EmpJobs empJobs, String firstName, String lastName, String gender, String address, String bloodType, String natId, Date dateOfBirth, String primaryNumber, String secondaryNumber, String salary, Set donorses, Set bloodTransactionses, Set patientses, Set bloodStocks) {
       this.empJobs = empJobs;
       this.firstName = firstName;
       this.lastName = lastName;
       this.gender = gender;
       this.address = address;
       this.bloodType = bloodType;
       this.natId = natId;
       this.dateOfBirth = dateOfBirth;
       this.primaryNumber = primaryNumber;
       this.secondaryNumber = secondaryNumber;
       this.salary = salary;
       this.donorses = donorses;
       this.bloodTransactionses = bloodTransactionses;
       this.patientses = patientses;
       this.bloodStocks = bloodStocks;
    }
   
    public Integer getEmpId() {
        return this.empId;
    }
    
    public void setEmpId(Integer empId) {
        this.empId = empId;
    }
    public EmpJobs getEmpJobs() {
        return this.empJobs;
    }
    
    public void setEmpJobs(EmpJobs empJobs) {
        this.empJobs = empJobs;
    }
    public String getFirstName() {
        return this.firstName;
    }
    
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    public String getLastName() {
        return this.lastName;
    }
    
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    public String getGender() {
        return this.gender;
    }
    
    public void setGender(String gender) {
        this.gender = gender;
    }
    public String getAddress() {
        return this.address;
    }
    
    public void setAddress(String address) {
        this.address = address;
    }
    public String getBloodType() {
        return this.bloodType;
    }
    
    public void setBloodType(String bloodType) {
        this.bloodType = bloodType;
    }
    public String getNatId() {
        return this.natId;
    }
    
    public void setNatId(String natId) {
        this.natId = natId;
    }
    public Date getDateOfBirth() {
        return this.dateOfBirth;
    }
    
    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }
    public String getPrimaryNumber() {
        return this.primaryNumber;
    }
    
    public void setPrimaryNumber(String primaryNumber) {
        this.primaryNumber = primaryNumber;
    }
    public String getSecondaryNumber() {
        return this.secondaryNumber;
    }
    
    public void setSecondaryNumber(String secondaryNumber) {
        this.secondaryNumber = secondaryNumber;
    }
    public String getSalary() {
        return this.salary;
    }
    
    public void setSalary(String salary) {
        this.salary = salary;
    }
    public Set getDonorses() {
        return this.donorses;
    }
    
    public void setDonorses(Set donorses) {
        this.donorses = donorses;
    }
    public Set getBloodTransactionses() {
        return this.bloodTransactionses;
    }
    
    public void setBloodTransactionses(Set bloodTransactionses) {
        this.bloodTransactionses = bloodTransactionses;
    }
    public Set getPatientses() {
        return this.patientses;
    }
    
    public void setPatientses(Set patientses) {
        this.patientses = patientses;
    }
    public Set getBloodStocks() {
        return this.bloodStocks;
    }
    
    public void setBloodStocks(Set bloodStocks) {
        this.bloodStocks = bloodStocks;
    }




}


