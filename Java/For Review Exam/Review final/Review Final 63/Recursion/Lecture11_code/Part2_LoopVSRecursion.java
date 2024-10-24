
public class Part2_LoopVSRecursion {
	
	public static void main(String[] args) {
		System.out.println("-- Recursion --");
		recursion(4);
		
		System.out.println("-- Recursion2 --");
		recursion2(4);
	}
	
	
	public static void recursion(int x){
		if(x == 0){
			System.out.println(x);
		} else{
			recursion(x-1);
			System.out.println(x);
		}
	}
	
	public static void recursion2(int x){
		if(x == 0){
			System.out.println(x);
		} else{
			System.out.println(x);
			recursion(x-1);
		}
	}
	
	/*
	public static void loop(int x) {
		for(int i = x; i >= 0; i--) {
			System.out.println(i);
		}
	}
	
	public static void loop2(int x) {
		for(int i = 0; i <= x; i++) {
			System.out.println(i);
		}
	}
	*/
	
}
