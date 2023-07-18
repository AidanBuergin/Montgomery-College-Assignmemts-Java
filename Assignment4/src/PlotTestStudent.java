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

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class PlotTestStudent {
	
	Plot plot1;
	Plot plot2p;
	Plot plot3;
	Plot plot4far;
	Plot plot5;
	Plot plot2;

	/**
	 * @throws java.lang.Exception
	 */
	@BeforeEach
	public void setUp() throws Exception {
		plot1 = new Plot(2, 2, 4, 4);
		plot2p = new Plot(3, 4, 4, 4);
		plot2 = new Plot(plot2p);
		plot3 = new Plot(0, 6, 4, 4);
		plot4far = new Plot(9, 9, 2, 2);
		plot5 = new Plot();
		plot5.setX(3);
		plot5.setY(2);
	}

	/**
	 * @throws java.lang.Exception
	 */
	
	@AfterEach
	public void tearDown() throws Exception {
		plot1=null;
		plot2=null;
		plot3=null;
		plot4far=null;
	}
	
	/**
	 * @summary tests the overlaps method in plot.
	 */

	@Test
	public void testOverlaps() {
		assertTrue(plot1.overlaps(plot2));
		assertTrue(plot2.overlaps(plot3));
		assertFalse(plot1.overlaps(plot3));
		assertFalse(plot4far.overlaps(plot3));
	}
	
	/**
	 * @summary tests the encompasses method in plot.
	 */
	
	@Test
	public void testEncompasses() {
		assertTrue(plot1.encompasses(plot5));
		assertFalse(plot1.encompasses(plot4far));
	}
	
	@Test
	public void testToString() {
		assertEquals(plot1.toString(), "2,2,4,4");
	}
	
	@Test
	public void testGetX() {
		assertEquals(plot1.getX(), 2);
	}
	
	@Test
	public void testGetY() {
		assertEquals(plot1.getY(), 2);
	}
	
	@Test
	public void testGetWidth() {
		assertEquals(plot1.getWidth(), 4);
	}
	
	@Test
	public void testGetDepth() {
		assertEquals(plot1.getDepth(), 4);
	}

	
	//Author: Aidan Buergin

}
