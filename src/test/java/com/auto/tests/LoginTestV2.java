package com.auto.tests;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import com.auto.pages.HomePage;
import com.auto.pages.LoginPageV1;
import com.auto.utils.BaseTestV1;



public class LoginTestV2 extends BaseTestV1 {
	LoginPageV1 loginPage;
	HomePage homePage;
	
	@BeforeTest
	public void setUp() {
		
		launchApp("https://www.saucedemo.com/");
	    loginPage = new LoginPageV1(getDriver());
	    homePage = new HomePage(getDriver());

	}
	
	@Test
	public void loginTest() {
		
		loginPage.loginIntoApplication("standard_user", "secret_sauce");
		String title = getBasePage().get_text(homePage.title);
		System.out.println("The title of the page is ::"+title);
		Assert.assertEquals(title, "Swag Labs","Home Title not matching");

	}
	
	@AfterTest
	public void tearDown() {
		getDriver().close();
	}
	

}
