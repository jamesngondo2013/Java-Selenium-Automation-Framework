package com.james.training.selenium_project.pages;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class DropdownPage extends BasePage{
	
	private By dropdown = By.id("dropdown");

	public DropdownPage(WebDriver driver, Logger log) {
		super(driver, log);
		
	}
	
	/** This method selects given option from dropdown */
	public void selectOption(int index) {
		log.info("Selecting option " + index + " from dropdown");	
		selectDropdownByValue(dropdown, index);		
	}

	/** This method returns selected option in dropdown as a string */
	public String getSelectedOption() {
		WebElement dropdownElement = findElement(dropdown);
		Select dropdown = new Select(dropdownElement);
		String selectedOption = dropdown.getFirstSelectedOption().getText();
		log.info(selectedOption + " is selected in dropdown");
		return selectedOption;
	}


}
