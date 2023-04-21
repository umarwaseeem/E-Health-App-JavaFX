package app;
	
import java.io.FileInputStream;


import javafx.application.Application;
import javafx.fxml.FXMLLoader;


import javafx.scene.Scene;

import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;


public class Main extends Application {
//	this is responsible for loading UI
	FXMLLoader loader = new FXMLLoader();
	@Override
	public void start(Stage primaryStage) {
		try {
//			set UI to load
			String fxmlDocPath = "/FInalProject/src/Views/LoginSelect.fxml";
			FileInputStream fxmlStream = new FileInputStream(fxmlDocPath);
//			set root element
			BorderPane root = (BorderPane)loader.load(fxmlStream);
			
//			set scene
			Scene scene = new Scene(root,1550,800);
			
//			load css
			scene.getStylesheets().add(getClass().getResource("styles.css").toExternalForm());
			
//			show the UI
			primaryStage.setScene(scene);
			primaryStage.show();
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	
	public static void main(String[] args) {
//		start the application
		launch(args);
	}
}
