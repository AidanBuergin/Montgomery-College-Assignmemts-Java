import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
/*
 * Class: CMSC203 
 * Instructor: Eivazi
 * Description: customer junit test
 * Due: 08/06/2023
 * Platform/compiler: eclipse
 * I pledge that I have completed the programming 
 * assignment independently. I have not copied the code 
 * from a student or any source. I have not given my code 
 * to any student.
   Print your Name here: __aidan buergin________
*/

public class CustomerTestStudent {
	
	Customer c1;
	Customer c2;
	Customer c3;
	Customer c4;

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		c1 = new Customer("john", 16);
		c2 = new Customer("sean", 18);
		c3 = new Customer("sean", 18);
		c4 = new Customer(c2);
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
		c1 = null;
		c2 = null;
		c3 = null;
	}

	@Test
	public void testConstructors() {
		assertTrue(c2.toString().equals(c3.toString()));
		assertTrue(c2.toString().equals(c4.toString()));
		assertFalse(c1.toString().equals(c4.toString()));
	}

}
