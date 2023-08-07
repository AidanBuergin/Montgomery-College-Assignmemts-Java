/*
 * Class: CMSC203 
 * Instructor: Eivazi
 * Description: BevShop class
 * Due: 08/06/2023
 * Platform/compiler: eclipse
 * I pledge that I have completed the programming 
 * assignment independently. I have not copied the code 
 * from a student or any source. I have not given my code 
 * to any student.
   Print your Name here: __aidan buergin________
*/
import java.util.*;

public class BevShop implements BevShopInterface{
	
	public ArrayList<Order> orders;
	private Order currentOrder;
	
	public BevShop() {
		orders = new ArrayList<Order>();
	}
	
	/**
	 * @summary returns if order time is valid
	 * @return ^
	 */

	@Override
	public boolean isValidTime(int time) {
		if(time >= MIN_TIME && time <= MAX_TIME) {
			return true;
		}
		return false;
	}
	
	public void setCurrentOrder(Order o) {
		currentOrder = o;
	}
	
	/**
	 * @summary return max num of fruits
	 */

	@Override
	public int getMaxNumOfFruits() {
		return MAX_FRUIT;
	}
	
	/**
	 * @summary return min age for alc
	 */

	@Override
	public int getMinAgeForAlcohol() {
		return MIN_AGE_FOR_ALCOHOL;
	}
	
	/**
	 * @summary return whether drink has too many fruit or not
	 */

	@Override
	public boolean isMaxFruit(int numOfFruits) {
		if(numOfFruits >= MAX_FRUIT) {
			return true;
		}
		return false;
	}

	/**
	 * @summary return max amount of alc bevs per order
	 */

	@Override
	public int getMaxOrderForAlcohol() {
		// TODO Auto-generated method stub
		return MAX_ORDER_FOR_ALCOHOL;
	}
	
	/**
	 * @summary returns whether someone can order more alcoholic drinks
	 */

	@Override
	public boolean isEligibleForMore() {
		if(getNumOfAlcoholDrink() >= MAX_ORDER_FOR_ALCOHOL) {
			return false;
		} 
		return true;
	}
	
	/**
	 * @summary returns number of alc drinks in order
	 */

	@Override
	public int getNumOfAlcoholDrink() {
		return currentOrder.findNumOfBeveType(Type.ALCOHOL);
	}
	
	/**
	 * @summary returns wheter customer's age is valid for alc purchase
	 */

	@Override
	public boolean isValidAge(int age) {
		if(age >= MIN_AGE_FOR_ALCOHOL) {
			return true;
		}
		return false;
	}
	
	/**
	 * @summary creates a new order
	 */

	@Override
	public void startNewOrder(int time, Day day, String customerName, int customerAge) {
		Customer c = new Customer(customerName, customerAge);
		currentOrder = new Order(time, day, c);
		
	}
	
	/**
	 * @summary overloaded method that adds a coffee to the order
	 */

	@Override
	public void processCoffeeOrder(String bevName, Size size, boolean extraShot, boolean extraSyrup) {
		Coffee c = new Coffee(bevName, size, extraShot, extraSyrup);
		currentOrder.bevList.add(c);
		
	}
	
	/**
	 * @summary overloaded method that adds an alcoholic drink to the order
	 */

	@Override
	public void processAlcoholOrder(String bevName, Size size) {
		Alcohol a = new Alcohol(bevName, size, currentOrder.isWeekend());
		currentOrder.bevList.add(a);
		
	}
	
	/**
	 * @summary overloaded method that adds a smoothie to the order
	 */

	@Override
	public void processSmoothieOrder(String bevName, Size size, int numOfFruits, boolean addProtein) {
		Smoothie s = new Smoothie(bevName, size, numOfFruits, addProtein);
		currentOrder.bevList.add(s);
		
	}
	
	/**
	 * @summary finds an order in the orderlist matching the arg ordernumber
	 */

	@Override
	public int findOrder(int orderNo) {
		for(Order o : orders) {
			if(o.orderNumber == orderNo) {
				return orders.indexOf(o);
			}
		}
		return -1;
	}
	
	/**
	 * @summary returns total cost of an order found by comparing all order numbers
	 */

	@Override
	public double totalOrderPrice(int orderNo) {
		for(Order o : orders) {
			if(o.orderNumber == orderNo) {
				return o.calcOrderTotal();
			}
		}
		return -1;
	}
	
	/**
	 * @summary returns total sales of all orders
	 */

	@Override
	public double totalMonthlySale() {
		double sum = 0;
		for(Order o : orders) {
			sum += o.calcOrderTotal();
		}
		return sum;
	}
	
	/**
	 * @summary returns total amount of orders
	 */

	@Override
	public int totalNumOfMonthlyOrders() {
		return orders.size();	
	}
	
	/**
	 * @summary gets current index order
	 */

	@Override
	public Order getCurrentOrder() {
		Order order2 = new Order(currentOrder.getOrderTime(), currentOrder.getOrderDay(), currentOrder.getCust());
		order2.bevList = currentOrder.bevList;
		return order2;
	}
	
	/**
	 * @summary returns order at a certain index in order list
	 */

	@Override
	public Order getOrderAtIndex(int index) {
		return orders.get(index);
	}
	
	/**
	 * @summary sorts order list by comparing all orders
	 */

	@Override
	public void sortOrders() {
		Collections.sort(orders);
	}
	
	/**
	 * @summary toString for BevShop
	 */

	@Override
	public String toString() {
		
		String s = "all orders: \n";

		for(Order o : orders) {
			s += o.toString();
			s += "\n";
		}
		s += "total monthly sales: " + totalNumOfMonthlyOrders();
		
		return s;
	}
}
