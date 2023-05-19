public class BankAccount implements Measurable{ // once you have implements Measurable YOU MUST HAVE ONE ABSTRACT METHOD
    private String accountNumber; // initialize accountNumber
    private double balance; // initialize balance

    public BankAccount(String accountNumber, double balance) { // constructor
        this.accountNumber = accountNumber;
        this.balance = balance;
    }

    public double getMeasure(){ // Abstract method
      return getBalance();
    }
  
    public void deposit(double amount) {
        this.balance += amount;
    }

    public void withdraw(double amount) {
        this.balance -= amount;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public double getBalance() {
        return balance;
    }

}
