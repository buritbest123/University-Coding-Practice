import static org.junit.Assert.*;

import org.junit.Test;


public class TestCase {
	
	@Test	// 10 points
	public void testConstructor(){
		AccountManager am = new AccountManager(5);
		assertEquals(5, Account.FAIL_ATTEMPT_LIMIT);
		assertTrue(am.accounts.isEmpty());
	}

	@Test 	// 10 points
	public void testRegisterAccount() {
		Account myAccount = new Account("abc", "m1dt3rm");
		Account anAccount = new Account("xyz", "Ex@m");
		Account fakeAccount = new Account("abc", "midterm");
		
		AccountManager am = new AccountManager(2);
		
		// getLastAccount
		assertEquals(am.getLastAccount(), null);
		
		// register new accounts
		assertTrue(am.registerAccount(myAccount));
		assertTrue(am.registerAccount(anAccount));
		assertFalse(am.registerAccount(fakeAccount));
		assertFalse(am.registerAccount(null));
		
		// getLastAccount
		assertEquals(am.getLastAccount(), anAccount);
	}

	@Test	// 10 points
	public void testLogin() {
		Account myAccount = new Account("abc", "m1dt3rm");
		
		AccountManager am = new AccountManager(5);
		
		// register a new account
		am.registerAccount(myAccount);
		
		// login successfully
		assertTrue(am.login("abc", "m1dt3rm"));
		assertEquals(0, myAccount.getLoginFail());
		
		// login failed: incorrect password
		assertFalse(am.login("abc", "midterm"));
		// loginFail is increased by one
		assertEquals(1, myAccount.getLoginFail());
		
		// login failed: incorrect password
		assertFalse(am.login("abc", "midterm2"));
		// loginFail is increased by one
		assertEquals(2, myAccount.getLoginFail());
		
		// login successfully
		assertTrue(am.login("abc", "m1dt3rm"));
		// loginFail is reset
		assertEquals(0, myAccount.getLoginFail());
				
		// login failed: username doesn't exist
		assertFalse(am.login("xyz", "midterm2"));
		// no effect on the existing account
		assertEquals(0, myAccount.getLoginFail());
	}
	
	@Test	// 10 points
	public void testResetPassword() {
		Account myAccount = new Account("abc", "m1dt3rm");
		Account fakeAccount = new Account("abc", "midterm");
		Account newAccount = new Account("xyz", "Ex@m");
		
		AccountManager am = new AccountManager(2);
		am.registerAccount(myAccount);
		
		// null account
		assertFalse(am.resetPassword(null, "123456"));
		
		// incorrect old password
		assertFalse(am.resetPassword(fakeAccount, "123456"));
		
		// unregistered account
		assertFalse(am.resetPassword(newAccount, "123456"));
		
		// successfully reset password
		assertTrue(am.resetPassword(myAccount, "123456"));
		assertTrue(myAccount.authentication("123456"));
		
	}
}
