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
//		tk.setEmail("vinhlmpc01238@fpt.edu.vn");
		List<TaiKhoan> tkList = DatabaseManager.executeQuery(tk, TaiKhoan.EXECUTE_SELECT_ALL);
		assertFalse(tkList.isEmpty());
	}
	
	@Test
	public void selectUsernameTest() {
		TaiKhoan tk = new TaiKhoan();	
		tk.setIdTaiKhoan("vinhlm");
		List<TaiKhoan> tkList = DatabaseManager.executeQuery(tk, TaiKhoan.EXECUTE_SELECT_BY_ID);
		assertFalse(tkList.isEmpty());
	}
	
	@Test
	public void selectEmailTest() {
		TaiKhoan tk = new TaiKhoan();	
		tk.setIdTaiKhoan("vinhlm");
		List<TaiKhoan> tkList = DatabaseManager.executeQuery(tk, TaiKhoan.EXECUTE_SELECT_BY_MAIL);
		assertFalse(tkList.isEmpty());
	}
	
	@Test
	public void selectUsernameEmailPassTest() {
		TaiKhoan tk = new TaiKhoan();	
		tk.setIdTaiKhoan("vinhlm");
		tk.setEmail("vinhlmpc01238@fpt.edu.vn");
		tk.setMatKhau("1");
		List<TaiKhoan> tkList = DatabaseManager.executeQuery(tk, TaiKhoan.EXECUTE_SELECT_BY_USER_OR_EMAIL_AND_PASS);
		assertFalse(tkList.isEmpty());
	}
	
}
