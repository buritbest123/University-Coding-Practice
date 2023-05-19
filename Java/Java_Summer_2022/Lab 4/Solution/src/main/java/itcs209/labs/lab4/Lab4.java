/**
 * Author: 6488057
 */

package itcs209.labs.lab4;

public class Lab4 {
       /**
    * Return a Tutle object with the name and breed as in the arguments.
    * The Tutle object must have the weight of 19 and the age of 41.
    *
    * Steps:
    * 1. Create a new class Tutle at the package itcs209.labs.lab4
    * 2. Instance variables:
    *      2.1 name
    *      2.2 breed
    *      2.3 weight
    *      2.4 age
    * 3. Constructors:
    *      3.1 Tutle(): construct a Tutle object with name, breed, weight, age
    *      3.2 Tutle(): construct a Tutle object with name="Untitled", breed="Tutle", weight="15", age="30"
    * 4. Public methods:
    *      2.1 getFirstName: return name
    *      2.2 getType: return breed
    *      2.3 getWeight: return weight
    *      2.4 getAge: return age
    *      2.5 explain: return "name (breed)"
    *      2.6 setFirstName: return void, but change name
    *      2.7 setWeight: return void, but change weight
    *      2.8 setAge: return void, but change age
    *
    * @param name
    * @param breed
    * @return a Tutle object
    */
   public static Tutle createTutle1941(String name, String breed) {

       return new Tutle(name,breed,19, 41);
   }
        public static Tutle createTutle421(String name, String breed) {

            return new Tutle(name,breed,19, 41);
        }

   /**
    * Return a Tutle object with default data
    *
    * @return a Tutle object
    */
   public static Tutle createDefaultTutle() {
       return new Tutle();
   }


       /**
    * Return a Horse object with the name and breed as in the arguments.
    * The Horse object must have the weight of 5 and the age of 11.
    *
    * Steps:
    * 1. Create a new class Horse at the package itcs209.labs.lab4
    * 2. Instance variables:
    *      2.1 name
    *      2.2 breed
    *      2.3 weight
    *      2.4 age
    * 3. Constructors:
    *      3.1 Horse(): construct a Horse object with name, breed, weight, age
    *      3.2 Horse(): construct a Horse object with name="Not Available", breed="Horse", weight="33", age="1"
    * 4. Public methods:
    *      2.1 getFirstName: return name
    *      2.2 getKind: return breed
    *      2.3 getWeight: return weight
    *      2.4 getAge: return age
    *      2.5 Signature: return "name (breed)"
    *      2.6 setFirstName: return void, but change name
    *      2.7 setWeight: return void, but change weight
    *      2.8 setAge: return void, but change age
    *
    * @param name
    * @param breed
    * @return a Horse object
    */
   public static Horse createHorse421(String name, String breed) {
       return new Horse(name,breed,5,11);
   } public static Horse createHorse$4$21(String name, String breed) {
        return new Horse(name,breed,5,11);
    }

   /**
    * Return a Horse object with default data
    *
    * @return a Horse object
    */
   public static Horse createDefaultHorse() {
       return new Horse();
   }


       /**
    * Return a Circle object that has the area of 2.
    *
    * Steps:
    * 1. Create a new class Circle at the package itcs209.labs.lab4
    * 2. Instance variables:
    *      ... you decide, but they must be private ...
    * 3. Constructors:
    *      ... you decide, but it should take characteristics of the shape ...
    *      For example, a right triangle is characterized by a base and a height
    *          Hint: you can search Google for the characteristics, such as
    *                 "ellipse calc: find Area"
    * 4. Methods:
    *      4.1 computeArea: return area of the object
    *      ... you decide the rest, but this object must be an Immutable object ...
    *
    * @return a Circle object
    */
   public static Circle createCircle2() {
       return new Circle(0.7);
   }


       /**
    * Return a Ellipse object that has the area of 2.
    *
    * Steps:
    * 1. Create a new class Ellipse at the package itcs209.labs.lab4
    * 2. Instance variables:
    *      ... you decide, but they must be private ...
    * 3. Constructors:
    *      ... you decide, but it should take characteristics of the shape ...
    *      For example, a right triangle is characterized by a base and a height
    *          Hint: you can search Google for the characteristics, such as
    *                 "ellipse calc: find Area"
    * 4. Methods:
    *      4.1 area: return area of the object
    *      ... you decide the rest, but this object must be an Immutable object ...
    *
    * @return a Ellipse object
    */
   public static Ellipse createEllipse2() {
       return new Ellipse(4,0.15) ;
   }

}
