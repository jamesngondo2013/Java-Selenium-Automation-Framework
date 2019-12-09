package com.james.training.selenium_project.pages;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class FileUploaderPage extends BasePage{

	private By choseFileFieldLocator = By.id("file-upload");
	private By uploadButtonLocator = By.id("file-submit");
	private By uploadedFilesLocator = By.id("uploaded-files");

	public FileUploaderPage(WebDriver driver, Logger log) {
		super(driver, log);
	}

	/** Push Upload button */
	public void pushUploadButton() {
		log.info("Clicking on upload button");
		click(uploadButtonLocator);
	}

	/** Push Upload button */
	public void selectFile(String fileName) {
		log.info("Selecting '" + fileName + "' file from Files folder");
		// Selecting file
		// String filePath = "C:\\Users\\Dmitry\\Downloads\\some-file.txt";
		String filePath = System.getProperty("user.dir") + "//src//main//resources//files//" + fileName;
		enter(filePath, choseFileFieldLocator);
		log.info("File selected");
	}

	/** Get names of uploaded files */
	public String getUploadedFilesNames() {
		String names = findElement(uploadedFilesLocator).getText();
		log.info("Uploaded files: " + names);
		return names;
	}


}
