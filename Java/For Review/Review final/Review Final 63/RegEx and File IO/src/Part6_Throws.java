
public class Part6_Throws {
	
	public static void convertAmount(String txt) throws Exception{
		try {
			double amount = Double.parseDouble(txt);
			System.out.println("The amount is " + amount);
		} catch(Exception e) {
			System.out.println("-- Error found! --");
			throw new Exception("Cannot convert amount");
		}
	}
	
	public static void main(String[] args) {
		try {
			String dollar = "$123.00";
			convertAmount(dollar);
			
		} catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
}
