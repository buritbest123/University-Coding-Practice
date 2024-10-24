package part0_recall;

public class Cat extends Animal{

	public Cat(String color) {
		super("Cat", color);
	}
	
	public void chase() {
		System.out.println("Chasing mouse >>>");
	}
}
