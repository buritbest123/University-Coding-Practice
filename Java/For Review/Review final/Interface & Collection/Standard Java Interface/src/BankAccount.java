public class BankAccount implements Measurable, Comparable {
    private String accountNumber;
    private double balance;

    public BankAccount(String accountNumber, double balance) {
        this.accountNumber = accountNumber;
        this.balance = balance;
    }
  
    // implement compareTo method from Comparable interface
    public int compareTo(Object otherObject) {
      BankAccount other = (BankAccount) otherObject;
      if (balance < other.balance) { return -1; }
      if (balance > other.balance) { return 1; }
      return 0;
    }

    public double getMeasure(){
      return getBalance();
    }


    public String toString(){
      return "accNumber: " + accountNumber + ", balance: " + balance;
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
