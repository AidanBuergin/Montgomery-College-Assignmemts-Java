/*
 * Class: CMSC203 
 * Instructor: Eivazi
 * Description: Calculates the total bonuses for all departments
 * Due: 7/24/2023
 * Platform/compiler: Eclpise
 * I pledge that I have completed the programming 
 * assignment independently.
*  I have not copied the code 
 * from a student or any source. 
*  I have not given my code 
 * to any student.
 *  Print your Name here: _Aidan Buergin_________
*/


public class HolidayBonus {
	
	final static int HIGHEST = 5000;
	final static int OTHER = 2000;
	final static int LOWEST = 1000;
	
	public HolidayBonus() {
		
	}
	
	/**
	 * @summary calculates the total bonus money for each location.
	 * @param data
	 * @return a double[] that holds the total bonuses of every location separated.
	 */
	
	public static double[] calculateHolidayBonus(double[][] data) {
		
		int longestRow = 0;
		double[] fin = new double[data.length];
		
		for(int i = 0; i < data.length; i++) {
			if(longestRow < data[i].length) {
				longestRow = data[i].length;
			}
		}
		
		int loSalesIndex = 0;
		int hiSalesIndex = 0;
		
		for(int col = 0; col < longestRow; col++) {
			
			hiSalesIndex = TwoDimRaggedArrayUtility.getHighestInColumnIndex(data, col);
			loSalesIndex = TwoDimRaggedArrayUtility.getLowestInColumnIndex(data, col);
			
			for(int row = 0; row < data.length; row++) {
				
				if(data[row].length > col) {
					if(row == hiSalesIndex) {
						fin[row] += HIGHEST;
					}
					else if(data[row][col] < 0) {
						fin[row] += 0;
					}
					else if(row == loSalesIndex) {
						fin[row] += LOWEST;
					}
					else {
						fin[row] += OTHER;
					}	
				}
			}
		}
		
		return fin;
	}
	
	/**
	 * @summary finds the total of all bonuses awarded.
	 * @param data
	 * @return a double value representing the total.
	 */
	
	public static double calculateTotalHolidayBonus(double[][] data) {
		
		double[] locationTotals = calculateHolidayBonus(data);
		int total = 0;
		
		for(double d : locationTotals) {
			total += d;
		}
		return total;
	}

}
