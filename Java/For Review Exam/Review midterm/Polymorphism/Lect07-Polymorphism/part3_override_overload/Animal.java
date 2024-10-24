package part3_override_overload;

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
	
	/*
	 * Use over load to minimize the code
	 */
	public final void greeting(String msg){
		greeting();
		System.out.println(msg);  // to print additional msg
	}
	
}
	
	


/*
 * Overload method: same name but different signature
 */
/*
public void greeting(String msg){
	System.out.println("I'm " + name);
	System.out.println(msg);  // to print the given msg
}
*/