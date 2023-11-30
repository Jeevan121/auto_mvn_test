package com.auto.tests;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import com.auto.pages.CartPage;
import com.auto.pages.CheckOutOverviewPage;
import com.auto.pages.CheckOutPage;
import com.auto.pages.HomePage;
import com.auto.pages.LoginPageV1;
import com.auto.pages.OrderCompletePage;
import com.auto.utils.BaseTestV1;

public class AddToCartTestV1 extends BaseTestV1{
	LoginPageV1 loginPage;
	HomePage homePage;
	CartPage cartPage;
	CheckOutPage checkOutPage;
	CheckOutOverviewPage checkOutOverviewPage;
	OrderCompletePage orderCompletePage;
	
	@BeforeTest
	public void setUp() {
		launchApp("https://www.saucedemo.com/");
		loginPage = new LoginPageV1(getDriver());
		homePage = new HomePage(getDriver());
		cartPage = new CartPage(getDriver());
		checkOutPage = new CheckOutPage(getDriver());
		checkOutOverviewPage = new CheckOutOverviewPage(getDriver());
		orderCompletePage = new OrderCompletePage(getDriver());
	}
	
	@Test
	public void addToCartTest() throws InterruptedException {
		
		loginPage.loginIntoApplication("standard_user", "secret_sauce");
		
		//Validating the Home Page Title
		String actualTitle = getBasePage().get_text(homePage.title);
		Assert.assertEquals(actualTitle, "Swag Labs","Home Page Title is not matching");
		
		String actualPrdTitle =  getBasePage().get_text(homePage.productTitle);
		Assert.assertEquals(actualPrdTitle, "Products","Product Title is not matching");
		
		//clicking on the add to cart button
		getBasePage().safe_click(homePage.addToCartBtn);
		Thread.sleep(1000);
		//clicking on the cart icon and then it will navigate to cart page
		getBasePage().safe_click(homePage.shoppingCartIcon);
	
		
		//validating the Cart Page Title as Your Cart
		String actualCartTitle = getBasePage().get_text(cartPage.cartTitle);
		Assert.assertEquals(actualCartTitle, "Your Cart","Cart Title is not matching");
		
		Thread.sleep(3000);
		
		//Clicking on the checkout button
		getBasePage().safe_click(cartPage.checkoutBtn);
		
		
		Thread.sleep(3000);
		//validating the Cart Page Title as Your Cart
		String actualCheckOutTitle = getBasePage().get_text(checkOutPage.checkOutTitle);
		Assert.assertEquals(actualCheckOutTitle, "Checkout: Your Information","Checkout Title is not matching");

		getBasePage().safe_type(checkOutPage.firstNameTxt, "Auto");
		getBasePage().safe_type(checkOutPage.lastNameTxt, "Test");
		getBasePage().safe_type(checkOutPage.zipCodeTxt, "1234");
		getBasePage().safe_click(checkOutPage.continueBtn);

		Thread.sleep(3000);
		
		String actualCheckOutOverViewTitle = getBasePage().get_text(checkOutOverviewPage.checkOutOverViewTitle);
		
		Assert.assertEquals(actualCheckOutOverViewTitle, "Checkout: Overview","Checkout Over view Title is not matching");
		getBasePage().safe_click(checkOutOverviewPage.finishBtn);

		Thread.sleep(3000);
		String actualOrderCompleteTitle = getBasePage().get_text(orderCompletePage.orderCompleteTitle);
		Assert.assertEquals(actualOrderCompleteTitle, "Thank you for your order!","order complete Title is not matching");
		
	}
	
	@AfterTest
	public void tearDown() {
		getDriver().close();
	}

}
