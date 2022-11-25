package app;

import java.io.FileInputStream;
import java.io.IOException;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;

import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class OrderMedicinesPageController {

	
	
	public OrderMedicinesPageController() {
		
		
		
		
		
	}
	
	@FXML
//	goto next page
	public void OrderMedicinesProceedcCick(ActionEvent event) throws IOException {
		System.out.println("Going to Doctor Finalizing Order Page");
			
		Stage s=(Stage)((Node)event.getSource()).getScene().getWindow();
			
		FXMLLoader loader = new FXMLLoader();
		String fxmlDocPath = "/SDAFInalProject/src/app/FinalizingMedicinesOrderPage.fxml";
		FileInputStream fxmlStream = new FileInputStream(fxmlDocPath);
		BorderPane pane = (BorderPane)loader.load(fxmlStream);
		
		Scene scene = new Scene (pane,1500,800);
		s.setScene(scene);
		s.show();
	}
		
	
	
	
	
	
}
