package com.danube.qa.testcases;

import static org.testng.Assert.assertTrue;

import org.testng.Assert;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
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
	@Parameters({"browser","url"})
	public void setup(String browser,String url) {
		initialization(browser,url);
		loginPage = new LoginPage();
		testutil = new TestUtil();
	}
	
	@Test(priority = 1)
	public void loginPageTitleTest() {
		String title = loginPage.loginPageTitle();
		Assert.assertEquals(title, "Cheap hotels, flights and holidays from Travel Republic");
		
	}
	
	@DataProvider(name = "data-provider")
	public Object[][] getData() {
		Object[][] testData = TestUtil.getDataFromExcel("login");
		return testData;
		
	}
	
	@Test(priority = 2,dependsOnMethods = {"loginPageTitleTest"},dataProvider = "data-provider")
	public void loginPageLoginTest(String username,String password) {
		
		//loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		//if(execute.equalsIgnoreCase("y")) {
			loginPage.login(username, password);
			Assert.assertTrue(loginPage.isSelectContext());
		//}
		
	}
	
	@AfterMethod
	public void teardown() {
		driver.quit();
	}

}
