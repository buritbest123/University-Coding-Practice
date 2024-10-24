public class ButterBall extends Sphere implements Comparable<Object3D>, Meltable { // A ButterBall is a sphere whose material is butter.

    public ButterBall(String _name, double _radius) {
        super(_name, Object3D.Material.Butter, _radius); // super class' constructor from Sphere !no need to initialize _radius because Sphere has 3 parameters right now!.
    }

    @Override
    public int compareTo(Object3D o)
    {
        // ranking the balls by surface areas (ascending)
        if (this.getSurface() < o.getSurface()) {       // If Surface is less than o (other) return -1
            return -1;
        } else if (this.getVolume() > o.getVolume()) {  // else if Surface is more than o (other) return 1
            return 1;
        }

        // The compareTo() method compares two strings lexicographically.
        // Each character of both the strings is converted into a Unicode value for comparison.
        // If the surface areas are equal, break the tie with the !names!
        if (this.getSurface() == o.getSurface()) {
            if (this.getName().compareTo(o.getName()) < 0) {      // If Name is less than o (other) return -1
                return -1;
            } else if (this.getName().compareTo(o.getName()) > 0) { // else if Name is more than o (other) return 1
                return 1;
            } else {
                return 0;                                       // else both Name is equal return 0
            }
            // !!! Can reduction by only return Integer.compare(this.getName().compareTo(o.getName()), 0); !!!
        }
        return 0;
    }

    @Override
    public Object3D convertToOtherShape() // ButterBall from Sphere to Cube
    {
        // Same name (ButterBall) && Same material (Butter) && Same volume
        // Use Math.cbrt() to compute cube root (i.e., Math.cbrt(x) = √𝑥3).
        double new_edge = (Math.cbrt(36 * Object3D.PI) * this.getRadius()) / 3; // volume sphere = ((4*PI*radius)^3)/3 -> volume cube = edge^3
        return new Cube(this.getName(), this.getMaterial(), new_edge);
    }
}