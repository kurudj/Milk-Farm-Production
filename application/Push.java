////////////////////////////////////////////////////////////////////////////////
// Name: Ivan Khurudzhi
// E-mail: khurudzhi@wisc.edu
// Class: CS400
// Lecture: Online
// Project: FINAL A3
////////////////////////////////////////////////////////////////////////////////

package application;

import javafx.application.Application;
import javafx.stage.Stage;

/*
 * class that starts the application
 */
public class Push extends Application {

	@Override
	public void start(Stage primaryStage) throws Exception {
		// creation of the main window
		StartWindow strtWndw = new StartWindow(primaryStage);
	}

	public static void main(String[] args) {
		launch(args);
	}
}