package app;


import javafx.stage.Stage;
import javafx.scene.Node;
import javafx.scene.Scene;

import java.io.FileInputStream;
import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;

import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;



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
		
		Stage s=(Stage)((Node)event.getSource()).getScene().getWindow();
		
		FXMLLoader loader = new FXMLLoader();
		String fxmlDocPath = "/SDAFInalProject/src/app/SignupScreenSelect.fxml";
		FileInputStream fxmlStream = new FileInputStream(fxmlDocPath);
		BorderPane pane = (BorderPane)loader.load(fxmlStream);
		
		Scene scene = new Scene (pane,1500,800);
		s.setScene(scene);
		s.show();
	}
	
	
	@FXML
	public void goToDoctorLoginScreen(ActionEvent event) throws IOException {
		System.out.println("Doctor Login Button Clicked");

		Stage s=(Stage)((Node)event.getSource()).getScene().getWindow();
		
//		m.changeScene(s,"Views/FXML/LoginScreen.fxml");
		
		FXMLLoader loader = new FXMLLoader();
		String fxmlDocPath = "/SDAFInalProject/src/app/LoginScreen.fxml";
		FileInputStream fxmlStream = new FileInputStream(fxmlDocPath);
		BorderPane pane =	(BorderPane)loader.load(fxmlStream);
		
		Scene scene = new Scene(pane,1500,800);
		s.setScene(scene);
		s.show();
		
		LoginScreenController loginScreenController = loader.getController();
		
		loginScreenController.setValues(doctorImage.getImage().getUrl(), "Doctor");
	}
	
	@FXML
	public void goToPatientLoginScreen(ActionEvent event) throws IOException {
		System.out.println("Patient Login Button Clicked");

		Stage s=(Stage)((Node)event.getSource()).getScene().getWindow();
		
		FXMLLoader loader = new FXMLLoader();
		String fxmlDocPath = "/SDAFInalProject/src/app/LoginScreen.fxml";
		FileInputStream fxmlStream = new FileInputStream(fxmlDocPath);
		BorderPane pane =	(BorderPane)loader.load(fxmlStream);
		
		Scene scene = new Scene(pane,1500,800);
		s.setScene(scene);
		s.show();
		
		LoginScreenController loginScreenController = loader.getController();
		
		loginScreenController.setValues(patientImage.getImage().getUrl(), "Patient");
	}
	
	@FXML
	public void goToAdminLoginScreen(ActionEvent event) throws IOException {
		System.out.println("Admin Login Button Clicked");

		Stage s=(Stage)((Node)event.getSource()).getScene().getWindow();
		
		FXMLLoader loader = new FXMLLoader();
		String fxmlDocPath = "/SDAFInalProject/src/app/LoginScreen.fxml";
		FileInputStream fxmlStream = new FileInputStream(fxmlDocPath);
		BorderPane pane =	(BorderPane)loader.load(fxmlStream);
		
		Scene scene = new Scene(pane,1500,800);
		s.setScene(scene);
		s.show();
		
		LoginScreenController loginScreenController = loader.getController();
		
		loginScreenController.setValues(adminImage.getImage().getUrl(), "Admin");
	}

}
