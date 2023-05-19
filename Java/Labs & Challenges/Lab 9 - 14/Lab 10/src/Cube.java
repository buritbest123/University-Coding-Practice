public class Cube extends Object3D{
    private double edge;

    public Cube(String _name, Object3D.Material _matType, double _edge) // Constructor
    {
        super(_name, _matType); // super class' constructor from Object3D
        this.edge = _edge; // initializes edge by equal (==) _edge
    }

    public double getEdge() // method "getEdge"
    {
        return this.edge; // return edge
    }

    @Override
    public double getVolume() // abstract method "getVolume"
    {
        return Math.pow(edge,3); // volume = edge^3
    }

    @Override
    public double getSurface() // abstract method "getSurface"
    {
        return 6 * Math.pow(edge,2); // surface area = 6 * edge^2
    }
}
