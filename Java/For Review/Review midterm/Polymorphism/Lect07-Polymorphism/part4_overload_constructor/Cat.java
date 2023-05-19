package part4_overload_constructor;

public class Cat extends Animal{
	
	public Cat(){
		super();
		System.out.println("Cat without name");
	}
	
	public Cat(String name){
		this(name, 20, 20);
	}
	
	public Cat(String name, int h, int e){
		super(name, h, e);
		System.out.println("Cat with name");
	}
	
	/*
	 * Override method: same name same signature 
	 * from the superclass (Animal)
	 */
	@Override
	public void greeting(){
		System.out.print("Meow! ");
		super.greeting();
	}
	
	public void chasing(){
		System.out.println("Chasing mouse...");
	}
	
}
