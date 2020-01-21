package com.james.training.selenium_project.uielementspagetests;

import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.james.training.selenium_project.basetest.CsvDataProviders;
import com.james.training.selenium_project.basetest.DBDataProvider;
import com.james.training.selenium_project.basetest.TestUtilities;
import com.james.training.selenium_project.pages.LoginPage;
import com.james.training.selenium_project.pages.SecureAreaPage;
import com.james.training.selenium_project.pages.WelcomePage;

/**
 * Unit test for simple App.
 */
public class PositiveLoginTest extends TestUtilities {
	
	//@Test(dataProvider="csvPositiveTestReader", dataProviderClass = CsvDataProviders.class)
	public void positivelogInTest(Map<String, String> testData) {
		
		// System.err.println("Running Test=> " + this + " -> on thread [" + Thread.currentThread().getId() + "]");
		 
		// data extraction
		String no = testData.get("no");
		String username = testData.get("username");
		String password = testData.get("password");
		String expectedSuccessMessage = testData.get("expectedSuccessMessage");
		
		log.info("Starting positiveLogInTest #" + no + " for "+ username);

		// open main page
		WelcomePage welcomePage = new WelcomePage(getDriver(), log);
		welcomePage.openPage();
		//takeScreenshot("Welcome page opened - by "+ username);

		// Click on Form Authentication link
		LoginPage loginPage = welcomePage.clickFormAuthenticationLink();
		//takeScreenshot("click auth link - by "+ username);
		
		// execute log in
		SecureAreaPage secureAreaPage = loginPage.logIn(username, password);
		//takeScreenshot("logged in - by "+ username);

		// Verifications
		// New page url is expected
		Assert.assertEquals(secureAreaPage.getCurrentUrl(), secureAreaPage.getPageUrl());

		// log out button is visible
		Assert.assertTrue(secureAreaPage.isLogOutButtonVisible(), "LogOut Button is not visible.");

		// Successful log in message
		String actualSuccessMessage = secureAreaPage.getSuccessMessageText();
		
		Assert.assertTrue(actualSuccessMessage.contains(expectedSuccessMessage),
				"actualSuccessMessage does not contain expectedSuccessMessage\nexpectedSuccessMessage: "
						+ expectedSuccessMessage + "\nactualSuccessMessage: " + actualSuccessMessage);
	}
	
	@Test(dataProvider="databaseTestData", dataProviderClass = DBDataProvider.class)
	public void positivelogInDBTest(String username, String password) {
		
		// System.err.println("Running Test=> " + this + " -> on thread [" + Thread.currentThread().getId() + "]");	 
		
		log.info("Starting positiveLogInTest for "+ username);

		// open main page
		WelcomePage welcomePage = new WelcomePage(getDriver(), log);
		welcomePage.openPage();
		//takeScreenshot("Welcome page opened - by "+ username);

		// Click on Form Authentication link
		LoginPage loginPage = welcomePage.clickFormAuthenticationLink();
		//takeScreenshot("click auth link - by "+ username);
		
		// execute log in
		SecureAreaPage secureAreaPage = loginPage.logIn(username, password);
		//takeScreenshot("logged in - by "+ username);

		// Verifications
		// New page url is expected
		Assert.assertEquals(secureAreaPage.getCurrentUrl(), secureAreaPage.getPageUrl());

		// log out button is visible
		Assert.assertTrue(secureAreaPage.isLogOutButtonVisible(), "LogOut Button is not visible.");

		// Successful log in message
		String actualSuccessMessage = secureAreaPage.getSuccessMessageText();
		
		//Assert.assertTrue(actualSuccessMessage.contains(expectedSuccessMessage),
		//		"actualSuccessMessage does not contain expectedSuccessMessage\nexpectedSuccessMessage: "
		//				+ expectedSuccessMessage + "\nactualSuccessMessage: " + actualSuccessMessage);
	}
	
	//@Test
	public void test2()
	{
		WelcomePage welcomePage = new WelcomePage(getDriver(), log);
		welcomePage.openPage();

		// Click on Form Authentication link
		LoginPage loginPage = welcomePage.clickFormAuthenticationLink();
		// takeScreenshot("click auth link - by "+ username);

		// execute log in
		SecureAreaPage secureAreaPage = loginPage.logIn("tomsmith", "SuperSecretPassword!");
		secureAreaPage.clickLogout();
	}
	
}
