////////////////////////////////////////////////////////////////////////////////
// Name: Ivan Khurudzhi
// E-mail: khurudzhi@wisc.edu
// Class: CS400
// Lecture: Online
// Project: FINAL A3
////////////////////////////////////////////////////////////////////////////////

package application;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

public class StartWindow {
	Pane root = new Pane();
	public static File f;

	/*
	 * constructor setting the start window scene
	 */
	public StartWindow(Stage primaryStage) {
		Scene mainScene = new Scene(root, 900, 600);
		root.setBackground(new Background(new BackgroundFill(Color.ORANGE, CornerRadii.EMPTY, Insets.EMPTY)));
		ArrayList<String> list;

		Button upld = new Button("Upload a file");
		upld.setLayoutX(350);
		upld.setLayoutY(300);
		upld.setMinWidth(200);
		upld.setMaxWidth(200);
		upld.setMinHeight(60);
		upld.setMaxHeight(60);
		root.getChildren().add(upld);

		Button closeButt = new Button("Close Application");
		closeButt.setLayoutX(350);
		closeButt.setLayoutY(400);
		closeButt.setMinWidth(200);
		closeButt.setMaxWidth(200);
		closeButt.setMinHeight(60);
		closeButt.setMaxHeight(60);
		root.getChildren().add(closeButt);

		Label lbl = new Label("Welcome to the Milk Weight application");
		lbl.setLayoutX(180);
		lbl.setLayoutY(120);
		lbl.setTextFill(Color.WHITE);
		lbl.setFont(new Font("Arial", 30));
		root.getChildren().add(lbl);

		upld.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent e) {
				FileChooser fileChooser = new FileChooser();
				FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter("CSV files (*.csv)", "*.csv",
						"*.json");
				fileChooser.getExtensionFilters().add(extFilter);
				fileChooser.setTitle("Open Multiple Files");
				List<File> fileList = fileChooser.showOpenMultipleDialog(primaryStage);
				boolean n = true;
				if (fileList == null) // making sure the file list is correct
					n = false;
				if (n) {
					StartWindow.f = readFile(fileList);
					try {
						if (!formatChecker(StartWindow.f)) { // checking the format
							ButtonType reupld = new ButtonType("Reupload");
							ButtonType exit = new ButtonType("Exit");
							Alert alert = new Alert(AlertType.ERROR, "Wrong Input Format. Re-upload a correct input.",
									reupld, exit); // alert if there's errors in the file format
							alert.showAndWait().ifPresent(reaction -> {
								boolean rpld = false;
								if (reaction == reupld) {// if the user chooses to reupload
									rpld = true; // then alert closes and scene recreates itself
									alert.close();
								} else {
									System.exit(0); // otherwise the applications exits
								}
								if (rpld) {
									StartWindow strtWndw = new StartWindow(primaryStage);
									primaryStage.getScene().setRoot(strtWndw.getPane());
								}
							});
						} else { // if the format is right we go to the next scene
							MainWindow mainWndw = new MainWindow(primaryStage);
							primaryStage.getScene().setRoot(mainWndw.getPane());
						}
					} catch (FileNotFoundException e1) {
						//
					}
				}
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
	 * 
	 * @return root
	 */
	public Pane getPane() {
		return root;
	}

	/*
	 * file that determines if the file is written in the right format
	 * 
	 * @param file that is being checked
	 * 
	 * @return true if the format is right, false otherwise
	 * 
	 * @throws FileNotFoundException if there's no such file
	 */
	public boolean formatChecker(File f) throws FileNotFoundException {
		Scanner scnr = new Scanner(f);
		if (!formatCheckerHelper(scnr))
			return false;
		else
			return true;
	}

	/*
	 * helper method for the formatChecker method
	 * 
	 * @param scnr that reads the file
	 * 
	 * @return true if the format is right, false otherwise
	 */
	public boolean formatCheckerHelper(Scanner scnr) {
		String s1 = "";
		String s2 = "";
		String s3 = "";
		String genS = "";
		boolean n = true;
		while (scnr.hasNextLine()) { // making sure that every string in the file is in proper format
			genS = scnr.nextLine();
			s1 = genS.split(",")[0];
			s2 = genS.split(",")[1];
			s3 = genS.split(",")[2];
			if (s1.charAt(0) < 48 || s1.charAt(0) > 57)
				return false;
			if (s1.charAt(1) < 48 || s1.charAt(1) > 57)
				return false;
			if (s1.charAt(2) < 48 || s1.charAt(2) > 57)
				return false;
			if (s1.charAt(3) < 48 || s1.charAt(3) > 57)
				return false;
			if (s1.charAt(4) != 45)
				return false;
			if (s1.charAt(5) < 48 || s1.charAt(5) > 57)
				return false;
			if (s1.charAt(6) != 45
					&& !(Integer.parseInt(s1.substring(5, 6)) >= 10 || Integer.parseInt(s1.substring(5, 6)) <= 12))
				return false;
			if (s1.charAt(7) == 45 && (s1.charAt(8) < 48 || s1.charAt(8) > 57))
				return false;
			if (!s2.contains("Farm"))
				return false;
			if (!s2.contains(" "))
				return false;
			if (s2.charAt(5) < 45 || s2.charAt(5) > 57)
				return false;
			try {
				Double num = Double.parseDouble(s3);
			} catch (NumberFormatException e) {
				n = false;
			}
			if (!n)
				return false;
		}
		return true;

	}

	/*
	 * reading the files from a list of files into a single file
	 * 
	 * @param list of files inputted from the file chooser
	 * 
	 * @return file combining data from several files
	 */
	public static File readFile(List<File> list) {
		FileReader reader;
		ArrayList<String> read;
		FileWriter writer = null;
		File f = null;
		try {
			f = new File("./FilesWritten.txt");
			writer = new FileWriter(f);
		} catch (IOException e) {
			e.printStackTrace();
		}
		for (int i = 0; i < list.size(); i++) {
			reader = new FileReader(list.get(i));
			read = reader.readFile();
			for (int j = 1; j < read.size(); j++) {
				try {
					writer.write(read.get(j));
					writer.write("\n");
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		try {
			writer.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return f;
	}
}
