/**
 * Author: 6488057
 */

package itcs209.labs.lab6;

import java.util.ArrayList;

public class Lab6 {

       /**
    * BEFORE YOU START
    * You will have to create a class Enrollment in this package.
    *       You can design methods, constructors and instance variables,
    *       but it should at least have 4 public methods:
    *          + String getSubjectTitle()
    *          + String getCourseID()
    *          + double getScore()
    *          + String getLetterGrade()
   */

   /**
    * Create an array of fruit names, at least 3 fruits
    * @return
    */
   public static String[] createFruitArray() {
       String[] fruits = {"Banana", "Apple", "Rambutan"};

       return fruits;
   }

   /**
    * Create an array list of fruit names, at least 3 fruits
    * @return
    */
   public static ArrayList<String> createFruitArrayList() {
      ArrayList<String> fruit = new ArrayList<String>();
      fruit.add("Banana");
      fruit.add("Apple");
      fruit.add("Rambutan");

       return fruit;
   }

   /**
    * Check whether the index `i` is in-bound of the array `collection`.
    * @param collection
    * @param i
    * @return true if is in-bound, false if out-of-bound
    */
   public static boolean isIndexInBound(int[] collection, int i){
       if(i<collection.length&&i>=0){
           return true;
       }else {
           return false;
       }

   }

   /**
    * Check whether the index `i` is in-bound of the array `collection`.
    * @param collection
    * @param i
    * @return true if is in-bound, false if out-of-bound
    */
   public static boolean isIndexInBound(ArrayList<Character> collection, int i)
   {
       return (i<collection.size()&&i>=0);


   }

   /**
    * Convert `collection` array to an array list that has the same elements
    * @param collection
    * @return
    */
   public static ArrayList<Double> toArrayList(double[] collection) {
       ArrayList<Double> collect = new ArrayList<Double>();
       for(int i = 0; i < collection.length; i++) {
            collect.add(collection[i]);
       }
       return collect;
   }


   /**
    * Convert `collection` array list to an array that has the same elements
    * @param collection
    * @return
    */
   public static double[] convertToArray(ArrayList<Double> collection) {
       double[] newArray = new double[collection.size()];
       for(int i =0;i<newArray.length;i++){
           newArray[i] = collection.get(i);
       }
       return newArray;
   }


    // OPTIONAL: No unit test
   public static <T> ArrayList<T> convertToArrayListGeneric(T[] collection) {
       return null;
   }


   /**
    * Set the element at odd indices to zero.
    * For example, input: {0, 1, 2, 3, 4}, output: {0, 0, 2, 0, 4}
    * @param collection
    */
   public static void setOddIndicesToZero(double[] collection) {

       for(int i = 0;i<collection.length;i++)
       {
           if(i%2==1)
           {
               collection[i] =0;
           }
       }

   }



    /**
    * Set the element at odd indices to zero.
    * For example, input: {7, 6, 2, 9, 4}, output: {0, 6, 2, 0, 4}
    * (this works with ArrayList, rather than array)
    * @param collection
    */

    
   public static void setOddElementToZero(ArrayList<Double> collection) {
       for (int i = 0; i < collection.size(); i++) {
           //System.out.println(collection.get(i) % 2==1);
           if (collection.get(i) % 2 == 1) {
               collection.set(i,(double)0);
           } else {
               collection.set(i,collection.get(i));
           }
       }
   }

   /**
    * Create an array with the value ranging from a to before the e incrementing 1 at a time.
    * Not including the e
    * For example:
    *      getRangeArray(0, 4) will return {0, 1, 2, 3}
    * @param a
    * @param e
    * @return
    */
   public static int[] getRangeArray(int a, int e)
   {
        int[] value= new int[e-a];
        for(int i=0;i<value.length;i++)
        {
                value[i] = a;
                a++;
        }


       return value;
   }

   // OPTIONAL: No unit test
   public static ArrayList<String> filterEmptyLine(ArrayList<String> lines) {
       return null;
   }

   /**
    * Remove an empty strings out from the array list `lines`
    *
    * An empty string is a string whose length == 0
    *
    * @param lines
    */
   public static void removeEmptyLineInPlace(ArrayList<String> lines) {
       // HINT: See example in Lecture 6, "Index and Size are changing"
       int i=0;
       while (i < lines.size()) {
           String word = lines.get(i);
           if (word.length() == 0) {
               lines.remove(i);
           } else {
               i++;
           }
       }

   }

   /**
    * Compute the range value of the elements in `collection` array.
    *
    * A range is defined as
    *          range = max - min
    *
    */
   public static double computeRange(double[] collection) {
       double max = Double.NEGATIVE_INFINITY;
       double min = Double.POSITIVE_INFINITY;
       for(int i=0;i<collection.length;i++){
           max = Math.max(collection[i],max);
           min = Math.min(collection[i],min);
       }
       return max-min;
   }
   /**
    * Convert the parallel arrays of `names`, `IDs`, `scores`, `grades` to
    * an array list of Enrollment objects.
    *
    * @param names
    * @param IDs
    * @param scores
    * @param grades
    * @return
    */
   public static ArrayList<Enrollment> convertParallelArraysToObjects(
           String[] names, String[] IDs,
           double[] scores, String[] grades) {
       ArrayList<Enrollment> newArrList = new ArrayList<>();
       for(int i =0;i<names.length;i++){
           Enrollment enroll = new Enrollment(names[i],IDs[i],scores[i],grades[i]);
           newArrList.add(enroll);
       }
       return newArrList;
   }

}
