package com.automation.selenium;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.interactions.Actions;

public class CSSSelectors {

	public static void main(String[] args) throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver", "./Drivers/chromedriver.exe");
		System.setProperty(ChromeDriverService.CHROME_DRIVER_SILENT_OUTPUT_PROPERTY, "true");
		
		WebDriver driver = new ChromeDriver();
		
		driver.manage().timeouts().pageLoadTimeout(30,  TimeUnit.SECONDS);				
		
		driver.get("http://demosite.center/wordpress/wp-login.php");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		//id
		driver.findElement(By.cssSelector("input#user_login")).sendKeys("admin");
		//attribute
		driver.findElement(By.cssSelector("input[name='pwd']")).sendKeys("demo123");
		//class
		driver.findElement(By.cssSelector("input.button-large")).click();
		//driver.findElement(By.cssSelector("input.button.button-primary.button-large#wp-submit")).click();
		
		Thread.sleep(5000);
		
		driver.findElement(By.cssSelector("button[id^='contextual-help']")).click();
		
		Thread.sleep(2000);
		driver.findElement(By.cssSelector("a[aria-controls$='help-layout']")).click();
		
		Actions action = new Actions(driver);
		
		WebElement ele=driver.findElement(By.xpath("//a[contains(text(),'Hi,')]"));
		
		action.moveToElement(ele).perform();
		
		Thread.sleep(5000);
		//attribute - contains
		WebElement ele2=driver.findElement(By.cssSelector("a[href*='logout']"));
		action.click(ele2).perform();
		
		//driver.findElement(By.cssSelector("a[href*='logout']")).click();

	}

}
