module SDAFInalProject {
	requires javafx.controls;
	requires javafx.fxml;
	requires java.sql;
	requires javafx.base;
	requires javafx.graphics;
	requires java.desktop;
	
	
	opens app to javafx.graphics, javafx.fxml;
}
