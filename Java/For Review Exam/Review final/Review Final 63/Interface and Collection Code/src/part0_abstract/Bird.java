package part0_abstract;

public class Bird extends Animal{
	
	public Bird(String color) {
		super("Bird", color);
	}
	
	public void fly() {
		System.out.println("Flying in the sky...");
	}

	@Override
	public void speak() {
		System.out.println("Tweet!");
	}
}
