import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/*
 * Class: CMSC203 
 * Instructor: Eivazi
 * Description: coffee junit test
 * Due: 08/06/2023
 * Platform/compiler: eclipse
 * I pledge that I have completed the programming 
 * assignment independently. I have not copied the code 
 * from a student or any source. I have not given my code 
 * to any student.
   Print your Name here: __aidan buergin________
*/

public class CoffeeTestStudent {
	
	Coffee c1;
	Coffee c2;
	Coffee c3;

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		c1 = new Coffee("coffee", Size.MEDIUM, true, false);
		c2 = new Coffee("espresso", Size.SMALL, false, false);
		c3 = new Coffee("espresso", Size.SMALL, false, false);
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
		c1 = null;
		c2 = null;
	}

	@Test
	public void testConstructorWithEquals() {
		assertTrue(c2.equals(c3));
		assertFalse(c2.equals(c1));
	}
	
	@Test
	public void testCalcPrice() {
		assertEquals(3.5, c1.calcPrice(), .01);
	}

}
