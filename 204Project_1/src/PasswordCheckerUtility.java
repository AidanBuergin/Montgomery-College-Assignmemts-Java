import java.util.ArrayList;
import java.util.regex.*;

//author Aidan Buergin

public class PasswordCheckerUtility {
	
	/**
	 * @summary constructor for the class
	 */
	
	public PasswordCheckerUtility() {}
	
	/**
	 * @summary ensures that both password and passwordConfirm are entirely equal to each other. Throws exception if they are different.
	 * @param password
	 * @param passwordConfirm
	 * @throws UnmatchedException
	 */
	
	public static void comparePasswords(String password, String passwordConfirm) throws UnmatchedException {
		
		if(password.compareTo(passwordConfirm) != 0) {
			throw new UnmatchedException();
		}
	}
	
	/**
	 * @summary determines if both args are the same. returns true if they are and false if they are different.
	 * @param password
	 * @param passwordConfirm
	 * @return whether password and passwordConfirm are the same. 
	 */
	
	public static boolean comparePasswordsWithReturn(String password, String passwordConfirm) {
		
		if(password.compareTo(passwordConfirm) != 0) {
			return false;
		}
		return true;
	}
	
	/**
	 * @summary determines if arg is greater than 5
	 * @param password
	 * @return true if arg is bigger than 5
	 * @throws LengthException
	 */
	
	public static boolean isValidLength(String password) throws LengthException {
		
		if(password.length() < 6) {
			throw new LengthException();
		}
		return true;
		
	}
	
	/**
	 * @summary checks for at least one uppercase alphabetic letter in the password
	 * @param password
	 * @return true if password contains uppercase
	 * @throws NoUpperAlphaException
	 */
	
	public static boolean hasUpperAlpha(String password) throws NoUpperAlphaException {
		
		for(int i = 0; i < password.length(); i++) {
			if(Character.isUpperCase(password.charAt(i))) {
				return true;
			}
		}
		throw new NoUpperAlphaException();
	}
	
	/**
	 * @summary checks for at least one lowercase alphabetic letter in the password
	 * @param password
	 * @return true if password contains lowercase
	 * @throws NoLowerAlphaException
	 */
	
	public static boolean hasLowerAlpha(String password) throws NoLowerAlphaException {
		
		for(int i = 0; i < password.length(); i++) {
			if(Character.isLowerCase(password.charAt(i))) {
				return true;
			}
		}
		throw new NoLowerAlphaException();
	}
	
	/**
	 * @summary checks password for at least one digit
	 * @param password
	 * @return true if password contains digit
	 * @throws NoDigitException
	 */
	
	public static boolean hasDigit​(String password) throws NoDigitException {
		
		for(int i = 0; i < password.length(); i++) {
			if(Character.isDigit(password.charAt(i))) {
				return true;
			}
		}
		throw new NoDigitException();
	}
	
	/**
	 * @summary checks password for at least one special character
	 * @param password
	 * @return true if password contains a special character 
	 * @throws NoSpecialCharacterException
	 */
	
	public static boolean hasSpecialChar(String password) throws NoSpecialCharacterException {
		
		Pattern pt = Pattern.compile("[a-zA-Z0-9]*");
		Matcher mt = pt.matcher(password);
		if ((mt.matches())) {
			throw new NoSpecialCharacterException();
		}
		
		return true;
	}
	
	/**
	 * @summary checks password for any repeating characters more than 2 times
	 * @param password
	 * @return true as long as password does not contain three chars in a row
	 * @throws InvalidSequenceException
	 */
	
	public static boolean NoSameCharInSequence(String password) throws InvalidSequenceException {
		
		for(int i = 1; i < password.length() - 1; i++){
			if(password.charAt(i - 1) == password.charAt(i)) {
				if(password.charAt(i + 1) == password.charAt(i)) {
					throw new InvalidSequenceException();
				}
			}
		}
		return true;
	}
	
	/**
	 * @summary uses many other methods in order to ensure that a password passes all tests and is valid
	 * @param password
	 * @return true if password is valid
	 * @throws LengthException
	 * @throws NoUpperAlphaException
	 * @throws NoLowerAlphaException
	 * @throws NoDigitException
	 * @throws NoSpecialCharacterException
	 * @throws InvalidSequenceException
	 */
	
	public static boolean isValidPassword(String password) throws LengthException, NoUpperAlphaException, NoLowerAlphaException, NoDigitException, NoSpecialCharacterException, InvalidSequenceException {
		
		if(!PasswordCheckerUtility.isValidLength(password)) {
			throw new LengthException();
		}
		if(!PasswordCheckerUtility.hasUpperAlpha(password)) {
			throw new NoUpperAlphaException();
		}
		if(!PasswordCheckerUtility.hasLowerAlpha(password)) {
			throw new NoLowerAlphaException();
		}
		if(!PasswordCheckerUtility.hasDigit​(password)) {
			throw new NoDigitException();
		}
		if(!PasswordCheckerUtility.hasSpecialChar(password)) {
			throw new NoSpecialCharacterException();
		}
		if(!PasswordCheckerUtility.NoSameCharInSequence(password)) {
			throw new InvalidSequenceException();
		}
		
		return true;
	}
	
	/**
	 * @summary checks if password has between six and nine characters
	 * @param password
	 * @return true if ^
	 */
	
	private static boolean hasBetweenSixAndNineChars​(String password) {
		
		if(password.length() > 5 && password.length() < 10) {
			return true;
		}
		return false;
	}
	
	/**
	 * @summary checks password for validity and if it is less than 10 chars.
	 * @param password
	 * @return true if password is deemed weak
	 * @throws WeakPasswordException
	 */
	
	public static boolean isWeakPassword(String password) throws WeakPasswordException {
		
		try {
			PasswordCheckerUtility.isValidPassword(password);
		} 
		catch (Exception e) {
			e.printStackTrace();
			return true;
		}
		
		if(PasswordCheckerUtility.hasBetweenSixAndNineChars​(password)) {
			throw new WeakPasswordException();
		}
		
		return false;
	}
	
	/**
	 * @summary checks an arraylist of passwords for validity.
	 * @param passwords
	 * @return an array with all failed passwords and the reasons for failure next to each
	 */
	
	public static ArrayList<String> getInvalidPasswords(ArrayList<String> passwords) {
		
		ArrayList<String> arr = new ArrayList<String>();
		
		for(String password : passwords) {
			
			try {
				PasswordCheckerUtility.isValidPassword(password);
			} catch (Exception e) {
				arr.add(password + " " + e.getMessage());
			} 
		}
		
		return arr;
	}
	
	
	
}

//author Aidan Buergin
