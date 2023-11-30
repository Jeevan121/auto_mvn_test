package com.auto.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.auto.utils.BasePage;

public class CheckOutPage extends BasePage{
	
	public CheckOutPage(WebDriver driver) {
		super(driver);
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
	
	public String getCheckoutTitle() {
		String title = get_text(checkOutTitle);
		return title;
	}
	
	public void enter_check_out_details(String firstName,String lastName,String zipCode) {
		safe_type(firstNameTxt, firstName);
		safe_type(lastNameTxt, lastName);
		safe_type(zipCodeTxt, zipCode);
		safe_click(continueBtn);
	}
	
	
}
