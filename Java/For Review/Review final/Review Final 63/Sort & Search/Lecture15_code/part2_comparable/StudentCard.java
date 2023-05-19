package part2_comparable;

public class StudentCard extends Card {
	
	private String firstname;
	private double gpa;

	public StudentCard(int value, int suit, String name, double gpa) {
		super(value, suit);
		this.firstname = name;
		this.gpa = gpa;
	}
	
	public String getValueAsString() {
		
		return "ID:" + getValue();
	}
	
	public String getSuitAsString() {
		
		return "Year:" + getSuit();
	}
	
	@Override
	public int compareTo(Card c) {
		return getSuit() - c.getSuit();
	}
}
