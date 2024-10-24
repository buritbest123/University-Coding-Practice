/**
 * Author: 6488057
 */

package itcs209.labs.lab4;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class Lab4Test {

      @Test
   @DisplayName("1. createTutle1941")
   void test_createTutle1941() {
       Tutle c = Lab4.createTutle1941("Test", "BBB");
       assertEquals("Test", c.getFirstName());
       assertEquals("BBB", c.getType());
       assertEquals(19.0, c.getWeight(), 1e-5);
       assertEquals(41.0, c.getAge(), 1e-5);
       assertEquals("Test (BBB)", c.explain());

       c = Lab4.createTutle1941("Nor", "AAA");
       assertEquals("Nor", c.getFirstName());
       assertEquals("AAA", c.getType());
       assertEquals(19.0, c.getWeight(), 1e-5);
       assertEquals(41.0, c.getAge(), 1e-5);
       assertEquals("Nor (AAA)", c.explain());
   }

   @Test
   @DisplayName("2. createDefaultTutle")
   void test_createDefaultTutle() {
       Tutle c = Lab4.createDefaultTutle();
       assertEquals("Untitled", c.getFirstName());
       assertEquals("Tutle", c.getType());
       assertEquals(15, c.getWeight(), 1e-5);
       assertEquals(30, c.getAge(), 1e-5);

       c.setWeight(42.2);
       assertEquals(42.2, c.getWeight(), 1e-5, "setWeight works");

       c.setFirstName("Nor");
       assertEquals("Nor", c.getFirstName(), "setFirstName works");

       c.setAge(22.9);
       assertEquals(22.9, c.getAge(), "setAge works");
   }


      @Test
   @DisplayName("3. createHorse511")
   void test_createHorse511() {
       Horse c = Lab4.createHorse511("Test", "BBB");
       assertEquals("Test", c.getFirstName());
       assertEquals("BBB", c.getKind());
       assertEquals(5.0, c.getWeight(), 1e-5);
       assertEquals(11.0, c.getAge(), 1e-5);
       assertEquals("Test (BBB)", c.Signature());

       c = Lab4.createHorse511("Nor", "AAA");
       assertEquals("Nor", c.getFirstName());
       assertEquals("AAA", c.getKind());
       assertEquals(5.0, c.getWeight(), 1e-5);
       assertEquals(11.0, c.getAge(), 1e-5);
       assertEquals("Nor (AAA)", c.Signature());
   }

   @Test
   @DisplayName("4. createDefaultHorse")
   void test_createDefaultHorse() {
       Horse c = Lab4.createDefaultHorse();
       assertEquals("Not Available", c.getFirstName());
       assertEquals("Horse", c.getKind());
       assertEquals(33, c.getWeight(), 1e-5);
       assertEquals(1, c.getAge(), 1e-5);

       c.setWeight(42.2);
       assertEquals(42.2, c.getWeight(), 1e-5, "setWeight works");

       c.setFirstName("Nor");
       assertEquals("Nor", c.getFirstName(), "setFirstName works");

       c.setAge(22.9);
       assertEquals(22.9, c.getAge(), "setAge works");
   }


      @Test
   @DisplayName("5. createCircle2")
   void test_createCircle2() {
       Circle r = Lab4.createCircle2();
       assertEquals(2.0, r.computeArea(), 1e-5);
   }


      @Test
   @DisplayName("6. createEllipse2")
   void test_createEllipse2() {
       Ellipse r = Lab4.createEllipse2();
       assertEquals(2.0, r.area(), 1e-5);
   }

}
