import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
/*
 * Class: CMSC203 
 * Instructor: Eivazi
 * Description: smoothie junit test
 * Due: 08/06/2023
 * Platform/compiler: eclipse
 * I pledge that I have completed the programming 
 * assignment independently. I have not copied the code 
 * from a student or any source. I have not given my code 
 * to any student.
   Print your Name here: __aidan buergin________
*/

public class SmoothieTestStudent {
	
	Smoothie c1;
	Smoothie c2;
	Smoothie c3;

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		c1 = new Smoothie("smoothie", Size.MEDIUM, 3, false);
		c2 = new Smoothie("smo", Size.SMALL, 2, false);
		c3 = new Smoothie("smo", Size.SMALL, 2, false);
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
		assertEquals(4.5, c1.calcPrice(), .01);
	}

}
