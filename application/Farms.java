////////////////////////////////////////////////////////////////////////////////
// Name: Ivan Khurudzhi
// E-mail: khurudzhi@wisc.edu
// Class: CS400
// Lecture: Online
// Project: FINAL A3
////////////////////////////////////////////////////////////////////////////////

package application;

import java.text.DecimalFormat;
import java.util.ArrayList;

/*
 * class representing the data structure of the farms
 */
public class Farms {
	Farm head;
	Farm tail;
	int size;
	static ArrayList<String> list;
	static ArrayList<String> viewList = new ArrayList<String>();
	static Farm searchedForFarm; // used in other classes
									// so that when a farm with id that is already in the DT
									// is being added we sum the weights instead of rewriting

	/*
	 * constructor 1 for farms
	 */
	public Farms() {
		size = 0;
		head = null;
		tail = null;
	}

	/*
	 * constructor 2 for farms
	 * 
	 * @param head
	 * 
	 * @param tail
	 */
	public Farms(Farm head, Farm tail) {
		this.head = head;
		this.tail = tail;
		size = 0;
	}

	/*
	 * method that returns farm with a certain farmId
	 * 
	 * @param farmId - id of the farm to search for
	 * 
	 * @return farm with given farmId
	 * 
	 * @throws Exception if farms does not contain farm with given id
	 */
	public Farm get(int farmId) throws Exception {
		if (farmId < 0)
			return null;
		if (!contains(farmId))
			throw new Exception();
		Farm f = null;
		if (head != null) {
			f = head.getNext();
			for (int i = 0; i < farmId; i++) {
				if (f.getNext() == null)
					return null;
				f = f.getNext();
			}
			searchedForFarm = f;
			return f;
		}
		searchedForFarm = f;
		return f;
	}

	/*
	 * adding a farm to the data structure
	 * 
	 * @param farm to add
	 * 
	 * @throws exception if farms already contains such a farm
	 */
	public void add(Farm farm) throws Exception {
		if (contains(farm.getFarmId())) {
			int newWeight = farm.weight;
			farm = searchedForFarm;
			farm.addWeight(newWeight);
		}
		if (head == null) {
			head = tail = farm;
			head.setPrevious(null);
			tail.setNext(null);
		} else {
			tail.setNext(farm);
			farm.setPrevious(tail);
			tail = farm;
			tail.setNext(null);
		}
		size++;
	}

	/*
	 * removing a farm with given id from the data structure
	 * 
	 * @param farmId of the farm to remove
	 */
	public void remove(int farmId) {
		if (head.getFarmId() == farmId) {
			head = head.next;
			head.setPrevious(null);
		} else if (tail.getFarmId() == farmId) {
			tail = tail.getPrevious();
			tail.setNext(null);
		} else {
			Farm temp = head;
			while (temp.next != null && temp.getNext().getFarmId() != farmId) {
				temp = temp.next;
			}
			if (temp != null) {
				temp.setNext(temp.getNext().getNext());
				temp.getNext().setPrevious(temp);
			}
		}
		size--;
	}

	/*
	 * check if the data structure contains a farm with given id
	 * 
	 * @param farmId of the farm to search
	 * 
	 * @return true if contains else otherwise
	 */
	public boolean contains(int farmId) {
		Farm temp = head;
		while (temp != null) {
			if (temp.getFarmId() == farmId)
				return true;
			temp = temp.next;
		}
		return false;
	}

	/*
	 * getting the size of the data structure
	 * 
	 * @return size of the farms DT
	 */
	public int size() {
		return size;
	}

	/*
	 * getting the total weight of the milk of the farms in the DT
	 * 
	 * @return totalWeight
	 */
	public int getTotalWeight() {
		Farm temp = head;
		int weight = 0;
		while (temp != null) {
			weight += temp.weight;
			temp = temp.next;
		}
		return weight;
	}

	/*
	 * transforming farms DT into a string depending on a type of analysis
	 * 
	 * @return string representing the analysis of inputted farms
	 */
	public String toString() {
		String s = "";
		if (Button1Press.b) {
			Farm temp = head;
			double div = 0;
			int totalWeight = getTotalWeight();
			s = "Total Milk Weight - " + totalWeight + "\n";
			DecimalFormat format = new DecimalFormat("#.00");
			while (temp != null) {
				div = (double) temp.weight / totalWeight;
				viewList.add(String.valueOf(temp.getFarmId()) + "," + String.valueOf(format.format(div * 100)));
				s += "Percent of milk weight for Farm " + temp.getFarmId() + " - " + format.format(div * 100) + "\n";
				temp = temp.next;
			}
		} else if (Button2Press.b) {
			Farm temp = head;
			double div = 0;
			int totalWeight = getTotalWeight();
			s = "Total Milk Weight - " + totalWeight + "\n";
			DecimalFormat format = new DecimalFormat("#.00");
			while (temp != null) {
				div = (double) temp.weight / totalWeight;
				viewList.add(String.valueOf(temp.getFarmId()) + "," + String.valueOf(format.format(div * 100)) + ","
						+ String.valueOf(temp.weight));
				s += "Percent of milk weight for Farm " + temp.getFarmId() + " - " + format.format(div * 100)
						+ ". Milk Weight for Farm " + temp.getFarmId() + " - " + temp.weight + ".\n";
				temp = temp.next;
			}
		} else if (Button4Press.b) {
			Farm temp = head;
			double div = 0;
			int totalWeight = getTotalWeight();
			s = "";
			String per;
			DecimalFormat format = new DecimalFormat("#.00");
			while (temp != null) {
				per = format.format(div * 100);
				viewList.add(String.valueOf(temp.getFarmId()) + "," + String.valueOf(format.format(div * 100)));
				s += "Total milk per farm " + temp.getFarmId() + " - " + temp.weight + ".";
				div = (double) temp.weight / totalWeight;
				s += "Percent of milk weight for Farm " + temp.getFarmId() + " - " + format.format(div * 100) + ".\n";
				temp = temp.next;
			}
		}
		return s;
	}
}
