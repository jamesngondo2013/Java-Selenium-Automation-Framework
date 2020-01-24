package com.james.training.ParallelTesting.basetest;

import java.lang.reflect.Method;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

public class BaseTest {
	
	private static final ThreadLocal<WebDriver> drivers = new ThreadLocal<WebDriver>();
	private WebDriver driver;
	public WebDriverWait wait;
	protected Logger log;
	protected FirefoxProfile profile;
	
	protected String testSuiteName;
	protected String testName;
	protected String testMethodName;
	
	private String pageUrl = "http://www.qaclickacademy.com/";
	
	public WebDriver getDriver() {
		return drivers.get();
	}
	
	@Parameters({ "deviceName" })
	@BeforeMethod()
	public void setUp(Method method, @Optional String deviceName, ITestContext ctx) {
		String testName = ctx.getCurrentXmlTest().getName();
		log = LogManager.getLogger(testName);
		
		if(deviceName != null) {
			driver = BrowserDriverFactory.createChromeWithMobileEmulation(deviceName, log);
			drivers.set(driver);
			driver.get(pageUrl);
		}
		//else {
		//	driver = BrowserDriverFactory.createDriver("chrome", log);
		//	drivers.set(driver);
		//	driver.get(pageUrl);
		//}
		//drivers.set(driver);
		//driver.get(pageUrl);
		
		profile=new FirefoxProfile();
		// Set preferences for file type 
		profile.setPreference("browser.helperApps.neverAsk.openFile", "application/octet-stream");
		
		driver.manage().window().maximize();
		wait = new WebDriverWait(driver, 10);
		
		this.testSuiteName = ctx.getSuite().getName();
		this.testName = testName;
		this.testMethodName = method.getName();
	}

	 @AfterMethod(alwaysRun = true)
	  public void tearDown(ITestResult result) {
	    getDriver().quit();
	    drivers.remove();
	  }

}
