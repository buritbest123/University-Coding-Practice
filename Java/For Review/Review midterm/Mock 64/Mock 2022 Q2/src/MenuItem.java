// Name: Burit Sihabut
// ID: 6488079
// Section: 1

import java.util.ArrayList;

public class MenuItem {

	public  ArrayList<MenuItem> menu = new ArrayList<MenuItem>();
	
	// Task 1: Instance variables & constructors methods
	private String name; // • String name: a menu item’s name
	private double price; // • private double price;
	private int calorie; // • int calorie: a menu item’s calorie

	// Then, create two (overloading) constructor methods with the following signature
	public MenuItem(String _name, double _price, int _calorie) {
	name = _name;
    price = _price;
	calorie = _calorie;
	}

	// Overload constructor method
	public MenuItem(String _name, double _price) {
   		// your code goes here
		name = _name;
		price = _price;
		calorie = 0;
	}

  	// Task 2: Implements all required methods

	public String getName() {
		return name;
	}

	public double getPrice() {
		return price;
	}

	public int getCalorie() {
		return calorie;
	}

	public double increasePrice(int percent){
		return (this.price + ((double) percent / 100 * this.price));
	}
}
