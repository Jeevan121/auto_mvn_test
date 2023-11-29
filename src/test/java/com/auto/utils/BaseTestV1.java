package com.auto.utils;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BaseTestV1 {
	
	WebDriver driver;
	public WebDriver launchApp(String url) {
		System.setProperty("webdriver.chrome.driver","D:\\auto_test_demo\\auto-bots\\driver\\chromedriver.exe");
	    driver = new ChromeDriver();
		driver.get(url);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		return driver;
	}
	
	public WebDriver getDriver() {
		return driver;
	}
	
	BasePage basePage= null;
	public BasePage getBasePage() {
		    if(basePage == null) {
		      basePage = new BasePage(getDriver());
		    }
		    return basePage;
	}
	 

	
}
