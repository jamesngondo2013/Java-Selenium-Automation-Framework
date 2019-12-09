package com.james.training.selenium_project.pages;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class KeyPressesPage extends BasePage{

	private By body = By.xpath("//body");
	private By resultTextLocator = By.id("result");
	
	public KeyPressesPage(WebDriver driver, Logger log) {
		super(driver, log);
	}

	/** Press given key while on this page */
	public void pressKey(Keys key) {
		log.info("Pressing " + key.name());
		pressKeys(body, key);
	}

	/** Get result text */
	public String getResultText() {
		String result = findElement(resultTextLocator).getText();
		log.info("Result text: " + result);
		return result;
	}

	public void pressKeyWithAction(Keys space) {
		log.info("Pressing " + space.name());
		pressKeyWithActions(space);
	}

}
