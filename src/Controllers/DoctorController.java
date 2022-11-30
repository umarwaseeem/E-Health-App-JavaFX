package Controllers;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class DoctorController {
	
	Connection con;
	ObservableList<String> allDoctorsNameList;
	ObservableList<String> doctorsByDiseaseList;
	
	public DoctorController() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/e-health-care", "root", "umar");
			
			OutputUtil.printGreen("Database Connection Succesful 😍");
			
			allDoctorsNameList = FXCollections.observableArrayList();
			doctorsByDiseaseList = FXCollections.observableArrayList();
			
		} catch (Exception e) {

			e.printStackTrace();
			OutputUtil.printRed("Database Connection Failed 😡");
		}
	}
	
	public ObservableList<String> getAvailableDoctors() throws SQLException {
		Statement st = con.createStatement();
		
		ResultSet rs = st.executeQuery("SELECT * FROM `e-health-care`.doctor;");
		
		while(rs.next()) {
			String name = rs.getString("Name");

			allDoctorsNameList.add(name);
			
			System.out.println("Name: " + name );
		}
		return allDoctorsNameList;
	}
	
	public ObservableList<String> getDoctorsByDisease(String disease) throws SQLException{
		Statement st = con.createStatement();
		
		System.out.println("Disease received in doctor controller: "+ disease);
		
		ResultSet rs = st.executeQuery("SELECT * FROM `e-health-care`.doctor where Speciality = '" + disease + "';");
		
		while(rs.next()) {
			String name = rs.getString("Name");
			System.out.println("Name1: " + name );
			
			doctorsByDiseaseList.add(name);
			System.out.println("Name2: " + name );
			
		}
		return doctorsByDiseaseList;
	}
	
	public List<String> numberOfDoctorsInEachHospital() throws SQLException {
		Statement st = con.createStatement();
		
		ResultSet rs = st.executeQuery("SELECT count(*) numOfDoctors FROM `e-health-care`.doctor group by AffiliatedHospital_Id;");
	
		List<String> count = new ArrayList<String>();
		
		while(rs.next()) {
			String numOfDoctors = rs.getString("numOfDoctors");
			count.add(numOfDoctors);
		}
		return count;
	}
}















 