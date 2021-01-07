package pages;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import commonUtils.TestBase;

public class LoginPage extends TestBase {
	
	//******************Locators in Login Page*************************//
	
	@FindBy(name="userName") WebElement username;
	@FindBy(name="userPwd") WebElement password;
	@FindBy(xpath="//input[@class='btn']") WebElement loginButton;
	@FindBy(id="userErrMsg") WebElement userErrMsg;
	@FindBy(id="pwdErrMsg") WebElement pwdErrMsg;
	
	
	public LoginPage() throws IOException {
		PageFactory.initElements(driver, this);
		}

	
	//*********************Actions in Login Page**************************//
	
	public String validateLoginPageTitle() {
		return driver.getTitle();
		
	}
	
	public String getUsereErrMsg() {
		loginButton.click();
		return userErrMsg.getText();
	}
	
public String getPwdeErrMsg(String un) {
	  username.sendKeys(un);
	  loginButton.click();
		return pwdErrMsg.getText();
}
	
	public void login (String un, String pwd) throws IOException {
		username.sendKeys(un);
		password.sendKeys(pwd);
		loginButton.click();
		
		
	}


	public void clearFields() {
		username.clear();
		password.clear();

		
	}
	
	
	
}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
