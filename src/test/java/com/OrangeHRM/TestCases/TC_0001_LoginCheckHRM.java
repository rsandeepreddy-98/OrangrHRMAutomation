package com.OrangeHRM.TestCases;



import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import org.testng.annotations.Test;

import com.OrangeHRM.PageObjects.PIMTab_AddEmployee;
import com.OrangeHRM.PageObjects.AdminTab;
import com.OrangeHRM.PageObjects.LoginPage;
import com.OrangeHRM.PageObjects.PersonalDetailsPage;

import com.OrangeHRM.Utilities.ReadConfig;

public class TC_0001_LoginCheckHRM extends BaseClass {
	private static Logger logger = LogManager.getLogger(TC_0001_LoginCheckHRM.class);

	public LoginPage loginPage;
	public ReadConfig readConfig = new ReadConfig();
	public AdminTab adminTab;

	@Test
	public void addEmployee() throws InterruptedException {
		PIMTab_AddEmployee addEmployeePage = new PIMTab_AddEmployee(driver); //
		Thread.sleep(3000);
		addEmployeePage.addEmployeeClick(); //
		Thread.sleep(3000);
		addEmployeePage.addFirstName(readConfig.getFirstName()); //
		Thread.sleep(3000);
		addEmployeePage.addLastName(readConfig.getLastName()); //
		Thread.sleep(3000);
		addEmployeePage.clickSaveButton();
		Thread.sleep(2500);
	}

	@Test(dependsOnMethods = "addEmployee")
	public void personalDetailsPage() {
		PersonalDetailsPage personalDetailsPage = new PersonalDetailsPage(driver);
		personalDetailsPage.editButton();
		personalDetailsPage.genderElement();
		personalDetailsPage.selectDropDown();
	}

	
	

}
