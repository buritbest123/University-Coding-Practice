package part0_abstract;

public class Dog extends Animal{
	
	public Dog(String color) {
		super("Dog", color);
	}
	
	public void catching() {
		System.out.println("Catching frisbee");
	}

	@Override
	public void speak() {
		System.out.println("Bark!");
	}
	
}
