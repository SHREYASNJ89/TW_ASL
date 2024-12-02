package Listeners;


import java.io.File;
import java.io.IOException;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.testng.IResultMap;
import org.testng.ISuite;
import org.testng.ISuiteResult;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.xml.XmlSuite;


import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;


public class ExtentReportTestNG 
//extends BaseTest  implements org.testng.IReporter
{


public ExtentReports extent;
public ExtentTest test;
// HTMLReporter htmlreporter;
WebDriver driver;



public  void generateReport(List<XmlSuite> xmlsuites,List<ISuite>suites,String outputDirectory)
{
extent=new ExtentReports(System.getProperty("user.dir")+ "/test-output/Antares.ForwardAuction.html",true);
extent=new ExtentReports(outputDirectory+File.separator+"Antares.ForwardAuction.html",true);
// htmlreporter=new HTMLReporter(System.getProperty("user.dir")+"/test-output/Xpitax.html");
//extent.attachReporter(htmlreporter);

//
// extent.attachreporter(htmlreporter);

//ExtentHtmlReporter reporter=new ExtentHtmlReporter(System.getProperty("user.dir")+ "/test-output/Xpitax.Reports.html");
//com.aventstack.extentreports.ExtentReports extent=new com.aventstack.extentreports.ExtentReports();
//extent.attachReporter(reporter);


for(ISuite suite:suites)
{
Map<String,ISuiteResult>result=suite.getResults();
for(ISuiteResult r:result.values())
{
ITestContext context=r.getTestContext();
try {
buildTestNodes(context.getPassedTests(),LogStatus.PASS);
} catch (IOException e) {
// TODO Auto-generated catch block
e.printStackTrace();
}
try {
buildTestNodes(context.getFailedTests(),LogStatus.FAIL);
} catch (IOException e) {
// TODO Auto-generated catch block
e.printStackTrace();
}

try {
buildTestNodes(context.getSkippedTests(),LogStatus.SKIP);
} catch (IOException e) {
// TODO Auto-generated catch block
e.printStackTrace();
}
}
}
extent.flush();
extent.close();
}
private void buildTestNodes(IResultMap tests,LogStatus status) throws IOException
{


if(tests.size()>0)
{
for(ITestResult result:tests.getAllResults())
{
test=extent.startTest(result.getMethod().getMethodName());
test.setStartedTime(getTime(result.getStartMillis()));
test.setEndedTime(getTime(result.getEndMillis()));

for(String group: result.getMethod().getGroups())
test.assignCategory(group);
if(result.getThrowable()!=null)
{

  test.log(LogStatus.FAIL, result.getName());
test.log(LogStatus.FAIL, result.getThrowable());
//test.log(LogStatus.FAIL, test.addScreenCapture("D:\\New folder\\eclipse-dsl-neon-3-win32-x86_64\\eclipse\\Reports\\Screenshots\\validate_UserReports_IssuePoints_Open.png"));
     //test.log(LogStatus.FAIL, test.addScreenCapture(BaseTest.screenshotpath));

//test.log(LogStatus.FAIL, test.addScreenCapture(b1.screenshotpath));
//test.log(LogStatus.FAIL, test.addScreenCapture(("user.dir")+ "/Screenshots/" + result.getTestName()+ ".png"));

//test.log(LogStatus.FAIL, extent.ad);
//test.log(LogStatus.FAIL, test.addScreenCapture(imagePath)
//test.log(LogStatus.FAIL, test.addScreenCapture(GetScreenShot.capturescreenshot(driver, "screenshotpath")));
}
else
{
test.log(status, "Test"+status.toString().toLowerCase()+"ed");
}
extent.endTest(test);
}
}
}
private Date getTime(long mills) 
{
	Calendar calendar=Calendar.getInstance();
	calendar.setTimeInMillis(mills);
	return calendar.getTime();
/*{
	// TODO Auto-generated method stub
	return null;
}*/
}
}