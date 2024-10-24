/*
 * Lab 3 for ITCS209 3/2021
 * Author: 6488057
 */

package itcs209.labs.lab3;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.awt.*;

import static org.junit.jupiter.api.Assertions.*;

public class Lab3Test {

    private void assertEqualsRect(
            int x, int y, int width, int height, Rectangle r,
            String extraMsg) {
        assertEquals(x, r.getX(), "Location X as specified" + extraMsg);
        assertEquals(y, r.getY(), "Location Y as specified" + extraMsg);
        assertEquals(width, r.getWidth(), "Width as specified" + extraMsg);
        assertEquals(height, r.getHeight(), "Height as specified" + extraMsg);
    }


       @Test
   @DisplayName("0. createRectangle20411919")
   public void test_createRectangle20411919() {
       Rectangle r = Lab3.createRectangle20411919();
       this.assertEqualsRect(20, 41, 19, 19, r, "");
   }


       @Test
   @DisplayName("1. buildUnitRectangle")
   public void test_buildUnitRectangle() {
       int x, y;
       Rectangle r;
       int[] xCases = {1, 3, 2, 0};
       int[] yCases = {2, -2, 1, 0};
       for (int i = 0; i < xCases.length; i++) {
           x = xCases[i];
           y = yCases[i];
           r = Lab3.buildUnitRectangle(x, y);
           this.assertEqualsRect(x, y, 1, 1, r, "");
       }
   }


       @Test
   @DisplayName("2. isAtX0Y0")
   public void test_isAtX0Y0() {
       Rectangle r1 = new Rectangle(10, 10, 2000, 2000);
       assertFalse(Lab3.isAtX0Y0(r1), "A rectangle at (10, 10) is not at the origin.");

       Rectangle r2 = new Rectangle(12, 11, 42, 42);
       assertFalse(Lab3.isAtX0Y0(r2), "A rectangle at (12, 11) is not at the origin.");

       Rectangle r3 = new Rectangle(0, 0, 1, 2);
       assertTrue(Lab3.isAtX0Y0(r3), "A rectangle at (0, 0) is at the origin.");
   }


       @Test
   @DisplayName("3. computePerimeter")
   public void test_computePerimeter() {
       int x, y, width, height;
       double perimeter;
       Rectangle r;
       int[] xCases = {1, 3, 2, 0};
       int[] yCases = {2, -2, 1, 0};
       int[] widthCases = {20, 42, 2, 0};
       int[] heightCases = {1, 2, 21, 1000};
       double[] perimeterCases = {42, 88, 46, 2000};
       for (int i = 0; i < perimeterCases.length; i++) {
           x = xCases[i];
           y = yCases[i];
           width = widthCases[i];
           height = heightCases[i];
           perimeter = perimeterCases[i];
           r = new Rectangle(x, y, width, height);
           assertEquals(
                   perimeter, Lab3.computePerimeter(r), 1e-6,
                   "The perimeter must be the same");
       }
   }


       @Test
   @DisplayName("4. getWidthOrHeight")
   public void test_getWidthOrHeight() {
       int x, y, width, height;
       double result;
       String type;
       Rectangle r;
       int[] xCases = {1, 3, 2, 0, -10};
       int[] yCases = {2, -2, 1, 0, 4};
       int[] widthCases = {20, 42, 2, 0, 10};
       int[] heightCases = {1, 2, 21, 1000, 15};
       String[] typeCases = {"w", "W", "h", "H", ""};
       double[] resultCases = {20, 42, 21, 1000, Double.NEGATIVE_INFINITY};
       for (int i = 0; i < xCases.length; i++) {
           x = xCases[i];
           y = yCases[i];
           width = widthCases[i];
           height = heightCases[i];
           result = resultCases[i];
           type = typeCases[i];
           r = new Rectangle(x, y, width, height);

           assertEquals(
                   result, Lab3.getWidthOrHeight(r, type), 1e6,
                   "Get dimension: " + type + " should return " + result);
       }
   }


