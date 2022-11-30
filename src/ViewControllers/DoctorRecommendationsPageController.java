package ViewControllers;

import java.sql.SQLException;
import java.util.Optional;

import Controllers.AppointmentController;
import Controllers.DoctorController;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;


public class DoctorRecommendationsPageController {

	String disease;
	String timings;
	String date;
	String docName;
	
	public void setAppointmentValues(String timings, String date, String disease) throws SQLException {
		this.disease = disease;
		this.timings= timings;
		this.date = date;
		
		System.out.println("Disease selected was: " + disease);
		docController = new DoctorController();
		doctorRecommendationComboBox.setItems(docController.getDoctorsByDisease(disease));
	}
	
	public DoctorRecommendationsPageController() {

	}
	
	@FXML
	ComboBox<String> doctorRecommendationComboBox;

	DoctorController docController;
	
	@FXML
	public void initialize() {

	}
	
	AppointmentController apptController;
	
	  public void confirmAppointmentAlertDialog() throws SQLException {
		docName = doctorRecommendationComboBox.getValue();
		Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
		alert.setTitle("Confirm your appointment");
		alert.setContentText("Appointment Details: \n\n\n Disease: " + disease + "\n Timings: " + timings + "\n Doctor: " + docName + "\n Date: " + date);
		alert.setHeaderText("Confirm appointment?");
		Optional<ButtonType> result = alert.showAndWait();
		
		if(!result.isPresent())
		{
			
		}
		else if(result.get() == ButtonType.OK)
		{
			System.out.println("Ok pressed");
			apptController = new AppointmentController();
			
			apptController.saveAppointmentToDatabase(timings, docName, date, date);
		}
		else if(result.get() == ButtonType.CANCEL)
		{
			System.out.println("Cancel pressed");
		}
	}
	
	
	@FXML
	public void confirmAppointment() throws SQLException {
		System.out.println("Confirm button clicked");
		confirmAppointmentAlertDialog();
	}
	
	
//@FXML
//////goto next page
//public void recommendationListPage(ActionEvent event) throws IOException {
//System.out.println("Going to Doctor Recommendations page");
//
//Stage s=(Stage)((Node)event.getSource()).getScene().getWindow();
//
//FXMLLoader loader = new FXMLLoader();
//String fxmlDocPath = "Views/FXML/BookAppointmentPage.fxml";
//FileInputStream fxmlStream = new FileInputStream(fxmlDocPath);
//BorderPane pane = (BorderPane)loader.load(fxmlStream);
//
//Scene scene = new Scene (pane,1500,800);
//s.setScene(scene);
//s.show();
//}

}
