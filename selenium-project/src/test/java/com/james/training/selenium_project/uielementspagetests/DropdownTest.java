package com.james.training.selenium_project.uielementspagetests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.james.training.selenium_project.basetest.TestUtilities;
import com.james.training.selenium_project.pages.DropdownPage;
import com.james.training.selenium_project.pages.WelcomePage;

public class DropdownTest extends TestUtilities {
	
	@Test
	public void optionTwoTest() {

		// open main page
		WelcomePage welcomePage = new WelcomePage(getDriver(), log);
		welcomePage.openPage();

		// Click on Dropdown link
		DropdownPage dropdownPage = welcomePage.clickDropdownLink();

		// Select Option 2
		dropdownPage.selectOption(2);

		// Verify Option 2 is selected
		String selectedOption = dropdownPage.getSelectedOption();
		Assert.assertTrue(selectedOption.equals("Option 2"),
				"Option 2 is not selected. Instead selected - " + selectedOption);
	}
}
