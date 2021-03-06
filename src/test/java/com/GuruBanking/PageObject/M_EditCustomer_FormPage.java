package com.GuruBanking.PageObject;

import java.io.IOException;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.GuruBanking.TestCase.BaseClass;

public class M_EditCustomer_FormPage extends BaseClass {
	public  WebDriver driver;
	
	@FindBy(xpath="//tbody/tr[4]/td[2]/input[1]")
	private WebElement txteditCustomerName;
	@FindBy(xpath="//tbody/tr[5]/td[2]/input[1]")
	private WebElement txtGender;
	@FindBy(xpath="//tbody/tr[6]/td[2]/input[1]")
	private WebElement txtdob;
	@FindBy(xpath="//tbody/tr[7]/td[2]/textarea[1]")
	private WebElement txtAddress;
	@FindBy(xpath="//tbody/tr[7]/td[1]")
	private WebElement txtAdressError;
	
	@FindBy(xpath="//tbody/tr[13]/td[2]/input[1]")
	private WebElement txtSubmit;
	
	public M_EditCustomer_FormPage(WebDriver d)
	{
		driver=d;
		PageFactory.initElements(d, this);
	}
	public void verifyEditCustomerPageAfterEnterId()
	{
		try{
			if(driver.getTitle().contains("Guru99 Bank Edit Customer Entry Page"))
			{
				
				logger.info(" Guru99 Bank Edit Customer Entry form Page Dispaly----Pass");
				Assert.assertTrue(true);
			}
			else
			{
				Thread.sleep(2000);
				CaptureScreen(driver,"verifyEditCustomerPageAfterEnterId");
				Thread.sleep(2000);
				logger.info(" Guru99 Bank Edit Customer Entry Page not display----Fail");
				Assert.assertTrue(false);
			}
		}
		catch(Exception e)
		{
			System.out.println("Exception message="+e.getMessage());
		}	
	}
	public void checkCustomerNmaeIsDisable()
	{
		try{
			if(txteditCustomerName.isEnabled()==false)
			{
				logger.info("CustomerNmae Is Disable----Pass");
				Assert.assertTrue(true);
			}
			else
			{
				CaptureScreen(driver,"checkCustomerNmaeIsDisable");
				Thread.sleep(2000);
				logger.info(" CustomerNmae Is Enable----Fail");
				Assert.assertTrue(false);
			}
		}
		catch(Exception e)
		{
			System.out.println("Exception message="+e.getMessage());
		}
	}
	public void checkGenderIsDisable()
	{
		try{
			if(txtGender.isEnabled()==false)
			{
				logger.info("Gender Is Disable----Pass");
				Assert.assertTrue(true);
			}
			else
			{
				CaptureScreen(driver,"checkGenderIsDisable");
				Thread.sleep(2000);
				logger.info(" Gender Is Enable----Fail");
				Assert.assertTrue(false);
			}
		}
		catch(Exception e)
		{
			System.out.println("Exception message="+e.getMessage());
		}
	}
	public void DateOfBirthIsDisable()
	{
		try{
			if(txtdob.isEnabled()==false)
			{
				logger.info("Date of birth Is Disable----Pass");
				Assert.assertTrue(true);
			}
			else
			{
				CaptureScreen(driver,"DateOfBirthIsDisable");
				Thread.sleep(2000);
				logger.info(" Date of birth Is Enable----Fail");
				Assert.assertTrue(false);
			}
		}
		catch(Exception e)
		{
			System.out.println("Exception message="+e.getMessage());
		}
	}
	public void EnterCharToAddressBox(String address)
	{
		txtAddress.clear();
		txtAddress.sendKeys(address);
	}
	public void EnterIntegerToAddress(int address)
	{
		txtAddress.clear();
		txtAddress.sendKeys(String.valueOf(address));
	}
	
	public void verifyAfterEnter_InvaliedDataInAdress() throws IOException, InterruptedException
	{
		try{
			if(driver.getTitle().contains("Guru99 Bank Customer Registration Page")==false)
			{
				
				logger.info( "Customer details is not updated with invalied data----Pass");
				Assert.assertTrue(true);
			}
			else
			{
				Thread.sleep(2000);
				CaptureScreen(driver,"EditCustomerAdressWithInvaliedData");
				Thread.sleep(2000);
				logger.info("Customer details is  updated with invalied data----Faile");
				Assert.assertTrue(false);
			}
		}
		catch(Exception e)
		{
			System.out.println("Exception message="+e.getMessage());
		}
	}
	public void BorderAroundAddressErrorMsg(WebDriver driver)
	{
		JavascriptExecutor js=((JavascriptExecutor)driver);
		js.executeScript("argument[0].style.border='3px solid red'", txtAdressError);
	}
	public void ClickOnSubmit()
	{
		txtSubmit.click();
	}

}
