package part0_recall;

public class Bird extends Animal{
	
	public Bird(String color) {
		super("Bird", color);
	}
	
	public void fly() {
		System.out.println("Flying in the sky...");
	}
}
