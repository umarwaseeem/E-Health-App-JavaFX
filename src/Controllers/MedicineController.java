package Controllers;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class MedicineController {
	
	Connection con;
	
	public MedicineController() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/e-health-care", "root", "umar");
			
			OutputUtil.printGreen("Database Connection Succesful 😍");
			
			medicines = FXCollections.observableArrayList();
//			apptController = new AppointmentController(con);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			OutputUtil.printRed("Database Connection Failed 😡");
		}
	}

	ObservableList<String> medicines;
	
	public ObservableList<String> getMedicines() throws SQLException {
		Statement st = con.createStatement();
		
		ResultSet rs = st.executeQuery("SELECT Medset_info names FROM `e-health-care`.medicine;");
		
		while(rs.next()) {
			String medName = rs.getString("names");
			
			medicines.add(medName);
		}
		
		return medicines;
	}
}




