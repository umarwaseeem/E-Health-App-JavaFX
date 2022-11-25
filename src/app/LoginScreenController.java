package app;

import javafx.scene.control.TextField;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.SQLException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class LoginScreenController {

	Main m = new Main();

	String leftImagePath;
	String loginAsText;

	public void setValues(String path, String name) {
		leftImagePath = path;
		loginAsText = name;
		
		loginScreenMainText.setText("Login as " + loginAsText);
		loginScreenImage.setImage(new javafx.scene.image.Image(leftImagePath));

	}

	@FXML
	Text loginScreenMainText;
	
	@FXML
	ImageView loginScreenImage;

	@FXML
	Button loginButton;

	@FXML
	TextField userNameTextField;

	@FXML
	PasswordField passwordTextField;

	public LoginScreenController() {

	}
	
	LoginController loginController;

	@FXML
	public void initialize() {
		System.out.println("Login screen scene init");
		
		loginController = new LoginController();
//		loginScreenMainText.setText("Login as " + loginAsText);
//		loginScreenImage.setImage(new javafx.scene.image.Image(leftImagePath));	
		
	}

	@FXML
	public void submitButton(ActionEvent event) throws IOException, SQLException  {
		System.out.println("Login button clicked");
		
		String enteredUsername = userNameTextField.getText();
		String enteredPassword = passwordTextField.getText();
		
//		go to next screen when login successful
		
		FXMLLoader loader = new FXMLLoader();
		String fxmlDocPath = "/SDAFInalProject/src/app/DoctorMainScreen.fxml";
		
		if(loginAsText.contains("Doctor")) {
			boolean loginSuccess = loginController.login(enteredUsername, enteredPassword, "doctor");
			if(loginSuccess == false) {
				OutputUtil.printRed("Login Failed");
				return;
			}
			OutputUtil.printGreen("Login Successful");
			fxmlDocPath = "/SDAFInalProject/src/app/DoctorMainScreen.fxml";
		}
		else if(loginAsText.contains("Admin")) {
			boolean loginSuccess = loginController.login(enteredUsername, enteredPassword, "admin");
			if(loginSuccess == false) {
				OutputUtil.printRed("Login Failed");
				return;
			}
			OutputUtil.printGreen("Login Successful");
			fxmlDocPath = "/SDAFInalProject/src/app/AdminMainScreen.fxml";
		}
		else if(loginAsText.contains("Patient")) {
			boolean loginSuccess = loginController.login(enteredUsername, enteredPassword, "patient");
			if(loginSuccess == false) {
				OutputUtil.printRed("Login Failed");
				return;
			}
			OutputUtil.printGreen("Login Successful");
			fxmlDocPath = "/SDAFInalProject/src/app/PatientOptionsPage.fxml";
		}
		
		Stage s=(Stage)((Node)event.getSource()).getScene().getWindow();
		
		FileInputStream fxmlStream = new FileInputStream(fxmlDocPath);
		BorderPane pane = (BorderPane)loader.load(fxmlStream);
		
		Scene scene = new Scene (pane,1500,800);
//		scene.getStylesheets().add("styles.css");
		s.setScene(scene);
		s.show();
	}
	
	
//	@FXML
//	public void adminLoginButton(ActionEvent event) throws IOException  {
//		System.out.println("Admin Login button clicked");
//		System.out.println(userNameTextField.getText());
//		System.out.println(passwordTextField.getText());
//		
//		Stage s=(Stage)((Node)event.getSource()).getScene().getWindow();
//		
//		FXMLLoader loader = new FXMLLoader();
//		String fxmlDocPath = "Views/FXML/AdminMainScreen.fxml";
//		FileInputStream fxmlStream = new FileInputStream(fxmlDocPath);
//		BorderPane pane = (BorderPane)loader.load(fxmlStream);
//		
//		Scene scene = new Scene (pane,1500,800);
//		s.setScene(scene);
//		s.show();
//	}
//	
//	@FXML
//	public void patientLoginButton(ActionEvent event) throws IOException  {
//		System.out.println("Patient Login button clicked");
//		System.out.println(userNameTextField.getText());
//		System.out.println(passwordTextField.getText());
//		
//		Stage s=(Stage)((Node)event.getSource()).getScene().getWindow();
//		
//		FXMLLoader loader = new FXMLLoader();
//		String fxmlDocPath = "Views/FXML/PatientMainScreen.fxml";
//		FileInputStream fxmlStream = new FileInputStream(fxmlDocPath);
//		BorderPane pane = (BorderPane)loader.load(fxmlStream);
//		
//		Scene scene = new Scene (pane,1500,800);
//		s.setScene(scene);
//		s.show();
//	}
	

}
