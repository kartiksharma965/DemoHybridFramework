package com.DemoHybridFramework.qa.testCases;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.DemoHybridFramework.qa.baseTest.BaseTest;
import com.DemoHybridFramework.qa.pageObject.HomePage;
import com.DemoHybridFramework.qa.pageObject.SearchPage;

public class SearchTest extends BaseTest {

	// global variable of SearchTest class.
	public WebDriver driver;
	HomePage homePage;
	SearchPage searchPage;

	// constructor of SearchTest class.
	public SearchTest() {
		super();
	}
	
	@BeforeMethod
	public void setUp() {
	driver=initializeBrowserAndOpenApplicationURL(configProp.getProperty("browser"));
	homePage = new HomePage(driver);
	}
	
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

	@Test(priority=0)
	public void verifySearchWithValidProduct() {
	
	searchPage=homePage.searchForProduct(testDataProp.getProperty("validProduct"));
	Assert.assertTrue(searchPage.displayStatusOfHPvalidProduct(),"Valid product HP is not displayed in the search results");
	}
	
	@Test(priority=1)
	public void verifySearchWithInValidProduct() {
	searchPage=homePage.searchForProduct(testDataProp.getProperty("invalidProduct"));
	Assert.assertEquals(searchPage.retriveNoProductMessageText(), "There is no product that matches the search criteria.");
	}
	
	@Test(priority=2)
	public void verifySearchWithoutAnyProduct() {
		searchPage=homePage.clickOnsearchButton();
		Assert.assertEquals(searchPage.retriveNoProductMessageText(), testDataProp.getProperty("NoProductTextInSearchResult"),"No product message in search results is not displayed");
	}
}
