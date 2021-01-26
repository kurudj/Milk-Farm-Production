////////////////////////////////////////////////////////////////////////////////
// Name: Ivan Khurudzhi
// E-mail: khurudzhi@wisc.edu
// Class: CS400
// Lecture: Online
// Project: FINAL A3
////////////////////////////////////////////////////////////////////////////////

package application;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

/*
 * class that creates the main window
 */
public class MainWindow {

	Pane root = new Pane();

	/*
	 * constructor that sets the scene of the main windown where user chooses the
	 * type of analysis
	 */
	public MainWindow(Stage primaryStage) {
		Scene mainScene = new Scene(root, 900, 600);
		root.setBackground(new Background(new BackgroundFill(Color.ORANGE, CornerRadii.EMPTY, Insets.EMPTY)));

		Button btn1 = new Button("Annual Report");
		Button btn2 = new Button("Monthly Report");
		Button btn3 = new Button("Farm Report");
		Button btn4 = new Button("Date Range Report");
		Button btn5 = new Button("Upload a file");

		Rectangle r = new Rectangle();
		r.setX(350);
		r.setY(77);
		r.setWidth(200);
		r.setHeight(60);
		r.setFill(Color.LIGHTGREY);
		root.getChildren().add(r);

		Label lbl = new Label("Choose the kind of report");
		lbl.setLayoutX(370);
		lbl.setLayoutY(100);
		root.getChildren().add(lbl);

		btn1.setLayoutX(170);
		btn1.setLayoutY(210);
		btn1.setMinWidth(200);
		btn1.setMaxWidth(200);
		btn1.setMinHeight(60);
		btn1.setMaxHeight(60);
		root.getChildren().add(btn1);

		btn2.setLayoutX(530);
		btn2.setLayoutY(210);
		btn2.setMinWidth(200);
		btn2.setMaxWidth(200);
		btn2.setMinHeight(60);
		btn2.setMaxHeight(60);
		root.getChildren().add(btn2);

		btn3.setLayoutX(170);
		btn3.setLayoutY(380);
		btn3.setMinWidth(200);
		btn3.setMaxWidth(200);
		btn3.setMinHeight(60);
		btn3.setMaxHeight(60);
		root.getChildren().add(btn3);

		btn4.setLayoutX(530);
		btn4.setLayoutY(380);
		btn4.setMinWidth(200);
		btn4.setMaxWidth(200);
		btn4.setMinHeight(60);
		btn4.setMaxHeight(60);
		root.getChildren().add(btn4);

		Button back = new Button("Back");
		back.setLayoutX(10);
		back.setLayoutY(500);
		back.setMinWidth(200);
		back.setMaxWidth(200);
		back.setMinHeight(60);
		back.setMaxHeight(60);
		root.getChildren().add(back);

		Button closeButt = new Button("Close Application");
		closeButt.setLayoutX(350);
		closeButt.setLayoutY(500);
		closeButt.setMinWidth(200);
		closeButt.setMaxWidth(200);
		closeButt.setMinHeight(60);
		closeButt.setMaxHeight(60);
		root.getChildren().add(closeButt);

		back.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent e) {
				StartWindow strtWndw = new StartWindow(primaryStage);
				primaryStage.getScene().setRoot(strtWndw.getPane());
			}
		});

		btn1.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent e) {
				boolean b1 = true;
				Button1Press action = new Button1Press(primaryStage);
				primaryStage.getScene().setRoot(action.getPane());
			}
		});

		btn2.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent e) {
				boolean b2 = true;
				Button2Press action = new Button2Press(primaryStage);
				primaryStage.getScene().setRoot(action.getPane());
			}
		});

		btn3.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent e) {
				boolean b3 = true;
				Button3Press action = new Button3Press(primaryStage);
				primaryStage.getScene().setRoot(action.getPane());
			}
		});

		btn4.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent e) {
				boolean b4 = true;
				Button4Press action = new Button4Press(primaryStage);
				primaryStage.getScene().setRoot(action.getPane());
			}
		});

		closeButt.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent e) {
				System.exit(0);
			}
		});

		primaryStage.setResizable(false);
		primaryStage.setTitle("Milk Weight");
		primaryStage.setScene(mainScene);
		primaryStage.show();
	}

	/*
	 * getting the root of the scene
	 */
	public Pane getPane() {
		return root;
	}
}
