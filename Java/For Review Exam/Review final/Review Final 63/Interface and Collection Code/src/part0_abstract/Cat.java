package part0_abstract;

public class Cat extends Animal{

	public Cat(String color) {
		super("Cat", color);
	}
	
	public void chase() {
		System.out.println("Chasing mouse >>>");
	}
	
	@Override
	public void speak() {
		System.out.println("Meow!");
	}
}
