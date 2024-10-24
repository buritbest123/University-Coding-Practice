// Name: Burit Sihabut
// ID: 6488079
// Section: 1

public class Book extends Item{
	
	private StringBuilder note = null;
	
	public Book(double _purchasePrice, double _age, double weight) {
		super(_purchasePrice, _age, weight);
		note = new StringBuilder();
	}

	@Override
	public double getCurrentValue() { // The current value of a book depreciates 10% each year.
		double C = super.getPurchasePrice() * Math.pow(0.9,super.getAge());
		return C;
	}

	@Override
	public String toString()
	{
		return "[Book: value = "+String.format( "%.2f", this.getCurrentValue())+" Baht, Note = \""+getNote()+"\"]";
	}
	
	public void takeNote(String _note)
	{
		System.out.println("Taking note: \""+_note+"\"");
		note.append(_note);
	}
	
	public String getNote()
	{
		return note.toString();
	}
	
	public Book clone()
	{
		/*
		This method creates and returns a “deep” clone of this book. A deep clone is a process to create a
new object by coping all the values from an original object. However, there is no link between original
and new object after cloning. For example, after clone the original book, you will get a copied book.
Both of them have a note “Old Text” inside. Later, you add a new note “New Text” in the copied Book,
but no text will be added to the original book.
		 */
		//Your Code Goes Here
		Book b = new Book(this.getPurchasePrice(), this.getWeight(), this.getAge());
		b.note.append(this.getNote());
		return b;
	}
}