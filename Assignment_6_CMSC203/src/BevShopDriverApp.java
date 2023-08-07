/*
 * Class: CMSC203 
 * Instructor: Eivazi
 * Description: Driver app for program
 * Due: 08/06/2023
 * Platform/compiler: eclipse
 * I pledge that I have completed the programming 
 * assignment independently. I have not copied the code 
 * from a student or any source. I have not given my code 
 * to any student.
   Print your Name here: __aidan buergin________
*/

import java.util.*;
public class BevShopDriverApp {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		BevShop bs = new BevShop();
		
		System.out.println("The min age to buy alcohol is 21 and you can only buy up to 3 alcoholic beverages.");
		
		System.out.println("Enter name: ");
		String n = sc.nextLine();
		System.out.println("Enter age: ");
		int a = sc.nextInt();
		Customer c = new Customer(n, a);
		
		
		boolean con = true;
		do {
			
		bs.startNewOrder(8, Day.TUESDAY, n, a);
		
		System.out.println("Starting a new order for " + c.getName());
		if(c.getAge() >= 21) {
			System.out.println("You are old enough for alcohol.");
		} else {
			System.out.println("You may not order alcohol.");
		}
		
		boolean cont = true;
		
		do {
			System.out.println("What type of beverage would you like to add?");
			System.out.println("Smoothie = 1, Coffee = 2, Alcohol = 3, finish order = 4");
			int i = sc.nextInt();
			
			if(i == 1) {
				System.out.println("Smoothie name: ");
				String bName = sc.next();
				System.out.println("Enter size: ");
				String s = sc.next();
				Size size = Size.valueOf(s.toUpperCase());
				System.out.println("Would you like protein? True/False");
				boolean p = sc.nextBoolean();
				System.out.println("How many fruit?");
				int f = sc.nextInt();
				if(f > 5) {
					System.out.println("Cannot add that much. Fruit privelage revoked!");
					bs.processSmoothieOrder(bName, size, 0, p);
				} else {
					bs.processSmoothieOrder(bName, size, f, p);
				}
			}
			
			if(i == 2) {
				System.out.println("Coffee name: ");
				String bName = sc.next();
				System.out.println("Enter size: ");
				String s = sc.next();
				Size size = Size.valueOf(s.toUpperCase());
				System.out.println("Would you like extra shot? True/False");
				boolean esh = sc.nextBoolean();
				System.out.println("Would you like extra syrup? True/False");
				boolean esy = sc.nextBoolean();
				bs.processCoffeeOrder(bName, size, esh, esy);
			}
			
			if(i == 3) {
				if(c.getAge() >= 21) {
					System.out.println("Alcoholic bev name: ");
					String bName = sc.next();
					System.out.println("Enter size: ");
					String s = sc.next();
					Size size = Size.valueOf(s.toUpperCase());
					bs.processAlcoholOrder(bName, size);
				} else {
					System.out.println("You cant order alcohol!");
				}
			}
			
			if(i == 4) {
				cont = false;
			}
			
		} while (cont == true);
		
		bs.orders.add(bs.getCurrentOrder());
		
		System.out.println("Would you like to start another order? True/False");
		if(sc.nextBoolean() == false) {
			con = false;	
		}
		
		} while (con == true);
		
		System.out.println("Order total is " + bs.getCurrentOrder().calcOrderTotal());
		System.out.println("Monthly total is " + bs.totalMonthlySale() + " from " + bs.totalNumOfMonthlyOrders() + " order(s).");
		sc.close();
	}

}
