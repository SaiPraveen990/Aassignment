package com.AddToCart.PO;

import java.util.Set;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PO_Elements {
	
	@FindBy(how =How.XPATH,using="//span[contains(text(),'Select your address')]")
	public WebElement addressSelect;
	
	@FindBy(how =How.XPATH,using="//input[@id='GLUXZipUpdateInput']")
	public WebElement addressEnter;
	
	//input[@id='GLUXZipUpdateInput']
	
	@FindBy(how =How.XPATH,using="//span[text()='realme']//preceding-sibling::div")
	public WebElement CheckBox;
	
	@FindBy(how =How.XPATH,using="//input[@id='twotabsearchtextbox']")
	public WebElement searchbox;
	
	@FindBy(how =How.XPATH,using="//span[contains(text(),'Realme 8 Pro')]")
	public WebElement product;
	
	
	@FindBy(how =How.XPATH,using="(//span[contains(text(),'Realme 8 Pro')])[1]")
	public WebElement productVerify;

	@FindBy(how =How.XPATH,using="//input[@id='add-to-cart-button']")
	public WebElement AddCart;
	
	PO_Common pcr;
	public PO_Elements(WebDriver driver) {
		PageFactory.initElements(driver, this);
		pcr =new PO_Common();
	}
	int flag =0;
	JavascriptExecutor js ;
	public boolean AddToCart(WebDriver driver) throws InterruptedException {
		pcr.click(addressSelect);
		WebDriverWait wait = new WebDriverWait(driver,20);
		wait.until(ExpectedConditions.elementToBeClickable(addressEnter));
		pcr.enterData("500072", addressEnter);
		Thread.sleep(3);
		wait.until(ExpectedConditions.elementToBeClickable(searchbox));
		pcr.click(searchbox);
		pcr.enterData("MobilePhones",searchbox);
		wait.until(ExpectedConditions.elementToBeClickable(CheckBox));
		pcr.click(CheckBox);
		js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();", product);
//		pcr.mouseHover(product, driver);
		Thread.sleep(3);
		pcr.click(product);
		Thread.sleep(3);
		
		String parent = driver.getWindowHandle();
		Set<String> child = driver.getWindowHandles();
		for(String handle : child) {
			if(!parent.equalsIgnoreCase(handle)) {
				driver.switchTo().window(handle);
			}
			if(pcr.verifyText(driver, productVerify, "Realme 8 Pro") == true) {
				pcr.click(AddCart);
				flag = 1;
			}
		}
		return true;
		
	}
	
}
