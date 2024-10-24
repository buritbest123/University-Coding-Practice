/*
 * Lab 3 for ITCS209 3/2021
 * Author: 6488057
 */

package itcs209.labs.lab3;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.awt.*;

import static org.junit.jupiter.api.Assertions.*;

public class Lab3OptionalTest {

    private void assertEqualsRect(
            int x, int y, int width, int height, Rectangle r,
            String extraMsg) {
        assertEquals(x, r.getX(), "Location X as specified" + extraMsg);
        assertEquals(y, r.getY(), "Location Y as specified" + extraMsg);
        assertEquals(width, r.getWidth(), "Width as specified" + extraMsg);
        assertEquals(height, r.getHeight(), "Height as specified" + extraMsg);
    }

    @Test
    @DisplayName("computeAreaUnion")
    public void computeAreaUnion() {
        int x, y, width, height;
        double area;
        Rectangle r;
        Rectangle r2 = new Rectangle(0, 0, 10, 10);
        int[] xCases = {1, 3, 1, 0};
        int[] yCases = {1, -2, 2, 0};
        int[] widthCases = {10, 42, 20, 0};
        int[] heightCases = {10, 2, 1, 1000};
        double[] areaCases = {119.0, 184.0, 111.0, 100.0};
        for (int i = 0; i < areaCases.length; i++) {
            x = xCases[i];
            y = yCases[i];
            width = widthCases[i];
            height = heightCases[i];
            area = areaCases[i];
            r = new Rectangle(x, y, width, height);
            assertEquals(
                area, Lab3.computeAreaUnion(r, r2), 1e-6,
                "Case " + i + ": The area must be the same for " + r + " and " + r2);
        }
    }

    @Test
    @DisplayName("computeAreaIntersection")
    public void computeAreaIntersection() {
        int x, y, width, height;
        double area;
        Rectangle r;
        Rectangle r2 = new Rectangle(0, 0, 10, 10);
        int[] xCases = {1, 3, 1, 0};
        int[] yCases = {1, -2, 2, 0};
        int[] widthCases = {10, 42, 20, 0};
        int[] heightCases = {10, 2, 1, 1000};
        double[] areaCases = {81.0, 0.0, 9.0, 0.0};
        for (int i = 0; i < areaCases.length; i++) {
            x = xCases[i];
            y = yCases[i];
            width = widthCases[i];
            height = heightCases[i];
            area = areaCases[i];
            r = new Rectangle(x, y, width, height);
            assertEquals(
                    area, Lab3.computeAreaIntersection(r, r2), 1e-6,
                    "Case " + i + ": The area must be the same for " + r + " and " + r2);
        }
    }

    @Test
    @DisplayName("copyAndDoubleSize")
    public void copyAndDoubleSize() {
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
            Rectangle newR = Lab3.copyAndDoubleSize(r);
            this.assertEqualsRect(x, y, width, height, r, " (r is unchanged)");
            this.assertEqualsRect(x, y, width * 2, height * 2, newR, " (the return rectangle is double in size)");
        }
    }

    @Test
    @DisplayName("copyAndShrinkHalf")
    public void copyAndShrinkHalf() {
        int x, y, width, height;
        Rectangle r, target;
        int[] xCases = {1, 3, 2, 0, -10};
        int[] yCases = {2, -2, 1, 0, 4};
        int[] widthCases = {20, 42, 2, 20, 10};
        int[] heightCases = {222, 2, 22, 1000, 10};
        for (int i = 0; i < xCases.length; i++) {
            x = xCases[i];
            y = yCases[i];
            width = widthCases[i];
            height = heightCases[i];
            r = new Rectangle(x, y, width, height);
            Rectangle newR = Lab3.copyAndShrinkHalf(r);
            this.assertEqualsRect(x, y, width, height, r, " (r is unchanged)");
            this.assertEqualsRect(x, y, width / 2, height / 2, newR, " (the return rectangle is shrink in size)");
        }
    }

    @Test
    @DisplayName("moveToLeft")
    public void moveToLeft() {
        int x, y, width, height;
        Rectangle r, target;
        int[] xCases = {1, 3, 2, 0, -10};
        int[] yCases = {2, -2, 1, 0, 4};
        int[] widthCases = {20, 42, 2, 20, 10};
        int[] heightCases = {222, 2, 22, 1000, 10};
        for (int i = 0; i < xCases.length; i++) {
            x = xCases[i];
            y = yCases[i];
            width = widthCases[i];
            height = heightCases[i];
            r = new Rectangle(1, 8, width, height);
            target = new Rectangle(x, y, width, height);
            Lab3.moveToLeft(r, target);
            this.assertEqualsRect(x - width, y, width, height, r, " (r is move to the left.)");
            this.assertEqualsRect(x, y, width, height, target, " (the target rectangle is unchanged.)");
        }
    }

    @Test
    @DisplayName("moveToTop")
    public void moveToTop() {
        int x, y, width, height;
        Rectangle r, target;
        int[] xCases = {1, 3, 2, 0, -10};
        int[] yCases = {2, -2, 1, 0, 4};
        int[] widthCases = {20, 42, 2, 20, 10};
        int[] heightCases = {222, 2, 22, 1000, 10};
        for (int i = 0; i < xCases.length; i++) {
            x = xCases[i];
            y = yCases[i];
            width = widthCases[i];
            height = heightCases[i];
            r = new Rectangle(1, 8, width, height);
            target = new Rectangle(x, y, width, height);
            Lab3.moveToTop(r, target);
            this.assertEqualsRect(x, y - height, width, height, r, " (r is move to the top.)");
            this.assertEqualsRect(x, y, width, height, target, " (the target rectangle is unchanged.)");
        }
    }

}
