package com.OrangeHRM.TestCases;

import java.util.HashMap;
import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.OrangeHRM.PageObjects.AddEmployeePage;
import com.OrangeHRM.PageObjects.AdminTab;
import com.OrangeHRM.PageObjects.LoginPage;
import com.OrangeHRM.PageObjects.PersonalDetailsPage;
import com.OrangeHRM.Utilities.ExcelReader;
import com.OrangeHRM.Utilities.ReadConfig;

public class TC_0001_LoginCheckHRM extends BaseClass {
	private static Logger logger = LogManager.getLogger(TC_0001_LoginCheckHRM.class);

	public 	LoginPage loginPage;
	public ReadConfig readConfig = new ReadConfig();
	public AdminTab adminTab;

	@Test
	public void loginCheck() {

		loginPage = new LoginPage(driver);
		loginPage.getUserName(uName);
		logger.info("Entered Username");
		loginPage.getPassword(pwd);
		logger.info("Enter password");
		loginPage.clickSubmit();
		logger.info("Clicked on Login Button");

	}

	@Test(dependsOnMethods = "loginCheck")
	public void addEmployee() {
		AddEmployeePage addEmployeePage = new AddEmployeePage(driver);
		addEmployeePage.getElement();
		addEmployeePage.addFirstName(readConfig.getFirstName());
		addEmployeePage.addLastName(readConfig.getLastName());
		addEmployeePage.clickSaveButton();
	}

	@Test(dependsOnMethods = "addEmployee")
	public void personalDetailsPage() {
		PersonalDetailsPage personalDetailsPage = new PersonalDetailsPage(driver);
		personalDetailsPage.editButton();
		personalDetailsPage.genderElement();
		personalDetailsPage.selectDropDown();
	}


	@Test
	public void checkEmployeeStatus() {
		adminTab = new AdminTab(driver);
		adminTab.getAdminElement();
		adminTab.getJobElement();
		adminTab.getEmployeeStatusElement();
		//adminTab.getaddButtonElement();
		//adminTab.getnameElement(readConfig.getGeneralName());
		//adminTab.getSaveButtonElement();
		adminTab.getcheckboxSelect();
		adminTab.getDeleteElement();
	}




}


