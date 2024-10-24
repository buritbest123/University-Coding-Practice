package step3_private;

public class CatTester {
	public static void main(String[] args){
		
		Cat c1 = new Cat("Silver", "gray", 10);
		
		// access "public" instance field
		// using objectname.instancefiledname
		// correct... yea!
		System.out.println(c1.name);
		System.out.println(c1.color);
		
		// access "private" instance field
		// error... boo!
		//System.out.println(c1.hungry);
		
		// have to access through the getter method
		// correct... yea!
		System.out.println(c1.getHungry());
	}
}

