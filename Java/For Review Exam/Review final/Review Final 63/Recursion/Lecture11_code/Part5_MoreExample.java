
public class Part5_MoreExample {
	
	public static double pow(double a, int n)
	{
	  if (n == 0)
	    return 1.0;
	  else
	    return a * pow(a, n-1);
	}

	public static int f(int x){
	    if(x == 0)
	      return 1;
	    else
	      return x * f(x - 1);
	}	
	
	public static int fib(int n) {
		if (n == 0)
			return 0;
		else if (n == 1)
			return 1;
		else
			return fib(n-1) + fib(n -2);
	}

	public static void main(String[] args) {
		System.out.println("pow(4, 3): " + pow(4, 3));
		
		System.out.println("f(4): " + f(4));
		
		System.out.println("The first 10 members in the Fibonacci series are: ");
		for (int i = 0; i < 10; i++) {
			System.out.print(fib(i) + " ");
		}
	}
}
