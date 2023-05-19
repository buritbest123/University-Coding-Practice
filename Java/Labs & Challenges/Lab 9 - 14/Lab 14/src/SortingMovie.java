import java.util.ArrayList;
import java.util.Collections;

public class SortingMovie {
	static int count = 0; // create static variable named "count", then assign = 0
	public static void main(String[] args) {
		ArrayList<Movie> movieList = new ArrayList<Movie>();
		movieList.add(new Movie(1, "The Intern", 2009));
		movieList.add(new Movie(2, "The Gift", 2009));
		movieList.add(new Movie(3, "The Lost Room", 2009));
		movieList.add(new Movie(4, "The Gift", 2012));
		movieList.add(new Movie(5, "Pasolini", 2012));
		movieList.add(new Movie(6, "The Intern", 2009));
		movieList.add(new Movie(7, "American Ultra", 2019));
		movieList.add(new Movie(8, "Sweet Red Bean Paste", 2019));
		
		sort(movieList);
	}
	
	public static void sort (ArrayList<Movie>  movies) {
		// YOUR CODE GOES HERE
		System.out.println("== sorted movie list (ascending) ==");
		for (int i = 0 ; i < movies.size(); i++) // This nested loop will run every list in ArrayList<String>  movies
		{
			for (int j = 0 ; j < movies.size()-1; j++)
			{
				if (movies.get(j).compareTo(movies.get(j+1)) > 0) // Use this compareTo method to compare to each other
				{
					Collections.swap(movies, j, j+1); // Use Collections swap() method | movies – The list in which to swap elements. | j + 1 - the index of one element to be swapped. | j – the index of the other element to be swapped.
				}
			}
		}
		for (Movie movie : movies)
		{
			System.out.println(movie);
		}
	}
}