package com.auto.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckOutPage {
	
	public CheckOutPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//span[@class='title']")
	public WebElement checkOutTitle;
	
	@FindBy(id = "first-name")
	public WebElement firstNameTxt;
	
	@FindBy(id = "last-name")
	public WebElement lastNameTxt;
	
	@FindBy(id = "postal-code")
	public WebElement zipCodeTxt;
	
	@FindBy(id = "continue")
	public WebElement continueBtn;
	
	
}
