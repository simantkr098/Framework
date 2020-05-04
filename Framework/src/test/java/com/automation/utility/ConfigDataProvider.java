package com.automation.utility;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ConfigDataProvider {

	static Properties prop;
	
	public ConfigDataProvider()
	{
		File src = new File("./Config/config.properties");
		try 
		{
			FileInputStream fis = new FileInputStream(src);
			prop = new Properties();
			prop.load(fis);
		
		} catch (Exception e)
		{
			System.out.println("Not able to load Configuration file >> "+e.getMessage());
		}
	}
	
	public String getDataFromConfig(String key)
	{
		return prop.getProperty(key);
	}
	
}
