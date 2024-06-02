package utilities;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import testBase.BaseClass;

public class ExtentReportManager implements ITestListener{
	
	public ExtentSparkReporter sparkreporter;
	public ExtentReports extent;
	public ExtentTest test;
	String repName;
	public WebDriver driver;
	
	public void onStart(ITestContext context) {
		String timestamp=new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
		repName="Test-Report-"+timestamp+".html";
		
		sparkreporter=new ExtentSparkReporter(".\\Reports\\"+repName);
		sparkreporter.config().setDocumentTitle("Automation testing");
		sparkreporter.config().setReportName("Smoke Test");
		sparkreporter.config().setTheme(Theme.DARK);
		
		extent =new ExtentReports();
		extent.attachReporter(sparkreporter);
		extent.setSystemInfo("computer name", "localhost");
		extent.setSystemInfo("Environment", "QA");
		extent.setSystemInfo("Testrname","vamshi");
		extent.setSystemInfo("OS", "Windows 10");
		extent.setSystemInfo("Browser", "chrome");		
	}
	public void onTestSuccess(ITestResult result) {
		
		test=extent.createTest(result.getName());
		test.log(Status.PASS, "Test is passed:"+result.getName());
		System.out.println("test is passed");
		
		
	}
	public void onTestFailure(ITestResult result) {
		test=extent.createTest(result.getName());
		test.log(Status.FAIL, "Test is failed:"+result.getName());
		test.log(Status.FAIL, "Test is failed:"+result.getThrowable());
		System.out.println("test is failed");
		try {
			String image=new BaseClass().captureScreen(result.getName());
			test.addScreenCaptureFromPath(image);
			
		}catch(Exception e2) {
			e2.printStackTrace();
		}
	}
	public void onTestSkipped(ITestResult result) {
		test=extent.createTest(result.getName());
		test.log(Status.SKIP, "Test is skipped:"+result.getName());
		test.log(Status.SKIP, "Test is skipped:"+result.getThrowable());
		try {
			String imgpath=new BaseClass().captureScreen(result.getName());
			test.addScreenCaptureFromPath(imgpath);
			
		}catch(Exception e3) {
			e3.printStackTrace();
		}
	}
	public void onFinish(ITestContext context) {
		extent.flush();
	}
}
