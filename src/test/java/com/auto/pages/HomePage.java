package com.auto.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.auto.utils.BasePage;

public class HomePage extends BasePage {
	
	public HomePage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//div[@class='app_logo']")
	public WebElement title;
	
	@FindBy(xpath = "//span[@class='title']")
	public WebElement productTitle;
	
	@FindBy(xpath="//button[@id='add-to-cart-sauce-labs-backpack']")
	public WebElement addToCartBtn;

	@FindBy(xpath = "//div[@id='shopping_cart_container']")
	public WebElement shoppingCartIcon;
	
	public String getHomePageTitle() {
		String title1 = get_text(title);
		return title1;
	}
	
	public String getProductTitle() {
		String title1 = get_text(productTitle);
		return title1;
	}
	
	public HomePage click_on_add_to_cart() {
		safe_click(addToCartBtn);
		return this;
	}
	
	public HomePage click_on_shopping_cart_icon() throws InterruptedException {
		Thread.sleep(1000);
		safe_click(shoppingCartIcon);
		return this;
	}
}
