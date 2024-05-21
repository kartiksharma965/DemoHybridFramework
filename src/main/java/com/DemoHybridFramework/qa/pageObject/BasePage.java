package com.DemoHybridFramework.qa.pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
/* Rule
 a) BasePage includes only constructor. 
    This will be invoked by every Page Object Class constructor (Re-usability).
 b) Every Page Object Classes extends BasePage class. 
    There is Inheritance relationship between BasePage and Page Object Classes
    There Page Object classes extends from BasePage.
 */
public class BasePage {

	WebDriver driver;
	
	// Constructor of BagePage class.
	public BasePage(WebDriver driver) {
		{
			this.driver=driver;
			PageFactory.initElements(driver, this);
		}
	}
}
