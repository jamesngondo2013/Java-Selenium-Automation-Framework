package com.pageFactory;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class ClickAcadamyLandingPage extends BasePage {

	public static String PAGE_TITLE = "FEATURED COURSES";
	public static String PAGE_HEADLINE = "An Academy to Learn Earn & Shine  in your QA Career";
	private String pageUrl = "https://s1.ariba.com/Sourcing/Main/aw?awh=r&awssk=KkQ74sDa&realm=cirrusatlanticsuite&dard=1#b0";
	private String pageUrl3 = "https://rahulshettyacademy.com/index";
	private String pageUrl0 = "http://www.qaclickacademy.com/";
	private String pageUrl2 = "https://sso.teachable.com/secure/9521/users/sign_in?clean_login=true&reset_purchase_session=1";
	
	public WebDriver driver;
	

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
		click(loginBtn);
		log.info("Clicked login button");
		return new ClickAcadamyLoginPage(driver, log);
	}

	// click login link button
	public ClickAcadamyRegisterPage registerBtn() {
		click(registerBtn);
		log.info("Clicked registration button");
		return new ClickAcadamyRegisterPage(driver, log);
	}

	/** Open WelcomePage with it's url */
	public void openPage() {
		
		log.info("Opening page: " + pageUrl);
		openUrl(pageUrl);
		log.info("Page opened!");
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
	}

	public ClickAcadamyLoginPage clickLogin() {
		// TODO Auto-generated method stub
		click(loginBtn2);
		sleep(5);
		return new ClickAcadamyLoginPage(driver,log);
	}

	public void enterUsername(String string) {
		// TODO Auto-generated method stub
		enter(string,usernameTxt);
		log.info("pass: "+ string);
	}
	
}
