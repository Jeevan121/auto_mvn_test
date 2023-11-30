package com.auto.tests;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.auto.dataprovider.DataProviderUtils;
import com.auto.pages.HomePage;
import com.auto.pages.LoginPageV1;
import com.auto.utils.BaseTestV1;




public class LoginTestV3 extends BaseTestV1 {
	LoginPageV1 loginPage;
	HomePage homePage;
	
	@BeforeMethod
	public void setUp() {
		
		launchApp("https://www.saucedemo.com/");
	    loginPage = new LoginPageV1(getDriver());
	    homePage = new HomePage(getDriver());

	}

	@Test(dataProviderClass = DataProviderUtils.class,dataProvider = "loginTestV3",enabled=true,alwaysRun=true)
	public void loginTestV3(String userName,String	password,String expected_title) {
		
		loginPage.loginIntoApplication(userName, password);
		String title = getBasePage().get_text(homePage.title);
		System.out.println("The title of the page is ::"+title);
		Assert.assertEquals(title, expected_title,"Home Title not matching");

	}
	
	@AfterMethod
	public void tearDown() {
		getDriver().close();
	}
	

}
