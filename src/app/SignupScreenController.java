package app;

import java.io.FileInputStream;
import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;


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
	
	@FXML
	public void goToContinueToDetailScreen(ActionEvent event) throws IOException{
		System.out.println("Continue to detail screen button clicked");
		
		Stage s=(Stage)((Node)event.getSource()).getScene().getWindow();
		
		FXMLLoader loader = new FXMLLoader();
		String fxmlDocPath = "/SDAFInalProject/src/app/DoctorSignupDetailScreen.fxml";
		FileInputStream fxmlStream = new FileInputStream(fxmlDocPath);
		BorderPane pane = (BorderPane)loader.load(fxmlStream);
		
		Scene scene = new Scene (pane,1500,800);
		s.setScene(scene);
		s.show();
	}
	
}
