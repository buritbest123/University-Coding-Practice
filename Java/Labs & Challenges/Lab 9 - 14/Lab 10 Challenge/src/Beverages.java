public abstract class Beverages {

    //*** Constants and enum ***//
    public enum drink {Pepsi, Cola, Sprite, Mirinda, Milk, Water}    //All the Beverages types
    public static final double[] pH = {2.13, 2.24, 3.09, 2.53, 7.05, 7.00}; //Corresponding pH

    //Class variables
    public drink drinks;	//drink of this
    public String name;		// New name of this Beverages

    public Beverages(String _name, drink _drink)
    {
        this.name = _name;
        this.drinks = _drink;
    }

    public drink getDrinks(){
        return this.drinks;
    }

    public double getpH(){
        return pH[this.getDrinks().ordinal()];
    }

    public String pH_scale(){
        if (getpH() < 7){
            return "Acidic";
        }else if (getpH() > 7){
            return "Alkaline";
        }else{
            return "Neutral";
        }
    }

    public String toString(){
        return "["+name+"("+drinks.toString()+"), "
                +"pH: "+String.format("%,.2f",this.getpH())+", "
                +"The pH Scale is "+ pH_scale();
    }

    public abstract double makeItNeutral();
}