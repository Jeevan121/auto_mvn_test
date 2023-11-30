package com.auto.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.auto.utils.BasePage;

public class CheckOutOverviewPage extends BasePage{
	
	public CheckOutOverviewPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//span[@class='title']")
	public WebElement checkOutOverViewTitle;
	
	@FindBy(id = "finish")
	public WebElement finishBtn;
	
	public String getCheckoutOverviewTitle() {
		String title = get_text(checkOutOverViewTitle);
		return title;
	}
	
	public void click_on_finish_btn() {
		safe_click(finishBtn);
		
	}

}
