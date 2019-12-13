package com.james.training.selenium_project.uielementspagetests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.james.training.selenium_project.basetest.TestUtilities;
import com.james.training.selenium_project.pages.HorizontalSliderPage;
import com.james.training.selenium_project.pages.WelcomePage;

public class HorizontalSliderTest extends TestUtilities{

	@Test
	public void sliderTest() {

		// Open WelcomePage
		WelcomePage welcomePage = new WelcomePage(driver, log);
		welcomePage.openPage();

		//open horizontal slider page
		HorizontalSliderPage horizontalSilderPage = welcomePage.clickHorizontalSliderPageLink();
		String value = "3.5";

		// Set slider value
		sleep(2000);
		horizontalSilderPage.setSliderTo(value);
		sleep(2000);

		// Verify slider value
		String sliderValue = horizontalSilderPage.getSliderValue();
		Assert.assertTrue(sliderValue.equals(value), "Range is not correct. It is: " + sliderValue);
	}
}
