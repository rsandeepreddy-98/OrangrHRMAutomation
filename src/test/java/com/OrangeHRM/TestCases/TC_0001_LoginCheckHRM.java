package com.OrangeHRM.TestCases;

import org.testng.annotations.Test;

import com.OrangeHRM.PageObjects.PIMTab_AddEmployee;
import com.OrangeHRM.PageObjects.PersonalDetailsPage;
import com.OrangeHRM.Utilities.BaseClass;

public class TC_0001_LoginCheckHRM extends BaseClass {
	// private static Logger logger =
	// LogManager.getLogger(TC_0001_LoginCheckHRM.class);
	PIMTab_AddEmployee addEmployeePage;

	@Test
	public void addEmployee() throws InterruptedException {
		addEmployeePage = new PIMTab_AddEmployee(driver); //
		Thread.sleep(2000);

		addEmployeePage.pim_TabElement_click();
		Thread.sleep(3000);

		addEmployeePage.addEmployeeClick();
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
