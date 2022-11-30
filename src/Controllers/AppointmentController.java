package Controllers;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import Models.Appointment;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class AppointmentController {
	
	Connection con;
	ObservableList<Appointment> upcomingAppointments;
	ObservableList<Appointment> pastAppointments;
	
	private static AppointmentController instance;
	
	public AppointmentController() {
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
	
	public void saveAppointmentToDatabase(String time, String doctorName, String date, String patientID) throws SQLException{
		Statement stmnt = con.createStatement();
		
		System.out.println("Finding max appointment id");
//		find max appointment id
		String appointmentId = "";
		ResultSet rs = stmnt.executeQuery("SELECT max(Appointment_id) FROM `e-health-care`.appointment;");
		System.out.println("Query executed");
		while(rs.next()) {
			appointmentId = rs.getString("max(Appointment_id)");
		}
		
		int apptIdInteger = Integer.parseInt(appointmentId);
		apptIdInteger++;
		appointmentId = Integer.toString(apptIdInteger);
		
		System.out.println("Max appt id: " + appointmentId);

//      find doctor
		
		Statement stmnt2 = con.createStatement();
		
		int docId = 0;
		
		String query = "SELECT Doctor_id FROM `e-health-care`.doctor where Name = '" + doctorName + "';";
		
		ResultSet rs2 = stmnt2.executeQuery(query);
		
		while(rs2.next()) {
			docId = rs2.getInt("Doctor_id");
		}
		
		System.out.println("Doctor id for name " + doctorName + " found : " + docId);
//		
		Statement stmnt3 = con.createStatement();
		String insertAppointmentQuery = "INSERT INTO `e-health-care`.appointment  VALUES ('"+appointmentId+"', '"+time+"', 'Valid', '"+docId+"', '"+LoginController.userId+"', '"+date+"');";
		stmnt3.executeUpdate(insertAppointmentQuery);
		
//		INSERT INTO `e-health-care`.`appointment`  VALUES ('4', '6:40', 'Valid', '4', '4', '30-Feb-2023');
	}
	
}
