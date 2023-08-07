/*
 * Class: CMSC203 
 * Instructor: Eivazi
 * Description: order class
 * Due: 08/06/2023
 * Platform/compiler: eclipse
 * I pledge that I have completed the programming 
 * assignment independently. I have not copied the code 
 * from a student or any source. I have not given my code 
 * to any student.
   Print your Name here: __aidan buergin________
*/
import java.util.*;

public class Order implements OrderInterface, Comparable{
	
	int orderNumber;
	int orderTime;
	Customer cust;
	Day orderDay;
	ArrayList<Beverage> bevList;
	
	public Order(int oT, Day d, Customer c) {
		
		cust = new Customer(c.getName(), c.getAge());
		
		orderNumber = generateOrder();
		
		orderTime = oT;
		orderDay = d;
		
		bevList = new ArrayList<Beverage>();
	}
	
	public int generateOrder() {
		Random rand = new Random();
		return rand.nextInt(10000, 90001);
	}
	
	public int getOrderNo() {
		return orderNumber;
	}
	
	public void setOrderNo(int i) {
		orderNumber = i;
	}

	/**
	 * @return the orderTime
	 */
	public int getOrderTime() {
		return orderTime;
	}

	/**
	 * @param orderTime the orderTime to set
	 */
	public void setOrderTime(int orderTime) {
		this.orderTime = orderTime;
	}

	/**
	 * @return the cust
	 */
	public Customer getCust() {
		Customer ncust = new Customer(cust.getName(), cust.getAge());
		
		return ncust;
	}

	/**
	 * @param cust the cust to set
	 */
	public void setCust(Customer cust) {
		this.cust = cust;
	}

	/**
	 * @return the orderDay
	 */
	public Day getOrderDay() {
		return orderDay;
	}
	
	public int getTotalItems() {
		return bevList.size();
	}

	/**
	 * @param orderDay the orderDay to set
	 */
	public void setOrderDay(Day orderDay) {
		this.orderDay = orderDay;
	}

	@Override
	public int compareTo(Object o) {
		Order order = (Order) o;
		if(orderNumber > order.orderNumber) {
			return 1;
		}
		if(orderNumber == order.orderNumber) {
			return 0;
		}
		return -1;
	}

	@Override
	public boolean isWeekend() {
		if(orderDay.equals(Day.SATURDAY) || orderDay.equals(Day.SUNDAY)) {
			return true;
		}
		return false;
	}

	@Override
	public Beverage getBeverage(int itemNo) {
		return bevList.get(itemNo);
	}

	@Override
	public void addNewBeverage(String bevName, Size size, boolean extraShot, boolean extraSyrup) {
		Beverage c = new Coffee(bevName, size, extraShot, extraSyrup);
		bevList.add(c);
	}

	@Override
	public void addNewBeverage(String bevName, Size size) {
		Beverage a = new Alcohol(bevName, size, isWeekend());
		bevList.add(a);
	}

	@Override
	public void addNewBeverage(String bevName, Size size, int numOfFruits, boolean addProtein) {
		Beverage s = new Smoothie(bevName, size, numOfFruits, addProtein);
		bevList.add(s);
	}

	@Override
	public double calcOrderTotal() {
		double total = 0;
		for(Beverage b : bevList) {
			total += b.calcPrice();
		}
		return total;
	}

	@Override
	public int findNumOfBeveType(Type type) {
		int sum = 0;
		for(Beverage b : bevList) {
			if(b.getType().equals(type)) {
				sum += 1;
			}
		}
		return sum;
	}

	@Override
	public String toString() {
		return "Order [orderNumber=" + orderNumber + ", orderTime=" + orderTime + ", customer info=[" + cust.toString() + "], orderDay="
				+ orderDay + ",\nbevList=" + bevList + "]";
	}
}
