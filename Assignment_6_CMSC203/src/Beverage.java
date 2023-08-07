/*
 * Class: CMSC203 
 * Instructor: Eivazi
 * Description: abstract beverage
 * Due: 08/06/2023
 * Platform/compiler: eclipse
 * I pledge that I have completed the programming 
 * assignment independently. I have not copied the code 
 * from a student or any source. I have not given my code 
 * to any student.
   Print your Name here: __aidan buergin________
*/
public abstract class Beverage {

	private String bevName;
	private Type type;
	private Size size;
	
	public static final double BASEPRICE = 2.0;
	public static final double SIZEPRICE = 1.0;
	
	public Beverage(String n, Type t, Size s) {
		bevName = n;
		type = t;
		size = s;
	}
	

	/**
	 * @return the bevName
	 */
	public String getBevName() {
		return bevName;
	}



	/**
	 * @param bevName the bevName to set
	 */
	public void setBevName(String bevName) {
		this.bevName = bevName;
	}



	/**
	 * @return the type
	 */
	public Type getType() {
		return type;
	}



	/**
	 * @param type the type to set
	 */
	public void setType(Type type) {
		this.type = type;
	}



	/**
	 * @return the size
	 */
	public Size getSize() {
		return size;
	}



	/**
	 * @param size the size to set
	 */
	public void setSize(Size size) {
		this.size = size;
	}



	/**
	 * @return the baseprice
	 */
	public static double getBasePrice() {
		return BASEPRICE;
	}

	/**
	 * @return the sizeprice
	 */
	public static double getSizePrice() {
		return SIZEPRICE;
	}


	public abstract double calcPrice();
	
	
	
	@Override
	public boolean equals(Object obj) {
		
		Beverage bev = (Beverage) obj;
		
		if(this.bevName.equals(bev.bevName) && this.size.equals(bev.size) && this.type.equals(bev.type)) {
			return true;
		} else {
		return false;
		}
	}

	@Override
	public String toString() {
		String s = bevName + ", " + type  + ", " + size;
		return s;
	}
	
	public double addSizePrice() {
		
		if(size.equals(Size.SMALL)) {
			return BASEPRICE;
		} 
		else if(size.equals(Size.MEDIUM)) {
			return BASEPRICE + SIZEPRICE;
		}
		else if(size.equals(Size.LARGE)) {
			return BASEPRICE + (SIZEPRICE * 2);
		} else {
			return -1;
		}
	}
}
