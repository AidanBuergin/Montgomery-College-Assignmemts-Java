import java.util.*;
//Aidan Buergin
public class Graph implements GraphInterface<Town, Road>{
	
	private Set<Town> vSet = new HashSet<Town>();
	private Set<Road> rSet = new HashSet<Road>();
	private HashMap<Town, Integer> dijkMap = new HashMap<Town, Integer>();
	private HashMap<Town, Town> pathMap = new HashMap<Town, Town>();
	
	//empty constructor
	public Graph(){}
	
    /**
     * Returns an edge connecting source vertex to target vertex if such
     * vertices and such edge exist in this graph. Otherwise returns
     * null. If any of the specified vertices is null
     * returns null
     *
     * In undirected graphs, the returned edge may have its source and target
     * vertices in the opposite order.
     *
     * @param sourceVertex source vertex of the edge.
     * @param destinationVertex target vertex of the edge.
     *
     * @return an edge connecting source vertex to target vertex.
     */

	@Override
	public Road getEdge(Town sourceVertex, Town destinationVertex) {
		
		if(sourceVertex == null || destinationVertex == null) {
			return null;
		}
		
		for(Road r : rSet) {
			if(r.contains(sourceVertex) && r.contains(destinationVertex)) {
				return r;
			}
		}
		
		return null;
	}
	
    /**
     * Creates a new edge in this graph, going from the source vertex to the
     * target vertex, and returns the created edge. 
     * 
     * The source and target vertices must already be contained in this
     * graph. If they are not found in graph IllegalArgumentException is
     * thrown.
     *
     *
     * @param sourceVertex source vertex of the edge.
     * @param destinationVertex target vertex of the edge.
     * @param weight weight of the edge
     * @param description description for edge
     *
     * @return The newly created edge if added to the graph, otherwise null.
     *
     * @throws IllegalArgumentException if source or target vertices are not
     * found in the graph.
     * @throws NullPointerException if any of the specified vertices is null.
     */

	@Override
	public Road addEdge(Town sourceVertex, Town destinationVertex, int weight, String description) throws IllegalArgumentException, NullPointerException {
		
		if(sourceVertex == null || destinationVertex == null) {
			throw new NullPointerException();
		}
		if(!vSet.contains(sourceVertex) || !vSet.contains(destinationVertex)) {
			throw new IllegalArgumentException();
		}
		
		Road road = new Road(sourceVertex, destinationVertex, weight, description);
		sourceVertex.getAdjList().add(destinationVertex);
		destinationVertex.getAdjList().add(sourceVertex);
		rSet.add(road);
		return road;
	}
	
    /**
     * Adds the specified vertex to this graph if not already present. More
     * formally, adds the specified vertex, v, to this graph if
     * this graph contains no vertex u such that
     * u.equals(v). If this graph already contains such vertex, the call
     * leaves this graph unchanged and returns false. In combination
     * with the restriction on constructors, this ensures that graphs never
     * contain duplicate vertices.
     *
     * @param v vertex to be added to this graph.
     *
     * @return true if this graph did not already contain the specified
     * vertex.
     *
     * @throws NullPointerException if the specified vertex is null.
     */

	@Override
	public boolean addVertex(Town v) {
		
		if(containsVertex(v)) {
			return false;
		}
		
		dijkMap.put(v, 999999999);
		vSet.add(v);
		return true;
	}
	
    /**
     * Returns true if and only if this graph contains an edge going
     * from the source vertex to the target vertex. In undirected graphs the
     * same result is obtained when source and target are inverted. If any of
     * the specified vertices does not exist in the graph, or if is
     * null, returns false.
     *
     * @param sourceVertex source vertex of the edge.
     * @param destinationVertex target vertex of the edge.
     *
     * @return true if this graph contains the specified edge.
     */

	@Override
	public boolean containsEdge(Town sourceVertex, Town destinationVertex) {

		if(sourceVertex == null || destinationVertex == null) {
			return false;
		}
		
		if(!containsVertex(sourceVertex) || !containsVertex(destinationVertex)) {
			return false;
		}
		
		if(sourceVertex.getAdjList().contains(destinationVertex) && destinationVertex.getAdjList().contains(sourceVertex)) {
			return true;
		}
		
		return false;
	}
	
