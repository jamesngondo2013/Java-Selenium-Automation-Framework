package com.james.training.selenium_project.basetest;

import java.lang.reflect.Method;
import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
/*
 * can add @Listeners to the base if we dont want to add it in test suite xml
 */


//@Listeners({com.james.training.selenium_project.basetest.TestListener.class})
public class BaseTest {

	private static final ThreadLocal<WebDriver> drivers = new ThreadLocal<WebDriver>();
	protected Logger log;
	protected FirefoxProfile profile;
	
	protected String testSuiteName;
	protected String testName;
	protected String testMethodName;
	
	protected String url = "http://the-internet.herokuapp.com/";
	
	public WebDriver getDriver() {
		return drivers.get();
	}

	@Parameters({ "browser" })
	@BeforeMethod(alwaysRun = true)
	public void setUp(Method method, @Optional String browser, ITestContext ctx) {
		String testName = ctx.getCurrentXmlTest().getName();
		log = LogManager.getLogger(testName);
		
		WebDriver driver = BrowserDriverFactory.createDriver(browser, log);
		drivers.set(driver);
		driver.get(url);
		
		profile=new FirefoxProfile();
		// Set preferences for file type 
		profile.setPreference("browser.helperApps.neverAsk.openFile", "application/octet-stream");
		
		// This sleep here is for instructor only. Students don't need this here
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
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
