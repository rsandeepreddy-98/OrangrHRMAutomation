package com.OrangeHRM.PageObjects;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.OrangeHRM.TestCases.TC_0001_LoginCheckHRM;

public class PersonalDetailsPage {
	private static Logger logger = LogManager.getLogger(TC_0001_LoginCheckHRM.class);
	
	 WebDriver driver;
	 Select select;
	 JavascriptExecutor javascriptExecutor;
	public PersonalDetailsPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}


	@FindBy(xpath = "//input[@id='btnSave']")
	WebElement editElement;

	@FindBy(xpath = "//input[@id='personal_optGender_1']")
	WebElement genderOptionElement;
	
	@FindBy(xpath = "//select[@id='personal_cmbNation']")
	WebElement selctWebElement;
	
	public void editButton() {
		editElement.click();
	}

	public void genderElement() {
		genderOptionElement.click();
	}

	public void selectDropDown() {
		select = new Select(selctWebElement);
		select.selectByValue("82");
		List<WebElement> allOptions = select.getOptions();
		int totalCount = allOptions.size();
		logger.info(totalCount);
	}

	
}
