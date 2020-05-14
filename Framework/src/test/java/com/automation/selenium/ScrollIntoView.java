package com.automation.selenium;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;


public class ScrollIntoView {

	public static void main(String[] args) throws InterruptedException {


		String url="http://manos.malihu.gr/repository/custom-scrollbar/demo/examples/complete_examples.html";

		System.setProperty("webdriver.chrome.driver", "./Drivers/chromedriver.exe");
		System.setProperty(ChromeDriverService.CHROME_DRIVER_SILENT_OUTPUT_PROPERTY, "true");
		
		WebDriver driver = new ChromeDriver();
		
		driver.manage().timeouts().pageLoadTimeout(60,  TimeUnit.SECONDS);				
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get(url);
		
		//1st element
		WebElement ele1 = driver.findElement(By.cssSelector("div#mCSB_1_container > p.full > img.mCS_img_loaded[src*='img5']"));
		
		if(ele1.isDisplayed())
		{
			System.out.println(">>> element ele1 is displayed");
		}
		else
		{
			System.out.println(">>> element ele1 is Not displayed");
		}
		
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollIntoView(true);", ele1);
		
		if(ele1.isDisplayed())
		{
			System.out.println(">>> element ele1 is displayed");
		}
		else
		{
			System.out.println(">>> element ele1 is Not displayed");
		}

		Thread.sleep(5000);
		
		//2nd element
		WebElement ele2 = driver.findElement(By.xpath("//div[@id='mCSB_2_container']//p[contains(text(),'Quis autem')]"));
		
		if(ele2.isDisplayed())
		{
			System.out.println(">>> element ele2 is displayed");
		}
		else
		{
			System.out.println(">>> element ele2 is Not displayed");
		}
		
		js.executeScript("arguments[0].scrollIntoView(true);", ele2);
		
		if(ele2.isDisplayed())
		{
			System.out.println(">>> element ele2 is displayed");
			System.out.println(">>> Text: "+ele2.getText());
		}
		else
		{
			System.out.println(">>> element ele2 is Not displayed");
		}
		
		Thread.sleep(5000);
		
		//3rd element
		WebElement ele3 = driver.findElement(By.cssSelector("p>textarea"));
		
		if(ele3.isDisplayed())
		{
			System.out.println(">>> element ele3 is displayed");
		}
		else
		{
			System.out.println(">>> element ele3 is Not displayed");
		}
		
		js.executeScript("arguments[0].scrollIntoView(true);", ele3);
		
		if(ele3.isDisplayed())
		{
			System.out.println(">>> element ele3 is displayed");
			ele3.clear();
			ele3.sendKeys("simsim");		
			
			System.out.println(">>> Text Entered: "+ele3.getText());
		}
		else
		{
			System.out.println(">>> element ele3 is Not displayed");
		}
		
		Thread.sleep(5000);
		
		//4th element
		WebElement ele4 = driver.findElement(By.partialLinkText("MIT"));
		
		if(ele4.isDisplayed())
		{
			System.out.println(">>> element ele4 is displayed");
		}
		else
		{
			System.out.println(">>> element ele4 is Not displayed");
		}
		
		js.executeScript("arguments[0].scrollIntoView(true);", ele4);
		
		if(ele4.isDisplayed())
		{
			System.out.println(">>> element ele4 is displayed");
			System.out.println(">>> Link text: "+ele4.getText());
//			ele4.click();
		}
		else
		{
			System.out.println(">>> element ele4 is Not displayed");
		}
				
				
				
		
	}

}
