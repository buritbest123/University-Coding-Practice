// Student ID:
// Name:
// Section:

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
//////////////////////////////////
import java.io.FileWriter;
import java.util.Scanner;
import java.util.ArrayList;

public class BasicMovieDatabase {

	// DO NOT MOIDIFY THIS
	public static final String INIT_PATH = Paths.get("").toAbsolutePath().toString() + File.separator + "init"
			+ File.separator;

	public Map<Integer, Movie> movies = null;

	public static enum OPERATOR {
		EQ, LT, GT, LTE, GTE
	};
	// EQ = Equal, LT = Less than, GT = Greater than
	// LTE = Less than or equal, GTE = Greater than or equal

	// ---------------------------------------------------------------------

	public void importMovies(String movieFilename) throws FileNotFoundException {

		movies = new HashMap<Integer, Movie>();

		// -------- Using your code from Lab 10 -------------- //

		File file = new File(movieFilename);
		Scanner reader = new Scanner(file);

		while (reader.hasNextLine()) {

			String line = reader.nextLine();
			int comma = line.length() - line.replaceAll(",", "").length();
			// valid
			if (comma == 2) {

				String[] splLine = line.split(",");
				String rawID = splLine[0];
				String rawTitle = splLine[1];
				String rawGen = splLine[2];

				// base case
				if (!rawID.matches(".*[0-9]+.*")) {
					continue;
				}
				if (!rawTitle.matches(".*[a-zA-Z0-9]+.*")) {
					continue;
				}
				if (!rawGen.matches(".*[A-Za-z]+.*")) {
					continue;
				}

				int id = Integer.parseInt(rawID);
				Movie mov = new Movie(id, rawTitle);

				String full = "";
				for (int i = 0; i < rawGen.length(); i++) {
					if (rawGen.charAt(i) == '|') {
						mov.tags.add(full);
						full = "";
					} else if (i == rawGen.length() - 1) {
						full += rawGen.charAt(i);
						mov.tags.add(full);
					} else {
						full += rawGen.charAt(i);
					}
				}

				movies.put(id, mov);

			}

		}

		reader.close();

	}

	/**
	 * Import movie ratings from text file and update into each specific movie
	 * 
	 * @param filename
	 * @throws FileNotFoundException
	 */
	public void importRating(String filename) throws FileNotFoundException {

		File file = new File(filename);
		Scanner reader = new Scanner(file);

		while (reader.hasNextLine()) {

			String line = reader.nextLine();
			String[] splLine = line.split(",");

			// base case
			if (splLine.length != 3) {
				continue;
			}

			String id = splLine[0];
			String rate = splLine[1];
			String time = splLine[2];

			// base case
			if (!id.matches(".*[0-9]+.*")) {
				continue;
			}
			if (!rate.matches(".*[0-9]+.*")) {
				continue;
			}
			if (!time.matches(".*[0-9]+.*")) {
				continue;
			}

			// create new Rating
			Integer mid = Integer.parseInt(id);

			// access movie
			Movie mov = this.movies.get(mid);

			double rateMov = Double.parseDouble(rate);

			// base case
			if (rateMov < 0.0 || rateMov > 5.0) {
				continue;
			}

			long timestamp = Long.parseLong(time);
			Rating newRating = new Rating(mov, rateMov, timestamp);

			mov.allRating.add(newRating);

		}

		reader.close();
	}

	/**
	 * Exporting movie with the valid format <mid>,<title>,<tag1>|<tag2>|...|<tagN>
	 * and write to the given file
	 * 
	 * @param filename
	 * @return number of exported movies
	 * @throws IOException
	 */
	public int exportMovies(String filename) throws IOException {
		// YOUR CODE GOES HERE //
		int count = 0;
		FileWriter fileToWrite = new FileWriter(filename);

		for (Movie mov : this.movies.values()) {

			String form = "";
			form += mov.mid;
			form += ",";
			form += mov.title;
			form += ",";

			for (String tag : mov.tags) {
				form += tag;
				form += "|";
			}

			form = form.substring(0, form.length() - 1);
			fileToWrite.write(form);
			fileToWrite.write("\n");
			count++;

		}

		fileToWrite.close();

		return count;
	}

