package com.AddToCart.PO;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class PO_Common {
	
	public void click(WebElement element) {
		element.click();
	}
	
	public void enterData(String text,WebElement element) {
		element.sendKeys(text,Keys.ENTER);
	}
	
	public void clear(WebElement element) {
		element.clear();
	}
	
	public void mouseHover(WebElement element, WebDriver driver) {
		Actions act = new Actions(driver);
		act.moveToElement(element).build().perform();
	}
	
	public boolean verifyText(WebDriver driver, WebElement element, String expectedText) {
		String ActualText = element.getText();
		if(ActualText.equalsIgnoreCase(expectedText)) {
			return true;
		}
		return false;
	}
	
}
