package com.danube.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.danube.qa.base.BaseTest;
import com.danube.qa.util.TestUtil;

public class LoginPage extends BaseTest{

	
	@FindBy(xpath = "//div[contains(@class,\'ad2-input-group\')][1]/div[@class = \'input-field\']/input[@type=\'text\']")
	WebElement username;
	
	@FindBy(xpath = "//div[contains(@class,\'ad2-input-group\')][2]/div[@class = \'input-field\']/input[@type=\'password\']")
	WebElement password;
	
	@FindBy(xpath = "//div[@class='login-buttons']/button[@type = 'submit']")
	WebElement signin;
	
	public LoginPage() {
		PageFactory.initElements(driver, this);
	}
	
	public String loginPageTitle() {
		return driver.getTitle();
	}
	
	public Basket login(String username, String password) {
		
		WaitForElementVisible(this.username, TestUtil.EXPLICITLY_WAIT);
		this.username.sendKeys(username);	
		WaitForElementVisible(this.password, TestUtil.EXPLICITLY_WAIT);
		this.password.sendKeys(password);
		
//		JavascriptExecutor js = (JavascriptExecutor) driver;  
//		String s1 = "document.querySelector('.input-field input').value = "+"'" +username+"'";
//		String s2 = "document.querySelectorAll('.input-field')[1].querySelector('input').value = "+ "'"+password+"'";
//		
//		WaitForElementVisible(this.username, TestUtil.EXPLICITLY_WAIT);
//		this.username.click();
//		js.executeScript(s1);
//		WaitForElementVisible(this.password, TestUtil.EXPLICITLY_WAIT);
//		this.password.click();
//		js.executeScript(s2);
		
		signin.click();
		
		
 		return new Basket();
		
	}
}
