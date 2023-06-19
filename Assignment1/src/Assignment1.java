import java.util.*;

/*
 * Class: CMSC203 
 * Instructor: Eivazi
 * Description: The class runs a guessing game where one out of five
 * colors is selected at random and the user guesses which color is picked. The game has 10 rounds.
 * Due: 06/19/2023
 * Platform/compiler: Eclipse
 * I pledge that I have completed the programming 
 * assignment independently. I have not copied the code 
 * from a student or any source. I have not given my code 
 * to any student.
   Print your Name here: _Aidan Buergin_________
*/


public class Assignment1 {
	
	// Main method runs the code for the game

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter your name: ");
		String name = sc.nextLine();
		
		System.out.println("Enter your MC M#: ");
		String mcnum = sc.nextLine();
		
		System.out.println("Describe Yourself: ");
		String desc = sc.nextLine();
		
		System.out.println("Due Date: ");
		String date = sc.nextLine();
		
		System.out.print("");
		
		System.out.println("CMSC203 Assignmnet1: Test your ESP skills!");
		
		Random rand = new Random();
		int counter = 0;
		
		// for loop that runs exactly ten times and counts correct guesses
		
		for(int i = 1; i <= 10; i++) {
			
			System.out.println("Round " + i + "\n");
			System.out.println("I am thinking of a color.");
			System.out.println("Is it Red, Green, Blue, Orange, or Yellow?");
			
			int number = rand.nextInt(5);
			String color = "";
			
			switch(number) {
				case 0:
					color = "Red";
					break;
				case 1:
					color = "Green";
					break;
				case 2:
					color = "Blue";
					break;
				case 3:
					color = "Orange";
					break;
				case 4:
					color = "Yellow";
					break;
				default:
					System.out.println("Random number higher than 4 or lower than 0");
			}
			
			System.out.println("Enter your guess here: ");
			int guess = sc.nextInt();
			System.out.println("");
			
			/*
			1 is added to "number" for the correct guess check because the computer
			picks a random integer from 0-4 while the user picks and integer from 1-5.
			If 1 was not added, user might try to pick red with "1" but computer would
			have red stored under 0. Even though the user guesses correct, the win is not counted.
			*/
			
			if(guess == (number + 1)) {
				counter++;
			}
			
			System.out.println("I was thinking of " + color + ".");
		}
		
		sc.close();
		
		System.out.println("Game Over \n");
		System.out.println("You guessed " + counter + " out of 10 colors correctly.");
		
		System.out.println("User Name: " + name);
		System.out.println("Student MC M#: " + mcnum);
		System.out.println("User Description: " + desc);
		System.out.println("Date: " + date + "\n");
		
		System.out.println("Aidan Buergin");

	}
}

// Written by Aidan Buergin