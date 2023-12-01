package com.auto.tests;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.auto.dataprovider.DataProviderUtils;
import com.auto.pages.CartPage;
import com.auto.pages.CheckOutOverviewPage;
import com.auto.pages.CheckOutPage;
import com.auto.pages.HomePage;
import com.auto.pages.LoginPageV1;
import com.auto.pages.OrderCompletePage;
import com.auto.utils.AutoConfigs;
import com.auto.utils.BaseTestV1;

public class AddToCartTestV3 extends BaseTestV1{
	LoginPageV1 loginPage;
	HomePage homePage;
	CartPage cartPage;
	CheckOutPage checkOutPage;
	CheckOutOverviewPage checkOutOverviewPage;
	OrderCompletePage orderCompletePage;
	
	@BeforeTest
	public void setUp() {
		launchApp(AutoConfigs.application_url);
		loginPage = new LoginPageV1(getDriver());
		homePage = new HomePage(getDriver());
		cartPage = new CartPage(getDriver());
		checkOutPage = new CheckOutPage(getDriver());
		checkOutOverviewPage = new CheckOutOverviewPage(getDriver());
		orderCompletePage = new OrderCompletePage(getDriver());
	}
	
	@Test(dataProviderClass = DataProviderUtils.class,dataProvider = "addToCartTestV3",enabled=true,alwaysRun=true)
	public void addToCartTestV3(String homeTitle,String	productTitle,String	cartTitle,String	coTitle,String	firstName,String	lastName,String	zipCode,
			String cOverviewTitle,String	orderCompleteTitle) throws InterruptedException {
		
		loginPage.loginIntoApplication(AutoConfigs.userName,AutoConfigs.password);
		//Validating the Home Page Title
		String actualTitle = homePage.getHomePageTitle();
		Assert.assertEquals(actualTitle, homeTitle,"Home Page Title is not matching");
		
		String actualPrdTitle =  homePage.getProductTitle();
		Assert.assertEquals(actualPrdTitle, productTitle,"Product Title is not matching");
		
		//clicking on the add to cart button
		homePage.click_on_add_to_cart();
		Thread.sleep(1000);
		//clicking on the cart icon and then it will navigate to cart page
		homePage.click_on_shopping_cart_icon();
	
		
		//validating the Cart Page Title as Your Cart
		String actualCartTitle = cartPage.getCartTitle();
		Assert.assertEquals(actualCartTitle, cartTitle,"Cart Title is not matching");
		
		Thread.sleep(3000);
		
		//Clicking on the checkout button
		cartPage.click_on_checkout_btn();
		
		
		Thread.sleep(3000);
		//validating the Cart Page Title as Your Cart
		String actualCheckOutTitle = checkOutPage.getCheckoutTitle();
		Assert.assertEquals(actualCheckOutTitle, coTitle,"Checkout Title is not matching");
		
		checkOutPage.enter_check_out_details(firstName, lastName, zipCode);

		Thread.sleep(3000);
		
		String actualCheckOutOverViewTitle = checkOutOverviewPage.getCheckoutOverviewTitle();
		
		Assert.assertEquals(actualCheckOutOverViewTitle, cOverviewTitle,"Checkout Over view Title is not matching");
		checkOutOverviewPage.click_on_finish_btn();

		Thread.sleep(3000);
		String actualOrderCompleteTitle = orderCompletePage.getOrderCompleteTitle();
		Assert.assertEquals(actualOrderCompleteTitle, orderCompleteTitle,"order complete Title is not matching");
		
	}
	
	@AfterTest
	public void tearDown() {
		getDriver().close();
	}

}