    /**
     * Returns true if this graph contains the specified vertex. More
     * formally, returns true if and only if this graph contains a
     * vertex u such that u.equals(v). If the
     * specified vertex is null returns false.
     *
     * @param v vertex whose presence in this graph is to be tested.
     *
     * @return true if this graph contains the specified vertex.
     */

	@Override
	public boolean containsVertex(Town v) {
		
		if(v == null) {
			return false;
		}
		
		for(Town t : vSet) {
			if(t.equals(v)) {
				return true;
			}
		}
		
		return false;
	}
	
    /**
     * Returns a set of the edges contained in this graph. The set is backed by
     * the graph, so changes to the graph are reflected in the set. If the graph
     * is modified while an iteration over the set is in progress, the results
     * of the iteration are undefined.
     *
     *
     * @return a set of the edges contained in this graph.
     */

	@Override
	public Set<Road> edgeSet() {
		return rSet;
	}
	
    /**
     * Returns a set of all edges touching the specified vertex (also
     * referred to as adjacent vertices). If no edges are
     * touching the specified vertex returns an empty set.
     *
     * @param vertex the vertex for which a set of touching edges is to be
     * returned.
     *
     * @return a set of all edges touching the specified vertex.
     *
     * @throws IllegalArgumentException if vertex is not found in the graph.
     * @throws NullPointerException if vertex is null.
     */

	@Override
	public Set<Road> edgesOf(Town vertex) {

		Set<Road> roadSet = new HashSet<Road>();
		
		for(Road r : rSet) {
			if(r.contains(vertex)) {
				roadSet.add(r);
			}
		}
		
		return roadSet;
	}
	
    /**
     * Removes an edge going from source vertex to target vertex, if such
     * vertices and such edge exist in this graph. 
     * 
     * If weight >- 1 it must be checked
     * If description != null, it must be checked 
     * 
     * Returns the edge if removed
     * or null otherwise.
     *
     * @param sourceVertex source vertex of the edge.
     * @param destinationVertex target vertex of the edge.
     * @param weight weight of the edge
     * @param description description of the edge
     *
     * @return The removed edge, or null if no edge removed.
     */

	@Override
	public Road removeEdge(Town sourceVertex, Town destinationVertex, int weight, String description) {
		
		Road road = new Road(sourceVertex, destinationVertex, weight, description);
		
		if(weight < 1 || description == null) {
			for(Road r : rSet) {
				if(r.equals(road)) {
					road = r;
					road.getDest().getAdjList().remove(road.getSource());
					road.getSource().getAdjList().remove(road.getDest());
					break;
				}
			}
			rSet.remove(road);
			return road;
		}
		
		boolean bool = false;
		
		for(Road r : rSet) {
			if(r.equals(road)) {
				if(r.getWeight() == road.getWeight() && r.getName() == road.getName()) {
					road = r;
					road.getDest().getAdjList().remove(road.getSource());
					road.getSource().getAdjList().remove(road.getDest());
					bool = true;
					break;
				}
			}
		}
		
		if(bool == false) {
			return null;
		} else {
			rSet.remove(road);
			return road;
		}
	}
	
    /**
     * Removes the specified vertex from this graph including all its touching
     * edges if present. More formally, if the graph contains a vertex 
     * u such that u.equals(v), the call removes all edges
     * that touch u and then removes u itself. If no
     * such u is found, the call leaves the graph unchanged.
     * Returns true if the graph contained the specified vertex. (The
     * graph will not contain the specified vertex once the call returns).
     *
     * If the specified vertex is null returns false.
     *
     * @param v vertex to be removed from this graph, if present.
     *
     * @return true if the graph contained the specified vertex;
     * false otherwise.
     */

	@Override
	public boolean removeVertex(Town v) {
		
		if(v == null) {
			return false;
		}
		
		if(containsVertex(v)) {
			vSet.remove(v);
			
			for(Road r : edgesOf(v)) {
				rSet.remove(r);
			}
			
			return true;
		}
		
		return false;
	}
	
