////////////////////////////////////////////////////////////////////////////////
// Name: Ivan Khurudzhi
// E-mail: khurudzhi@wisc.edu
// Class: CS400
// Lecture: Online
// Project: FINAL A3
////////////////////////////////////////////////////////////////////////////////

package application;

import java.util.ArrayList;

/*
 * class containing the functionality of the application, i.e.
 * where the analysis is done
 */
public class Reports {
	Farms farms;
	int farmId;
	int year;
	int month;
	String start;
	String end;
	ArrayList<String> list;
	static int staticTotalWeight;

	/*
	 * constructor 1 for the class
	 * 
	 * @param year to get a report for
	 * 
	 * @param list of the data
	 */
	public Reports(int year, ArrayList<String> list) {
		this.year = year;
		this.list = list;
	}

	/*
	 * constructor 2 for the class
	 * 
	 * @param year to get a report for
	 * 
	 * @param farmId of a farm to get a report for
	 * 
	 * @param list of the data
	 */
	public Reports(int year, int farmId, ArrayList<String> list) {
		this.farmId = farmId;
		this.year = year;
		this.list = list;
	}

	/*
	 * constructor 3 for the class
	 * 
	 * @param year to get a report for
	 * 
	 * @param month to get a report for
	 * 
	 * @param list of the data
	 */
	public Reports(int year, String month, ArrayList<String> list) {
		this.year = year;
		this.month = Integer.parseInt(month);
		this.list = list;
	}

	/*
	 * constructor 4 for the class
	 * 
	 * @param start date of the range to get a report of
	 * 
	 * @param end date of the range to get a report of
	 * 
	 * @param list of the data
	 */
	public Reports(String start, String end, ArrayList<String> list) {
		this.start = start;
		this.end = end;
		this.list = list;
	}

	/*
	 * method that generates a farm report
	 * 
	 * @return integer array with report data
	 */
	public double[] farmReport() {
		String idStr = "Farm " + farmId;
		String yearStr = Integer.toString(year);
		double[] weightByMonth = new double[13];
		int j = 0;
		int w = 0;
		int totalMilkWeight = 0;
		ArrayList<String> newList = new ArrayList<String>();
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).contains(idStr) && list.get(i).contains(yearStr))
				newList.add(list.get(i)); // filtering the list from unnecessary strings
		}
		list = newList;
		for (int i = 0; i < list.size(); i++) {
			j = Integer.parseInt(list.get(i).split("-")[1]);
			w = Integer.parseInt(list.get(i).split(",")[2]);
			totalMilkWeight += w;
			weightByMonth[j - 1] += w;
		} // writing list into an array with proper weight and month values
		for (int i = 0; i < weightByMonth.length; i++) {
			weightByMonth[i] = (weightByMonth[i] / totalMilkWeight) * 100;
		} // computing percents for every weight value
		weightByMonth[12] = (double) totalMilkWeight; // adding total weight as the last array value
		staticTotalWeight = totalMilkWeight;
		return weightByMonth;
	}

	/*
	 * method that generates annual report
	 * 
	 * @return farms - DT of the report data
	 */
	public Farms annualReport() {
		String yearStr = Integer.toString(year);
		Farms farms = new Farms(null, null);
		ArrayList<String> newList = new ArrayList<String>();
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).contains(yearStr))
				newList.add(list.get(i));
		} // filtering the list from unnecessary strings
		list = newList;
		int weight = 0;
		int id = 0;
		int totalWeight = 0;
		for (int i = 0; i < list.size(); i++) {
			id = Integer.parseInt(list.get(i).split(",")[1].split(" ")[1]);
			weight = Integer.parseInt(list.get(i).split(",")[2]);
			totalWeight += weight;
			try {
				farms.add(new Farm(id, weight));
			} catch (Exception e) {
				// System.out.println("bluyat");
			}
			// creating a DT of farms while going through the sorted list
		}
		staticTotalWeight = totalWeight;
		return farms;
	}

	/*
	 * method that generates a monthly report
	 * 
	 * @return farms - a DT of the report data
	 */
	public Farms monthlyReport() {
		String monthYearStr = Integer.toString(year) + "-" + Integer.toString(month) + "-";
		Farms farms = new Farms();
		ArrayList<String> newList = new ArrayList<String>();
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).contains(monthYearStr))
				newList.add(list.get(i));
		} // filtering the list from unnecessary strings
		list = newList;
		int w = 0;
		int totalWeight = 0;
		int id = 0;
		for (int i = 0; i < list.size(); i++) {
			id = Integer.parseInt(list.get(i).split(",")[1].split(" ")[1]);
			w = Integer.parseInt(list.get(i).split(",")[2]);
			totalWeight += w;
			try {
				farms.add(new Farm(id, w));
			} catch (Exception e) {
				// System.out.println("bluyat");
			}
			// creating a DT of farms while going through the sorted list
		}
		staticTotalWeight = totalWeight;
		return farms;
	}

	/*
	 * method generating date range report
	 * 
	 * @return farms - a DT of the report data
	 */
	public Farms dateRangeReport() {
		int startYearInt = Integer.parseInt(start.split("-")[0]);
		int startMonthInt = Integer.parseInt(start.split("-")[1]);
		int startDayInt = Integer.parseInt(start.split("-")[2]);
		int endYearInt = Integer.parseInt(end.split("-")[0]);
		int endMonthInt = Integer.parseInt(end.split("-")[1]);
		int endDayInt = Integer.parseInt(end.split("-")[2]);
		int currYearInt = 0, currMonthInt = 0, currDayInt = 0;
		ArrayList<String> finalList = new ArrayList<String>();
		for (int i = 0; i < list.size(); i++) {
			currYearInt = Integer.parseInt(list.get(i).split(",")[0].split("-")[0]);
			currMonthInt = Integer.parseInt(list.get(i).split(",")[0].split("-")[1]);
			currDayInt = Integer.parseInt(list.get(i).split(",")[0].split("-")[2]);
			if (!(currYearInt > endYearInt || currYearInt < startYearInt || currMonthInt > endMonthInt
					|| currMonthInt < startMonthInt || currDayInt > endDayInt || currDayInt < startDayInt)) {
				finalList.add(list.get(i));
			} // filtering the list by looking at date values
		}
		list = finalList;
		int w = 0;
		int totalWeight = 0;
		int id = 0;
		Farms farms = new Farms();
		for (int i = 0; i < list.size(); i++) {
			id = Integer.parseInt(list.get(i).split(",")[1].split(" ")[1]);
			w = Integer.parseInt(list.get(i).split(",")[2]);
			totalWeight += w;
			try {
				farms.add(new Farm(id, w));
			} catch (Exception e) {
				// System.out.println("bluyat");
			}
			// creating a DT of farms while going through the sorted list
		}
		staticTotalWeight = totalWeight;
		return farms;
	}

}
