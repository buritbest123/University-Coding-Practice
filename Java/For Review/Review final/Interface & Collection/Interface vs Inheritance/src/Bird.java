public class Bird extends Animal implements Skyability{
	
	public Bird(String color) {
		super("Bird", color);
	}
	
	
	@Override
	public void speak() {
		System.out.println("Tweet!");
	}


	@Override
	public void fly() {
		System.out.println("Flying with wings");
	}

}
