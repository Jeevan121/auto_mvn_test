package com.auto.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CartPage {
	
	public CartPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//span[@class='title']")
	public WebElement cartTitle;
	
	@FindBy(xpath = "//button[@id='checkout']")
	public WebElement checkoutBtn;

}
