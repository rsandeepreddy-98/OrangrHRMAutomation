package com.OrangeHRM.PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

	public WebDriver driver;

	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//input[@name='txtUsername']")
	WebElement userName;
	public void getUserName(String uName) {
		userName.sendKeys(uName);
	}
	
	@FindBy(id = "txtPassword")
	WebElement password;
	
	public void getPassword(String pwd) {
		password.sendKeys(pwd);
	}
	
	@FindBy(name = "Submit")
	WebElement submitButton;
	
	public void clickSubmit() {
		submitButton.click();
	}
}

