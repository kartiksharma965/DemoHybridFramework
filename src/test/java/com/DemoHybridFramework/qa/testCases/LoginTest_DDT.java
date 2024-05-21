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


public class LoginTest_DDT extends BaseTest {

	// global variable of LoginTest_DDT class.
	public WebDriver driver;
	HomePage homePage;
	LoginPage loginPage;
	AccountPage accountPage;

	//Constructor of LoginTest_DDT class.
	public LoginTest_DDT() {
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

	@Test(priority=0, enabled=true, dataProviderClass = DataUtil.class, dataProvider="dp")
	public void Login_valid_DDT(String email ,String password) {
		password =password.replace(".0", "");
		//UserID = UserID.replace(".0", "");
		accountPage=loginPage.login(email, password);
		Assert.assertTrue(accountPage.getDisplayStatusOfeditYourAccountInformationOption(), "Testcase fail ==Edit Your Account Information option is not displayed");
	}


	
}
		/*
		 * @Test(priority=0, dataProviderClass = DataUtil.class,dataProvider="dp")
	public void Login_valid_DDT(String email ,String Password) {
	    Problem scenario
		Password value = 123456. But at runtime value becomes = 123456.0. Hence all testcase were failing
		solution
		Password =Password.replace(".0", "");
		System.out.println(Password);
		output = 123456 now
		 ******** below code *******************
		Password =Password.replace(".0", "");
		System.out.println(Password);
		System.out.println(email);
	} */
	

