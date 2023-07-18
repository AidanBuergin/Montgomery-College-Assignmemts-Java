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

public class Property {
	
	private String propertyName;
	private String city;
	private double rentAmount;
	private String owner;
	private Plot plot;
	
	/**
	 * @summary constructor that sets strings to "".
	 */
	public Property() {
		this.propertyName = "";
		this.city = "";
		this.rentAmount = 0;
		this.owner = "";
		this.plot = new Plot();
	}

	/**
	 * @param propertyName
	 * @param city
	 * @param rentalAmount
	 * @param owner
	 */
	public Property(String propertyName, String city, double rentAmount, String owner) {
		this.propertyName = propertyName;
		this.city = city;
		this.rentAmount = rentAmount;
		this.owner = owner;
		this.plot = new Plot();
	}

	/**
	 * @param propertyName
	 * @param city
	 * @param rentalAmount
	 * @param owner
	 * @param x
	 * @param y
	 * @param width
	 * @param depth
	 */
	public Property(String propertyName, String city, double rentAmount, String owner, int x, int y, int width, int depth) {
		this.propertyName = propertyName;
		this.city = city;
		this.rentAmount = rentAmount;
		this.owner = owner;
		this.plot = new Plot(x, y, width, depth);
	}
	
	

	/**
	 * @param property
	 */
	public Property(Property property) {
		this.propertyName = property.propertyName;
		this.city = property.city;
		this.rentAmount = property.rentAmount;
		this.owner = property.owner;
		this.plot = new Plot();
	}

	/**
	 * @return the propertyName
	 */
	public String getPropertyName() {
		return propertyName;
	}

	/**
	 * @param propertyName the propertyName to set
	 */
	public void setPropertyName(String propertyName) {
		this.propertyName = propertyName;
	}

	/**
	 * @return the city
	 */
	public String getCity() {
		return city;
	}

	/**
	 * @param city the city to set
	 */
	public void setCity(String city) {
		this.city = city;
	}

	/**
	 * @return the rentalAmount
	 */
	public double getRentAmount() {
		return rentAmount;
	}

	/**
	 * @param rentalAmount the rentalAmount to set
	 */
	public void setRentAmount(double rentAmount) {
		this.rentAmount = rentAmount;
	}

	/**
	 * @return the owner
	 */
	public String getOwner() {
		return owner;
	}

	/**
	 * @param owner the owner to set
	 */
	public void setOwner(String owner) {
		this.owner = owner;
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
	 * @summary returns a string of all fields for the property.
	 */

	@Override
	public String toString() {
		return propertyName + "," + city + "," + owner + "," + rentAmount;
	}
	
	//Author: Aidan Buergin
}
