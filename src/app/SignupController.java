package app;

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
	
	public void doctorSignup(String userName, String password,String affiliatedHospitalId ,String speciality, String timings, String loginType) throws SQLException {
		Statement stmnt = con.createStatement();
		
		System.out.println("Signing Up A New User");
		System.out.println("Username: " + userName);
		System.out.println("Password: " + password);
		System.out.println("Login Type: " + loginType);
		
		String doctorId = "5";
		
		String signupQuery = "INSERT INTO `e-health-care`.`" + loginType +  "` VALUES ('" + doctorId + "', '" + userName + "', '"+ speciality + "', '" + affiliatedHospitalId +"', '" + timings + "', '"+ password+"');";
		
		ResultSet rs = stmnt.executeQuery(signupQuery);
		///////////
		con.close();
	}
	
	
}
