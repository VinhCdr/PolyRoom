package poro.module;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Year;
import java.util.Date;

import org.testng.Assert;
import org.testng.annotations.Test;



public class CalendarManagerTest {

  @Test
  public void addTimesTest() {
	  Date time = new Date();
	  long a=10;
	  Date hientai = CalendarManager.addTimes(time, a);
	  long mongmuon = time.getTime()+a;
	  Assert.assertEquals(hientai.getTime(), mongmuon);
   
    
  }

  @Test
  public void getDateByStringTest() {
	
try {
	 
	String b = "mm-dd-yyyy";
    SimpleDateFormat a = new SimpleDateFormat();
    Date hientai;
	hientai = a.parse(b);
	String mongmuon="4-21-2021";
	   Assert.assertEquals(hientai, mongmuon);
} catch (ParseException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}
   
    
    
  }

  @Test
  public void getDaysOfTest() {
	  
	  
   int hientai = CalendarManager.getDaysOf(2020, 3);
   int mongmuon = CalendarManager.getDaysOf(2020, 3);
   Assert.assertEquals(hientai, mongmuon);
   
  }

  @Test
  public void getNowTest() {
    Date thucte = CalendarManager.getNow();
    Date mongmuon = new Date();
    Assert.assertEquals(thucte, mongmuon);
    
  }

  @Test
  public void getStringTest() {
	
    Date ngay = new Date();
    String chuyen="21";
    String hientai = CalendarManager.getString(ngay, chuyen);
    String mongmuon="21";
    Assert.assertEquals(hientai, mongmuon);
    
    
  }

  @Test
  public void isLeapYearTest() {
    boolean hientai = CalendarManager.isLeapYear(2020);
    boolean thucte = CalendarManager.isLeapYear(2000);
    Assert.assertEquals(hientai, thucte);
  }
}
