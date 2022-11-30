package ViewControllers;


import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class PatientOptionsPageController {
	@FXML
	TextField name;
	public PatientOptionsPageController() {
		
	}
	
	@FXML
	public void initiliaze() {
		
		System.out.println("done initialization");
		
	}

	
//	@FXML
//	public void BookAppointmentClick() {
//		System.out.println("yuu huuu");
//	}
	
	
	
	@FXML
	//goto BookAppointmentPage
	public void BookAppointmentClick(ActionEvent event) throws IOException {
		System.out.println("Book Appointment button clicked");
		
		Navigator nav = new Navigator();
		nav.push("/SDAFInalProject/src/Views/BookAppointmentPage.fxml", event);
	}
	
	
	
	
	@FXML
	//goto Order Medicines Page
	public void OrderMedicinesClick(ActionEvent event) throws IOException {
		System.out.println("Order Medicines button clicked");
		
		
		Navigator nav = new Navigator();
		nav.push("/SDAFInalProject/src/Views/OrderMedicinesPage.fxml", event);
		
	}
	
	@FXML
	Button patientSignoutButton;
	
	@FXML
	public void signout() throws IOException {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("LoginSelect.fxml"));  
        Stage stage = new Stage();
        stage.initOwner(patientSignoutButton.getScene().getWindow());
        stage.close();
        
        patientSignoutButton.getScene().getStylesheets().add(getClass().getResource("styles.css").toExternalForm());
        stage.setScene(new Scene((Parent) loader.load()));

        // showAndWait will block execution until the window closes...
        stage.showAndWait();
	}
	
	
}
