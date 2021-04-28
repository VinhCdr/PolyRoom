package poro.gui;

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

	@Test(timeOut = 10000, priority = 0, dataProvider = "InsertAccount")
	public void dangKyTaiKhoan(String username, String email, String fname, String phone, String password,
			String confirmPass) throws InterruptedException {
		
		qltk = Babysitter.getTabPanelSelected();

		BigBug.writeString(qltk.txtTenTaiKhoan, username);
		BigBug.writeString(qltk.txtEmail, email);
		BigBug.writeString(qltk.txtHoVaTen, fname);
		BigBug.writeString(qltk.txtSoDienThoai, phone);
		BigBug.writeString(qltk.txtMatKhau, password);
		BigBug.writeString(qltk.txtXacNhanMatKhau, confirmPass);
		// Còn phần kiểm tra checkbox???

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
				{ "loilhpc01261", "loilh@gmail.com", "Lương Hữu Lợi", "0909123456", "123abc", "123abc" },
				{ "loilh123", "loilh@gmail.com", "", "", "", "" },
				{ "loilh123", "emailsai", "Lương Hữu Lợi", "0909123456", "123abc", "123abc" },
				{ "loilhpc01261", "loilh@gmail.com", "Lương Hữu Lợi", "9999", "123abc", "123abc" },
				{ "loilhpc01261", "loilh@gmail.com", "Lương Hữu Lợi", "0909123456", "123abc", "123" }, };
	}
}
