package poro.gui;

import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.plaf.basic.BasicBorders.MenuBarBorder;

import org.openqa.selenium.By.ByTagName;
import org.openqa.selenium.interactions.Mouse;
import org.openqa.selenium.interactions.MoveMouseAction;
import org.openqa.selenium.interactions.internal.MouseAction;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import poro.MainClass;
import poro.module.Session;
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
	@Test(timeOut = 10000, priority = 1, dataProvider = "dnthanhcong")
	public void dangnhapthanhcong(String username, String password) throws InterruptedException{
		DangNhapJDialog dn = Babysitter.getWindow(DangNhapJDialog.class);
		 BigBug.writeString(dn.txtTaiKhoan,username);
		
		 BigBug.writeString(dn.txtPassword,password);
		 Thread.sleep(200);
		 new Thread(()->{
			 dn.btnDangNhap.doClick();
		 }).start();
		 Thread.sleep(500);
		 
		 Assert.assertTrue(MainClass.mainJFrame.isVisible());
	}
	
	@Test(timeOut = 10000,priority = 6,  dataProvider = "dnthanhcong")
	public void dangxuat(String username,String password) throws InterruptedException {
		DangNhapJDialog dn = Babysitter.getWindow(DangNhapJDialog.class);
		 BigBug.writeString(dn.txtTaiKhoan,username);
	
		 BigBug.writeString(dn.txtPassword,password);
		 Thread.sleep(200);
		 new Thread(()->{
			 dn.btnDangNhap.doClick();
		 }).start();
		 Thread.sleep(2000);
		 new Thread(()->{
			 MainClass.mainJFrame.mniDangXuat.doClick();
		 }).start();
		 Thread.sleep(5000);
		 Assert.assertNull(Session.USER);
		
	}
	
	

	

	
	@DataProvider(name="quenmatkhau")
	public Object[][] getqmk(){
		return new Object[][] {
			{"phongtcpc01275@fpt.edu.vn"}
		};
		
	}
	
	@DataProvider(name = "userFail")
	public Object[][] getUser() {
		return new Object[][] {
				{"phongtc", "1"},
				{"", "vipass"},
				{"vinhlm", ""},
				{"phongtc","PHONGPASS"},
			
				
		};
	}
	@DataProvider(name = "dnthanhcong")
	public Object[][] getUser1() {
		return new Object[][] {
				{"phongtc", "phongpass"},
			
			
				
		};
	}
}
