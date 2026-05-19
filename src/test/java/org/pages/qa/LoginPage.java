package org.pages.qa;

import org.base.qa.BaseTest;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends BaseTest{
	@FindBy(id = "Email")
	private WebElement userName;
	
	@FindBy(id = "Password")
	private WebElement password;
	
	@FindBy(xpath = "//input[@type='submit' and @value='Log in']")
	private WebElement loginBtn;
	
	public LoginPage() throws Exception {
		PageFactory.initElements(driver, this);
	}
	
	public void login(String un, String pwd) {
		userName.sendKeys(un);
		password.sendKeys(pwd);
		loginBtn.click();
	}
}
