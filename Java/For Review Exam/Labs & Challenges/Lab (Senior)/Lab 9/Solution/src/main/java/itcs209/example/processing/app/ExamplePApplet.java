package itcs209.example.processing.app;


import processing.core.PApplet;
import processing.core.PConstants;

public class ExamplePApplet extends PApplet {

    private  int x;

    @Override
    public void settings() {
        size(300, 200, PConstants.JAVA2D);
    }

    @Override
    public void setup() {

    }

    @Override
    public void draw() {
        this.background(51);

        this.fill(255, 0, 0);
        this.strokeWeight(5);
        this.stroke(0, 255, 0);
        this.ellipse(x, 20, 20, 20);
        x++;
        x = x % this.width;
    }

}
