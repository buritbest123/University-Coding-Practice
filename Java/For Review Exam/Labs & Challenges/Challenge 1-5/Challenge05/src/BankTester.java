
public class BankTester {

	public static void main(String[] args) {
		
		// small testcases
		Bank bank = new Bank("+POSITIVE+");
		bank.addAccount(new BankAccount(1001,20000));
		bank.addAccount(new BankAccount(1015,10000));
		bank.addAccount(new BankAccount(1729,15000));
		
		System.out.println("Bank Name: " + bank.getName());
		System.out.printf("Total balance: %.2f\n", bank.getTotalBalance());
		System.out.println("Account number with having balance at least 12000: " + bank.countBalanceAtLeast(12000));
		System.out.println("Balance of matching account: " + bank.find(1729).getBalance());
		System.out.println("Account number with the smallest balance: " + bank.getMin().getAccountNumber());
		System.out.println("Account number with the highest balance: " + bank.getMax().getAccountNumber());
		
		// find unknown account
		BankAccount account = bank.find(1730);
		if(account == null) {
			System.out.println("Cannot find account 1730");
		}
		
		// full testcases
		String[][] accountsStr = {
				{"1228", "5067.15"}, {"3185", "9949.83"}, {"6377", "3953.06"}, {"7667", "4899.44"}, {"2722", "9537.86"}, {"9764", "9079.35"}, {"1971", "9723.04"}, {"6476", "4260.29"}, 
				{"6931", "7364.35"}, {"7005", "1079.13"}, {"6686", "1312.76"}, {"6205", "5859.36"}, {"1808", "2774.83"}, {"8616", "3320.3"}, {"7893", "9527.22"}, {"3908", "7978.35"}, 
				{"5652", "9557.67"}, {"6900", "1825.35"}, {"1211", "1995.48"}, {"4225", "6847.47"}, {"1725", "424.38"}, {"6184", "6084.43"}, {"5792", "6057.85"}, {"4271", "4841.8"}, 
				{"9818", "3344.28"}, {"6136", "364.18"}, {"6076", "6506.2"}, {"5196", "1978.2"}, {"1969", "1043.59"}, {"8599", "3542.69"}, {"6900", "60.25"}, {"7297", "9714.04"}, 
				{"4158", "5269.51"}, {"2810", "1338.23"}, {"9420", "8998.16"}, {"6810", "4820.1"}, {"1745", "2953.39"}, {"8542", "4106.35"}, {"7362", "6311.8"}, {"8730", "6941.63"}, 
				{"9951", "9820.31"}, {"9637", "877.84"}, {"4397", "6049.85"}, {"6513", "7770.36"}, {"8907", "6013.09"}, {"3901", "3258.63"}, {"4154", "3350.78"}, {"7137", "7258.45"}, 
				{"5421", "1521.13"}, {"9825", "8048.61"}, {"1969", "1044.59"}, {"6900", "71.25"},  {"7155", "9441.66"} 
				};
		
		Bank bigBank = new Bank("+++BIG POSITIVE+++");
		
		for(String[] acc: accountsStr)
		{
			bigBank.addAccount(new BankAccount(Integer.parseInt(acc[0]), Double.parseDouble(acc[1])));
		}
		
		System.out.println("**********************************");
		System.out.println("Bank Name: " + bigBank.getName());
		System.out.printf("Total balance: %.2f\n", bank.getTotalBalance());
		System.out.println("Account number with having balance at least 5000: " + bigBank.countBalanceAtLeast(5000));
		System.out.println("Balance of matching account: " + bigBank.find(9825).getBalance());
		System.out.println("Account number with the smallest balance: " + bigBank.getMin().getAccountNumber());
		System.out.println("Account number with the highest balance: " + bigBank.getMax().getAccountNumber());
		// find unknown account
		account = bank.find(4242);
		if(account == null) {
			System.out.println("Cannot find account 4242");
		}
				
		
		
		// Uncomment these for bonus
		 System.out.println("************** BONUS ********************");
		 System.out.println("Found duplicate accounts: " + bigBank.findDuplicate().toString());
		
	}

}
