public class Sphere extends Object3D{
    private double radius; // initialization "radius"

    public Sphere(String _name, Material _matType, double _radius) // Constructor
    {
        super(_name, _matType); // super class' constructor from Object3D
        this.radius = _radius; // initializes radius by equal (==) _radius
    }

    public double getRadius() // method "getRadius"
    {
        return this.radius; // return radius
    }

    @Override
    public double getVolume() // abstract method "getVolume"
    { //Be careful about decimal at first I used integer (4 / 3)
        return  4.00 / 3.00 * Object3D.PI * Math.pow(getRadius(), 3); // volume = 4.00 / 3.00 * PI (That already constant in Object3D Line 11) * radius^3
    }

    @Override
    public double getSurface() // abstract method "getSurface"
    {
        return 4.00 * Object3D.PI * Math.pow(radius, 2); // surface area = 4.00 * PI (That already constant in Object3D Line 11) * radius^2
    }
}
