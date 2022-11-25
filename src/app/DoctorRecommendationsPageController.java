package app;

import javafx.collections.FXCollections;
import javafx.fxml.FXML;

import javafx.scene.control.ComboBox;

public class DoctorRecommendationsPageController {

	public DoctorRecommendationsPageController() {

	}

	@FXML
	ComboBox<String> Select_timings_ComboBox;

	private String timings[] = { "10:00-12:00", "2:00-3:00", "7:00-8:30", "9:00-10:00", "10:00-10:30" };

	@FXML
	public void initialize() {
		Select_timings_ComboBox.setItems(FXCollections.observableArrayList(timings));
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
