package poro.gui;

import static org.testng.Assert.assertEquals;

import javax.swing.JDialog;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import poro.MainClass;
import poro.module.Session;
import test.module.Babysitter;
import test.module.BigBug;

public class QuanLyTaiKhoanJPanelTest {

	QuanLyTaiKhoanJPanel qltk;

	@BeforeClass
	public void init() throws InterruptedException {
		Babysitter.showMain();
		// Đăng nhập
		BigBug.writeString(MainClass.dangNhapJDialog.txtTaiKhoan, "loilh");
		BigBug.writeString(MainClass.dangNhapJDialog.txtPassword, "loipass");
		Thread.sleep(500);
		MainClass.dangNhapJDialog.btnDangNhap.doClick();
	}

	@AfterClass
	public void close() {
		Babysitter.closeMain();
	}

	@BeforeMethod
	public void resetForm() throws InterruptedException {
		MainClass.mainJFrame.setGiaoDien(Session.USER.isPhanQuyen());
		Thread.sleep(500);
		MainClass.mainJFrame.mniQLTaiKhoanActionPerformed(null);
		qltk = Babysitter.getTabPanelSelected();
		Thread.sleep(200);
	}

	@AfterMethod
	public void delay() throws InterruptedException {
		Thread.sleep(500);
	}
	
	//Test Thêm tài khoản
	@Test(timeOut = 10000, priority = 0, dataProvider = "InsertAccount")
	public void themTaiKhoan(String username, String email, String fname, String phone, String password,
			String confirmPass, boolean quanLy) throws InterruptedException {
		
		BigBug.writeString(qltk.txtTenTaiKhoan, username);
		BigBug.writeString(qltk.txtEmail, email);
		BigBug.writeString(qltk.txtHoVaTen, fname);
		BigBug.writeString(qltk.txtSoDienThoai, phone);
		BigBug.writeString(qltk.txtMatKhau, password);
		BigBug.writeString(qltk.txtXacNhanMatKhau, confirmPass);
		qltk.chkQuanLy.setSelected(quanLy);
		
		Thread.sleep(200);
		new Thread(() -> {
			qltk.btnThem.doClick();
		}).start();
		Thread.sleep(500);

		JDialog jp = Babysitter.getWindow(JDialog.class);

		Thread.sleep(200);

		Assert.assertEquals(jp.getTitle(), "Message");

		jp.setVisible(false);
		Thread.sleep(200);
	}

	@DataProvider(name = "InsertAccount")
	public Object[][] getAccount() {
		return new Object[][] {
				{ "loilhpc01261", "loilh@gmail.com", "Lương Hữu Lợi", "0909123456", "123abc", "123abc", true },
				{ "huuloi", "loiabc@gmail.com", "Lương Hữu Lợi", "0909123456", "123abc", "123abc", false },
				{ "loilh123", "loi123@gmail.com", "", "", "", "", true },
				{ "huuloi123", "emailsai", "Lương Hữu Lợi", "0909123456", "123abc", "123abc", true },
				{ "loixyz", "loixyz@gmail.com", "Lương Hữu Lợi", "9999", "123abc", "123abc", true },
				{ "loizz", "loizz@gmail.com", "Lương Hữu Lợi", "0909123456", "123abc", "123", true }
				};
	}
	
	//Test Cập nhật Tài Khoản
	@Test(timeOut = 10000 , priority = 1, dataProvider = "UpdateAccount")
	public void capNhatTaiKhoan(String email, String fname, String phone) throws InterruptedException {		
		
		Thread.sleep(500);
		qltk.tabs.setSelectedIndex(1);
		Thread.sleep(500);
		
		qltk.tblTaiKhoan.setRowSelectionInterval(2, 2);
		Thread.sleep(500);
		qltk.selectTable();	
		Thread.sleep(500);
		
		BigBug.writeString(qltk.txtEmail, email);
		BigBug.writeString(qltk.txtHoVaTen, fname);
		BigBug.writeString(qltk.txtSoDienThoai, phone);
		
		
		Thread.sleep(500);
		new Thread(() -> {
			qltk.btnCapNhat.doClick();
		}).start();
		Thread.sleep(500);

		JDialog jp = Babysitter.getWindow(JDialog.class);
		
		Thread.sleep(500);

		Assert.assertEquals(jp.getTitle(), "Message");

		jp.setVisible(false);
		
		Thread.sleep(500);
		
	}
	
	@DataProvider(name = "UpdateAccount")
	public Object[][] updateAccount() {
		return new Object[][] {
				{"huuloi@gmail.com", "Hữu Lợi", "0333456789"},
				{"", "Hữu Lợi", "0333456789"},
				{"huuloi@gmail.com", "", "0333456789"},
				{"huuloi@gmail.com", "Hữu Lợi", ""},
				{"emailsai", "Hữu Lợi", "0333456789"},
				{"huuloi@gmail.com", "Hữu Lợi", "123"},
		};
	}
	
	//Test Xóa Tài Khoản
	@Test(timeOut = 10000 ,priority = 2)
	public void XoaTaiKhoan() throws InterruptedException{
		
		Thread.sleep(500);
		qltk.tabs.setSelectedIndex(1);
		
		Thread.sleep(500);
		qltk.tblTaiKhoan.setRowSelectionInterval(3, 3);
		Thread.sleep(500);
		qltk.selectTable();	
		Thread.sleep(500);
		
		Thread.sleep(500);
		new Thread(() -> {
			qltk.btnXoa.doClick();
		}).start();
		Thread.sleep(500);
		
		JDialog jp = Babysitter.getWindow(JDialog.class);
		
		Thread.sleep(500);

		Assert.assertEquals(jp.getTitle(), "Message");
		
		jp.setVisible(false);
		
		Thread.sleep(500);
		
	}
	
	//Test Làm Mới
	@Test(timeOut = 10000, priority = 3, dataProvider = "NewAccount")
	public void lamMoi(String username, String email, String fname, String phone, String password,
			String confirmPass, boolean quanLy) throws InterruptedException {
		
		BigBug.writeString(qltk.txtTenTaiKhoan, username);
		BigBug.writeString(qltk.txtEmail, email);
		BigBug.writeString(qltk.txtHoVaTen, fname);
		BigBug.writeString(qltk.txtSoDienThoai, phone);
		BigBug.writeString(qltk.txtMatKhau, password);
		BigBug.writeString(qltk.txtXacNhanMatKhau, confirmPass);
		qltk.chkQuanLy.setSelected(quanLy);
		
		Thread.sleep(200);
		new Thread(() -> {
			qltk.btnMoi.doClick();
		}).start();
		Thread.sleep(500);

		JDialog jp = Babysitter.getWindow(JDialog.class);

		Thread.sleep(200);
	}

	@DataProvider(name = "NewAccount")
	public Object[][] newAccount() {
		return new Object[][] {
				{ "loi12345", "loilh@gmail.com", "Lương Hữu Lợi", "0909123456", "123abc", "123abc", true }
				};
	}
}
