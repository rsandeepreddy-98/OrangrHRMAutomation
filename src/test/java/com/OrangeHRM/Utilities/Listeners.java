package com.OrangeHRM.Utilities;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

public class Listeners extends BaseClass implements ITestListener{

	private static Logger logger = LogManager.getLogger(Listeners.class);
	ExtentTest test;
	ExtentReports extent = Reporting.getExtentReports();
	ThreadLocal<ExtentTest> threadLocal = new ThreadLocal<ExtentTest>();
	@Override
	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		test=extent.createTest(result.getMethod().getMethodName());
		threadLocal.set(test);
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
				
		
	}

	@Override
	public void onTestFailure(ITestResult result) {
		// TODO Auto-generated method stub
		logger.error(result.getMethod().getMethodName());
		threadLocal.get().fail(result.getThrowable());
		String testmethodName = result.getMethod().getMethodName();
		try {
			takeScreenshot(testmethodName);
			threadLocal.get().addScreenCaptureFromPath(takeScreenshot(testmethodName), result.getMethod().getMethodName());
		} catch (Exception e) {
			System.out.println("Error");
		}
		
	}

	
	@Override
	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		extent.flush();
	}

}
