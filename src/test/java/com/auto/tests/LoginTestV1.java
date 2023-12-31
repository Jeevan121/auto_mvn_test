package com.auto.tests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.auto.pages.HomePage;
import com.auto.pages.LoginPage;
import com.auto.pages.LoginPageV1;
import com.auto.utils.BaseTest;
import com.auto.utils.BaseTestV1;



public class LoginTestV1 extends BaseTestV1 {
	LoginPageV1 loginPage;
	HomePage homePage;
	@BeforeTest
	public void setUp() {
		
		launchApp("https://www.saucedemo.com/");
	    loginPage = new LoginPageV1(getDriver());
	    homePage = new HomePage(getDriver());
		//waitForElementTobeVisble(getDriver(),getDriver().findElement(By.xpath("//input[@placeholder='Username']")));
		//getBasePage().waitForElementTobeVisble(getDriver(), getDriver().findElement(By.xpath("//input[@placeholder='Username']")));
	    getBasePage().waitForElementTobeVisble(getDriver(), loginPage.userNameTxt);
	}
	
	@Test
	public void loginTest() {
		
		loginPage.loginIntoApplication("standard_user", "secret_sauce");
		//waitForElementTobeVisble(getDriver(), getDriver().findElement(By.xpath("//div[@class='app_logo']")));
		getBasePage().waitForElementTobeVisble(getDriver(), homePage.title);
		//String title = getDriver().findElement(By.xpath("//div[@class='app_logo']")).getText();
		String title = getBasePage().get_text(homePage.title);
		System.out.println("The title of the page is ::"+title);
		Assert.assertEquals(title, "Swag Labs","Home Title not matching");

	}
	
	@AfterTest
	public void tearDown() {
		getDriver().close();
	}
	

}
