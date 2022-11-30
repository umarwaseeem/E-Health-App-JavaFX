package ViewControllers;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;

public class SignupScreenSelectController {

	@FXML
	Button doctorSignupButton;
	
	@FXML
	Button patientSignupButton;
	
	@FXML
	Button adminSignupButton;
	
	@FXML
	ImageView doctorSignupImage;
	
	@FXML
	ImageView patientSignupImage;
	
	@FXML
	ImageView adminSignupImage;
	
	
	public SignupScreenSelectController (){
		
	}
	
	@FXML
	public void changeToLoginSelectScreen(ActionEvent event)throws IOException  {
		System.out.println("Change to login select screen button clicked");
		
		Navigator nav = new Navigator();
		nav.push("/SDAFInalProject/src/Views/LoginSelect.fxml", event);
	}
	
	@FXML
	public void initialize() {
		System.out.println("Signup Select Screen Initialized");
	}
	
	@FXML
	public void goToDoctorSignupScreen(ActionEvent event)throws IOException{
		System.out.println("Doctor signup button clicked");
		
		Navigator nav = new Navigator();
		FXMLLoader loader = nav.push("/SDAFInalProject/src/Views/SignupScreen.fxml", event);
		
		SignupScreenController controller = new SignupScreenController();
		controller = loader.getController();
		
		controller.setSignupScreenValues(doctorSignupImage.getImage().getUrl(), "Signup as a Doctor");
	}
	
	@FXML
	public void goToPatientSignupScreen(ActionEvent event)throws IOException{
		System.out.println("Patient signup button clicked");
		
		Navigator nav = new Navigator();
		FXMLLoader loader = nav.push("/SDAFInalProject/src/Views/SignupScreen.fxml", event);
		
		SignupScreenController controller = new SignupScreenController();
		controller = loader.getController();
		
		controller.setSignupScreenValues(patientSignupImage.getImage().getUrl(), "Signup as a Patient");
	}
	
	@FXML
	public void goToAdminSignupScreen(ActionEvent event)throws IOException{
		System.out.println("Admin signup button clicked");
		
		Navigator nav = new Navigator();
		FXMLLoader loader = nav.push("/SDAFInalProject/src/Views/SignupScreen.fxml", event);
		
		SignupScreenController controller = new SignupScreenController();
		controller = loader.getController();
		
		controller.setSignupScreenValues(adminSignupImage.getImage().getUrl(), "Signup as an Admin");
	}
	
}
