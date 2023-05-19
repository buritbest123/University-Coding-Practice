# ITCS209 Lab 9: Practicing Basic Inheritance

In this lab, we are going to use [Processing](https://processing.org/) 
as our main framework. You are invited to read "[Getting Started](https://processing.org/tutorials/gettingstarted)" 
before starting the lab. Alternatively, you can see `Example.java` 
and `ExamplePApplet.java` as an example.

You will implement 3 classes:

- A sliding circle that will constantly move.
- A standing circle that will not move unless ordered to do so.
- A jitter circle that will constantly move and shake.

## How to run?
Find the main method and then click on the green "Play" button.

## Instructions

### Step 1: Designing the hierarchy

Please draw a class hierarchy diagram (only class names) on a 
piece of paper. You will need to bring this to the instructor.

### Step 2: Getting Started
1. Create a subclass of `PApplet` class, named `Lab9PApplet` 
  in the package `itcs209.labs.lab9`. 
  This subclass will *override* the following methods (see `ExamplePApplet`):  
   1. `public void settings()`
   2. `public void setup()`
   3. `public void draw()`
2. Change the background of your `Lab9PApplet` to be other color
  such as red `(255, 0, 0)`, green `(0, 255, 0)` or blue `(0, 0, 255)`.
  Use [W3Schools's Color Picker](https://www.w3schools.com/colors/colors_picker.asp) to help you find the color code.
  You draw function might look like this:
     ```java
     @Override
     public void draw() {
         this.background(214, 245, 214);
     }
     ```
4. Run the main method in `App.java`.
5. Check the color.

### Step 3: Implementing a base class

1. One of the possible base class is the standing circle. Here is the source code:  
      ```java
      package itcs209.labs.lab9;

    import processing.core.PApplet;
    
    public class StandingCircle {
    private float x;
    private float y;
    private float radius;
    
        public StandingCircle(float x, float y, float radius) {
            this.x = x;
            this.y = y;
            this.radius = radius;
        }
    
        public void render(PApplet context) {
            this.wrapSpace(context.width, context.height);
            // fill free to change your own color
            context.fill(255, 0, 0);
            context.stroke(255, 255, 0);
            context.strokeWeight(5);
            context.circle(this.x, this.y, this.radius);
        }
    
        public void move(float dx, float dy) {
            this.x = x + dx;
            this.y = y + dy;
        }
    
        public void setRadius(float radius) {
            this.radius = radius;
        }
    
        public void wrapSpace(int canvasWidth, int canvasHeight) {
            if (x > canvasWidth) {
                this.x = this.x % canvasWidth;
            }
            if (y > canvasHeight) {
                this.y = this.y % canvasHeight;
            }
        }
    }

      ```
2. Create an instance variable of the `StandingCicle` in the `Lab9PApplet` class.
      ```java
    private StandingCircle c1;
      ```
3. Construct the object in the `setUp()` method:
      ```java
   c1 = new StandingCircle(42, 42, 40);
      ```
4. Render the object in the `draw()` method:
      ```java
    c1.render(this);
      ```
5. Run your code.


### Step 4: Designing a class

1. You now have the base classes for the other classes: the sliding circle and the jitter circle.
2. On a paper, draw two class diagrams of the two classes.
3. Consult with your TA before you implement the classes!

Hint: You will need to override some methods.

### Step 5 

1. Implement the classes.
2. Add the sliding circle and the jitter circle in `Lab9PApplet`.
      ```java
   private StandingCircle c1;
   private _____ c2;
   private _____ c3;
      ```
3. Construct the two objects in the `setUp()` method:
      ```java
   c1 = new StandingCircle(42, 42, 40);
   c2 = new ______________________;
   c3 = new ______________________;
      ```
4. Render the two objects in the `draw()` method:
      ```java
    c1.render(this);
    c2.render(this);
    c3.render(this);
      ```
5. Run your code.

## Submission

Once your code work (see the example in the video above), you can submit your work 
on MyCourses

1. You will have to submit 4 java files
   1. Lab9PApplet.java
   2. StandingCircle.java
   3. ______.java (the sliding circle)
   4. ______.java (the jitter circle)
2. Bring your paper to Nor or Prach to get your lab score.
3. Do the Lab 9 Review.