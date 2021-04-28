package poro.module.db.data;

import java.util.List;
import org.testng.Assert;
import org.testng.annotations.Test;
import poro.module.CalendarManager;
import poro.module.db.DatabaseManager;

public class MuonPhongTest {
	
	@Test
	public void getFullListTest() {
		MuonPhong mp = new MuonPhong();
		List<MuonPhong> ls = DatabaseManager.executeQuery(mp, MuonPhong.EXECUTE_SELECT_ALL);
		Assert.assertFalse(ls.isEmpty());
	}
	
	@Test
	public void getListByPhongYesTest() {
		MuonPhong mp = new MuonPhong();
		mp.setSoTang(1);
		mp.setIdPhong(1);
		List<MuonPhong> ls = DatabaseManager.executeQuery(mp, MuonPhong.EXECUTE_SELECT_BY_ID_PHONG);
		Assert.assertFalse(ls.isEmpty(), "Khi lấy list thông tin mượn phòng 101, kết quả trả về là list rổng");
	}
	
	@Test
	public void getListByPhongNoTest() {
		MuonPhong mp = new MuonPhong();
		mp.setIdPhong(99);
		mp.setSoTang(50);
		List<MuonPhong> ls = DatabaseManager.executeQuery(mp, MuonPhong.EXECUTE_SELECT_BY_ID_PHONG);
		Assert.assertTrue(ls.isEmpty());
	}
	
	@Test (priority = -2)
	public void insertMuonPhongTest() {
		//Insert
		MuonPhong mp = new MuonPhong();
		mp.setIdPhong(1);
		mp.setSoTang(1);
		mp.setIdTaiKhoan("vinhlm");
		mp.setLyDo("Kiểm thử");
		mp.setTgMuon(CalendarManager.getNow());
		mp.setTgTra(CalendarManager.addTimes(CalendarManager.getNow(), ((long) 1000 * 60 * 60 * 2)));
		
		int i = DatabaseManager.executeUpdate(mp, MuonPhong.EXECUTE_INSERT);
		
		Assert.assertEquals(i, 1);
	}
	
	@Test (priority = -1)
	public void updateMuonPhongTest() {
		MuonPhong mp = new MuonPhong();
		mp.setIdPhong(1);
		mp.setSoTang(1);
		mp.setIdTaiKhoan("vinhlm");
		mp.setLyDo("Kiểm thử");
		mp.setTgMuon(CalendarManager.getNow());
		mp.setTgTra(CalendarManager.addTimes(CalendarManager.getNow(), ((long) 1000 * 60 * 60 * 2)));
		
		int i = DatabaseManager.executeUpdate(mp, MuonPhong.EXECUTE_INSERT);
		
		Assert.assertEquals(i, 1);
	}
	
	@Test
	public void seleteLastMuonPhongTest() {
		MuonPhong mp = new MuonPhong();
		List<MuonPhong> mpList = DatabaseManager.executeQuery(mp, MuonPhong.EXECUTE_SELECT_LAST_INSERT);
		Assert.assertFalse(mpList.isEmpty());
	}

}
