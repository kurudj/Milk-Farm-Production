////////////////////////////////////////////////////////////////////////////////
// Name: Ivan Khurudzhi
// E-mail: khurudzhi@wisc.edu
// Class: CS400
// Lecture: Online
// Project: FINAL A3
////////////////////////////////////////////////////////////////////////////////

package application;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

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
 * class that creates a new scene when a submit button is pressed
 */
public class Download {

	Pane root = new Pane();
	static ArrayList<String> list = new ArrayList<String>(); // list that will be used in displaying data
	static String s;

	/*
	 * setting up the scene for the download scene
	 */
	public Download(Stage stage) {
		Scene mainScene = new Scene(root, 900, 600);
		root.setBackground(new Background(new BackgroundFill(Color.ORANGE, CornerRadii.EMPTY, Insets.EMPTY)));
		Rectangle r = new Rectangle();
		r.setX(350);
		r.setY(140);
		r.setWidth(200);
		r.setHeight(60);
		r.setFill(Color.LIGHTGREY);
		root.getChildren().add(r);

		Label lbl = new Label("Your report is ready!");
		lbl.setLayoutX(380);
		lbl.setLayoutY(160);
		root.getChildren().add(lbl);

		Button printToFile = new Button("Print result to file");
		printToFile.setLayoutX(350);
		printToFile.setLayoutY(260);
		printToFile.setMinWidth(200);
		printToFile.setMaxWidth(200);
		printToFile.setMinHeight(60);
		printToFile.setMaxHeight(60);
		root.getChildren().add(printToFile);

		Button view = new Button("View");
		view.setLayoutX(350);
		view.setLayoutY(360);
		view.setMinWidth(200);
		view.setMaxWidth(200);
		view.setMinHeight(60);
		view.setMaxHeight(60);
		root.getChildren().add(view);

		Button closeButt = new Button("Close Application");
		closeButt.setLayoutX(355);
		closeButt.setLayoutY(500);
		closeButt.setMinWidth(200);
		closeButt.setMaxWidth(200);
		closeButt.setMinHeight(60);
		closeButt.setMaxHeight(60);
		root.getChildren().add(closeButt);

		printToFile.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent e) {
				if (Button1Press.b) {
					try {
						FileWriter writer = new FileWriter(Button1Press.writeFile);
						writer.write(Button1Press.farms.toString()); // write data to file
						writer.close();
					} catch (IOException e1) {
						e1.printStackTrace();
					}
				} else if (Button2Press.b) {
					try {
						FileWriter writer = new FileWriter(Button2Press.writeFile);
						writer.write(Button2Press.farms.toString());// write data to file
						writer.close();
					} catch (IOException e1) {
						e1.printStackTrace();
					}
				} else if (Button3Press.b) {
					try {
						FileWriter writer = new FileWriter(Button3Press.writeFile);
						writer.write("Total Milk Weight - " + Button3Press.arr[12] + ".\n");
						for (int i = 0; i < Button3Press.arr.length - 1; i++) {
							list.add(String.valueOf(i + 1) + "," + String.valueOf(Button3Press.arr[i]));
							writer.write("Percent of milk of month " + (i + 1) + " - " + Button3Press.arr[i] + ".\n");
						} // write data from an array to file
						writer.close();
					} catch (IOException e1) {
						e1.printStackTrace();
					}
				} else if (Button4Press.b) {
					try {
						FileWriter writer = new FileWriter(Button4Press.writeFile);
						writer.write(Button4Press.farms.toString());// write data to file
						writer.close();
					} catch (IOException e1) {
						e1.printStackTrace();
					}
				}
			}
		});

		view.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent e) {
				if (Button3Press.b)
					for (int i = 0; i < Button3Press.arr.length - 1; i++)
						list.add(String.valueOf(i + 1) + "," + String.valueOf(Button3Press.arr[i])); // adding data to
																										// list
				if (Button1Press.b) {
					s = Button1Press.farms.toString(); // transforming farms' data into a string
					list = Farms.viewList; // getting farms' viewlist
				}
				if (Button2Press.b) {
					s = Button2Press.farms.toString();// transforming farms' data into a string
					list = Farms.viewList; // getting farms' viewlist
				}
				if (Button4Press.b) {
					s = Button4Press.farms.toString();// transforming farms' data into a string
					list = Farms.viewList;// getting farms' viewlist
				}
				ViewWindow action = new ViewWindow(stage);
				stage.getScene().setRoot(action.getPane());
			}
		});

		closeButt.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent e) {
				System.exit(0);
			}
		});

		stage.setTitle("Download");
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