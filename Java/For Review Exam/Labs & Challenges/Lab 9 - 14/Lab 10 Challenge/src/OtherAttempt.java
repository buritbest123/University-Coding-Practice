public class OtherAttempt extends FirstAttempt implements Adjust_pH {
    private double pH;

    public OtherAttempt(String _name, drink _drink, double pH) {
        super(_name, _drink, pH);
        this.pH = pH;
    }

    public double increase_pH() {
        return ++this.pH;
    }

    @Override
    public String pH_scale(){
        if (this.pH < 7){
            return "Acidic";
        }else if (this.pH > 7){
            return "Alkaline";
        }else{
            return "Neutral";
        }
    }

    @Override
    public String toString(){
        return "["+name+"("+drinks.toString()+"), "
                +"pH: "+String.format("%,.2f",this.increase_pH())+", "
                +"The pH Scale is "+ pH_scale();
    }
}

