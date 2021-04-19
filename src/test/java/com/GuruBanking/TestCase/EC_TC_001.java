package com.GuruBanking.TestCase;

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
	public void CheckCustomerNameDisable()
	{
		M_EditCustomer_FormPage mefp=new M_EditCustomer_FormPage(driver);
		//mefp.verifyEditCustomerPageAfterEnterId();
		mefp.checkCustomerNmaeIsDisable();
		mefp.DateOfBirthIsDisable();
		mefp.checkGenderIsDisable();
		
	}
	@Test(priority=2)
	public void EditCustomerAdressWithChar() throws InterruptedException
	{
		M_EditCustomer_FormPage mefp=new M_EditCustomer_FormPage(driver);
		mefp.EnterCharToAddressBox("my village is koll");
		mefp.ClickOnSubmit();
		M_EditCustomer_FormConfirmationPage mefcp=new M_EditCustomer_FormConfirmationPage(driver);
		//mefcp.verifyEditCustomerPageConfirmationAfterEditCustomer();
		Thread.sleep(2000);
		mefcp.CheckEnterAddressSameOrNot("my village is koll");
	}

}
