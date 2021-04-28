package poro.gui;

import javax.swing.JDialog;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import test.module.Babysitter;
import test.module.BigBug;

public class QuenMatKhauJDialogTest {
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
	
	
	@Test(timeOut = 30000, priority = 3, dataProvider = "quenmatkhauthatbai")
	public void quenmatkhauthatbai(String email) throws InterruptedException {
	
		DangNhapJDialog dn = Babysitter.getWindow(DangNhapJDialog.class);
		 new Thread(()->{
			 dn.btnQuenMatKhauActionPerformed(null);
		 }).start();
		 Thread.sleep(500);
		 QuenMatKhauJDialog qmk = Babysitter.getWindow(QuenMatKhauJDialog.class);
		 
		 BigBug.writeString(qmk.txtemail, email);
		
		 new Thread(()->{
			qmk.btnGuiMaActionPerformed(null);
		 }).start();
		 Thread.sleep(500);
		
		 JDialog message = Babysitter.getWindow(qmk, JDialog.class);
		 Thread.sleep(500);
		 message.setVisible(false);
		 
		 BigBug.writeString(qmk.txtMaOTP, qmk.otp);
		 
		 new Thread(() -> {
			 qmk.btnXacNhan.doClick();
			 
		 });
		 Thread.sleep(5000);
			
		 DoiMatKhauJDialog dmk = qmk.doiMatKhauJDialog;
		 BigBug.writeString(dmk.txtPassMoi1, "phongpass");
		 BigBug.writeString(dmk.txtPassMoi2, "phongpass");
		 new Thread(() -> {
			 dmk.btnMatKhauActionPerformed(null);
		 });
		 Thread.sleep(5000);
		 
		DangNhapJDialog dnl = Babysitter.getWindow(DangNhapJDialog.class);
		BigBug.writeString(dnl.txtTaiKhoan,"phongtc");
		BigBug.writeString(dnl.txtPassword,"phongpass");
		 new Thread(()->{
			 dnl.btnDangNhap.doClick();
		 }).start();
		 Thread.sleep(500);
		 
	}
	
	@Test(timeOut = 30000, priority = 3, dataProvider = "quenmatkhau")
	public void quenmatkhauthatbai1(String email) throws InterruptedException {
	
		DangNhapJDialog dn = Babysitter.getWindow(DangNhapJDialog.class);
		 new Thread(()->{
			 dn.btnQuenMatKhauActionPerformed(null);
		 }).start();
		 Thread.sleep(500);
		 QuenMatKhauJDialog qmk = Babysitter.getWindow(QuenMatKhauJDialog.class);
		 
		 BigBug.writeString(qmk.txtemail, email);
		
		 new Thread(()->{
			qmk.btnGuiMaActionPerformed(null);
		 }).start();
		 Thread.sleep(500);
		
		 JDialog message = Babysitter.getWindow(qmk, JDialog.class);
		 Thread.sleep(500);
		 message.setVisible(false);
		 
		 BigBug.writeString(qmk.txtMaOTP, "8456");
		 
		 new Thread(() -> {
			 qmk.btnXacNhan.doClick();
			 
		 });
		 Thread.sleep(5000);
			
		 DoiMatKhauJDialog dmk = qmk.doiMatKhauJDialog;
		 BigBug.writeString(dmk.txtPassMoi1, "phongpass");
		 BigBug.writeString(dmk.txtPassMoi2, "phongpass");
		 new Thread(() -> {
			 dmk.btnMatKhauActionPerformed(null);
		 });
		 Thread.sleep(5000);
		 
		DangNhapJDialog dnl = Babysitter.getWindow(DangNhapJDialog.class);
		BigBug.writeString(dnl.txtTaiKhoan,"phongtc");
		BigBug.writeString(dnl.txtPassword,"phongpass");
		 new Thread(()->{
			 dnl.btnDangNhap.doClick();
		 }).start();
		 Thread.sleep(500);
		 
	}
	
	
	@Test(timeOut = 30000, priority = 3, dataProvider = "quenmatkhau")
	public void quenmatkhau(String email) throws InterruptedException {
	
		DangNhapJDialog dn = Babysitter.getWindow(DangNhapJDialog.class);
		 new Thread(()->{
			 dn.btnQuenMatKhauActionPerformed(null);
		 }).start();
		 Thread.sleep(500);
		 QuenMatKhauJDialog qmk = Babysitter.getWindow(QuenMatKhauJDialog.class);
		 
		 BigBug.writeString(qmk.txtemail, email);
		
		 new Thread(()->{
			qmk.btnGuiMaActionPerformed(null);
		 }).start();
		 Thread.sleep(500);
		
		 JDialog message = Babysitter.getWindow(qmk, JDialog.class);
		 Thread.sleep(500);
		 message.setVisible(false);
		 
		 BigBug.writeString(qmk.txtMaOTP, qmk.otp);
		 
		 new Thread(() -> {
			 qmk.btnXacNhan.doClick();
			 
		 });
		 Thread.sleep(5000);
			
		 DoiMatKhauJDialog dmk = qmk.doiMatKhauJDialog;
		 BigBug.writeString(dmk.txtPassMoi1, "phongpass");
		 BigBug.writeString(dmk.txtPassMoi2, "phongpass");
		 new Thread(() -> {
			 dmk.btnMatKhauActionPerformed(null);
		 });
		 Thread.sleep(5000);
		 
		DangNhapJDialog dnl = Babysitter.getWindow(DangNhapJDialog.class);
		BigBug.writeString(dnl.txtTaiKhoan,"phongtc");
		BigBug.writeString(dnl.txtPassword,"phongpass");
		 new Thread(()->{
			 dnl.btnDangNhap.doClick();
		 }).start();
		 Thread.sleep(500);
		 
	}
	
	
	
  
  @DataProvider(name="quenmatkhau")
	public Object[][] getqmk(){
		return new Object[][] {
			{"phongtcpc01275@fpt.edu.vn"}
		};
		
	}
  @DataProvider(name="quenmatkhauthatbai")
	public Object[][] getqmk1(){
		return new Object[][] {
			{"phongtcpc012751@fpt.edu.vn"}
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
