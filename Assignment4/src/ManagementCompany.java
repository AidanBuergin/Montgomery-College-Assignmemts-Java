import java.util.Arrays;

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

public class ManagementCompany {
	
	private String name;
	private String taxID;
	private double mgmFee;
	
	static final int MAX_PROPERTY = 5;
	static final int MGMT_WIDTH = 10;
	static final int MGMT_DEPTH = 10;
	
	private Property[] properties;
	private Plot plot;
	private int numberOfProperties;
	
	/**
	 * @summary no arg constructor
	 */
	public ManagementCompany() {
		this.name = "";
		this.taxID = "";
		this.mgmFee = 0;
		this.properties = new Property[5];
		this.plot = new Plot(0, 0, MGMT_WIDTH, MGMT_DEPTH);
	}
	
	/**
	 * @summary constructor with three args that creates a default plot
	 * @param name
	 * @param taxID
	 * @param mgmFee
	 */
	public ManagementCompany(String name, String taxID, double mgmFee) {
		this.name = name;
		this.taxID = taxID;
		this.mgmFee = mgmFee;
		this.properties = new Property[5];
		this.plot = new Plot(0, 0, MGMT_WIDTH, MGMT_DEPTH);
	}
	
	/**
	 * @summary constructor with all parameters that creates a new company and plot with given arguments.
	 * @param name
	 * @param taxID
	 * @param mgmFee
	 * @param x
	 * @param y
	 * @param width
	 * @param depth
	 */
	public ManagementCompany(String name, String taxID, double mgmFee, int x, int y, int width, int depth) {
		this.name = name;
		this.taxID = taxID;
		this.mgmFee = mgmFee;
		this.properties = new Property[5];
		this.plot = new Plot(x, y, width, depth);
	}
	
	/**
	 * @summary constructor that copies another company from argument.
	 * @param mgmco (copied company)
	 */
	public ManagementCompany(ManagementCompany mgmco) {
		this.name = mgmco.name;
		this.taxID = mgmco.taxID;
		this.mgmFee = mgmco.mgmFee;
		this.properties = mgmco.properties;
		this.plot = mgmco.plot;
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

	/**
	 * @return the taxID
	 */
	public String getTaxID() {
		return taxID;
	}

	/**
	 * @param taxID the taxID to set
	 */
	public void setTaxID(String taxID) {
		this.taxID = taxID;
	}

	/**
	 * @return the mgmFee
	 */
	public double getMgmFeePer() {
		return mgmFee;
	}

	/**
	 * @param mgmFee the mgmFee to set
	 */
	public void setMgmFee(double mgmFee) {
		this.mgmFee = mgmFee;
	}

	/**
	 * @return the properties
	 */
	public Property[] getProperties() {
		return properties;
	}

	/**
	 * @param properties the properties to set
	 */
	public void setProperties(Property[] properties) {
		this.properties = properties;
	}

	/**
	 * @return the plot
	 */
	public Plot getPlot() {
		return plot;
	}

	/**
	 * @param plot the plot to set
	 */
	public void setPlot(Plot plot) {
		this.plot = plot;
	}
	
	/**
	 * 
	 * @param newProp
	 * @return whether the property was added or there was an error. If error, determines type of error.
	 */
	
	public int addProperty(Property newProp) {
		
		if(newProp == null) {
			return -2;
		}
		
		for(int i = 0; i < properties.length; i++) {
			if(properties[i] == null) {
				
				if(this.plot.encompasses(newProp.getPlot()) == false) {
					return -3;
				}
				for(Property p : properties) {
					
					if(!(p == null)) {
						if(newProp.getPlot().overlaps(p.getPlot())) {
							return -4;
						}
					}
				}
				
				properties[i] = newProp;
				return 0;
			}
		}
		
		return -1;
	}
	
	/**
	 * @summary creates a property instance with arguments and calls sibiling-method.
	 * @param name
	 * @param city
	 * @param rent
	 * @param owner
	 * @return same as first addProperty.
	 */
	
	public int addProperty(String name, String city, double rent, String owner) {
		
		Property newProp = new Property(name, city, rent, owner);
		
		return addProperty(newProp);
	}
	
	/**
	 * @summary creates a property instance with arguments and calls sibiling-method.
	 * @param name
	 * @param city
	 * @param rent
	 * @param owner
	 * @return same as first addProperty.
	 */
	
	public int addProperty(String name, String city, double rent, String owner, int x, int y, int width, int depth) {
		
		Property newProp = new Property(name, city, rent, owner, x, y, width, depth);
		
		return addProperty(newProp);
	}
	
	/**
	 * 
	 * @return the sum rent amount of all properties for this company.
	 */
	
	public double getTotalRent() {
		
		int total = 0;
		
		for(Property p : properties) {
			if(!(p == null)) {
				total += p.getRentAmount();
			}
		}
		
		return total;
	}
	
	/**
	 * 
	 * @return property with highest rent.
	 */
	
	public Property getHighestRentPropperty() {
		
		Property prop = new Property();
		
		for(Property p : properties) {
			if(!(p == null)) {
				if(p.getRentAmount() > prop.getRentAmount()) {
					prop = p;
				}
			}
		}
		
		return prop;
	}
	
	/**
	 * @summary removes the last property in the properties array.
	 */
	
	public void removeLastProperty() {
		
		for(int i = 0; i < properties.length; i++) {
			if(properties[i] == null) {
				properties[i-1] = null;
			}
		}
	}
	
	/**
	 * 
	 * @return whether or not company has all 5 properties
	 */
	
	public boolean isPropertiesFull() {
		
		for(Property p : properties) {
			if(p == null) {
				return false;
			}
		}
		
		return true;
	}
	
	/**
	 * @summary returns number of properties that a company has
	 * @return int
	 */
	
	public int getPropertiesCount() {
		
		numberOfProperties = 0;
		
		for(Property p : properties) {
			if(!(p == null)) {
				numberOfProperties++;
			}
		}
		
		return numberOfProperties;
	}
	
	/**
	 * @summary returns whether the mgmFee is within 0, 100 or not.
	 * @return boolean
	 */
	
	public boolean isManagementFeeValid() {
		
		if(this.mgmFee > 100 || this.mgmFee < 0) {
			return false;
		}
		
		return true;
	}
	
	/**
	 * @summary prints out the management company's info and each property.
	 */

	@Override
	public String toString() {
		
		String s = "List of the properties for " + name + ", taxID: " + taxID + "\n"
				+ "_____________________________________________\n";
		
		for(Property p : properties) {
			
			if(!(p == null)) {
			s += "Property Name: " + p.getPropertyName() + "\n";
			s += "Located in: " + p.getCity() + "\n";
			s += "Belongs to: " + p.getOwner() + "\n";
			s += "Rent Amount: " + p.getRentAmount() + "\n\n";
			}
		}
		
		s +=  "_____________________________________________" + "\n\n";
		s += "total management Fee: " + mgmFee;
		
		return s;
	}
	
	//Author: Aidan Buergin
	
}
