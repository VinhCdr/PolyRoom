package poro.gui;

import java.util.Date;

import javax.swing.JDialog;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import poro.MainClass;
import poro.module.CalendarManager;
import poro.module.Session;
import test.module.Babysitter;
import test.module.BigBug;

public class NMXemPhongJPanelTest {

	NMXemPhongJPanel nmXem;

	@BeforeClass
	public void init() throws InterruptedException {
		Babysitter.showMain();
		// Đăng nhập
		BigBug.writeString(MainClass.dangNhapJDialog.txtTaiKhoan, "vinhlm");
		BigBug.writeString(MainClass.dangNhapJDialog.txtPassword, "vipass");
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
		MainClass.mainJFrame.mniMuonPhongActionPerformed(null);
		nmXem = Babysitter.getTabPanelSelected();
		Thread.sleep(200);
	}

	@AfterMethod
	public void delay() throws InterruptedException {
		Thread.sleep(500);
	}

	/**
	 * Kiểm tra giá trị ô text feild theo mặc định
	 */
	@Test(timeOut = 10_000)
	public void valueTimPhongDefTest() throws InterruptedException {
		new Thread(() -> {
			nmXem.txtTimStartMouseClicked(null);
		}).start();
		Thread.sleep(500);
		ChonNgayGioJDialog cng = Babysitter.getWindow(ChonNgayGioJDialog.class);
		cng.btnXacNhanActionPerformed(null);

		new Thread(() -> {
			nmXem.txtTimEndMouseClicked(null);
		}).start();
		Thread.sleep(500);
		ChonNgayGioJDialog cng2 = Babysitter.getWindow(ChonNgayGioJDialog.class);
		cng2.btnXacNhanActionPerformed(null);

		Thread.sleep(500);
		String actualStart = nmXem.txtTimStart.getText();
		String actualEnd = nmXem.txtTimEnd.getText();

		long startTime = CalendarManager.getDateByString(actualStart, CalendarManager.DATE_HOUR_FULL_FORMAT).getTime();
		long endTime = CalendarManager.getDateByString(actualEnd, CalendarManager.DATE_HOUR_FULL_FORMAT).getTime();
		long nowTime = CalendarManager.getNow().getTime();
		
		
		boolean startOk = Math.abs(nowTime - startTime) < 120_000; // sai số 120.000ms = 2m
		boolean endOk = Math.abs((nowTime + 7_200_000) - endTime) < 120_000; // sai số 120.000ms | 7.200.000ms = 2h
		Assert.assertTrue(startOk, 
				"Kết quả bắt đầu là: " + actualStart + ", Kết quả mong muốn là: " + nowTime);
		Assert.assertTrue(endOk,
				"Kết quả kết thúc là: " + actualEnd + ", Kết quả mong muốn là: " + (nowTime + 7_200_000));
	}

	/**
	 * Kiểm tra tìm phòng theo mặc định và tìm được phòng
	 */
	@Test(timeOut = 10_000)
	public void showTimPhongDefTest() throws InterruptedException {

		new Thread(() -> {
			nmXem.txtTimStartMouseClicked(null);
		}).start();
		Thread.sleep(500);

		ChonNgayGioJDialog cng = Babysitter.getWindow(ChonNgayGioJDialog.class);
		cng.btnXacNhanActionPerformed(null);

		new Thread(() -> {
			nmXem.txtTimEndMouseClicked(null);
		}).start();
		Thread.sleep(500);

		ChonNgayGioJDialog cng2 = Babysitter.getWindow(ChonNgayGioJDialog.class);
		cng2.btnXacNhanActionPerformed(null);

		Thread.sleep(500);
		nmXem.btnTimPhongActionPerformed(null);

		int[] expected = new int[] { 2, 3, 6, 7, 8, 9 };

		for (int i : expected) {
			Assert.assertTrue(nmXem.tblPhong.isRowSelected(i));
		}
	}
	
