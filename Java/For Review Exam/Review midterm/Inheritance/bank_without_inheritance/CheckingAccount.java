package bank_without_inheritance;

public class CheckingAccount {
	private double balance;
	
	public CheckingAccount(){   
		balance = 0;
	}
	
	public CheckingAccount(double initialBalance) {
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
