package com.james.training.selenium_project.uielementspagetests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.james.training.selenium_project.basetest.TestUtilities;
import com.james.training.selenium_project.pages.TextEditoriFramePage;
import com.james.training.selenium_project.pages.WelcomePage;

public class TextEditoriFrameTests extends TestUtilities{

	@Test
	public void textEditorIFrameTest() {
		log.info("Text Editor iFrame Test");

		// open main page
		WelcomePage welcomePage = new WelcomePage(getDriver(), log);
		welcomePage.openPage();
		
		//scroll to bottom of page
		welcomePage.scrollToBottom();

		// Click on WYSIWYG Editor link
		TextEditoriFramePage editorPage = welcomePage.clickWYSIWYGEditorLink();
		
		// Get default editor text
		String editorPageText = editorPage.getEditorText();
		
		// Verification that new page contains expected text in source
		Assert.assertTrue(editorPageText.equals("Your content goes here."),
						"Editor default text is not expected. It is: " + editorPageText);

	}
}
