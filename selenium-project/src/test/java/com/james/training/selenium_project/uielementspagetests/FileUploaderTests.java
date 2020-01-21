package com.james.training.selenium_project.uielementspagetests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.james.training.selenium_project.basetest.TestUtilities;
import com.james.training.selenium_project.pages.FileUploaderPage;
import com.james.training.selenium_project.pages.WelcomePage;

public class FileUploaderTests extends TestUtilities{

	@Test(dataProvider = "files")
	public void fileUploaderTest(int no, String fileName) {
		log.info("Starting fileUp loader Test #:"+ no + " for "+ fileName);
		
		// open main page
		WelcomePage welcomePage = new WelcomePage(getDriver(), log);
		welcomePage.openPage();
	
		// open fileUploader
		FileUploaderPage fileUploaderPage = welcomePage.clickFileUploaderPageLink();
		
		fileUploaderPage.selectFile(fileName);
		
		// Push upload button
		fileUploaderPage.pushUploadButton();
		
		// Get uploaded files
		String fileNames = fileUploaderPage.getUploadedFilesNames();

		// Verify selected file uploaded
		Assert.assertTrue(fileNames.contains(fileName),
						"Our file (" + fileName + ") is not one of the uploaded (" + fileName + ")");
		
	}
}
