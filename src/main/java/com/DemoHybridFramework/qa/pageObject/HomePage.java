package com.DemoHybridFramework.qa.pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {
	
	//Constructor of HomePage class.
	public HomePage(WebDriver driver) {
		super(driver);
	}

	// WebElements or objects of HomePage class.
	@FindBy(xpath="//span[text()='My Account']")
	private WebElement myAccountDropDown;
	
	@FindBy(linkText="Login")
	private WebElement loginOption;
	
	@FindBy(linkText="Register")
	private WebElement registerOption;
	
	@FindBy(name="search")
	private WebElement searchBoxField;
	
	@FindBy(xpath="//div[@id='search']/descendant::button")
	private WebElement searchButton;

	// methods or actions of HomePage class.
	public void clickOnMyAccount() {
		myAccountDropDown.click();
	}
	
	public void clickOnLoginOption() {
		loginOption.click();
	}
	
	public SearchPage clickOnsearchButton() {
		searchButton.click();
		return new SearchPage(driver);
	}
	
	public LoginPage navigateToLoginPage() {
		myAccountDropDown.click();
		loginOption.click();
		return new LoginPage(driver);
	}
	
	public RegisterPage navigateToRegistrationPage() {
		myAccountDropDown.click();
		registerOption.click();
		return new RegisterPage(driver);
	}
	
	public SearchPage searchForProduct(String ProductText) {
		searchBoxField.clear();
		searchBoxField.sendKeys(ProductText);
		searchButton.click();
		return new SearchPage(driver);
	}
}

