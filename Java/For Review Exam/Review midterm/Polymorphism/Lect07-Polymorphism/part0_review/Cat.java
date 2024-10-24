package part0_review;

public class Cat {
	public String name, color;
	private int hungry, energy;	
	
	Cat(String name, String color, int hungry, int energy){
		this.name = name;
		this.color = color;
		this.hungry = hungry;
		this.energy = energy;
	}
	
	/* greeting with "Meow!" */
	void greeting(){
		System.out.println("Meow! I'm " + this.name);
	}
	
	/* play: Increase hungry level, and decrease energy level */
	void play(){
		hungry++;
		energy--;
	}
	
	/* sleep: Increase both energy and hungry level */
	void sleep(){
		hungry++;
		energy++;
	}
	
	/* If the hungry level is less than 0, set its value to 0 */
	void feed(Food f){	
		hungry = hungry - f.getLevel();	// decrease hungry 
		if(hungry < 0){
			hungry = 0;
		}
		if(f instanceof EnergyDrink){
			energy = energy + ((EnergyDrink) f).getPower();
		}
	}

	int getHungry(){ 
		return this.hungry;
	}
	
	int getEnergy(){ 
		return this.energy;
	}
	
	/* show Cat's info */
	void display(){
		System.out.println("------------------------");
		System.out.println("Name: " + this.name);
		System.out.println("Color: " + this.color);
		System.out.printf("Hungry (%d), Energy (%d)\n", hungry, energy);
	}
}


/*
 * isAlive() method
 * The cat is alive if the energy is greater than 0
 
boolean isAlive(){
	return energy > 0;
}
*/