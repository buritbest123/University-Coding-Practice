package bank_without_inheritance;

public class SavingAccount {
	private double balance;
	private double interestRate; 
	
	public SavingAccount(double interest){   
		balance = 0;
		interestRate = interest;
	}
	
	public SavingAccount(double interest, double balance) {
		this.balance = balance;
		this.interestRate = interest;
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
	
	public void addInterest() {
		double interest = balance * (interestRate / 100.0);
		deposit(interest);
	}
}
