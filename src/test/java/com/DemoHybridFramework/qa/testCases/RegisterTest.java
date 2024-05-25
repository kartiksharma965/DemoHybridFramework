package com.DemoHybridFramework.qa.testCases;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.DemoHybridFramework.qa.baseTest.BaseTest;
import com.DemoHybridFramework.qa.pageObject.AccountSuccessPage;
import com.DemoHybridFramework.qa.pageObject.HomePage;
import com.DemoHybridFramework.qa.pageObject.RegisterPage;
import com.DemoHybridFramework.qa.utils.Utilities;

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
	
	
	@Test(priority=0)
	public void verifyRegisteringAccountWithMandatoryFields() {
		accountSuccessPage=registerPage.registerWithMandatoryFields(testDataProp.getProperty("firstName"), testDataProp.getProperty("lastName"), Utilities.generateEmailWithTimeStamp(), testDataProp.getProperty("telephoneNumber"), configProp.getProperty("validPassword"));
		Assert.assertEquals(accountSuccessPage.retriveAccountSuccessPageHeading(), testDataProp.getProperty("accountSuccessfullyCreatedHeading"), "Account success page is not displayed");
	}
	
	@Test(priority=1)
	public void verifyRegisterAccountByProvidingAllFields() {
		accountSuccessPage=registerPage.registerWithAllFields(testDataProp.getProperty("firstName"),testDataProp.getProperty("lastName"), Utilities.generateEmailWithTimeStamp(), testDataProp.getProperty("telephoneNumber"), configProp.getProperty("validPassword"));
		Assert.assertEquals(accountSuccessPage.retriveAccountSuccessPageHeading(), testDataProp.getProperty("accountSuccessfullyCreatedHeading"), "Account Success page is not displayed");	
	}
	
	@Test(priority=2)
	public void VerifyRegisteringAccountWithExistingEamilAddress() {
		registerPage.registerWithAllFields(testDataProp.getProperty("firstName"), testDataProp.getProperty("lastName"), configProp.getProperty("validEmail"), testDataProp.getProperty("telephoneNumber"), configProp.getProperty("validPassword"));
		Assert.assertEquals(registerPage.retrieveDuplicateEmailAddressWarning().contains(testDataProp.getProperty("duplicateEmailWarning")), "Warning message regarding duplicate email address is not getting displayed");
	}
	
	@Test(priority=3)
	public void VerifyRegisteringAccountWithoutFillingAnydetails() {
		registerPage.clickOnContinueButton();
		Assert.assertTrue(registerPage.displayStatusOfWarningMessages(testDataProp.getProperty("privacyPolicyWarning"), testDataProp.getProperty("firstNameWarning"), testDataProp.getProperty("lastNameWarning"), testDataProp.getProperty("emailWarning"), testDataProp.getProperty("telephoneWarning"), testDataProp.getProperty("passwordWarning")));
	}
	

}
