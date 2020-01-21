package com.james.training.selenium_project.uielementspagetests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.james.training.selenium_project.basetest.TestUtilities;
import com.james.training.selenium_project.pages.NewWindowPage;
import com.james.training.selenium_project.pages.WelcomePage;
import com.james.training.selenium_project.pages.MultipleWindowsPage;

public class MultipleWindowsTests extends TestUtilities{

	@Test
	public void newWindowTest() {

		// open main page
		WelcomePage welcomePage = new WelcomePage(getDriver(), log);
		welcomePage.openPage();

		// Click on MultipleWindows link
		MultipleWindowsPage multipleWindowsPage = welcomePage.clickMultipleWindowsLink();

		// Click 'Click Here' link to open new window from multiple windows page
		multipleWindowsPage.openNewWindow();
		sleep(1000);
		
		// Find and switch to new window page
		NewWindowPage newWindowPage = multipleWindowsPage.switchToNewWindowPage();

		String pageSource = newWindowPage.getCurrentPageSource();

		// Verification that new page contains expected text in source
		Assert.assertTrue(pageSource.contains("New Window"), "New page source doesn't contain expected text");
	}
}
