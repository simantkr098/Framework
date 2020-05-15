package com.automation.selenium;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;

public class HandleAlert {

	public static void main(String[] args) throws InterruptedException {

		String url="https://ksrtc.in/oprs-web/guest/ticket/cancel.do";

		System.setProperty("webdriver.chrome.driver", "./Drivers/chromedriver.exe");
		System.setProperty(ChromeDriverService.CHROME_DRIVER_SILENT_OUTPUT_PROPERTY, "true");

		WebDriver driver = new ChromeDriver();

		driver.manage().timeouts().pageLoadTimeout(60,  TimeUnit.SECONDS);				
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get(url);

		driver.findElement(By.id("searchBtn")).click();
		Thread.sleep(5000);
		
		Alert dialog = driver.switchTo().alert();
		System.out.println("Dialog Message: "+ dialog.getText());
		//dialog.accept();
		
		Thread.sleep(5000);
		
		driver.switchTo().alert().accept();
		
		Thread.sleep(5000);
		System.out.println(driver.getTitle());
		System.out.println(driver.findElement(By.xpath("//li[text()='Welcome to KSRTC']//following-sibling::li/a")).getText());
		
	}

}
