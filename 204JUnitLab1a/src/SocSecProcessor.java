import java.util.Scanner;

public class SocSecProcessor {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		boolean cont = true;
		
		do {
		
		System.out.println("Name? ");
		String name = sc.nextLine();
		
		System.out.println("SSN? ");
		String ssn = sc.nextLine();
		
		try {
			SocSecProcessor.isValid(ssn);
			System.out.println(name + " " + ssn + " is valid.");
		}
		catch(SocSecException e) {
			System.out.println(name);
			System.out.println(ssn);
			System.out.println(e.getMessage());
		}
		
		System.out.println("Continue? true/false");
		cont = sc.nextBoolean();
		String s = sc.nextLine();
		System.out.println(cont);
		
		} while(cont == true);
		
		sc.close();
	}
	
	public static boolean isValid(String ssn) throws SocSecException{
		
		if(ssn.length() != 11) {
			throw new SocSecException(", wrong number of characters.");
		}
		else if(ssn.charAt(3) != '-' || ssn.charAt(6) != '-') {
			throw new SocSecException(", dashes at wrong positions.");
		}
		for(int i = 0; i < ssn.length(); i++) {
			if(ssn.charAt(i) != '-') {
				if(ssn.charAt(i) < 48 || ssn.charAt(i) > 57)
					throw new SocSecException(", contains a character that is not a digit or dash.");
			}
		}
		return true;
	}

}
