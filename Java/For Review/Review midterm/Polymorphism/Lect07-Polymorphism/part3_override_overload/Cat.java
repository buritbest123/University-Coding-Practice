package part3_override_overload;

public class Cat extends Animal{
	public Cat(String name){
		super(name);
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
	
	/*
	 * Error: cannot override "final" method
	 */
/*
	public void greeting(String msg){
		System.out.print("Meow! ");
		super.greeting(msg);
	}

	*/
	public void chasing(){
		System.out.println("Chasing mouse...");
	}
	
}




