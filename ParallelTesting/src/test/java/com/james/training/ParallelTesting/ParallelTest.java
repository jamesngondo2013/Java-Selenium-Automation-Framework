package com.james.training.ParallelTesting;

import org.testng.annotations.Test;

import com.james.training.ParallelTesting.basetest.BaseTest;
import com.james.training.ParallelTesting.pages.ClickAcadamyDashboard;
import com.james.training.ParallelTesting.pages.ClickAcadamyLandingPage;
import com.james.training.ParallelTesting.pages.ClickAcadamyLoginPage;
import com.james.training.ParallelTesting.utils.DBDataProvider;

import junit.framework.Assert;

/**
 * Unit test for simple App.
 */
public class ParallelTest extends BaseTest
{
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
	
	
	@Test(dataProvider = "databaseTestData", dataProviderClass = DBDataProvider.class)
	public void loginTestDBData(String username, String password) {

		System.err.println("Running Test=> " + this + " -> on thread [" + Thread.currentThread().getId() + "]");

		//log.info("Starting positiveLogInTest #  for " + username);

		
		ClickAcadamyLandingPage home = new ClickAcadamyLandingPage(getDriver(), log);
		home.openPage();

		// assert page url
		Assert.assertEquals(home.getCurrentUrl(), home.getPageUrl());

		// assert page headline
		String headline = "An Academy to Learn Earn & Shine  in your QA Career";
		Assert.assertEquals(headline, home.getPageHeadline());

		// assert nav-bar
		Assert.assertTrue(home.getNavBar());

		//home.closeNewsLetterPopup();

		// click login
		ClickAcadamyLoginPage loginPage = new ClickAcadamyLoginPage(getDriver(), log);
		loginPage = home.clickLoginBtn();

		// loginPage.enterEmailAddress("unresticteduser@gmail.com");
		loginPage.enterEmailAddress(username);

		loginPage.enterPassword(password);

		ClickAcadamyDashboard dashboard = loginPage.clickLogin();
		dashboard.clickLogout();
		

	}
}
