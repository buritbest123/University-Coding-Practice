package step1_no_subclass;

public class EnergyDrink {
	private String name;	// same attribute as Food 
	private int level;		// same attribute as Food
	private int power; 
	
	EnergyDrink(String name, int level, int power){
		this.name = name;
		this.level = level;
		this.power = power;
	}
	
	// same method as Food
	void printInfo(){
		System.out.println(
				name + ": " + level + ", power: " + power);
	}
	
	// same method as Food
	int getLevel(){
		return level;
	}
	
	// new method (doesn't have this in Food)
	int getPower(){
		return power;
	}
}

