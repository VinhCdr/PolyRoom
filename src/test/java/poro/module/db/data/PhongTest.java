package poro.module.db.data;

import static org.testng.Assert.assertEquals;

import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;

import poro.module.db.DatabaseManager;

public class PhongTest {
  
	
	
  @Test
  public void SelectAllphong() {
	  Phong p = new Phong();
	  List<Phong> lp = DatabaseManager.executeQuery(p, Phong.EXECUTE_SELECT_ALL);
	  Assert.assertFalse(lp.isEmpty());
  }
  
  @Test
  public void SelectByIdPhong() {
	  Phong p = new Phong();
	  p.setIdPhong(1);
	  List<Phong> lp = DatabaseManager.executeQuery(p, Phong.EXECUTE_SELECT_BY_ID);
	  Assert.assertFalse(lp.isEmpty());
  }
  
  @Test
  public void InsertPhong() {
	  Phong p = new Phong();
	  p.setIdPhong(30);
	  p.setIdSoTang(1);
	  p.setTenPhong("phongit");
	  p.setChoMuon(true);
	  int i = DatabaseManager.executeUpdate(p, Phong.EXECUTE_INSERT);
	  assertEquals(i, 1);
	  DatabaseManager.executeUpdate(p, Phong.EXECUTE_DELETE_BY_ID);
  }
  
  @Test
  public void UpdatePhong() {
	  Phong p = new Phong();
	  p.setIdPhong(3);
	  p.setIdSoTang(2);
	  p.setTenPhong("phongi123t");
	  p.setChoMuon(true);
	  int i = DatabaseManager.executeUpdate(p, Phong.EXECUTE_UPDATE_BY_ID);
	  assertEquals(i, 1);
  }
  
  public void DeletePhong() {
	  Phong p = new Phong();
	  p.setIdPhong(4);
	  List<Phong> lp = DatabaseManager.executeQuery(p, Phong.EXECUTE_DELETE_BY_ID);
	  Assert.assertFalse(lp.isEmpty());
  }
}
