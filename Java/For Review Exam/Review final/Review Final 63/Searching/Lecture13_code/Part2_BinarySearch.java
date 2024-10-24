
public class Part2_BinarySearch {

	public static void main(String[] args) {
		int[] nums = {2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53};
		
		int found = bsearch(nums, 3);
		if(found != -1) 
			System.out.println("Found 3 at index " + found);
		else
			System.out.println("3 not found");
		
		found = bsearch(nums, 30);
		if(found != -1) 
			System.out.println("Found 30 at index " + found);
		else
			System.out.println("30 not found");
		
	}

	public static int bsearch(int[] list, int target) {
		int result = -1;
		int low = 0;
		int high = list.length - 1;
		int mid;
		while(result == -1 && low <= high) {
			mid = low + ((high - low) / 2);
			System.out.printf("%d, %d, %d compare: %d with %d\n", 
					low, mid, high, list[mid], target);
			if(list[mid] == target)
				result = mid;
			else if(list[mid] < target)
				low  = mid + 1;
			else
				high = mid - 1;
		}
		return result;
	}
}

