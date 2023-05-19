public class Dog extends Animal{ // subclass is "Dog" and superclass is "Animal"
	
	public Dog(String color) { // constructor method "parameter is data type String named color"
		super("Dog", color);
	}
	
	public void catching() { // method void only do when main use this method no return named "catching"
		System.out.println("Catching frisbee ^^^");
	}

  // Subclass HAS TO implement an abstract method from the superclass
	public void speak() {
		System.out.println("Bark!");
	}
	
}
