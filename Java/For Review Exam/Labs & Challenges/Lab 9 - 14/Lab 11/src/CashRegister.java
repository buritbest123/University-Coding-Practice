import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Map;
import java.util.HashMap;

public class CashRegister extends RegisterMachine{

  public Map<String, Double> coinType; // Map: Things with unique ID * cares about unique identifiers (key-value pair)
  public double purchase = 0.0; // initialization named "purchase"
  public double payment = 0.0; // initialization named "payment"

  /**
  *  input: a filename contains coins description that this cash register can accept
  *  thows: NumberFormatException when the coin value is not a number
  */
  public CashRegister(String coinFileName) throws NumberFormatException {
    super(coinFileName);
    // TODO: implement CashRegister constructor method
    this.coinType = new HashMap<String, Double>();   // "coinType" can access classes that implement Map
    File inFile = new File(coinFileName); // Reading Text Files "coinFileName"
    Scanner in = null; // Create 'Scanner' class | To read input from a disk file, you need 'File' Class as well

    try {
      in = new Scanner(inFile);
      do {
        String[] data = in.nextLine().split(" ");  // Input coin name and split to 2 String
        String name = data[0]; // Initialize String name to data index 0
        double value; // declaration "value"
        try {
          value = Double.parseDouble(data[1]); // Casting data index 1 to Double (Wrapper Class)
          this.coinType.put(name, value); // put() Method | Add information to Map by has two parameters (Key, Value)
        } catch (NumberFormatException e) { // If the file is not properly formatted
          throw new NumberFormatException("Incorrect coin format"); // (for example, coinValue comes first, and follow by coinName),
        }                                 // throw a NumberFormatException exception with message
      } while(in.hasNextLine()); // hasNextLine() Method to check if there is another line in the input of this scanner. It returns true if it finds another line, otherwise returns false.

    } catch(FileNotFoundException e) { // In case of can't found file
      e.printStackTrace(); // printStackTrace() Method to tell detail mistake to me (for example, Line that occur an error and class that run for debug program
    } finally { // No matter what include do this Line 41 to 42
      in.close(); // close then scanner
    }
    in.close(); // close the scanner when exit do-while loop
  }

  public double getPurchase(){
    // TODO: implement getAmount() method
    return this.purchase; // return purchase
  }

  public double getPayment(){
    // TODO: implement getPayment() method
    return this.payment; // return payment
  }

  // Return list of acceptable coins for this cash registration. For example
  // Note that the format is not strict, as long as you can get all coins' names and values
  /*
    nickel   0.05
    dime     0.10
    quater   0.25
    penny    0.01
    dollar   1.00
  */
  public String getCoinTypeList(){
    // TODO: implement getCoinType() method
    if(!this.coinType.isEmpty()) { // if coinType is not empty
      String name = ""; // StringBuilder class to do about string (for example, concat, edit, create new String)
      for(Map.Entry<String, Double> entry : this.coinType.entrySet()) { // For-each loop (Map.Entry to iterate over every pair contained within it.
        String key = entry.getKey(); // To get "Key"
        Double val = entry.getValue(); // To get "Value"

        name += (String.format("%s\t%.2f\n", key, val)); // same as name += String.format("%s\t%.2f\n", key,val);
      }
      return name.toString(); // return string of all acceptable coins for this cash registration.
    }
    else {
      return null;
    }
  }
  
  public void recordPurchase(double amount){ // To add up the current purchase with a new purchase record
    // TODO: implement recordPurchase() method
    this.purchase += amount;  // To add up the current purchase with a new purchase record
  }

  public void recordPayment(int coinCount, String coinName) throws IllegalArgumentException { // To add up the current payment with a new payment.
    // TODO: implement recordPayment() method
    if(!this.coinType.isEmpty()) {  // if coinType is not empty
      try {
        double coinValue = this.coinType.get(coinName);  // initialize coinValue = coinType.get(coinName)
        this.payment += (coinCount * coinValue);
      } catch (NullPointerException e) {
        throw new IllegalArgumentException("This cash registration doesn't accept this coin: " + coinName);
      }
    }else return;
  }

  // Return a receipt string in the following format. For example,
  /*
    Case 1: sufficient payment
    Sale person: <YOUR NAME>
    Purchase Amount:\t9.99
    Payment Amount:\t11.0
    Change Amount:\t\t1.01

    Case 2: insufficient payment
    Sale person: <YOUR NAME>
    Purchase Amount:\t9.99
    Payment Amount:\t11.0
    NOTE: Insufficent payment, please insert more coins.
  */

  public String getReceipt(){ // You just need to change the sale person’s name to be your firstname and lastname.
    // TODO: change <YOUR NAME> text to be your firstname and lastname
    String receipt = "Sale person: " + "<Burit Sihabut>";

    receipt += "\nPurchase Amount: \t" + purchase + "\nPayment Amount: \t" + payment;
    if(payment < purchase){
      receipt += "\nNOTE: Insufficient payment, please insert more coins.\n";
    } else{
      receipt += "\nChange Amount: \t\t" + String.format("%.2f", (payment - purchase)) + "\n";
    }

    return receipt;
  }

  // Print reciept in the output file according to the format in getReceipt method
  public void printReceipt(String outputFile){ // To write a receipt into an output file.
    // TODO: implement printReceipt(..) method
    try {
      File file = new File(outputFile); // Reading Text Files "outputFile"
      PrintWriter fp = new PrintWriter(file); // Writing Text File "file"

      String data = this.getReceipt();

      fp.println(data);

      fp.close();

    } catch (FileNotFoundException e) {
      e.printStackTrace();
    }
  }

  public double increase_purchase(char mastercard){
    if (validate_mastercard(mastercard)){
      return purchase = purchase + purchase * 7 / 100;
    }
    return purchase;
  }

  public double decrease_purchase(char clothbag){
    if (use_clothbag(clothbag)){
      return purchase -= 2;
    }
    return purchase;
  }
}