package poro.gui;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import poro.MainClass;
import test.module.BigBug;

public class DangNhapJDialogTest {
	@BeforeTest
	public void openProject() throws InterruptedException {
		new Thread(() -> {
			MainClass.main(null);
		}).start();
		Thread.sleep(3500);
	}
	
	@AfterMethod
	public void hideMain() throws InterruptedException {
		Thread.sleep(1000);
	}
	
	@AfterTest
	public void closeProject() throws InterruptedException {
		Thread.sleep(2000);
		new Thread(() -> {
			MainClass.mainJFrame.dispose();
		}).start();
		Thread.sleep(1000);
		BigBug.keyClick("enter");
	}
	
	@Test(timeOut = 10000, priority = 0)
	public void loginFail1() throws InterruptedException {

		MainClass.dangNhapJDialog.txtTaiKhoan.setText("");
		MainClass.dangNhapJDialog.txtPassword.setText("");
		MainClass.dangNhapJDialog.txtTaiKhoan.requestFocus();

		BigBug.writeString("vinhlm");
		BigBug.keyClick("tab");
		BigBug.keyPressMutil("shift", "tab");
		BigBug.keyPressMutil("capslock");
		BigBug.writeString("error");
		BigBug.keyPressMutil("capslock");
		BigBug.keyClick("tab");
		BigBug.writeString("vinhlm");
		BigBug.keyClick("tab");
		BigBug.keyClick("tab");
		BigBug.keyClick("enter");
		Thread.sleep(700);
		BigBug.keyClick("enter");
		Assert.assertFalse(MainClass.mainJFrame.isVisible());
	}
	
	@Test(timeOut = 10000, priority = 1)
	public void loginOk() throws InterruptedException {
		
		MainClass.dangNhapJDialog.txtTaiKhoan.setText("");
		MainClass.dangNhapJDialog.txtPassword.setText("");
		MainClass.dangNhapJDialog.txtTaiKhoan.requestFocus();
		
		BigBug.writeString("vinhlm");
		BigBug.keyClick("tab");
		BigBug.writeString("vinhlm");
		BigBug.keyClick("tab");
		BigBug.keyClick("tab");
		BigBug.keyClick("enter");
		Thread.sleep(700);
		Assert.assertTrue(MainClass.mainJFrame.isVisible());
	}
}
