public class Book implements Measurable {
  private double purchasePrice;	//baht
	private StringBuilder note = null;
	
	public Book(double _purchasePrice) {
    purchasePrice = _purchasePrice;
		note = new StringBuilder();

	} 

  public double getMeasure(){
     return getPrice();
    
  }

  public double getPrice() {
		return purchasePrice;
	}
  
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
