package com.OrangeHRM.TestCases;

import java.util.concurrent.TimeUnit;

import javax.sound.midi.VoiceStatus;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;

import com.OrangeHRM.Utilities.Listeners;
import com.OrangeHRM.Utilities.ReadConfig;

public class BaseClass {
	private static Logger logger = LogManager.getLogger(Listeners.class);
	public WebDriver driver;

	ReadConfig readConfig = new ReadConfig();
	String  url = readConfig.getApplicationUrl();
	String  uName = readConfig.getUserName();
	String pwd = readConfig.getPassword();


	@BeforeClass
	public void setUp() {
		System.setProperty("webdriver.chrome.driver", readConfig.getPath());
		driver = new ChromeDriver();
		logger.info("ChromeDriver opened");
		driver.get(url);
	}

	@AfterClass
	public void teardown() {
		driver.quit();
	}


}
