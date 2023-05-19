//******************* DO NOT MODIFY THIS FILE **************************

public abstract class Item {

	private double purchasePrice;	//baht
	private double age;				//years
	private double weight;			//kg
	
	public Item(double _purchasePrice, double _age, double _weight){
		purchasePrice = _purchasePrice;
		age = _age;
		weight = _weight;
	}

	public double getPurchasePrice() {
		return purchasePrice;
	}

	public double getAge() {
		return age;
	}
	
	public double getWeight() {
		return weight;
	}
	
	@Override
	public String toString()
	{
		return "[Item"+": Value "+this.getCurrentValue()+" Baht]";
	}
	
	public abstract double getCurrentValue();
	
	public abstract Item clone();
	
}
