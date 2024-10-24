package part4_overload_constructor;

public class Animal {
	private String name;
	private int hungry, energy;
	public static final int LIVE = 9;
	
	/*
	public Animal(){
		this.name = "n/a"; // default value
		this.hungry = 0;   // default value
		this.energy = 10;  // default value
	}
	
	public Animal(String n){
		this.name = n;
		this.hungry = 0;   // default value
		this.energy = 10;  // default value
	}
	
	public Animal(String n, int h, int e){
		this.name = n;
		this.hungry = h;
		this.energy = e;
	}
	
	*/
	
	public Animal(){
		this("n/a");
	}
	
	public Animal(String n){
		this(n, 0, 10);
	}
	
	public Animal(String n, int h, int e){
		this.name = n;
		this.hungry = h;
		this.energy = e;
	}
	
	void display(){
		System.out.println("Name: " + this.name);
		System.out.printf("Hungry (%d), Energy (%d)\n", hungry, energy);
	}
	
	public String getName(){
		return this.name;
	}
	
	public void greeting(){
		System.out.println("I'm " + name);
	}
	
	/*
	 * Overload method: same name but different signature
	 */
	public final void greeting(String msg){
		greeting();
		System.out.println(msg);  // to print additional msg
	}
}

