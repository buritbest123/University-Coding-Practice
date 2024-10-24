//Name: Burit Sihabut
//ID: 6488079
//Section: 1

//********************** DO NOT MODIFY EXCEPT WHERE INDICATED **************************//
public abstract class Object3D {
	
	//*** Constants and enum ***//
	public static final double G = 9.8; //Gravitational force (G) = 9.8 m/s^2
	public static final double PI = 3.14;	//Pi 
	public static enum Material {Water, Rubber, Gold, OakWood, Butter, Wax, Soap, Air, Oxygen, Hydrogen, Helium};	//All the material types
	public static final double[] DENSITIES = {1000, 1522, 19320, 760, 911, 961, 801, 1.225, 1.43, 0.08988, 0.1664}; //Corresponding densities
	
	//Class variables
	private Material matType = null;	//Material of this Object3D
	private String name = null;			//Name of this Object3D
	
	//Constructor
	public Object3D(String _name, Material _matType)
	{
		this.name = _name;
		this.matType = _matType;
	}
	
	//Return the material type
	public Material getMaterial()
	{
		return this.matType;
	}
	
	//Return the name
	public String getName()
	{
		return this.name;
	}
	
	//Cool way to display this Object3D
	public String toString()
	{
		return "["+name+"("+matType.toString()+"), "
				+"V: "+String.format("%,.2f",this.getVolume())+", "
				+"S: "+String.format("%,.2f",this.getSurface())+", "
				+"M: "+String.format("%,.2f",this.getMass())+", "
				+"PE from 9m Height: "+String.format("%,.2f",this.getDroppingPotentialEngery(9))+", "
				+"CanFloat: "+this.canFloat()+", "
				+"CanFly: "+this.canFly()+"]";
	}
	
	/**
	 * Calculate and return the mass of this Object3D
	 */
	public double getMass() // enum is new Data Type that we create
	{
		//****************** YOUR CODE HERE *************************
		return DENSITIES[this.getMaterial().ordinal()] * this.getVolume(); // mass = density * volume
		//***********************************************************//    // enum has ordinal() Method
	} 																	   // It can return the position of a constant starting with zero.
	
	/**
	 * Calculate and return the PE from dropping this Object3D from the given height 
	 */
	public double getDroppingPotentialEngery(double height) // Calculate and return the PE from dropping this Object3D from the given height.
	{
		//****************** YOUR CODE HERE *************************//
		return this.getMass() * Object3D.G * height;  // PE (potential energy) = mass * G (That already constant in Line 10) * height (parameter)
		//***********************************************************//
	}
	
	/**
	 * Return true of this Object3D can float on water; false otherwise.
	 */
	public boolean canFloat() // Return true of this Object3D can float on water; false otherwise.
	{
		//****************** YOUR CODE HERE *************************//
		if(DENSITIES[this.getMaterial().ordinal()] < DENSITIES[Material.Water.ordinal()]){ // Any Object.DENSITIES less than water density return true else false
			return true;
		}
		return false;
		//***********************************************************//
	}
	
	/**
	 * Return true of this Object3D can fly in the air; false otherwise.
	 */
	public boolean canFly() // Return true of this Object3D can fly in the air; false otherwise.
	{
		//****************** YOUR CODE HERE *************************//
		if(DENSITIES[this.getMaterial().ordinal()] < DENSITIES[Material.Air.ordinal()]){ // Any Object.DENSITIES less than air density return true else false
			return true;
		}
		return false;
		//***********************************************************//
	}
	
	//Abstract Methods
	public abstract double getVolume();	//Calculate and return the volume of this object
	public abstract double getSurface(); //Calculate and return the surface area of this object
}