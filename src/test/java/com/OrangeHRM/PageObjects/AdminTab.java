package com.OrangeHRM.PageObjects;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.OrangeHRM.TestCases.TC_0001_LoginCheckHRM;

public class AdminTab {
	
	private static Logger logger = LogManager.getLogger(TC_0001_LoginCheckHRM.class);

	public WebDriver driver;
	public Actions actions;
	public Alert alert;
	
	public AdminTab(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(id = "menu_admin_viewAdminModule")
	WebElement adminElement;
	
	@FindBy(xpath = "//a[@id='menu_admin_Job']")
	WebElement jobElement;
	
	@FindBy(xpath = "//a[@id='menu_admin_employmentStatus']")
	WebElement employeeStatusElement;
	
	@FindBy(xpath = "//input[@id='btnAdd']")
	WebElement addButtonElement;
	
	@FindBy(xpath = "//input[@id='empStatus_name']")
	WebElement nameElement;
	
	@FindBy(id = "btnSave")
	WebElement saveButtonElement;
	
	@FindBy(xpath = "//input[@id='ohrmList_chkSelectRecord_9']")
	WebElement checkselctBoxElement;
	
	@FindBy(css = "input.delete")
	WebElement deleteButtonElement;
	
	@FindBy(xpath = "//input[@id='dialogDeleteBtn']")
	WebElement dialogOkButtonElement;
	
	public void getAdminElement() {
		actions = new Actions(driver);
		actions.moveToElement(adminElement).build().perform();
	}
	
	public void getJobElement() {
		actions = new Actions(driver);
		actions.moveToElement(jobElement).build().perform();
	} 
	
	public void getEmployeeStatusElement() {
		employeeStatusElement.click();
	}
	
	public void getaddButtonElement() {
		addButtonElement.click();
	}
	
	
	public void getnameElement(String addName) {
		nameElement.sendKeys(addName);
	}
	
	public void getSaveButtonElement() {
		saveButtonElement.click();
	}
	
	public void getcheckboxSelect() {
		checkselctBoxElement.click();
	}
	
	public void getDeleteElement() {
		deleteButtonElement.click();
		dialogOkButtonElement.click();
	}
	

}
