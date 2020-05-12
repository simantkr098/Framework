package com.automation.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import com.automation.pages.BaseClass;




@SuppressWarnings("unused")
public class ExecuteJavaScript extends BaseClass {
	
	
	@Test
	public void ExecuteJS() throws InterruptedException
	{
		JavascriptExecutor js= ((JavascriptExecutor)driver);
	
		js.executeScript("document.getElementsByName('userName').item(0).value='simsim'");
		// OR
		
//		WebElement element = driver.findElement(By.xpath("//input[@value='Login']"));
//		js.executeScript("arguments[0].click()", element);
		
		Thread.sleep(5000);
		
	}
	
	
}
