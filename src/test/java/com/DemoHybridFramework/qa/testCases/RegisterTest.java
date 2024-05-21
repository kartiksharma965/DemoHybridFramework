package com.DemoHybridFramework.qa.testCases;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.DemoHybridFramework.qa.baseTest.BaseTest;
import com.DemoHybridFramework.qa.pageObject.AccountSuccessPage;
import com.DemoHybridFramework.qa.pageObject.HomePage;
import com.DemoHybridFramework.qa.pageObject.RegisterPage;

public class RegisterTest extends BaseTest{
	
	WebDriver driver;
	HomePage homePage;
	RegisterPage registerPage;
	AccountSuccessPage accountSuccessPage;
	
	public RegisterTest() {
		super();
	}
	
	@BeforeMethod
	public void setUp() {
		driver=initializeBrowserAndOpenApplicationURL(configProp.getProperty("browserName"));
		homePage = new HomePage(driver);
		registerPage=homePage.navigateToRegistrationPage();
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	
	
	
	
	

}
