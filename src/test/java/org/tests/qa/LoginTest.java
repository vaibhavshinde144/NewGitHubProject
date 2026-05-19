package org.tests.qa;

import org.base.qa.BaseTest;
import org.pages.qa.LoginPage;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {
	LoginPage lp;
	
	public LoginTest() throws Exception {
		super();
	}
	
	@BeforeMethod
	public void setUp() throws Exception {
		initialization();
		lp = new LoginPage();
	}
	
	@Test(dataProvider = "getData")
	public void TC001_ValidloginTest(String un, String pwd) {
		lp.login(un, pwd);
		Assert.assertEquals(driver.getTitle(), "Demo Web Shop. Login");
	}

	@DataProvider
	public Object[][] getData() {
		Object[][] obj = new Object[2][2];
		obj[0][0] = "Admin";
		obj[0][1] = "admin123";
		obj[1][0] = "vaibhav.shinde144@gmail.com";
		obj[1][1] = "vs@12345";
		return obj;
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	
	
	

}
