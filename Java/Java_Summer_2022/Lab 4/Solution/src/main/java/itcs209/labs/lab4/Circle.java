package itcs209.labs.lab4;

public class Circle {
    private double a;

    public Circle(double a) {
        this.a =a;
    }
    public double computeArea(){
        double comArea = Math.pow(a,2)*Math.PI;
        return Math.ceil(comArea);
    }
}
