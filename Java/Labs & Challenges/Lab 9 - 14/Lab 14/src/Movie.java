public class Movie implements Comparable<Movie> {
	public int mid = -1;
	public String title = null;
	public int year = -1;
	
	public Movie(int _mid, String _title, int _year)
	{
		mid = _mid;
		title = _title;
		year = _year;
	}
	
	
	public String toString()
	{
		return "[mid:"+mid+" |"+title+" |"+year+"]";
	}
	
	
	public int compareTo(Movie m) {
		// ascending order
		// return a negative if m1 comes before m2
		// return a positive if m1 comes after m2
		// returns 0 if they have the same title, release year, and mid
		// YOUR CODE GOES HERE
		if (this.title.compareTo(m.title) < 0)
		{
			return -1;
		}
		else if (this.title.compareTo(m.title) == 0)  // both title exactly the same, then compare year
		{
			if (this.year < m.year)  // movie released year less than second movie released year
			{
				return -1; 			 // then return -1
			}
			if (this.year == m.year) // both year equal to then compare mid
			{
				if (this.mid < m.mid) // mid less than second mid
				{
					return -1;		   // then return -1
				}
				// if m1 is equal to m2 (i.e., they have the same
				// title, release year, and mid);
				else if (this.mid == m.mid) // both equal finally
				{
					return 0; 				// then return 0
				}
			}
		}
		// m1 comes after m2 anyway
		// return a positive if m1 comes after m2
		return 1;
	}
}