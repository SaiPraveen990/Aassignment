package com.AddToCart.TestScript;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import com.AddToCart.PO.PO_Elements;
public class Test_AddToCart {
	
	WebDriver driver;
	PO_Elements addcart;
	
	
	@BeforeTest
	public void Setup() {
		System.setProperty("webdriver.chrome.driver", "D:\\Drivers\\chromedriver.exe");
		 driver  = new ChromeDriver();
		 driver.get("https://www.amazon.in");
		 driver.manage().window().maximize();
		 driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		addcart = new PO_Elements(driver);
	}
	
	@Test
	public void AddToCart() throws InterruptedException {
		Assert.assertTrue(addcart.AddToCart(driver));

	}
	
	@AfterTest
	public void close() {
		driver.quit();
	}
}
