package mockexam;
// Name:
// ID:
// Section:

import java.util.ArrayList;

public class ItemTester {
	
	public static void testTask1()
	{
		Book b1 = new Book(500, 3, 4);
		b1.takeNote("Book 1");
		Book b2 = b1.clone();
		b2.takeNote("Book 2");
		System.out.println("Note on B1: "+b1.getNote());
		System.out.println("Note on B2: "+b2.getNote());
				
		BottleOfMilk m1 = new BottleOfMilk(300, 0.1, 3, 300);
		m1.drink(50);
		BottleOfMilk m2 = m1.clone();
		m2.drink(50);
		System.out.println("Milk left in m1: "+m1.getVolume()+" ml");
		System.out.println("Milk left in m2: "+m2.getVolume()+" ml");
	}
	
	public static void testTask2()
	{
		Item[] items = new Item[5];
		
		items[0] = new Book(500, 3, 4);
		((Book)items[0]).takeNote("Science Book");
		
		items[1] = new Book(1350, 4, 5);
		((Book)items[1]).takeNote("OOP Book");
		
		items[2] = new Book(30, 1, 1);
		((Book)items[2]).takeNote("Comic Book");
		
		items[3] = new BottleOfMilk(30, 0.1, 3.5, 350);
		((BottleOfMilk)items[3]).drink(50);
		
		items[4] = new BottleOfMilk(150, 0.2, 6, 600);
		((BottleOfMilk)items[4]).drink(450);
		
		ArrayList<Book> books = ItemTester.getDeepCopyOfBooks(items);
		((Book)items[0]).takeNote(" including Math and Physics");
		
		System.out.println("All books are:");
		for(int i = 0; i < books.size(); i++)
		{
			System.out.println("["+(i+1)+"] "+books.get(i).toString());
		}
		
	}
	
	// implement
	public static ArrayList<Book> getDeepCopyOfBooks(Item[] items)
	{
		// Your Code Goes Here
		ArrayList<Book> list = new ArrayList<Book>();
		for(Item temp: items){
			if(temp instanceof Book)
				list.add((Book) temp.clone());
		}
		return list;
	}
	
	public static void main(String[] args)
	{
		testTask1();
		testTask2();
	}
}
