package com.james.training.selenium_project.uielementspagetests;

import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.james.training.selenium_project.basetest.CsvDataProviders;
import com.james.training.selenium_project.basetest.TestUtilities;
import com.james.training.selenium_project.pages.LoginPage;
import com.james.training.selenium_project.pages.WelcomePage;

public class NegativeLoginTests extends TestUtilities {

	@Test(priority = 1, dataProvider="csvNegativeTestReader", dataProviderClass = CsvDataProviders.class)
	public void negativeLogInTest(Map<String, String> testData) {
		
		//data extraction
		String no = testData.get("no");
		String username = testData.get("username");
		String password = testData.get("password");
		String expectedErrorMessage  = testData.get("expectedMessage");
		String description = testData.get("description");

		log.info("Starting negativeLogInTest #" + no + " for "+ description);

		// open main page
		WelcomePage welcomePage = new WelcomePage(getDriver(), log);
		welcomePage.openPage();

		// Click on Form Authentication link
		LoginPage loginPage = welcomePage.clickFormAuthenticationLink();

		// execute negative login
		loginPage.negativeLogIn(username, password);

		// wait for error message
		loginPage.waitForErrorMessage();
		String message = loginPage.getErrorMessageText();

		// Verification
		Assert.assertTrue(message.contains(expectedErrorMessage), "Message doesn't contain expected text.");
	}
	
}
