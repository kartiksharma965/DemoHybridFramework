package com.DemoHybridFramework.qa.utils;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class Utilities {

	
	public static final int IMPLICIT_WAIT_TIME=10;
	public static final int PAGE_LOAD_TIME=10;
	public static final int Expilicit_Wait_TIME=20;
	
	public static String generateEmailWithTimeStamp() {
		Date date = new Date();
		String timeStramp=date.toString().replace(":", "_").replace(" ", "_");
		return "Shree"+timeStramp+"gmail.com";
	}
	
	public String randomString() {
		String generateString=RandomStringUtils.randomAlphabetic(5);
		return generateString;
	}
	
	public String randomNumber() {
		String generateString=RandomStringUtils.randomNumeric(10);
		return generateString;
	}
	
	public String randomAlphaNumeric() {
		String str= RandomStringUtils.randomAlphabetic(3);
		String numb=RandomStringUtils.randomNumeric(3);
		
		String randomAlphaNumeric=str+"@"+numb;
		return randomAlphaNumeric;
	}
	/*
	 *Scenario :- If we declare captureScreen shot method in utilities class and call it in ExtentReportManager than
	              as result "java.lang.NullPointerException: Cannot invoke "org.openqa.selenium.TakesScreenshot.getScreenshotAs(org.openqa.selenium.OutputType)" 
	                          because "takesScreenshot" is null".
	                          
	  Solution  :- We will write below code in BaseTest() class.                        
	    
	    static public WebDriver driver;  
	    
	    Note = public WebDriver driver;// In case of parallel testing we do not use static keyword.                 
	
	    public String captureScreen(String tname) throws IOException {

		String timeStamp = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
				
		TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
		File sourceFile = takesScreenshot.getScreenshotAs(OutputType.FILE);
		
		String targetFilePath=System.getProperty("user.dir")+"\\screenshots\\" + tname + "_" + timeStamp + ".png";
		File targetFile=new File(targetFilePath);
		
		sourceFile.renameTo(targetFile);
			
		return targetFilePath;
	}
*/
}
