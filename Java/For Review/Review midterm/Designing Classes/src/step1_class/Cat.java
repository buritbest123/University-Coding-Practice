package step1_class;

public class Cat {
	/*
	 * Instance fields or Instance variables or Attributes
	 */
	String name;
	String color;
	int hungry;
	
	/*
	 * When there is no constructor method provided,
	 * the class has a default constructor
	 * with empty parameter and empty body.
	 * For example, this Cat class has this constructor 
	 *  
	 * public Cat(){
	 * }
	 */
	
	/*
	 * Instance method with no return (void)
	 * To display the greeting message
	 */
	void greeting(){
		System.out.println(
		 "Meow! " + this.name);
	}
}