       @Test
   @DisplayName("5. isSameArea")
   public void test_isSameArea() {
       Rectangle r1, r2;

       r1 = new Rectangle(0, 0, 5, 5);
       r2 = new Rectangle(0, 0, 5, 5);
       assertEquals(
               true, Lab3.isSameArea(r1, r2),
               r1 + " and " + r2 + " have the same area.");
       r1 = new Rectangle(0, 0, 1, 5);
       r2 = new Rectangle(0, 0, 5, 1);
       assertEquals(
               true, Lab3.isSameArea(r1, r2),
               r1 + " and " + r2 + " have the same area.");
       r1 = new Rectangle(0, 0, 6, 1);
       r2 = new Rectangle(0, 0, 2, 3);
       assertEquals(
               true, Lab3.isSameArea(r1, r2),
               r1 + " and " + r2 + " have the same area.");
       r1 = new Rectangle(0, 0, 1, 5);
       r2 = new Rectangle(0, 0, 5, 5);
       assertEquals(
               false, Lab3.isSameArea(r1, r2),
               r1 + " and " + r2 + " does not have the same area.");
   }


       @Test
   @DisplayName("6. move41R")
   public void test_move41R() {
       int x, y, width, height;
       Rectangle r, target;
       int[] xCases = {1, 3, 2, 0, -10};
       int[] yCases = {2, -2, 1, 0, 4};
       int[] widthCases = {20, 42, 2, 0, 10};
       int[] heightCases = {1, 2, 21, 1000, 15};
       for (int i = 0; i < xCases.length; i++) {
           x = xCases[i];
           y = yCases[i];
           width = widthCases[i];
           height = heightCases[i];
           r = new Rectangle(x, y, width, height);
           Lab3.move41R(r);
           this.assertEqualsRect(x + 41, y, width, height, r, " (r is changed)");
       }
   }


       @Test
   @DisplayName("7. setXYTo")
   public void test_setXYTo() {
       int x, y, width, height;
       Rectangle r, target;
       int[] xCases = {1, 3, 2, 0, -10};
       int[] yCases = {2, -2, 1, 0, 4};
       int[] widthCases = {20, 42, 2, 0, 10};
       int[] heightCases = {1, 2, 21, 1000, 15};
       for (int i = 0; i < xCases.length; i++) {
           x = xCases[i];
           y = yCases[i];
           width = widthCases[i];
           height = heightCases[i];
           r = new Rectangle(10, 15, width, height);
           target = new Rectangle(x, y, width, height);
           Lab3.setXYTo(r, target);
           this.assertEqualsRect(x, y, width, height, r, " (r is changed)");
           this.assertEqualsRect(x, y, width, height, target, " (target is unchanged)");
       }
   }


       @Test
   @DisplayName("8. resizeWithCopy")
   public void test_resizeWithCopy() {
       int x, y, width, height, dw, dh;
       Rectangle r, target;
       int[] xCases = {1, 3, 2, 0, -10};
       int[] yCases = {2, -2, 1, 0, 4};
       int[] dwCases = {1, 0, -2, 0, 10};
       int[] dhCases = {1, 0, 1, -3, 4};
       int[] widthCases = {20, 42, 2, 0, 10};
       int[] heightCases = {1, 2, 21, 1000, 15};
       for (int i = 0; i < xCases.length; i++) {
           x = xCases[i];
           y = yCases[i];
           width = widthCases[i];
           height = heightCases[i];
           dw = dwCases[i];
           dh = dhCases[i];
           r = new Rectangle(x, y, width, height);
           target = Lab3.resizeWithCopy(r, dw, dh);
           this.assertEqualsRect(
                   x, y, width, height, r, " (r is unchanged)");
           this.assertEqualsRect(
                   x, y, width + dw, height + dh, target, " (new rectangle)");
       }
   }



}
