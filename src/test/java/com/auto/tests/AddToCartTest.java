package com.auto.tests;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import com.auto.pages.CartPage;
import com.auto.pages.CheckOutOverviewPage;
import com.auto.pages.CheckOutPage;
import com.auto.pages.HomePage;
import com.auto.pages.LoginPage;
import com.auto.pages.OrderCompletePage;
import com.auto.utils.BaseTest;

public class AddToCartTest extends BaseTest{
	
	@BeforeTest
	public void setUp() {
		launchApp("https://www.saucedemo.com/");
		waitForElementTobeVisble(getDriver(),getDriver().findElement(By.xpath("//input[@placeholder='Username']")));
	}
	
	@Test
	public void addToCartTest() throws InterruptedException {
		
		LoginPage loginPage = new LoginPage(getDriver());
		HomePage homePage = new HomePage(getDriver());
		CartPage cartPage = new CartPage(getDriver());
		CheckOutPage checkOutPage = new CheckOutPage(getDriver());
		CheckOutOverviewPage checkOutOverviewPage = new CheckOutOverviewPage(getDriver());
		OrderCompletePage orderCompletePage = new OrderCompletePage(getDriver());
		
		loginPage.loginIntoApplication("standard_user", "secret_sauce");
		waitForElementTobeVisble(getDriver(),homePage.title);
		
		//Validating the Home Page Title
		String actualTitle = homePage.title.getText();
		Assert.assertEquals(actualTitle, "Swag Labs","Home Page Title is not matching");
		
		String actualPrdTitle = homePage.productTitle.getText();
		Assert.assertEquals(actualPrdTitle, "Products","Product Title is not matching");
		
		//clicking on the add to cart button
		homePage.addToCartBtn.click();
		Thread.sleep(1000);
		//clicking on the cart icon and then it will navigate to cart page
		homePage.shoppingCartIcon.click();
		waitForElementTobeVisble(getDriver(), cartPage.cartTitle);
		
		//validating the Cart Page Title as Your Cart
		String actualCartTitle = cartPage.cartTitle.getText();
		Assert.assertEquals(actualCartTitle, "Your Cart","Cart Title is not matching");
		
		Thread.sleep(3000);
		
		//Clicking on the checkout button
		cartPage.checkoutBtn.click();
		waitForElementTobeVisble(getDriver(), checkOutPage.checkOutTitle);
		
		Thread.sleep(3000);
		//validating the Cart Page Title as Your Cart
		String actualCheckOutTitle = checkOutPage.checkOutTitle.getText();
		Assert.assertEquals(actualCheckOutTitle, "Checkout: Your Information","Checkout Title is not matching");
		
		checkOutPage.firstNameTxt.sendKeys("Auto");
		checkOutPage.lastNameTxt.sendKeys("Test");
		checkOutPage.zipCodeTxt.sendKeys("1234");
		checkOutPage.continueBtn.click();
		
		waitForElementTobeVisble(getDriver(), checkOutOverviewPage.checkOutOverViewTitle);
		Thread.sleep(3000);
		
		String actualCheckOutOverViewTitle = checkOutOverviewPage.checkOutOverViewTitle.getText();
		Assert.assertEquals(actualCheckOutOverViewTitle, "Checkout: Overview","Checkout Over view Title is not matching");
		checkOutOverviewPage.finishBtn.click();
		
		waitForElementTobeVisble(getDriver(), orderCompletePage.orderCompleteTitle);
		Thread.sleep(3000);
		String actualOrderCompleteTitle = orderCompletePage.orderCompleteTitle.getText();
		Assert.assertEquals(actualOrderCompleteTitle, "Thank you for your order!","order complete Title is not matching");
		
	}
	
	@AfterTest
	public void tearDown() {
		getDriver().close();
	}

}
