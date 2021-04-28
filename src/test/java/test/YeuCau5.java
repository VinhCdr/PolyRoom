package test;

import static org.testng.Assert.assertEquals;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class YeuCau5 {
	
	WebDriver browser;
	
	@BeforeClass
	public void init() {
		System.setProperty("webdriver.chrome.driver", "asset/chromedriver.exe");
		browser = new ChromeDriver();
	}
	
	@AfterClass
	public void close() throws InterruptedException {
		Thread.sleep(2000);
		browser.close();
	}
	
	@Test(groups = "lauchBrowser")
	public void launchBrowser() {
		browser.get("https://ap.poly.edu.vn/");
		browser.manage().window().maximize();
		browser.manage().deleteAllCookies();
		browser.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	
	@Test(dependsOnGroups = "lauchBrowser")
	public void signIn() throws InterruptedException {
		WebElement sinhVien = browser.findElement(By.cssSelector("a[href=\"https://ap.poly.edu.vn/login\"]"));
		sinhVien.click();
		Thread.sleep(1000);
		WebElement chonCoSo = browser.findElement(By.name("campus_id"));
		chonCoSo.click();
		WebElement canTho = browser.findElement(By.cssSelector("option[value=\"pc\"]"));
		canTho.click();
		Thread.sleep(1000);
		WebElement google = browser.findElement(By.id("btn_login_google"));
		google.click();
		Thread.sleep(1000);
	}
	@Test(dependsOnMethods = "signIn")
	public void fillSignIn() throws InterruptedException {
		WebElement email = browser.findElement(By.name("identifier"));
		email.sendKeys("vinhlmpc01238");
		Thread.sleep(500);
		email.sendKeys(Keys.ENTER);
		Thread.sleep(1500);
		
		WebElement pass = browser.findElement(By.name("password"));
		pass.click();
		pass.sendKeys("Xwt5Z9?NGb8Y!@Bq!x-gRWs");
		Thread.sleep(500);
		pass.sendKeys(Keys.ENTER);
		
		Thread.sleep(6000);
		WebElement okie = browser.findElement(By.className("kt-header__topbar-username"));
		assertEquals(okie.getText(), "Vinh");
	}
	
	
}
