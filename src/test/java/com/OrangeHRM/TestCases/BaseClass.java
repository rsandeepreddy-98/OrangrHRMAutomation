package com.OrangeHRM.TestCases;


import java.sql.ResultSet;
import java.sql.SQLException;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import com.OrangeHRM.PageObjects.LoginPage;
import com.OrangeHRM.Utilities.DBConnection;
import com.OrangeHRM.Utilities.Listeners;

import com.OrangeHRM.Utilities.ReadConfig;

public class BaseClass extends DBConnection{
	private static Logger logger = LogManager.getLogger(Listeners.class);
	public  WebDriver driver;
	public 	LoginPage loginPage;
	ResultSet resultSet ;

	ReadConfig readConfig = new ReadConfig();
	String  url = readConfig.getApplicationUrl();
	//String  uName = readConfig.getUserName();
	//String pwd = readConfig.getPassword();
	
	List<String> list = DBConnection.returnData();
	
	@BeforeClass
	public void setUp() throws InterruptedException, ClassNotFoundException, SQLException {
		System.setProperty("webdriver.chrome.driver", readConfig.getPath());
		driver = new ChromeDriver();
		logger.info("ChromeDriver opened");
		driver.get(url);
		loginPage = new LoginPage(driver);
		Thread.sleep(3000);
		//loginPage.getUserName(uName);
		loginPage.getUserName(list.get(0));
		Thread.sleep(2500);
		logger.info("Entered Username");
		Thread.sleep(2500);
		//loginPage.getPassword(pwd);
		loginPage.getPassword(list.get(1));
		Thread.sleep(2500);
		logger.info("Enter password");
		loginPage.clickLogin();
		logger.info("Clicked on Login Button");
		Thread.sleep(2500);
	}

	@AfterClass
	public void teardown() {
		driver.quit();
	}
	
	

}
