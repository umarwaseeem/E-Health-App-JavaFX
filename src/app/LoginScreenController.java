package app;

import javafx.scene.control.TextField;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;

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
	


	@FXML
	public void initialize() {
		System.out.println("Login screen scene init");
		
//		loginScreenMainText.setText("Login as " + loginAsText);
//		loginScreenImage.setImage(new javafx.scene.image.Image(leftImagePath));	
		
	}

	@FXML
	public void submitButton() {
		System.out.println("Submit button clicked");
		System.out.println(userNameTextField.getText());
		System.out.println(passwordTextField.getText());
	}

}
