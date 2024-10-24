package step8_combine;

import java.util.ArrayList;

public class Cat {
	public String name, color;
	private int hungry, energy;		// Add another attribute (energy)
	public int catID;				// Add another attribute (catID)
	private ArrayList<Food> foods;	// Keep list of foods
	public static int objCounter = 0;
	static final int LIVE = 9;
	
	Cat(String name, String color, int hungry, int energy){
		this.name = name;
		this.color = color;
		this.hungry = hungry;
		this.energy = energy;
		this.foods = new ArrayList<Food>();
		objCounter++;
		this.catID = objCounter;	// Using counter to initialize ID
	}
	
	/*
	 * Getter method
	 */
	int getHungry(){ 
		return this.hungry;
	}
	
	/*
	 * Getter method
	 */
	int getEnergy(){ 
		return this.energy;
	}
	
	/*
	 * greeting method()
	 */
	void greeting(){
		System.out.println("Meow! I'm " + this.name);
	}
	
	/*
	 * isAlive() method
	 * The cat is alive if the energy is greater than 0
	 */
	boolean isAlive(){
		return energy > 0;
	}
	
	/*
	 * play() method
	 * Increase hungry level, and decrease energy level
	 */
	void play(){
		hungry++;
		energy--;
	}
	
	/*
	 * sleep() method
	 * Increase both energy and hungry level
	 */
	void sleep(){
		hungry++;
		energy++;
	}
	
	/*
	 * Add food into the list and decrease hungry level
	 * If the hungry level is less than 0, set its value to 0 
	 */
	void feedFood(Food f){	
		foods.add(f);		// add Food f into the list
		hungry = hungry - f.getLevel();	// decrease hungry 
		if(hungry < 0){
			hungry = 0;
		}
	}
	
	/*
	 * Display all foods in the list
	 */
	void printFoods(){
		for(Food f: foods){
			// now variable "f" is a Food object
			// it can call printInfo() which is 
			// an instance method of the Food class
			f.printInfo();	
		}
	}
	
	/*
	 * show Cat's info
	 */
	void displayCat(){
		System.out.println("------------------------");
		System.out.println("CatID: " + this.catID);
		System.out.println("Name: " + this.name);
		System.out.println("Color: " + this.color);
		System.out.printf("Hungry (%d), Energy (%d)\n", hungry, energy);
	}
	
	/*
	 * static method to begin the game
	 */
	static void begin(){
		System.out.println("Let's begin!");
	}
	
}
