package com.james.training.selenium_project.basetest;


public class TestDataDetails {

    private String id;
    private String password;
    private String username;
    private String expectedMessage;
    private String description;
    
	public TestDataDetails(String id, String password, String username, String expectedMessage, String description) {
		this.id = id;
		this.password = password;
		this.username = username;
		this.expectedMessage = expectedMessage;
		this.description = description;
	}

	
	public TestDataDetails() {
		
	}
	
	public TestDataDetails(String password, String username) {
		this.password = password;
		this.username = username;
	}


	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getExpectedMessage() {
		return expectedMessage;
	}

	public void setExpectedMessage(String expectedMessage) {
		this.expectedMessage = expectedMessage;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	
  
    
    
    
    
}
