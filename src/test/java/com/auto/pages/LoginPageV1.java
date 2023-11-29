package com.auto.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.auto.utils.BasePage;

public class LoginPageV1 extends BasePage{
	
		public LoginPageV1(WebDriver driver) {
			super(driver);
			PageFactory.initElements(driver,this);
		}
		

	
	  @FindBy(xpath="//input[@placeholder='Username']")
	  public WebElement userNameTxt; 
	  
	  @FindBy(xpath = "//input[@placeholder='Password']")
	  WebElement passwordTxt;
	 
	  @FindBy(id="login-button")
	  WebElement loginBtn;
	 
	
	public void loginIntoApplication(String userName,String password) {
		safe_type(userNameTxt, userName);
		safe_type(passwordTxt, password);
		safe_click(loginBtn);
	}
	
}
