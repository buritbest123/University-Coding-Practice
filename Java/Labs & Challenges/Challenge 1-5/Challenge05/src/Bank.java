import java.util.ArrayList;

public class Bank {
    private final String name; // Constant or final (cannot be changed) = name
    private final ArrayList<BankAccount> Bank_list; // create an ArrayList object called Bank_list that will store

    public Bank(String Bank_account) { // This constructor method gets called by runtime
        // Use this method to assign the bank's name and create a list of accounts (using ArrayList to store BankAccount objects)
        name = Bank_account;
        Bank_list = new ArrayList<>();
    }

    public String getName() { // This method gets called by runtime
        // Use this method to get Bank name
        return name;
    }

    public void addAccount(BankAccount bankAccount){ // This method gets called by runtime
        // Use this method to add account
        Bank_list.add(bankAccount);
    }

    public double getTotalBalance(){ // This method gets called by runtime
        // Use this method to get total balance
        double t_balance = 0;
        for (BankAccount bankAccount : Bank_list) { // is equivalent to  for (int i=0;i<Bank_list.size();i++)
            t_balance += bankAccount.getBalance();
        }
        return t_balance;
    }

    public int countBalanceAtLeast(double atLeast) { // This method gets called by runtime
        // Use this method to count account that having balance at least ___ (It depends on configuration)

        int c_balance = 0;
        for (BankAccount bankAccount : Bank_list) {  // is equivalent to  for (int i=0;i<Bank_list.size();i++)
            if (bankAccount.getBalance() >= atLeast) {
                c_balance += 1;
            }
        }
        return c_balance;
    }

    public BankAccount find(int accountNumber) { // This method gets called by runtime.
        // Use this method to find account that matching account.
        for (BankAccount bankAccount : Bank_list) {  // is equivalent to  for (int i=0;i<Bank_list.size();i++)
            if (bankAccount.getAccountNumber() == accountNumber) {
                return bankAccount;
            }
        }
        return null;
    }

    public BankAccount getMax() { // This method gets called by runtime.
        // Use this method to find account number with the highest balance
        double max = Double.MIN_VALUE; // Set max holding the minimum value a double can have -2³¹ | To check in Line 46
        BankAccount get_max = Bank_list.get(0); // Getting element at index 0
        for (BankAccount bankAccount : Bank_list) { // is equivalent to  for (int i=0;i<Bank_list.size();i++)
            if (bankAccount.getBalance() >= max) {
                max = bankAccount.getBalance();
                get_max = bankAccount;
            }
            if (Bank_list.size() == 0) {
                return null;
            }
        }
        return get_max ;
    }

    public  BankAccount getMin() { // This method gets called by runtime.
        // Use this method to find account number with the smallest balance
        double min = Double.MAX_VALUE; // Set min holding the maximum value a double can have 2³¹-1 | To check in Line 60
        BankAccount get_min = Bank_list.get(0); // Getting element at index 0
        for (BankAccount bankAccount : Bank_list) { // is equivalent to  for (int i=0;i<Bank_list.size();i++)
            if (bankAccount.getBalance() <= min) {
                min = bankAccount.getBalance();
                get_min = bankAccount;
            }
        }
        if (Bank_list.size()==0) {
            return null;
        }
        return get_min ;
    }

    public ArrayList<BankAccount> findDuplicate(){ // create an ArrayList object called findDuplicate that will store
        // This method gets called by runtime
        // Use this method to create a duplicate (using ArrayList to store BankAccount objects)
        ArrayList<BankAccount> duplicate = new ArrayList<>();
        int[] get_duplicate = new int[Bank_list.size()]; // Create an array named get_duplicate size = Bank_list.size() && To find duplicate account (position)
        for (int i=0; i<Bank_list.size(); i++){ // 2D array
            for (int j=0; j<Bank_list.size(); j++){
                if (Bank_list.get(i).getAccountNumber() == Bank_list.get(j).getAccountNumber()){
                    get_duplicate[i]++;
                }
            }
        }
        for (int i=0; i<Bank_list.size();i++){ // This loop run to find duplicate account
            if (get_duplicate[i] > 1){
                duplicate.add(Bank_list.get(i));
            }
        }
        return duplicate;
    }
}