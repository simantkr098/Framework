package com.automation.testcases;

import java.util.HashMap;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.automation.pages.BaseClass;
import com.automation.pages.LoginPage;



public class LoginTestCRM extends BaseClass {
		
	@Test
	@Parameters({"browserName","appURL","xmlFileName"})
	public void loginApp(String bName, String aName, String xName)
	{
		System.out.println("---> BrowserName: "+bName);
		System.out.println("---> App URL: "+aName);
		System.out.println("---> XML Name: "+xName);
		
		logger = report.createTest("Login to App");
				
		LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);

		logger.info("Starting Apllication");
		
		HashMap<String,String> data= excel.getRowData("Login","TC01");
		loginPage.loginToCRM(data.get("UserName"),data.get("Password"));
		
		Assert.assertEquals(loginPage.getBrowserTitle(),config.getDataFromConfig("landingPageTitle"));
		logger.pass("Login Done Successfull");

		
	}
	
}
