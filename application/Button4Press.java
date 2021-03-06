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
import javafx.scene.control.Button;
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
 * class that creates a new scene when a button 4 is pressed in the main window
 */
public class Button4Press {

	Pane root = new Pane();
	static Farms farms;
	static boolean b = false; // used further to check if button 4 is pressed
	static File writeFile; // file where data is printed

	/*
	 * setting up the scene for button 4 pressed
	 */
	public Button4Press(Stage stage) {
		Scene mainScene = new Scene(root, 900, 600);
		root.setBackground(new Background(new BackgroundFill(Color.ORANGE, CornerRadii.EMPTY, Insets.EMPTY)));

		Rectangle r = new Rectangle();
		r.setX(150);
		r.setY(150);
		r.setWidth(200);
		r.setHeight(60);
		r.setFill(Color.LIGHTGREY);
		root.getChildren().add(r);

		Label lbl = new Label("Input the start date:");
		lbl.setLayoutX(180);
		lbl.setLayoutY(170);
		root.getChildren().add(lbl);

		Rectangle r2 = new Rectangle();
		r2.setX(560);
		r2.setY(150);
		r2.setWidth(200);
		r2.setHeight(60);
		r2.setFill(Color.LIGHTGREY);
		root.getChildren().add(r2);

		Label lbl2 = new Label("Input the end date:");
		lbl2.setLayoutX(600);
		lbl2.setLayoutY(170);
		root.getChildren().add(lbl2);

		TextField input = new TextField();
		input.setLayoutX(170);
		input.setLayoutY(300);
		input.setMinHeight(40);
		input.setMaxHeight(40);
		root.getChildren().add(input);

		TextField input2 = new TextField();
		input2.setLayoutX(580);
		input2.setLayoutY(300);
		input2.setMinHeight(40);
		input2.setMaxHeight(40);
		root.getChildren().add(input2);

		Button sbmt = new Button("Submit");
		sbmt.setLayoutX(355);
		sbmt.setLayoutY(400);
		sbmt.setMinWidth(200);
		sbmt.setMaxWidth(200);
		sbmt.setMinHeight(60);
		sbmt.setMaxHeight(60);
		root.getChildren().add(sbmt);

		Button invldVl = new Button("Invalid Value Pane Simulation");
		invldVl.setLayoutX(700);
		invldVl.setLayoutY(500);
		invldVl.setMinWidth(200);
		invldVl.setMaxWidth(200);
		invldVl.setMinHeight(60);
		invldVl.setMaxHeight(60);
		root.getChildren().add(invldVl);

		Button back = new Button("Back");
		back.setLayoutX(20);
		back.setLayoutY(500);
		back.setMinWidth(200);
		back.setMaxWidth(200);
		back.setMinHeight(60);
		back.setMaxHeight(60);
		root.getChildren().add(back);

		Button closeButt = new Button("Close Application");
		closeButt.setLayoutX(355);
		closeButt.setLayoutY(500);
		closeButt.setMinWidth(200);
		closeButt.setMaxWidth(200);
		closeButt.setMinHeight(60);
		closeButt.setMaxHeight(60);
		root.getChildren().add(closeButt);

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
				FileReader flRdr = new FileReader(StartWindow.f);
				flRdr.readFile();
				String startDate = input.getText();
				String endDate = input2.getText();
				Reports r = new Reports(startDate, endDate, flRdr.readFile()); // new report
				farms = r.dateRangeReport();// get data from report
				writeFile = new File("./Date range report.txt");
				Download action = new Download(stage);
				stage.getScene().setRoot(action.getPane());
			}
		});

		invldVl.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent e) {
				InvalidValue action = new InvalidValue(stage);
				stage.getScene().setRoot(action.getPane());
			}
		});

		closeButt.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent e) {
				System.exit(0);
			}
		});

		stage.setTitle("Date Range Report");
		stage.setResizable(false);
		stage.setScene(mainScene);
		stage.show();
	}

	/*
	 * @return root - returning the root
	 */
	public Pane getPane() {
		return root;
	}
}