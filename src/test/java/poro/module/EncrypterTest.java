package poro.module;

import org.testng.Assert;
import org.testng.annotations.Test;

public class EncrypterTest {

  @Test
  public void toMD5Testbyte1() {
    String s1 = Encrypter.toMD5(new byte[] {1,2,3,4});
    String s2 = Encrypter.toMD5(new byte[] {1,2,3,4});
    
    Assert.assertEquals(s1, s2);
    
  }
  @Test
  public void toMD5Testbyte2() {
	    String s1 = Encrypter.toMD5(new byte[] {1,2,3,4});
	    String s2 = Encrypter.toMD5(new byte[] {1,2,3,4,5});
	    
	    Assert.assertNotEquals(s1, s2);
	    
	  }

  @Test
  public void toMD5TestString1() {
   String s1 = Encrypter.toMD5("chuoi1");
   String s2 = Encrypter.toMD5("chuoi1");
   
   Assert.assertEquals(s1, s2);
  }
  @Test
  public void toMD5TestString2() {
   String s1 = Encrypter.toMD5("chuoi2");
   String s2 = Encrypter.toMD5("daychuoi2");
   
   Assert.assertNotEquals(s1, s2);
  }
}
