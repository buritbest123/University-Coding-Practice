import java.util.Arrays;

public class Part5_BubbleSort {

	public static void main(String[] args) {
		int[] a = {7, 8, 5, 2, 4, 6, 3};
		bubbleSort(a);
		System.out.println(Arrays.toString(a));
	}

	/**
	 * Compares adjacent array elements
	 * Exchanges their values if they are out of order
	 * Smaller values bubble up to the top of the array
	 * Larger values sink to the bottom
	 * @param array of integer
	 */
	public static void bubbleSort(int[] a) {
		int n = a.length;	// number of elements
		int pass = 0;		
		boolean exchanges = false;
		
		do {
			exchanges = false;
			for(int i = 0; i < (n - pass - 1); i++) {
				if(a[i] > a[i+1]) {		
					int temp = a[i];
					a[i] = a[i+1];
					a[i+1] = temp;
					exchanges = true;
				}
			}
			pass++;
		} while (exchanges);
	}
}
