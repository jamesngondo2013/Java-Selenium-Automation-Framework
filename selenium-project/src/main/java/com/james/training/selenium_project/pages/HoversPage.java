package com.james.training.selenium_project.pages;

import java.util.List;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HoversPage extends BasePage{

	private By avatarLocator = By.xpath("//div[@class='figure']");
	private By viewProfileLinkLocator = By.xpath(".//a[contains(text(),'View profile')]");

	public HoversPage(WebDriver driver, Logger log) {
		super(driver, log);
	}

	/** Open specified user profile */
	public ViewUserProfilePage openUserProfile(int i) {
		List<WebElement> avatars = findAllElements(avatarLocator);
		WebElement specifiedUserAvatar = avatars.get(i - 1);
		log.info("Hover over avatar: "+(i - 1)+ " on hovers page");
		hoverOverElement(specifiedUserAvatar);
		log.info("Hover and click on avatar: "+(i - 1)+ " on hovers page");
		specifiedUserAvatar.findElement(viewProfileLinkLocator).click();
		
		return new ViewUserProfilePage(driver, log);
	}

}
