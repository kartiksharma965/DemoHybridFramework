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
import com.DemoHybridFramework.qa.utils.DataUtil;


public class LoginTest_DDT2a extends BaseTest {

	// global variable of LoginTest_DDT
	public WebDriver driver;
	HomePage homePage;
	LoginPage loginPage;
	AccountPage accountPage;

	//Constructor of LoginTest_DDT class.
	public LoginTest_DDT2a() {
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

	@Test(priority=0, dataProviderClass = DataUtil.class, dataProvider="dp" )
	public void Login_valid_invalid_DDT(String email, String password,String exp) {
		logger.info("**** Starting TC_003_LoginDDT *****");
		try {
		password =password.replace(".0", "");
		accountPage=loginPage.login(email, password);
		// After valid user login "My Account" heading is displayed
		boolean targetPage=accountPage.getDisplayStatusOfaccountHeadingAfterValidLogin();
		
		if(exp.equalsIgnoreCase("valid"))
		{
			if (targetPage==true)
			{
				accountPage.clickOnLogout();
				Assert.assertTrue(true);
			} else {
				Assert.assertTrue(false);
			}
		}
		
		if(exp.equalsIgnoreCase("invalid"))
		{
			{
				if(targetPage==true)
				{
					accountPage.clickOnLogout();
					Assert.assertTrue(false);
				}
				else
				{
					Assert.assertTrue(true);
				}
			}
		}
		}
		catch(Exception e)
		{
			Assert.fail("An exception occurred: " + e.getMessage());
		}
			
		logger.info("**** Finished TC_003_LoginDDT *****");
	}
	
}


	
	

