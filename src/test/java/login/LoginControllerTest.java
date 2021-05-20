package login;

import static org.junit.Assert.assertNotNull;

import org.junit.BeforeClass;
import org.junit.Test;
import core.login.Account;
import core.login.LoginController;

public class LoginControllerTest {

	static LoginController controller;
	
	@BeforeClass
	public static void beforeClass() {
		controller = new LoginController();
	}
	
	@Test
	public void mainFrameTest() {
		Account account = controller.login("user", "user");
		assertNotNull(account);
	}
}
