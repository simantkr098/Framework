package com.automation.testcases;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class LaunchBrowserTestWithoutFramework {

  @Test
  public void mainTest() {
   
	  try {
			
//			System.setProperty("webdriver.ie.driver", "./Drivers/IEdriver.exe");
//			WebDriver driver = new InternetExplorerDriver();
			
//			System.setProperty("webdriver.gecko.driver", "./Drivers/geckodriver.exe");
//			WebDriver driver = new FirefoxDriver();
			
			
			System.setProperty("webdriver.chrome.driver", "./Drivers/chromedriver.exe");
			WebDriver driver = new ChromeDriver();
			driver.get("http://newtours.demoaut.com/");
			driver.manage().window().maximize();
			driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			
			
			driver.findElement(By.name("userName")).sendKeys("Selenium_50");
			driver.findElement(By.name("password")).sendKeys("Abcd@123456");
			driver.findElement(By.xpath("//input[@value='Login']")).click();
			
			System.out.println(driver.getTitle());
			
			driver.quit();
			
		} finally {
			
			try {
				
				Runtime.getRuntime().exec("taskkhttp://marketplace.eclipse.org/marketplace-client-intro?mpc_install=1549ill /im chromedriver.exe /f");
				
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
		
  }
}
