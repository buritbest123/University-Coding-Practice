public abstract class Animal {

  // instance variables
	private int age;
	static String color = "BLUE";

  // Constructor 1
	public Animal(int age){
		// this.age = age;
		// this.color = "unknown";

    // How to use overloading constructor here
     this(age, "unknown");
	}

  // Constructor 2
	public Animal(int age, String color){
		this.age = age;
		this.color = color;
	}
	
	public void setColor(String newColor){
		color = newColor;
	}
	
	public void setAge(int age){
		this.age = age;
		
	}
	public int getAge(){
		return age;
	}
	
	public String toString(){
		return age + "," + color;
	}

  // Abstract method -> no method body
	public abstract void speak();
}