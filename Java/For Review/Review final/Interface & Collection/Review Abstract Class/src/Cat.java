public class Cat extends Animal{ // subclass is "Cat" and superclass is "Animal"

	public Cat(String color) { // constructor method "parameter is data type String named color"
		super("Cat", color);
	}
	
	public void chase() { // method void only do when main use this method no return named "chase"
		System.out.println("Chasing mouse >>>");
	}

  // Subclass HAS TO implement an abstract method from the superclass
	public void speak() {
		System.out.println("Meow!");
	}
}