	/**
	 * Tìm kiếm phòng, và phòng 102 sẽ không được chọn
	 */
	@Test(dataProvider = "dataSkipPhong102")
	public void skipPhong102(Date start, Date end) throws InterruptedException {
		nmXem.tblPhong.setRowSelectionInterval(5, 5); // check trước, để kiểm tra có bỏ check không !
		
		new Thread(() -> {
			nmXem.txtTimStartMouseClicked(null);
		}).start();
		Thread.sleep(500);
		ChonNgayGioJDialog ngStart = Babysitter.getWindow(ChonNgayGioJDialog.class);
		ngStart.cboNam.setSelectedItem(CalendarManager.getString(start, "yyyy").replaceAll("^0", ""));
		ngStart.cboThang.setSelectedItem(CalendarManager.getString(start, "MM").replaceAll("^0", ""));
		ngStart.cboNgay.setSelectedItem(CalendarManager.getString(start, "dd").replaceAll("^0", ""));
		ngStart.cboGio.setSelectedItem(CalendarManager.getString(start, "HH").replaceAll("^0", ""));
		ngStart.cboPhut.setSelectedItem(CalendarManager.getString(start, "mm").replaceAll("^0", ""));
		Thread.sleep(500);
		ngStart.btnXacNhanActionPerformed(null);
		
		new Thread(() -> {
			nmXem.txtTimEndMouseClicked(null);
		}).start();
		Thread.sleep(500);
		ChonNgayGioJDialog ngEnd = Babysitter.getWindow(ChonNgayGioJDialog.class);
		ngEnd.cboNam.setSelectedItem(CalendarManager.getString(end, "yyyy").replaceAll("^0", ""));
		ngEnd.cboThang.setSelectedItem(CalendarManager.getString(end, "MM").replaceAll("^0", ""));
		ngEnd.cboNgay.setSelectedItem(CalendarManager.getString(end, "dd").replaceAll("^0", ""));
		ngEnd.cboGio.setSelectedItem(CalendarManager.getString(end, "HH").replaceAll("^0", ""));
		ngEnd.cboPhut.setSelectedItem(CalendarManager.getString(end, "mm").replaceAll("^0", ""));
		
		Thread.sleep(500);
		ngEnd.btnXacNhanActionPerformed(null);
		
		Thread.sleep(500);
		nmXem.btnTimPhongActionPerformed(null);
		Thread.sleep(200);
		Assert.assertFalse(nmXem.tblPhong.isRowSelected(5), "Phòng 102 (index 5, dòng 6), Trong table đã selected");
	}
	
	@DataProvider(name = "dataSkipPhong102")
	private Date[][] getSkipPhong102(){
		return new Date[][] {
			{
				CalendarManager.addTimes(CalendarManager.getNow(), 1_800_000L),//0.5h 
				CalendarManager.addTimes(CalendarManager.getNow(), 9_000_000L) //2.5h
			},
			{
				CalendarManager.getNow(), 
				CalendarManager.addTimes(CalendarManager.getNow(), 7_200_000L) //2h
			},
			{
				CalendarManager.addTimes(CalendarManager.getNow(), 9_000_000L), //2.5h
				CalendarManager.addTimes(CalendarManager.getNow(), 12_600_000L) //3.5h
			}
		};
	}
	
	/**
	 * Tìm kiếm phòng, Kiểm tra lỗi khi form thời gian nhập sai
	 * @throws InterruptedException 
	 */
	@Test(dataProvider = "messageErrorTimPhong", timeOut = 5_000)
	public void messageErrorTimPhongTest(Date start, Date end) throws InterruptedException {
		if (null != start) {
			new Thread(() -> {
				nmXem.txtTimStartMouseClicked(null);
			}).start();
			Thread.sleep(500);
			ChonNgayGioJDialog cn = Babysitter.getWindow(ChonNgayGioJDialog.class);
			cn.cboNam.setSelectedItem(CalendarManager.getString(start, "yyyy").replaceAll("^0", ""));
			cn.cboThang.setSelectedItem(CalendarManager.getString(start, "MM").replaceAll("^0", ""));
			cn.cboNgay.setSelectedItem(CalendarManager.getString(start, "dd").replaceAll("^0", ""));
			cn.cboGio.setSelectedItem(CalendarManager.getString(start, "HH").replaceAll("^0", ""));
			cn.cboPhut.setSelectedItem(CalendarManager.getString(start, "mm").replaceAll("^0", ""));
			cn.btnXacNhanActionPerformed(null);
		}
		if (null != end) {
			new Thread(() -> {
				nmXem.txtTimEndMouseClicked(null);
			}).start();
			Thread.sleep(500);
			ChonNgayGioJDialog cn = Babysitter.getWindow(ChonNgayGioJDialog.class);
			cn.cboNam.setSelectedItem(CalendarManager.getString(end, "yyyy").replaceAll("^0", ""));
			cn.cboThang.setSelectedItem(CalendarManager.getString(end, "MM").replaceAll("^0", ""));
			cn.cboNgay.setSelectedItem(CalendarManager.getString(end, "dd").replaceAll("^0", ""));
			cn.cboGio.setSelectedItem(CalendarManager.getString(end, "HH").replaceAll("^0", ""));
			cn.cboPhut.setSelectedItem(CalendarManager.getString(end, "mm").replaceAll("^0", ""));
			cn.btnXacNhanActionPerformed(null);
		}
		Thread.sleep(500);
		new Thread(() -> {
			nmXem.btnTimPhongActionPerformed(null);
		}).start();
		Thread.sleep(1000);
		JDialog message = Babysitter.getWindow(JDialog.class);
		
		Assert.assertTrue(message.isVisible());
		Assert.assertEquals(message.getTitle(), "Message");
		
		message.setVisible(false);
	}
	
	@DataProvider(name = "messageErrorTimPhong")
	private Date[][] getMessageErrorTimPhong(){
		return new Date[][] {
			{null, null},
			{null , new Date()},
			{CalendarManager.addTimes(new Date(), -1_200_000L), new Date()},
			{CalendarManager.addTimes(new Date(), 1_200_000L), new Date()}
		};
	}
	
}
