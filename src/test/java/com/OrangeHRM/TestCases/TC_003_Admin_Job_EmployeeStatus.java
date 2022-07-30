package com.OrangeHRM.TestCases;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.Test;

import com.OrangeHRM.PageObjects.AdminTab;
import com.OrangeHRM.PageObjects.LoginPage;

public class TC_003_Admin_Job_EmployeeStatus extends BaseClass{
	private static Logger logger = LogManager.getLogger(TC_0001_LoginCheckHRM.class);

	public AdminTab adminTab;
	public 	LoginPage loginPage;
	@Test
	public void loginPageCheck() {

		loginPage = new LoginPage(driver);
		loginPage.getUserName(uName);
		logger.info("Entered Username");
		loginPage.getPassword(pwd);
		logger.info("Enter password");
		loginPage.clickSubmit();
		logger.info("Clicked on Login Button");

	}
	
	@Test
	public void checkEmployeeStatus() {
		adminTab = new AdminTab(driver);
		adminTab.getAdminElement();
		adminTab.getJobElement();
		adminTab.getEmployeeStatusElement();
	}
}
