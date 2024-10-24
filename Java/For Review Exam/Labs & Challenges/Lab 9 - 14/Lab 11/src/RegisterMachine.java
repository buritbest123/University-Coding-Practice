import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class RegisterMachine {
    public Map<String, Double> noteType; // Map: Things with unique ID * cares about unique identifiers (key-value pair)
    public double payment = 0.0; // initialization named "payment"

    /**
     *  input: a filename contains coins description that this cash register can accept
     *  throws: NumberFormatException when the coin value is not a number
     */
    public RegisterMachine(String noteFileName) throws NumberFormatException {
        // TODO: implement CashRegister constructor method
        this.noteType = new HashMap<>();   // "coinType" can access classes that implement Map
        File inFile = new File(noteFileName); // Reading Text Files "coinFileName"
        Scanner in = null; // Create 'Scanner' class | To read input from a disk file, you need 'File' Class as well

        try {
            in = new Scanner(inFile);
            do {
                String[] data = in.nextLine().split(" ");  // Input coin name and split to 2 String
                String name = data[0]; // Initialize String name to data index 0
                double value; // declaration "value"
                try {
                    value = Double.parseDouble(data[1]); // Casting data index 1 to Double (Wrapper Class)
                    this.noteType.put(name, value); // put() Method | Add information to Map by has two parameters (Key, Value)
                }catch(NumberFormatException e) { // If the file is not properly formatted
                    throw new NumberFormatException("Incorrect note format"); // (for example, coinValue comes first, and follow by coinName),
                }                                 // throw a NumberFormatException exception with message
            } while(in.hasNextLine()); // hasNextLine() Method to check if there is another line in the input of this scanner. It returns true if it finds another line, otherwise returns false.

        } catch(FileNotFoundException e) { // In case of can't found file
            e.printStackTrace(); // printStackTrace() Method to tell detail mistake to me (for example, Line that occur an error and class that run for debug program
        } finally { // No matter what include do this Line 41 to 42
            in.close(); // close then scanner
        }
        in.close(); // close the scanner when exit do-while loop
    }

    public void recordPayment(int noteCount, String noteName) throws IllegalArgumentException { // To add up the current payment with a new payment.
        // TODO: implement recordPayment() method
        if(!this.noteType.isEmpty()) {  // if coinType is not empty
            try {
                double noteValue = this.noteType.get(noteName);  // initialize coinValue = coinType.get(coinName)
                this.payment += (noteCount * noteValue);
            } catch (NullPointerException e) {
                throw new IllegalArgumentException("This cash registration doesn't accept this note: " + noteName);
            }
        }
    }

    public boolean use_clothbag(char Y_N) {
        if (Y_N == 'Y'){
            return true;
        }else if (Y_N == 'N'){
            return false;
        }else {
            return false;
        }
    }

    public boolean validate_mastercard(char Y_N) {
        if (Y_N == 'Y'){
            return true;
        }else if (Y_N == 'N'){
            return false;
        }else {
            return false;
        }
    }

}
