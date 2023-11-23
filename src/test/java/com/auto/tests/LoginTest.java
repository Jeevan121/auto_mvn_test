package com.auto.tests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.auto.pages.LoginPage;
import com.auto.utils.BaseTest;



public class LoginTest extends BaseTest {
	
	@BeforeTest
	public void setUp() {
		
		launchApp("https://www.saucedemo.com/");
		waitForElementTobeVisble(getDriver(),getDriver().findElement(By.xpath("//input[@placeholder='Username']")));
			
	}
	
	@Test
	public void loginTest() {
		LoginPage loginPage = new LoginPage(getDriver());
		loginPage.loginIntoApplication("standard_user", "secret_sauce");
		waitForElementTobeVisble(getDriver(), getDriver().findElement(By.xpath("//div[@class='app_logo']")));
		String title = getDriver().findElement(By.xpath("//div[@class='app_logo']")).getText();
		System.out.println("The title of the page is ::"+title);
		Assert.assertEquals(title, "Swag Labs","Home Title not matching");

	}
	
	@AfterTest
	public void tearDown() {
		getDriver().close();
	}
	

}
