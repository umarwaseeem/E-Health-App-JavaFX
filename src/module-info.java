module SDAFInalProject {
	requires javafx.controls;
	requires javafx.fxml;
	requires java.sql;
	requires javafx.base;
	requires javafx.graphics;
	requires java.desktop;
	requires java.base;
	
	exports ViewControllers;
	
	opens ViewControllers to javafx.graphics, javafx.fxml, javafx.base,  javafx.controls;
	
	opens Models to javafx.graphics, javafx.fxml, javafx.base,  javafx.controls;
	
	
	opens app to javafx.graphics, javafx.fxml, javafx.base,  javafx.controls;
}
