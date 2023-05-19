package part4_overload_constructor;

public class Tester {
	public static void main(String args[]) {
		Animal a1 = new Animal();
		a1.display();
		System.out.println("------------------------");
		
		Animal a2 = new Animal("Olaf");
		a2.display();
		System.out.println("------------------------");
		
		Animal a3 = new Animal("Olaf", 5, 5);
		a3.display();
		System.out.println("------------------------");
		
		
		System.out.println("****** Print CAT ******");
		Cat c1 = new Cat();
		c1.display();
		System.out.println("------------------------");
		
		Cat c2 = new Cat("Elsa");
		c2.display();
		System.out.println("------------------------");
		
		Cat c3 = new Cat("Elsa", 1, 15);
		c3.display();
	}
	
	
}

