package app;
	
import java.io.FileInputStream;
import java.io.IOException;


import javafx.application.Application;
import javafx.fxml.FXMLLoader;


import javafx.scene.Scene;

import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;


public class Main extends Application {
	FXMLLoader loader = new FXMLLoader();
	@Override
	public void start(Stage primaryStage) {
		try {
			String fxmlDocPath = "/SDAFInalProject/src/app/LoginSelect.fxml";
			FileInputStream fxmlStream = new FileInputStream(fxmlDocPath);
			BorderPane root = (BorderPane)loader.load(fxmlStream);
			
			Scene scene = new Scene(root,1000,800);
			
//			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			
			primaryStage.setScene(scene);
			primaryStage.show();
		
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void changeScene(Stage currentStage, String destinationUI) throws IOException {
		
		String fxmlDocPath = destinationUI;
		FileInputStream fxmlStream = new FileInputStream(fxmlDocPath);
		BorderPane pane = (BorderPane)loader.load(fxmlStream);
		
		Scene scene = new Scene(pane,600,600);
		
		currentStage.setScene(scene);
		currentStage.show();
	}
	
	
	public static void main(String[] args) {
//		DatabaseHandler dbHandler = new DatabaseHandler();
		launch(args);
	}
}
