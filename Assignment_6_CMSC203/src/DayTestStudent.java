import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/*
 * Class: CMSC203 
 * Instructor: Eivazi
 * Description: Day enum test
 * Due: 08/06/2023
 * Platform/compiler: eclipse
 * I pledge that I have completed the programming 
 * assignment independently. I have not copied the code 
 * from a student or any source. I have not given my code 
 * to any student.
   Print your Name here: __aidan buergin________
*/
public class DayTestStudent {

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
		assertEquals(Day.FRIDAY, Day.valueOf("FRIDAY"));
		assertEquals(Day.SUNDAY, Day.valueOf("SUNDAY"));
		assertEquals(Day.SATURDAY, Day.valueOf("SATURDAY"));
		assertEquals(Day.MONDAY, Day.valueOf("MONDAY"));
		assertEquals(Day.TUESDAY, Day.valueOf("TUESDAY"));
		assertEquals(Day.WEDNESDAY, Day.valueOf("WEDNESDAY"));
		assertEquals(Day.THURSDAY, Day.valueOf("THURSDAY"));
	}

}
