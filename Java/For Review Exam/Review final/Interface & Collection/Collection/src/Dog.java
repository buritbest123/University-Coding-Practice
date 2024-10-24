class Dog {
	int age;
	String color;
	
	Dog(int age, String color){
		this.age = age;
		this.color = color;
	}
	
	public String getColor() { 
		return this.color;
	}

  public String toString(){
    return "age: " + age + ", color: " + color;
  }
}

