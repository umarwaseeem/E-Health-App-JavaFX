package ViewControllers;

import javafx.scene.control.TextField;

import java.io.IOException;
import java.sql.SQLException;

import Controllers.LoginController;
import Controllers.OutputUtil;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;

public class LoginScreenController {

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
	HBox alertBar;
	
	public void errorBar() {
//		alertBar.setBackground(new Background());
		alertBar.setStyle("-fx-background-color: red;");
		alertBar.setStyle("-fx-text-fill: white;");
	}
	
	public void successBar() {
		
	}

	@FXML
	public void submitButton(ActionEvent event) throws IOException, SQLException  {
		System.out.println("Login button clicked");
		
		String enteredUsername = userNameTextField.getText();
		String enteredPassword = passwordTextField.getText();
		
		String fxmlDocPath = "/SDAFInalProject/src/Views/DoctorMainScreen.fxml";
		
		if(loginAsText.contains("Doctor")) {
			boolean loginSuccess = loginController.login(enteredUsername, enteredPassword, "doctor");
			if(loginSuccess == false) {
				OutputUtil.printRed("Login Failed");
				
//				errorBar();
				
				return;
			}
			OutputUtil.printGreen("Login Successful");
			fxmlDocPath = "/SDAFInalProject/src/Views/DoctorMainScreen.fxml";
		}
		
		else if(loginAsText.contains("Admin")) {
			boolean loginSuccess = loginController.login(enteredUsername, enteredPassword, "admin");
			if(loginSuccess == false) {
				OutputUtil.printRed("Login Failed");
				return;
			}
			OutputUtil.printGreen("Login Successful");
			fxmlDocPath = "/SDAFInalProject/src/Views/AdminMainScreen.fxml";
		}
		
		else if(loginAsText.contains("Patient")) {
			boolean loginSuccess = loginController.login(enteredUsername, enteredPassword, "patient");
			if(loginSuccess == false) {
				OutputUtil.printRed("Login Failed");
				return;
			}
			OutputUtil.printGreen("Login Successful");
			fxmlDocPath = "/SDAFInalProject/src/Views/PatientOptionsPage.fxml";
		}
		
		Navigator nav = new Navigator();
		nav.push(fxmlDocPath, event);
	}
	
	

}
