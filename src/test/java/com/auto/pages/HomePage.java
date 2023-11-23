package com.auto.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	
	public HomePage(WebDriver driver) {
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
}
