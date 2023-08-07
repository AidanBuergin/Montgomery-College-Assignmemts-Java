/*
 * Class: CMSC203 
 * Instructor: Eivazi
 * Description: Type enum junit test
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


public class TypeTestStudent {

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() {
		assertEquals(Type.ALCOHOL, Type.valueOf("ALCOHOL"));
		assertEquals(Type.SMOOTHIE, Type.valueOf("SMOOTHIE"));
		assertEquals(Type.COFFEE, Type.valueOf("COFFEE"));
	}

}
