package poro.module;

import org.testng.Assert;
import org.testng.annotations.Test;
import poro.module.db.data.TaiKhoan;

public class SessionTest {

	@Test
	public void isLoginTest() {
		Session.USER = new TaiKhoan();
		Assert.assertTrue(Session.isLogin());
		
		Session.USER = null;		
		Assert.assertFalse(Session.isLogin());
	}

	@Test
	public void logoffTest() {
		Session.USER = new TaiKhoan();

		Session.logoff();

		Assert.assertNull(Session.USER);
	}

	@Test(enabled = false)
	public void exitTest() {
		Session.exit();
		Assert.fail();
	}
}
