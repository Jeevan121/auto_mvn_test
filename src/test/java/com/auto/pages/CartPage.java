package com.auto.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.auto.utils.BasePage;

public class CartPage extends BasePage{
	
	public CartPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//span[@class='title']")
	public WebElement cartTitle;
	
	@FindBy(xpath = "//button[@id='checkout']")
	public WebElement checkoutBtn;
	
	public String getCartTitle() {
		String title1 = get_text(cartTitle);
		return title1;
	}
	
	public void click_on_checkout_btn() {
		safe_click(checkoutBtn);
	}

}
