class Main {

  public static void main(String[] args) {
    BankAccount[] accounts = new BankAccount[3]; // create object BankAccount named "accounts" and has 3 accounts
    accounts[0] = new BankAccount("001", 100);
    accounts[1] = new BankAccount("002", 200);
    accounts[2] = new BankAccount("003", 300);

    // without interface type, you have to use overloading method
    // with interface type, you only need one average method 
    // double avgBalance = average(accounts);

    // You can even create a new class (Data), 
    // to handle other methods for measurable objects such as min, max, etc.
    double avgBalance = Data.average(accounts);
    System.out.println("Avg balance: Expect= 200, actual= " + avgBalance);


    Book[] books = new Book[3];
    books[0] = new Book(50);
    books[1] = new Book(40);
    books[2] = new Book(30);

    //double avgPrice = average(books);
    double avgPrice = Data.average(books);
    System.out.println("Avg balance: Expect= 40, actual= " + avgPrice);


    Student[] students = new Student[3];
    students[0] = new Student(3.99);
    students[1] = new Student(2.50);
    students[2] = new Student(1.50);
    double avgGPA = Data.average(students);
    System.out.println("Avg GPA: Expect= 2.6633333333333336, actual= " + avgGPA);

  }
}

// !There too much overloading method IT WORKS BUT SO CODING IS TOO LONG!
   /*public static double average(BankAccount[] objects) {
     double sum = 0;
     for (BankAccount obj : objects) {
       sum = sum + obj.getBalance();
     }
     if (objects.length > 0) {
       return sum / objects.length;
     }
     else {
       return 0;
     }
   }

   public static double average(Book[] objects) {
     double sum = 0;
     for (Book obj : objects) {
       sum = sum + obj.getPrice();
     }
     if (objects.length > 0) {
       return sum / objects.length;
     }
     else {
       return 0;
     }
   }

   public static double average(Student[] objects) {
     double sum = 0;
     for (Student obj : objects) {
       sum = sum + obj.gpa;
     }
     if (objects.length > 0) {
       return sum / objects.length;
     }
     else {
       return 0;
     }
   }*/