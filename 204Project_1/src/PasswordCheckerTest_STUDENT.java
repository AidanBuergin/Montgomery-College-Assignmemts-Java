
import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * STUDENT tests for the methods of PasswordChecker
 * @author 
 *
 */
public class PasswordCheckerTest_STUDENT {
	
	String p1;
	String p2;
	String p3;
	String p4;
	String p5;
	ArrayList<String> arr;

	@Before
	public void setUp() throws Exception {
		p1 = "Ab1234$3";
		p2 = "Appple$werttr";
		p3 = "ab334$2";
		p4 = "A2B%";
		p5 = "AB5$ererererer";
		arr = new ArrayList<String>();
	}

	@After
	public void tearDown() throws Exception {
		p1 = null;
		p2 = null;
		p3 = null;
		p4 = null;
		arr = null;
	}

	/**
	 * Test if the password is less than 6 characters long.
	 * This test should throw a LengthException for second case.
	 */
	@Test
	public void testIsValidPasswordTooShort()
	{
		try {
			assertEquals(true, PasswordCheckerUtility.isValidLength(p1));
			PasswordCheckerUtility.isValidLength(p4);
			assertTrue("LengthException exception not called", false);
		} catch (LengthException e) {

		}
	}
	
	/**
	 * Test if the password has at least one uppercase alpha character
	 * This test should throw a NoUpperAlphaException for second case
	 */
	@Test
	public void testIsValidPasswordNoUpperAlpha()
	{
		try {
			assertTrue(PasswordCheckerUtility.hasUpperAlpha(p1));
			PasswordCheckerUtility.hasUpperAlpha(p3);
			assertFalse("NoUpperAlphaException exception not called", true);
		}
		catch(NoUpperAlphaException e) {
			
		}
	}
	
	/**
	 * Test if the password has at least one lowercase alpha character
	 * This test should throw a NoLowerAlphaException for second case
	 */
	@Test
	public void testIsValidPasswordNoLowerAlpha()
	{
		try {
			assertTrue(PasswordCheckerUtility.hasLowerAlpha(p1));
			PasswordCheckerUtility.hasLowerAlpha(p4);
			assertFalse("NoLowerAlphaException exception not called", true);
		}
		catch(NoLowerAlphaException e) {
			
		}
	}
	/**
	 * Test if the password has more than 2 of the same character in sequence
	 * This test should throw a InvalidSequenceException for second case
	 */
	@Test
	public void testIsWeakPassword()
	{
		try {
			assertFalse(PasswordCheckerUtility.isWeakPassword(p5));
			PasswordCheckerUtility.isWeakPassword(p1);
			assertFalse("WeakPasswordException exception not called", true);
		}
		catch(Exception e) {
			System.out.println("called");
		}
	}
	
	/**
	 * Test if the password has more than 2 of the same character in sequence
	 * This test should throw a InvalidSequenceException for second case
	 */
	@Test
	public void testIsValidPasswordInvalidSequence()
	{
		try {
			assertTrue(PasswordCheckerUtility.NoSameCharInSequence(p1));
			PasswordCheckerUtility.NoSameCharInSequence(p2);
			assertFalse("InvalidSequenceException exception not called", true);
		}
		catch(InvalidSequenceException e) {
			
		}
	}
	
	/**
	 * Test if the password has at least one digit
	 * One test should throw a NoDigitException
	 */
	@Test
	public void testIsValidPasswordNoDigit()
	{
		try {
			assertTrue(PasswordCheckerUtility.hasDigit​(p1));
			PasswordCheckerUtility.hasDigit​(p2);
			assertFalse("NoDigitException exception not called", true);
		}
		catch(NoDigitException e) {
			
		}
	}
	
	/**
	 * Test correct passwords
	 * This test should not throw an exception
	 */
	@Test
	public void testIsValidPasswordSuccessful()
	{
		try {
		assertTrue(PasswordCheckerUtility.isValidPassword(p1));
		assertTrue(PasswordCheckerUtility.isValidPassword(p5));
		}
		catch(Exception e) {
			assertFalse("exception called", true);
		}
	}
	
	/**
	 * Test the invalidPasswords method
	 * Check the results of the ArrayList of Strings returned by the validPasswords method
	 */
	@Test
	public void testInvalidPasswords() {
		arr.add(p1);
		arr.add(p2);
		arr.add(p3);
		arr.add(p4);
		arr.add(p5);
		ArrayList<String> alist;
		alist = PasswordCheckerUtility.getInvalidPasswords(arr);
		assertEquals(alist.get(0), "Appple$werttr The password must contain at least one digit");
		assertEquals(alist.get(1), "ab334$2 The password must contain at least one uppercase alphabetic character");
		assertEquals(alist.get(2), "A2B% The password must be at least 6 characters long");
		assertEquals(alist.size(), 3, .001);
		alist = null;
	}
	
}
