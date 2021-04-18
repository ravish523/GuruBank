package com.GuruBanking.TestCase;

	import java.io.File;
	import java.io.IOException;

	import org.apache.commons.io.FileUtils;
	import org.apache.log4j.Logger;
	import org.apache.log4j.PropertyConfigurator;
	import org.openqa.selenium.OutputType;
	import org.openqa.selenium.TakesScreenshot;
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.chrome.ChromeDriver;
	import org.openqa.selenium.firefox.FirefoxDriver;
	import org.openqa.selenium.ie.InternetExplorerDriver;
	import org.testng.annotations.AfterClass;
	import org.testng.annotations.BeforeClass;
	import org.testng.annotations.Parameters;

import com.GuruBanking.Utilities.ReadConfig;
	
	
	public class BaseClass {
		
		
	ReadConfig readconfig=new ReadConfig();
			public String baseURL=readconfig.getApplicationURL();
		    public String username =readconfig.getusername();
	        public String password=readconfig.getpassword();
		    public static WebDriver driver;
		    public static Logger logger;
		  
		    @Parameters("browser")  
		    @BeforeClass
		    public void setup(String br) throws InterruptedException
		    {
		    	logger=Logger.getLogger("BaseClass");
				PropertyConfigurator.configure("log4j.properties");
				if(br.equals("chrome"))
				{
		    	System.setProperty("webdriver.chrome.driver","C:\\work1\\chromedriver.exe");
				 driver=new ChromeDriver();
				}
				else if(br.equals("firefox"))
				{
					System.setProperty("webdriver.gecko.driver", readconfig.getfirefoxpath());
					driver=new FirefoxDriver();
				}
				else if(br.equals("ie"))
				{
					System.setProperty("webdriver.ie.driver", readconfig.getiepath());
					driver=new InternetExplorerDriver();
				}
				 driver.manage().window().maximize();
				 Thread.sleep(2000);
				 driver.get(baseURL);
				
		    }
		    @AfterClass
		    public void tearDown()
		    {
		    	driver.quit();
		    }
		    
		    public void CaptureScreen(WebDriver driver,String testname) throws IOException
		    {
		    	TakesScreenshot ts=(TakesScreenshot)driver;
		    	File source=ts.getScreenshotAs(OutputType.FILE);
		    	File target=new File(System.getProperty("user.dir")+"/Screenshot/"+testname+".png");
		    	FileUtils.copyFile(source, target);
		    	System.out.println("screenshot is taken");
		    }

	}


