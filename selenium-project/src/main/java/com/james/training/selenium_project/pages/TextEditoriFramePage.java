package com.james.training.selenium_project.pages;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class TextEditoriFramePage extends BasePage{
	
	private By editorLocator = By.id("tinymce");
	private By frame = By.tagName("iframe");

	public TextEditoriFramePage(WebDriver driver, Logger log) {
		super(driver, log);
	}
	
	/** Get text from TinyMCE WYSIWYG Editor */
	public String getEditorText() {
		switchToFrame(frame);
		String text = findElement(editorLocator).getText();
		log.info("Text from TinyMCE WYSIWYG Editor: " + text);
		return text;
	}


}
