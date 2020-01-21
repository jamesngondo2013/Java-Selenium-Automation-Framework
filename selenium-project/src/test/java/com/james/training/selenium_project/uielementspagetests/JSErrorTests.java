package com.james.training.selenium_project.uielementspagetests;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.james.training.selenium_project.basetest.TestUtilities;
import com.james.training.selenium_project.pages.JSErrorPage;
import com.james.training.selenium_project.pages.WelcomePage;

import java.util.List;

import org.openqa.selenium.logging.LogEntry;

public class JSErrorTests extends TestUtilities{

	@Test
	public void jsErrorTest() {
		
		SoftAssert softAssert = new SoftAssert();

		// Open Welcome page
		WelcomePage welcomePage = new WelcomePage(getDriver(), log);
		welcomePage.openPage();
		
		JSErrorPage jsErrorPage = welcomePage.clickJavaScriptOnloadEventErrorPage();

		// Get logs
		List<LogEntry> logs = getBrowserLogs();

		// Verifying there are no JavaScript errors in console
		for (LogEntry logEntry : logs) {
			if (logEntry.getLevel().toString().equals("SEVERE")) {
				softAssert.fail("Severe error: " + logEntry.getMessage());
			}
		}
		softAssert.assertAll();
	}

}
