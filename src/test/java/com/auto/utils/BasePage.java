package com.auto.utils;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {
	
	WebDriver driver;
	
	public BasePage() {
		
	}
	
	public BasePage(WebDriver driver) {
		this.driver=driver;
	}
	
	public void waitForElementTobeVisble(WebDriver driver, WebElement elem) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(50));
		wait.until(ExpectedConditions.visibilityOf(elem));
		
	}
	
	public void waitForElementTobeClickable(WebDriver driver,WebElement elem) {
		WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(50));
		wait1.until(ExpectedConditions.elementToBeClickable(elem));
	}
	
	public void safe_type(WebElement element,String data) {
		waitForElementTobeVisble(driver,element);
		element.sendKeys(data);
	}
	
	public void safe_click(WebElement element) {
		waitForElementTobeClickable(driver,element);
		element.click();
	}
	
	public String get_text(WebElement element) {
		waitForElementTobeVisble(driver,element);
		String data = element.getText();
		return data;
	}

}
