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
 * class that creates a new scene when a user inputs an invalid value
 */
public class InvalidValue {

	Pane root = new Pane();

	public InvalidValue(Stage stage) {
		Scene mainScene = new Scene(root, 900, 600);
		root.setBackground(new Background(new BackgroundFill(Color.ORANGE, CornerRadii.EMPTY, Insets.EMPTY)));
		Rectangle r = new Rectangle();
		r.setX(350);
		r.setY(140);
		r.setWidth(200);
		r.setHeight(60);
		r.setFill(Color.RED);
		root.getChildren().add(r);

		Label lbl = new Label("Invalid value!");
		lbl.setLayoutX(410);
		lbl.setLayoutY(160);
		lbl.setTextFill(Color.WHITE);
		root.getChildren().add(lbl);

		Button tryAgn = new Button("Try Again");
		tryAgn.setLayoutX(355);
		tryAgn.setLayoutY(380);
		tryAgn.setMinWidth(200);
		tryAgn.setMaxWidth(200);
		tryAgn.setMinHeight(60);
		tryAgn.setMaxHeight(60);
		root.getChildren().add(tryAgn);

		tryAgn.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent e) {
				MainWindow action = new MainWindow(stage);
				stage.getScene().setRoot(action.getPane());
			}
		});

		stage.setTitle("Invalid Value Entered");
		stage.setResizable(false);
		stage.setScene(mainScene);
		stage.show();
	}

	public Pane getPane() {
		return root;
	}
}