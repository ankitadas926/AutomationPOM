package com.danube.qa.testcases;

import org.testng.Assert;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.danube.qa.base.BaseTest;
import com.danube.qa.pages.Basket;
import com.danube.qa.pages.LoginPage;
import com.danube.qa.util.TestUtil;

public class LoginPageTest extends BaseTest{
	
	LoginPage loginPage;
	TestUtil testutil;
	
	public LoginPageTest() {
		super();
	}
	
	@BeforeMethod
	public void setup() {
		initialization();
		loginPage = new LoginPage();
		testutil = new TestUtil();
	}
	
	@Test(priority = 1)
	public void loginPageTitleTest() {
		String title = loginPage.loginPageTitle();
		Assert.assertEquals(title, "Cheap hotels, flights and holidays from Travel Republic");
		
	}
	
	@Test(priority = 2)
	public void loginPageLoginTest() {
		
		Object obj = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		Assert.assertTrue(obj instanceof Basket);
	}
	
	@AfterMethod
	public void teardown() {
		driver.quit();
	}

}
