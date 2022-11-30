package ViewControllers;

import java.io.IOException;
import java.sql.SQLException;

import Controllers.SignupController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;


public class SignupScreenController {
	
	@FXML
	ImageView leftImageSignupScreen;
	
	String leftImagePath;
	
	@FXML
	Button continueButtonSignupScreen;
	
	@FXML
	Text signupScreenMainText;
	
	String mainText;
	
	@FXML
	TextField userNameTextFieldSignupScreen;
	
	@FXML
	TextField passwordTextFieldSignupScreen;
	
	public void setSignupScreenValues(String path, String text) {
		leftImagePath = path;
		mainText = text;
		
		signupScreenMainText.setText(mainText);
		leftImageSignupScreen.setImage(new javafx.scene.image.Image(leftImagePath));
	}
	
	public SignupScreenController() {
		
	}
	
	@FXML
	public void initialize() {
		System.out.println("Signup screen initialized");
	}
	
	
//	signup screen controller -> user specific detail screen
	@FXML
	public void goToContinueToDetailScreen(ActionEvent event) throws IOException, SQLException{
		System.out.println("Inside continue to detail screen function");
		
		if(mainText.contains("Doctor")) {
			doctorSignup(event);
		}
		else if(mainText.contains("Patient")) {
			patientSignup(event);
		}
		else if(mainText.contains("Admin")) {
			adminSignup(event);
		}
	}
	
	
	public void doctorSignup(ActionEvent event) throws IOException {
		System.out.println("Inside doctor signup function coming from continue detail screen function");
		
		Navigator nav = new Navigator();
		FXMLLoader loader = nav.push("/SDAFInalProject/src/Views/DoctorSignupDetailScreen.fxml", event);
		
		DoctorSignupDetailScreenController signupDetailScreenController = new DoctorSignupDetailScreenController();
		signupDetailScreenController = loader.getController();
		
		String docName = userNameTextFieldSignupScreen.getText();
		String docPassword = passwordTextFieldSignupScreen.getText();
		signupDetailScreenController.setDocNameAndPassword(docName, docPassword);
	}
	
//	if we came from selecting patient on signup select screen, then pressing continue button will execute this function
	public void patientSignup(ActionEvent event) throws IOException {
		System.out.println("Inside patient signup function coming from continue detail screen function");
	
		Navigator nav = new Navigator();
		FXMLLoader loader = nav.push("/SDAFInalProject/src/Views/PatientSignupDetailScreen.fxml", event);
	
		PatientSignupDetailScreenController patientSignupDetailScreenController = loader.getController();
		
		String patName = userNameTextFieldSignupScreen.getText();
		String patPassword = passwordTextFieldSignupScreen.getText();
		patientSignupDetailScreenController.setPatNameAndPass(patName, patPassword);
	}
	
	public void adminSignup(ActionEvent event) throws IOException, SQLException{
		System.out.println("Inside admin signup function coming from continue detail screen function");
		
		
		String adminName = userNameTextFieldSignupScreen.getText();
		String adminPassword = passwordTextFieldSignupScreen.getText();
		
		SignupController signupController = new SignupController();
		signupController.adminSignup(adminName, adminPassword);
		
		Navigator nav = new Navigator();
		nav.push("/SDAFInalProject/src/Views/AdminMainScreen.fxml", event);
	}
	
 	
}
