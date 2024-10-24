
public class Part1_Stack {
	
	public static void main(String[] args) {
		// Stack overflow error
		func();
		
		/*
		System.out.println("Start-Main");
		printA();
		System.out.println("End-Main");
		*/
	}
	
	static void printA() {
		System.out.println("Start-A");
		printB();
		System.out.println("End-A");
	}
	
	static void printB() {
		System.out.println("Start-B");
		System.out.println("End-B");
	}
	
	static void printC() {
		System.out.println("Start-C");
		System.out.println("End-C");
	}
	
	static void func() {
		func();
	}
}
