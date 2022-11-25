package app;


import java.io.FileInputStream;
import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
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
		
		Stage s=(Stage)((Node)event.getSource()).getScene().getWindow();
		
		FXMLLoader loader = new FXMLLoader();
		String fxmlDocPath = "/SDAFInalProject/src/app/BookAppointmentPage.fxml";
		FileInputStream fxmlStream = new FileInputStream(fxmlDocPath);
		BorderPane pane = (BorderPane)loader.load(fxmlStream);
		
		Scene scene = new Scene (pane,1500,800);
		s.setScene(scene);
		s.show();
	}
	
	
	
	
	@FXML
	//goto Order Medicines Page
	public void OrderMedicinesClick(ActionEvent event) throws IOException {
		System.out.println("Order Medicines button clicked");
		
		Stage s=(Stage)((Node)event.getSource()).getScene().getWindow();
		
		FXMLLoader loader = new FXMLLoader();
		String fxmlDocPath = "/SDAFInalProject/src/app/OrderMedicinesPage.fxml";
		FileInputStream fxmlStream = new FileInputStream(fxmlDocPath);
		BorderPane pane = (BorderPane)loader.load(fxmlStream);
		
		Scene scene = new Scene (pane,1500,800);
		s.setScene(scene);
		s.show();
	}
	
	
}
