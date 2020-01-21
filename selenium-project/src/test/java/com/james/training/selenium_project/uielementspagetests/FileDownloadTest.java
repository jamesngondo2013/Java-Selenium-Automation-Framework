package com.james.training.selenium_project.uielementspagetests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.james.training.selenium_project.basetest.TestUtilities;
import com.james.training.selenium_project.pages.FileDownloadPage;
import com.james.training.selenium_project.pages.WelcomePage;

public class FileDownloadTest extends TestUtilities{

	@Test
	public void fileDownoladTest() {

		// open main page
		WelcomePage welcomePage = new WelcomePage(getDriver(), log);
		welcomePage.openPage();
		
		FileDownloadPage downloadPage = welcomePage.clickFileDownloadPage();
		
		String filename = downloadPage.downloadFile(4);
		
		// Verify correct user profile opened
		Assert.assertTrue(filename.equals("New Piskel-1.png (13).png"),
						"Filename value is not expected. \nShould be 'New Piskel-1.png (13).png', but it is '" + filename + "'");
	}
		
}
