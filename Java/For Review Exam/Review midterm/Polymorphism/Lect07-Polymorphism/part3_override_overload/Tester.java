package part3_override_overload;

public class Tester {
	public static void main(String args[]) {
		myPrint(5); 		// call myPrint(   ?   )
		myPrint(5.0); 		// call myPrint(   ?   )
		
		Animal a = new Animal("Olaf");
		a.greeting("Nice to meet you");
		
	}
	
	static void myPrint(int i) { 
		System.out.println("int i = " + i);
	}
	
	static void myPrint(double d) { 
		// Overload: same name, different parameters 
		System.out.println("double d = " + d);
	} 
}

