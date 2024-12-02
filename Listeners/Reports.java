package Listeners;

import java.io.File;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import TenderCreation.BaseTest;

public class Reports extends BaseTest {

	public static ExtentReports extent;
	public ExtentTest test;

	public static ExtentReports getExtentReportsInstance(String reportName) {
		
		/* --- the first 'if condition' was written to make the extent ref variable as null
		 * because we needed a new report after execution of each test class mentioned in xml
		 * file
		 */
		if(extent!=null)
		{
			extent=null;
		}
		if (extent == null) {
			getExtent(reportName);
			
		}
		
		return extent;
	}
	
	public ExtentTest getExtentTestInstance(String testCaseName, String description) {
		if(test!=null)
		{
			test=null;
		}
		if (test == null) {
			startTest(testCaseName,description);
			
		}
		return test;
	}

	public static ExtentReports getExtent(String ReportName) {
		/*
		 * Create ExtentReports object passing location and report name as argument.
		 * Notice a new Result Log folder will be created inside project and the report
		 * name will be TestReport.html
		 */
		//extent = new ExtentReports(System.getProperty("user.dir") + "/RESULT_LOG" + "/TestReport.html", true);
		extent = new ExtentReports(System.getProperty("user.dir") + File.separator + "src\\main\\resources"
				+ File.separator + "ExtentReports" + File.separator +ReportName+".html", true);
		
		// Add details to our report
		extent.addSystemInfo("Selenium Version", "Value").addSystemInfo("Environment", "UAT");
		return extent;
	}

	// Start Test Case
	public void startTest(String testCaseName, String description) {
		// Create ExtentTest passing test case name and description
		test = extent.startTest(testCaseName, description);
	}

	// Log Test status, Test name and Test details
	public void logStatus(LogStatus testStatus, String testStepName, String testDetails) {
		// Log test status
		test.log(testStatus, testStepName, testDetails);
	}

	// Capture screenshot and log into report
	public void screenshotLog(LogStatus logStatus, String testStepName, String screenShotPath) {
		// Attach screenshots
		test.log(logStatus, testStepName + test.addScreenCapture(screenShotPath));
	}

	// End Test Case
	public void endTest() {
		// End test
		extent.endTest(test);
		extent.flush();
	}

	public static void endReport() {
		extent.close();
	}

}