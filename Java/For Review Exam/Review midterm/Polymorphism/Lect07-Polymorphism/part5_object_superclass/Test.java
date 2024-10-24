package part5_object_superclass;

public class Test {

	public static void main(String[] agrs){
		Animal a = new Animal("Olaf");
		System.out.println(a.toString());
		
		Animal b = a;
		System.out.println(a.equals(b));
		
		Animal c = new Animal("Olaf");
		System.out.println(a.equals(c));
	}
}

class Animal {	// default extends Object
	public String name;
	
	public Animal(String n){
		this.name = n;
	}
	
	@Override
	public String toString(){
		return "name: " + name;
	}
	
	@Override
	public boolean equals(Object a){
		return name == ((Animal)a).name;
	}
	
}

