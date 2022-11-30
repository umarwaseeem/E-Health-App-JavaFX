package Models;

public class Doctor {

	String docId;
	String docName;
	String speciality;
	String affiliatedHospitalId;
	String timings;
	
	
	public Doctor() {	}

	public Doctor(String id, String name, String speciality, String hospitalId, String timings) {
		hospitalId = id;
		docName = name;
		this.speciality = speciality;
		affiliatedHospitalId = hospitalId;
		this.timings = timings;
	}
	
	public String getDocId() {
		return docId;
	}
	
	public String getAffiliatedHospitalId() {
		return affiliatedHospitalId;
	}
	
	public String getDocName() {
		return docName;
	}
	
	public String getSpeciality() {
		return speciality;
	}
	
	public String getTimings() {
		return timings;
	}
	
	/////////
	
	public void setAffiliatedHospitalId(String affiliatedHospitalId) {
		this.affiliatedHospitalId = affiliatedHospitalId;
	}
	
	public void setDocId(String docId) {
		this.docId = docId;
	}
	
	public void setDocName(String docName) {
		this.docName = docName;
	}
	
	public void setSpeciality(String speciality) {
		this.speciality = speciality;
	}
	
	public void setTimings(String timings) {
		this.timings = timings;
	}
	
	
}
