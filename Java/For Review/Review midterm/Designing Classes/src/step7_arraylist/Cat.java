package step7_arraylist;

import java.util.ArrayList;

public class Cat {
	public String name, color;
	private int hungry;
	private ArrayList<Food> foods;	// Keep list of foods
	
	Cat(String name, String color, int hungry){
		this.name = name;
		this.color = color;
		this.hungry = hungry;
		// initialize ArrayList inside the constructor
		this.foods = new ArrayList<Food>();
	}
	void feedFood(Food f){	
		foods.add(f);		// add Food f into the list
		hungry = hungry - f.getLevel();	// decrease hungry 
	}
	//Display all foods in the list
	void printFoods(){
		for(Food f: foods){
			// now variable "f" is a Food object
			// it can call printInfo() which is 
			// an instance method of the Food class
			f.printInfo();	
		}
	}
	int getHungry(){ return this.hungry;}
}
