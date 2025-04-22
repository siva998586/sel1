package com.Ats.qa.Testcase;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.*;

import com.Ats.qa.Base.TestBase;
import com.Ats.qa.Pages.HomePage;
import com.Ats.qa.Pages.LoginPage;
import com.Ats.qa.Util.CommonFeature;



public class LoginPageTest extends TestBase {
	
	public static LoginPage logintest;
	public static HomePage Homepage;
	String sheetname = "Login";
	
	public LoginPageTest() {
		super();
	}
	
	@BeforeMethod
	public void setup() {
		initilization();
		 logintest = new LoginPage();
	}
	
	@DataProvider(name = "Login")
	public Object [][] VerifyLogindata() {
		Object [][] verifylogin = CommonFeature.getTestData(sheetname);
		return verifylogin;
	}
	
	
	@Test(priority = 1)
	public void verifyTitleTest() {
		String title = logintest.verifyTitle();
		Assert.assertEquals(title, "AT Application","ATS Title does not Match");
	}
	@Test(priority = 2)
	public void verifylogoTest() {
		boolean logo = logintest.verifylogo();
		Assert.assertTrue(logo);
	}
	
	@Test (priority = 3, dataProvider = "Login")
	public void LoginValidation(String uname, String pword) throws InterruptedException {
		
		logintest.verifyloginpage(uname, pword);
		Thread.sleep(2000);
		
	}
	
	@Test(priority = 4)
	public void loginTest() throws InterruptedException {
		Homepage = logintest.verifyloginpage(prop.getProperty("username"), prop.getProperty("password"));
		Thread.sleep(5000);
		
	}
	
	@AfterMethod
	public void Teardown() throws IOException {
		CommonFeature.captureFailedScreenshot(driver,"Issue");
		CommonFeature.capturePassedScreenshot();
		driver.quit();
	}

}
