package ViewControllers;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Controllers.HospitalController;
import Controllers.SignupController;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;

public class DoctorSignupDetailScreenController {
	
	public DoctorSignupDetailScreenController() {
		
	}
	
	@FXML
	public void initialize() {
		System.out.println("Doctor Signup Detail Screen initialized");
		try {
			getHospitalsAffiliatedToSystem();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	@FXML
	ComboBox<String> hospitalsCombobox;

	
	@FXML
	public void getHospitalsAffiliatedToSystem() throws SQLException {
		HospitalController hospitalController = new HospitalController();
		List<String> hospitals =new ArrayList<String>(); 
		hospitals = hospitalController.getListOfHospitals();
		hospitalsCombobox.setItems(FXCollections.observableArrayList(hospitals));
	}
	
	@FXML
	TextField specialityTextField;
	
	@FXML
	TextField timingsTextField;
	
	String docName;
	String docPassword;
	
	public void setDocNameAndPassword(String docName, String docPassword) {
		this.docName = docName;
		this.docPassword = docPassword;
	}
	
	@FXML
	public void signupDoctor(ActionEvent event) throws SQLException, IOException {
		System.out.println("Signup doctor button clicked");
		String timings = timingsTextField.getText();
		String speciality = specialityTextField.getText();
		
		System.out.println("Timings for new doctor: " + timings);
		System.out.println("Speciality of new doctor: " + speciality);
		
		
//		get selected hospital from combo box
		HospitalController hospitalController = new HospitalController();
		String hospital = hospitalsCombobox.getValue();
		System.out.println("Hospital name for new doctor: " + hospital);
		
		String affiliatedHospitalId = hospitalController.getHospitalIdByName(hospital);
		
		System.out.println("Hospital id for new doctor:  " + affiliatedHospitalId);
		
//		query to signup doctor
		SignupController controller = new SignupController();
		controller.doctorSignup(docName, docPassword, affiliatedHospitalId, speciality, timings);
		
		Navigator nav = new Navigator();
		nav.push("/SDAFInalProject/src/Views/DoctorMainScreen.fxml", event);
	}
	
}
