package bank_with_inheritance;;

public class BankTester {

	public static void main(String[] args) {
		CheckingAccount mom = new CheckingAccount(2000);
		System.out.println("Mom's checking account: " + mom.getBalance());
		
		SavingAccount dad = new SavingAccount(1.5, 3000);
		dad.addInterest();
		dad.withdraw(5000);
		System.out.println("Dad's saving account: " + dad.getBalance());
		dad.withdraw(1000);
		System.out.println("Dad's saving account: " + dad.getBalance());
	}
}
