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
		mp.setIdPhong(1);
		mp.setSoTang(1);
		List<MuonPhong> ls = DatabaseManager.executeQuery(mp, MuonPhong.EXECUTE_SELECT_BY_ID_PHONG);
		Assert.assertFalse(ls.isEmpty());
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
		
		DatabaseManager.executeUpdate(mp, MuonPhong.EXECUTE_INSERT);
		
		// Lấy ra kiểm tra
		MuonPhong mp2 = new MuonPhong();
		mp2.setIdPhong(1);
		mp2.setSoTang(1);
		List<MuonPhong> ls = DatabaseManager.executeQuery(mp2, MuonPhong.EXECUTE_SELECT_BY_ID_PHONG);
		Assert.assertFalse(ls.isEmpty());
	}

}
