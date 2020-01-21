package com.james.training.selenium_project.uielementspagetests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.james.training.selenium_project.basetest.TestUtilities;
import com.james.training.selenium_project.pages.CheckboxesPage;
import com.james.training.selenium_project.pages.WelcomePage;

public class CheckboxesTests extends TestUtilities {

	@Test
	public void selectingTwoCheckboxesTest() {
		
		// open main page
		WelcomePage welcomePage = new WelcomePage(getDriver(), log);
		welcomePage.openPage();

		// Click on Checkboxes link
		CheckboxesPage checkboxesPage = welcomePage.clickCheckboxesLink();

		// Select All Checkboxes
		checkboxesPage.selectAllCheckboxes();

		// Verify all checkboxes are checked
		Assert.assertTrue(checkboxesPage.areAllCheckboxesChecked(), "Not all checkboxes are checked");

	}
}
