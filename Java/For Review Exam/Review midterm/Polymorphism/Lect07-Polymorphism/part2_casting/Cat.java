package part2_casting;

public class Cat extends Animal{
	public Cat(String name){
		super(name);
	}
	
	@Override
	public void greeting(){
		System.out.print("Meow! ");
		super.greeting();
	}
	
	public void chasing(){
		System.out.println("Chasing mouse...");
	}
	
}
