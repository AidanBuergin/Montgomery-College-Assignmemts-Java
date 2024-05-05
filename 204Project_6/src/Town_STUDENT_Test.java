import static org.junit.Assert.*;
import java.util.*;
//Aidan Buergin

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class Town_STUDENT_Test {
	
	Town town1;
	Town town2;
	Town town3;

	@Before
	public void setUp() throws Exception {
		town1 = new Town("Town1");
		town2 = new Town("Town2");
		town3 = new Town("Town3");
	}

	@After
	public void tearDown() throws Exception {
		town1 = null;
		town2 = null;
		town3 = null;
	}

	//Only testing equals because the equals() method calls compareTo() and StringCompare()
	@Test
	public void testEquals() {
		Town town1Copy = new Town("Town1");
		assertTrue(town1Copy.equals(town1));
		assertFalse(town2.equals(town1));
	}
	
	@Test
	public void testGetName() {
		Town town1Copy = new Town("Town1");
		assertEquals(town1Copy.getName(), town1.getName());
	}
	
	@Test
	public void testGetAdjList() {
		ArrayList<Town> arr = new ArrayList<Town>();
		assertEquals(arr, town1.getAdjList());
	}
	
	@Test
	public void testToString() {
		assertEquals("Town1", town1.toString());
	}

}
