import java.util.Arrays;

public class Part1_Sort_Integer {
	
	public static void main(String[] args) {
		
		int[] items = {5, 2, 4, 1, 3};
		
		Arrays.sort(items, 1, 3); 	// 5, 2, 4, 1, 3
		System.out.println(Arrays.toString(items));
		
		Arrays.sort(items); 		// 1, 2, 3, 4, 5
		System.out.println(Arrays.toString(items));
	}
}

