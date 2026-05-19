package org.tests.qa;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import org.utils.qa.Log;

public class ReportingLog4JTest{
	
	
	@Test
	public void TC001_loginTest() {
		Log.info("Login test is started");
		
		Log.info("Launching the browser");
		WebDriver driver = new ChromeDriver();
		
		Log.info("Navigating to login page");
		driver.get("https://demowebshop.tricentis.com/login/");
		
		String actualTitle = driver.getTitle();
		
		if(actualTitle.equals("Demo Web Shop. Login1")) {
			Log.info("Login page is displayed");
		} else {
			Log.error("Login page is not displayed");
		}
	
		Log.warn("Close the browser");
		driver.quit();
		
	}
	
	

}
