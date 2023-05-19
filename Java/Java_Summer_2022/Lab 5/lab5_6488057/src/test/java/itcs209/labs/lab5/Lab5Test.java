package itcs209.labs.lab5;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Lab5Tests {
       @ParameterizedTest(name = "{index}: {0}, {1}, {2}, {3}")
   @CsvSource({
           "4988246, thanapon, noraset, 1",
           "6088222, FIRST,  LAST, 5",
           "4221984, Murakami,  Haruki, 42"
   })
   @DisplayName("1. basicGetters")
   void test_basicGetters(String id, String fname, String lname, int year) {
       ICTStudent s = Lab5.createStudent(id, fname, lname, year);
       assertEquals(id, s.getStudentID(), "student ID does not match.");
       assertEquals(fname, s.getFirstName(), "first name does not match.");
       assertEquals(lname, s.getLastName(), "last name does not match.");
       assertEquals(year, s.getYear(), "year does not match.");
   }

   @ParameterizedTest(name = "{index}: {0}, {1} ==> {2}")
   @CsvSource({
           "thanapon, noraset, Thanapon Noraset",
           "FIRST,  LAST, First Last",
           "Murakami,  Haruki, Murakami Haruki"
   })
   @DisplayName("2. getCapName")
   void test_getCapName(String fname, String lname, String capname) {
       ICTStudent s = Lab5.createStudent("42424242", fname, lname, 0);
       assertEquals(capname, s.getCapName());
   }

   @ParameterizedTest(name = "{index}: {0}, {1}, {2}, {3} ==> {4}")
   @CsvSource({
           "4988246, thanapon, noraset, 1, 4988246\tthanapon\tnoraset\t1",
           "6088222, FIRST,  LAST, 5, 6088222\tFIRST\tLAST\t5",
           "4221984, Murakami,  Haruki, 42, 4221984\tMurakami\tHaruki\t42"
   })
   @DisplayName("3. getStudentInfoTSV")
   void test_getStudentInfoTSV(String id, String fname, String lname, int year, String tsv) {
       ICTStudent s = Lab5.createStudent(id, fname, lname, year);
       assertEquals(tsv, s.getStudentInfoTSV());
   }

   @ParameterizedTest(name = "{index}: {0}, {1} ==> {2}")
   @CsvSource({
           "thanapon, noraset, aaooae",
           "FIRST,  LAST, IA",
           "Murakami,  Haruki, uaaiaui"
   })
   @DisplayName("4. getVowels")
   void test_getVowels(String fname, String lname, String vowels) {
       ICTStudent s = Lab5.createStudent("42424242", fname, lname, 0);
       assertEquals(vowels, s.getVowels());
   }

   @ParameterizedTest(name = "{index}: {0} ==> {1}")
   @CsvSource({
           "4988246, 246",
           "424242,  242",
           "0000000, 000"
   })
   @DisplayName("5. getShortID")
   void test_getShortID(String id, String digits) {
       ICTStudent s = Lab5.createStudent(id, "X", "Y", 0);
       assertEquals(digits, s.getShortID());
   }

}
