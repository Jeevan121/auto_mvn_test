package com.auto.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
		public LoginPage(WebDriver driver) {
			PageFactory.initElements(driver, this);
		}
		

	
	  @FindBy(xpath="//input[@placeholder='Username']")
	  WebElement userNameTxt; 
	  
	  @FindBy(xpath = "//input[@placeholder='Password']")
	  WebElement passwordTxt;
	 
	  @FindBy(id="login-button")
	  WebElement loginBtn;
	 
	
	public void loginIntoApplication(String userName,String password) {
		userNameTxt.sendKeys(userName);
		passwordTxt.sendKeys(password);
		loginBtn.click();
	}
	
}
