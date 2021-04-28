package poro.gui;

import static org.testng.Assert.assertEquals;

import java.awt.Robot;
import java.awt.event.MouseEvent;

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

public class QuanLyPhongJPanelTest {
	
	QuanLyPhongJPanel qlp;
	
	@BeforeClass
	public void init() throws InterruptedException {
		Babysitter.showMain();
		// Đăng nhập
		BigBug.writeString(MainClass.dangNhapJDialog.txtTaiKhoan, "taivt");
		BigBug.writeString(MainClass.dangNhapJDialog.txtPassword, "taipass");
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
		MainClass.mainJFrame.mniQLPhongActionPerformed(null);
		qlp = Babysitter.getTabPanelSelected();
		Thread.sleep(200);
	}

	@AfterMethod
	public void delay() throws InterruptedException {
		Thread.sleep(500);
	}
	
	@Test(timeOut = 10000 , dataProvider = "InsertAccount", priority = 1)
	public void ThemPhong(int sotang, String maphong , String tenphong , boolean muon) throws InterruptedException {
		qlp = Babysitter.getTabPanelSelected();
		
		qlp.cboLau.setSelectedIndex(sotang);
		BigBug.writeString(qlp.txtMaPhong, maphong);
		BigBug.writeString(qlp.txtTenPhong, tenphong);
		qlp.chkChoPhep.setSelected(muon);
		
		
		Thread.sleep(500);
		new Thread(() -> {
			qlp.btnThemPhong.doClick();
		}).start();
		Thread.sleep(500);

		JDialog jp = Babysitter.getWindow(JDialog.class);
		
		Thread.sleep(500);

		Assert.assertEquals(jp.getTitle(), "Message");

		jp.setVisible(false);
		Thread.sleep(500);
		qlp.tabs.setSelectedIndex(1);
		Thread.sleep(2000);
	}
	
	@DataProvider(name = "InsertAccount")
	public Object[][] getAccount() {
		return new Object[][] {
				{ 2,"4","402",true},
				{ 2,"4","402",true},
				{ 2,"404","402",true},
				{ 2,"","402",true},
				{ 2,"tăirq","@!#@!$@!$@!",false},
				{ 0,"","",false},
		};
	}
	
	@Test(timeOut = 10000 , dataProvider = "InsertAccount2", priority = 2)
	public void SuaPhong(String tenphong, boolean muon) throws InterruptedException {

		Thread.sleep(500);
		qlp.tabs.setSelectedIndex(1);
		
		Thread.sleep(500);
		
		qlp.tblPhong.setRowSelectionInterval(4, 4);
		Thread.sleep(500);
		qlp.selectTable();	
		Thread.sleep(500);
		
		BigBug.writeString(qlp.txtTenPhong, tenphong);
		qlp.chkChoPhep.setSelected(muon);
		
		Thread.sleep(500);
		new Thread(() -> {
			qlp.btnSuaPhong.doClick();
		}).start();
		Thread.sleep(500);

		JDialog jp = Babysitter.getWindow(JDialog.class);
		
		Thread.sleep(500);

		Assert.assertEquals(jp.getTitle(), "Message");

		jp.setVisible(false);
		
		Thread.sleep(500);
		qlp.tabs.setSelectedIndex(1);
		Thread.sleep(2000);
		assertEquals(qlp.tblPhong.getValueAt(4, 2), tenphong);
		assertEquals(qlp.tblPhong.getValueAt(4, 3), muon?"Có":"-");
	}
	
	@DataProvider(name = "InsertAccount2")
	public Object[][] getAccount2() {
		return new Object[][] {
				{ "qưe",false},
				{ "qưe",true},
				{ "",true},
				{ "@!#@!$@!$@!",false},
		};
	}
	
	@Test(timeOut = 10000 ,priority = 3)
	public void XoaPhong() throws InterruptedException{
		Thread.sleep(500);
		qlp.tabs.setSelectedIndex(1);
		
		Thread.sleep(500);
		
		qlp.tblPhong.setRowSelectionInterval(6, 6);
		Thread.sleep(500);
		qlp.selectTable();	
		Thread.sleep(500);
		
		Thread.sleep(500);
		new Thread(() -> {
			qlp.btnXoaPhong.doClick();
		}).start();
		Thread.sleep(500);

		JDialog jp = Babysitter.getWindow(JDialog.class);
		
		Thread.sleep(500);

		Assert.assertEquals(jp.getTitle(), "Message");
		
		jp.setVisible(false);
		
		Thread.sleep(500);
		qlp.tabs.setSelectedIndex(1);
		Thread.sleep(2000);
	}
	
	@Test(timeOut = 10000 , dataProvider = "InsertAccount3", priority = 4)
	public void XoaPhongNhap(int chon, String tenphong , boolean muon) throws InterruptedException{
		Thread.sleep(500);
		qlp.tabs.setSelectedIndex(1);
		
		Thread.sleep(500);
		
		qlp.tblPhong.setRowSelectionInterval(chon, chon);
		Thread.sleep(500);
		qlp.selectTable();	
		Thread.sleep(500);
		
		BigBug.writeString(qlp.txtTenPhong, tenphong);
		qlp.chkChoPhep.setSelected(muon);
		
		Thread.sleep(500);
		new Thread(() -> {
			qlp.btnXoaPhong.doClick();
		}).start();
		Thread.sleep(500);

		JDialog jp = Babysitter.getWindow(JDialog.class);
		
		Thread.sleep(500);

		Assert.assertEquals(jp.getTitle(), "Message");
		
		jp.setVisible(false);
		
		Thread.sleep(500);
		qlp.tabs.setSelectedIndex(1);
		Thread.sleep(2000);
	}
	
	@DataProvider(name = "InsertAccount3")
	public Object[][] getAccount3() {
		return new Object[][] {
				{ 7,"zxcasd",true},
				{ 7,"101",true},
		};
	}
}
