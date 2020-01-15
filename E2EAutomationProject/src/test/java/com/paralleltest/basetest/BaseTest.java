package com.paralleltest.basetest;

import java.lang.reflect.Method;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import com.paralleltest.utils.ConfigDataProvider;
import com.paralleltest.utils.ExcelUtils;

public class BaseTest {
	
	protected WebDriver driver;
	protected Logger log;
	protected FirefoxProfile profile;
	
	public ConfigDataProvider config;
	public ExcelUtils excelUtils;
	
	protected String testSuiteName;
	protected String testName;
	protected String testMethodName;
	
	@BeforeSuite
	public void setUpSuite() {
		
		config = new ConfigDataProvider();
		excelUtils = new ExcelUtils(config.getExcelPathName(), config.getExcelSheetName());
	}

	@BeforeMethod(alwaysRun = true)
	public void setUp(Method method, ITestContext ctx) {
		String testName = ctx.getCurrentXmlTest().getName();
		log = LogManager.getLogger(testName);
		
		BrowserDriverFactory factory = new BrowserDriverFactory(config.getBrowser(), log);
		driver = factory.createDriver();
		driver.get(config.getStagingURL());
		
		profile=new FirefoxProfile();
		// Set preferences for file type 
		profile.setPreference("browser.helperApps.neverAsk.openFile", "application/octet-stream");
		
		// This sleep here is for instructor only. Students don't need this here
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		driver.manage().window().maximize();
		
		this.testSuiteName = ctx.getSuite().getName();
		this.testName = testName;
		this.testMethodName = method.getName();
	}

	@AfterMethod(alwaysRun = true)
	public void tearDown(ITestResult result) {
		
		if(result.getStatus()==ITestResult.FAILURE) {
			//capture screenshot
		}
		
		log.info("Close driver");
		// Close browser
		driver.quit();
	}


}
