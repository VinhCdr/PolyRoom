package poro.gui;

import javax.swing.JDialog;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import poro.MainClass;
import test.module.Babysitter;
import test.module.BigBug;

public class DangNhapJDialogTest {
	@BeforeTest
	public void openProject() throws InterruptedException {
		Babysitter.showMain();
	}
	
	@AfterMethod
	public void delay() throws InterruptedException {
		Thread.sleep(1000);
	}
	
	@AfterTest
	public void closeProject() throws InterruptedException {
		Babysitter.closeMain();
	}
	
	@Test(timeOut = 10000, priority = 0, dataProvider = "userFail")
	public void loginFail(String username, String password) throws InterruptedException {
		
		DangNhapJDialog dnj = Babysitter.getWindow(DangNhapJDialog.class);
		
		BigBug.writeString(dnj.txtTaiKhoan, username);
		BigBug.writeString(dnj.txtPassword, password);
		
		Thread.sleep(200);
		new Thread(() -> {
			dnj.btnDangNhap.doClick();
		}).start();
		Thread.sleep(500);

		
		JDialog jd = Babysitter.getWindow(dnj, JDialog.class);
		
		Thread.sleep(200);
		
		Assert.assertEquals(jd.getTitle(), "Message");
		
		jd.setVisible(false);
		Thread.sleep(200);
		
		
		Assert.assertFalse(MainClass.mainJFrame.isVisible());
	}
	
	@DataProvider(name = "userFail")
	public Object[][] getUser() {
		return new Object[][] {
				{"vinhlm", "vipassx"},
				{"", "vipass"},
				{"vinhlm", ""}
		};
	}
}