    /**
     * Returns a set of the vertices contained in this graph. The set is backed
     * by the graph, so changes to the graph are reflected in the set. If the
     * graph is modified while an iteration over the set is in progress, the
     * results of the iteration are undefined.
     *
     *
     * @return a set view of the vertices contained in this graph.
     */

	@Override
	public Set<Town> vertexSet() {
		return vSet;
	}
	
    /**
     * Find the shortest path from the sourceVertex to the destinationVertex
     * call the dijkstraShortestPath with the sourceVertex
     * @param sourceVertex starting vertex
     * @param destinationVertex ending vertex
     * @return An arraylist of Strings that describe the path from sourceVertex
     * to destinationVertex
     * They will be in the format: startVertex "via" Edge "to" endVertex weight
	 * As an example: if finding path from Vertex_1 to Vertex_10, the ArrayList<String>
	 * would be in the following format(this is a hypothetical solution):
	 * Vertex_1 via Edge_2 to Vertex_3 4 (first string in ArrayList)
	 * Vertex_3 via Edge_5 to Vertex_8 2 (second string in ArrayList)
	 * Vertex_8 via Edge_9 to Vertex_10 2 (third string in ArrayList)
     */   

	@Override
	public ArrayList<String> shortestPath(Town sourceVertex, Town destinationVertex) {
		
		ArrayList<String> arr = new ArrayList<String>();
		
		if(sourceVertex.getAdjList().size() < 1 || destinationVertex.getAdjList().size() < 1) {
			return arr;
		}
		
		dijkstraShortestPath(sourceVertex);
		
		while(true) {
			
			Town tempVertex = pathMap.get(destinationVertex);
			
			arr.add(0, tempVertex.getName() + " via " + getEdge(tempVertex, destinationVertex).getName() + " to " + destinationVertex.getName() + " " + getEdge(tempVertex, destinationVertex).getWeight() + " mi");
			
			destinationVertex = tempVertex;
			
			if(destinationVertex.equals(sourceVertex)) {
				break;
			}
		}
		
		for(Town t : dijkMap.keySet()) {
			dijkMap.put(t, 999999999);
		}
		pathMap.clear();
		return arr;
	}
	
    /**
     * Dijkstra's Shortest Path Method.  Internal structures are built which
     * hold the ability to retrieve the path, shortest distance from the
     * sourceVertex to all the other vertices in the graph, etc.
     * @param sourceVertex the vertex to find shortest path from
     * 
     */

	@Override
	public void dijkstraShortestPath(Town sourceVertex) {
		
		Set<Town> unvisited = new HashSet<Town>(vSet);
		Set<Town> visited = new HashSet<Town>();
		
		dijkMap.put(sourceVertex, 0);
		
		while(!unvisited.isEmpty()) {
		
			for(Road r : edgesOf(sourceVertex)) {
			
				Town roadDest = r.getDest();
				Town roadSource = r.getSource();
			
				if(!roadDest.equals(sourceVertex) && unvisited.contains(roadDest)) {
					
					int totalDist = r.getWeight() + dijkMap.get(sourceVertex);
					
					if(totalDist < dijkMap.get(roadDest)) {
						dijkMap.put(roadDest, totalDist);
						pathMap.put(roadDest, sourceVertex);
					}	
				}
			 
				else if(!roadSource.equals(sourceVertex) && unvisited.contains(roadSource)) {
					
					int totalDist = r.getWeight() + dijkMap.get(sourceVertex);
					
					if(totalDist < dijkMap.get(roadSource)) {
						dijkMap.put(roadSource, totalDist);
						pathMap.put(roadSource, sourceVertex);
					}
				}
			}
			
			visited.add(sourceVertex);
			unvisited.remove(sourceVertex);
			
			if(unvisited.isEmpty()) {
				break;
			}
			
			Integer min = 999999999;
			Town nextSource = null;
			for(Town t : unvisited) {
				if(dijkMap.get(t) < min) {
					min = dijkMap.get(t);
					nextSource = t;
				}
			}
			sourceVertex = nextSource;
		}
	}
	
	public Town getVertex(String name) {
		for(Town t : vSet) {
			if(t.getName().equals(name)) {
				return t;
			}
		}
		return null;
	}
}
