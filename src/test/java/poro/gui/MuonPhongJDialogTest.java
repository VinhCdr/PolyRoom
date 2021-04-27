package poro.gui;

import java.util.Date;

import javax.swing.JDialog;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import poro.MainClass;
import poro.module.CalendarManager;
import poro.module.Session;
import poro.module.db.DatabaseManager;
import poro.module.db.data.TempMuonPhong;
import poro.module.web.WebStdManager;
import test.module.Babysitter;
import test.module.BigBug;

public class MuonPhongJDialogTest {

	NMXemPhongJPanel nmXemPhong;
	
	@BeforeTest
	public void init() throws InterruptedException {
		Babysitter.showMain();
		BigBug.writeString(MainClass.dangNhapJDialog.txtTaiKhoan, "vinhlm");
		BigBug.writeString(MainClass.dangNhapJDialog.txtPassword, "vipass");
		Thread.sleep(200);
		MainClass.dangNhapJDialog.btnDangNhapActionPerformed(null);
	}
	
	@BeforeMethod
	public void createXemPhong() throws InterruptedException {
		MainClass.mainJFrame.setGiaoDien(Session.USER.isPhanQuyen());
		Thread.sleep(500);
		MainClass.mainJFrame.mniMuonPhongActionPerformed(null);
		nmXemPhong = Babysitter.getTabPanelSelected();
		Thread.sleep(200);
	}
	
	@AfterMethod
	public void delay() throws InterruptedException {
		Thread.sleep(1000);
	}
	
	@AfterClass
	public void close() {
		Babysitter.closeMain();
	}
	
	/**
	 * Mượn phòng 201 thành công
	 */
	@Test
	public void muon201Test() throws InterruptedException {
		nmXemPhong.tblPhong.setRowSelectionInterval(2, 2);
		Thread.sleep(200);
		new Thread(() -> {
			nmXemPhong.btnMuonPhongActionPerformed(null);
		}).start();
		Thread.sleep(500);
		
		MuonPhongJDialog  muonPhong = Babysitter.getWindow(MuonPhongJDialog.class);
		
		new Thread(() -> {
			muonPhong.txtTGBatDauMouseClicked(null);
		}).start();
		Thread.sleep(500);
		ChonNgayGioJDialog ngStart = Babysitter.getWindow(ChonNgayGioJDialog.class);
		ngStart.btnXacNhanActionPerformed(null);
		
		
		new Thread(() -> {
			muonPhong.txtTraDuKienMouseClicked(null);
		}).start();
		Thread.sleep(500);
		
		ChonNgayGioJDialog ngEnd = Babysitter.getWindow(ChonNgayGioJDialog.class);
		ngEnd.btnXacNhanActionPerformed(null);
		
		BigBug.writeString(muonPhong.txtLyDo, "Kiểm thử hệ thống");
		
		new Thread(() -> {
			muonPhong.btnDangKyActionPerformed(null);
		}).start();
		Thread.sleep(500);
		
		Babysitter.getWindow(muonPhong, JDialog.class).dispose();
		
		// Đã mượn thành công, đang check lại
		
		Thread.sleep(200);
		nmXemPhong.tblPhong.setRowSelectionInterval(2, 2);
		Thread.sleep(200);
		
		new Thread(() -> {
			nmXemPhong.btnMuonPhongActionPerformed(null);
		}).start();
		Thread.sleep(200);
		
		MuonPhongJDialog muonPhong2 = Babysitter.getWindow(MuonPhongJDialog.class);
		muonPhong2.tblContent.setRowSelectionInterval(0, 0);
		
		Assert.assertEquals(nmXemPhong.tblPhong.getValueAt(2, 5).toString(), "1");
		Assert.assertEquals(muonPhong2.tblContent.getValueAt(0, 0), "Lê Minh Vinh (vinhlm)");
		Assert.assertEquals(muonPhong2.tblContent.getValueAt(0, 1), ngStart.getResult());
		Assert.assertEquals(muonPhong2.tblContent.getValueAt(0, 2), ngEnd.getResult());
		
		Thread.sleep(500);
		
		muonPhong2.dispose();
	}
	
