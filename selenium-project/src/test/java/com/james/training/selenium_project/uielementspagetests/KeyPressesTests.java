package com.james.training.selenium_project.uielementspagetests;

import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.james.training.selenium_project.basetest.TestUtilities;
import com.james.training.selenium_project.pages.KeyPressesPage;
import com.james.training.selenium_project.pages.WelcomePage;

public class KeyPressesTests extends TestUtilities{

	@Test
	public void pressKeyTest() {
		
		
		// open main page
		WelcomePage welcomePage = new WelcomePage(getDriver(), log);
		welcomePage.openPage();

		// open KeyPressesPage
		KeyPressesPage keyPressesPage = welcomePage.clickKeyPressesPageLink();

		// Push keyboard key
		keyPressesPage.pressKey(Keys.ENTER);

		// Get Results text
		String result = keyPressesPage.getResultText();

		// Verify Result text is expected
		Assert.assertTrue(result.equals("You entered: ENTER"),
				"result is not expected. \nShould be 'You entered: ENTER', but it is '" + result + "'");
	}

	@Test
	public void pressKeyWithActionsTest() {

		// open main page
		WelcomePage welcomePage = new WelcomePage(getDriver(), log);
		welcomePage.openPage();

		// open KeyPressesPage
		KeyPressesPage keyPressesPage = welcomePage.clickKeyPressesPageLink();

		// Push keyboard key
		keyPressesPage.pressKeyWithAction(Keys.SPACE);

		// Get Results text
		String result = keyPressesPage.getResultText();

		// Verify Result text is expected
		Assert.assertTrue(result.equals("You entered: SPACE"),
				"result is not expected. \nShould be 'You entered: ENTER', but it is '" + result + "'");
	}
}
