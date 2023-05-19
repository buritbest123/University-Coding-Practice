package step5_parameter;

public class Cat {
	public String name, color;
	private int hungry;
	
	Cat(String name, String color, int hungry){
		this.name = name;
		this.color = color;
		this.hungry = hungry;
	}
	
	/*
	 * instance method with one parameter (primitive type)
	 * This method changes the hungry level (instance field)
	 */
	void feed(int level){
		hungry = hungry - level;
	}
	
	void greeting(){
		System.out.println("Meow! " + this.name);
	}
	
	int getHungry(){
		return this.hungry;
	}
}

