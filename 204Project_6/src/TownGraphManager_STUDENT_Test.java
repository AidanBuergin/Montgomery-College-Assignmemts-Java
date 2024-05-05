import static org.junit.Assert.*;
//Aidan Buergin
import java.util.ArrayList;
import java.io.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class TownGraphManager_STUDENT_Test {
	
	private TownGraphManager graphInstance;
	private String[] towns;

	@Before
	public void setUp() throws Exception {
		  graphInstance = new TownGraphManager();
		  towns = new String[12];
		  
		  for (int i = 1; i < 12; i++) {
			  towns[i] = "City_" + i;
			  graphInstance.addTown(towns[i]);
		  }
		  graphInstance.addRoad(towns[1], towns[2], 12, "Path_#1");
		  graphInstance.addRoad(towns[1], towns[3], 44, "Path_#2");
		  graphInstance.addRoad(towns[1], towns[5], 26, "Path_#3");
		  graphInstance.addRoad(towns[3], towns[7], 21, "Path_#4");
		  graphInstance.addRoad(towns[3], towns[8], 24, "Path_#5");
		  graphInstance.addRoad(towns[4], towns[8], 32, "Path_#6");
		  graphInstance.addRoad(towns[6], towns[9], 13, "Path_#7");
		  graphInstance.addRoad(towns[9], towns[10], 47, "Path_#8");
		  graphInstance.addRoad(towns[8], towns[10], 72, "Path_#9");
		  graphInstance.addRoad(towns[5], towns[10], 75, "Path_#10");
		  graphInstance.addRoad(towns[10], towns[11], 53, "Path_#11");
		  graphInstance.addRoad(towns[2], towns[11], 66, "Path_#12");
		 
	}

	@After
	public void tearDown() throws Exception {
		graphInstance = null;
	}

	@Test
	public void testAddRoad() {
		ArrayList<String> roads = graphInstance.allRoads();
		assertEquals("Path_#1", roads.get(0));
		assertEquals("Path_#10", roads.get(1));
		assertEquals("Path_#11", roads.get(2));
		assertEquals("Path_#12", roads.get(3));
		graphInstance.addRoad(towns[4], towns[11], 1,"Path_#13");
		roads = graphInstance.allRoads();
		assertEquals("Path_#1", roads.get(0));
		assertEquals("Path_#10", roads.get(1));
		assertEquals("Path_#11", roads.get(2));
		assertEquals("Path_#12", roads.get(3));
		assertEquals("Path_#13", roads.get(4));
		
	}

	@Test
	public void testGetRoad() {
		assertEquals("Path_#3", graphInstance.getRoad(towns[1], towns[5]));
		assertEquals("Path_#4", graphInstance.getRoad(towns[3], towns[7]));
	}

	@Test
	public void testAddTown() {
		assertEquals(false, graphInstance.containsTown("City_12"));
		graphInstance.addTown("City_12");
		assertEquals(true, graphInstance.containsTown("City_12"));
		assertEquals(false, graphInstance.containsTown("City_20"));
		graphInstance.addTown("City_20");
		assertEquals(true, graphInstance.containsTown("City_20"));
	}
	
	@Test
	public void testDisjointGraph() {
		assertEquals(false, graphInstance.containsTown("City_14"));
		graphInstance.addTown("City_14");
		ArrayList<String> path = graphInstance.getPath(towns[1],"City_14");
		assertFalse(path.size() > 0);
		ArrayList<String> path1 = graphInstance.getPath("City_14",towns[1]);
		assertFalse(path1.size() > 0);
	}

	@Test
	public void testContainsTown() {
		assertEquals(true, graphInstance.containsTown("City_7"));
		assertEquals(false, graphInstance.containsTown("City_22"));
	}

	@Test
	public void testContainsRoadConnection() {
		assertEquals(true, graphInstance.containsRoadConnection(towns[8], towns[10]));
		assertEquals(false, graphInstance.containsRoadConnection(towns[3], towns[4]));
	}

	@Test
	public void testAllRoads() {
		ArrayList<String> roads = graphInstance.allRoads();
		assertEquals("Path_#1", roads.get(0));
		assertEquals("Path_#10", roads.get(1));
		assertEquals("Path_#11", roads.get(2));
		assertEquals("Path_#2", roads.get(4));
		assertEquals("Path_#4", roads.get(6));
		assertEquals("Path_#10", roads.get(1));
	}

	@Test
	public void testDeleteRoadConnection() {
		assertEquals(true, graphInstance.containsRoadConnection(towns[10], towns[11]));
		graphInstance.deleteRoadConnection(towns[10], towns[11], "Path_#11");
		assertEquals(false, graphInstance.containsRoadConnection(towns[10], towns[11]));
		assertEquals(true, graphInstance.containsRoadConnection(towns[2], towns[11]));
		graphInstance.deleteRoadConnection(towns[2], towns[11], "Path_#12");
		assertEquals(false, graphInstance.containsRoadConnection(towns[2], towns[11]));
	}

	@Test
	public void testDeleteTown() {
		assertEquals(true, graphInstance.containsTown("City_2"));
		graphInstance.deleteTown(towns[2]);
		assertEquals(false, graphInstance.containsTown("City_2"));
	}
	
	@Test
	public void testAllTowns() {
		ArrayList<String> roads = graphInstance.allTowns();
		assertEquals("City_1", roads.get(0));
		assertEquals("City_10", roads.get(1));
		assertEquals("City_2", roads.get(3));
		assertEquals("City_9", roads.get(10));
	}

	@Test
	public void testGetPath() {
		ArrayList<String> path = graphInstance.getPath(towns[1],towns[11]);
		  assertNotNull(path);
		  assertTrue(path.size() > 0);
		  assertEquals("City_1 via Path_#1 to City_2 12 mi",path.get(0).trim());
		  assertEquals("City_2 via Path_#12 to City_11 66 mi",path.get(1).trim());

	}
	
	@Test
	public void testGetPathPart_A() {
		ArrayList<String> path = graphInstance.getPath(towns[1],towns[10]);
		  assertNotNull(path);
		  assertTrue(path.size() > 0);
		  assertEquals("City_1 via Path_#3 to City_5 26 mi",path.get(0).trim());
		  assertEquals("City_5 via Path_#10 to City_10 75 mi",path.get(1).trim());
	}
	
	@Test
	public void testGetPathPart_B() {
		ArrayList<String> path = graphInstance.getPath(towns[1],towns[6]);
		  assertNotNull(path);
		  assertTrue(path.size() > 0);
		  assertEquals("City_1 via Path_#3 to City_5 26 mi",path.get(0).trim());
		  assertEquals("City_5 via Path_#10 to City_10 75 mi",path.get(1).trim());
		  assertEquals("City_10 via Path_#8 to City_9 47 mi",path.get(2).trim());
		  assertEquals("City_9 via Path_#7 to City_6 13 mi",path.get(3).trim());
	}
	
	@Test
	public void testPopulateWithFile() throws FileNotFoundException {
		
		File file = new File("MD Towns.txt");
		graphInstance.populateTownGraph(file);
		assertTrue(graphInstance.containsTown("Boyds"));
		assertTrue(graphInstance.containsTown("Darnestown"));
		assertTrue(graphInstance.containsTown("Potomac"));
		assertTrue(graphInstance.containsRoadConnection("Frederick", "Clarksburg"));
		assertTrue(graphInstance.containsRoadConnection("Darnestown", "Potomac"));
	}


}
