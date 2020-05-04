package com.automation.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage {
	
	WebDriver driver;
	
	public LoginPage(WebDriver driver)
	{
			this.driver=driver;
	}
		
	@FindBy(name="userName") WebElement uname;
	@FindBy(name="password") WebElement passwd;
	@FindBy(xpath="//input[@value='Login']") WebElement signInBtn;
	
	
	public void loginToCRM(String userName, String password)
	{
		uname.sendKeys(userName);
		passwd.sendKeys(password);
		signInBtn.click();
	}
		
	public String getBrowserTitle() {
		return driver.getTitle();
	}
}
