//Aidan Buergin
public class Road implements Comparable<Road> {
	
	private Town source;
	private Town dest;
	private int weight = 1;
	private String name;
	
	public Road(Town source, Town destination, int degrees, String name) {
		this.source = source;
		dest = destination;
		weight = degrees;
		this.name = name;
	}
	
	public Road(Town source, Town destination, String name) {
		this.source = source;
		dest = destination;
		this.name = name;
	}
	
	/**
	 * @summary uses Town's equals method to compare arg with this road's source and dest towns.
	 * @param town
	 * @return true if town is either source or dest of this road
	 */
	public boolean contains(Town town) {
		//null arg check
		if(town == null) {
			return false;}
		
		if(town.equals(source)) {
			return true;
		} 
		if(town.equals(dest)) {
			return true;
		} 
		
		return false;
	}
	
	@Override
	public String toString() {
		return(name);
	}
	
	@Override
	public int compareTo(Road o){
		return Town.stringCompare(this.getName(), o.getName());
	}
	
	@Override
	public boolean equals(Object r) {
		Road road = (Road) r;
		
		if(this.getSource().equals(road.getSource())) {
			if(this.getDest().equals(road.getDest())) {
				return true;
			}
		}
		
		if(this.getSource().equals(road.getDest())) {
			if(this.getDest().equals(road.getSource())) {
				return true;
			}
		}
		
		return false;
	}

	/**
	 * @return the source
	 */
	public Town getSource() {
		return source;
	}

	/**
	 * @param source the source to set
	 */
	public void setSource(Town source) {
		this.source = source;
	}

	/**
	 * @return the dest
	 */
	public Town getDest() {
		return dest;
	}

	/**
	 * @param dest the dest to set
	 */
	public void setDest(Town dest) {
		this.dest = dest;
	}

	/**
	 * @return the weight
	 */
	public int getWeight() {
		return weight;
	}

	/**
	 * @param weight the weight to set
	 */
	public void setWeight(int weight) {
		this.weight = weight;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
}
