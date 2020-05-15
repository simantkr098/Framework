package com.automation.utility;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.poi.openxml4j.opc.internal.FileHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Helper {

	
	public static String captureScreenshot(WebDriver driver)
	{
//		String screenshotPath=System.getProperty("user.dir")+"\\Screenshots\\screenshotAt_"+getCurrentDate()+".png";
		
		String screenshotPath="screenshotAt_"+getCurrentDate()+".png";
		
		File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		
		try
		{
			FileHelper.copyFile(src, new File("./Reports/screenshots/"+screenshotPath));
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
	
	public static void HighlightWebElement(WebDriver driver, WebElement ele)
	{
		JavascriptExecutor js = (JavascriptExecutor)driver;
		try {

//			js.executeScript("arguments[0].scrollIntoView(true));", ele);

/*			https://developer.mozilla.org/en-US/docs/Web/API/Element/scrollIntoView  */
			js.executeScript("arguments[0].scrollIntoView({ behavior: 'smooth', block: 'center', inline: 'start' });", ele);
			
//			js.executeScript("window.scroll({top: arguments[0].offsetTop, behavior: 'smooth'});", ele);
		
			
			Thread.sleep(2000);
								
			for(int i=0;i<5;i++)
			{
				js.executeScript("arguments[0].setAttribute('style','border: solid 2px red');", ele);
				Thread.sleep(250);
				js.executeScript("arguments[0].setAttribute('style','border: 0px');", ele);
				Thread.sleep(250);
			} 
			
		} catch (Exception e) {
			
			System.out.println(e.getMessage());
		}
		
		
	}
	
	
}
