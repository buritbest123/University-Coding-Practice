
public class Part5_Exception {
	
	public static void main(String[] args) 	{
		
		String num = "$123.00";
		
		// convert string to number
		//double numValue = Double.parseDouble(num);
		//System.out.println("The amount is " + numValue);

		
		
		try {
			String dollar = "$123.00";
			double amount = Double.parseDouble(dollar);
			System.out.println("The amount is " + amount);
			
		} catch(Exception e) {
			System.out.println("Error found!");
		}
		
		try {
			
			String[] list = {"$123", "456"};
			double amount = Double.parseDouble(list[2]);
			System.out.println("The amount at index 2 " + amount);
			
		} catch(ArrayIndexOutOfBoundsException e) {
			System.out.println("Index out of bounds");
			
		} catch(NumberFormatException e) {
			System.out.println("Number format exception");
			
		}
		
		try {
			
			String[] list = {"$123", "456"};
			double amount = Double.parseDouble(list[0]);
			System.out.println("The amount at index 0 " + amount);
			
		} catch(ArrayIndexOutOfBoundsException e) {
			System.out.println("Index out of bounds");
			
		} catch(NumberFormatException e) {
			System.out.println("Number format exception");
			
		}
		
		try {
			String[] list = {"$123", "456"};
			double amount = Double.parseDouble(list[0]);
			System.out.println("The amount at index 0 " + amount);
			
		} catch(Exception e) {
			System.out.println("--- Error found!");
			
		} finally {
			System.out.println("### Alawys do this!");
		}
		
		try {
			String[] list = {"123", "456"};
			double amount = Double.parseDouble(list[0]);
			System.out.println("The amount at index 0 " + amount);
			
		} catch(Exception e) {
			System.out.println("--- Error found!");
			
		} finally {
			System.out.println("*** Alawys do this!");
		}
	}
	
}
