package poro.module;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CalendarManagerTest {

	@Test
	public void addTimesTest() {
		Date time = new Date();
		long a = 10;
		Date hientai = CalendarManager.addTimes(time, a);
		
		long mongmuon = time.getTime() + a;
		Assert.assertEquals(hientai.getTime(), mongmuon);
	}

	@Test
	public void getDateByStringTest() {

		Date mongmuon = new Date();
		
		String b = "MM-dd-yyyy HH:mm:ss SSS";
		
		SimpleDateFormat a = new SimpleDateFormat(b);
		String sMongMuon = a.format(mongmuon);
		
		Date hienTai = CalendarManager.getDateByString(sMongMuon, b);
		Assert.assertEquals(hienTai.getTime(), mongmuon.getTime());

	}

	@Test
	public void getDaysOfTest() {
		int hientai = CalendarManager.getDaysOf(2000, 2);
		Assert.assertEquals(hientai, 29);

	}

	@Test
	public void getNowTest() {
		Date thucte = CalendarManager.getNow();
		Date mongmuon = new Date();
		Assert.assertEquals(thucte, mongmuon);

	}

	@Test
	public void getStringTest() {
		Date ngay = new Date(0);
		String chuyen = "dd/MM/yyyy";
		String hientai = CalendarManager.getString(ngay, chuyen);
		String mongmuon = "01/01/1970";
		Assert.assertEquals(hientai, mongmuon);
	}

	@Test
	public void isLeapYearTest() {
		boolean thucte = CalendarManager.isLeapYear(2000);
		Assert.assertTrue(thucte);
	}
}
