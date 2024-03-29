package com.OrangeHRM.TestCases;


import org.testng.annotations.Test;

import com.OrangeHRM.PageObjects.AdminTab;
import com.OrangeHRM.PageObjects.LoginPage;
import com.OrangeHRM.Utilities.BaseClass;

public class TC_003_Admin_Job_EmployeeStatus extends BaseClass{
	//private static Logger logger = LogManager.getLogger(TC_0001_LoginCheckHRM.class);

	public AdminTab adminTab;
	public 	LoginPage loginPage;
	
	
	
	@Test
	public void adminEmployeeStatus() throws InterruptedException {
		adminTab = new AdminTab(driver);
		Thread.sleep(3000);
		adminTab.clickAdminElement();
		Thread.sleep(2500);
		adminTab.getJobElement();
		Thread.sleep(2500);
		adminTab.getEmployeeStatusElement();
		Thread.sleep(2500);
		adminTab.getaddButtonElement();
		Thread.sleep(2500);
		adminTab.getnameElement(readConfig.getGeneralName());
		Thread.sleep(2500);
		if (driver.getPageSource().contains("Already exists")) {
			adminTab.cancelButton();
		}
		else {
		adminTab.getSaveButtonElement();
		Thread.sleep(3000);
		}
	}
}
