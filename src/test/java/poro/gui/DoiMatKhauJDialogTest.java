package poro.gui;

import javax.swing.JDialog;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import poro.MainClass;
import poro.module.Encrypter;
import poro.module.db.DatabaseManager;
import poro.module.db.data.TaiKhoan;
import test.module.Babysitter;
import test.module.BigBug;

public class DoiMatKhauJDialogTest {

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

	@Test(timeOut = 10000, priority = 4, dataProvider = "dnthanhcong")
	public void doimatkhau(String username, String password) throws InterruptedException {
		DangNhapJDialog dn = Babysitter.getWindow(DangNhapJDialog.class);

		BigBug.writeString(dn.txtTaiKhoan, username);

		BigBug.writeString(dn.txtPassword, password);
		Thread.sleep(200);
		new Thread(() -> {
			dn.btnDangNhap.doClick();
		}).start();
		Thread.sleep(500);

		new Thread(() -> {
			MainClass.mainJFrame.btnDoiMatKhau.doClick();

		}).start();
		Thread.sleep(500);
		DoiMatKhauJDialog jd = Babysitter.getWindow(DoiMatKhauJDialog.class);
		BigBug.writeString(jd.txtPassCu, "phongpass");
		BigBug.writeString(jd.txtPassMoi1, "phongpass");
		BigBug.writeString(jd.txtPassMoi2, "phongpass");
		new Thread(() -> {
			jd.btnMatKhau.doClick();
		}).start();
		Thread.sleep(500);
		JDialog jdMessage = Babysitter.getWindow(jd, JDialog.class);
		jdMessage.setVisible(false);
		//
		TaiKhoan taiKhoan = new TaiKhoan();
		taiKhoan.setIdTaiKhoan("phongtc");
		taiKhoan = DatabaseManager.executeQuery(taiKhoan, TaiKhoan.EXECUTE_SELECT_BY_ID).get(0);
		Assert.assertEquals(taiKhoan.getMatKhau(), Encrypter.toMD5("phongpass"));

	}

	@Test(timeOut = 10000, priority = 5, dataProvider = "dnthanhcong")
	public void doimatkhauthatbai(String username, String password) throws InterruptedException {
		DangNhapJDialog dn = Babysitter.getWindow(DangNhapJDialog.class);

		BigBug.writeString(dn.txtTaiKhoan, username);

		BigBug.writeString(dn.txtPassword, password);
		Thread.sleep(200);
		new Thread(() -> {
			dn.btnDangNhap.doClick();
		}).start();
		Thread.sleep(500);

		new Thread(() -> {
			MainClass.mainJFrame.btnDoiMatKhau.doClick();
		}).start();
		Thread.sleep(500);
		DoiMatKhauJDialog jd = Babysitter.getWindow(DoiMatKhauJDialog.class);
		BigBug.writeString(jd.txtPassCu, "phongpass1");
		BigBug.writeString(jd.txtPassMoi1, "phongpassXX");
		BigBug.writeString(jd.txtPassMoi2, "phongpassXX");
		new Thread(() -> {
			jd.btnMatKhau.doClick();
		}).start();
		Thread.sleep(500);
		JDialog jdMessage = Babysitter.getWindow(jd, JDialog.class);
		jdMessage.setVisible(false);

		TaiKhoan taiKhoan = new TaiKhoan();
		taiKhoan.setIdTaiKhoan("phongtc");
		taiKhoan = DatabaseManager.executeQuery(taiKhoan, TaiKhoan.EXECUTE_SELECT_BY_ID).get(0);
		Assert.assertEquals(taiKhoan.getMatKhau(), Encrypter.toMD5("phongpass"));
	}

	@Test(timeOut = 10000, priority = 5, dataProvider = "dnthanhcong")
	public void doimatkhauthatbai1(String username, String password) throws InterruptedException {
		DangNhapJDialog dn = Babysitter.getWindow(DangNhapJDialog.class);

		BigBug.writeString(dn.txtTaiKhoan, username);

		BigBug.writeString(dn.txtPassword, password);
		Thread.sleep(200);
		new Thread(() -> {
			dn.btnDangNhap.doClick();
		}).start();
		Thread.sleep(500);

		new Thread(() -> {
			MainClass.mainJFrame.btnDoiMatKhau.doClick();

		}).start();
		Thread.sleep(500);
		DoiMatKhauJDialog jd = Babysitter.getWindow(DoiMatKhauJDialog.class);
		BigBug.writeString(jd.txtPassCu, "phongpass");
		BigBug.writeString(jd.txtPassMoi1, "phongpass1");
		BigBug.writeString(jd.txtPassMoi2, "phongpass2");
		new Thread(() -> {
			jd.btnMatKhau.doClick();

		}).start();
		Thread.sleep(500);

	}

	@DataProvider(name = "quenmatkhau")
	public Object[][] getqmk() {
		return new Object[][] { { "phongtcpc01275@fpt.edu.vn" } };

	}

	@DataProvider(name = "userFail")
	public Object[][] getUser() {
		return new Object[][] { { "phongtc", "1" }, { "", "vipass" }, { "vinhlm", "" }, { "phongtc", "PHONGPASS" },

		};
	}

	@DataProvider(name = "dnthanhcong")
	public Object[][] getUser1() {
		return new Object[][] { { "phongtc", "phongpass" }, };
	}
}
