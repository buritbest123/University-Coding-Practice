import java.util.Arrays;

class Main {
  
  public static void main(String[] args) {
    BankAccount[] accounts = new BankAccount[3];
    accounts[0] = new BankAccount("001", 300);  
    accounts[1] = new BankAccount("002", 100);  
    accounts[2] = new BankAccount("003", 200); 
  
    for(int i = 0; i < accounts.length; i++){
      System.out.println(accounts[i]);
    }
    
    Arrays.sort(accounts);
    System.out.println("---- After Sorting ----");
    for(int i = 0; i < accounts.length; i++){
      System.out.println(accounts[i]);
    }

    System.out.println("\n***********************\n");
    
    Book[] books = new Book[3];
    books[0] = new Book(50); 
    books[1] = new Book(40);      
    books[2] = new Book(30); 
    for(int i = 0; i < books.length; i++){
      System.out.println(books[i]);
    }

    // Exercise: implement compareTo in Book class, so that you can use Java sort method
    Arrays.sort(books);
    System.out.println("---- After Sorting ----");
    for(int i = 0; i < books.length; i++){
      System.out.println(books[i]);
    }
    
    
  }


  // public static double average(BankAccount[] objects) {
  //   double sum = 0;
  //   for (BankAccount obj : objects) {
  //     sum = sum + obj.getBalance();
  //   }  
  //   if (objects.length > 0) { 
  //     return sum / objects.length; 
  //   }
  //   else { 
  //     return 0; 
  //   }
  // }

  // public static double average(Book[] objects) {
  //   double sum = 0;
  //   for (Book obj : objects) {
  //     sum = sum + obj.getPrice();
  //   }  
  //   if (objects.length > 0) { 
  //     return sum / objects.length; 
  //   }
  //   else { 
  //     return 0; 
  //   }
  // }

  // average method with interface type
  public static double average(Measurable[] objects) {
    double sum = 0;
    for (Measurable obj : objects) {
      sum = sum + obj.getMeasure();
    }  
    if (objects.length > 0) { 
      return sum / objects.length; 
    }
    else { 
      return 0; 
    }
  }
}