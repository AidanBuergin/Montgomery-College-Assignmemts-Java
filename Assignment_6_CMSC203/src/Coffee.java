/*
 * Class: CMSC203 
 * Instructor: Eivazi
 * Description: coffee class
 * Due: 08/06/2023
 * Platform/compiler: eclipse
 * I pledge that I have completed the programming 
 * assignment independently. I have not copied the code 
 * from a student or any source. I have not given my code 
 * to any student.
   Print your Name here: __aidan buergin________
*/
public class Coffee extends Beverage{
	
	boolean extraShot;
	boolean extraSyrup;
	
	public final double EXTRA = .5;
	
	public Coffee(String n, Size s, boolean esh, boolean esy) {
	
		super(n, Type.COFFEE, s);
		extraShot = esh;
		extraSyrup = esy;
		
	}

	/**
	 * @return the extraShot
	 */
	public boolean getExtraShot() {
		return extraShot;
	}

	/**
	 * @param extraShot the extraShot to set
	 */
	public void setExtraShot(boolean extraShot) {
		this.extraShot = extraShot;
	}

	/**
	 * @return the extraSyrup
	 */
	public boolean getExtraSyrup() {
		return extraSyrup;
	}

	/**
	 * @param extraSyrup the extraSyrup to set
	 */
	public void setExtraSyrup(boolean extraSyrup) {
		this.extraSyrup = extraSyrup;
	}

	@Override
	public boolean equals(Object obj) {
		
		Coffee c = (Coffee) obj;
		
		if(super.equals(obj) == true) {
			if(this.extraShot == c.extraShot && this.extraSyrup == c.extraSyrup) {
				return true;
			}
		} 
		
		return false;
	}

	@Override
	public String toString() {
		return "name: " + super.getBevName() + ", size: " + super.getSize() + ", extraShot: " + extraShot + ", extraSyrup: " + extraSyrup + ", Price: " + calcPrice();
	}

	@Override
	public double calcPrice() {
		
		double price = addSizePrice();
		if(extraShot == true) {
			price += EXTRA;
		}
		if(extraSyrup == true) {
			price += EXTRA;
		}
		return price;
	}
}
