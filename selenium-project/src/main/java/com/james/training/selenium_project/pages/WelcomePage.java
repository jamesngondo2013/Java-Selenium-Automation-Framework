package com.james.training.selenium_project.pages;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class WelcomePage extends BasePage {

	private String pageUrl = "http://the-internet.herokuapp.com/";

	//elements on the Welcome Page
	private By formAuthenticationLinkLocator = By.linkText("Form Authentication");
	private By checkboxesLinkLocator = By.linkText("Checkboxes");
	private By dropdownLinkLocator = By.linkText("Dropdown");
	private By multipleWindowsLinkLocator = By.linkText("Multiple Windows");
	private By javaScriptAlertsLinkLocator = By.linkText("JavaScript Alerts");
	private By editorLinkLocator = By.linkText("WYSIWYG Editor");
	private By keyPressesLocator = By.linkText("Key Presses");
	private By fileUploaderLocator = By.linkText("File Upload");
	private By dragAndDropLocator = By.linkText("Drag and Drop");
	private By hoverOverLocator = By.linkText("Hovers");
	private By horizontalSliderLocator = By.linkText("Horizontal Slider");
	private By fileDownloadLocator = By.linkText("File Download");
	private By javaScriptOnloadError = By.linkText("JavaScript onload event error");

	public WelcomePage(WebDriver driver, Logger log) {
		super(driver, log);
	}

	/** Open WelcomePage with it's url */
	public void openPage() {
		log.info("Opening page: " + pageUrl);
		openUrl(pageUrl);
		log.info("Page opened!");
	}

	/** Open LoginPage by clicking on Form Authentication Link */
	public LoginPage clickFormAuthenticationLink() {
		log.info("Clicking Form Authentication link on Welcome Page");
		click(formAuthenticationLinkLocator);
		return new LoginPage(driver, log);
	}
	
	/** Open CheckboxesPage by clicking on Checkboxes Link */
	public CheckboxesPage clickCheckboxesLink() {
		log.info("Clicking Checkboxes link on Welcome Page");
		click(checkboxesLinkLocator);
		return new CheckboxesPage(driver, log);
	}
	
	public DropdownPage clickDropdownLink() {
		log.info("Clicking Dropdown link on Welcome Page");
		click(dropdownLinkLocator);
		return new DropdownPage(driver, log);
	}
	
	public MultipleWindowsPage clickMultipleWindowsLink() {
		log.info("Clicking Multiple Windows link on Welcome Page");
		click(multipleWindowsLinkLocator);
		return new MultipleWindowsPage(driver, log);
	}

	public JavaScriptAlertsPage clickJavaScriptAlertsLink() {
		log.info("Clicking JavaScript Alerts link on Welcome Page");
		click(javaScriptAlertsLinkLocator);
		return new JavaScriptAlertsPage(driver, log);
	}

	public TextEditoriFramePage clickWYSIWYGEditorLink() {
		log.info("Clicking kWYSIWYG Editor link on Welcome Page");
		click(editorLinkLocator);
		return new TextEditoriFramePage(driver, log);
	}

	public KeyPressesPage clickKeyPressesPageLink() {
		log.info("Clicking Key Presses link on Welcome Page");
		click(keyPressesLocator);
		return new KeyPressesPage(driver, log);
	}

	public FileUploaderPage clickFileUploaderPageLink() {
		log.info("Clicking Key Presses link on Welcome Page");
		click(fileUploaderLocator);
		return new FileUploaderPage(driver, log);
	}
	
	public DragAndDropPage clickDragAndDropPageLink() {
		log.info("Clicking Drag And Drop link on Welcome Page");
		click(dragAndDropLocator);
		return new DragAndDropPage(driver, log);
	}
	
	public HorizontalSliderPage clickHorizontalSliderPageLink() {
		log.info("Clicking Horizontal Slider link on Welcome Page");
		click(horizontalSliderLocator);
		return new HorizontalSliderPage(driver, log);
	}
	
	public HoversPage clickHoversPageLink() {
		log.info("Clicking Hover link on Welcome Page");
		click(hoverOverLocator);
		return new HoversPage(driver, log);
	}

	public FileDownloadPage clickFileDownloadPage() {
		log.info("Clicking file download link on Welcome Page");
		click(fileDownloadLocator);
		return new FileDownloadPage(driver, log);
	}
	
	public JSErrorPage clickJavaScriptOnloadEventErrorPage() {
		log.info("Clicking JavaScript Onload Event Error link on Welcome Page");
		click(javaScriptOnloadError);
		return new JSErrorPage(driver, log);
	}

}
