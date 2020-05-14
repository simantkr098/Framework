package com.automation.selenium;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.support.ui.Select;

public class HandleSimpleDropdownAndRadioButton {

	public static void main(String[] args) {

		String url="https://www.facebook.com/";

		System.setProperty("webdriver.chrome.driver", "./Drivers/chromedriver.exe");
		System.setProperty(ChromeDriverService.CHROME_DRIVER_SILENT_OUTPUT_PROPERTY, "true");
		
		WebDriver driver = new ChromeDriver();
		
		driver.manage().timeouts().pageLoadTimeout(60,  TimeUnit.SECONDS);				
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get(url);
		
		//Select Date Dropdown
		String selectedValue=null;
		
		WebElement month = driver.findElement(By.id("month"));
		if(chkWebElement(month,"Month Dropdown"))
		{
			Select monthDropdown = new Select(month);
			monthDropdown.selectByIndex(1);
			selectedValue=monthDropdown.getFirstSelectedOption().getText();
			System.out.println("Month selected is: "+ selectedValue);
			
			List<WebElement> monthOptions= monthDropdown.getOptions();
			for(WebElement ele:monthOptions)
			{
				System.out.println("The month options are: "+ele.getText());
			}
		}
		
		WebElement day = driver.findElement(By.xpath("//select[@name='birthday_day']"));
		if(chkWebElement(month,"Day Dropdown"))
		{
			Select dayDropdown = new Select(day);
			dayDropdown.selectByValue("2");
			selectedValue=dayDropdown.getFirstSelectedOption().getText();
			System.out.println("Day selected is: "+ selectedValue);
		}
		
		WebElement year = driver.findElement(By.cssSelector("select[name='birthday_year']"));
		if(chkWebElement(month,"Year Dropdown"))
		{
			Select yearDropdown = new Select(year);
			yearDropdown.selectByVisibleText("1988");
			selectedValue=yearDropdown.getFirstSelectedOption().getText();
			System.out.println("Year selected is: "+ selectedValue);
		}
		
				
		//Select Sex Radio Button
		WebElement radioBtn = driver.findElement(By.xpath("//label[text()='Male']//preceding-sibling::input[@type='radio']"));
		if(chkWebElement(radioBtn,"Sex Radio Button"))
		{
			radioBtn.click();
					
			if(radioBtn.isSelected())
			{
				System.out.println(">> Selected");
			}
			else
			{
				System.out.println(">> Not Selected");
			}
		}
	
		WebElement ForgetPasswdLnk = driver.findElement(By.linkText("Forgot account?"));
		
		if(chkWebElement(ForgetPasswdLnk,"Forgot Passwd Link"))
		{
			ForgetPasswdLnk.click();
					
			if(driver.getTitle().contains("Forgot Password"))
			{
				System.out.println(">> Link Working");
			}
			else
			{
				System.out.println(">> Link Not Working");
			}
		}		
				
	}
	
	public static boolean chkWebElement(WebElement ele,String eleName)
	{
		if(ele.isDisplayed())
		{
			System.out.print(eleName+" is >> Displayed");
			if(ele.isEnabled())
			{
				System.out.print(">> Enabled >> ");
				return true;
			}
			else
			{
				System.out.println(">> Not Enabled");
				return false;
			}
		}
		else
		{
			System.out.println(eleName+" is >> Not Displayed");
			return false;
		}
	}

}
