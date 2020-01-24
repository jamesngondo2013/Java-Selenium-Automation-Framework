package com.james.training.ParallelTesting.pages;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ClickAcadamyDashboard extends BasePage{

	private By dropdown = By.xpath("//*[@class='fedora-navbar-link navbar-link dropdown-toggle open-my-profile-dropdown']");
	private By logout = By.xpath("//*[@class='user-signout']");

	public ClickAcadamyDashboard(WebDriver driver, Logger log) {
		super(driver, log);
		this.driver = driver;
	}

	public void clickLogout() {
		// TODO Auto-generated method stub
		click(dropdown);
		sleep(2);
		click(logout);
	}
	
	
}
