import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class Road_STUDENT_Test {
	
	Road road1;
	Road road2;
	Town town1;
	Town town2;
	Town town3;

	@Before
	public void setUp() throws Exception {
		town1 = new Town("Town1");
		town2 = new Town("Town2");
		town3 = new Town("Town3");
		road1 = new Road(town1, town2, 5, "Road1");
		road2 = new Road(town2, town3, 7, "Road2");
	}

	@After
	public void tearDown() throws Exception {
		town1 = null;
		town2 = null;
		town3 = null;
		road1 = null;
		road2 = null;
	}

	@Test
	public void testContains() {
		assertTrue(road1.contains(town1));
		assertFalse(road1.contains(town3));
	}
	
	@Test
	public void testToString() {
		assertEquals(road1.toString(), "Road1");
	}
	
	@Test
	public void testEquals() {
		Road road1Copy = new Road(town1, town2, 5, "Road1");
		assertTrue(road1Copy.equals(road1));
		assertFalse(road1Copy.equals(road2));
	}
	
	@Test
	public void testGetSource() {
		assertEquals(road1.getSource(), town1);
	}
	
	@Test
	public void testGetDest() {
		assertEquals(road1.getDest(), town2);
	}
	
	@Test
	public void testGetWeight() {
		assertEquals(road1.getWeight(), 5);
	}
	
	@Test
	public void testGetName() {
		assertEquals(road1.getName(), "Road1");
	}

}
