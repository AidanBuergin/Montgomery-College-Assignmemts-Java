import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/*
 * Class: CMSC203 
 * Instructor: Eivazi
 * Description: The plot of land that a property takes up.
 * Due: 7/17/2023
 * Platform/compiler: Eclipse
 * I pledge that I have completed the programming 
 * assignment independently. I have not copied the code 
 * from a student or any source. I have not given my code 
 * to any student.
   Print your Name here: _Aidan Buergin_________
*/

class PropertyTestStudent {
	Property prop1;
	Property prop2;
	Property prop3;
	Property prop4;

	/**
	 * @throws java.lang.Exception
	 */
	@BeforeEach
	void setUp() throws Exception {
		prop1 = new Property();
			prop1.setCity("Frederick");
			prop1.setOwner("me");
			prop1.setPropertyName("5532 America St");
			prop1.setRentAmount(2000.00);
			prop1.setPlot(new Plot(1,1,1,1));
			
		prop2 = new Property("775 Oakwood ln", "Rockville", 250.0, "dude");
		prop2.setPlot(new Plot(2,2,2,2));
		
		prop3 = new Property("335 Pine Ct", "Los Angeles", 2500.0, "person", 5,5,2,2);
		
		prop4 = new Property(prop3);
		
	}

	/**
	 * @throws java.lang.Exception
	 */
	@AfterEach
	void tearDown() throws Exception {
		prop1 = null;
		prop2 = null;
		prop3 = null;
		prop4 = null;
	}
	
	/**
	 *@summary test the toString method and all constructors.
	 */

	@Test
	void testToString() {
		assertEquals("5532 America St,Frederick,me,2000.0", prop1.toString());
		assertEquals("775 Oakwood ln,Rockville,dude,250.0", prop2.toString());
		assertEquals("335 Pine Ct,Los Angeles,person,2500.0", prop3.toString());
		assertEquals("335 Pine Ct,Los Angeles,person,2500.0", prop4.toString());
	}
	
	@Test
	void testgetPropertyName() {
		assertEquals(prop1.getPropertyName(), "5532 America St");
	}
	
	@Test
	void testGetCity() {
		assertEquals(prop1.getCity(), "Frederick");
	}
	
	@Test
	void testGetRentAmount() {
		assertEquals(prop1.getRentAmount(), 2000.0);
	}
	
	@Test
	void testGetOwner() {
		assertEquals(prop1.getOwner(), "me");
	}
	
	@Test
	void testGetPlot() {
		assertEquals(prop1.getPlot().toString(), "1,1,1,1");
	}
	
	//Author: Aidan Buergin

}
