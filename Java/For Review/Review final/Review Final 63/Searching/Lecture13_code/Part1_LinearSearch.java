
public class Part1_LinearSearch {

	public static void main(String[] args) {
		int[] nums = {10, 50, 30, 70, 80, 60, 20, 90, 40};
		int target = 20;
		int found = linearSearch(nums, target);
		if(found != -1) 
			System.out.println("Found " + target + " at index " + found);
		else
			System.out.println(target + " not found");
		
		Person[] persons = new Person[5];
		persons[0] = new Person("Alan", 165);
		persons[1] = new Person("Boby", 175);
		persons[2] = new Person("Cathy", 178);
		persons[3] = new Person("Alan", 160);
		persons[4] = new Person("Boby", 173);
		
		Person p = new Person("Boby", 170);
		
		int foundPerson = linearSearch(persons, p);
		if(foundPerson != -1) 
			System.out.println("Found " + p + " at index " + foundPerson 
								+ ":" + persons[foundPerson]);
		else
			System.out.println(p + " not found");
		
	}

	/* 	pre: list != null	post: return the index of the first occurrence
	       	of target in list or -1 if target not present in 
		list
	*/
	public static int linearSearch(int[] list, int target) {
	    for(int i = 0; i < list.length; i++)
	        if( list[i] == target )
	            return i;
	    return -1;
	}
		

	public static int linearSearch(Person[] list, Person target) {
	    for(int i = 0; i < list.length; i++)
	        if( list[i] != null && list[i].equals(target) )
	            return i;
	    return -1;
	}

}


class Person {
	String name;
	double height;
	
	Person(String n, double h){
		name = n;
		height = h;
	}
	
	public boolean equals(Person p) {
		return this.name.equalsIgnoreCase(p.name);
	}
	
	public String toString() {
		return name + "(" + height + "cm)";
	}
}