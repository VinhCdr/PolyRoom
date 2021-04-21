package poro.module.db.data;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;

import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;
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
	
	@Test
	  public void InsertTaiKhoan() {
		  TaiKhoan tk = new TaiKhoan();
		  tk.setIdTaiKhoan("loilh");
		  tk.setMatKhau("123");
		  tk.setTen("luong huu loi");
		  tk.setEmail("loilhpc01261@fpt.edu.vn");
		  tk.setSdt("0909123456");
		  tk.setPhanQuyen(true);
		  int i = DatabaseManager.executeUpdate(tk, TaiKhoan.EXECUTE_INSERT);
		  assertEquals(i, 1);
		  DatabaseManager.executeUpdate(tk, TaiKhoan.EXECUTE_DELETE_BY_ID);
	  }
	
	 @Test
	  public void UpdateTaiKhoan() {
		  TaiKhoan tk = new TaiKhoan();
		  tk.setIdTaiKhoan("loilh");
		  tk.setMatKhau("123");
		  tk.setTen("luong loi");
		  tk.setEmail("loilhpc01261@fpt.edu.vn");
		  tk.setSdt("0909654321");
		  tk.setPhanQuyen(true);
		  int i = DatabaseManager.executeUpdate(tk, TaiKhoan.EXECUTE_UPDATE_BY_ID);
		  assertEquals(i, 1);
	  }
	 
	 @Test
	 public void DeleteTaiKhoan() {
		 TaiKhoan tk = new TaiKhoan();
		  tk.setIdTaiKhoan("vinhlm");
		  int i = DatabaseManager.executeUpdate(tk, TaiKhoan.EXECUTE_DELETE_BY_ID);
		  assertEquals(i, 1);
	  }
	
}
