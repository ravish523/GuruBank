package com.GuruBanking.PageObject;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.GuruBanking.TestCase.BaseClass;

public class LoginPage extends BaseClass {
	
	
	public WebDriver driver;
	 
	 @FindBy(name="uid")
	  private WebElement uname;
	 @FindBy(name="password")
	 private WebElement pass;
	 @FindBy(name="btnLogin")
	 private WebElement submit;
	 
	 public LoginPage(WebDriver d)
	 {
		 driver=d;
		 PageFactory.initElements(d, this);
		 
	 }
	 public void setuser(String name)
	 {
		 uname.sendKeys(name);
	 }
	 public void setpass(String passwd)
	 {
		 pass.sendKeys(passwd);
	 }
	 public void clicklogin()
	 {
		 submit.click();
	 }
	 public void verifyLoginWithInvaliedData() throws IOException, InterruptedException
	 {
		 String alertText=driver.switchTo().alert().getText();
		 if(alertText.equals("User is valid")==true)
		 { 
			 logger.info("test pass..");
			 Assert.assertTrue(true);
		 }
		 else
		 {
			 Thread.sleep(2000);
			 logger.info("accepting the alert..");
			 CaptureScreen(driver,"verifyLoginWithInvaliedData");
			 Assert.assertTrue(false);
		 }
	 }

}
