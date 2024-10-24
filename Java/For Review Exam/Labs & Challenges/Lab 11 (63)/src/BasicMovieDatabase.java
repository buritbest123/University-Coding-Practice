// Student ID:
// Name:
// Section:

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class BasicMovieDatabase {
	
	// DO NOT MOIDIFY THIS 
	public static final String INIT_PATH = Paths.get("").toAbsolutePath().toString() 
			+ File.separator + "init" +  File.separator;

	public Map<Integer, Movie> movies = null;
	
	public static enum OPERATOR {EQ, LT, GT, LTE, GTE};
					// EQ = Equal, LT = Less than, GT = Greater than
					// LTE = Less than or equal, GTE = Greater than or equal
	
	// ---------------------------------------------------------------------
	
	public void importMovies(String movieFilename) {
		movies = new HashMap<Integer, Movie>();
		
		// -------- Using your code from Lab 10 -------------- //
		
	}
	
	
	
	/**
	 * Import movie ratings from text file and update into each specific movie
	 * @param filename
	 */
	public void importRating(String filename) {
		
		
	}
	
	/**
	 * Exporting movie with the valid format 
	 * <mid>,<title>,<tag1>|<tag2>|...|<tagN> and write to the given file
	 * @param filename
	 * @return number of exported movies 
	 */
	public int exportMovies(String filename) {
		// YOUR CODE GOES HERE //
		return 0;
	}
	
	
	/**
	 * If you want to use this method, you can copy your code from lab 10
	 * @param query
	 * @return
	 */
	public List<Movie> searchMovies(String query) {
		
		// -------- Using your code from Lab 10 -------------- //
		return null;
	}
	
	/**
	 * Search movies by the query and the rating
	 * The operator indicate the comparison operator on the rating value
	 * (note. You may reuse the searchMovies method here)
	 * @param query
	 * @param op
	 * @param rating
	 * @return List of movies that satisfied the conditions
	 */
	public List<Movie> searchMoviesWithRating(String query, OPERATOR op, double rating) {
		
		// YOUR CODE GOES HERE //
		return null;
	}
	
	// ********************************************************************************
	// DO NOT MODIFY THIS MAIN METHOD (except to uncomment the bonus part)
	public static void main(String[] args){
		
		BasicMovieDatabase mdb = new BasicMovieDatabase();
		mdb.importMovies(INIT_PATH + "lab10_movies.txt");
		System.out.println("Done importing "+mdb.movies.size()+" movies");
		int[] mids = new int[]{139747, 141432, 139415, 139620, 141305, 140715, 148626};
		
		System.out.println("-- before adding ratings --");
		for(int mid: mids) {
			System.out.println("Retrieving movie ID "+mid+": "+mdb.movies.get(mid));
		}
		
		// Task 1: importing movies rating file and update the movies rating
		System.out.println("-- after adding ratings --");
		mdb.importRating(INIT_PATH + "lab11_ratings.txt");
		for(int mid: mids) {
			System.out.println("Retrieving movie ID "+mid+": "+mdb.movies.get(mid));
			
		}
		
		
		// Task 2: exporting movies into a new file
		System.out.println("-- exporting movies --");
		
		// add two more movies
		mdb.movies.put(999999, new Movie(999999, "Harry Potter"));
		mdb.movies.put(888888, new Movie(888888, "Up"));
		mdb.movies.get(888888).tags.add("Animation");
		
		// export movie into the text file
		try {
			File export = new File(INIT_PATH + "lab11_movies.txt");
			Files.deleteIfExists(export.toPath());
		} catch (IOException e) {
			e.printStackTrace();
		}
		int count = mdb.exportMovies(INIT_PATH + "lab11_movies.txt");
		System.out.println("Done exporting " + count + " movies");
		// The file should contains 50 movies
		
		
		//Uncomment for bonus
		/*
		System.out.println("\n////////////////////////// BONUS ///////////////////////////////");
		double[] ratings = {0.0, 2.5, 4.0};
		String query = "america";
		
		OPERATOR[] ops = {OPERATOR.EQ, OPERATOR.GT, OPERATOR.GTE};
		for(OPERATOR op: ops) {
			for(int i = 0; i < 3; i++) {
				double rating = ratings[i];
				System.out.println("Results for movies that match: ["+query + "] and have rating " + op.toString() + " " + rating);
				for(Movie m: mdb.searchMoviesWithRating(query, op, rating)) {
					System.out.println("\t"+m);
				}
				System.out.println();
			}
		}
		*/
		
	}

}
