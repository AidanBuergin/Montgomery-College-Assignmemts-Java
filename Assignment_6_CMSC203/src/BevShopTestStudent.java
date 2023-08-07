/*
 * Class: CMSC203 
 * Instructor: Eivazi
 * Description: BevShop junit test
 * Due: 08/06/2023
 * Platform/compiler: eclipse
 * I pledge that I have completed the programming 
 * assignment independently. I have not copied the code 
 * from a student or any source. I have not given my code 
 * to any student.
   Print your Name here: __aidan buergin________
*/
import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;


public class BevShopTestStudent {

	Customer c1;
	Customer c2;
	
	Order o1;
	Order o2;
	Order o3;
	
	BevShop b1;

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
		b1 = new BevShop();
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
		b1 = null;
	}

	@Test
	public void testConstructor() {
		assertFalse(b1.orders == null);
	}
	
	@Test
	public void testIsValidTime() {
		assertFalse(b1.isValidTime(3));
		assertFalse(b1.isValidTime(29));
		assertTrue(b1.isValidTime(13));
	}
	
	@Test
	public void testIsValidAge() {
		assertFalse(b1.isValidAge(3));
		assertTrue(b1.isValidTime(23));
	}
	
	@Test
	public void testIsMaxFruit() {
		assertFalse(b1.isMaxFruit(3));
		assertTrue(b1.isMaxFruit(5));
	}
	
	@Test
	public void testIsEligibleForMore() {
		o1.addNewBeverage("alc1", Size.SMALL);
		o1.addNewBeverage("alc2", Size.SMALL);
		b1.setCurrentOrder(o1);
		assertTrue(b1.isEligibleForMore());
		b1.setCurrentOrder(o1);
		o1.addNewBeverage("alc3", Size.SMALL);
		assertFalse(b1.isEligibleForMore());
	}
	
	@Test
	public void testStartNewOrder() {
		b1.startNewOrder(8, Day.TUESDAY, "John", 22);
		o1.setOrderNo(b1.getCurrentOrder().getOrderNo());
		assertEquals(b1.getCurrentOrder().cust.toString(), o1.cust.toString());
	}
	
	@Test
	public void testProcessOrder() {
		b1.startNewOrder(8, Day.TUESDAY, "John", 22);
		b1.processAlcoholOrder("alc", Size.LARGE);
		b1.processSmoothieOrder("smo", Size.LARGE, 2, true);
		b1.processCoffeeOrder("cof", Size.LARGE, false, true);
		assertEquals(b1.getCurrentOrder().bevList.size(), 3, .02);
	}
	
	@Test
	public void testFindOrder() {
		b1.startNewOrder(8, Day.TUESDAY, "John", 22);
		o1.setOrderNo(b1.getCurrentOrder().getOrderNo());
		assertEquals(b1.getCurrentOrder().cust.toString(), o1.cust.toString());
	}
	
	@Test
	public void testTotalOrderPrice() {
		b1.startNewOrder(9, Day.FRIDAY, "Keith", 21);
		b1.processAlcoholOrder("alc", Size.SMALL);
		b1.orders.add(b1.getCurrentOrder());
		b1.orders.get(0).setOrderNo(1);
		assertEquals(2, b1.totalOrderPrice(1), .06);
	}
	
	@Test
	public void testTotalMonthlySale() {
		b1.startNewOrder(9, Day.FRIDAY, "Keith", 21);
		b1.processAlcoholOrder("alc", Size.SMALL);
		b1.orders.add(b1.getCurrentOrder());
		b1.startNewOrder(9, Day.FRIDAY, "Keith", 21);
		b1.processAlcoholOrder("alc", Size.SMALL);
		b1.orders.add(b1.getCurrentOrder());
		assertEquals(4, b1.totalMonthlySale(), .06);
	}
	
	@Test
	public void testSort() {
		b1.startNewOrder(8, Day.TUESDAY, "John", 22);
		b1.orders.add(b1.getCurrentOrder());
		b1.orders.get(0).setOrderNo(20000);
		b1.startNewOrder(8, Day.TUESDAY, "John", 22);
		b1.orders.add(b1.getCurrentOrder());
		b1.orders.get(0).setOrderNo(10000);
		b1.sortOrders();
		assertEquals(b1.orders.get(0).getOrderNo(), 10000, .01);
	}
	
	@Test
	public void testToString() {
		b1.startNewOrder(8, Day.TUESDAY, "John", 22);
		b1.orders.add(b1.getCurrentOrder());
		b1.orders.get(0).setOrderNo(70000);
		assertEquals(b1.toString(), 
				"all orders: \n"
				+ "Order [orderNumber=70000, orderTime=8, "
				+ "customer info=[name = John, age = 22], orderDay=TUESDAY,\n"
				+ "bevList=[]]\n"
				+ "total monthly sales: 1");
	}

}
