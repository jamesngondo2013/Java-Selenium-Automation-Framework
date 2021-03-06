package com.james.training.ParallelTesting.pages;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ClickAcadamyLoginPage extends BasePage{
	
	public ClickAcadamyLoginPage(WebDriver driver, Logger log) {
		super(driver, log);
		this.driver =driver;
	}
	
	private By emailLocator = By.id("user_email");
	private By passwordLocator = By.id("user_password");
	private By loginBtnLocator = By.name("commit");
	
	private By createDrop = By.xpath("//span[contains(@class,'a-srch-bar-create')]");
	private By proj = By.xpath("//*[contains(@title,'Birthday cake')]");

	public void enterEmailAddress(String email) {
		enter(email, emailLocator);
		sleep(30);
	}

	public void enterPassword(String pass) {
		enter(pass, passwordLocator);	
	}

	public ClickAcadamyDashboard clickLogin() {
		click(loginBtnLocator);
		sleep(15);
		return new ClickAcadamyDashboard(driver, log);
	}

}
