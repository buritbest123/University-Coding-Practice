package bank_with_inheritance;

public class BankAccount {
	private double balance;
	
	public BankAccount(){   
		balance = 0;
	}
	
	public BankAccount(double initialBalance) {
		balance = initialBalance;
	}
	
	public double getBalance() {
		return this.balance;
	}
	
	public void deposit(double amount) {
		balance = balance + amount;
	} 
	
	public void withdraw(double amount) {
		balance = balance - amount;
	}
}
