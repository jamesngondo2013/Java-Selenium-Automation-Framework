package com.james.training.selenium_project.pages;

import java.util.List;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class FileDownloadPage extends BasePage{

	private By fileDownloadTextLocator = By.xpath("//*[contains(@href,'download')]");
	
	public FileDownloadPage(WebDriver driver, Logger log) {
		super(driver, log);
	}

	public String downloadFile(int fileIndex) {
		List<WebElement> elements=  findAllElements(fileDownloadTextLocator);
		log.info("Selected file: " + elements.get(fileIndex).getText() + " : to download");
		log.info("Clicking on selected file: " + fileIndex + " : to download");
		elements.get(fileIndex).click();
		
		return elements.get(fileIndex).getText();
	}
}
