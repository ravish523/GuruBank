package com.GuruBanking.PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ManagerPage {
	 public WebDriver driver;
	  
	 @FindBy(xpath="//a[contains(text(),'New Customer')]")
	 private WebElement txtNewCustomer;
	 
	 public ManagerPage(WebDriver d)
	 {
		 driver=d;
		 PageFactory.initElements(d, this);
	 }
	 
	 public void ClickOnNewCustomer()
	 {
		 txtNewCustomer.click();
	 }
	 

}
