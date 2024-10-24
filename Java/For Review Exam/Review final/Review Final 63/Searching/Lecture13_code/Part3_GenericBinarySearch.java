import java.util.Arrays;

public class Part3_GenericBinarySearch {

	public static void main(String[] args) {
		Product[] list = new Product[5];
		list[0] = new Product("apple", 10);
		list[1] = new Product("apple", 20);
		list[2] = new Product("apple", 30);
		list[3] = new Product("bread", 15);
		list[4] = new Product("bread", 5);
		
		// to make sure that the list is sorted
		Arrays.sort(list);
		for(int i = 0; i < list.length; i++) {
			System.out.println("["+ i + "] " + list[i]);
		}
		
		Product target = new Product("apple", 20);
		int found = bsearch(list, target);
		if(found != -1) 
			System.out.println("Found " + target + " at index " + found 
								+ " -> " + list[found]);
		else
			System.out.println(target + " not found");
		
		target = new Product("bread", 20);
		found = bsearch(list, target);
		if(found != -1) 
			System.out.println("Found " + target + " at index " + found 
								+ " -> " + list[found]);
		else
			System.out.println(target + " not found");
		
	}

	public static int bsearch(Comparable[] list, Comparable target){
		int result = -1; 	
		int low = 0; 		
		int high = list.length - 1; 	
		int mid; 	
		while( result == -1 && low <= high ){	 		
			mid = low + ((high - low) / 2); 		
			if( target.equals(list[mid]) ) 			
				result = mid; 		
			else if(target.compareTo(list[mid]) > 0) 			
				low = mid + 1; 		
			else 			
				high = mid - 1; 	
			} 	
		return result; 
	}

}

class Product implements Comparable<Product> {
	
	public String name;
	public double price;
	
	Product(String n, double p){
		name = n;
		price = p;
	}

	public String toString() {
		return name + "(" + price + ")";
	}
	
	@Override
	public boolean equals(Object o) {
		if(o instanceof Product) {
			Product p = (Product) o;
			return (this.name.equals(p.name)) && (this.price == p.price);
		} else {
			return false;
		}
	}
	
	@Override
	public int compareTo(Product p) {
		
		// check their names first
		int result = this.name.compareTo(p.name);
				// if this name comes before p, result = -1
				// if this name comes after p, result = 1
				// if this name is the same as p, result = 0
		
		if( result == 0 ) {		// same name, continue check price
			if(this.price == p.price)
				result = 0;
			else if(this.price < p.price)
				result = -1;
			else
				result = 1;
		} 

		return result;
	}
	
}
