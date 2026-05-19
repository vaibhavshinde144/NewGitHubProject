package org.tests.qa;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class TestWithExtentReports {
	WebDriver driver;
	ExtentSparkReporter spark;
	ExtentReports extent;
	ExtentTest test;
	static SoftAssert soft;
	
	@Test
	public void TC001_GoogleLogin() {
		try {
		soft = new SoftAssert();
		spark = new ExtentSparkReporter("D:\\Java Eclipse\\HybridFramework\\Report\\Extent.html");
		spark.config().setDocumentTitle("Automation Reporting Test");
		spark.config().setReportName("Extent Report1");
		spark.config().setTheme(Theme.STANDARD);
		
		extent = new ExtentReports();
		extent.attachReporter(spark);
		
		test = extent.createTest("TC001_GoogleLogin");
		test.info("Test Start ------------------- TC001");
		
		test.info("Launching the browser--------------");
		driver = new ChromeDriver();
		driver.get("https://www.google.com/");
		test.info("Navigating to google page----------------");
		//soft.assertEquals(driver.getTitle(), "Google11");
		test.info("Title is verified------------------");
		//test.log(Status.PASS, "TC001 is passed");
		//test.log(Status.FAIL, "Test case is failed");
		//test.log(Status.SKIP, "This test case is skipped");
		
		try {
		Assert.assertEquals(driver.getTitle(), "Google12");
		test.log(Status.PASS, "TC001 is passed");
		}
		catch(AssertionError b) {
			test.log(Status.FAIL, "Test case is failed");
		}
		
		//if(driver.getTitle().equals("Google11")) {
			//test.log(Status.PASS, "TC001 is passed");
		//}
		//else {
			//test.log(Status.FAIL, "Test case is failed");
		//}
		extent.flush();
		soft.assertAll();
		driver.quit();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	

}
