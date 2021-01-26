////////////////////////////////////////////////////////////////////////////////
// Name: Ivan Khurudzhi
// E-mail: khurudzhi@wisc.edu
// Class: CS400
// Lecture: Online
// Project: FINAL A3
////////////////////////////////////////////////////////////////////////////////

package application;

import java.io.File; // Import the File class
import java.io.FileNotFoundException; // Import this class to handle errors
import java.util.ArrayList;
import java.util.Scanner; // Import the Scanner class to read text files

/*
 * class that reads a file
 */
public class FileReader {
	File f;
	ArrayList<String> readFile;

	/*
	 * constructor of the class
	 * 
	 * @param file to read
	 */
	public FileReader(File f) {
		this.f = f;
	}

	/*
	 * reading a file and converting it to arraylist of strings
	 * 
	 * @return array list of strings with strings of the file
	 */
	public ArrayList<String> readFile() {
		try {
			Scanner scnr = new Scanner(f);
			readFile = new ArrayList<String>();
			while (scnr.hasNextLine()) {
				readFile.add(scnr.nextLine());
			}
			scnr.close();
		} catch (FileNotFoundException e) {
			System.out.println("Unfortunately, file is not found");
		}
		return readFile;
	}

	/*
	 * get the array list representing the read file
	 * 
	 * @return read file array list
	 */
	public ArrayList<String> getList() {
		return readFile;
	}
}
