package com.DemoHybridFramework.qa.testCases;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.DemoHybridFramework.qa.baseTest.BaseTest;
import com.DemoHybridFramework.qa.pageObject.AccountPage;
import com.DemoHybridFramework.qa.pageObject.HomePage;
import com.DemoHybridFramework.qa.pageObject.LoginPage;
import com.DemoHybridFramework.qa.utils.Utilities;

public class LoginTest extends BaseTest{

	// global variable of LoginTest class.
	public WebDriver driver;
	HomePage homePage;
	LoginPage loginPage;
	AccountPage accountPage;

	// constructor of LoginTest class.
	public LoginTest() {
		super();
	}

	@BeforeMethod
	public void setUp() {
		driver= initializeBrowserAndOpenApplicationURL(configProp.getProperty("browser"));
		homePage = new HomePage(driver);
		loginPage=homePage.navigateToLoginPage();
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

	@Test(priority=0)
	public void verifyLoginWithValidCredentials() {
		logger.info("**** starting TC_001_LoginWithValidCredentials  *****");
		// we are fetching valid email and password from config.properties file.
		accountPage=loginPage.login(configProp.getProperty("validEmail"), configProp.getProperty("validPassword"));
		Assert.assertTrue(accountPage.getDisplayStatusOfeditYourAccountInformationOption(), "Testcase fails as ==Edit Your Account Information option is not displayed");
		logger.info("**** finishing TC_001_LoginWithValidCredentials  *****");	
	}

	@Test(priority=1)
	public void verifyLoginWithInValidCredentials() {
		logger.info("**** starting TC_002_LoginWithInValidCredentials  *****");
		// we are fetching inValid email(any random email) and invalid password from testData.
		loginPage.login(Utilities.generateEmailWithTimeStamp(), testDataProp.getProperty("invalidPassword"));
		Assert.assertTrue(loginPage.retriveEmailPasswordNotMatchingWarningMessageText().contains(testDataProp.getProperty("emailPasswordNoMatchWarning")),"Testcase fails as ==Expected Warning message is not displayed");	
		logger.info("**** finishing TC_002_LoginWithInValidCredentials  *****");
	}

	@Test(priority=2)
	public void verifyLoginWithInValidEmailAndValidPassword() {
		logger.info("**** starting TC_003_LoginWithInValidEmailAndValidPasswordls  *****");
		// we are fetching invalid email(any random email) and valid password from config.properties.file
		loginPage.login(Utilities.generateEmailWithTimeStamp(), configProp.getProperty("validPassword"));
		// In case we provide wrong argument from config.ptoprty ("validPass") then as result at runtime get below error
		// java.lang.IllegalArgumentException:
		Assert.assertTrue(loginPage.retriveEmailPasswordNotMatchingWarningMessageText().contains(testDataProp.getProperty("emailPasswordNoMatchWarning")),"Testcase fails as ==Expected Warning message is not displayed");
		logger.info("**** finishing TC_003_LoginWithInValidEmailAndValidPasswordls  *****");
	}

	@Test(priority=3)
	public void verifyLoginWithValidEmailAndValidPassword() {
		logger.info("**** starting TC_004_LoginWithValidEmailAndValidPassword  *****");
		// we are fetching valid email(config.properties) and invalid password from testData.
		loginPage.login(configProp.getProperty("validEmail"), testDataProp.getProperty("invalidPassword"));
		Assert.assertTrue(loginPage.retriveEmailPasswordNotMatchingWarningMessageText().contains(testDataProp.getProperty("emailPasswordNoMatchWarning")),"Testcase fails as ==Expected Warning message is not displayed");
		logger.info("**** finishing TC_004_LoginWithValidEmailAndValidPassword  *****");
	}

	@Test(priority=4)
	public void verifyLogWithoutProvidingCredentials() {
		logger.info("**** starting TC_005_LoginWithWithoutProvidingCredentials  *****");
		loginPage.clickOnLoginButton();
		Assert.assertTrue(loginPage.retriveEmailPasswordNotMatchingWarningMessageText().contains(testDataProp.getProperty("emailPasswordNoMatchWarning")), "Testcase fails as ==Expected Warning message is not displayed");
		logger.info("**** finishing TC_005_LoginWithWithoutProvidingCredentials  *****");
	}
}
