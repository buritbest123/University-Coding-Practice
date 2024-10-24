import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Part5_IndexOf {

	public static void main(String[] args) {
		List<Item> list = new ArrayList<Item>();
		list.add(new Item("apple", 10));
		list.add(new Item("apple", 20));
		list.add(new Item("apple", 30));
		list.add(new Item("bread", 15));
		list.add(new Item("bread", 5));
		
		Item target = new Item("apple", 20);
		System.out.println("Contains target object? " + list.contains(target));
		
		int found = list.indexOf(target);
		if(found != -1) 
			System.out.println("Found " + target + " at index " + found 
								+ " -> " + list.get(found));
		else
			System.out.println(target + " not found");
		
		target = new Item("bread", 20);
		System.out.println("Contains target object? " + list.contains(target));
		
		found = list.indexOf(target);
		if(found != -1) 
			System.out.println("Found " + target + " at index " + found 
								+ " -> " + list.get(found));
		else
			System.out.println(target + " not found");
		
		
	}

}
class Item {
	
	public String name;
	public double price;
	
	Item(String n, double p){
		name = n;
		price = p;
	}

	public String toString() {
		return name + "(" + price + ")";
	}
	
	@Override
	public boolean equals(Object o) {
		if(o instanceof Item) {
			Item p = (Item) o;
			return (this.name.equals(p.name)) && (this.price == p.price);
		} else {
			return false;
		}
	}
}