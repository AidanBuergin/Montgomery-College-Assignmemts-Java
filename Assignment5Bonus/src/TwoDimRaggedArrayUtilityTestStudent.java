/*
 * Class: CMSC203 
 * Instructor: Eivazi
 * Description: Junit test for TwoDimRaggedArrayUtility class.
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

import static org.junit.Assert.*;

import java.io.File;
import java.io.FileNotFoundException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.util.*;

public class TwoDimRaggedArrayUtilityTestStudent {
	
	private File file1;
	private File file2;
	private double[][] arr1 = {
			{1, 2, 3}, 
			{4, 5}, 
			{6, 7, 8, 9},
			{4, 2, 5, 2, 7}
			};

	@Before
	public void setUp() throws Exception {
		file1 = new File("district3.txt");
		file2 = new File("JUnitTest.txt");
	}

	@After
	public void tearDown() throws Exception {
		file1 = null;
		file2 = null;
	}

	@Test
	public void testReadFile() throws FileNotFoundException {
		double[][] arr = TwoDimRaggedArrayUtility.readFile(file1);
		
		String s = "";
		
		for(int i = 0; i < arr.length; i++) {
			for(int j = 0; j < arr[i].length; j++) {
				s += arr[i][j] + " ";
			}
			s += "\n";
		}
		
		assertEquals(s, 
				"1.65 4.5 2.36 7.45 3.44 6.23 \n"
				+ "2.22 -3.24 -1.66 -5.48 3.46 \n"
				+ "4.23 2.29 5.29 \n"
				+ "2.76 3.76 4.29 5.48 3.43 \n"
				+ "3.38 3.65 3.76 \n"
				+ "2.46 3.34 2.38 8.26 5.34 \n"
				);
	}
	
	@Test
	public void testWriteToFile() throws FileNotFoundException {
		TwoDimRaggedArrayUtility.writeToFile(arr1, file2);
		
		Scanner sc = new Scanner(file2);
		
		assertEquals("1.0 2.0 3.0 ", sc.nextLine());
		assertEquals("4.0 5.0 ", sc.nextLine());
		
		sc.close();
	}
	
	@Test
	public void testGetTotal() {
		assertEquals(65, TwoDimRaggedArrayUtility.getTotal(arr1), .001);
	}

	@Test
	public void testGetAverage() {
		assertEquals(4.64285, TwoDimRaggedArrayUtility.getAverage(arr1), .01);
	}

	@Test
	public void testGetRowTotal() {
		assertEquals(6, TwoDimRaggedArrayUtility.getRowTotal(arr1, 0), .001);
	}

	@Test
	public void testGetColumnTotal() {
		assertEquals(11, TwoDimRaggedArrayUtility.getColumnTotal(arr1, 3), .001);
	}

	@Test
	public void testGetHighestInRow() {
		assertEquals(3, TwoDimRaggedArrayUtility.getHighestInRow(arr1, 0), .001);
	}

	@Test
	public void testGetHighestInRowIndex() {
		assertEquals(2, TwoDimRaggedArrayUtility.getHighestInRowIndex(arr1, 0), .001);
	}

	@Test
	public void testGetLowestInRow() {
		assertEquals(2, TwoDimRaggedArrayUtility.getLowestInRow(arr1, 3), .001);
	}

	@Test
	public void testGetLowestInRowIndex() {
		assertEquals(1, TwoDimRaggedArrayUtility.getLowestInRowIndex(arr1, 3), .001);
	}

	@Test
	public void testGetHighestInColumn() {
		assertEquals(9, TwoDimRaggedArrayUtility.getHighestInColumn(arr1, 3), .001);
	}

	@Test
	public void testGetHighestInColumnIndex() {
		assertEquals(2, TwoDimRaggedArrayUtility.getHighestInColumnIndex(arr1, 3), .001);
	}

	@Test
	public void testGetLowestInColumn() {
		assertEquals(2, TwoDimRaggedArrayUtility.getLowestInColumn(arr1, 3), .001);
	}

	@Test
	public void testGetLowestInColumnIndex() {
		assertEquals(3, TwoDimRaggedArrayUtility.getLowestInColumnIndex(arr1, 3), .001);
	}

	@Test
	public void testGetHighestInArray() {
		assertEquals(9, TwoDimRaggedArrayUtility.getHighestInArray(arr1), .001);
	}

	@Test
	public void testGetLowestInArray() {
		assertEquals(1, TwoDimRaggedArrayUtility.getLowestInArray(arr1), .001);
	}
}
