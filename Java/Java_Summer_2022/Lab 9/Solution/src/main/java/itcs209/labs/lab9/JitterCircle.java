package itcs209.labs.lab9;

import processing.core.PApplet;

import java.math.MathContext;

public class JitterCircle extends  SlidingCircle{

    public  JitterCircle(float x,float y, float radius){
        super(x,y,radius);
    }
public void render(PApplet context){
        super.render(context);
        super.move((float) Math.random()*10,(float) Math.random()*2);
}
}



