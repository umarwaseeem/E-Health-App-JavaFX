package ViewControllers;

import java.io.IOException;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import Controllers.DoctorController;
import Controllers.HospitalController;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class AdminMainScreenController {
	
	private volatile boolean stop = false;
	
	public AdminMainScreenController() {
		
	}
	
	@FXML
	public void initialize() throws SQLException {
		System.out.println("Admin Main Screen initialized");
		timeNow();
		
		noOfPatientsText.setText("2");
		noOfHospitalsText.setText("3");
		
		DoctorController doc = new DoctorController();
		List<String> count = doc.numberOfDoctorsInEachHospital();
		
		int noOfDoctors = 0;
		
		for(int i=0; i<count.size(); i++) {
			noOfDoctors += Integer.parseInt(count.get(i)); 
		}
		
		noOfDoctorsText.setText(Integer.toString(noOfDoctors));
		
		fillHospitalsList();
	}
	
	@FXML
	public Text noOfPatientsText;
	@FXML
	public Text noOfHospitalsText;
	@FXML
	public Text noOfDoctorsText;
	

	
	@FXML
	private Label time;
	
	public void timeNow() {
		Thread thread = new Thread ( () -> {
			SimpleDateFormat sdf = new SimpleDateFormat("hh:mm:ss");
			while(!stop) {
				try {
					Thread.sleep(1000);
				}
				catch(Exception e) {
					System.out.println(e);
				}
				final String timeNow = sdf.format(new Date());
				Platform.runLater(()-> {
					time.setText(timeNow);
				});
			}
		});
		thread.start();
	}
	
	@FXML
	Button adminSignoutButton;
	
	@FXML
	public void signoutAdmin() throws IOException {
		System.out.println("Admin signout button clicked");
		
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/SDAFInalProject/src/Views/LoginSelect.fxml"));  
        Stage stage = new Stage();
        stage.initOwner(adminSignoutButton.getScene().getWindow());
        stage.setScene(new Scene((Parent) loader.load()));

        // showAndWait will block execution until the window closes...
        stage.showAndWait();
	}
	
	@FXML
	Text adminMainScreenText;
	
	@FXML
	Button adminManageHospitalsButton;
	
	@FXML
	public void goToManageHospitals() {
		System.out.println("Manage hospitals button clicked");
		adminMainScreenText.setText("Manage Hospitals");
	}
	@FXML
	public void goToManageAlerts() {
		System.out.println("Manage alerts button clicked");
		adminMainScreenText.setText("Manage Alerts");
	}
	@FXML
	public void goToManageAccounts() {
		System.out.println("Manage accounts button clicked");
		adminMainScreenText.setText("Manage Accounts");
	}
	
	
	
	@FXML
	ListView<String> hospitalsListView;
	
	ObservableList<String> hospitals;
	
	public void fillHospitalsList() throws SQLException {
		
		hospitals = FXCollections.observableArrayList();
		
		HospitalController hospController = new HospitalController();
		hospitals =  hospController.getListOfHospitals();
		
		hospitalsListView.setItems(hospitals);
	}
	
}















