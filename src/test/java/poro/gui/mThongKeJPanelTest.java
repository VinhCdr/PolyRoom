package poro.gui;

import javax.swing.JDialog;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import poro.MainClass;
import poro.module.Session;
import test.module.Babysitter;
import test.module.BigBug;

public class mThongKeJPanelTest {
ThongKeJPanel tk;
	
	@BeforeClass
	public void init() throws InterruptedException {
		Babysitter.showMain();
		// Đăng nhập
		BigBug.writeString(MainClass.dangNhapJDialog.txtTaiKhoan, "minhvhn");
		BigBug.writeString(MainClass.dangNhapJDialog.txtPassword, "minhpass");
		Thread.sleep(500);
		MainClass.dangNhapJDialog.btnDangNhapActionPerformed(null);
	}
	
	@AfterClass
	public void close() {
		Babysitter.closeMain();
	}
	
	@BeforeMethod
	public void resetForm() throws InterruptedException {
		MainClass.mainJFrame.setGiaoDien(Session.USER.isPhanQuyen());
		Thread.sleep(500);
		MainClass.mainJFrame.mniThongKeGvActionPerformed(null);
		tk = Babysitter.getTabPanelSelected();
		Thread.sleep(200);
	}

	@AfterMethod
	public void delay() throws InterruptedException {
		Thread.sleep(500);
	}
	@Test
	public void thongke() {
		tk= Babysitter.getTabPanelSelected();
	}
}