	/**
	 * Mượn phòng bình thường, nhưng sai validate
	 */
	@Test(dataProvider = "errorFromTest")
	public void errorFromTest(Date start, Date end, String lyDo) throws InterruptedException {
		nmXemPhong.tblPhong.setRowSelectionInterval(5, 5);
		Thread.sleep(200);
		new Thread(() -> {
			nmXemPhong.btnMuonPhongActionPerformed(null);
		}).start();
		Thread.sleep(500);
		
		MuonPhongJDialog  muonPhong = Babysitter.getWindow(MuonPhongJDialog.class);
		
		if (null != start) {
			new Thread(() -> {
				muonPhong.txtTGBatDauMouseClicked(null);
			}).start();
			Thread.sleep(500);
			ChonNgayGioJDialog ngStart = Babysitter.getWindow(ChonNgayGioJDialog.class);
			ngStart.cboNam.setSelectedItem(CalendarManager.getString(start, "yyyy").replaceAll("^0", ""));
			ngStart.cboThang.setSelectedItem(CalendarManager.getString(start, "MM").replaceAll("^0", ""));
			ngStart.cboNgay.setSelectedItem(CalendarManager.getString(start, "dd").replaceAll("^0", ""));
			ngStart.cboGio.setSelectedItem(CalendarManager.getString(start, "HH").replaceAll("^0", ""));
			ngStart.cboPhut.setSelectedItem(CalendarManager.getString(start, "mm").replaceAll("^0", ""));
			ngStart.btnXacNhanActionPerformed(null);
		}
		
		
		if (null != end) {
			new Thread(() -> {
				muonPhong.txtTraDuKienMouseClicked(null);
			}).start();
			Thread.sleep(500);
			ChonNgayGioJDialog ngEnd = Babysitter.getWindow(ChonNgayGioJDialog.class);
			ngEnd.cboNam.setSelectedItem(CalendarManager.getString(end, "yyyy").replaceAll("^0", ""));
			ngEnd.cboThang.setSelectedItem(CalendarManager.getString(end, "MM").replaceAll("^0", ""));
			ngEnd.cboNgay.setSelectedItem(CalendarManager.getString(end, "dd").replaceAll("^0", ""));
			ngEnd.cboGio.setSelectedItem(CalendarManager.getString(end, "HH").replaceAll("^0", ""));
			ngEnd.cboPhut.setSelectedItem(CalendarManager.getString(end, "mm").replaceAll("^0", ""));
			ngEnd.btnXacNhanActionPerformed(null);
		}
		
		if (null != lyDo) {
			BigBug.writeString(muonPhong.txtLyDo, lyDo);
			Thread.sleep(200);
		}
		
		new Thread(() -> {
			muonPhong.btnDangKyActionPerformed(null);
		}).start();
		Thread.sleep(500);
		
		JDialog message = Babysitter.getWindow(muonPhong, JDialog.class);
		Thread.sleep(500);
		
		Assert.assertEquals(message.getTitle(), "Message");
		message.dispose();
		
		Assert.assertTrue(muonPhong.isVisible());
		Assert.assertEquals(muonPhong.tblContent.getRowCount(), 1);
		
		Thread.sleep(500);
		muonPhong.dispose();
	}
	
	@DataProvider(name = "errorFromTest")
	private Object[][] getErrorFromTest(){
		return new Object[][] {
			{null, new Date(), "Kiểm thử hệ thống"},
			{new Date(), null, "Kiểm thử hệ thống"},
			{new Date(), CalendarManager.addTimes(new Date(), 7_200_000L), null},
			{CalendarManager.addTimes(new Date(), 3_600_000L), new Date(), "Kiểm thử hệ thống"},
			{CalendarManager.addTimes(new Date(), -3_600_000L), new Date(), "Kiểm thử hệ thống"},
		};
	}

