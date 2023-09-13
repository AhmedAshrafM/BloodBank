package bloodbank.json_entites;
// Generated May 13, 2022 3:58:33 PM by Hibernate Tools 4.3.1


import java.util.HashSet;
import java.util.Set;

/**
 * Diseases generated by hbm2java
 */
public class Diseases  implements java.io.Serializable {


     private Integer diseaseId;
     private String diseaseName;
     private Set donorses = new HashSet(0);
     private Set patientHistories = new HashSet(0);

    public Diseases() {
    }

	
    public Diseases(String diseaseName) {
        this.diseaseName = diseaseName;
    }
    public Diseases(String diseaseName, Set donorses, Set patientHistories) {
       this.diseaseName = diseaseName;
       this.donorses = donorses;
       this.patientHistories = patientHistories;
    }
   
    public Integer getDiseaseId() {
        return this.diseaseId;
    }
    
    public void setDiseaseId(Integer diseaseId) {
        this.diseaseId = diseaseId;
    }
    public String getDiseaseName() {
        return this.diseaseName;
    }
    
    public void setDiseaseName(String diseaseName) {
        this.diseaseName = diseaseName;
    }
    public Set getDonorses() {
        return this.donorses;
    }
    
    public void setDonorses(Set donorses) {
        this.donorses = donorses;
    }
    public Set getPatientHistories() {
        return this.patientHistories;
    }
    
    public void setPatientHistories(Set patientHistories) {
        this.patientHistories = patientHistories;
    }




}


