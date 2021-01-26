////////////////////////////////////////////////////////////////////////////////
// Name: Ivan Khurudzhi
// E-mail: khurudzhi@wisc.edu
// Class: CS400
// Lecture: Online
// Project: FINAL A3
////////////////////////////////////////////////////////////////////////////////

package application;

import java.io.File;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

/*
 * class that creates a new scene when a button 1 is pressed in the main window
 */
public class Button1Press {

	Pane root = new Pane();
	static File writeFile; // file where the report is printed
	static boolean b = false; // used in other classes to check if button 1 is pressed
	static Farms farms;

	/*
	 * setting up the scene
	 */
	public Button1Press(Stage stage) {
		Scene mainScene = new Scene(root, 900, 600);
		root.setBackground(new Background(new BackgroundFill(Color.ORANGE, CornerRadii.EMPTY, Insets.EMPTY)));
		Rectangle r = new Rectangle();
		r.setX(350);
		r.setY(77);
		r.setWidth(200);
		r.setHeight(60);
		r.setFill(Color.LIGHTGREY);
		root.getChildren().add(r);

		Label lbl = new Label("Input the year number:");
		lbl.setLayoutX(380);
		lbl.setLayoutY(100);
		root.getChildren().add(lbl);

		Button sbmt = new Button("Submit");
		sbmt.setLayoutX(355);
		sbmt.setLayoutY(350);
		sbmt.setMinWidth(200);
		sbmt.setMaxWidth(200);
		sbmt.setMinHeight(60);
		sbmt.setMaxHeight(60);
		root.getChildren().add(sbmt);

		Button back = new Button("Back");
		back.setLayoutX(20);
		back.setLayoutY(450);
		back.setMinWidth(200);
		back.setMaxWidth(200);
		back.setMinHeight(60);
		back.setMaxHeight(60);
		root.getChildren().add(back);

		Button closeButt = new Button("Close Application");
		closeButt.setLayoutX(355);
		closeButt.setLayoutY(450);
		closeButt.setMinWidth(200);
		closeButt.setMaxWidth(200);
		closeButt.setMinHeight(60);
		closeButt.setMaxHeight(60);
		root.getChildren().add(closeButt);

		TextField input = new TextField();
		input.setLayoutX(370);
		input.setLayoutY(260);
		input.setMinHeight(40);
		input.setMaxHeight(40);
		root.getChildren().add(input);

		back.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent e) {
				MainWindow action = new MainWindow(stage);
				stage.getScene().setRoot(action.getPane());
			}
		});

		sbmt.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent e) {
				b = true;
				FileReader flRdr = new FileReader(StartWindow.f); // read the uploaded file
				flRdr.readFile();
				int yearNumber = 0;
				boolean rearr = false;
				try {
					yearNumber = Integer.parseInt(input.getText());
					rearr = true; // checking if it's allowed to move to the next scene
				} catch (NumberFormatException ex) { // checking the format of input
					ButtonType reupld = new ButtonType("Try Again");
					ButtonType exit = new ButtonType("Exit");
					Alert alert = new Alert(AlertType.ERROR, "Wrong Input Format. Rewrite a correct input.", reupld,
							exit);
					alert.showAndWait().ifPresent(reaction -> {
						boolean rpld = false;
						if (reaction == reupld) {// if the user chooses to rewrite
							rpld = true; // then alert closes and scene recreates itself
							alert.close();
						} else {
							System.exit(0); // otherwise the applications exits
						}
						if (rpld) {
							Button1Press strtWndw = new Button1Press(stage);
							stage.getScene().setRoot(strtWndw.getPane());
						}
					});
				}
				if (rearr) { // moving to the download scene
					Reports r = new Reports(yearNumber, flRdr.readFile()); // create a new report
					farms = r.annualReport(); // get data from report
					writeFile = new File("./Annual report.txt");
					Download action = new Download(stage);
					stage.getScene().setRoot(action.getPane());
				}
			}
		});

		closeButt.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent e) {
				System.exit(0);
			}
		});

		stage.setTitle("Annual Report");
		stage.setResizable(false);
		stage.setScene(mainScene);
		stage.show();
	}

	/*
	 * @return - returning the root
	 */
	public Pane getPane() {
		return root;
	}
}