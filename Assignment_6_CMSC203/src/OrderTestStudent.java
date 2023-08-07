import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/*
 * Class: CMSC203 
 * Instructor: Eivazi
 * Description: order junit test
 * Due: 08/06/2023
 * Platform/compiler: eclipse
 * I pledge that I have completed the programming 
 * assignment independently. I have not copied the code 
 * from a student or any source. I have not given my code 
 * to any student.
   Print your Name here: __aidan buergin________
*/

public class OrderTestStudent {
	
	Customer c1;
	Customer c2;
	
	Order o1;
	Order o2;
	Order o3;

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		c1 = new Customer("John", 22);
		c2 = new Customer("Sam", 32);
		o1 = new Order(8, Day.TUESDAY, c1);
		o2 = new Order(8, Day.TUESDAY, c1);
		o3 = new Order(12, Day.SATURDAY, c2);
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
		c1 = null;
		c2 = null;
		o1 = null;
		o2 = null;
		o3 = null;
	}

	@Test
	public void testConstructor() {
		assertEquals(o1.getOrderTime(), o2.getOrderTime());
		assertEquals(o1.getOrderDay(), o2.getOrderDay());
		assertEquals(o1.getCust().toString(), o2.getCust().toString());
	}
	
	@Test
	public void testRandOrderNum() {
		assertFalse(o1.generateOrder() == o2.generateOrder());
	}
	
	@Test
	public void testCompareTo() {
		assertEquals(o1.compareTo(o1), 0, .01);
		assertFalse(o1.compareTo(o2) == 0);
	}
	
	@Test
	public void testIsWeekend() {
		assertFalse(o1.isWeekend());
		assertTrue(o3.isWeekend());
	}
	
	@Test
	public void testAddNewBeverage() {
		o1.addNewBeverage("alc", Size.MEDIUM);
		o1.addNewBeverage("smooth", Size.MEDIUM, 4, true);
		o1.addNewBeverage("coff", Size.MEDIUM, true, false);
		
		assertEquals(o1.bevList.get(0).getBevName(), "alc");
		assertEquals(o1.bevList.get(1).getBevName(), "smooth");
		assertEquals(o1.bevList.get(2).getBevName(), "coff");
	}
	
	@Test
	public void testCalcOrderTotal() {
		o1.addNewBeverage("alc", Size.MEDIUM);
		o1.addNewBeverage("smooth", Size.MEDIUM, 4, true);
		o1.addNewBeverage("coff", Size.MEDIUM, true, false);
		
		assertEquals(o1.calcOrderTotal(), 13.0, .01);
	}
	
	@Test
	public void testNumOfBevType() {
		o1.addNewBeverage("alc", Size.MEDIUM);
		o1.addNewBeverage("smooth", Size.MEDIUM, 4, true);
		o1.addNewBeverage("coff", Size.MEDIUM, true, false);
		
		assertEquals(o1.findNumOfBeveType(Type.ALCOHOL), 1, .01);
	}

}
