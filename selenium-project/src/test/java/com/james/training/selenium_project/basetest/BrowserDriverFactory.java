package com.james.training.selenium_project.basetest;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class BrowserDriverFactory {

	private ThreadLocal<WebDriver> driver = new ThreadLocal<WebDriver>();
	private String browser;
	private Logger log;

	public BrowserDriverFactory(String browser, Logger log) {
		this.browser = browser.toLowerCase();
		this.log = log;
	}

	public WebDriver createDriver() {
		// Create driver
		log.info("Create driver: " + browser);

		if(browser.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
			driver.set(new ChromeDriver());
		}
		else if(browser.equals("firefox")) {
			System.setProperty("webdriver.gecko.driver", "src/main/resources/geckodriver.exe");
			driver.set(new FirefoxDriver());
		}
		else if(browser.equals("IE")) {
			System.setProperty("", "");
			driver.set(new InternetExplorerDriver());
		}
		else {
			System.out.println("Do not know how to start: " + browser + ", starting chrome.");
			System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
			driver.set(new ChromeDriver());
		}

		return driver.get();
	}
}
