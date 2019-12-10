package com.james.training.selenium_project.uielementspagetests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.james.training.selenium_project.basetest.TestUtilities;
import com.james.training.selenium_project.pages.HoversPage;
import com.james.training.selenium_project.pages.ViewUserProfilePage;
import com.james.training.selenium_project.pages.WelcomePage;

public class HoverOverTests extends TestUtilities {

	@Test
	public void user2ProfileTest() {
		log.info("Starting user2ProfileTest");

		// Open HoversPage
		WelcomePage welcome = new WelcomePage(driver, log);
		welcome.openPage();

		// Open User 2 profile
		HoversPage hoversPage = welcome.clickHoversPageLink();
		ViewUserProfilePage userProfile = hoversPage.openUserProfile(2);

		// Verify correct user profile opened
		Assert.assertTrue(hoversPage.getCurrentUrl().contains("/users/2"),
				"Url of opened page is not expected User 1 page url");
		
		String textValue = userProfile.getText();
		
		// Verify correct user profile opened
		Assert.assertTrue(textValue.equals("Not Found"),
				"Text value is not expected. \nShould be 'Not Found', but it is '" + textValue + "'");
	}
}
