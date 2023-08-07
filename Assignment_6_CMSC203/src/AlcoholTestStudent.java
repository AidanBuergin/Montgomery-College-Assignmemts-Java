/*
 * Class: CMSC203 
 * Instructor: Eivazi
 * Description: alc test
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


public class AlcoholTestStudent {
	
	Alcohol c1;
	Alcohol c2;
	Alcohol c3;

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		c1 = new Alcohol("alc", Size.MEDIUM, true);
		c2 = new Alcohol("vodka", Size.SMALL, false);
		c3 = new Alcohol("vodka", Size.SMALL, false);
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
		assertEquals(3.6, c1.calcPrice(), .01);
	}

}
