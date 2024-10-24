package itcs209.labs.lab9;

import processing.core.PApplet;

public class SlidingCircle extends StandingCircle {
    private float move1;
    private float move2;
       SlidingCircle(float x, float y, float radius){
        super(x,y,radius);
        this.move1= x;
        this.move2= y;
    }
    public void render(PApplet context){
           super.move(2,2);
           super.render(context);
       }




}
