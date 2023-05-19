
public class Part3_Factorial {
	public static void main(String[] args) {
		System.out.println("Recursion: " + factorial(5));
		System.out.println("Hard code: " + factorial5());
		System.out.println("Loop: " + factorialLoop(5));
	}

	/*
	
	// No base case
	static int factorial(int n) {
		return n * factorial(n-1);
	}
	*/
	
	
	// correct factorial method
	
	static int factorial(int n) {
		if(n == 1)
			return 1;
		else
			return n * factorial(n-1);
	}

	static int factorial5() {
		return 5 * factorial4();
	}
	static int factorial4() {
		return 4 * factorial3();
	}
	static int factorial3() {
		return 3 * factorial2();
	}
	static int factorial2() {
		return 2 * factorial1();
	}
	static int factorial1() {
		return 1;
	}
	
	static int factorialLoop(int n) {
		int result = 1;
		for(int i = 1; i <= 5; i++) {
			result = result * i;
		}
		return result;
	}

}
