import java.util.Map;
import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.regex.Pattern;
import java.util.regex.Matcher;
import java.util.HashSet;
import java.util.Set;
import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import org.apache.commons.io.FileUtils;

public class SimpleMovieDatabase {

	public Map<Integer, Movie> movies = null;

	public void importMovies(String movieFilename) throws IOException { // YOUR CODE GOES HERE

		movies = new HashMap<Integer, Movie>();

		File file = FileUtils.getFile(movieFilename); //
		// File tmpDir = FileUtils.getTempDirectory();
		// FileUtils.copyFileToDirectory(file, tmpDir);
		// File newTempFile = FileUtils.getFile(tmpDir, file.getName());
		String rawData = FileUtils.readFileToString(file, Charset.defaultCharset());

		Pattern pat = Pattern.compile("[0-9]+,.+,.+");
		Matcher m = pat.matcher(rawData);

		while (m.find()) {

			String rawEachLine = rawData.substring(m.start(), m.end());
			String[] rawEachLineArray = rawEachLine.split(",");
			List<String> rawTag = new ArrayList<String>();
			String fullTag = "";
			for (int i = 0; i < rawEachLineArray[2].length(); i++) {
				Character cha = rawEachLineArray[2].charAt(i);
				if (cha == '|' || i == rawEachLineArray[2].length() - 1) {
					if (cha != '|') {
						fullTag += cha;
					}
					rawTag.add(fullTag);
					fullTag = "";
				} else {
					fullTag += cha;
				}
			}

			Integer id = Integer.parseInt(rawEachLineArray[0]);
			String title = rawEachLineArray[1];
			Set<String> tags = new HashSet<String>();
			for (String eachTag : rawTag) {
				tags.add(eachTag);
			}

			Movie mov = new Movie(id, title);
			mov.tags = tags;

			if (title.matches(".*[a-zA-Z]+.*") && rawTag.size() != 0) {
				movies.put(id, mov);
			}
		}

	}

	// -------------------BONUS----------------------
	public List<Movie> searchMovies(String query) {
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

	public List<Movie> getMoviesByTag(String tag) {
		// YOUR BONUS CODE GOES HERE
		List<Movie> result = new ArrayList<Movie>();

		for (Movie movie : this.movies.values()) {
			if (movie.tags.contains(tag)) {
				result.add(movie);
			}
		}

		return result;
	}

	public static void main(String[] args) {
		SimpleMovieDatabase mdb = new SimpleMovieDatabase();
		try {
			mdb.importMovies("lab10_movies.txt");
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println("Done importing " + mdb.movies.size() + " movies");
		int[] mids = new int[] { 139747, 141432, 139415, 139620, 141305 };
		for (int mid : mids) {
			System.out.println("Retrieving movie ID " + mid + ": " + mdb.movies.get(mid));
		}

		// Uncomment for bonus

		System.out.println("\n////////////////////////// BONUS ///////////////////////////////");
		String[] queries = new String[] { "america", "thai", "thailand" };
		for (String query : queries) {
			System.out.println("Results for movies that match: " + query);
			for (Movie m : mdb.searchMovies(query)) {
				System.out.println("\t" + m);
			}
			System.out.println();
		}

		String[] tags = new String[] { "Musical", "Action", "Thriller" };
		for (String tag : tags) {
			System.out.println("Results for movies in category: " + tag);
			for (Movie m : mdb.getMoviesByTag(tag)) {
				System.out.println("\t" + m);
			}
			System.out.println();
		}

	}

}