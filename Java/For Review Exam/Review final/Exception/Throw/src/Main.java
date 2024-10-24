class Main {
  public static void main(String[] args) {
    try { 
			Circle c1 = new Circle(5); 
			Circle c2 = new Circle(-5); 
			Circle c3 = new Circle(0); 
		} 
	catch (IllegalArgumentException ex) {
		System.out.println(ex);
		} 
		System.out.println("Number of objects created: " + Circle.getNumberOfObjects());
  }
}

