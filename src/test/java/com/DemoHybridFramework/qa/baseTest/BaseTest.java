package com.DemoHybridFramework.qa.baseTest;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.DemoHybridFramework.qa.utils.ExcelReader;
import com.DemoHybridFramework.qa.utils.Utilities;



public class BaseTest {

	static public  WebDriver driver;
	//In case we 'public WebDriver driver' then null pointer exception is occurs we are not able to takescreenshot.
	WebDriverWait wait;
	public Logger logger;
	// In case below are default access modifier than it can not be visible outside the package. Hence making it protected access modifier.
	protected Properties configProp;
	protected Properties testDataProp;
	public ExcelReader excel = new ExcelReader(".\\src\\main\\java\\com\\DemoHybridFramework\\qa\\testData\\testdata.xlsx");

	// Constructor of BaseTest class.
	public BaseTest() {

		// fetching data at runtime from config.properties file.
		configProp = new Properties();
		File configFile = new File(".\\src\\main\\java\\com\\DemoHybridFramework\\qa\\config\\config.properties");
		try{
			FileInputStream fis = new FileInputStream(configFile);
			configProp.load(fis);	
		}catch(Throwable e) {
			e.printStackTrace();	
		}

		// fetching data at runtime from testdata.properties file.
		testDataProp = new Properties();
		File testDataFile = new File(".\\src\\main\\java\\com\\DemoHybridFramework\\qa\\testData\\testdata.properties");
		try {
			FileInputStream fis = new FileInputStream(testDataFile);
			testDataProp.load(fis);
		}catch(Throwable e) {
			e.printStackTrace();
		}
	}


	public WebDriver initializeBrowserAndOpenApplicationURL(String browserName) {
		logger=LogManager.getLogger(this.getClass());


		if(browserName.equalsIgnoreCase("chrome")) {
			driver = new ChromeDriver();
		} else if (browserName.equalsIgnoreCase("fireFox")) {
			driver = new FirefoxDriver();
		} else if (browserName.equalsIgnoreCase("edge")) {
			driver = new EdgeDriver();
		} else if (browserName.equalsIgnoreCase("safari")) {
			driver = new SafariDriver();
		}

		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(Utilities.IMPLICIT_WAIT_TIME));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(Utilities.PAGE_LOAD_TIME));
		wait = new WebDriverWait(driver,Duration.ofSeconds(Utilities.Expilicit_Wait_TIME));
		driver.get(configProp.getProperty("url"));
		return driver;
	}

	public String captureScreen(String tname) throws IOException {

		String timeStamp = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());

		TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
		File sourceFile = takesScreenshot.getScreenshotAs(OutputType.FILE);

		String targetFilePath=System.getProperty("user.dir")+"\\screenshots\\" + tname + "_" + timeStamp + ".png";
		File targetFile=new File(targetFilePath);

		sourceFile.renameTo(targetFile);

		return targetFilePath;
	}
}
