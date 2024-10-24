package step3_private;

public class Cat {
	String name;			// public by default
	public String color;	// public access modifier
	private int hungry;		// private access modifier
	
	/*
	 * Constructor method
	 */
	Cat(String name, String color, int hungry){
		this.name = name;
		this.color = color;
		this.hungry = hungry;
	}
	
	/*
	 * Instance method
	 */
	void greeting(){
		System.out.println(
		 "Meow! " + this.name);
	}
	
	/*
	 * Getter method with return type (int)
	 */
	int getHungry(){
		return hungry;
	}
}

