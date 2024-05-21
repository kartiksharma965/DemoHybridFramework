package com.DemoHybridFramework.qa.pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SearchPage extends BasePage {
	
	//Constructor of SearchPage class.
	public SearchPage(WebDriver driver) {
		super(driver);
	}
	
	//WebElement or objects of SearchPage class.
	@FindBy(linkText="HP LP3065")
	private WebElement validHProduct;
	
	@FindBy(xpath="//div[@id='content']/h2/following-sibling::p")
	private WebElement noProductMessage;
	
	// methods or actions of SearchPage class.
	public boolean displayStatusOfHPvalidProduct() {
		boolean displayStatus=validHProduct.isDisplayed();
		return displayStatus;
	}
	
	public String retriveNoProductMessageText() {
		String noProductMessageText=noProductMessage.getText();
		return noProductMessageText;
	}
}
