package itcs209.labs.lab9;

import processing.core.PApplet;
import processing.core.PConstants;

public class Lab9PApplet extends PApplet {
    private StandingCircle c1;
    private SlidingCircle c2;
    private JitterCircle  c3;

    public void setting(){
        size(330,200, PConstants.JAVA2D);
    }

    public void setup( )
    {
        c1 = new StandingCircle(42, 42, 40);
        c2 = new SlidingCircle(42,42,40);
        c3= new JitterCircle(22,22,20);

    }
    public void draw()
    {
        this.background(214, 245, 214);
        c1.render(this);
        c2.render(this);
        c3.render(this);
    }
    }


