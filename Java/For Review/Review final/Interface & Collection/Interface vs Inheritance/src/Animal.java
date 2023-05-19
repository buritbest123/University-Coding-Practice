public abstract class Animal {
	public String type;
	public String color;
	
	public Animal(String type, String color){
		this.type = type;
		this.color = color;
	}
		
	public void print() {
		System.out.println(color + " " + type);
	}
	
	public abstract void speak();
}

