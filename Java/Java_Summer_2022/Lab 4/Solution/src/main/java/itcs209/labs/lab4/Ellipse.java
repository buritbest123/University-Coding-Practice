package itcs209.labs.lab4;

public class Ellipse {
    private double a;
    private double b;

    public Ellipse(double a, double b) {
        this.a = a;
        this.b = b;
    }

    public double area(){
        double compute =  Math.PI*this.a*this.b;
        return Math.ceil(compute);
    }

}