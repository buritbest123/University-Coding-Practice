package step0_review;

public class Food {
	public String name;		// instance field/ attribute
	private int level;		// instance field/ attribute
	
	Food(String name, int level){
		this.name = name;
		this.level = level;
	}
	
	void printInfo(){
		System.out.println(
				name + ": " + level);
	}
	
	int getLevel(){
		return level;
	}
	
}

