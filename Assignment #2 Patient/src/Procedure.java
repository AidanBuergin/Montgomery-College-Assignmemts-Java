/*
 * Class: CMSC203 
 * Instructor: Eivazi
 * Description: Procedure is where the blueprint for procedures are stored.
 * Due: 07/03/2023
 * Platform/compiler: Eclipse
 * I pledge that I have completed the programming 
 * assignment independently. I have not copied the code 
 * from a student or any source. I have not given my code 
 * to any student.
   Print your Name here: _Aidan Buergin_________
*/

public class Procedure {
	
	String name;
	String date;
	String pracName;
	double cost;
	
	

	/**
	 * @param name
	 * @param date
	 * @param pracName
	 * @param cost
	 */
	public Procedure(String name, String date, String pracName, double cost) {
		this.name = name;
		this.date = date;
		this.pracName = pracName;
		this.cost = cost;
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
	 * @return the date
	 */
	public String getDate() {
		return date;
	}

	/**
	 * @param date the date to set
	 */
	public void setDate(String date) {
		this.date = date;
	}

	/**
	 * @return the pracName
	 */
	public String getPracName() {
		return pracName;
	}

	/**
	 * @param pracName the pracName to set
	 */
	public void setPracName(String pracName) {
		this.pracName = pracName;
	}

	/**
	 * @return the cost
	 */
	public double getCost() {
		return cost;
	}

	/**
	 * @param cost the cost to set
	 */
	public void setCost(double cost) {
		this.cost = cost;
	}
	
	/**
	 * @description prints out procedure information
	 */

	@Override
	public String toString() {
		return "Procedure: " + name + "\nProcedure Date: " + date + "\nPractitioner: " + pracName + "\nProcedure Cost: " + cost + "\n";
	}
	
	

}
