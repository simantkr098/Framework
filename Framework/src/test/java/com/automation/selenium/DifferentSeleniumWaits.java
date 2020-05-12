package com.automation.selenium;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.common.base.Function;

public class DifferentSeleniumWaits {

	public static void main(String[] args) {
		
		String url="http://seleniumpractise.blogspot.in/2016/08/how-to-use-explicit-wait-in-selenium.html";
		
		System.setProperty("webdriver.chrome.driver", "./Drivers/chromedriver.exe");
		System.setProperty(ChromeDriverService.CHROME_DRIVER_SILENT_OUTPUT_PROPERTY, "true");
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.get(url);
		
		driver.findElement(By.xpath("//button[text()='Click me to start timer']")).click();
		
		/* 1st Implicit Wait */

//		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);		
//		WebElement ele = driver.findElement(By.xpath("//p[text()='WebDriver']"));
		
		/* 2nd Implicit Wait */
		
//		WebDriverWait wait = new WebDriverWait(driver,30);		
//		WebElement ele = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[text()='WebDriver']")));
		
		/* 3rd Fluent Wait */
		
		FluentWait<WebDriver> wait = new FluentWait<WebDriver>(driver);
//		wait.pollingEvery(250, TimeUnit.MILLISECONDS);
//		wait.withTimeout(30, TimeUnit.SECONDS);
//		wait.ignoring(NoSuchElementException.class);
		
		wait.pollingEvery(Duration.ofMillis(250));
		wait.withTimeout(Duration.ofSeconds(30));
		wait.ignoring(NoSuchElementException.class);
		
		
		WebElement ele = wait.until(new Function<WebDriver, WebElement>()
		{
			public WebElement apply(WebDriver arg0) {
				
				WebElement tmp = arg0.findElement(By.id("demo"));
				
				System.out.println("Vaue is: "+tmp.getAttribute("innerHTML"));
				
				if(tmp.getAttribute("innerHTML").equalsIgnoreCase("WebDriver"))
					return tmp;
				else
					return null;
			}
		});

				
		if(ele.isDisplayed())
		{
			System.out.println("Element is Displayed");
		}
		else
		{
			System.out.println("Element is Not Displayed");
		}
	}

}
