package ViewControllers;



import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;

import javafx.scene.image.ImageView;



public class LoginSelectController {
	
	@FXML
	ImageView doctorImage;
	
	@FXML
	ImageView patientImage;
	
	@FXML
	ImageView adminImage;

	LoginScreenController loginScreenController = new  LoginScreenController();

	// no argument constructor
	public LoginSelectController() {

	}
	
	@FXML
	public void initialize() {
		System.out.println("Login select screen initialized");
	}
	
	@FXML
	public void changeToSignupSelectScreen(ActionEvent event) throws IOException {
		System.out.println("Change to signup select screen button clicked");
		
		Navigator nav = new Navigator();
		nav.push("/SDAFInalProject/src/Views/SignupScreenSelect.fxml", event);
	}
	
	
	@FXML
	public void goToDoctorLoginScreen(ActionEvent event) throws IOException {
		System.out.println("Doctor Login Button Clicked");

		Navigator nav = new Navigator();
		FXMLLoader loader = nav.push("/SDAFInalProject/src/Views/LoginScreen.fxml", event);
		
		LoginScreenController loginScreenController = loader.getController();
		
		loginScreenController.setValues(doctorImage.getImage().getUrl(), "Doctor");
	}
	
	@FXML
	public void goToPatientLoginScreen(ActionEvent event) throws IOException {
		System.out.println("Patient Login Button Clicked");

		Navigator nav = new Navigator();
		FXMLLoader loader = nav.push("/SDAFInalProject/src/Views/LoginScreen.fxml", event);
		
		LoginScreenController loginScreenController = loader.getController();
		
		loginScreenController.setValues(patientImage.getImage().getUrl(), "Patient");
	}
	
	@FXML
	public void goToAdminLoginScreen(ActionEvent event) throws IOException {
		System.out.println("Admin Login Button Clicked");

		Navigator nav = new Navigator();
		FXMLLoader loader = nav.push("/SDAFInalProject/src/Views/LoginScreen.fxml", event);
		
		LoginScreenController loginScreenController = loader.getController();
		
		loginScreenController.setValues(adminImage.getImage().getUrl(), "Admin");
	}

}
