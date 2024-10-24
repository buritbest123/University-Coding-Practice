package bank_with_inheritance;;

public class SavingAccount extends BankAccount {
	private double interestRate; 
	
	public SavingAccount(double interest){   
		super(0);
		interestRate = interest;
	}
	
	public SavingAccount(double interest, double balance) {
		super(balance);
		this.interestRate = interest;
	}
	
	public void addInterest() {
		double interest = this.getBalance() * (interestRate / 100.0);
		deposit(interest);
	}
	
	@Override
	public void withdraw(double amount) {
		if(amount > getBalance()) {
			System.out.println("Not enough money. You cannot withdraw.");
		} else {
			super.withdraw(amount);
		}
	}
}
