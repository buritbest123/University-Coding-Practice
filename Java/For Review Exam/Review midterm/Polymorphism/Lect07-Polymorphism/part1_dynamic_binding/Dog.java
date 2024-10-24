package part1_dynamic_binding;

public class Dog extends Animal{

	public Dog(String name) {
		super(name);
	}
	
	@Override
	public void greeting(){
		System.out.print("Bark! ");
		super.greeting();
	}
	
	public void catching(){
		System.out.println("Catching frisbee...");
	}

}
