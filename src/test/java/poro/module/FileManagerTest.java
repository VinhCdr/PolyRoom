package poro.module;

import static org.testng.Assert.assertEquals;

import org.testng.Assert;
import org.testng.annotations.Test;

import poro.module.db.data.TaiKhoan;

public class FileManagerTest {

  @Test
  public void readTest() {
	  FileManager fm = new FileManager("testfile.txt");
	  byte[] x = new byte[]{1,2,3,4,5,6};
	  fm.write(x);
	  byte[] read = fm.read();
	  Assert.assertEquals(read, x);
  }

  @Test
  public void readObjectTest() {
	  TaiKhoan tk = new TaiKhoan();
	  FileManager fm = new FileManager("test.dat");
	  fm.writeObject(tk);
	  
	  TaiKhoan readtk = fm.readObject();
	  Assert.assertEquals(readtk, tk);
  }

  @Test
  public void readStringTest() {
	  FileManager fm = new FileManager("testfile2.txt");
	  fm.writeString("123abcxyz");
	  String read = fm.readString();
	  assertEquals(read, "123abcxyz");
  }

  @Test
  public void writeTest() {
	  FileManager fm = new FileManager("testfile.txt");
	  byte[] x = new byte[]{1,2,3,4,5,6};
	  fm.write(x);
	  byte[] read = fm.read();
	  Assert.assertEquals(read, x);
  }

  @Test
  public void writeObjectTest() {
	  TaiKhoan tk = new TaiKhoan();
	  FileManager fm = new FileManager("test2.dat");
	  fm.writeObject(tk);
	  
	  TaiKhoan readtk = fm.readObject();
	  Assert.assertEquals(readtk, tk);
  }

  @Test
  public void writeStringTest() {
	  FileManager fm = new FileManager("testfile.txt");
	  fm.writeString("123abcxyz");
	  String read = fm.readString();
	  assertEquals(read, "123abcxyz");
  }
}
