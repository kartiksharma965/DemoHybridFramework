package com.DemoHybridFramework.qa.pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends HomePage{
	
	// Constructor of LoginPage class.
	public LoginPage(WebDriver driver) {
		super(driver);
	}
	
	// WebElements or objects of LoginPage class.
	@FindBy(xpath="//input[@type='text' and @name='email' and @id='input-email']")
	private WebElement emailAddressField;
	
	@FindBy(xpath="//input[@type='password' and @name='password' and @id='input-password']")
	private WebElement passwordField;
	
	@FindBy(xpath="//input[@value='Login']")
	private WebElement loginButton;
	
	@FindBy(xpath="//div[contains(@class,'alert-dismissible')]")
	private WebElement emailPasswordNotMaching;
	
	// methods or actions of LoginPage class.
	public void enterEmailAddress(String emailText) {
		emailAddressField.clear();
		emailAddressField.sendKeys(emailText);
	}
	
	public void enterPasswordField(String passwordText) {
		passwordField.clear();
		passwordField.sendKeys(passwordText);
	}
	
	public String retriveEmailPasswordNotMatchingWarningMessageText() {
		String warningText=emailPasswordNotMaching.getText();
		return warningText;
	}
	
	public AccountPage clickOnLoginButton() {
		loginButton.click();
		return new AccountPage(driver);
	}
	
	public AccountPage login(String emailText, String passwordText) {
		enterEmailAddress(emailText);
		enterPasswordField(passwordText);
		loginButton.click();
		return new AccountPage(driver);
	}
}
