package step4_static;

public class Cat {
	public String name, color;
	private int hungry;
	
	// "static" keyword to indicate a variable of the class 
	static int objCounter = 0;
	
	// "final" keyword to indicate an unchangeable variable
	final String TYPE = "cat";
	
	// static and final are commonly used together 
	static final int LIVE = 9;
	
	Cat(String name, String color, int hungry){
		this.name = name;
		this.color = color;
		this.hungry = hungry;
		this.objCounter++;		// increase the counter when 
								// an object is created
	}
	
	// "static" keyword to indicate a method of class
	public static void begin(){
		System.out.println("Let's start");
	}
	
	void greeting(){
		System.out.println("Meow! " + this.name);
	}
}

