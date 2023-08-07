/*
 * Class: CMSC203 
 * Instructor: Eivazi
 * Description: alcohol class
 * Due: 08/06/2023
 * Platform/compiler: eclipse
 * I pledge that I have completed the programming 
 * assignment independently. I have not copied the code 
 * from a student or any source. I have not given my code 
 * to any student.
   Print your Name here: __aidan buergin________
*/
public class Alcohol extends Beverage{
	
	boolean isOfferedWeekend;
	public final double WEEKEND = .6;

	public Alcohol(String n, Size s, boolean iW) {
		super(n, Type.ALCOHOL, s);
		isOfferedWeekend = iW;
	}

	/**
	 * @return the isWeekend
	 */
	public boolean isWeekend() {
		return isOfferedWeekend;
	}

	/**
	 * @param isWeekend the isWeekend to set
	 */
	public void setWeekend(boolean isWeekend) {
		this.isOfferedWeekend = isWeekend;
	}

	@Override
	public boolean equals(Object obj) {
		
		Alcohol c = (Alcohol) obj;
		
		if(super.equals(obj) == true) {
			if(this.isOfferedWeekend == c.isOfferedWeekend) {
				return true;
			}
		} 
		
		return false;
	}

	@Override
	public String toString() {
		return "name: " + super.getBevName() + ", size: " + super.getSize() + ", offered in weekend: " + isOfferedWeekend + ", Price: " + calcPrice();
	}

	@Override
	public double calcPrice() {
		
		double price = addSizePrice();
		
		if(isOfferedWeekend == true) {
			price += WEEKEND;
		}

		return price;
	}
}
