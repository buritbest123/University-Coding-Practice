package itcs209.labs.lab5;

public class Lab5 {

       /**
    * Create a ICTStudent class in the package 'itcs209.labs.lab5'
    * The ICTStudent class has the following data items and behaviors:
    * -----------------------------------
    *            ICTStudent
    * -----------------------------------
    *  - String ID
    *  - String givenName
    *  - String ln
    *  - int year
    * -----------------------------------
    *  + ICTStudent(String, String, String, int)
    *  + String getStudentID()
    *  + String getFirstName()
    *  + String getLastName()
    *  + int getYear()
    *  + String getCapName()
    *  + String getStudentInfoTSV()
    *  + String getVowels()
    *  + String getShortID()
    *  + void setName(String)
    * -----------------------------------
    * Note:
    * 1. The first 5 behaviors are a constructor and getter methods.
    * 2. getCapName() return the first name and last name (or surname) that have the first characters
    *          in upper case. For example, "thanapon", "noraset" --> "Thanapon Noraset"
    * 3. getStudentInfoTSV() return student ID, first name, last name (or surname), and year separated by a tab.
    *          For example, "4988246\tThanapon\tNoraset\t1"
    * 4. getVowels() return only the vowels from the first name and last name ('a', 'e', 'i', 'o', 'u').
    *          For example, first name: "Thanapon", last name "Noraset" --> "aaooae"
    * 5. getShortID() return the last 3 digits of the student ID.
    * 6. [optional, no unit test, you will have to check your own output (in a main method) or write your own test]
    *    setName(String) changes the first name and last name (or surname), assumed that they are separated by a tab.
    *          For example, "Thanapon\tNoraset" --> "Thanapon", "Noraset"
    *          You can use substring method, but you must not use "split" method.
    *
    * @param ID
    * @param givenName
    * @param ln
    * @param year
    * @return
    */
   public static ICTStudent createStudent(
           String ID, String givenName, String ln, int year) {
       return new ICTStudent (ID, givenName, ln, year);
   }


}
