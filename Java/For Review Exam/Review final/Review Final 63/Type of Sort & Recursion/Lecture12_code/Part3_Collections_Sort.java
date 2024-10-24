import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Part3_Collections_Sort {
	
	public static void main(String[] args) {
		List<Person> plist = new ArrayList<Person>();
		plist.add(new Person(183));
		plist.add(new Person(185));
		plist.add(new Person(165));
		plist.add(new Person(170));
		
		Collections.sort(plist);
		
		for(Person p: plist) {
			System.out.println(p);
		}
	}
}

