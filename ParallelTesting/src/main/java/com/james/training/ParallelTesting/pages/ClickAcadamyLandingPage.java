package com.james.training.ParallelTesting.pages;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.mysql.cj.util.TestUtils;


public class ClickAcadamyLandingPage extends BasePage {

	public static String PAGE_TITLE = "FEATURED COURSES";
	public static String PAGE_HEADLINE = "An Academy to Learn Earn & Shine  in your QA Career";
	private String pageUrl0 = "https://s1.ariba.com/Sourcing/Main/aw?awh=r&awssk=KkQ74sDa&realm=cirrusatlanticsuite&dard=1#b0";
	private String pageUrl3 = "https://rahulshettyacademy.com/index";
	private String pageUrl = "http://www.qaclickacademy.com/";

	

	public ClickAcadamyLandingPage(WebDriver driver, Logger log) {
		super(driver, log);
		this.driver = driver;
	}

	private By loginBtn = By.cssSelector("a[href='http://qaclickacademy.usefedora.com/sign_in']");
	private By registerBtn = By.cssSelector("a[href='http://qaclickacademy.usefedora.com/sign_in']");
	
	private By usernameTxt = By.id("UserName");
	private By userpasswordTxt = By.id("Password");
	private By loginBtn2 = By.xpath("//input[@value='Login']");

	// to get navigation bar on the landing page
	public Boolean getNavBar() {
		return isElementPresent(loginBtn);
	}

	// click login link button
	public ClickAcadamyLoginPage clickLoginBtn() {
		WebElement elem = findElement(loginBtn);
		click(elem);
		sleep(2);
		//log.info("Clicked login button");
		return new ClickAcadamyLoginPage(driver, log);
	}

	/** Open WelcomePage with it's url */
	public void openPage() {
		
		//log.info("Opening page: " + pageUrl);
		getCurrentUrl();
		sleep(3);
		//openUrl(pageUrl);
		//log.info("Page opened!");
	}

	public String getPageUrl() {
		// TODO Auto-generated method stub
		return pageUrl;
	}
	
	public String getPageHeadline() {
		// TODO Auto-generated method stub
		return PAGE_HEADLINE;
	}
	
	//============================

	public void enterPassword(String string) {
		// TODO Auto-generated method stub
		enter(string, userpasswordTxt);
		sleep(3);
	}

	public ClickAcadamyLoginPage clickLogin() {
		// TODO Auto-generated method stub
		click(loginBtn2);
		sleep(3);
		
		return new ClickAcadamyLoginPage(driver,log);
	}

	public void enterUsername(String string) {
		// TODO Auto-generated method stub
		enter(string,usernameTxt);
		sleep(3);
		//log.info("pass: "+ string);
	}

	public void closeNewsLetterPopup() {
		By popup = By.xpath("//button[contains(text(), 'NO THANKS')]");
		findElement(popup).click();
		//clickStallElement(popup);
		sleep(2);
		
		/*
		 * if (isElementPresent(popup)) { click(popup); sleep(2); }
		 */
		
	}
	
}
