package step6_object_parameter;

public class Cat {
	public String name, color;
	private int hungry;
	
	Cat(String name, String color, int hungry){
		this.name = name;
		this.color = color;
		this.hungry = hungry;
	}
	
	void feed(int level){
		hungry = hungry - level;
	}

	/*
	 * Instance method with one parameter (object type)
	 * It changes the hungry level based on 
	 * the level score of the food object "f"
	 */
	void feedFood(Food f){
		hungry = hungry - f.getLevel();
	}
	
	int getHungry(){
		return this.hungry;
	}
}
