////////////////////////////////////////////////////////////////////////////////
// Name: Ivan Khurudzhi
// E-mail: khurudzhi@wisc.edu
// Class: CS400
// Lecture: Online
// Project: FINAL A3
////////////////////////////////////////////////////////////////////////////////

package application;

/*
 * class representing a single farm
 */
public class Farm {
	int farmId;
	int year;
	int month;
	String startDate;
	String endDay;
	Farm previous;
	Farm next;
	int weight;

	/*
	 * constructor 1 for farm
	 * 
	 * @param farmId - id of the farm
	 * 
	 * @param year - year for the farm
	 * 
	 * @param month - month for the farm
	 * 
	 * @param startDate - starting date of the analysis for the farm
	 * 
	 * @param endDay - ending date of the analysis for the farm
	 */
	public Farm(int farmId, int year, int month, String startDate, String endDay) {
		this.farmId = farmId;
		this.month = month;
		this.year = year;
		this.startDate = startDate;
		this.endDay = endDay;
	}

	/*
	 * constructor 2 for farm
	 * 
	 * @param farmId - id of the farm
	 * 
	 * @param weight - weight of the milk produced by the farm
	 */
	public Farm(int farmId, int weight) {
		this.farmId = farmId;
		this.weight = weight;
	}

	/*
	 * getting the next farm
	 * 
	 * @return next
	 */
	public Farm getNext() {
		return next;
	}

	/*
	 * setting the next farm
	 * 
	 * @param next farm
	 */
	public void setNext(Farm next) {
		this.next = next;
	}

	/*
	 * getting the previous farm
	 * 
	 * @return previous
	 */
	public Farm getPrevious() {
		return previous;
	}

	/*
	 * setting the previous farm
	 * 
	 * @param previous farm
	 */
	public void setPrevious(Farm previous) {
		this.previous = previous;
	}

	/*
	 * getting the id of the farm
	 * 
	 * @return farmId
	 */
	public int getFarmId() {
		return farmId;
	}

	/*
	 * adding weight to the farm
	 * 
	 * @param weight
	 */
	public void addWeight(int weight) {
		this.weight += weight;
	}
}
