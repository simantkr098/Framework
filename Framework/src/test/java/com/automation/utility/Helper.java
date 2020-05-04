package com.automation.utility;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.poi.openxml4j.opc.internal.FileHelper;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class Helper {

	
	public static String captureScreenshot(WebDriver driver)
	{
		String screenshotPath=System.getProperty("user.dir")+"/Screenshots/screenshotAt_"+getCurrentDate()+".png";
		
		File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		
		try
		{
			FileHelper.copyFile(src, new File(screenshotPath));
		}
		catch (Exception e)
		{
			System.out.println("Unable to Capture Screenshot : "+ e.getMessage());
		}
		
		return screenshotPath;
	}
	
	
	public static String getCurrentDate()
	{
		SimpleDateFormat customFormat = new SimpleDateFormat("MM_dd_yyyy_HH_mm_ss");
		
		Date currentDate = new Date();
		
		return customFormat.format(currentDate);
				
	}
	
	
	
}
