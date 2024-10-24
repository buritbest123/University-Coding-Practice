package bank_without_inheritance;

public class BankTester {

	public static void main(String[] args) {
		CheckingAccount mom = new CheckingAccount(2000);
		System.out.println("Mom's checking account: " + mom.getBalance());
		
		SavingAccount dad = new SavingAccount(1.5, 3000);
		dad.addInterest();
		System.out.println("Dad's saving account: " + dad.getBalance());
	}

}
