public class Bird extends Animal{
	
	public Bird(String color) {
		super("Bird", color);
	}
	
	public void fly() {
		System.out.println("Flying in the sky...");
	}

  // Subclass HAS TO implement an abstract method from the superclass
	public void speak() {
		System.out.println("Tweet!");
	}
}
