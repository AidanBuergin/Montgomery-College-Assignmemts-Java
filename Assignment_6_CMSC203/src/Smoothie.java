/*
 * Class: CMSC203 
 * Instructor: Eivazi
 * Description: smoothie class
 * Due: 08/06/2023
 * Platform/compiler: eclipse
 * I pledge that I have completed the programming 
 * assignment independently. I have not copied the code 
 * from a student or any source. I have not given my code 
 * to any student.
   Print your Name here: __aidan buergin________
*/
public class Smoothie extends Beverage{
	
	int numOfFruits;
	boolean addProtein;
	
	public final double PROTEIN = 1.5;
	public final double FRUIT = .5;
	
	public Smoothie(String n, Size s, int fNum, boolean addP) {
		super(n, Type.SMOOTHIE, s);
		numOfFruits = fNum;
		addProtein = addP;
	}

	/**
	 * @return the numOfFruits
	 */
	public int getNumOfFruits() {
		return numOfFruits;
	}

	/**
	 * @param numOfFruits the numOfFruits to set
	 */
	public void setNumOfFruits(int numOfFruits) {
		this.numOfFruits = numOfFruits;
	}

	/**
	 * @return the addProtein
	 */
	public boolean isAddProtein() {
		return addProtein;
	}

	/**
	 * @param addProtein the addProtein to set
	 */
	public void setAddProtein(boolean addProtein) {
		this.addProtein = addProtein;
	}
	
	@Override
	public boolean equals(Object obj) {
		
		Smoothie c = (Smoothie) obj;
		
		if(super.equals(obj) == true) {
			if(this.numOfFruits == c.numOfFruits && this.addProtein == c.addProtein) {
				return true;
			}
		} 
		
		return false;
	}

	@Override
	public String toString() {
		return "name: " + super.getBevName() + ", size: " + super.getSize() + ", number of fruits: " + numOfFruits + ", extra protein: " + addProtein + ", Price: " + calcPrice();
	}

	@Override
	public double calcPrice() {
		
		double price = addSizePrice();
		
		price += (.5 * numOfFruits);
		if(addProtein == true) {
			price += PROTEIN;
		}

		return price;
	}
	
	

}
