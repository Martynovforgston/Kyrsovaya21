package settings;

import static org.junit.Assert.assertTrue;

import org.junit.BeforeClass;
import org.junit.Test;

import core.login.Account;
import core.settings.AccountsManager;
import core.settings.PropertyGeneric;

public class AccountsManagerTest {

	static AccountsManager accounts;
	
	@BeforeClass
	public static void beforeClass() {
		accounts = new AccountsManager();
		accounts.load();
	}
	
	@Test
	public void settingsTest() {
		accounts.add(new PropertyGeneric<Account>("admin123", new Account("admin123", "pass123", true)));
		PropertyGeneric<Account> account = accounts.find("admin123");
		assertTrue(account.getValue().isAdmin());
	}
}
