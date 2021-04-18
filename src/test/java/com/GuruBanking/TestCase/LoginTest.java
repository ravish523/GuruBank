package com.GuruBanking.TestCase;

import java.io.IOException;

import org.testng.annotations.Test;

import com.GuruBanking.PageObject.LoginPage;

public class LoginTest extends BaseClass {
	
	@Test
	public void TestLogin() throws IOException, InterruptedException
	{
		LoginPage lp=new LoginPage(driver);
		logger.info("entering user id");
		lp.setuser("mngr31895");
		logger.info("entering pass");
		lp.setpass("unujYA");
		logger.info("click on login button");
		lp.clicklogin();
		logger.info("verify login details...");
		lp.verifyLoginWithInvaliedData();
		logger.info("wait for 2 sec");
		Thread.sleep(2000);
	}

}
