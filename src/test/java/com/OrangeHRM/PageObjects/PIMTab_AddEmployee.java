package com.OrangeHRM.PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PIMTab_AddEmployee {

	public WebDriver driver;
	public Actions actions;
	
	public PIMTab_AddEmployee(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//span[text()='PIM']")
	private WebElement pimTab;
	
	public void pim_TabElement_click() {
		pimTab.click();
	}
	
	@FindBy(xpath = "//a[text()='Add Employee']")
	WebElement addEmployeeButton;
	public void addEmployeeClick() {
		addEmployeeButton.click();
		
	}
	
	//Elements in Addemployee tab
	@FindBy(xpath = "//input[@name='firstName']")
	WebElement firstName;
	public void addFirstName(String fname) {
		firstName.sendKeys(fname);
	}
	
	@FindBy(xpath = "//input[@name='lastName']")
	WebElement lastName;
	public void addLastName(String lname) {
		lastName.sendKeys(lname);
	}
	
	//for Save Button
	@FindBy(xpath = "//button[@class='oxd-button oxd-button--medium oxd-button--secondary orangehrm-left-space']")
	WebElement saveButton;
	
	public void clickSaveButton() {
		saveButton.click();
	}
}
