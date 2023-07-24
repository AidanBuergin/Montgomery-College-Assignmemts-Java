import java.io.*;
import java.io.FileNotFoundException;
import java.util.*;

/*
 * Class: CMSC203 
 * Instructor: Eivazi
 * Description: provides methods for functionality of the App and HolidayBonus class.
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


public final class TwoDimRaggedArrayUtility {
	
	final static int MAX_ROW = 10;
	final static int MAX_COLUMN = 10;
	
	public TwoDimRaggedArrayUtility() {
		
	}
	
	/**
	 * @summary reads a file and creates a ragged array with the data.
	 * @param file
	 * @return double[][] data, the ragged array of data.
	 * @throws FileNotFoundException
	 */
	
	public static double[][] readFile(File file) throws FileNotFoundException {
		
		Scanner sc = new Scanner(file);
		int i = 0;
		double[][] temp = new double[MAX_ROW][MAX_COLUMN];
		String nums = "";
		int l = 0;
		String s = "";
		
		while(sc.hasNext()) { //each row

			s = sc.nextLine();
			
			if(!(s.isBlank())) {
				for(int k = 0; k < MAX_COLUMN; k++) { //each column
					
					//this loop sorts through each character in each row of the file, and 
					//finds all string numbers in the row by stopping the loop when a space in encountered.
					//Every string number is added to their same row in temp, but now as a real double.
					
					for(int doesntMatter = 0; l < s.length() && !(s.charAt(l) == ' '); l++) { // each character
						
						nums += s.charAt(l);
					}
					
					if(!(nums.isBlank())) {
						
						temp[i][k] = Double.valueOf(nums);
					}
					l++;
					nums = "";
				}
				l = 0;
			}
			i++;
		}
		
		//both rowcounter and colcounter loops essentially just find the actual number of
		//rows and columns with real vaules, so that the final double[][] to be returned has no empty rows
		//or columns with no values in any row.
		
		int rowcounter =0;
		
		for(double[] d : temp) {
			if(!(d[0] == 0.0)) {
				rowcounter++;
			}
		}
		
		sc.close();
		
		//creates the final double[][] of the correct dimensions and copies all values from temp to the final array (fin).
		
		double[][] fin = new double[rowcounter][];
		
		int colcount =0;
		
		for(int j = 0; j < rowcounter; j++) {
			for(int e = 0; e < MAX_COLUMN; e++) {
				if(!(temp[j][e] == 0.0)) {
					colcount++;
				}
			}
			double[] arr = new double[colcount];
			for(int e = 0; e < colcount; e++) {
				arr[e] = temp[j][e];
			}
			fin[j] = arr;
			colcount = 0;
		}
		
		return fin;
	}
	
	/**
	 * @summary writes all the data from a double[][] to a .txt file.
	 * @param data
	 * @param outputFile
	 * @throws FileNotFoundException
	 */
	
	public static void writeToFile(double[][] data, File outputFile) throws FileNotFoundException {
		
		PrintWriter pw = new PrintWriter(outputFile);
		for(int i = 0; i < data.length; i++) {
			for(int j = 0; j < data[i].length; j++) {
				pw.print(data[i][j] + " ");
			}
			pw.print("\n");
		}
		
		pw.close();
	}
	
	/**
	 * @summary returns the total of every sales department in every location combined
	 * @param data
	 * @return total of all location's sales
	 */
	
	public static double getTotal(double[][] data) {
		
		double total = 0;
		
		for(int i = 0; i < data.length; i++) {
			for(int j = 0; j < data[i].length; j++) {
				total += data[i][j];
			}
		}
		
		return total;
	}
	
	/**
	 * @summary finds the average sales figure of all departments and locations.
	 * @param data
	 * @return double: the average.
	 */
	
	public static double getAverage(double[][] data) {
		
		double total = 0;
		double numOfVals = 0;
		
		for(int i = 0; i < data.length; i++) {
			for(int j = 0; j < data[i].length; j++) {
				total += data[i][j];
				numOfVals++;
			}
		}
		
		return total/numOfVals;
	}
	
	/**
	 * @summary gets the total sales from a row
	 * @param data
	 * @param row
	 * @return total sales of the row
	 */
	
	public static double getRowTotal(double[][] data, int row) {
		
		double total = 0;
		
		for(int i = 0; i < data[row].length; i++) {
			total += data[row][i];
		}
		
		return total;
	}
	
	/**
	 * @summary gets total sales of a column
	 * @param data
	 * @param col
	 * @return total sales in column
	 */
	
	public static double getColumnTotal(double[][] data, int col) {
		
		double total = 0;
		
		for(int i = 0; i < data.length; i++) {
			if(data[i].length > col) {
			total += data[i][col];
			}
		}
		
		return total;
	}
	
	/**
	 * @summary finds highest value in a row
	 * @param data
	 * @param row
	 * @return highest value in row
	 */
	
	public static double getHighestInRow(double[][] data, int row) {
		
		double highest = 0;
		
		for(int i = 0; i < data[row].length; i++) {
			if(data[row][i] > highest) {
				highest = data[row][i];
			}
		}
		
		return highest;
	}
	
	/**
	 * @summary finds index of highest value in a row
	 * @param data
	 * @param row
	 * @return index
	 */
	
	public static int getHighestInRowIndex(double[][] data, int row) {
		
		double highest = 0;
		int index = 0;
		
		for(int i = 0; i < data[row].length; i++) {
			if(data[row][i] > highest) {
				highest = data[row][i];
				index = i;
			}
		}
		
		return index;
	}
	
	/**
	 * @summary finds lowest value in a row
	 * @param data
	 * @param row
	 * @return lowest sale
	 */
	
	public static double getLowestInRow(double[][] data, int row) {
		
		double lowest = data[row][0];
		
		for(int i = 0; i < data[row].length; i++) {
			if(data[row][i] < lowest) {
				lowest = data[row][i];
			}
		}
		
		return lowest;
	}
	
	/**
	 * @summary gets index of the lowest sales in the row
	 * @param data
	 * @param row
	 * @return index
	 */
	
	public static int getLowestInRowIndex(double[][] data, int row) {
		
		double lowest = data[row][0];
		int index = 0;
		
		for(int i = 0; i < data[row].length; i++) {
			if(data[row][i] < lowest) {
				lowest = data[row][i];
				index = i;
			}
		}
		
		return index;
	}
	
	/**
	 * @summary finds highest sales value in a column
	 * @param data
	 * @param col
	 * @return highest sale
	 */
	
	public static double getHighestInColumn(double[][] data, int col) {
		
		double highest = 0;
		
		for(int i = 0; i < data.length; i++) {
			if(data[i].length > col && data[i][col] > highest) {
				highest = data[i][col];
			}
		}
		
		return highest;
	}
	
	/**
	 * @summary finds index of highest sale in a column
	 * @param data
	 * @param col
	 * @return index
	 */
	
	public static int getHighestInColumnIndex(double[][] data, int col) {
		
		double highest = 0;
		int index = 0;
		
		for(int i = 0; i < data.length; i++) {
			if(data[i].length > col && data[i][col] > highest) {
				highest = data[i][col];
				index = i;
			}
		}
		
		return index;
	}
	
	/**
	 * @summary finds lowest sale in a column
	 * @param data
	 * @param col
	 * @return lowest sale
	 */
	
	public static double getLowestInColumn(double[][] data, int col) {
		
		double lowest = Integer.MAX_VALUE;
		
		for(int i = 0; i < data.length; i++) {
			if(data[i].length > col && data[i][col] < lowest) {
				lowest = data[i][col];
			}
		}
		
		return lowest;
	}
	
	/**
	 * @summary finds index of lowest sale in column
	 * @param data
	 * @param col
	 * @return lowest sale index
	 */
	
	public static int getLowestInColumnIndex(double[][] data, int col) {
		
		double lowest = Integer.MAX_VALUE;
		int index = 0;
		
		for(int i = 0; i < data.length; i++) {
			if(data[i].length > col && data[i][col] < lowest) {
				lowest = data[i][col];
				index = i;
			}
		}
		
		return index;
	}
	
	/**
	 * @summary finds highest sale value in the whole array
	 * @param data
	 * @return highest sale
	 */
	
	public static double getHighestInArray(double[][] data) {
		
		double highest = 0;
		
		for(int i = 0; i < data.length; i++) {
			for(int j = 0; j < data[i].length; j++) {
				if(data[i][j] > highest) {
					highest = data[i][j];
				}
			}
		}
		
		return highest;
	}
	
	/**
	 * @summary finds lowest sale value in the entire array
	 * @param data
	 * @return lowest sale
	 */
	
	public static double getLowestInArray(double[][] data) {
		
		double lowest = data[0][0];
		
		for(int i = 0; i < data.length; i++) {
			for(int j = 0; j < data[i].length; j++) {
				if(data[i][j] < lowest) {
					lowest = data[i][j];
				}
			}
		}
		
		return lowest;
	}

}
