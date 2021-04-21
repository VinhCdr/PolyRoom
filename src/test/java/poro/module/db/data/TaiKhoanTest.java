package poro.module.db.data;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;

import java.util.List;
import org.testng.annotations.Test;
import poro.module.db.DatabaseManager;

public class TaiKhoanTest {
  
	@Test
	public void selectAllTest() {
		TaiKhoan tk = new TaiKhoan();	
		tk.setEmail("vinhlmpc01238@fpt.edu.vn");
		List<TaiKhoan> tkList = DatabaseManager.executeQuery(tk, TaiKhoan.EXECUTE_SELECT_BY_MAIL);
		assertFalse(tkList.isEmpty());
	}
	
	@Test
	public void updateAllTest() {
		TaiKhoan tk = new TaiKhoan();
		tk.setIdTaiKhoan("xa43sdf");
		tk.setEmail("mai43eeel@gm.g");
		tk.setPhanQuyen(true);
		tk.setSdt("01238");
		tk.setTen("name");
		tk.setMatKhau("xxx");
		int i = DatabaseManager.executeUpdate(tk, TaiKhoan.EXECUTE_INSERT);
		
		assertEquals(i, 1);
		DatabaseManager.executeUpdate(tk, TaiKhoan.EXECUTE_DELETE_BY_ID);	
	}
	
}
