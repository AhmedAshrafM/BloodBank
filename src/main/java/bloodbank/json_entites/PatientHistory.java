package bloodbank.json_entites;
// Generated May 13, 2022 3:58:33 PM by Hibernate Tools 4.3.1



/**
 * PatientHistory generated by hbm2java
 */
public class PatientHistory  implements java.io.Serializable {


     private PatientHistoryId id;
     private Diseases diseases;
     private Patients patients;

    public PatientHistory() {
    }

    public PatientHistory(PatientHistoryId id, Diseases diseases, Patients patients) {
       this.id = id;
       this.diseases = diseases;
       this.patients = patients;
    }
   
    public PatientHistoryId getId() {
        return this.id;
    }
    
    public void setId(PatientHistoryId id) {
        this.id = id;
    }
    public Diseases getDiseases() {
        return this.diseases;
    }
    
    public void setDiseases(Diseases diseases) {
        this.diseases = diseases;
    }
    public Patients getPatients() {
        return this.patients;
    }
    
    public void setPatients(Patients patients) {
        this.patients = patients;
    }




}