	/**
	 * Mượn phòng cho sinh viên, như sai validate
	 */
	@Test(dataProvider = "errorFromSvTest", priority = 19)
	public void errorFromSvTest(String idSv, String nameSv, String emailSv) throws InterruptedException {
		nmXemPhong.tblPhong.setRowSelectionInterval(3, 3);
		Thread.sleep(200);
		new Thread(() -> {
			nmXemPhong.btnMuonPhongActionPerformed(null);
		}).start();
		Thread.sleep(500);
		
		MuonPhongJDialog  muonPhong = Babysitter.getWindow(MuonPhongJDialog.class);
		
		new Thread(() -> {
			muonPhong.txtTGBatDauMouseClicked(null);
		}).start();
		Thread.sleep(500);
		ChonNgayGioJDialog ngStart = Babysitter.getWindow(ChonNgayGioJDialog.class);
		ngStart.btnXacNhanActionPerformed(null);
		
		
		new Thread(() -> {
			muonPhong.txtTraDuKienMouseClicked(null);
		}).start();
		Thread.sleep(500);
		ChonNgayGioJDialog ngEnd = Babysitter.getWindow(ChonNgayGioJDialog.class);
		ngEnd.btnXacNhanActionPerformed(null);
		
		BigBug.writeString(muonPhong.txtLyDo, "Kiểm thử hệ thống");
		
		muonPhong.chkMuonHo.setSelected(true);
		
		if (null != idSv) {
			BigBug.writeString(muonPhong.txtMaSV, idSv);
		}
		
		if (null != nameSv) {
			BigBug.writeString(muonPhong.txtTenSV, nameSv);
		}
		
		if (null != emailSv) {
			BigBug.writeString(muonPhong.txtEmail, emailSv);
		}
		
		Thread.sleep(200);
		
		new Thread(() -> {
			muonPhong.btnDangKyActionPerformed(null);
		}).start();
		Thread.sleep(500);
		
		JDialog message = Babysitter.getWindow(muonPhong, JDialog.class);
		Thread.sleep(500);
		
		Assert.assertEquals(message.getTitle(), "Message");
		message.dispose();
		Thread.sleep(200);
		
		Assert.assertTrue(muonPhong.isVisible());
		Assert.assertEquals(muonPhong.tblContent.getRowCount(), 0);
		
		muonPhong.dispose();
	}
	
	@DataProvider(name = "errorFromSvTest")
	private Object[][] getErrorFromSvTest(){
		return new Object[][] {
			{"", "Lê Minh Vinh", "vinhlmpc01238@fpt.edu.vn"},
			{"PC01238", "", "vinhlmpc01238@fpt.edu.vn"},
			{"PC01238", "Lê Minh Vinh", ""},
			{"PC01238", "Lê Minh Vinh", "ÔiKhôngEmailĐãSaiValidate"},
		};
	}
	
