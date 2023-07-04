import java.util.ArrayList;

/*
 * Class: CMSC203 
 * Instructor: Eivazi
 * Description: PatientDriverApp is the driver for the project and is where instances will be created.
 * Due: 07/03/2023
 * Platform/compiler: Eclipse
 * I pledge that I have completed the programming 
 * assignment independently. I have not copied the code 
 * from a student or any source. I have not given my code 
 * to any student.
   Print your Name here: _Aidan Buergin_________
*/



public class PatientDriverApp {
	
	/**
	 * @description main driver method for the application.
	 * @param args
	 */

	public static void main(String[] args) {
		
		Patient john = new Patient("John B. Addleston", "2243 Pikewood ln", "Frederick", "Maryland", "20443", "203-203-2003","Mark Jacobs 776-666-5543");
		Procedure p1 = new Procedure("Physical Exam", "7/20/2023", "Dr. Irvine", 250.0);
		Procedure p2 = new Procedure("X-ray", "7/20/2023", "Dr. Jamison", 500.0);
		Procedure p3 = new Procedure("Blood Test", "7/20/2023", "Dr. Smith", 200.0);
		
		System.out.println(john.toString());
		System.out.println(p1.toString());
		System.out.println(p2.toString());
		System.out.println(p3.toString());
		
		double total = (p1.getCost() + p2.getCost() + p3.getCost());
		System.out.println("The total cost of the operations is: " + total);
		
		System.out.println("Student name: Aidan Buergin");
		System.out.println("Student MC: M21175822");
		System.out.println("Due Date: 07/03/2023");

	}
}
