package com.GuruBanking.TestCase;

import java.io.IOException;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.GuruBanking.PageObject.LoginPage;
import com.GuruBanking.PageObject.M_EditCustomerPage;
import com.GuruBanking.PageObject.M_EditCustomer_FormConfirmationPage;
import com.GuruBanking.PageObject.M_EditCustomer_FormPage;
import com.GuruBanking.PageObject.ManagerPage;

public class EC_TC_001 extends BaseClass {
	
	@BeforeMethod
	public void Precondition ()
	{
		LoginPage lp= new LoginPage(driver);
		lp.setuser(username);
		lp.setpass(password);
		lp.clicklogin();
		ManagerPage mp=new ManagerPage(driver);
		mp.ClickOnEditCustomer();
		M_EditCustomerPage mecp=new M_EditCustomerPage(driver);
		mecp.EnterCustomerId(customerid);
		mecp.ClickOnSubmitAfterEnterId();
		
	}
	@Test(priority=1)
	public void CheckCustomerNameDisable() throws InterruptedException
	{
		Thread.sleep(2000);
		M_EditCustomer_FormPage mefp=new M_EditCustomer_FormPage(driver);
		mefp.verifyEditCustomerPageAfterEnterId();
		mefp.checkCustomerNmaeIsDisable();
		mefp.DateOfBirthIsDisable();
		mefp.checkGenderIsDisable();
		
	}
	@Test(priority=2)
	public void EditCustomerAdressWithChar() throws InterruptedException
	{
		String add=RandomStringUtils.randomAlphabetic(10);
		M_EditCustomer_FormPage mefp=new M_EditCustomer_FormPage(driver);
		mefp.EnterCharToAddressBox(add);
		mefp.ClickOnSubmit();
		M_EditCustomer_FormConfirmationPage mefcp=new M_EditCustomer_FormConfirmationPage(driver);
		mefcp.verifyEditCustomerPageConfirmationAfterEditCustomer();
		Thread.sleep(2000);
		mefcp.CheckEnterAddressSameOrNot(add);
	}
	@Test(priority=3)
	public void EditCustomerAdressWithInvaliedData() throws InterruptedException, IOException
	{
		String add=RandomStringUtils.randomAlphabetic(10);
		M_EditCustomer_FormPage mefp=new M_EditCustomer_FormPage(driver);
		mefp.EnterCharToAddressBox(add+"@#%");
		Thread.sleep(2000);
		//mefp.BorderAroundAddressErrorMsg(driver);
		Thread.sleep(2000);
		mefp.ClickOnSubmit();
		Thread.sleep(2000);
		mefp.verifyAfterEnter_InvaliedDataInAdress();
	}

}
