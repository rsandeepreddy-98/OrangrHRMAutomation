package com.OrangeHRM.PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.OrangeHRM.Utilities.DBConnection;

public class LoginPage extends DBConnection{

	public WebDriver driver;

	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//input[@name='username']")
	WebElement userNameField;
	public void getUserName(String uName) {
		userNameField.sendKeys(uName);
	}
	
	@FindBy(xpath = "//input[@name='password']")
	WebElement passwordField;
	
	public void getPassword(String pwd) {
		passwordField.sendKeys(pwd);
	}
	
	@FindBy(xpath = "//button[@class='oxd-button oxd-button--medium oxd-button--main orangehrm-login-button']")
	WebElement loginButton;
	
	public void clickLogin() {
		loginButton.click();
	}
}

