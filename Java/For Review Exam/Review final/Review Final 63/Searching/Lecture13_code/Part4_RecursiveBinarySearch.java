
public class Part4_RecursiveBinarySearch {
	
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
	
	public static int bsearch(int[] list, int target){     
		return bsearch(list, target, 0, list.length - 1); 	
	}  	
	
	public static int bsearch(
			int[] list, int target, int low, int high) { 		
		if( low <= high ){ 			
			int mid = low + ((high - low) / 2); 			
			if( list[mid] == target ) 				
				return mid; 			
			else if( list[mid] < target )   // right 	
				return bsearch(list, target, mid + 1, high);	
			else							// left 				
				return bsearch(list, target, low, mid - 1); 	 	
		} 		
		return -1; 	
	}
	
}
