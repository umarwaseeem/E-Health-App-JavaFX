package app;


import java.io.FileInputStream;
import java.io.IOException;

import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;

import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;


public class BookAppointmentController {

	
	
	
	
	
		
	
		public BookAppointmentController() {
			
		}
		
	

		
		
		
		@FXML	ComboBox<String>Select_Disease_ComboBox;

	    private String diseases[] = {"Flu", "Nosea", "ChestPain", "Injury","SkinProblem"};
        @FXML
	    public void initialize() {
	    	Select_Disease_ComboBox.setItems(FXCollections.observableArrayList(diseases));
	    }
		
		
		
		@FXML
		public void BookAppointmentClick() {
			System.out.println("yuu huuu");
		}
		
		
		
		    @FXML
//		//goto next page
			public void recommendation_list_page(ActionEvent event) throws IOException {
			System.out.println("Going to Doctor Recommendations page");
			
			Stage s=(Stage)((Node)event.getSource()).getScene().getWindow();
			
			FXMLLoader loader = new FXMLLoader();
			String fxmlDocPath = "/SDAFInalProject/src/app/DoctorReccomendationsPage.fxml";
			FileInputStream fxmlStream = new FileInputStream(fxmlDocPath);
			BorderPane pane = (BorderPane)loader.load(fxmlStream);
			
			Scene scene = new Scene (pane,1500,800);
			s.setScene(scene);
			s.show();
		}
		
	

	
	
	
	
}
