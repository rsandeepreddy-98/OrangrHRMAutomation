package com.OrangeHRM.Utilities;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class Reporting {

		public static ExtentReports extentReports;
		
		public static ExtentReports getExtentReports() {
		String pathString = System.getProperty("user.dir")+"./reports//index.html";
		ExtentSparkReporter extentSparkReporter = new ExtentSparkReporter(pathString);
		extentSparkReporter.config().setReportName("OrangeHRM Report");
		extentSparkReporter.config().setDocumentTitle("Automation HRM");
		
		extentReports = new ExtentReports();
		extentReports.attachReporter(extentSparkReporter);
		extentReports.setSystemInfo("Tester", "Sandeep");
		
		return extentReports;
		}
}
