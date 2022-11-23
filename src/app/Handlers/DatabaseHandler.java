package app.Handlers;



import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import app.Utilities.OutputUtil;

public class DatabaseHandler {
	
	Connection con;
	
	public DatabaseHandler(){
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/umardb", "root", "umar");
			
			OutputUtil.printGreen("Database Connection Succesfull");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			OutputUtil.printRed("Database Connection Failed");
		}
	}
	
	public void insert(String rollNumber, String name, String batch, String section) {
		try {
			String sql = "INSERT INTO Person (rollNum,name,batch,sec) VALUES (?, ?, ?, ?)";
			PreparedStatement statement = con.prepareStatement(sql);
			
			statement.setString(1, rollNumber);
			statement.setString(2, name);
			statement.setString(3, batch);
			statement.setString(4, section);
			
			int rowsInserted = statement.executeUpdate();
			
			if(rowsInserted > 0) {
				System.out.println("Student inserted");
			}
		}
		catch (Exception e) {
			System.out.println(e);
		}
	}
	
	public void displayData() {
		try {
			Statement stmnt = con.createStatement();
			
			System.out.println("Current data in table: ");
			
			ResultSet rs = stmnt.executeQuery("select * from person");
			
			while(rs.next()) {
				String r = rs.getString("rollNum");
				String n = rs.getString("name");
				String b = rs.getString("batch");
				String s = rs.getString("sec");
				
				System.out.println(r + " " + n + " " + b + " " + s);
			}
			
			con.close();
		}
		catch(Exception e) {
			System.out.println(e);
		}
	}
}
