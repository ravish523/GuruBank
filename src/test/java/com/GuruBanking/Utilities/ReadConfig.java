package com.GuruBanking.Utilities;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ReadConfig {
	
Properties prop;
	
	public ReadConfig()
	{
		File src= new File("./Configurations/config.properties");
		
		try
		{
			FileInputStream fis=new FileInputStream(src);
			prop=new Properties();
			prop.load(fis);
		}
		catch(Exception e)
		{
			System.out.println("Exception is "+e.getMessage());
		}
	}
	public String getApplicationURL()
	{
		String url=prop.getProperty("baseURL");
		return url;
	}
	public String getusername()
	{
		String username=prop.getProperty("username");
		return username;
	}
	public String getpassword()
	{
		String password=prop.getProperty("password");
		return password;
	}
	public String getchromepath()
	{
		String chromepath=prop.getProperty("chromepath");
		return chromepath;
	}
	public String getfirefoxpath()
	{
		String firefoxpath=prop.getProperty("firefoxpath");
		return firefoxpath;
	}
	public String getiepath()
	{
		String iepath=prop.getProperty("iepath");
		return iepath;
	}
}

