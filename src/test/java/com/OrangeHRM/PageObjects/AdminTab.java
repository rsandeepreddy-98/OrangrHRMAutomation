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

	

	
	
	@FindBy(xpath = "//span[text()='Admin']")
	WebElement adminElement;
	public void clickAdminElement() {
		adminElement.click();
	}
	
	@FindBy(xpath = "//li[@class='oxd-topbar-body-nav-tab --parent'][1]")
	WebElement jobElement;
	public void getJobElement() {
		jobElement.click();
	}
	
	@FindBy(xpath = "//ul[@class='oxd-dropdown-menu']/child::li[3]")
	WebElement employeeStatusElement;
	
	public void getEmployeeStatusElement() {
		employeeStatusElement.click();
	}
	
	@FindBy(xpath = "//button[@class='oxd-button oxd-button--medium oxd-button--secondary']")
	WebElement addButtonElement;
	public void getaddButtonElement() {
		addButtonElement.click();
	}
	
	
	@FindBy(xpath = "//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[1]/div/div[2]/input")
	WebElement nameElement;
	public void getnameElement(String addName) {
		nameElement.sendKeys(addName);
		
	}
	
	@FindBy(xpath = "//button[@class='oxd-button oxd-button--medium oxd-button--secondary orangehrm-left-space']")
	WebElement saveButtonElement;
	    
	public void getSaveButtonElement() {
		saveButtonElement.click();
		
	}

	/*
	 * public void getcheckboxSelect() { checkselctBoxElement.click(); }
	 * 
	 * public void getDeleteElement() { deleteButtonElement.click();
	 * dialogOkButtonElement.click(); }
	 */
}
