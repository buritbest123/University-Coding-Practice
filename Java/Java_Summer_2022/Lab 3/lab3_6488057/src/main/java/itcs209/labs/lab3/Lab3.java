/*
 * Lab 3 for ITCS209 3/2021
 * Author: 6488057
 */


package itcs209.labs.lab3;

import java.awt.*;

public class Lab3 {

    // Please see Rectangle documentation here:
    // https://docs.oracle.com/en/java/javase/17/docs/api/java.desktop/java/awt/Rectangle.html

    /**
     * Create a Rectangle object at x = 10 and y = 20
     * having the width of 42 and the height of 21
     *
     * @return a Rectangle object
     */
    public static Rectangle createAnExampleRectangle() {
        return new Rectangle(10, 20, 42, 21);
    }


       /**
    * Create a Rectangle object that locates at x = 20 and y = 41
    * having the width of 19 and the height of 19
    *
    * @return a Rectangle object
    */
   public static Rectangle createRectangle20411919() {return null; }


       /**
    * Create a Rectangle object that has the width and height = 1.0 and
    * locates at x = `q` and y = `y`
    * @param q
    * @param y
    * @return a Rectangle object
    */
   public static Rectangle buildUnitRectangle(int q, int y) {
       return null;
   }


       /**
    * Check whether the Rectangle r's upper-left corner is at origin.
    * The origin is where x = 0 and y = 0
    *
    * @param box
    * @return a boolean
    */
   public static boolean isAtX0Y0(Rectangle box) {
       // Hint: use the accessor methods
       // Rectangle's getX() and getY()
       return false;
   }


       /**
    * Compute the perimeter of the Rectangle r
    *
    * @param r
    * @return perimeter
    */
   public static double computePerimeter(Rectangle r) {
       // Hint: use the accessor methods
       // Rectangle's getX() and getY()
       return 0;
   }


       /**
    * Return the width or the height location based on the axis.
    *
    * If dimensionType is "w" or "W", return width
    * If dimensionType is "h" or "H", return height
    * Otherwise, return negative infinity
    *
    * @param r
    * @param axis
    * @return width or height
    */
   public static double getWidthOrHeight(Rectangle r, String axis) {
       // Hint: use String's equalsIgnoreCase(str)
       // Hint: use Double.NEGATIVE_INFINITY
       return 0;
   }


       /**
    * Check whether the two Rectangle objects have the same areas.
    *
    * @param rectangle1
    * @param s2
    * @return true if same areas
    */
   public static boolean isSameArea(Rectangle rectangle1, Rectangle s2) {
       return false;
   }


       /**
    * Translate the Rectangle r to 41 points to the right
    *
    * @param r
    */
   public static void move41R(Rectangle r) {
       // Hint: use Rectangle's setLocation(x, y) method

   }


       /**
    * Translate the Rectangle r1 to the same location as the Rectangle box2
    *
    * @param r1
    * @param box2
    */
   public static void setXYTo(Rectangle r1, Rectangle box2) {
       // Hint: use Rectangle's setLocation(x, y) method

   }


       /**
    * Return a new Rectangle object that changes the width and height by dw and dh
    * from the Rectangle s
    *
    * @param s
    * @param dw
    * @param dh
    * @return a new Rectangle
    */
   public static Rectangle resizeWithCopy(Rectangle s, int dw, int dh) {
       // Hint: use Rectangle's setSize(width, height) method
       return null;
   }


    /**
     * [Optional] -- Test available in Lab3OptionalTest
     * Return an area of the union of Rectangle r1 and r2
     * Note that the area of the union = area r1 + area r2 - area intersection
     *
     * @param r1
     * @param r2
     * @return area
     */
    public static double computeAreaUnion(Rectangle r1, Rectangle r2) {
        // Hint: use Rectangle's intersection(r) method and union(r) method
        //
        return 0;
    }

    /**
     * [Optional] -- Test available in Lab3OptionalTest
     * Return an area of the rectangle that is the intersection of Rectangle r1 and r2
     *
     * @param r1
     * @param r2
     * @return area
     */
    public static double computeAreaIntersection(Rectangle r1, Rectangle r2) {
        // Hint: use Rectangle's intersection(r) method
        return 0;
    }


    /**
     * [Optional] -- Test available in Lab3OptionalTest
     * Return a new Rectangle object that its width and height are increased by 100% from the
     * Rectangle r
     *
     * @param r
     * @return
     */
    public static Rectangle copyAndDoubleSize(Rectangle r) {
        // Hint: use Rectangle's setSize(width, height) method
        // https://docs.oracle.com/javase/8/docs/api/java/awt/Rectangle.html#setSize-int-int-
        return null;
    }

    /** [Optional] -- Test available in Lab3OptionalTest
     * Return a new Rectangle object that its width and height are reduced by half from the
     * Rectangle r
     *
     * @param r
     * @return
     */
    public static Rectangle copyAndShrinkHalf(Rectangle r) {
        // Hint: use Rectangle's setSize(width, height) method
        // https://docs.oracle.com/javase/8/docs/api/java/awt/Rectangle.html#setSize-int-int-
        return null;
    }

    /**
     * [Optional] -- Test available in Lab3OptionalTest
     * Move the Rectangle r to touch the Rectangle target to the left:
     * - The right border of `r` should touch the `target` left border
     * - The y of `r` should be the same as y of the `target`
     *
     * @param r
     * @param target
     */
    public static void moveToLeft(Rectangle r, Rectangle target) {
        // Hint: use Rectangle's setSize(width, height) method

    }

    /**
     * [Optional] -- Test available in Lab3OptionalTest
     * Move the Rectangle r to touch the Rectangle target to the top:
     * - The x of `r` should be the same as x of the `target`.
     * - The bottom border of `r` should touch the `target` top border
     *
     */
    public static void moveToTop(Rectangle r, Rectangle target) {
        // Hint: use Rectangle's setSize(width, height) method

    }

}