	/**
	 * If you want to use this method, you can copy your code from lab 10
	 * 
	 * @param query
	 * @return
	 */
	public List<Movie> searchMovies(String query) {

		// -------- Using your code from Lab 10 -------------- //
		// YOUR BONUS CODE GOES HERE
		List<Movie> result = new ArrayList<Movie>();
		query = query.toLowerCase();

		for (Movie movie : this.movies.values()) {
			String tit = movie.title.toLowerCase();
			if (tit.contains(query)) {
				result.add(movie);
			}
		}

		return result;
	}

	/**
	 * Search movies by the query and the rating The operator indicate the
	 * comparison operator on the rating value (note. You may reuse the searchMovies
	 * method here)
	 * 
	 * @param query
	 * @param op
	 * @param rating
	 * @return List of movies that satisfied the conditions
	 */
	public List<Movie> searchMoviesWithRating(String query, OPERATOR op, double rating) {

		// YOUR CODE GOES HERE //
		List<Movie> result = new ArrayList<Movie>();
		List<Movie> queried = searchMovies(query);

		for (Movie movie : queried) {
			try {
				if (op == OPERATOR.EQ && movie.getAverageRating() == rating) {
					result.add(movie);
				} else if (op == OPERATOR.LT && movie.getAverageRating() < rating) {
					result.add(movie);
				} else if (op == OPERATOR.GT && movie.getAverageRating() > rating) {
					result.add(movie);
				} else if (op == OPERATOR.LTE && movie.getAverageRating() <= rating) {
					result.add(movie);
				} else if (op == OPERATOR.GTE && movie.getAverageRating() >= rating) {
					result.add(movie);
				}
			} catch (MovieException e) {
				// do nothing
			}
		}

		return result;
	}

	// ********************************************************************************
	// DO NOT MODIFY THIS MAIN METHOD (except to uncomment the bonus part)
	public static void main(String[] args) throws IOException {

		BasicMovieDatabase mdb = new BasicMovieDatabase();
		mdb.importMovies(INIT_PATH + "lab10_movies.txt");
		System.out.println("Done importing " + mdb.movies.size() + " movies");
		int[] mids = new int[] { 139747, 141432, 139415, 139620, 141305, 140715, 148626 };

		System.out.println("-- before adding ratings --");
		for (int mid : mids) {
			System.out.println("Retrieving movie ID " + mid + ": " + mdb.movies.get(mid));
		}

		// Task 1: importing movies rating file and update the movies rating
		System.out.println("-- after adding ratings --");
		mdb.importRating(INIT_PATH + "lab11_ratings.txt");
		for (int mid : mids) {
			System.out.println("Retrieving movie ID " + mid + ": " + mdb.movies.get(mid));

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
		int count;
		count = mdb.exportMovies(INIT_PATH + "lab11_movies.txt");
		System.out.println("Done exporting " + count + " movies");
		// The file should contains 50 movies

		// Uncomment for bonus

		System.out.println("\n////////////////////////// BONUS ///////////////////////////////");
		double[] ratings = { 0.0, 2.5, 4.0 };
		String query = "america";

		OPERATOR[] ops = { OPERATOR.EQ, OPERATOR.GT, OPERATOR.GTE };
		for (OPERATOR op : ops) {
			for (int i = 0; i < 3; i++) {
				double rating = ratings[i];
				System.out.println("Results for movies that match: [" + query + "] and have rating " + op.toString()
						+ " " + rating);
				for (Movie m : mdb.searchMoviesWithRating(query, op, rating)) {
					System.out.println("\t" + m);
				}
				System.out.println();
			}
		}

	}

}
