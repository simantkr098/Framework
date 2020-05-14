package com.automation.selenium;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;

public class ScrollsTypes {


		public static void main(String... args) throws InterruptedException
		{
			String url="https://www.monsterindia.com/seeker/registration?";

			System.setProperty("webdriver.chrome.driver", "./Drivers/chromedriver.exe");
			System.setProperty(ChromeDriverService.CHROME_DRIVER_SILENT_OUTPUT_PROPERTY, "true");
			
			WebDriver driver = new ChromeDriver();
			
			driver.manage().timeouts().pageLoadTimeout(60,  TimeUnit.SECONDS);				
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			driver.manage().window().maximize();
			driver.get(url);
			
			WebElement choseFileBtn = driver.findElement(By.cssSelector("label[for='file-upload']"));
			
			JavascriptExecutor js = (JavascriptExecutor)driver;
			js.executeScript("window.scrollBy(0,300);");
			Thread.sleep(5000);
			
			js.executeScript("window.scrollBy(0,-200);");
			Thread.sleep(5000);
			
			js.executeScript("scroll(0,250);");
			Thread.sleep(5000);
			
			js.executeScript("arguments[0].scrollIntoView(true);", choseFileBtn);
			Thread.sleep(5000);
			
			js.executeScript("window.scrollBy(0,document.body.scrollHeight);");
			Thread.sleep(5000);
			
			js.executeScript("window.scrollBy(0,0);");
			Thread.sleep(5000);
			
			js.executeScript("window.scrollBy(document.body.scrollWidth,0);");
			Thread.sleep(5000);
			
			js.executeScript("window.scrollBy(document.body.scrollWidth,document.body.scrollHeight);");
			Thread.sleep(5000);
			
			js.executeScript("window.scrollBy(-(document.body.scrollWidth),-(document.body.scrollHeight));");
			Thread.sleep(5000);
			
		
		}
	
}
