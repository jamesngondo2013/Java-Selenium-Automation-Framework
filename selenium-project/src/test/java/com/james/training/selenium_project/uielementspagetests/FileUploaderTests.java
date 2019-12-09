package com.james.training.selenium_project.uielementspagetests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.james.training.selenium_project.basetest.TestUtilities;
import com.james.training.selenium_project.pages.FileUploaderPage;
import com.james.training.selenium_project.pages.WelcomePage;

public class FileUploaderTests extends TestUtilities{

	@Test
	public void fileUploaderTest() {
		log.info("Starting fileUp loader Test");
		
		// open main page
		WelcomePage welcomePage = new WelcomePage(driver, log);
		welcomePage.openPage();
	
		// open fileUploader
		FileUploaderPage fileUploaderPage = welcomePage.clickFileUploaderPageLink();
		
		// Select file
		String filename = "nuig-data-analytics (1).pdf";
		fileUploaderPage.selectFile(filename);
		
		// Push upload button
		fileUploaderPage.pushUploadButton();
		
		// Get uploaded files
		String fileNames = fileUploaderPage.getUploadedFilesNames();

		// Verify selected file uploaded
		Assert.assertTrue(fileNames.contains(filename),
						"Our file (" + filename + ") is not one of the uploaded (" + fileNames + ")");
		
	}
}
