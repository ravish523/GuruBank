package com.GuruBanking.TestCase;

import java.io.IOException;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.GuruBanking.PageObject.LoginPage;
import com.GuruBanking.PageObject.ManagerPage;
import com.GuruBanking.PageObject.Manager_NewCustomerPage;

public class M_NC_004 extends BaseClass {
	
	@BeforeMethod
	public void OpenNewCustomer()
	{  
		logger.info("Open the website..");
		LoginPage lp=new LoginPage(driver);
		logger.info("enter the userid..");
		lp.setuser("mngr318995");
		logger.info("enter the pass..");
		lp.setpass("unujYsA");
		logger.info("click on login..");
		lp.clicklogin();
		logger.info("Manager page open..");
		ManagerPage mp=new ManagerPage(driver);
		logger.info("Clicked on New Customer..");
		mp.ClickOnNewCustomer();
	}
	@Test(priority=1)
	public void EnterChar() throws IOException, InterruptedException
	{
		logger.info("Customer form open..");
		Manager_NewCustomerPage mnc=new Manager_NewCustomerPage(driver);
		logger.info("Enter char in Address box..");
		mnc.EnterChar("ankodha");
		Thread.sleep(2000);
		logger.info("verify error..");
		mnc.VerifyCharAndNumberInAddresstxt();
		Thread.sleep(2000);
	}
	@Test (priority=2)
	public void EnterInteger() throws InterruptedException, IOException
	{
		logger.info("Customer form open..");
		Manager_NewCustomerPage mnc=new Manager_NewCustomerPage(driver);
		logger.info("Enter integer in Address box..");
		mnc.EnterChar(1283);
		Thread.sleep(2000);
		logger.info("verify error..");
		mnc.VerifyCharAndNumberInAddresstxt();
		Thread.sleep(2000);
	}
	@Test (priority=3)
	public void EnterSpecialChar() throws InterruptedException, IOException
	{
		logger.info("Customer form open..");
		Manager_NewCustomerPage mnc=new Manager_NewCustomerPage(driver);
		logger.info("Enter special char in Address box..");
		mnc.EnterChar("#&@#");
		Thread.sleep(2000);
		logger.info("verify error..");
		mnc.VerifySpecialCharInAddresstxt();
		Thread.sleep(2000);
	}
	@Test (priority=4)
	public void EnterFirstSpaceChar() throws InterruptedException, IOException
	{
		logger.info("Customer form open..");
		Manager_NewCustomerPage mnc=new Manager_NewCustomerPage(driver);
		logger.info("Enter first space char in Address box..");
		mnc.EnterChar("   ravis");
		Thread.sleep(2000);
		logger.info("verify error..");
		mnc.VerifyFirstSpaceCharInAddresstxt();
		Thread.sleep(2000);
	}
	@Test (priority=5)
	public void EnterEmptyAddress() throws InterruptedException, IOException
	{
		logger.info("Customer form open..");
		Manager_NewCustomerPage mnc=new Manager_NewCustomerPage(driver);
		logger.info("Enter empty in Address box..");
		mnc.setEmptyAddressBox();
		Thread.sleep(2000);
		logger.info("verify error..");
		mnc.VerifyEmptyInAddresstxt();
		Thread.sleep(2000);
	}

}
