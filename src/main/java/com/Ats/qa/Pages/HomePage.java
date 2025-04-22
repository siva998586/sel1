package com.Ats.qa.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.Ats.qa.Base.TestBase;
//import com.Ats.qa.Pages.CandidateListpage;
//import com.Ats.qa.Pages.MyJobPage;
//import com.Ats.qa.Pages.NewCandidatePage;
//import com.Ats.qa.Pages.NewJobPage;


public class HomePage extends TestBase{

	@FindBy(xpath="//span[contains(text(),'Supriyo Sen')]//parent::a[@class='nav-link']")
	WebElement loginuser;
	
	// Main Menu just for click
	@FindBy(xpath="//a[contains(text(),'Job Management')]")
	WebElement JobManagement;
	
	@FindBy(xpath="//a[contains(text(),'New Job')]")  
	WebElement NewJob;
	
	@FindBy(xpath="//a[contains(text(),'My Job')]")  
	WebElement MyJob;
	
	@FindBy(xpath="//a[contains(text(),'Talent Management')]")
	WebElement Talentmanagement;
	
	
	@FindBy(xpath="//a[contains(text(),'New Candidate')]")
	WebElement NewCandidate;
	
	
	@FindBy(xpath="//a[contains(text(),'Candidate List')]")
	WebElement ViewCandidate;
	
	
	
	public HomePage() {
		PageFactory.initElements(driver, this);
	}

	public String verifyHomePageTitle() {
		return driver.getTitle();
	}
	
	public String verifyLoggedinuser() {
		return loginuser.getText();
	}
	
	public void expandJobManagement() {
		JobManagement.click();
	}
	
	public NewJobPage validateNewJobPage() {
		JobManagement.click();
		NewJob.click();
		return new NewJobPage();
	}
	
	public MyJobPage validateMyJobPage() {
		JobManagement.click();
		MyJob.click();
		return new MyJobPage();
	}
	
	public void expandTalentManagement() {
		Talentmanagement.click();
	}
	
	public NewCandidatePage addNewCandidate() {
		Talentmanagement.click();
		NewCandidate.click();
		return new NewCandidatePage();
	}
	
	public CandidateListpage validateCandidateList() {
		Talentmanagement.click();
		ViewCandidate.click();
		return new CandidateListpage();
		
	}
	
}
