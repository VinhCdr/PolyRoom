package poro.gui;

import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import poro.MainClass;
import poro.module.Session;
import test.module.Babysitter;
import test.module.BigBug;

public class NMXemPhongJPanelTest {
	
	@BeforeClass
	public void init () throws InterruptedException {
		Babysitter.showMain();
		//Đăng nhập
		BigBug.writeString(MainClass.dangNhapJDialog.txtTaiKhoan,"vinhlm");
		Thread.sleep(200);
		
		BigBug.writeString(MainClass.dangNhapJDialog.txtPassword,"vipass");
		Thread.sleep(200);
		
		MainClass.dangNhapJDialog.btnDangNhap.doClick();
		Thread.sleep(500);
	}
	
	@AfterClass
	public void close () {
		Babysitter.closeMain();
	}
	
	@BeforeMethod
	public void resetForm() {
		MainClass.mainJFrame.setGiaoDien(Session.USER.isPhanQuyen());
	}
	
	@AfterMethod
	public void delay() throws InterruptedException {
		Thread.sleep(500);
	}
	
	@Test(timeOut = 15_000)
	public void showXemPhongTest() throws InterruptedException {
		
		MainClass.mainJFrame.mniMuonPhongActionPerformed(null);
		Thread.sleep(200);
		
		NMXemPhongJPanel nmXem = Babysitter.getTabPanelSelected();
		Thread.sleep(200);
		
		new Thread(() -> {
			nmXem.txtTimStartMouseClicked(null);
		}).start();
		Thread.sleep(500);
		
		ChonNgayGioJDialog cng = Babysitter.getWindow(ChonNgayGioJDialog.class);
		Thread.sleep(200);
		
		cng.btnXacNhanActionPerformed(null);
		Thread.sleep(200);
		
		new Thread(() -> {
			nmXem.txtTimEndMouseClicked(null);
		}).start();
		Thread.sleep(500);
		
		ChonNgayGioJDialog cng2 = Babysitter.getWindow(ChonNgayGioJDialog.class);
		Thread.sleep(200);
		
		cng2.btnXacNhanActionPerformed(null);
		Thread.sleep(200);
		
		nmXem.btnTimPhongActionPerformed(null);
		Thread.sleep(200);
		
	}
}
