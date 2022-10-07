package com.OrangeHRM.TestCases;

import org.testng.annotations.Test;

import com.OrangeHRM.PageObjects.PIMTab_AddEmployee;
import com.OrangeHRM.Utilities.ReadConfig;

public class TC_004_PIM_AddEmployee extends BaseClass {
	
	@Test(dependsOnMethods = "loginPageCheck")
	public void addEmployee() throws InterruptedException {
		TC_0001_LoginCheckHRM  tc_0001_LoginCheckHRM = new TC_0001_LoginCheckHRM();
		//tc_0001_LoginCheckHRM.loginPageCheck();
		
		PIMTab_AddEmployee addEmployeePage = new PIMTab_AddEmployee(driver); //
		  Thread.sleep(3000);
		  addEmployeePage.addEmployeeClick(); //
		  Thread.sleep(3000);
		  addEmployeePage.addFirstName(readConfig.getFirstName()); //
		  Thread.sleep(3000);
		  addEmployeePage.addLastName(readConfig.getLastName()); //
		  Thread.sleep(3000);
		  addEmployeePage.clickSaveButton();
	}
}
