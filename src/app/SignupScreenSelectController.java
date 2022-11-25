package app;

import java.io.FileInputStream;
import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

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
		
		Stage s=(Stage)((Node)event.getSource()).getScene().getWindow();
		
		FXMLLoader loader = new FXMLLoader();
		String fxmlDocPath = "/SDAFInalProject/src/app/LoginSelect.fxml";
		FileInputStream fxmlStream = new FileInputStream(fxmlDocPath);
		BorderPane pane = (BorderPane)loader.load(fxmlStream);
		
		Scene scene = new Scene (pane,1500,800);
		s.setScene(scene);
		s.show();
	}
	
	@FXML
	public void initialize() {
		System.out.println("Signup Select Screen Initialized");
	}
	
	@FXML
	public void goToDoctorSignupScreen(ActionEvent event)throws IOException{
		System.out.println("Doctor signup button clicked");
		
		Stage s=(Stage)((Node)event.getSource()).getScene().getWindow();
		
		FXMLLoader loader = new FXMLLoader();
		String fxmlDocPath = "/SDAFInalProject/src/app/SignupScreen.fxml";
		FileInputStream fxmlStream = new FileInputStream(fxmlDocPath);
		BorderPane pane = (BorderPane)loader.load(fxmlStream);
		
		Scene scene = new Scene (pane,1500,800);
		s.setScene(scene);
		s.show();
		
		SignupScreenController controller = new SignupScreenController();
		controller = loader.getController();
		
		controller.setSignupScreenValues(doctorSignupImage.getImage().getUrl(), "Signup as a Doctor");
	}
	
	@FXML
	public void goToPatientSignupScreen(ActionEvent event)throws IOException{
		System.out.println("Patient signup button clicked");
		
		Stage s=(Stage)((Node)event.getSource()).getScene().getWindow();
		
		FXMLLoader loader = new FXMLLoader();
		String fxmlDocPath = "/SDAFInalProject/src/app/SignupScreen.fxml";
		FileInputStream fxmlStream = new FileInputStream(fxmlDocPath);
		BorderPane pane = (BorderPane)loader.load(fxmlStream);
		
		Scene scene = new Scene (pane,1500,800);
		s.setScene(scene);
		s.show();
		
		SignupScreenController controller = new SignupScreenController();
		controller = loader.getController();
		
		controller.setSignupScreenValues(patientSignupImage.getImage().getUrl(), "Signup as a Patient");
	}
	
	@FXML
	public void goToAdminSignupScreen(ActionEvent event)throws IOException{
		System.out.println("Admin signup button clicked");
		
		Stage s=(Stage)((Node)event.getSource()).getScene().getWindow();
		
		FXMLLoader loader = new FXMLLoader();
		String fxmlDocPath = "/SDAFInalProject/src/app/SignupScreen.fxml";
		FileInputStream fxmlStream = new FileInputStream(fxmlDocPath);
		BorderPane pane = (BorderPane)loader.load(fxmlStream);
		
		Scene scene = new Scene (pane,1500,800);
		s.setScene(scene);
		s.show();
		
		SignupScreenController controller = new SignupScreenController();
		controller = loader.getController();
		
		controller.setSignupScreenValues(adminSignupImage.getImage().getUrl(), "Signup as an Admin");
	}
	
}
