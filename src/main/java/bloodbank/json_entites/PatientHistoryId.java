package bloodbank.json_entites;
// Generated May 13, 2022 3:58:33 PM by Hibernate Tools 4.3.1



/**
 * PatientHistoryId generated by hbm2java
 */
public class PatientHistoryId  implements java.io.Serializable {


     private int patientId;
     private int diseaseId;

    public PatientHistoryId() {
    }

    public PatientHistoryId(int patientId, int diseaseId) {
       this.patientId = patientId;
       this.diseaseId = diseaseId;
    }
   
    public int getPatientId() {
        return this.patientId;
    }
    
    public void setPatientId(int patientId) {
        this.patientId = patientId;
    }
    public int getDiseaseId() {
        return this.diseaseId;
    }
    
    public void setDiseaseId(int diseaseId) {
        this.diseaseId = diseaseId;
    }


   public boolean equals(Object other) {
         if ( (this == other ) ) return true;
		 if ( (other == null ) ) return false;
		 if ( !(other instanceof PatientHistoryId) ) return false;
		 PatientHistoryId castOther = ( PatientHistoryId ) other; 
         
		 return (this.getPatientId()==castOther.getPatientId())
 && (this.getDiseaseId()==castOther.getDiseaseId());
   }
   
   public int hashCode() {
         int result = 17;
         
         result = 37 * result + this.getPatientId();
         result = 37 * result + this.getDiseaseId();
         return result;
   }   


}


