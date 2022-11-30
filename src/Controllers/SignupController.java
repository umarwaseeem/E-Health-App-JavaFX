package Controllers;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SignupController {
	
	Connection con;
	
	public SignupController() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/e-health-care", "root", "umar");
			
			OutputUtil.printGreen("Database Connection Succesful 😍");
			
//			apptController = new AppointmentController(con);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			OutputUtil.printRed("Database Connection Failed 😡");
		}
	}
	
	public void doctorSignup(String userName, String password,String affiliatedHospitalId ,String speciality, String timings) throws SQLException {
		Statement stmnt = con.createStatement();
		
		System.out.println("Signing Up A New Doctor User");
		System.out.println("Username: " + userName);
		System.out.println("Password: " + password);
//		get max id from database to use as offset for next value
		
		String getMaxIdQuery = "SELECT max(Doctor_id) maxId FROM `e-health-care`.doctor;";
		ResultSet rs = stmnt.executeQuery(getMaxIdQuery);

		String doctorId = "";
		
		while(rs.next()) {
			doctorId = rs.getString("maxId");
		}
		
//		insert new record using maxId from database
		int docIdInteger = Integer.parseInt(doctorId);
		docIdInteger++;
		doctorId = Integer.toString(docIdInteger);
		System.out.println("New doctor id: " + doctorId);
		
		String signupQuery = "INSERT INTO `e-health-care`.`" + "doctor" +  "` VALUES ('" + doctorId + "', '" + userName + "', '"+ speciality + "', '" + affiliatedHospitalId +"', '" + timings + "', '"+ password + "');";
		
		@SuppressWarnings("unused")
		int rs1 = stmnt.executeUpdate(signupQuery);
		///////////
//		con.close();
	}
	
	
	@SuppressWarnings("unused")
	public void patientSignup(String userName, String password, String address) throws SQLException{
		Statement stmnt = con.createStatement();
		
		System.out.println("Signing Up A New Patient User");
		System.out.println("Username: " + userName);
		System.out.println("Password: " + password);
		
		String getMaxIdQuery = "SELECT max(Patient_id) maxId FROM `e-health-care`.patient;";
		ResultSet rs = stmnt.executeQuery(getMaxIdQuery);
		
		String patientId="";
		
		while(rs.next()) {
			patientId = rs.getString("maxId");
		}
		
		int patIdInteger = Integer.parseInt(patientId);
		patIdInteger++;
		patientId = Integer.toString(patIdInteger);
		
		String patientSignupQuery = "INSERT INTO `e-health-care`.`patient`  VALUES ('"+ patientId +"', '"+ userName +"', '"+ address +"', '"+ password +"');";
				
		int result = stmnt.executeUpdate(patientSignupQuery);
	}
	
	public void adminSignup(String userName , String password) throws SQLException {
		Statement stmnt = con.createStatement();
		
		System.out.println("Signing Up A New Patient User");
		System.out.println("Username: " + userName);
		System.out.println("Password: " + password);
		
		String adminSignupQuery = "INSERT INTO `e-health-care`.`admin` (`Name`, `Password`) VALUES ('"+userName+"', '"+password+"');";
		
		@SuppressWarnings("unused")
		int result = stmnt.executeUpdate(adminSignupQuery);
	}
	
	
}
