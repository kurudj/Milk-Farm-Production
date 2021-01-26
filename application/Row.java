////////////////////////////////////////////////////////////////////////////////
// Name: Ivan Khurudzhi
// E-mail: khurudzhi@wisc.edu
// Class: CS400
// Lecture: Online
// Project: FINAL A3
////////////////////////////////////////////////////////////////////////////////

package application;

import javafx.beans.property.SimpleStringProperty;

/*
 * a class representing rows of the tableview
 */
public class Row {
	public SimpleStringProperty month;
	public SimpleStringProperty weight;
	public SimpleStringProperty farm;

	/*
	 * constructor 1 of the class
	 * 
	 * @param month
	 * 
	 * @param weight
	 */
	public Row(String month, String weight) {
		this.month = new SimpleStringProperty(month);
		this.weight = new SimpleStringProperty(weight);
	}

	/*
	 * constructor 2 of the class
	 * 
	 * @param weight
	 * 
	 * @param farm
	 */
	public Row(String weight, int farm) {
		this.weight = new SimpleStringProperty(weight);
		this.farm = new SimpleStringProperty(String.valueOf(farm));
	}

	/*
	 * getting the month
	 * 
	 * @return month as a string
	 */
	public String getMonth() {
		return month.get();
	}

	/*
	 * setting the month
	 * 
	 * @param month to set
	 */
	public void setMonth(String month) {
		this.month.set(month);
	}

	/*
	 * getting the weight
	 * 
	 * @return weight as a string
	 */
	public String getWeight() {
		return weight.get();
	}

	/*
	 * setting the weight
	 * 
	 * @param weight to set
	 */
	public void setWeight(String weight) {
		this.weight.set(weight);
	}

	/*
	 * getting the farm
	 * 
	 * @return farm as a string
	 */
	public String getFarm() {
		if (farm != null)
			return farm.get();
		else
			return null;
	}

	/*
	 * setting the farm
	 * 
	 * @param farm to set
	 */
	public void setFarm(String farm) {
		this.farm.set(farm);
	}
}
