package poro.module;

import static org.testng.Assert.assertEquals;
import org.testng.Assert;
import org.testng.annotations.Test;

public class StringHelperTest {

  @Test	
  public void randomTest1() {
    String ran1 = StringHelper.random(5);
    String ran2 = StringHelper.random(5);
    Assert.assertNotEquals(ran1, ran2);
  }
  @Test
public void randomTest2() {
    String ran1 = StringHelper.random(7);
    String ran2 = StringHelper.random(5);
    assertEquals(ran1.length(),7);
    assertEquals(ran2.length(),5);
  }
}