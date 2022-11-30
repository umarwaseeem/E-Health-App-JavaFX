package Models;

public class Appointment {
	
	
	public String appointmentId;
	public String patientId;
	public String doctorId;
	public String patientName;
	public String appointmentDate;
	public String appointmentTime;
	
	///////////////
	

	public Appointment(String apptId, String name,  String date, String time, String patId, String docId) {
		this.appointmentId = apptId;
		this.patientName = name;
		this.appointmentDate = date;
		this.appointmentTime = time;
		this.patientId = patId;
		this.doctorId = docId;
	}

//	public void setId(String id) {
//		this.id = id;
//	}
//	
//	public void setPatientName(String patientName) {
//		this.patientName = patientName;
//	}
//	
//	public void setAppointmentDate(String appointmentDate) {
//		this.appointmentDate = appointmentDate;
//	}
//	
//	public void setAppointmentTime(String appointmentTime) {
//		this.appointmentTime = appointmentTime;
//	}
//	
	////////////////////////
	
	public String getAppointmentId() {
		return appointmentId;
	}
	
	public String getDoctorId() {
		return doctorId;
	}
	
	public String getPatientId() {
		return patientId;
	}
	
	public String getAppointmentDate() {
		return appointmentDate;
	}
	
	public String getAppointmentTime() {
		return appointmentTime;
	}
	
	public String getPatientName() {
		return patientName;
	}
}
