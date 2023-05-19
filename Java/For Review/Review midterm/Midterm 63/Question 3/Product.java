//********************************** DO NOT MODIFY THIS FILE ******************************
public class Product {
	private double basePrice = -1;	//Manufacturer's suggested retail price in baht
	private int age = -1;	//How long since this product was released, in months
	
	public Product(double basePrice, int age)
	{
		this.basePrice = basePrice;
		this.setAge(age);
	}
	
	/**
	 * Return the price of this product. Default behavior: simply returns the base price.
	 * @return
	 */
	public double getPrice()
	{
		return this.basePrice;
	}
	
	/**
	 * Set this product's age
	 * @param newAge
	 */
	public void setAge(int newAge)
	{
		this.age = newAge;
	}
	
	/**
	 * Simply returns the age of this product.
	 * @return
	 */
	public int getAge()
	{
		return this.age;
	}

}
