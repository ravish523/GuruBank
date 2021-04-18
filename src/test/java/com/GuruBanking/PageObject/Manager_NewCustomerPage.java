package com.GuruBanking.PageObject;

import java.io.IOException;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.GuruBanking.TestCase.BaseClass;

public class Manager_NewCustomerPage extends BaseClass {
	
	public WebDriver driver;
	
	@FindBy(xpath="//tbody/tr[7]/td[2]/textarea[1]")
	private WebElement txtAddress;
	@FindBy(xpath="//label[@id='message3']")
	private WebElement txtAddressErrorMsg;
	
	public Manager_NewCustomerPage(WebDriver d)
	{
		driver=d;
		PageFactory.initElements(d, this);
	}
	
	public void EnterChar(String fchar)
	{
		txtAddress.sendKeys(fchar);
	}
	public void EnterChar(int fchar)
	{
		txtAddress.sendKeys(String.valueOf(fchar));
	}
	public void setEmptyAddressBox()
	{
		logger.info("set the empty address box..");
		txtAddress.sendKeys(Keys.TAB);
	}
	public void VerifyCharAndNumberInAddresstxt() throws IOException, InterruptedException
	{
		try{
			logger.info("try block is executing...");
		if(txtAddressErrorMsg.getText().contains(""))
		{
		     logger.info("Address text box is Accepting the integer or charcters...Pass");
		     Assert.assertTrue(true);
		}
		else
		{
			logger.info("Address text box is not Accepting the integer or charcters...Fail");
			Thread.sleep(2000);
			CaptureScreen(driver,"VerifyCharAndNumberInAddresstxt");
			Assert.assertTrue(false);
		}
		}
		catch(Exception e)
		{
			logger.info("Catching the exception..");
			System.out.println("exception msg :"+e.getMessage());
		}
	}
	public void VerifySpecialCharInAddresstxt() throws IOException, InterruptedException
	{
		try{
			logger.info("try block is executing...");
		if(txtAddressErrorMsg.getText().contains("Special characters are not allowed"))
		{
		     logger.info("Address text box is not Accepting special charcters...pass");
		     Assert.assertTrue(true);
		}
		else
		{
			logger.info("Address text box is  Accepting the special charcters...Fail");
			Thread.sleep(2000);
			CaptureScreen(driver,"VerifySpecialCharInAddresstxt");
			Assert.assertTrue(false);
		}
		}
		catch(Exception e)
		{
			logger.info("Catching the exception..");
			System.out.println("exception msg :"+e.getMessage());
		}
	}
	public void VerifyEmptyInAddresstxt() throws IOException, InterruptedException
	{ 
		try{
			logger.info("try block is executing...");
		if(txtAddressErrorMsg.getText().contains("Address Field must not be blank"))
		{
		     logger.info("Address Field must not be blank...Pass");
		     Assert.assertTrue(true);
		}
		else
		{
			logger.info("Address text box is  Accepting empty...fail");
			Thread.sleep(2000);
			CaptureScreen(driver,"VerifyEmptyInAddresstxt");
			Assert.assertTrue(false);
		}
		}
		catch(Exception e)
		{
			logger.info("Catching the exception..");
			System.out.println("exception msg :"+e.getMessage());
		}
	}
	
	
	public void VerifyFirstSpaceCharInAddresstxt() throws IOException, InterruptedException
	{
		try{
			logger.info("try block is executing...");
		if(txtAddressErrorMsg.getText().contains("First character can not have space"))
		{
		     logger.info("First character can not have space...Pass");
		     Assert.assertTrue(true);
		}
		else
		{
			logger.info("Address text box is  Accepting first space char...fail");
			Thread.sleep(2000);
			CaptureScreen(driver,"VerifyFirstSpaceCharInAddresstxt");
			Thread.sleep(2000);
			Assert.assertTrue(false);
		}
		}
		catch(Exception e)
		{
			logger.info("Catching the exception..");
			System.out.println("exception msg :"+e.getMessage());
		}
	}
	
	

}
