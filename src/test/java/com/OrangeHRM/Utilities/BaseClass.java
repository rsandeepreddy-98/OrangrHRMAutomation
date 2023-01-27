package com.OrangeHRM.Utilities;

import java.io.File;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.util.List;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import com.OrangeHRM.PageObjects.LoginPage;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass extends DBConnection {
	private static Logger logger = LogManager.getLogger(Listeners.class);
	public static WebDriver driver;
	public LoginPage loginPage;
	ResultSet resultSet;

	protected ReadConfig readConfig = new ReadConfig();
	public String url = readConfig.getApplicationUrl();
	// String uName = readConfig.getUserName();
	// String pwd = readConfig.getPassword();

	List<String> list = DBConnection.returnData();

	@BeforeClass
	public void setUp() throws InterruptedException, ClassNotFoundException, SQLException {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		logger.info("ChromeDriver opened");
		driver.get(url);
		driver.manage().window().maximize();
		loginPage = new LoginPage(driver);
		Thread.sleep(3000);
		// loginPage.getUserName(uName);
		loginPage.getUserName(list.get(0));
		Thread.sleep(2500);
		logger.info("Entered Username");
		Thread.sleep(2500);
		// loginPage.getPassword(pwd);
		loginPage.getPassword(list.get(1));
		Thread.sleep(2500);
		logger.info("Enter password");
		loginPage.clickLogin();
		logger.info("Clicked on Login Button");

	}

	@AfterClass
	public void teardown() {
		driver.quit();
	}
	
	public static String takeScreenshot(String testcaseName) throws IOException {
		TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
		File srcFile = takesScreenshot.getScreenshotAs(OutputType.FILE);
		String destFile = System.getProperty("user.dir")+"./Screenshots//"+testcaseName+".png";
		FileUtils.copyFile(srcFile, new File(destFile));
		return destFile;
		
		
	}

}
