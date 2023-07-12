import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.Test;

/*
 * Class: CMSC203 
 * Instructor:Eivazi
 * Description: This is my student junit class.
 * Due: 07/11/2023
 * Platform/compiler: Eclipse
 * I pledge that I have completed the programming  assignment independently. 
*  I have not copied the code from a student or any source. 
*  I have not given my code to any student.
*  Print your Name here: ___Aidan Buergin_______
*/

public class CryptoManagerTestStudent {

	@Test
	public void testStringInBounds() {
		assertTrue(CryptoManager.isStringInBounds("PURPLE"));
	}

	@Test
	public void testEncryptCaesar() {
		assertEquals("L#OLNH#WKH#FRORU#SXUSOH", CryptoManager.caesarEncryption("I LIKE THE COLOR PURPLE", 3));
	}

	@Test
	public void testDecryptCaesar() {
		assertEquals("I LIKE THE COLOR PURPLE", CryptoManager.caesarDecryption("L#OLNH#WKH#FRORU#SXUSOH", 3));
	}

	@Test
	public void testEncryptBellaso() {
		assertEquals("Y5$UQ!^)0!!&U5\"%\"%^U", CryptoManager.bellasoEncryption("I REALLY LOVE PURPLE", "PURP"));

	}

	@Test
	public void testDecryptBellaso() {
		assertEquals("I REALLY LOVE PURPLE", CryptoManager.bellasoDecryption("Y5$UQ!^)0!!&U5\"%\"%^U", "PURP"));

	}
	// @Author Aidan Buergin
}
