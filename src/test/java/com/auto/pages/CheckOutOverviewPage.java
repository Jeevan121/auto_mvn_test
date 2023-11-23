package com.auto.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckOutOverviewPage {
	
	public CheckOutOverviewPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//span[@class='title']")
	public WebElement checkOutOverViewTitle;
	
	@FindBy(id = "finish")
	public WebElement finishBtn;

}
