package step6_object_parameter;

public class Food {
	private String name; // instance field
	private int level;	 // instance field
	
	// Constructor method
	Food(String n, int lev){
		this.name = n;		
		this.level = lev;
	}
	
	// Display food information
	void printInfo(){
		System.out.println(
				name + ":" + this.level);
	}
	
	// Get hungry's level this food 
	// can decrease
	int getLevel(){
		return this.level;
	}	
}

