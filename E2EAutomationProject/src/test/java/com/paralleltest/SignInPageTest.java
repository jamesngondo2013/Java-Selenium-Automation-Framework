package com.paralleltest;

import org.testng.annotations.Test;

import com.datasource.db.CommonDataProvider;
import com.pageFactory.ClickAcadamyLandingPage;
import com.pageFactory.ClickAcadamyLoginPage;
import com.pageFactory.ClickAcadamyRegisterPage;
import com.pageFactory.ITProjectRequestPage;
import com.paralleltest.basetest.BaseTest;

import junit.framework.Assert;


public class SignInPageTest extends BaseTest {
  
	//@Test
	public void loginTest() {
		
		ClickAcadamyLandingPage home = new ClickAcadamyLandingPage(driver, log);
		home.openPage();
		
		//assert page url
		Assert.assertEquals(home.getCurrentUrl(), home.getPageUrl());
		
		//assert page headline
		String headline = "An Academy to Learn Earn & Shine  in your QA Career";
		Assert.assertEquals(headline, home.getPageHeadline());
		
		//assert nav-bar
		Assert.assertTrue(home.getNavBar());
		
		//click login
		ClickAcadamyLoginPage loginPage = new ClickAcadamyLoginPage(driver, log);
		 loginPage = home.clickLoginBtn();
		
		loginPage.enterEmailAddress("unresticteduser@gmail.com");
		
		loginPage.enterPassword("123456");
		
		loginPage.clickLogin();
		
		
	}
	
	@Test
	public void ariba() {
	
		ClickAcadamyLandingPage home = new ClickAcadamyLandingPage(driver, log);
		home.openPage();
		
		home.enterUsername("dsanghi");
		home.enterPassword("Go5ariba@sap");
		
		ClickAcadamyLoginPage loginPage = home.clickLogin();
		ITProjectRequestPage proj = loginPage.createITProjectRequest();
		//proj.enterProjectName("This is a test");
		//proj.enterGeneralDescrition("mine is working...");
		//proj.clickUploadFile();
		//proj.clickDateWidget();
		proj.clickSubmit();
		
	}
}
