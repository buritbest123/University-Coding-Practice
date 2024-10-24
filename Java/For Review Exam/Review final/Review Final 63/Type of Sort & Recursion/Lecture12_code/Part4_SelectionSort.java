import java.util.Arrays;

public class Part4_SelectionSort {

	public static void main(String[] args) {
		int[] a = {7, 8, 5, 2, 4, 6, 3};
		selectionSort(a);
		System.out.println(Arrays.toString(a));
	}

	/**
	 * Sorts an array in passes
	 * Each pass selects the next smallest element
	 * At the end of each pass, places it where it belongs
	 * @param array of integer
	 */
	public static void selectionSort(int[] a) {
		int n = a.length; 	// number of elements
		
		// For each pass, fill is the first unordered element in the list
		for(int fill = 0; fill < n - 1; fill++) {
			int posMin = fill; 	// set position of the smallest element 
			
			// find the position of the smallest element
			for(int nxt = fill + 1; nxt < n; nxt++) {
				if(a[nxt] < a[posMin]) {
					posMin = nxt;
				}
			}
			
			// place the smallest element where it belongs
			// by swapping it with the first unordered element in the list
			int temp = a[fill];
			a[fill] = a[posMin];
			a[posMin] = temp;
		}
	}
	
}
