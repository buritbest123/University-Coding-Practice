/**
 * Author: 6488057
 */
package itcs209.labs.lab6;

import java.util.ArrayList;
import java.util.Arrays;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class Lab6Test {

       @Test
   @DisplayName("1. createFruitArray")
   void testCreateFruitArray() {
       String[] fs = Lab6.createFruitArray();
       assert fs != null;
       assertTrue(fs.length >= 3, "fruit array must have more than 2 elements.");
       for (String string : fs) {
           assertNotNull(string, "fruit should not be null.");
           assertNotEquals(0, string.length(), "fruit should not be empty.");
       }
   }

   @Test
   @DisplayName("2. createFruitArrayList")
   void testCreateFruitArrayList() {
       ArrayList<String> fs = Lab6.createFruitArrayList();
       assert fs != null;
       assertTrue(fs.size() >= 3, "fruit array must have more than 2 elements.");
       for (String string : fs) {
           assertNotNull(string, "fruit should not be null.");
           assertNotEquals(0, string.length(), "fruit should not be empty.");
       }
   }

   @Test
   @DisplayName("3. isIndexInBound (Array)")
   void test_isIndexInBound() {
       int[] values = {2, 5, 7, 10, 3};
       assertFalse(Lab6.isIndexInBound(values, -1), "Negative index is out-of-bound.");
       assertFalse(Lab6.isIndexInBound(values, 100), "Index 100 is out-of-bound for an array " + Arrays.toString(values));
       assertTrue(Lab6.isIndexInBound(values, 1), "Index 1 is not out-of-bound for an array " + Arrays.toString(values));
       int[] values2 = {1};
       assertFalse(Lab6.isIndexInBound(values2, 2), "Index 2 is out-of-bound for an array " + Arrays.toString(values2));
       assertFalse(Lab6.isIndexInBound(values2, 1), "Index 1 is out-of-bound for an array " + Arrays.toString(values2));
       assertTrue(Lab6.isIndexInBound(values2, 0), "Index 0 is not out-of-bound for an array " + Arrays.toString(values2));

   }

   @Test
   @DisplayName("4. isIndexInBound (ArrayList)")
   void test_isIndexInBound2() {
       ArrayList<Character> values = new ArrayList<Character>();
       values.add('2');
       values.add('5');
       values.add('7');
       values.add('1');
       values.add('3');
       assertFalse(Lab6.isIndexInBound(values, -10), "Negative index is out-of-bound.");
       assertFalse(Lab6.isIndexInBound(values, 10), "Index 10 is out-of-bound for an array " + values);
       assertFalse(Lab6.isIndexInBound(values, 5), "Index 5 is out-of-bound for an array " + values);
       assertTrue(Lab6.isIndexInBound(values, 3), "Index 3 is not out-of-bound for an array " + values);
       assertTrue(Lab6.isIndexInBound(values, 4), "Index 4 is not out-of-bound for an array " + values);
       ArrayList<Character> values2 = new ArrayList<Character>();
       values2.add('x');
       assertFalse(Lab6.isIndexInBound(values2, 2), "Index 2 is out-of-bound for an array " + values2);
       assertFalse(Lab6.isIndexInBound(values2, 1), "Index 1 is out-of-bound for an array " + values2);
       assertTrue(Lab6.isIndexInBound(values2, 0), "Index 0 is not out-of-bound for an array " + values2);
   }


   @Test
   @DisplayName("5. toArrayList")
   void test_toArrayList() {
       ArrayList<Double> valueList = new ArrayList<Double>();
       valueList.add(2.);
       valueList.add(5.);
       valueList.add(7.);
       valueList.add(10.);
       valueList.add(3.);
       double[] valueArr = {2, 5, 7, 10, 3};
       ArrayList<Double> results = Lab6.toArrayList(valueArr);
       assertEquals(valueList, results);

       ArrayList<Double> valueList2 = new ArrayList<Double>();
       valueList2.add(2.1);
       valueList2.add(.005);
       valueList2.add(3.2);
       double[] valueArr2 = {2.1, .005, 3.2};
       ArrayList<Double> results2 = Lab6.toArrayList(valueArr2);
       assertEquals(valueList2, results2);

   }

   @Test
   @DisplayName("6. convertToArray")
   void test_convertToArray() {
       ArrayList<Double> valueList = new ArrayList<Double>();
       valueList.add(2.);
       valueList.add(5.);
       valueList.add(7.);
       valueList.add(10.);
       valueList.add(3.);
       double[] valueArr = {2, 5, 7, 10, 3};
       double[] results = Lab6.convertToArray(valueList);
       assertArrayEquals(valueArr, results);

       ArrayList<Double> valueList2 = new ArrayList<Double>();
       valueList2.add(2.1);
       valueList2.add(.005);
       valueList2.add(3.2);
       double[] valueArr2 = {2.1, .005, 3.2};
       double[] results2 = Lab6.convertToArray(valueList2);
       assertArrayEquals(valueArr2, results2);

   }


   @Test
   @DisplayName("7. setOddIndicesToZero (Array)")
   void testSetOddElementToZero() {
       double[] valueArr = {2, 5, 7, 10, 3};
       double[] valueArr2 = {2, 0, 7, 0, 3};
       Lab6.setOddIndicesToZero(valueArr);
       assertArrayEquals(valueArr2, valueArr);


       double[] valueArr3 = {0, 1, 2, 3, 4, 5, 6, 7, 8};
       double[] valueArr4 = {0, 0, 2, 0, 4, 0, 6, 0, 8};
       Lab6.setOddIndicesToZero(valueArr3);
       assertArrayEquals(valueArr4, valueArr3);
   }

   @Test
   @DisplayName("8. SetOddElementToZero (ArrayList)")
   void testSetOddElementToZero2() {
       ArrayList<Double> valueList = new ArrayList<Double>();
       valueList.add(2.);
       valueList.add(5.);
       valueList.add(7.);
       valueList.add(10.);
       valueList.add(3.);
       ArrayList<Double> valueList2 = new ArrayList<Double>();
       valueList2.add(2.);
       valueList2.add(0.);
       valueList2.add(0.);
       valueList2.add(10.);
       valueList2.add(0.);
       Lab6.setOddElementToZero(valueList);
       assertEquals(valueList2, valueList);
   }

   @Test
   @DisplayName("9. getRangeArray")
   void test_getRangeArray() {
       int[] results = {0, 1, 2, 3, 4};
       assertArrayEquals(results, Lab6.getRangeArray(0, 5));


       int[] results2 = {-1, 0, 1};
       assertArrayEquals(results2, Lab6.getRangeArray(-1, 2));


       int[] results3 = {2, 3, 4, 5, 6, 7};
       assertArrayEquals(results3, Lab6.getRangeArray(2, 8));


       int[] results4 = {0};
       assertArrayEquals(results4, Lab6.getRangeArray(0, 1));
   }


   @Test
   @DisplayName("10. RemoveEmptyLineInPlace")
   void testRemoveEmptyLineInPlace() {
       ArrayList<String> a = new ArrayList<>();
       a.add("");
       a.add(".");
       a.add("xxkd kdk");
       a.add("");
       a.add("Thanapon");
       ArrayList<String> b = new ArrayList<>();
       b.add(".");
       b.add("xxkd kdk");
       b.add("Thanapon");
       Lab6.removeEmptyLineInPlace(a);
       assertEquals(b, a);

       a = new ArrayList<>();
       a.add(".");
       a.add("");
       a.add(".");
       a.add("xxkd kdk");
       a.add("");
       a.add("Thanapon");
       a.add("");
       a.add("");
       a.add("");
       a.add("");
       b = new ArrayList<>();
       b.add(".");
       b.add(".");
       b.add("xxkd kdk");
       b.add("Thanapon");
       Lab6.removeEmptyLineInPlace(a);
       assertEquals(b, a);

   }


   @Test
   @DisplayName("11. ComputeRange")
   void testComputeRange() {
       double[][] arrs = {
           {0, 1, 2, 3, 4, 5},
           {9, 0, 2, 0, 8, 10},
           {2, 9},
           {-3, 0, 8}
       };
       double[] ranges = {5, 10, 7, 11};
       for (int i = 0; i < ranges.length; i++) {
           double[] inputs = arrs[i];
           double range = ranges[i];
           assertEquals(range, Lab6.computeRange(inputs), "Input: " + Arrays.toString(inputs));
       }
   }

   @Test
   @DisplayName("12.1 ConvertParallelArraysToObjects")
   void testConvertParallelArraysToObjects() {
       String[] courseNames = {"AI"};
       String[] courseIDs = {"ITCS451"};
       double[] scores = {95};
       String[] grades = {"A"};
       ArrayList<Enrollment> enrollments = Lab6.convertParallelArraysToObjects(courseNames, courseIDs, scores, grades);
       for (int i = 0; i < grades.length; i++) {
           assert enrollments != null;
           Enrollment e = enrollments.get(i);
           String courseName = courseNames[i];
           String courseID = courseIDs[i];
           double score = scores[i];
           String grade = grades[i];
           assertEquals(courseName, e.getSubjectTitle(), "Course name at index " + i + " does not match.");
           assertEquals(courseID, e.getCourseID(), "Course ID at index " + i + " does not match.");
           assertEquals(score, e.getScore(), "Score at index " + i + " does not match.");
           assertEquals(grade, e.getLetterGrade(), "Grade at index " + i + " does not match.");
       }
   }

   @Test
   @DisplayName("12.2 ConvertParallelArraysToObjects")
   void testConvertParallelArraysToObjects2() {
       String[] courseNames = {"AI", "OOP", "OS", "ML"};
       String[] courseIDs = {"ITCS451", "ITCS209", "ITCS343", "ITCS517"};
       double[] scores = {95, 100, 86, 89};
       String[] grades = {"A", "A", "B", "B+"};
       ArrayList<Enrollment> enrollments = Lab6.convertParallelArraysToObjects(courseNames, courseIDs, scores, grades);
       for (int i = 0; i < grades.length; i++) {
           Enrollment e = enrollments.get(i);
           String courseName = courseNames[i];
           String courseID = courseIDs[i];
           double score = scores[i];
           String grade = grades[i];
           assertEquals(courseName, e.getSubjectTitle(), "Course name at index " + i + " does not match.");
           assertEquals(courseID, e.getCourseID(), "Course ID at index " + i + " does not match.");
           assertEquals(score, e.getScore(), "Score at index " + i + " does not match.");
           assertEquals(grade, e.getLetterGrade(), "Grade at index " + i + " does not match.");
       }
   }


}
