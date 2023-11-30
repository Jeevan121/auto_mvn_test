package com.auto.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.auto.utils.BasePage;

public class OrderCompletePage extends BasePage{
	
	public OrderCompletePage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//h2[@class='complete-header']")
	public WebElement orderCompleteTitle;
	
	public String getOrderCompleteTitle() {
		String title = get_text(orderCompleteTitle);
		return title;
	}

}
