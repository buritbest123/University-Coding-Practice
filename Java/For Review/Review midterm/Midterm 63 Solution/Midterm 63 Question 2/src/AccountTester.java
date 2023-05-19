
/*
 * DO NOT MODIFY THIS CLASS
 */

public class AccountTester {
	
	public static void main(String[] args){
		
		// example accounts
		Account myAccount = new Account("abc", "m1dt3rm");
		Account anAccount = new Account("xyz", "Ex@m");
		Account fakeAccount = new Account("abc", "midterm");
		Account loginAccount = new Account("abc", "m1dt3rm");
		
		// construct AccountManager object
		AccountManager am = new AccountManager(2);
		System.out.print("[00] fail attempt limit is " + Account.FAIL_ATTEMPT_LIMIT);
		if(am.accounts.isEmpty())
			System.out.println(", and construct object successfully");
		
		// register new accounts
		if(am.registerAccount(myAccount))
			System.out.println("\n[01] " + am.getLastAccount() + ", register successfully");
		
		if(am.registerAccount(anAccount))
			System.out.println("[02] " + am.getLastAccount() + ", register successfully");
		
		if(!am.registerAccount(fakeAccount))
			System.out.println("[03] Sorry, abc username already exists!");
		
		if(!am.registerAccount(null))
			System.out.println("[04] Sorry, cannot register NULL account");
		
		// login with username and password
		if(am.login("abc", "m1dt3rm"))
			System.out.println("\n[05] abc login successfully");
		
		if(am.login("xyz", "Ex@m"))
			System.out.println("[06] xyz login successfully");
		
		if(!am.login("xyz", "ex@m"))
			System.out.println("[07] xyz login failed (" + anAccount.getLoginFail() + ")");
		
		if(!am.login("xyz", "1x@m"))
			System.out.println("[08] xyz login failed (" + anAccount.getLoginFail() + ")");
		
		if(!am.login("xyz", "2x@m"))
			System.out.println("[09] xyz login failed (" + anAccount.getLoginFail() + ")");
		
		// reset password
		String newPassword = "UC@nD01t";
		
		if(!am.resetPassword(fakeAccount, newPassword))
			System.out.println("\n[10] Couldn't reset password with account " + fakeAccount);
		
		if(am.resetPassword(loginAccount, newPassword)){
			System.out.println("[11] Reset password successfully");
			
			// try to login with a new password
			if(am.login(loginAccount.getUsername(), newPassword))
				System.out.println("[12] abc login successfully");
		}
			
		
	}
}
