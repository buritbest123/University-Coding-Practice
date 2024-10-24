package part2_casting;

public class Animal {
	private String name;
	
	public Animal(String n){
		this.name = n;
	}
	
	public String getName(){
		return this.name;
	}
	
	public void greeting(){
		System.out.println("I'm " + name);
	}
}

