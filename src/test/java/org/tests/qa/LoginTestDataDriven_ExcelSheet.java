package org.tests.qa;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.base.qa.BaseTest;
import org.pages.qa.LoginPage;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.utils.qa.ExcelReader;
import org.utils.qa.Log;

public class LoginTestDataDriven_ExcelSheet extends BaseTest {
	LoginPage lp;
	
	public LoginTestDataDriven_ExcelSheet() throws Exception {
		super();
	}
	
	@BeforeMethod
	public void setUp() throws Exception {
		Log.info("Starting the test case execution");
		Log.info("Launching the browser");
		initialization();
		Log.info("Navigating to login page");
		lp = new LoginPage();
	}
	
	@Test(dataProvider = "getData")
	public void TC001_ValidloginTest(String un, String pwd) {
		Log.info("Inputting the username and password");
		lp.login(un, pwd);
		Assert.assertEquals(driver.getTitle(), "Demo Web Shop. Login");
	}

	@DataProvider
	public Object[][] getData() throws EncryptedDocumentException, IOException {
		Object[][] obj = ExcelReader.getExceldata("UserDetails");
		return obj;
	}
	
	@AfterMethod
	public void tearDown() {
		Log.warn("Close the browser");
		driver.quit();
	Log.info("Test case execution is completed");
	}
}
