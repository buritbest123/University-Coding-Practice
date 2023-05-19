import java.util.Arrays;

public class Part2_Sort_Person {
	
	public static void main(String[] args) {
		
		Person[] people = new Person[4];
		people[0] = new Person(183);
		people[1] = new Person(185);
		people[2] = new Person(165);
		people[3] = new Person(170);
		
		Arrays.sort(people);
		
		for(Person p: people) {
			System.out.println(p);
		}
	}
}

class Person implements Comparable<Person> {
	public double height;
	
	public Person(double height) {
		this.height = height;
	}
	
	public String toString() {
		return "Height: " + this.height + " cm.";
	}
	
	/**
	 * Compares this object with the specified object for order. 
	 * Returns a negative integer, zero, or a positive integer 
	 * as this object is less than, equal to, or greater than 
	 * the specified object.
	 */
	public int compareTo(Person p) {
		if(this.height == p.height)
			return 0;
		else if(this.height > p.height)
			return 1;
		else
			return -1;
	}
	
}