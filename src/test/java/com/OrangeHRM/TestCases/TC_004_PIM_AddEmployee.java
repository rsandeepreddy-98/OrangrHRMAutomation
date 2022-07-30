package com.OrangeHRM.TestCases;

import org.testng.annotations.Test;

import com.OrangeHRM.PageObjects.PIMTab_AddEmployee;
import com.OrangeHRM.Utilities.ReadConfig;

public class TC_004_PIM_AddEmployee extends BaseClass {
	
	@Test(dependsOnMethods = "loginPageCheck")
	public void addEmployee() {
		TC_0001_LoginCheckHRM  tc_0001_LoginCheckHRM = new TC_0001_LoginCheckHRM();
		tc_0001_LoginCheckHRM.loginPageCheck();
		PIMTab_AddEmployee addEmployeePage = new PIMTab_AddEmployee(driver);
		addEmployeePage.getElement();
		addEmployeePage.addFirstName(readConfig.getFirstName());
		addEmployeePage.addLastName(readConfig.getLastName());
		addEmployeePage.clickSaveButton();
	}
}