	/**
	 * Mượn phòng thành công cho sinh viên, nhưng chưa có xác nhận
	 * @throws InterruptedException 
	 */
	@Test(priority = 20)
	public void muonOkSvTest() throws InterruptedException {
		nmXemPhong.tblPhong.setRowSelectionInterval(3, 3);
		Thread.sleep(200);
		new Thread(() -> {
			nmXemPhong.btnMuonPhongActionPerformed(null);
		}).start();
		Thread.sleep(500);
		
		MuonPhongJDialog  muonPhong = Babysitter.getWindow(MuonPhongJDialog.class);
		
		new Thread(() -> {
			muonPhong.txtTGBatDauMouseClicked(null);
		}).start();
		Thread.sleep(500);
		ChonNgayGioJDialog ngStart = Babysitter.getWindow(ChonNgayGioJDialog.class);
		ngStart.btnXacNhanActionPerformed(null);
		
		
		new Thread(() -> {
			muonPhong.txtTraDuKienMouseClicked(null);
		}).start();
		Thread.sleep(500);
		ChonNgayGioJDialog ngEnd = Babysitter.getWindow(ChonNgayGioJDialog.class);
		ngEnd.btnXacNhanActionPerformed(null);
		
		BigBug.writeString(muonPhong.txtLyDo, "Kiểm thử hệ thống khi mượn cho sinh viên . .. ...");
		muonPhong.chkMuonHo.setSelected(true);
		BigBug.writeString(muonPhong.txtMaSV, "KT01238");
		BigBug.writeString(muonPhong.txtTenSV, "Lê Minh Vinh Kiểm Thử");
		BigBug.writeString(muonPhong.txtEmail, "vinhlmpc01238@fpt.edu.vn");
		
		Thread.sleep(200);
		
		new Thread(() -> {
			muonPhong.btnDangKyActionPerformed(null);
		}).start();
		Thread.sleep(500);
		
		JDialog message = Babysitter.getWindow(muonPhong, JDialog.class);
		Thread.sleep(500);
		
		Assert.assertEquals(message.getTitle(), "Message");
		message.dispose();
		Thread.sleep(500);
		
		TempMuonPhong temp = new TempMuonPhong();
		temp = DatabaseManager.executeQuery(temp, TempMuonPhong.EXECUTE_SELECT_LAST_INSERT).get(0);
		
		Assert.assertEquals(temp.getIdSinhVien(), "KT01238");
		Assert.assertEquals(temp.getTenSinhVien(), "Lê Minh Vinh Kiểm Thử");
		Assert.assertEquals(temp.getEmailSinhVien(), "vinhlmpc01238@fpt.edu.vn");
		Assert.assertEquals(temp.getLyDo(), "Kiểm thử hệ thống khi mượn cho sinh viên . .. ...");
		Assert.assertEquals(temp.getSoTang(), 3);
		Assert.assertEquals(temp.getIdPhong(), 1);
		Assert.assertEquals(temp.getIdTaiKhoan(), "vinhlm");
		Assert.assertEquals(CalendarManager.getString(temp.getTgMuon(), CalendarManager.DATE_HOUR_FULL_FORMAT), ngStart.getResult());
		Assert.assertEquals(CalendarManager.getString(temp.getTgTra(), CalendarManager.DATE_HOUR_FULL_FORMAT), ngEnd.getResult());
		Assert.assertFalse(muonPhong.isVisible());
		Assert.assertEquals(muonPhong.tblContent.getRowCount(), 0);
	}
	
	/**
	 * Mượn phòng thành công cho sinh viên, nhưng chưa có xác nhận 
	 */
	@Test(dependsOnMethods = {"muonOkSvTest"})
	public void xacNhanMuonTest() throws InterruptedException {
		MainClass.mainJFrame.setAlwaysOnTop(false);
		
		TempMuonPhong temp = new TempMuonPhong();
		temp = DatabaseManager.executeQuery(temp, TempMuonPhong.EXECUTE_SELECT_LAST_INSERT).get(0);
		String url = String.format("http://%s?id=%d&otp=%s", WebStdManager.getAddress(), temp.getIdTemp(), temp.getOtp());
		
		System.setProperty("webdriver.chrome.driver", "asset/chromedriver.exe");
		WebDriver browser = new ChromeDriver();
		browser.get(url);
		Thread.sleep(500);
		WebElement actualMessage = browser.findElement(By.tagName("div"));
		
		Assert.assertEquals(actualMessage.getText(), "Xác nhận thành công");
		
		Thread.sleep(2000);
		browser.close();
		Thread.sleep(500);
		
		browser = new ChromeDriver();
		browser.get(url);
		Thread.sleep(500);
		WebElement actualMessage2 = browser.findElement(By.tagName("div"));
		Assert.assertEquals(actualMessage2.getText(), "Đường dẫn không đúng hoặc đã bị hủy");
		
		Thread.sleep(2000);
		browser.close();
		MainClass.mainJFrame.setAlwaysOnTop(true);
	}
	
}
