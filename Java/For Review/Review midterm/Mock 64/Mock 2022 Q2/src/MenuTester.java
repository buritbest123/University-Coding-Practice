// ID: 6488079
// Name: Burit Sihabut
// Section: 1

import java.awt.*;
import java.util.ArrayList;

public class MenuTester {
	public static void main(String[] args) {

		// Create Menu
		ArrayList<MenuItem> menu = new ArrayList<MenuItem>();
		menu.add(new MenuItem("Espresso", 60, 10));
		menu.add(new MenuItem("Cappuccino", 80, 155));
		menu.add(new MenuItem("Coffee Latte", 75, 150));
		menu.add(new MenuItem("Coffee Mocha", 80, 340));
		menu.add(new MenuItem("Water", 10));

		// Print all menu items
		System.out.println("------------------------------");
		System.out.println("       Coffee Menu");
		System.out.println("------------------------------");
		printMenu(menu);

		// Task 2 Tester: Increase the price 
		System.out.println("\nIncrease the price of Cappuccino and Coffee Latte by 8%");
		System.out.println(menu.get(1).getName() + " -> " + menu.get(1).increasePrice(8));
		System.out.println(menu.get(2).getName() + " -> " + menu.get(2).increasePrice(8));

		// Task3 Tester: Show total summary 
		System.out.println("\nShow the summary of the order");
		ArrayList<MenuItem> orders = new ArrayList<MenuItem>();
		orders.add(menu.get(1));
		orders.add(menu.get(4));
		showOrderSummary(orders);
	}

	public static void printMenu(ArrayList<MenuItem> menu) {
		int i = 1;
		for (MenuItem m : menu) {
			System.out.println("[" + (i++) + "] " + m.getName() + ": "
					+ m.getPrice() + " (" + m.getCalorie() + " Kcal)");
		}
	}

	// Task 3: Implement show order summary
	public static void showOrderSummary(ArrayList<MenuItem> order) {
		// Your code goes here
		double Calories = 0;
		double Price = 0;
		for (int i = 0; i < order.size(); i++) {
			Calories += order.get(i).getCalorie();
			Price += order.get(i).getPrice();
			System.out.println("Total Calories: " + Calories + ", " + "Total Price: " + Price);
		}
	}
}