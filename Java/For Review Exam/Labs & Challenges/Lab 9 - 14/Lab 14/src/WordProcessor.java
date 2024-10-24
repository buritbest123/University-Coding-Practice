import java.util.*;
import java.io.File;
import java.io.FileNotFoundException;

public class WordProcessor {

  /**
   * this method will accept a file name as a parameter, read the textual content in a given file, and return these words in a list of strings. 
   */
	public static ArrayList<String> readFile (String file) throws FileNotFoundException {
    ArrayList<String> words = new ArrayList<>();
		Scanner in = new Scanner(new File(file));
    while(in.hasNext()){
      String word = in.next();
      words.add(word);
    }
		return words;
	}

  /**
   * this method will accept a list of strings and print out all the words separated by commas in one line.  
   */
	public static void printWords(ArrayList<String> words){
    System.out.println(Arrays.toString(words.toArray()));
	}
	
	public static void sort (ArrayList<String>  a) {
    // TODO 1: implement sort method that accepts an array list of string, then sort it in descending order (b comes before a) using one of the sorting algorithms discusses in class.
        printWords(a); // called method "printWords", then put "a" to argument | Original List
        for (int i = 0 ; i < a.size(); i++) { // This nested loop will run every list in ArrayList<String>  a
            for (int j = 0 ; j < a.size() - 1; j++) {
                if (a.get(j).compareTo(a.get(j+1)) < 0) { // Use this compareTo method to compare to each other
                    Collections.swap(a, j+1, j); // Use Collections swap() method | a – The list in which to swap elements. | j + 1 - the index of one element to be swapped. | j – the index of the other element to be swapped.
                    printWords(a); // called method "printWords", then put "a" to argument | Print every word when one swap
                }
            }
        }
    }

  public static void removeDuplicate(ArrayList<String>  a){
    // TODO 2: implement removeDuplicate method that accepts a list of string, then remove all duplicates from the list
    // e.g., if the list has "ink sort make ink sort ink", then the list should be changed to "sort make ink".
    // Note that the result list may not have the same ordering as the original one.
      for (int i = 0 ; i < a.size(); i++) { // This loop run will run to less than i = 0 < size
          String list = a.get(i); // Initialize String named "list" = a.get(i)
          int count = 0; // Initialize int count = 0
          for (String temp : a) { // This For-each loop will run every element in a and create String temp
              if (list.equals(temp)) { // If list equal temp, then count++;
                  count++;
              }
          }
          if (count > 1) { // If count more than 1, then remove it
              a.remove(i);
          }
      }
  }
}