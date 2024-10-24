
public class Part4_Summation {
	
	public static int sum(int n){
		System.out.println("start sum " + n);
		if(n == 1){
			System.out.println("terminate at 1");
			return 1;
		}
		else{
			int result = n + sum(n-1);
			System.out.println("end sum " + n + " [" + result + "]");
			return result;
		}
		
	}

	public static void main(String[] args){
		int s = sum(4);
		System.out.println("final " + s);
	}

}
