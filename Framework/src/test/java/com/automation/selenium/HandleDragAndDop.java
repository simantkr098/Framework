package com.automation.selenium;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;

public class HandleDragAndDop {

	public static void main(String[] args) {

		String url="http://seleniumpractise.blogspot.com/2016/08/bootstrap-dropdown-example-for-selenium.html";

		System.setProperty("webdriver.chrome.driver", "./Drivers/chromedriver.exe");
		System.setProperty(ChromeDriverService.CHROME_DRIVER_SILENT_OUTPUT_PROPERTY, "true");

		WebDriver driver = new ChromeDriver();

		driver.manage().timeouts().pageLoadTimeout(60,  TimeUnit.SECONDS);				
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get(url);

	}

}
