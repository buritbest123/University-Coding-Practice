package step7_arraylist;

public class Food {
	private String name;		// instance field/ attribute
	private int level;		// instance field/ attribute
	
	// name as parameter
	// level as parameter
	Food(String n, int level){
		name = n;
		this.level = level;
	}
	
	void printInfo(){
		int x = 1;
		System.out.println(
				name + ":" + level);
	}
	
	int getLevel(){
		return level;
	}
	
}

