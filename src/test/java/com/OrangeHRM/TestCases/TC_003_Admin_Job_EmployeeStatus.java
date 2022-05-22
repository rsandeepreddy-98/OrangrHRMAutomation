package com.OrangeHRM.TestCases;

import org.testng.annotations.Test;

import com.OrangeHRM.PageObjects.AdminTab;

public class TC_003_Admin_Job_EmployeeStatus extends BaseClass{
	public AdminTab adminTab;


	@Test(groups = {"Functional"})
	public void checkEmployeeStatus() {
		adminTab = new AdminTab(driver);
		adminTab.getAdminElement();
		adminTab.getJobElement();
		adminTab.getEmployeeStatusElement();
	}
}
