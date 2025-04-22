package com.Ats.qa.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.Ats.qa.Base.TestBase;
//import com.Ats.qa.Pages.HomePage;


public class LoginPage extends TestBase{

	@FindBy(id="email")
	WebElement uname;

	@FindBy(id="password")
	WebElement pword;
	
	@FindBy(id="loginBtn")
	WebElement loginbt;
	
	@FindBy(xpath="//span[@class='ui-chkbox-icon ui-c']")
	WebElement PwReminder;
	
	@FindBy(xpath="//div[contains(@class,'company_login_logo')]")
	WebElement Atslogo;
	
	public LoginPage() {
		PageFactory.initElements(driver, this);
		
	}

	public String verifyTitle() {
		return driver.getTitle();
	}
	
	public boolean verifylogo() {
		return Atslogo.isDisplayed();
	}
	
	public  HomePage verifyloginpage(String un, String pw) {
		uname.clear();
		uname.sendKeys(un);
		pword.clear();
		pword.sendKeys(pw);
		loginbt.click();
		return new HomePage();
	}
	
}
