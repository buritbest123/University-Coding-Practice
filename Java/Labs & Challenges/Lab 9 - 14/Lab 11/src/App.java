import java.util.Scanner;
import java.util.Map;


// DO NOT MODIFY THIS CLASS //

class App {
  public static void main(String[] args) {
    //testcase1();
    //testcase2();
    //testcase3();
    testcase4();

    // to try your own input
     //dynamicInput();
  }


  public static CashRegister createCashRegister(String fileName){
    CashRegister register = null;
    
    try{
      register = new CashRegister(fileName);
      // System.out.println("Cash register only accept these types of coin:");
      System.out.println("Cash register only accept these types of note:");
      System.out.println(register.getCoinTypeList());
      System.out.println("----------------------------------");
    } catch(NumberFormatException e){
      System.out.println("Cannot create cash registration: " + e.getMessage());
      System.out.println("Please try a new input file. Bye!");
      return null;
    } 
    return register;
  }
  
  public static void testcase1(){
    System.out.println("Testcase 1: Easy case");
    String fileName = "coins.txt";
    CashRegister register = createCashRegister(fileName);
    register.recordPurchase(5.99);
    register.recordPayment(10, "quarter");
    // Not enough payment, you must insert more coins
    System.out.println(register.getReceipt());
    
    register.recordPurchase(4.00);
    register.recordPayment(20, "quarter");
    register.recordPayment(10, "dime");
    register.recordPayment(50, "nickel");
    // Enough payment
    System.out.println(register.getReceipt());
    register.printReceipt("receipt_case1.txt");
  }
  
  public static void testcase2(){
    System.out.println("\nTestcase 2: Invalid coins description");
    // invalid coins description
    String fileName = "coins_wrong_format.txt";
    CashRegister register = createCashRegister(fileName);
    if(register == null){
      System.out.println("Null expected!");
    }
  }

  public static void testcase3(){
    System.out.println("\nTestcase 3: Invalid coins payment");
    String fileName = "coins.txt";
    CashRegister register = createCashRegister(fileName);
    register.recordPurchase(19.99);
    try{
      register.recordPayment(10, "ten-baht");
    } catch(IllegalArgumentException e){
      System.out.println(e.getMessage());
    }
    
    System.out.println(register.getReceipt());
    register.printReceipt("receipt_case3.txt");
  }

  public static void dynamicInput(){
    CashRegister register = null;
    Scanner in = new Scanner(System.in);
    boolean done = false;

    while(!done){
      System.out.println("Please enter coins description file: ");
      String fileName = in.nextLine();
      try{
        register = new CashRegister(fileName);
        System.out.println("Cash register only accept these types of coin:");
        Map<String, Double> coins = register.coinType;
        
        done = true;
      } catch(NumberFormatException e){
        System.out.println("Connot create cash registeration: " + e.getMessage());
        System.out.println("Please try a new input file.");
      } finally {
        if(in != null)  in.close();
      }
    }

    System.out.println("Please enter purchase amount: ");
    Double purchase = in.nextDouble();

    register.recordPurchase(purchase);
    while (register.getPayment() < register.getPurchase()){
      in.nextLine();
      System.out.println("Insert coin name: ");
      String coinName = in.nextLine();
      System.out.println("Insert number of coins: ");
      int count = in.nextInt();
      register.recordPayment(count, coinName);
    }
    System.out.println(register.getReceipt());
    register.printReceipt("receipt_dynamic.txt");
  }

  public static void testcase4(){
    System.out.println("Testcase 4: Medium case");
    String fileName = "note.txt";
    CashRegister register = createCashRegister(fileName);
    register.recordPurchase(100);
    register.recordPayment(10, "yeasib");
    register.increase_purchase('Y');

    // Not enough payment, you must insert more coins
    System.out.println(register.getReceipt());

    register.recordPurchase(900);
    register.recordPayment(10, "yeasib");
    register.recordPayment(10, "hasib");
    register.recordPayment(3, "neungloy");
    register.decrease_purchase('Y');
    // Enough payment
    System.out.println(register.getReceipt());
    register.printReceipt("receipt_case4.txt");
  }
}