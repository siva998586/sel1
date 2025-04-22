package com.Ats.qa.Base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import com.Ats.qa.Util.CommonFeature;
//import com.Ats.qa.Util.WebEventListener;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestBase {

	public static Properties prop;
	public static WebDriver driver;
	EventFiringWebDriver eventdriver;
	// WebEventListener eventlistener;

	public TestBase() {

		try {
			prop = new Properties();
			FileInputStream ip = new FileInputStream(
					"C:\\Users\\Supriyo Sen\\eclipse-workspace\\ATS\\src\\main\\java\\com\\Ats\\qa\\Config\\Ats.properties");
			prop.load(ip);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void initilization() {

		String browser = prop.getProperty("Browser");

		if (browser.equalsIgnoreCase(browser)) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		} else if (browser.equalsIgnoreCase(browser)) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();

		} else if (browser.equalsIgnoreCase(browser)) {
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
		}

		
//		 eventdriver = new EventFiringWebDriver(driver); 
//		 eventlistener = newWebEventListener(); 
//		 eventdriver.register(eventlistener); driver = eventdriver;
//		

		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(CommonFeature.Imp_wait, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(CommonFeature.Page_load, TimeUnit.SECONDS);
		driver.manage().deleteAllCookies();
		driver.get(prop.getProperty("url"));
	}

}
