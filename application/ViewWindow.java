////////////////////////////////////////////////////////////////////////////////
// Name: Ivan Khurudzhi
// E-mail: khurudzhi@wisc.edu
// Class: CS400
// Lecture: Online
// Project: FINAL A3
////////////////////////////////////////////////////////////////////////////////

package application;

import java.util.ArrayList;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

/*
 * class representing the window where report data is displayed
 */
public class ViewWindow {
	Pane root = new Pane();
	private TableView<Row> table = new TableView<Row>();

	/*
	 * constructor setting the scene
	 */
	public ViewWindow(Stage stage) {
		Scene mainScene = new Scene(root, 300, 700);
		root.setBackground(new Background(new BackgroundFill(Color.ORANGE, CornerRadii.EMPTY, Insets.EMPTY)));
		table.setMinWidth(280);
		table.setMinHeight(400);
		table.setLayoutX(10);
		table.setLayoutY(20);
		ObservableList<Row> list = null;

		if (Button3Press.b) {
			TableColumn firstNameCol = new TableColumn<>("Month");
			firstNameCol.setMinWidth(140);

			TableColumn secondNameCol = new TableColumn<>("Milk Weight");
			secondNameCol.setMinWidth(140);

			firstNameCol.setCellValueFactory(new PropertyValueFactory<Row, String>("month"));
			secondNameCol.setCellValueFactory(new PropertyValueFactory<Row, String>("weight"));
			list = getRows(Download.list);
			table.setItems(list);
			table.getColumns().addAll(firstNameCol, secondNameCol);
		} else if (Button1Press.b || Button2Press.b) {
			TableColumn firstNameCol = new TableColumn<>("Farm");
			firstNameCol.setMinWidth(140);

			TableColumn secondNameCol = new TableColumn<>("Milk Weight");
			secondNameCol.setMinWidth(140);

			firstNameCol.setCellValueFactory(new PropertyValueFactory<Row, String>("farm"));
			secondNameCol.setCellValueFactory(new PropertyValueFactory<Row, String>("weight"));
			list = getRows(Download.list);
			table.setItems(list);
			table.getColumns().addAll(firstNameCol, secondNameCol);
		} else if (Button4Press.b) {
			Alert alert = new Alert(AlertType.INFORMATION,
					"Computations are likely to be wrong, for display purposes mostly!");
			alert.show();
			TableColumn firstNameCol = new TableColumn<>("Farm");
			firstNameCol.setMinWidth(140);

			TableColumn secondNameCol = new TableColumn<>("Milk Weight");
			secondNameCol.setMinWidth(140);

			firstNameCol.setCellValueFactory(new PropertyValueFactory<Row, String>("farm"));
			secondNameCol.setCellValueFactory(new PropertyValueFactory<Row, String>("weight"));
			list = getRows(Download.list);
			table.setItems(list);
			table.getColumns().addAll(firstNameCol, secondNameCol);
		}
		root.getChildren().add(table);

		Button closeButt = new Button("Close Application");
		closeButt.setLayoutX(60);
		closeButt.setLayoutY(600);
		closeButt.setMinWidth(200);
		closeButt.setMaxWidth(200);
		closeButt.setMinHeight(60);
		closeButt.setMaxHeight(60);
		root.getChildren().add(closeButt);

		Label totalMilkWeight = new Label("Total Milk Weight - " + Reports.staticTotalWeight);
		totalMilkWeight.setLayoutX(60);
		totalMilkWeight.setLayoutY(420);
		totalMilkWeight.setMinWidth(200);
		totalMilkWeight.setMaxWidth(200);
		totalMilkWeight.setMinHeight(60);
		totalMilkWeight.setMaxHeight(60);
		root.getChildren().add(totalMilkWeight);

		System.out.println((double) (Reports.staticTotalWeight / list.size()));
		Label average = new Label("Average Milk Weight - " + (double) (Reports.staticTotalWeight / list.size()));
		average.setLayoutX(60);
		average.setLayoutY(460);
		average.setMinWidth(200);
		average.setMaxWidth(2000);
		average.setMinHeight(40);
		average.setMaxHeight(40);
		root.getChildren().add(average);

		closeButt.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent e) {
				System.exit(0);
			}
		});

		stage.setTitle("View");
		stage.setResizable(false);
		stage.setScene(mainScene);
		stage.show();
	}

	/*
	 * getting the rows for the columns of the tableview
	 * 
	 * @param list of the report data
	 */
	public ObservableList<Row> getRows(ArrayList<String> list) {
		ObservableList<Row> rows = FXCollections.observableArrayList();
		if (Button3Press.b) // button 3 method is different from others so it's a different case of adding
							// rows
			for (int i = 0; i < list.size(); i++)
				rows.add(new Row(list.get(i).split(",")[0], list.get(i).split(",")[1]));
		else if (Button1Press.b || Button2Press.b || Button4Press.b)
			for (int i = 0; i < list.size(); i++)
				rows.add(new Row(list.get(i).split(",")[1], Integer.valueOf(list.get(i).split(",")[0])));
		return rows;
	}

	/*
	 * getting the root of the scene
	 * 
	 * @param root
	 */
	public Pane getPane() {
		return root;
	}
}
