package ViewControllers;

import java.io.IOException;
import java.sql.SQLException;

import Controllers.MedicineController;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;


public class OrderMedicinesPageController {

	
	@FXML
	ListView<String> prescriptionListView;
	
	ObservableList<String> medicines;
	
	public OrderMedicinesPageController() {
		medicines = FXCollections.observableArrayList();
	}
	
	@FXML
	public void initialize() throws SQLException {
		MedicineController controller = new MedicineController();
		medicines = controller.getMedicines();
		
		prescriptionListView.setItems(medicines);
	}
	
	@FXML
//	goto next page
	public void OrderMedicinesProceedcCick(ActionEvent event) throws IOException {
		System.out.println("Going to Doctor Finalizing Order Page");
			
		Navigator nav = new Navigator();
		nav.push("/SDAFInalProject/src/Views/FinalizingMedicinesOrderPage.fxml", event);
	}
		
	
	
	
	
	
}
