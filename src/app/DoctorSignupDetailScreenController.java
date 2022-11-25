package app;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;

public class DoctorSignupDetailScreenController {
	
	public DoctorSignupDetailScreenController() {
		
	}
	
	@FXML
	public void initialize() {
		System.out.println("Doctor Signup Detail Screen initialized");
		try {
			getHospitalsAffiliatedToSystem();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@FXML
	ComboBox<String> hospitalsCombobox;

	
	@FXML
	public void getHospitalsAffiliatedToSystem() throws SQLException {
		Connection con = null;
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
		
		Statement stmnt = con.createStatement();
		
		String getHospitalsQuery = "SELECT Name FROM `e-health-care`.hospital;";
		ResultSet rs = stmnt.executeQuery(getHospitalsQuery);
		
		List<String> hospitals =new ArrayList<String>();  
		
		while(rs.next()) {
			String hospitalName = rs.getString("Name");
			hospitals.add(hospitalName);
		}
		
//		return names or add them to the combo box
		hospitalsCombobox.setItems(FXCollections.observableArrayList(hospitals));
	}
	
}
