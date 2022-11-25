package app;


import java.sql.SQLException;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.text.Text;




public class DoctorMainScreenController {
	

	
	@FXML
	private Label time;
	
	public DoctorMainScreenController(){
		
	}
	
	@FXML
	public TableView<Appointment> appointmentsTableView;
	
	@FXML
	public TableColumn<Appointment,String> patientNames;
	
	@FXML
	public TableColumn<Appointment,String> appointmentTimes;
	
	@FXML
	public TableColumn<Appointment,String> appointmentDates;
	
	ObservableList<Appointment> newList;
	
	ObservableList<Appointment> pastList;
	
	AppointmentController apptController;
	
	@FXML
	public void initialize() throws SQLException, ClassNotFoundException {
		System.out.println("Doctor Main Screen Initialized");
//		timeNow();
		
		apptController = AppointmentController.getInstance();
		
		newList = FXCollections.observableArrayList();
		newList = apptController.getUpcomingAppointmentData();
		
		pastList = FXCollections.observableArrayList();
		pastList = apptController.getPastAppointmentData();

		patientNames.setCellValueFactory(new PropertyValueFactory<Appointment,String>("patientName"));
		
		appointmentDates.setCellValueFactory(new PropertyValueFactory<Appointment,String>("appointmentDate"));
		
		appointmentTimes.setCellValueFactory(new PropertyValueFactory<Appointment,String>("appointmentTime"));
		
		appointmentsTableView.setItems(newList);
	}
	
	
	@FXML
	Text appointmentsScreenMainText;

	@FXML
	public void setPastAppointments() {
		appointmentsTableView.setItems(pastList);
		appointmentsScreenMainText.setText("Your Past Appointments");
	}
	
	@FXML
	public void setUpcomingAppointments() {
		appointmentsTableView.setItems(newList);
		appointmentsScreenMainText.setText("Your Upcoming Appointments");
	}

	
}
