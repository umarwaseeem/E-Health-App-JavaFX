package Controllers;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class LoginController {
	
	Connection con;
	
	static String userId;
	
	public LoginController() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/e-health-care", "root", "umar");
			
			OutputUtil.printGreen("Database Connection Succesful ");
			
		} catch (Exception e) {
			e.printStackTrace();
			OutputUtil.printRed("Database Connection Failed ");
		}
	}
	
	public boolean login(String userName, String password, String loginType) throws SQLException {
		Statement stmnt = con.createStatement();
		
//		System.out.println("Going to check if user exists in database");
//		System.out.println("Username: " + userName);
//		System.out.println("Password: " + password);
//		System.out.println("Login Type: " + loginType);
		
		String loginQuery = "SELECT * FROM `e-health-care`." + loginType  + " where password ='" + password + "'" +  "and name ='" + userName + "';";
		ResultSet rs = stmnt.executeQuery(loginQuery); 
		
		String name = "";
		
		while(rs.next()) {
			name = rs.getNString("Name");
			
			if(loginType.contains("doctor")) {
				userId = rs.getString("Doctor_id");
				System.out.println("Doctor id: " + userId);
			}
			else if(loginType.contains("admin")) {
				userId = rs.getString("Admin_id");
				System.out.println("Admin id: " + userId);
			}
			else if (loginType.contains("patient")) {
				userId = rs.getString("Patient_id");
				System.out.println("Patient id: " + userId);
			}
			
			System.out.println("Name: " + name);
		}
		
		if(name.isEmpty()) {
			return false;
		}
		return true;
	}
	
}
