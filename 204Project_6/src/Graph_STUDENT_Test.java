
//Aidan Buergin

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.Set;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;


public class Graph_STUDENT_Test {
	private Graph graphInstance;
	private Town[] townArr;

	@Before
	public void setUp() throws Exception {
		 graphInstance = new Graph();
		  townArr = new Town[7];
		  
		  for (int i = 1; i < 6; i++) {
			  townArr[i] = new Town("Town_" + i);
			  graphInstance.addVertex(townArr[i]);
		  }
		  
		  graphInstance.addEdge(townArr[1], townArr[2], 7, "Road_1");
		  graphInstance.addEdge(townArr[1], townArr[3], 6, "Road_2");
		  graphInstance.addEdge(townArr[1], townArr[5], 9, "Road_3");
		  graphInstance.addEdge(townArr[3], townArr[5], 12, "Road_4");
		  graphInstance.addEdge(townArr[3], townArr[4], 8, "Road_5");
	}

	@After
	public void tearDown() throws Exception {
		graphInstance = null;
	}

	@Test
	public void testGetEdge() {
		assertEquals(new Road(townArr[3], townArr[5],12, "Road_4"), graphInstance.getEdge(townArr[3], townArr[5]));
	}

	@Test
	public void testAddEdge() {
		assertEquals(false, graphInstance.containsEdge(townArr[3], townArr[2]));
		graphInstance.addEdge(townArr[3], townArr[2], 1, "Road_7");
		assertEquals(true, graphInstance.containsEdge(townArr[3], townArr[2]));
	}

	@Test
	public void testAddVertex() {
		Town newTown = new Town("Town_6");
		assertEquals(false, graphInstance.containsVertex(newTown));
		graphInstance.addVertex(newTown);
		assertEquals(true, graphInstance.containsVertex(newTown));
	}

	@Test
	public void testContainsEdge() {
		assertEquals(true, graphInstance.containsEdge(townArr[2], townArr[1]));
		assertEquals(false, graphInstance.containsEdge(townArr[1], townArr[4]));
	}

	@Test
	public void testContainsVertex() {
		assertEquals(true, graphInstance.containsVertex(new Town("Town_2")));
		assertEquals(false, graphInstance.containsVertex(new Town("Town_220")));
	}

	@Test
	public void testEdgeSet() {
		Set<Road> roads = graphInstance.edgeSet();
		ArrayList<String> roadArrayList = new ArrayList<String>();
		for(Road road : roads)
			roadArrayList.add(road.getName());
		Collections.sort(roadArrayList);
		assertEquals("Road_1", roadArrayList.get(0));
	}

	@Test
	public void testEdgesOf() {
		Set<Road> roads = graphInstance.edgesOf(townArr[2]);
		ArrayList<String> roadArrayList = new ArrayList<String>();
		for(Road road : roads)
			roadArrayList.add(road.getName());
		Collections.sort(roadArrayList);
		assertEquals("Road_1", roadArrayList.get(0));
	}
	
	@Test
	public void testRemoveEdge() {
		assertEquals(true, graphInstance.containsEdge(townArr[2], townArr[1]));
		graphInstance.removeEdge(townArr[2], townArr[1], 7, "Road_1");
		assertEquals(false, graphInstance.containsEdge(townArr[2], townArr[1]));
	}
	
	@Test
	public void testRemoveVertex() {
		assertEquals(true, graphInstance.containsVertex(townArr[2]));
		graphInstance.removeVertex(townArr[2]);
		assertEquals(false, graphInstance.containsVertex(townArr[2]));
	}

	@Test
	public void testVertexSet() {
		Set<Town> roads = graphInstance.vertexSet();
		assertEquals(true,roads.contains(townArr[1]));
	}

	 @Test
	  public void testTown_1ToTown_4() {
		  String beginTown = "Town_1", endTown = "Town_4";
		  Town beginIndex=null, endIndex=null;
		  Set<Town> towns = graphInstance.vertexSet();
		  Iterator<Town> iterator = towns.iterator();
		  while(iterator.hasNext())
		  {    	
			  Town town = iterator.next();
			  if(town.getName().equals(beginTown))
				  beginIndex = town;
			  if(town.getName().equals(endTown))
				  endIndex = town;		
		  }
		  if(beginIndex != null && endIndex != null)
		  {

			  ArrayList<String> path = graphInstance.shortestPath(beginIndex,endIndex);
			  assertNotNull(path);
			  assertTrue(path.size() > 0);
			  assertEquals("Town_1 via Road_2 to Town_3 6 mi",path.get(0).trim());
			  assertEquals("Town_3 via Road_5 to Town_4 8 mi",path.get(1).trim());
		  }
		  else
			  fail("Town names are not valid");

	  }
	  
	  
	  @Test
	  public void testTown_5ToTown_1() {
		  String beginTown = "Town_5", endTown = "Town_1";
		  Town beginIndex=null, endIndex=null;
		  Set<Town> towns = graphInstance.vertexSet();
		  Iterator<Town> iterator = towns.iterator();
		  while(iterator.hasNext())
		  {    	
			  Town town = iterator.next();
			  if(town.getName().equals(beginTown))
				  beginIndex = town;
			  if(town.getName().equals(endTown))
				  endIndex = town;		
		  }
		  if(beginIndex != null && endIndex != null)
		  {

			  ArrayList<String> path = graphInstance.shortestPath(beginIndex,endIndex);
			  assertNotNull(path);
			  assertTrue(path.size() > 0);
			  assertEquals("Town_5 via Road_3 to Town_1 9 mi",path.get(0).trim());
		  }
		  else
			  fail("Town names are not valid");

	  }
	  
	  @Test
	  public void testTown_4ToTown_2() {
		  String beginTown = "Town_4", endTown = "Town_2";
		  Town beginIndex=null, endIndex=null;
		  Set<Town> towns = graphInstance.vertexSet();
		  Iterator<Town> iterator = towns.iterator();
		  while(iterator.hasNext())
		  {    	
			  Town town = iterator.next();
			  if(town.getName().equals(beginTown))
				  beginIndex = town;
			  if(town.getName().equals(endTown))
				  endIndex = town;		
		  }
		  if(beginIndex != null && endIndex != null)
		  {

			  ArrayList<String> path = graphInstance.shortestPath(beginIndex,endIndex);
			  assertNotNull(path);
			  assertTrue(path.size() > 0);
			  assertEquals("Town_4 via Road_5 to Town_3 8 mi",path.get(0).trim());
			  assertEquals("Town_3 via Road_2 to Town_1 6 mi",path.get(1).trim());
			  assertEquals("Town_1 via Road_1 to Town_2 7 mi",path.get(2).trim());
		  }
		  else
			  fail("Town names are not valid");

	  }
}
