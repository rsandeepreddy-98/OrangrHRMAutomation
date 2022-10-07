package com.OrangeHRM.TestCases;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.Test;

import com.OrangeHRM.PageObjects.LoginPage;
import com.OrangeHRM.Utilities.ExcelReader;

public class TC_002_DataProvider extends BaseClass {
	private static Logger logger = LogManager.getLogger(TC_0001_LoginCheckHRM.class);
	public 	LoginPage loginPage;

	@Test(dataProvider = "getData",dataProviderClass = ExcelReader.class)
	public void dataProvideLoginCheck(String username,String password) {
		driver.get(url);
		loginPage = new LoginPage(driver);
		loginPage.getUserName(username);
		logger.info("Entered Username");
		loginPage.getPassword(password);
		logger.info("Enter password");
		loginPage.clickLogin();
		logger.info("Clicked on Login Button");
		
		
	}
}
