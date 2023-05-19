public class FirstAttempt extends Beverages{
    private double pH;

    public FirstAttempt(String _name, drink _drink, double pH) {
        super(_name, _drink);
        this.pH = pH;
    }

    @Override
    public double makeItNeutral() {
            return this.pH = 7.0;
    }

    @Override
    public String pH_scale(){
        if (pH < 7){
            return "Acidic";
        }else if (pH > 7){
            return "Alkaline";
        }else{
            return "Neutral";
        }
    }

    @Override
    public String toString(){
        return "["+name+"("+drinks.toString()+"), "
                +"pH: "+String.format("%,.2f",this.makeItNeutral())+", "
                +"The pH Scale is "+ pH_scale();
    }
}