// Name: Burit Sihabut
// ID: 6488079
// Section: 1

public class BottleOfMilk extends Item{

	private double originalVolume = 0;		//ml
	private double currentVolume = 0;
	
	public BottleOfMilk(double _purchasePrice, double _age, double weight, double _volume) {
		super(_purchasePrice, _age, weight);
		originalVolume = _volume;
		currentVolume =originalVolume;
	}

	@Override
	public double getCurrentValue() { // The current value of a bottle of milk is proportionate to its
		// current volume. Let V0 and V be the original volume and current volume, respectively.
		double C = super.getPurchasePrice() * (currentVolume / originalVolume);
		return C;
	}
	
	@Override
	public String toString()
	{
		return "[Milk"+": Value = "+String.format( "%.2f", this.getCurrentValue())+" Baht, Milk left = "+getVolume()+" ml]";
	}
	
	public void drink(double vol)
	{
		System.out.println("Drinking "+vol+" ml of milk");
		currentVolume -= vol;
		if(currentVolume < 0) currentVolume = 0;
	}
	
	@Override
	public double getWeight()
	{
		return super.getWeight() * (currentVolume / originalVolume);
	}
	
	public double getVolume()
	{
		return currentVolume;
	}
	
	public BottleOfMilk clone() // This method creates and returns a “deep” clone of this bottle of milk.
	{
		//Your Code Goes Here
		BottleOfMilk b = new BottleOfMilk(this.getPurchasePrice(), this.getAge(), this.getWeight(), this.getVolume());
		b.originalVolume = this.getVolume();
		return b;
	}
}
