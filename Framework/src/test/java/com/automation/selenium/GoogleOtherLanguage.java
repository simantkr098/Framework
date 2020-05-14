package com.automation.selenium;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;

public class GoogleOtherLanguage {
	
	public static void main(String[] args) throws InterruptedException {
		
	System.setProperty("webdriver.chrome.driver", "./Drivers/chromedriver.exe");
	System.setProperty(ChromeDriverService.CHROME_DRIVER_SILENT_OUTPUT_PROPERTY, "true");
	
	WebDriver driver = new ChromeDriver();
	
	driver.manage().timeouts().pageLoadTimeout(30,  TimeUnit.SECONDS);				
	
	driver.get("https://www.google.com/");
	driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	
	driver.findElement(By.linkText("ગુજરાતી")).click();
	
		
//		String s = "ग्राहक";
//		String t = "\u0917\u094d\u0930\u093e\u0939\u0915";
//		t = "\u0958";
//		System.out.println("s = " + s);
//		System.out.println("t = " + t);
//		System.out.println("s equals t: " + s.equals(t));
}
}
