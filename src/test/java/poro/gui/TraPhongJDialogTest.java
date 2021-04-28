package poro.gui;

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

public class TraPhongJDialogTest {

	NMXemPhongJPanel nmXem;

	@BeforeClass
	public void init() throws InterruptedException {
		Babysitter.showMain();
		// Đăng nhập
		BigBug.writeString(MainClass.dangNhapJDialog.txtTaiKhoan, "vinhlm");
		BigBug.writeString(MainClass.dangNhapJDialog.txtPassword, "vipass");
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
		MainClass.mainJFrame.mniMuonPhongActionPerformed(null);
		nmXem = Babysitter.getTabPanelSelected();
		Thread.sleep(200);
	}

	@AfterMethod
	public void delay() throws InterruptedException {
		Thread.sleep(500);
	}
	
	@Test
	public void showListTest() throws InterruptedException {
		new Thread(() -> {
			nmXem.btnTraPhongActionPerformed(null);
		}).start();
		Thread.sleep(500);
		
		TraPhongJDialog traPhong = Babysitter.getWindow(TraPhongJDialog.class);
		Assert.assertEquals(traPhong.tblList.getValueAt(0, 0).toString(), "1");
		Assert.assertEquals(traPhong.tblList.getValueAt(0, 1).toString(), "101");
		Assert.assertEquals(traPhong.tblList.getValueAt(0, 2).toString(), "Lê Minh Vinh (vinhlm)");
		Assert.assertEquals(traPhong.tblList.getValueAt(0, 3).toString(), "vinhlmpc01238@fpt.edu.vn");
		Assert.assertEquals(traPhong.tblList.getValueAt(0, 4).toString(), "Quản lý");
		Assert.assertEquals(traPhong.tblList.getValueAt(0, 5).toString(), "Dạy học");
		
		Thread.sleep(200);
		traPhong.dispose();
	}
	
	@Test
	public void traPhongTest() throws InterruptedException {
		new Thread(() -> {
			nmXem.btnTraPhongActionPerformed(null);
		}).start();
		Thread.sleep(500);
		
		TraPhongJDialog traPhong = Babysitter.getWindow(TraPhongJDialog.class);		
		
		int soPhongStart = traPhong.tblList.getRowCount();
		
		traPhong.tblList.setRowSelectionInterval(0, 0);
		Thread.sleep(200);
		new Thread(() -> {
			traPhong.btnTraPhongActionPerformed(null);
		}).start();
		Thread.sleep(500);
		
		BigBug.keyPress("enter");
		Thread.sleep(200);
		BigBug.keyPress("enter");
		Thread.sleep(1000);
		
		if (nmXem.btnTraPhong.isEnabled()) {
			new Thread(() -> {
				nmXem.btnTraPhongActionPerformed(null);
			}).start();
			Thread.sleep(500);
			
			TraPhongJDialog traPhong2 = Babysitter.getWindow(TraPhongJDialog.class);
			
			Assert.assertEquals(traPhong2.tblList.getRowCount(), soPhongStart - 1);
			Thread.sleep(200);
			traPhong2.dispose();
		} else {
			Assert.assertFalse(nmXem.btnTraPhong.isEnabled());
		}
	}
	
}
