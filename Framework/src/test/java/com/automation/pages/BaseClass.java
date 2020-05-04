package com.automation.pages;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;

import com.automation.utility.BrowserFactory;
import com.automation.utility.ConfigDataProvider;
import com.automation.utility.ExcelDataProvider;
import com.automation.utility.Helper;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class BaseClass {

	public WebDriver driver;
	public ConfigDataProvider config;
	public ExcelDataProvider excel;
	public ExtentReports report;
	public ExtentTest logger;
	
	
	@BeforeSuite
	public void setUpSuite()
	{
		excel= new ExcelDataProvider("./TestData/MasterData.xlsx");
		config = new ConfigDataProvider();
	
		ExtentHtmlReporter reporter = new ExtentHtmlReporter(new File(System.getProperty("user.dir")+"/Reports/Login_"+Helper.getCurrentDate()+".html"));
		report = new ExtentReports();
		report.attachReporter(reporter);
		
	}
	
	@BeforeClass
	public void setup()
	{
		driver=BrowserFactory.startApplication(driver, config.getDataFromConfig("browser"), config.getDataFromConfig("qaURL"));
		Assert.assertEquals(driver.getTitle(), config.getDataFromConfig("loginPageTitle"));
	}
	
	@AfterClass
	public void tearDown()
	{
		BrowserFactory.quitBrowser(driver);
	}
	
	@AfterMethod
	public void tearDownMethod(ITestResult result) throws IOException
	{
		if(result.getStatus()==ITestResult.FAILURE)
		{
			logger.fail("Test Failed", MediaEntityBuilder.createScreenCaptureFromPath(Helper.captureScreenshot(driver)).build());
		}
		else if(result.getStatus()==ITestResult.SUCCESS)
		{
			logger.pass("Test Passed", MediaEntityBuilder.createScreenCaptureFromPath(Helper.captureScreenshot(driver)).build());
		}
		
		report.flush();
	}
	
	
}
