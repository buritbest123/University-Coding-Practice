public class Wine extends Product { // Inheritance by extends Product

    // additional private variables:
    private double baseVolume;
    private double actualVolume;

    // implement the constructor
    public Wine(double _basePrice, int _age, double _baseVolume) {
        super(_basePrice,_age); // appropriately calls the superclass’ constructor,
        // set baseVolume and actualVolume to _baseVolume.
        this.baseVolume = _baseVolume;
        this.actualVolume = _baseVolume;
    }

    @Override
    public double getPrice() {
        return super.getPrice() * (this.actualVolume / this.baseVolume) * (1 + 0.05 * super.getAge());
    }

    public void consume(double volume) {
        this.actualVolume -= volume; // Reduce the actualVolume by volume.
    }

}
