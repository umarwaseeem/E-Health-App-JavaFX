package ViewControllers;

import java.io.IOException;
import java.sql.SQLException;

import Controllers.SignupController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class PatientSignupDetailScreenController {
	
	public PatientSignupDetailScreenController() {

	}
	
	String patName;
	String patPassword;
	
	@FXML
	public void initialize() {
		System.out.println("Patient Signup Detail Screen initialized");
	}
	
	public void setPatNameAndPass(String name,  String password) {
		this.patName = name;
		this.patPassword = password;
	}
	
	@FXML
	TextField countryTextField;
	
	@FXML
	TextField cityTextField;
	
	@FXML
	TextField addressTextField;
	
	@FXML
	public void signupPatient(ActionEvent event) throws IOException, SQLException {
		System.out.println("Patient signup button clicked");
		String address = countryTextField.getText() + " "  + cityTextField.getText() +  " "  + addressTextField.getText();
		
		SignupController signupController = new SignupController();
		signupController.patientSignup(patName,patPassword, address);
		
		Navigator nav = new Navigator();
		nav.push("/SDAFInalProject/src/app/PatientOptionsPage.fxml", event);
	}
}
