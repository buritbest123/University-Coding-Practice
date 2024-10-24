import java.util.ArrayList;

public class AccountManager {

    // Instance Field
        // Declare accounts variable as an arraylist of Account with public access modifier

    public ArrayList<Account> accounts;

    // Constructors
        /* o Initialize the accounts arraylist
           o Assign the value of failLimit to the static variable FAIL_ATTEMPT_LIMIT in the Account class*/

    AccountManager(int failLimit) {
        accounts = new ArrayList<Account>();
        Account.FAIL_ATTEMPT_LIMIT = failLimit;
    }

    // Method
        // registerAccount
    /* o To add a new account into the accounts arraylist and return true.
       o If the username of the new account already exists or the given account is null,
        do nothing and return false.*/

    public boolean registerAccount(Account acc) {
        if (acc == null) {
            return false;
        }
        // check username if it exists in accounts (already exists)
        for (Account account : accounts) {
            if (acc.getUsername().equals(account.getUsername())) {
                return false;
            }
        }

        this.accounts.add(acc); // add a new account
        return true;

    }

        // getLastAccount
    /* o To return an account object at the last index of the arraylist.
       o If the arraylist is empty, return null. */

    public Account getLastAccount() {
        if (this.accounts.isEmpty()) {
            return null;
        }
        return this.accounts.get(this.accounts.size() - 1);
    }

        // login
    /* To validate the given username and password with all accounts in the arraylist.
        o If both username and password are matched with any account in the arraylist, the
          login is valid. This method has to set the loginFail attribute of the matched
          account to 0 and return true.
        o If the username is found in the arraylist but the password is incorrect, the login is
          failed. This method must increase loginFail value of the found account by one
          and return false. In addition, when the loginFail is higher than the
          FAIL_ATTEMPT_LIMIT value, a warning message must be displayed (see expected result).
        o If the username does not exist in the arraylist, do nothing and return false. */

    public boolean login(String username, String password) {
        // find this username is in accounts ot not?
        for (Account account : accounts) {
            if (account.getUsername().equals(username)) {
                // username
                return account.authentication(password);
            }
        }
        return false;
    }

    // resetPassword
    /* To reset a new password of the given account.
    o If the given account is equals (both username and password are matched) to any
      account in the arraylist, set a new password for that particular account and return
      true. Otherwise, return false.
    o Note! Unlike login method, you don’t have to modify the loginFail value. */

    public boolean resetPassword(Account acc, String newPassword) {

        if (acc == null) {
            return false;
        }

        for (Account account : accounts) {
            // acc == account ?
            if (acc.isEquals(account)) {
                account.setPassword(newPassword);
                return true;
            }
        }

        return false;
    }

}