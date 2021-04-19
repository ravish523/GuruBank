package com.GuruBanking.PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.GuruBanking.TestCase.BaseClass;

public class M_EditCustomerPage extends BaseClass {
	
	public  WebDriver driver;
	
	@FindBy(xpath="//tbody/tr[6]/td[2]/input[1]")
	private WebElement txtCustomerId;
	@FindBy(xpath="//tbody/tr[11]/td[2]/input[1]")
	private WebElement txtSubmit;
	@FindBy(xpath="//tbody/tr[11]/td[2]/input[2]")
	private WebElement txtreset;
	//----------------------------------------------------------------------------
	public M_EditCustomerPage(WebDriver d)
	{
		driver=d;
		PageFactory.initElements(d, this);
	}
	//--------------------------------------------
	public void EnterCustomerId(int id)
	{
		txtCustomerId.sendKeys(String.valueOf(id));
	}
	public void ClickOnSubmitAfterEnterId()
	{
		txtSubmit.click();
	}
	public void ClickOnResetAfterEnterId()
	{
		txtreset.click();
	}
	public void verifyForDeletedOrWrongId()
	{
		try{
			if(driver.switchTo().alert().getText().contains("Customer does not exist!!"))
			{
				
				logger.info("Customer does not exist!!----Pass");
				Assert.assertTrue(true);
			}
			else
			{
				CaptureScreen(driver,"verifyForDeletedOrWrongId");
				Thread.sleep(2000);
				logger.info("Customer exist!!----Faile");
				Assert.assertTrue(false);
			}
			
			
		}
		catch(Exception e)
		{
			System.out.println("Exception message="+e.getMessage());
		}
	}
	
	public void AcceptAlert()
	{
		try{
			driver.switchTo().alert().accept();
		}
		catch(Exception e)
		{
			System.out.println("Exception message="+e.getMessage());
		}	
	}

}
