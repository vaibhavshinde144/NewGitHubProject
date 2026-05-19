package org.tests.qa;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentReport3 {
	WebDriver driver;
	ExtentSparkReporter spark;
	ExtentReports extent;
	ExtentTest test;
	
	@BeforeSuite
	public void setup() {
		spark = new ExtentSparkReporter("D:\\Java Eclipse\\HybridFramework\\Report\\Extent3.html");
		spark.config().setDocumentTitle("Automation Testing Report");
		spark.config().setReportName("Internet Site Automation Report");
		spark.config().setTheme(Theme.DARK);
		
		extent = new ExtentReports();
		extent.attachReporter(spark);
	}
	
	@BeforeMethod
	public void browsersetup() {
		driver = new ChromeDriver();
		driver.get("https://the-internet.herokuapp.com/");
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
	}
	
	@Test
	public void TC001_ABTesting() {
		test = extent.createTest("TC001_A/BTesting");
		driver.findElement(By.linkText("A/B Testing")).click();
		try {
			Assert.assertEquals(driver.getCurrentUrl(), "https://the-internet.herokuapp.com/abtest");
			test.log(Status.PASS, "TC001 is passed");
		}
		catch(AssertionError a) {
			test.log(Status.FAIL, "TC001 is failed");
		}
	}
	
	@Test
	public void TC002_DisappearingElements() {
		try {
		test = extent.createTest("TC002_Disappearing Elements");
		driver.findElement(By.linkText("Disappearing Elements")).click();
		driver.findElement(By.linkText("Gallery")).click();
		try {
			Assert.assertEquals(driver.getCurrentUrl(), "https://the-internet.herokuapp.com/gallery/");
			test.log(Status.PASS, "TC002 is passed");
		}
		catch(AssertionError b) {
			test.log(Status.FAIL, "TC002 is failed");
		}
		}
		catch(Exception e) {
			e.printStackTrace();
			test.log(Status.SKIP, "TC002 is skipped");
		}
		
	}
	
	@Test
	public void TC003_Checkbox() {
		test=extent.createTest("TC003_Checkbox");
		driver.findElement(By.linkText("Checkboxes")).click();
		WebElement checkbox = driver.findElement(By.xpath("//form[@id='checkboxes']/input[1]"));
		if(checkbox.isSelected()) {
			test.log(Status.PASS, "TC003 is passed");
		}
		else {
			test.log(Status.FAIL, "TC003 is failed");
		}
	}
	
	@AfterMethod
	public void teardown() {
		driver.quit();
	}
	
	@AfterSuite
	public void end() {
		extent.flush();
	}
		
		
	}
