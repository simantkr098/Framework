package com.automation.selenium;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;

public class HandleRadioGroupAndCheckBoxs {

	public static void main(String[] args) {

		String url="http://seleniumpractise.blogspot.com/2016/08/how-to-automate-radio-button-in.html";

		System.setProperty("webdriver.chrome.driver", "./Drivers/chromedriver.exe");
		System.setProperty(ChromeDriverService.CHROME_DRIVER_SILENT_OUTPUT_PROPERTY, "true");
		
		WebDriver driver = new ChromeDriver();
		
		driver.manage().timeouts().pageLoadTimeout(60,  TimeUnit.SECONDS);				
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get(url);
	
		//Normal Radio Button - where each button have unique property
		
		//Important
			WebElement radiobtn = driver.findElement(By.xpath("//input[@id='male' and not(@hidden)]"));
			if(radiobtn.isDisplayed())
			{
				System.out.print("Radio Btn is >> Displayed");
				if(radiobtn.isEnabled())
				{
					System.out.print(">> Enabled >> ");
					radiobtn.click();
					
					if(radiobtn.isSelected())
					{
						System.out.println(">> Selected");
					}
					else
					{
						System.out.println(">> Not Selected");
					}
					
				}
				else
				{
					System.out.println(">> Not Enabled");
					
				}
			}
			else
			{
				System.out.println("Radio Btn is >> Not Displayed");
				
			}
		
		
				
		//Dynamic Radio Group where all the button have same properties
		String sRadioKey="Python";
		List<WebElement> radioGroup = driver.findElements(By.xpath("//input[@type='radio' and @name='lang']"));
		for(int i=0;i<radioGroup.size();i++) 
		{
			String str=radioGroup.get(i).getAttribute("value");
			System.out.println("Value of "+i+" radio is: "+str);
			if(str.equalsIgnoreCase(sRadioKey))
			{
				radioGroup.get(i).click();
				System.out.println("The "+(i+1)+" Radio Button status is: "+radioGroup.get(i).isSelected());
			}
		}
						
		
	//Dynamic CheckBox Group where all the button have same properties
		String sCheckBoxKey="code";
		List<WebElement> chkBoxGroup = driver.findElements(By.xpath("//input[@type='checkbox' and @name='lang']"));
		int i=0;
		for(WebElement ele : chkBoxGroup) 
		{
			i++;
			String str=ele.getAttribute("id");
			System.out.println("Value of "+i+" CheckBox is: "+str);
			if(str.equalsIgnoreCase(sCheckBoxKey))
			{
				ele.click();
				System.out.println("The "+i+" checkBox status is: "+ele.isSelected());
			}
		}
		
	
	
	}

}
