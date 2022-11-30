package ViewControllers;

import java.io.FileInputStream;
import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class Navigator {

	public FXMLLoader push(String nextScreenPath, ActionEvent event) throws IOException {
		FXMLLoader loader;
		
		Stage s=(Stage)((Node)event.getSource()).getScene().getWindow();
		
		loader = new FXMLLoader();
		String fxmlDocPath = nextScreenPath;
		FileInputStream fxmlStream = new FileInputStream(fxmlDocPath);
		BorderPane pane = (BorderPane)loader.load(fxmlStream);
		
		Scene scene = new Scene (pane,1500,800);
		
		scene.getStylesheets().add(getClass().getResource("styles.css").toExternalForm());
		s.setScene(scene);
		s.show();
		
		return loader;
	}
}
