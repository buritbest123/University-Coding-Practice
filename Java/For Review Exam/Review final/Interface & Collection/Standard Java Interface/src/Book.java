// Exercise: 
// Make this Book class implements Comparable interface
// and implement compareTo method

public class Book implements Measurable, Comparable {
  private double purchasePrice;	//baht
	private StringBuilder note = null;
	
	public Book(double _purchasePrice) {
    purchasePrice = _purchasePrice;
		note = new StringBuilder();

	} 

  public double getMeasure(){
    return getPrice();
  }

  public int compareTo(Object b){
    Book book = (Book)b;
    if(purchasePrice < book.getPrice()) return -1;
    if(purchasePrice > book.getPrice()) return 1;
    return 0;
  }

  public double getPrice() {
		return purchasePrice;
	}

  // implement comareTo method from Comparable interface
  
	public String toString(){
		return "[Book: value = "+String.format( "%.2f", getPrice()) +" Baht, Note = \"" + getNote()+"\"]";
	}
	
	public void takeNote(String _note){
		System.out.println("Taking note: \""+_note+"\"");
		note.append(_note);
	}
	
	public String getNote(){
		return note.toString();
	}
	
}
