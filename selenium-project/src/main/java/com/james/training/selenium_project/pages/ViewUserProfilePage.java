package com.james.training.selenium_project.pages;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ViewUserProfilePage extends BasePage{

	private By textLocator = By.xpath(".//*[contains(text(),'Not Found')]");
	
	public ViewUserProfilePage(WebDriver driver, Logger log) {
		super(driver, log);
	}
	
	public String getText() {
		log.info("Finding text value on user profile page");
		String element = findElement(textLocator).getText();
		log.info("Found: "+element +": as text value on user profile page");
		return element;
	}

}
