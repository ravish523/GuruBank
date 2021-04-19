package com.GuruBanking.PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.GuruBanking.TestCase.BaseClass;

public class M_EditCustomer_FormConfirmationPage extends BaseClass {
	
	public WebDriver driver;
	
	@FindBy(xpath="//tbody/tr[8]/td[2]")
	private WebElement getadress;
	
	public M_EditCustomer_FormConfirmationPage(WebDriver d)
	{
		driver=d;
		PageFactory.initElements(d, this);
	}
	
	public void verifyEditCustomerPageConfirmationAfterEditCustomer()
	{
		try{
			if(driver.getTitle().contains(" Guru99 Bank Customer Registration Page "))
			{
				
				logger.info( "Customer details updated Successfully!!!----Pass");
				Assert.assertTrue(true);
			}
			else
			{
				Thread.sleep(2000);
				CaptureScreen(driver,"verifyForDeletedOrWrongId");
				Thread.sleep(2000);
				logger.info(" Customer details not updated Successfully!!!----Faile");
				Assert.assertTrue(false);
			}
		}
		catch(Exception e)
		{
			System.out.println("Exception message="+e.getMessage());
		}	
	}
	public void CheckEnterAddressSameOrNot(String address)
	{
		try{
			if(getadress.getText().equals(address))
			{
				
				logger.info( "Customer details adress updated Successfully!!!----Pass");
				Assert.assertTrue(true);
			}
			else
			{
				CaptureScreen(driver,"CheckEnterAddressSameOrNot");
				Thread.sleep(2000);
				logger.info(" Customer address details not updated Successfully!!!----Faile");
				Assert.assertTrue(false);
			}
		}
		catch(Exception e)
		{
			System.out.println("Exception message="+e.getMessage());
		}
	}

}
