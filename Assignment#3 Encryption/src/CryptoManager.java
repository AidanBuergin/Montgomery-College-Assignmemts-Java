
/**
 * This is a utility class that encrypts and decrypts a phrase using two
 * different approaches. The first approach is called the Caesar Cipher and is a
 * simple �substitution cipher� where characters in a message are replaced by a
 * substitute character. The second approach, due to Giovan Battista Bellaso,
 * uses a key word, where each character in the word specifies the offset for
 * the corresponding character in the message, with the key word wrapping around
 * as needed.
 * 
 * @author Farnaz Eivazi
 * @version 7/16/2022
 */

/*
 * Class: CMSC203 
 * Instructor:Eivazi
 * Description: This class encrypts strings by using the Caesar method and the Bellaso method.
 * Due: 07/11/2023
 * Platform/compiler: Eclipse
 * I pledge that I have completed the programming  assignment independently. 
*  I have not copied the code from a student or any source. 
*  I have not given my code to any student.
*  Print your Name here: ___Aidan Buergin_______
*/

public class CryptoManager {
	
	private static final char LOWER_RANGE = ' ';
	private static final char UPPER_RANGE = '_';
	private static final int RANGE = UPPER_RANGE - LOWER_RANGE + 1;

	/**
	 * This method determines if a string is within the allowable bounds of ASCII codes 
	 * according to the LOWER_RANGE and UPPER_RANGE characters
	 * @param plainText a string to be encrypted, if it is within the allowable bounds
	 * @return true if all characters are within the allowable bounds, false if any character is outside
	 */
	public static boolean isStringInBounds (String plainText) {
		
		for(int i = 0; i < plainText.length(); i++) {
			if(plainText.charAt(i) < LOWER_RANGE || plainText.charAt(i) > UPPER_RANGE) {
				return false;
			}
		}
		return true;
	}

	/**
	 * Encrypts a string according to the Caesar Cipher.  The integer key specifies an offset
	 * and each character in plainText is replaced by the character \"offset\" away from it 
	 * @param plainText an uppercase string to be encrypted.
	 * @param key an integer that specifies the offset of each character
	 * @return the encrypted string
	 */
	public static String caesarEncryption(String plainText, int key) {
		
		if(plainText == plainText.toLowerCase()) {
			return "The selected string is not in bounds, Try again.";
		}
		
		String s = "";
		
		while(key > 95) {
			key -= RANGE;
		}
		
		char temp = 32;
		
		// for loop that determines the new character ascii value and ensures that it is still in bounds.
		
		for(int i = 0; i < plainText.length(); i++) {
			
			if(plainText.charAt(i) + key > 95) {
				temp = (char)(plainText.charAt(i) + key - RANGE);
			} 
			else if(plainText.charAt(i) + key < 32) {
				temp = (char)(plainText.charAt(i) + key + RANGE);
			} 
			else {
				temp = (char)(plainText.charAt(i) + key);
			}
			
			s += temp;
		}
		
		return s;
	}
	
	/**
	 * Encrypts a string according the Bellaso Cipher.  Each character in plainText is offset 
	 * according to the ASCII value of the corresponding character in bellasoStr, which is repeated
	 * to correspond to the length of plainText
	 * @param plainText an uppercase string to be encrypted.
	 * @param bellasoStr an uppercase string that specifies the offsets, character by character.
	 * @return the encrypted string
	 */
	public static String bellasoEncryption (String plainText, String bellasoStr) {
		
		//The if statements and loops below ensure that the key is the same size as the plainText string.
		
		int diff = plainText.length() - bellasoStr.length();
		
		if(bellasoStr.length() > plainText.length()) {
			bellasoStr = bellasoStr.substring(0, plainText.length());
		}
		
		if(bellasoStr.length() < plainText.length()) {
			
			String temp = bellasoStr;
			int i = 0;
			
			while(!(bellasoStr.length() == plainText.length())) {
				
				bellasoStr += bellasoStr.charAt(i);
				i++;
				
			}
			
		}
		
		//The loop below creates the new encrypted string using the key.
		
		String s = "";
		
		for(int i = 0; i < plainText.length(); i++) {
			int ascii = ((int)plainText.charAt(i) + (int)bellasoStr.charAt(i));
			while(ascii > 95) {
				ascii -= RANGE;
			}
			s += (char)ascii;
		}
		
		return s;
	}
	
	/**
	 * Decrypts a string according to the Caesar Cipher.  The integer key specifies an offset
	 * and each character in encryptedText is replaced by the character \"offset\" characters before it.
	 * This is the inverse of the encryptCaesar method.
	 * @param encryptedText an encrypted string to be decrypted.
	 * @param key an integer that specifies the offset of each character
	 * @return the plain text string
	 */
	public static String caesarDecryption (String encryptedText, int key) {
		
		while(key > 95) {
			key -= RANGE;
		}
		
		char temp;
		String s = "";
		
		for(int i = 0;i < encryptedText.length(); i++) {
			temp = encryptedText.charAt(i);
			if((temp - key) < 32) {
				s += (char)(temp - key + 64);
			} else {
			s += (char)(temp - key);
			}
		}
		
		return s;
	}
	
	/**
	 * Decrypts a string according the Bellaso Cipher.  Each character in encryptedText is replaced by
	 * the character corresponding to the character in bellasoStr, which is repeated
	 * to correspond to the length of plainText.  This is the inverse of the encryptBellaso method.
	 * @param encryptedText an uppercase string to be encrypted.
	 * @param bellasoStr an uppercase string that specifies the offsets, character by character.
	 * @return the decrypted string
	 */
	public static String bellasoDecryption(String encryptedText, String bellasoStr) {
		
		String s = "";
		
		//the two if statements below are the same as in the encryption method and ensure that the key is the same length as the encrypted string.
		
		if(bellasoStr.length() > encryptedText.length()) {
			bellasoStr = bellasoStr.substring(0, encryptedText.length());
		}
		
		if(bellasoStr.length() < encryptedText.length()) {
			
			String temp = bellasoStr;
			int i = 0;
			
			while(!(bellasoStr.length() == encryptedText.length())) {
				
				bellasoStr += bellasoStr.charAt(i);
				i++;
				
			}
			
		}
		
		//the statements below do the decrypting.
		
		int ascii = 0;
		
		for(int i = 0; i < encryptedText.length(); i++) {
			ascii = ((int)encryptedText.charAt(i) - (int)bellasoStr.charAt(i));
			while(ascii < 32) {
				ascii += RANGE;
			}
			s += (char)ascii;
		}
		
		return s;
	}
	
	// @Author Aidan Buergin
}
