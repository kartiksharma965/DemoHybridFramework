package com.DemoHybridFramework.qa.pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AccountPage extends BasePage {
	
	// Constructor of AccountPage class.
	public AccountPage(WebDriver driver) {
		super(driver);
	}
	
	// WebElements or Objects of AccountPage class.
	@FindBy(linkText="Edit your account information")
	private WebElement editYourAccountInformatioOption;
	
	@FindBy(xpath="//h2[text()='My Account']")
	private WebElement myAccountMsgHeading; // MyAccount Page heading after valid user login successfully.
	
	@FindBy(xpath = "//div[@class='list-group']//a[text()='Logout']")
	private WebElement lnkLogout;

	
	// methods or actions of AccountPage class.
	public void clickOnLogout() {
		lnkLogout.click();
	}
	
	public boolean getDisplayStatusOfeditYourAccountInformationOption() {
		
		boolean displayStatus = editYourAccountInformatioOption.isDisplayed();
		return displayStatus;
	}

	public boolean getDisplayStatusOfaccountHeadingAfterValidLogin() {
		boolean displayStaus=myAccountMsgHeading.isDisplayed();
		return displayStaus;
	}
}
