package com.automation.selenium;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;

import com.automation.utility.Helper;

public class HandleFrames {

	public static void main(String[] args) throws InterruptedException {

		String url="https://demoqa.com/iframe-practice-page/";

		System.setProperty("webdriver.chrome.driver", "./Drivers/chromedriver.exe");
		System.setProperty(ChromeDriverService.CHROME_DRIVER_SILENT_OUTPUT_PROPERTY, "true");

		WebDriver driver = new ChromeDriver();

		driver.manage().timeouts().pageLoadTimeout(60,  TimeUnit.SECONDS);				
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get(url);
		
		JavascriptExecutor js = (JavascriptExecutor)driver;
		
		//ByID
		driver.switchTo().frame("IF1");
		WebElement ele = driver.findElement(By.xpath("(//a[contains(node(),'LambdaTest Tutorial')])[1]"));
		System.out.println(ele.isDisplayed());
		Helper.HighlightWebElement(driver, ele);
		Thread.sleep(5000);
		driver.switchTo().defaultContent();
		
		//ByName
		driver.switchTo().frame("iframe2");
		ele = driver.findElement(By.linkText("Sortable"));
		System.out.println(ele.isDisplayed());
		Helper.HighlightWebElement(driver, ele);
		Thread.sleep(5000);
		driver.switchTo().defaultContent();
		
		//ByIndex
		driver.switchTo().frame(0);
		ele = driver.findElement(By.xpath("(//a[contains(node(),'Katalon Studio Tutorial')])[1]"));
		System.out.println(ele.isDisplayed());
		Helper.HighlightWebElement(driver, ele);
		Thread.sleep(5000);
		driver.switchTo().defaultContent();
		
		//ByWebElement
		ele = driver.findElement(By.xpath("//iframe[@name='iframe2']"));
		driver.switchTo().frame(ele);
		ele = driver.findElement(By.linkText("Resizable"));
		System.out.println(ele.isDisplayed());
		Helper.HighlightWebElement(driver, ele);
		Thread.sleep(5000);
		driver.switchTo().defaultContent();
	}

}
