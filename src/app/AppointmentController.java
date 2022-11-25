package app;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class AppointmentController {
	
	Connection con;
	ObservableList<Appointment> upcomingAppointments;
	ObservableList<Appointment> pastAppointments;
	
	private static AppointmentController instance;
	
	private AppointmentController() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/e-health-care", "root", "umar");
			
			OutputUtil.printGreen("Database Connection Succesful 😍");
			
			upcomingAppointments = FXCollections.observableArrayList();
			pastAppointments = FXCollections.observableArrayList();
			
		} catch (Exception e) {

			e.printStackTrace();
			OutputUtil.printRed("Database Connection Failed 😡");
		}
	}
	
//	singleton pattern
	public static AppointmentController getInstance() throws ClassNotFoundException, SQLException {
		if(instance == null) {
			instance = new AppointmentController();
		}
		return instance;
	}
	
	
	public ObservableList<Appointment> getUpcomingAppointmentData() throws SQLException {
		Statement stmnt = con.createStatement();
		
		System.out.println("Appointment data in table: ");
		
		ResultSet rs = stmnt.executeQuery("SELECT * FROM `e-health-care`.appointment WHERE `e-health-care`.appointment.Appointment_Status = 'Valid';");
		
		while(rs.next()) {
			String appointmentId = rs.getString("Appointment_id");
			String appointmentTime = rs.getString("Time");
			String doctorId = rs.getString("Doc_id");
			String patientId = rs.getString("Pat_id");
			String appointmentDate = rs.getString("Appointment_Date");
			
			String patientName = "";
			
			Statement stmnt2 = con.createStatement();
			ResultSet rs2 = stmnt2.executeQuery("SELECT patient.Name FROM `e-health-care`.patient where Patient_id =" + "'" + patientId + "';");
			
			while(rs2.next()) {
				patientName = rs2.getString("Name");
			}
			
			System.out.println("Pat Name: " + patientName +   "/ Appt Id: " + appointmentId + "/ Appt Time:" + appointmentTime + "/ Doc Id: " + doctorId + " Pat Id: " + patientId + "/ Appt Date: " + appointmentDate);
		
			upcomingAppointments.add(new Appointment(appointmentId, patientName,  appointmentDate,appointmentTime,patientId,doctorId));
		}
		
		return upcomingAppointments;
	}
	
	public ObservableList<Appointment> getPastAppointmentData() throws SQLException {
		Statement stmnt = con.createStatement();
		
		System.out.println("Appointment data in table: ");
		
		ResultSet rs = stmnt.executeQuery("SELECT * FROM `e-health-care`.appointment WHERE `e-health-care`.appointment.Appointment_Status = 'Invalid';");
		
		while(rs.next()) {
			String appointmentId = rs.getString("Appointment_id");
			String appointmentTime = rs.getString("Time");
			String doctorId = rs.getString("Doc_id");
			String patientId = rs.getString("Pat_id");
			String appointmentDate = rs.getString("Appointment_Date");
			
			String patientName = "";	
			
			Statement stmnt2 = con.createStatement();
			ResultSet rs2 = stmnt2.executeQuery("SELECT patient.Name FROM `e-health-care`.patient where Patient_id =" + "'" + patientId + "';");
			while(rs2.next()) {
				patientName = rs2.getString("Name");
			}
			
			System.out.println("Appt Id: " + appointmentId + "Appt Time: " + appointmentTime + "Doc Id: " + doctorId + "Pat Id: " + patientId + "Appt Date: " + appointmentDate);
		
			pastAppointments.add(new Appointment(appointmentId,patientName, appointmentDate,appointmentTime,patientId,doctorId));
		}
		
		return pastAppointments;
	}
	
}
