package com.Ats.qa.Testcase;

import org.testng.Assert;
import org.testng.annotations.*;

import com.Ats.qa.Base.TestBase;
import com.Ats.qa.Pages.HomePage;
import com.Ats.qa.Pages.LoginPage;
import com.Ats.qa.Pages.MyJobPage;
import com.Ats.qa.Pages.NewJobPage;


public class HomePageTest extends TestBase {

	public static HomePage Homepage;
	public static LoginPage logintest;
	public static NewJobPage NewJob;
	public static MyJobPage MyJob;
	
	
	public HomePageTest() {
		super();
	}

	@BeforeMethod
	public void setup() {
		initilization();
		logintest = new LoginPage();
		NewJob = new NewJobPage();
		MyJob = new MyJobPage();
		Homepage = new HomePage();
		Homepage = logintest.verifyloginpage(prop.getProperty("username"), prop.getProperty("password"));
	}
	
	@Test(priority = 1)
	public void HomePageTitleTest() {
		String Hometitle =Homepage.verifyHomePageTitle();
		Assert.assertEquals(Hometitle, "ATS Applicatio", "Home page Title not Match");
	}
	@Test(priority = 2)
	public void LoggedinUserTest() {
		String LoggedUserName = Homepage.verifyLoggedinuser();
		Assert.assertEquals(LoggedUserName, "Supriyo Se", "Login User does not Match");
	}
	
	@Test(priority = 3)
	public void NewJobPageTest() {
		Homepage.expandJobManagement();
		NewJob = Homepage.validateNewJobPage();
		
	}
	
	@Test(priority = 4)
	public void MyJobPageTest() {
		Homepage.expandJobManagement();
		MyJob = Homepage.validateMyJobPage();
	}
	
	
	

	@AfterMethod
	public void Teardown() {
		driver.quit();
	}
	
}
