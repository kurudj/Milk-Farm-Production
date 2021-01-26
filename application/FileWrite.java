////////////////////////////////////////////////////////////////////////////////
// Name: Ivan Khurudzhi
// E-mail: khurudzhi@wisc.edu
// Class: CS400
// Lecture: Online
// Project: FINAL A3
////////////////////////////////////////////////////////////////////////////////

package application;

import java.io.File; // Import the File class
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

/*
 * class that writes an array list of strings to a file
 */
public class FileWrite {
	static File f;

	/*
	 * a constructor for the class
	 * 
	 * @param s - name of the file to write into
	 */
	public FileWrite(String s) {
		this.f = new File(s);
	}

	/*
	 * writing array list into a file
	 * 
	 * @param list of strings to write into a file
	 */
	public void writeFile(ArrayList<String> list) {
		FileWriter writer = null;
		try {
			writer = new FileWriter(f);
		} catch (IOException e) {
			System.out.println("fwdf");
			e.printStackTrace();
		}
		for (int i = 1; i < list.size(); i++) {
			try {
				// System.out.println(list.get(i));
				writer.write(list.get(i));
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
