package com.DemoHybridFramework.qa.pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AccountSuccessPage extends BasePage{
	
	// Constructor of AccountSuccessPage class.
	public AccountSuccessPage(WebDriver driver) {
		super(driver);
	}
	
	// WebElements or Objects of AccountSuccessPage class.
	@FindBy(xpath="//div[@id='content']/h1")
	WebElement AccountSuccessPageHeading;
	
	// methods and actions of Account SuccessPage class.
	public String retriveAccountSuccessPageHeading() {
		
	String AccountSuccessPageText=AccountSuccessPageHeading.getText();
	return AccountSuccessPageText;
	}
}
