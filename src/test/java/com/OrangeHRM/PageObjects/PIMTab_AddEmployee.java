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
	
	@FindBy(id = "menu_pim_viewPimModule")
	WebElement idElement;
	
	@FindBy(id = "menu_pim_addEmployee")
	WebElement addElement;
	
	//Elements in Addemployee tab
	@FindBy(xpath = "//input[@name='firstName']")
	WebElement firstName;
	
	@FindBy(id = "lastName")
	WebElement lastName;
	
	//for Save Button
	@FindBy(xpath = "//input[@value='Save']")
	WebElement saveButton;
	
	//write a mechanism to hover on the element
	public void getElement() {
		actions = new Actions(driver);
		actions.moveToElement(idElement).perform();
		addElement.click();
		
	}
	public void addFirstName(String fname) {
		firstName.sendKeys(fname);
	}
	public void addLastName(String lname) {
		lastName.sendKeys(lname);
	}
	
	public void clickSaveButton() {
		saveButton.click();
	}
}
