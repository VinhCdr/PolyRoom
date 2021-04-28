package poro.module.db.data;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;
import java.util.List;
import org.testng.annotations.Test;

import poro.module.Encrypter;
import poro.module.db.DatabaseManager;

public class TaiKhoanTest {
  
	@Test
	public void selectAllTest() {
		TaiKhoan tk = new TaiKhoan();	
		List<TaiKhoan> tkList = DatabaseManager.executeQuery(tk, TaiKhoan.EXECUTE_SELECT_ALL);
		assertFalse(tkList.isEmpty());
	}
	
	@Test
	public void selectUsernameTest() {
		TaiKhoan tk = new TaiKhoan();	
		tk.setIdTaiKhoan("minhvhn");
		List<TaiKhoan> tkList = DatabaseManager.executeQuery(tk, TaiKhoan.EXECUTE_SELECT_BY_ID);
		assertFalse(tkList.isEmpty());
	}
	
	@Test
	public void selectEmailTest() {
		TaiKhoan tk = new TaiKhoan();	
		tk.setEmail("minhvhnpc01239@fpt.edu.vn");
		List<TaiKhoan> tkList = DatabaseManager.executeQuery(tk, TaiKhoan.EXECUTE_SELECT_BY_MAIL);
		assertFalse(tkList.isEmpty());
	}
	
	@Test
	public void selectUsernameEmailPassTest() {
		TaiKhoan tk = new TaiKhoan();	
		tk.setIdTaiKhoan("minhvhn");
		tk.setEmail("minhvhnpc01239@fpt.edu.vn");
		tk.setMatKhau(Encrypter.toMD5("minhpass"));
		List<TaiKhoan> tkList = DatabaseManager.executeQuery(tk, TaiKhoan.EXECUTE_SELECT_BY_USER_OR_EMAIL_AND_PASS);
		assertFalse(tkList.isEmpty());
	}
	
	@Test(priority = -1)
	  public void InsertTaiKhoan() {
		  TaiKhoan tk = new TaiKhoan();
		  tk.setIdTaiKhoan("loilhz");
		  tk.setMatKhau("123");
		  tk.setTen("luong huu loi");
		  tk.setEmail("loilhpc012612@fpt.edu.vn");
		  tk.setSdt("0909123456");
		  tk.setPhanQuyen(true);
		  int i = DatabaseManager.executeUpdate(tk, TaiKhoan.EXECUTE_INSERT);
		  assertEquals(i, 1);
	  }
	
	 @Test
	  public void UpdateTaiKhoan() {
		  TaiKhoan tk = new TaiKhoan();
		  tk.setIdTaiKhoan("loilhz");
		  tk.setMatKhau("123");
		  tk.setTen("luong loi2");
		  tk.setEmail("loilhpc01261x@fpt.edu.vn");
		  tk.setSdt("0909654321");
		  tk.setPhanQuyen(true);
		  int i = DatabaseManager.executeUpdate(tk, TaiKhoan.EXECUTE_UPDATE_BY_ID);
		  assertEquals(i, 1);
	  }
	 
	 @Test(priority = 90)
	 public void DeleteTaiKhoan() {
		 TaiKhoan tk = new TaiKhoan();
		  tk.setIdTaiKhoan("loilhz");
		  int i = DatabaseManager.executeUpdate(tk, TaiKhoan.EXECUTE_DELETE_BY_ID);
		  assertEquals(i, 1);
	  }
	
}
