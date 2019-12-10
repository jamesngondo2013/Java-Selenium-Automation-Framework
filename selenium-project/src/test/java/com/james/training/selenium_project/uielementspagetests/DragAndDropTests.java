package com.james.training.selenium_project.uielementspagetests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.james.training.selenium_project.basetest.TestUtilities;
import com.james.training.selenium_project.pages.DragAndDropPage;
import com.james.training.selenium_project.pages.WelcomePage;

public class DragAndDropTests extends TestUtilities {

	//@Test
	public void dragAtoBTest() {
		log.info("Starting dragAtoBTest");

		// open main page
		WelcomePage welcomePage = new WelcomePage(driver, log);
		welcomePage.openPage();
		
		DragAndDropPage dragAndDropPage = welcomePage.clickDragAndDropPageLink();

		// Drag box A and drop it on box B
		dragAndDropPage.dragAtoB();

		// Verify correct headers in correct boxes
		String columnAText = dragAndDropPage.getColumnAText();
		Assert.assertTrue(columnAText.equals("B"), "Column A header should be B, but it is: " + columnAText);

		String columnBText = dragAndDropPage.getColumnBText();
		Assert.assertTrue(columnBText.equals("A"), "Column A header should be B, but it is: " + columnBText);
	}
	
	@Test
	public void dragBtoATest() {
		log.info("Starting dragBtoATest");

		// open main page
		WelcomePage welcomePage = new WelcomePage(driver, log);
		welcomePage.openPage();
		
		DragAndDropPage dragAndDropPage = welcomePage.clickDragAndDropPageLink();

		// Drag box A and drop it on box B
		dragAndDropPage.dragBtoA();

		// Verify correct headers in correct boxes
		String columnAText = dragAndDropPage.getColumnAText();
		Assert.assertTrue(columnAText.equals("B"), "Column A header should be B, but it is: " + columnAText);

		String columnBText = dragAndDropPage.getColumnBText();
		Assert.assertTrue(columnBText.equals("A"), "Column A header should be B, but it is: " + columnBText);
	}
}
