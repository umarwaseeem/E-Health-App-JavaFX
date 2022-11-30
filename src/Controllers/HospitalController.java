package Controllers;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class HospitalController {

	Connection con;
	public HospitalController(){
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/e-health-care", "root", "umar");
			
			OutputUtil.printGreen("Database Connection Succesful 😍");
			
		} catch (Exception e) {
			e.printStackTrace();
			OutputUtil.printRed("Database Connection Failed 😡");
		}
	}
	
	public ObservableList<String> getListOfHospitals() throws SQLException{
		Statement stmnt = con.createStatement();
		
		String getHospitalsQuery = "SELECT Name FROM `e-health-care`.hospital;";
		ResultSet rs = stmnt.executeQuery(getHospitalsQuery);
		
		ObservableList<String> hospitals = FXCollections.observableArrayList();  
		
		while(rs.next()) {
			String hospitalName = rs.getString("Name");
			hospitals.add(hospitalName);
		}
		
		return hospitals;
	}
	
	public String getHospitalNameById(String id) throws SQLException {
		Statement stmnt = con.createStatement();
		
		String hospitalNameQuery = "SELECT name FROM `e-health-care`.hospital where Hospital_Id = '"+ id + "';";
		ResultSet rs = stmnt.executeQuery(hospitalNameQuery);
		
		String hospitalName = rs.getString("name");
		
		return hospitalName;
	}
	
	public String getHospitalIdByName(String name) throws SQLException{
		Statement stmnt = con.createStatement();
		
		String hospitalIdQuery = "SELECT Hospital_Id FROM `e-health-care`.hospital where Name = '"+ name + "';";
		ResultSet rs = stmnt.executeQuery(hospitalIdQuery);
		
		String hospitalId = "";
		while(rs.next()) {
			hospitalId = rs.getString("Hospital_Id");
		}
		
		return hospitalId;
		
	}
}
