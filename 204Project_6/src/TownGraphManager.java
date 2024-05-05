import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
import java.util.ArrayList;
import java.util.Collections;
//Aidan Buergin
public class TownGraphManager implements TownGraphManagerInterface{
	
	Graph graph = new Graph();

	/**
	 * Adds a road with 2 towns and a road name
	 * @param town1 name of town 1 (lastname, firstname)
	 * @param town2 name of town 2 (lastname, firstname)
	 * @param roadName name of road
	 * @return true if the road was added successfully
	 */
	public boolean addRoad(String town1, String town2, int weight, String roadName) {
		Town town11 = graph.getVertex(town1);
		Town town22 = graph.getVertex(town2);
		Road testRoad = new Road(town11, town22, weight, roadName);
		Road road = (graph.addEdge(town11, town22, weight, roadName));
		if(road.equals(testRoad)) {
			return true;
		} else {
			return false;
		}
	}
	
	/**
	 * Returns the name of the road that both towns are connected through
	 * @param town1 name of town 1 (lastname, firstname)
	 * @param town2 name of town 2 (lastname, firstname)
	 * @return name of road if town 1 and town2 are in the same road, returns null if not
	 */
	public String getRoad(String town1, String town2) {
		Town town11 = new Town(town1);
		Town town22 = new Town(town2);
		return graph.getEdge(town11, town22).getName();
	}
	
	/**
	 * Adds a town to the graph
	 * @param v the town's name  (lastname, firstname)
	 * @return true if the town was successfully added, false if not
	 */
	public boolean addTown(String v) {
		Town town = new Town(v);
		return (graph.addVertex(town));
	}
	
	/**
	 * Gets a town with a given name
	 * @param name the town's name 
	 * @return the Town specified by the name, or null if town does not exist
	 */
	public Town getTown(String name) {
		for(Town t : graph.vertexSet()) {
			if(t.getName().equals(name)) {
				return t;
			}
		}
		return null;
	}
	
	/**
	 * Determines if a town is already in the graph
	 * @param v the town's name 
	 * @return true if the town is in the graph, false if not
	 */
	public boolean containsTown(String v) {
		Town town = new Town(v);
		return graph.containsVertex(town);
	}
	
	/**
	 * Determines if a road is in the graph
	 * @param town1 name of town 1 (lastname, firstname)
	 * @param town2 name of town 2 (lastname, firstname)
	 * @return true if the road is in the graph, false if not
	 */
	public boolean containsRoadConnection(String town1, String town2) {
		Town town11 = graph.getVertex(town1);
		Town town22 = graph.getVertex(town2);
		return graph.containsEdge(town11, town22);
	}
	
	/**
	 * Creates an arraylist of all road titles in sorted order by road name
	 * @return an arraylist of all road titles in sorted order by road name
	 */
	public ArrayList<String> allRoads(){
		ArrayList<String> arr = new ArrayList<String>();
		for(Road r : graph.edgeSet()){
			arr.add(r.toString());
		}
		Collections.sort(arr);
		return arr;
	}
	
	/**
	 * Deletes a road from the graph
	 * @param town1 name of town 1 (lastname, firstname)
	 * @param town2 name of town 2 (lastname, firstname)
	 * @param roadName the road name
	 * @return true if the road was successfully deleted, false if not
	 */
	public boolean deleteRoadConnection(String town1, String town2, String road) {
		Town town11 = new Town(town1);
		Town town22 = new Town(town2);
		Road testRoad = new Road(town11, town22, 0, road);
		return testRoad.equals(graph.removeEdge(town11, town22, 0, road));
	}
	
	/**
	 * Deletes a town from the graph
	 * @param v name of town (lastname, firstname)
	 * @return true if the town was successfully deleted, false if not
	 */
	public boolean deleteTown(String v) {
		Town town = new Town(v);
		return graph.removeVertex(town);
	}

	/**
	 * Creates an arraylist of all towns in alphabetical order (last name, first name)
	 * @return an arraylist of all towns in alphabetical order (last name, first name)
	 */
	public ArrayList<String> allTowns() {
		ArrayList<String> arr = new ArrayList<String>();
		for(Town r : graph.vertexSet()){
			arr.add(r.toString());
		}
		Collections.sort(arr);
		return arr;
	}
	
	/**
	 * Returns the shortest path from town 1 to town 2
	 * @param town1 name of town 1 (lastname, firstname)
	 * @param town2 name of town 2 (lastname, firstname)
	 * @return an Arraylist of roads connecting the two towns together, null if the
	 * towns have no path to connect them.
	 */
	public ArrayList<String> getPath(String town1, String town2) {
		Town town11 = graph.getVertex(town1);
		Town town22 = graph.getVertex(town2);
		return graph.shortestPath(town11, town22);
	}
	
	public void populateTownGraph(File file) throws FileNotFoundException {
		
			Scanner sc = new Scanner(file);
			
			while(sc.hasNext()) {
				String s = sc.nextLine();
				
				String[] arr = s.split(",");
				String name = arr[0];
				
				arr = arr[1].split(";");
				
				int miles = Integer.parseInt(arr[0]);
				String town1 = arr[1];
				String town2 = arr[2];
				
				Town town11 = new Town(town1);
				Town town22 = new Town(town2);
				Road road = new Road(town11, town22, miles, name);
				
				graph.addVertex(town11);
				graph.addVertex(town22);
				System.out.println(graph.addEdge(graph.getVertex(town1), graph.getVertex(town2), miles, name));
			}
			
			sc.close();
	}

}
