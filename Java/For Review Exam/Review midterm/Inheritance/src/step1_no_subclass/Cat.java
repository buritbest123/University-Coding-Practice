package step1_no_subclass;

public class Cat {
	public String name, color;
	private int hungry, energy;		// Add another attribute (energy)
	
	Cat(String name, String color, int hungry, int energy){
		this.name = name;
		this.color = color;
		this.hungry = hungry;
		this.energy = energy;
	}
	
	int getHungry(){ 
		return this.hungry;
	}
	
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
	 * If the hungry level is less than 0, set its value to 0 
	 */
	void feedFood(Food f){	
		hungry = hungry - f.getLevel();	// decrease hungry 
		if(hungry < 0){
			hungry = 0;
		}
	}
	
	/*
	 * Feed EnergyDrink - decrease hungry level and increase energy level too
	 */
	void feedFood(EnergyDrink f){	
		hungry = hungry - f.getLevel();	// decrease hungry 
		if(hungry < 0){
			hungry = 0;
		}
		// increase energy level
		energy = energy + f.getPower();
	}
	/*
	 * show Cat's info
	 */
	void display(){
		System.out.println("------------------------");
		System.out.println("Name: " + this.name);
		System.out.println("Color: " + this.color);
		System.out.printf("Hungry (%d), Energy (%d)\n", hungry, energy);
	}
	
}
