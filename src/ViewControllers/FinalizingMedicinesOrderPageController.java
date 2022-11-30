package ViewControllers;

import java.util.Optional;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;

public class FinalizingMedicinesOrderPageController {

	public FinalizingMedicinesOrderPageController() {
		
	}
	
	@FXML
	public void initialize() {
		
	}
	
	
	@FXML
	public void showAlertBox() {
		Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
		alert.setTitle("Confirm your payment?");
		alert.setHeaderText("Confirm payment?");
		Optional<ButtonType> result = alert.showAndWait();
		
		if(!result.isPresent())
		{
			
		}
		else if(result.get() == ButtonType.OK)
		{
			System.out.println("Ok pressed");
		}
		else if(result.get() == ButtonType.CANCEL)
		{
			System.out.println("Cancel pressed");
		}
	}
	
}
