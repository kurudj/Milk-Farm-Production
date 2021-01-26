////////////////////////////////////////////////////////////////////////////////
// Name: Ivan Khurudzhi
// E-mail: khurudzhi@wisc.edu
// Class: CS400
// Lecture: Online
// Project: FINAL A3
////////////////////////////////////////////////////////////////////////////////

package application;

import static org.junit.Assert.fail;

import org.junit.Test;

/*
 * JUnit test class
 */
public class FarmsTest {

	/*
	 * test adding 6 farms to the DT and checking that size is 6, head is farm with
	 * 45 id and tail is farm with 12 id
	 */
	@Test
	public void test1_basicInsertCheck() {
		Farms farms = new Farms(null, null);
		Farm f1 = new Farm(45, 0);
		Farm f2 = new Farm(55, 0);
		Farm f3 = new Farm(65, 0);
		Farm f4 = new Farm(75, 0);
		Farm f5 = new Farm(43, 0);
		Farm f6 = new Farm(12, 0);
		try {
			farms.add(f1);
			farms.add(f2);
			farms.add(f3);
			farms.add(f4);
			farms.add(f5);
			farms.add(f6);
			assert (farms.size == 6);
			assert (farms.head.farmId == 45);
			assert (farms.tail.farmId == 12);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	/*
	 * test checking that a duplicate farm is not added to the DT
	 */
	@Test
	public void test2_duplicateFarmIdInsertCheck() {
		Farms farms = new Farms(null, null);
		Farm f1 = new Farm(45, 0);
		Farm f2 = new Farm(55, 0);
		Farm f3 = new Farm(65, 0);
		Farm f4 = new Farm(45, 0);
		try {
			farms.add(f1);
			farms.add(f2);
			farms.add(f3);
			farms.add(f4);
			fail("duplicate farm inserted and no exception thrown");
		} catch (Exception e) {
			assert (farms.size == 3);
		}
	}

	/*
	 * test checking the correctness of the get method of the Farms class
	 */
	@Test
	public void test3_getFarmCheck() {
		Farms farms = new Farms(null, null);
		Farm f1 = new Farm(45, 0);
		Farm f2 = new Farm(55, 0);
		Farm f3 = new Farm(65, 0);
		Farm f4 = new Farm(50, 0);
		try {
			farms.add(f1);
			farms.add(f2);
			farms.add(f3);
			farms.add(f4);
			assert (farms.get(45).farmId == 45);
			assert (farms.get(55).farmId == 55);
			assert (farms.get(65).farmId == 65);
			assert (farms.get(50).farmId == 50);
			assert (farms.get(-1) == null);
			farms.get(30);
			fail("didn't throw exception");
		} catch (Exception e) {
			// expected
		}
	}

	/*
	 * test checking the correctness of the contains method of the Farms class
	 */
	@Test
	public void test3_containsCheck() {
		Farms farms = new Farms(null, null);
		Farm f1 = new Farm(45, 0);
		Farm f2 = new Farm(55, 0);
		Farm f3 = new Farm(65, 0);
		Farm f4 = new Farm(50, 0);
		try {
			farms.add(f1);
			farms.add(f2);
			farms.add(f3);
			farms.add(f4);
			assert (farms.contains(45) == true);
			assert (farms.contains(55) == true);
			assert (farms.contains(65) == true);
			assert (farms.contains(50) == true);
			assert (farms.contains(30) == false);
		} catch (Exception e) {
			// expected
		}
	}
}
