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

public class ThongKeJPanelTest {
ThongKeJPanel tk;
	
	@BeforeClass
	public void init() throws InterruptedException {
		Babysitter.showMain();
		// Đăng nhập
		BigBug.writeString(MainClass.dangNhapJDialog.txtTaiKhoan, "linhntt");
		BigBug.writeString(MainClass.dangNhapJDialog.txtPassword, "linhpass");
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
	public void thongke() throws InterruptedException {
		tk = Babysitter.getTabPanelSelected();
		tk.tblPhong.setRowSelectionInterval(0, 0);
		Thread.sleep(500);
		Assert.assertEquals(tk.tblPhong.getValueAt(0, 0).toString(), "101");
		Assert.assertEquals(tk.tblPhong.getValueAt(0, 1).toString(), "1");
		Assert.assertEquals(tk.tblPhong.getValueAt(0, 2).toString(), "1");
		Assert.assertEquals(tk.tblPhong.getValueAt(0, 3).toString(), "1");
		Assert.assertEquals(tk.tblPhong.getValueAt(0, 4).toString(), "0");
		Assert.assertEquals(tk.tblPhong.getValueAt(0, 5).toString(), "0");
		Assert.assertEquals(tk.tblPhong.getValueAt(0, 6).toString(), "0.00 giờ");
	}
	
	@Test
	public void thongke1() throws InterruptedException {
		tk = Babysitter.getTabPanelSelected();
		tk.tblPhong.setRowSelectionInterval(1, 1);
		Thread.sleep(500);
		Assert.assertEquals(tk.tblPhong.getValueAt(1, 0).toString(), "102");
		Assert.assertEquals(tk.tblPhong.getValueAt(1, 1).toString(), "1");
		Assert.assertEquals(tk.tblPhong.getValueAt(1, 2).toString(), "2");
		Assert.assertEquals(tk.tblPhong.getValueAt(1, 3).toString(), "1");
		Assert.assertEquals(tk.tblPhong.getValueAt(1, 4).toString(), "0");
		Assert.assertEquals(tk.tblPhong.getValueAt(1, 5).toString(), "0");
		Assert.assertEquals(tk.tblPhong.getValueAt(1, 6).toString(), "0.00 giờ");
	}
}
