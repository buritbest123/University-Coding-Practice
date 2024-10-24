public class WaxDie extends Cube implements Comparable<Object3D>, Meltable { // A WaxDie is a cube whose material is wax.

    public WaxDie(String _name, double _edge)
    {
        super(_name, Object3D.Material.Wax, _edge); // super class' constructor from cube !no need to initialize _edge because Sphere has 3 parameters right now!.
    }

    @Override
    public int compareTo(Object3D o) // If the volumes are equal, break the tie with the names (lexicographically compared, ascending).
    {
        if(this.getVolume() < o.getVolume()) {                   // If Volume is less than o return -1
            return -1;
        }
        else if(this.getVolume() > o.getVolume()) {             // else if Volume is more than o return 1
            return 1;
        }
        // The compareTo() method compares two strings lexicographically.
        // Each character of both the strings is converted into a Unicode value for comparison.
        // If the volume are equal, break the tie with the !names!
        if(this.getVolume() == o.getVolume()) {
            if(this.getName().compareTo(o.getName()) < 0) {    // If Name is less than o return -1
                return -1;
            }
            else if(this.getName().compareTo(o.getName()) > 0){ // else if Name is more than o return 1
                return 1;
            }
            else {
                return 0;                                       // else both Name is equal return 0
            }
            // !!! Can reduction by only return Integer.compare(this.getName().compareTo(o.getName()), 0); !!!
        }
        return 0;
    }

    @Override
    public Object3D convertToOtherShape() // Return a Sphere with the same name, material, and volume.
    {
        // Same name (WaxDie) && Same material (Wax) && Same volume
        // Use Math.cbrt() to compute cube root (i.e., Math.cbrt(x) = √𝑥3).
        double new_radius = (Math.cbrt(6 * Math.pow(Object3D.PI, 2)) * this.getEdge()) / (2 * Object3D.PI); // volume cube = edge^3 -> volume sphere = ((4*PI*radius)^3)/3
        return new Sphere(this.getName(), this.getMaterial(), new_radius);
    }
}
