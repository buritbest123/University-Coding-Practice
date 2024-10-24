package step2_constructor;

public class Cat {
	String name;
	String color;
	int hungry;
	
	/*
	 * Define a constructor method with 3 parameters
	 */
	Cat(String name, String color, int hungry){
		this.name = name;		// "this." is required because 
								// the names of the parameter and 
								// the attribute are the same.
		
		this.color = color;		// "this." is required
		this.hungry = hungry;	// "this." is required
	}
	
	void greeting(){
		System.out.println(
		 "Meow! " + this.name);	// "this." is no required 
								// since no duplicate variable name
	}
	
}

