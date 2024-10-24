import java.util.Arrays;

public class Part6_InsertionSort {

	public static void main(String[] args) {
		int[] a = {9, 7, 8, 5, 2, 4, 6, 3, 1};
		System.out.println("Unsorted Array");
		System.out.println(Arrays.toString(a));
		insertionSort(a);
		System.out.println("Sorted Array");
		System.out.println(Arrays.toString(a));
	}

	/**
	 * Based on technique of card players to arrange a hand
	 * - Player keeps cards picked up so far in sorted order
	 * - When the player picks up a new card, makes room for the new card
	 * - Then inserts it in its proper place
	 * @param array of integer
	 */
	public static void insertionSort(int[] a) {
		int n = a.length;
		
		for(int sorted = 0; sorted < n - 1; sorted++) {
			int i = sorted + 1;
			int temp = a[i];		// new element
			
			System.out.println("Next element: " + temp);
			
			// make room for the new element
			// by shifting element in the sorted order to the right, 
			// until the proper place is found
			while(i > 0 && temp < a[i - 1]) {
				System.out.println("compare with " + a[i - 1]);
				a[i] = a[i - 1];
				i--;
			}
			
			// insert new element at the right place
			a[i] = temp;
			System.out.println(Arrays.toString(a));
		}
		
	}
	
}
