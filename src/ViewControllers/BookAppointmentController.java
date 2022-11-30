package ViewControllers;


import java.io.IOException;
import java.sql.SQLException;

import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.ComboBox;



public class BookAppointmentController {

		public BookAppointmentController() {}

		@FXML
		ComboBox<String> Select_timings_ComboBox;

		@FXML	
		ComboBox<String>Select_Disease_ComboBox;
		
		@FXML
		ComboBox<String>datesComboBox;


		private String timings[] = { "10:00-12:00", "2:00-3:00", "7:00-8:30", "9:00-10:00", "10:00-10:30" };
		private String diseases[] = {"Flu", "Nosea", "ChestPain", "Injury","SkinProblem"};
		private String dates[] = {"12-Nov-2022","11-Sep-2020" , "12-Dec-2023" , "10-Feb-2024" };
		
        @FXML
	    public void initialize() throws SQLException   {
	    	Select_Disease_ComboBox.setItems(FXCollections.observableArrayList(diseases));
	    	Select_timings_ComboBox.setItems(FXCollections.observableArrayList(timings));
	    	datesComboBox.setItems(FXCollections.observableArrayList(dates));
	    }
        
        String timingSelected;
        String date;
        String disease;
        
		public void continueToDoctorRecommendationPage(ActionEvent event) throws IOException, SQLException{
			Navigator nav = new Navigator();
			FXMLLoader loader = nav.push("/SDAFInalProject/src/Views/DoctorReccomendationsPage.fxml", event);
		
			timingSelected = Select_timings_ComboBox.getValue();
			System.out.println(timingSelected);
			date = datesComboBox.getValue();
			System.out.println(date);
			disease = Select_Disease_ComboBox.getValue();
			System.out.println(disease);
			
			DoctorRecommendationsPageController controller = loader.getController();
			controller.setAppointmentValues(timingSelected,date,disease);
		}
		
//		    @FXML
////		//goto next page
//			public void recommendation_list_page(ActionEvent event) throws IOException {
//			System.out.println("Going to Doctor Recommendations page");
//			
//			Navigator nav = new Navigator();
//			nav.push("/SDAFInalProject/src/app/DoctorReccomendationsPage.fxml", event);
//		}
//		
	

	
	
	
	
}
