package com.test.utils;
import java.io.IOException;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.test.constants.SourcePath;

public class GenerateReport {

	public static ExtentHtmlReporter htmlReporter;
	public static ExtentReports extent;
	public static ExtentTest extentTest;
	private static GenerateReport ob;

	private GenerateReport() {
	}

	public static GenerateReport getInstance() {
		if (ob == null) {
			ob = new GenerateReport();
		}
		return ob;
	}

	public void startExtentReports() {
		htmlReporter = new ExtentHtmlReporter(SourcePath.GENERATE_REPORT_PATH);
		extent = new ExtentReports();
        extent.attachReporter(htmlReporter);
		extent.setSystemInfo("Host Name", "DummyAPI");
		extent.setSystemInfo("Environment", "Dummy APITesting");
		extent.setSystemInfo("User Name", "Helen");
        htmlReporter.config().setDocumentTitle("Test Execution Report");
		htmlReporter.config().setReportName("Api tests");
		htmlReporter.config().setTheme(Theme.STANDARD);
	}

	public void startSingleTestReport(String testname) {
		extentTest = extent.createTest(testname);
	}

	public void logTestInfo(String message) {
		extentTest.log(Status.INFO, message);
	}

	public void logTestPassed(String testcasename) {
		extentTest.log(Status.PASS, MarkupHelper.createLabel(testcasename + "is passTest", ExtentColor.GREEN));
	}

	public void logTestFailed(String testcasename) {
		extentTest.log(Status.FAIL, MarkupHelper.createLabel(testcasename + "is not passTest", ExtentColor.RED));
	}

	public void logTestFailedWithException(Exception e) {
		extentTest.log(Status.ERROR, e);
	}

	public void logTestSkipped(String testcasename) {
		extentTest.log(Status.SKIP, MarkupHelper.createLabel(testcasename + "is not passTest", ExtentColor.RED));
	}

	public void logScreenshotCapture(String path, String message) {
		try {
			extentTest.addScreenCaptureFromPath(path, message);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("not able to add screenshort to extent report");
		}
	}

	public void endReport() {
		extent.flush();
	}

}

