package com.automation.selenium;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;

public class HandleBootstrapDropdown {

	public static void main(String... args) throws InterruptedException
	{
		String url="http://seleniumpractise.blogspot.com/2016/08/bootstrap-dropdown-example-for-selenium.html";

		System.setProperty("webdriver.chrome.driver", "./Drivers/chromedriver.exe");
		System.setProperty(ChromeDriverService.CHROME_DRIVER_SILENT_OUTPUT_PROPERTY, "true");
		
		WebDriver driver = new ChromeDriver();
		
		driver.manage().timeouts().pageLoadTimeout(60,  TimeUnit.SECONDS);				
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get(url);
		
		driver.findElement(By.xpath("//*[@id='menu1']")).click();
		Thread.sleep(2000);
		
		String dropdownKey="JavaScript";
		
		List<WebElement> bootDropdown = driver.findElements(By.xpath("//a[@role='menuitem']"));
		
		for(WebElement ele: bootDropdown)
		{
			System.out.println("values: "+ ele.getText());
			System.out.println("values: "+ ele.getAttribute("innerText"));
			System.out.println("values: "+ ele.getAttribute("innerHTML"));
			
			if(ele.getText().equals(dropdownKey))
			{
				ele.click();
				break;
			}
			
		}
		
	}
	
}
