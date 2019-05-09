package com.danube.qa.base;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Parameters;

import com.danube.qa.util.EventHandler;
import com.danube.qa.util.TestUtil;

public class BaseTest {
	public static WebDriver driver;
	public static Properties prop;
	public static JavascriptExecutor js;
	public static EventFiringWebDriver e_driver;
	public static EventHandler handler;
	
	
	
	public BaseTest() {
		try {
		prop = new Properties();
		FileReader reader = new FileReader("C:\\Users\\Devjit\\Documents\\AutomationPOM\\POMAutomation\\src\\main\\java\\com\\danube\\qa\\config\\config.properties");
		prop.load(reader);		
		}
		catch(FileNotFoundException e) {
			e.printStackTrace();
		}
		catch(IOException e) {
			e.printStackTrace();
		}
		
	}
	
	
	public static void initialization(String browser,String url) {
		//String browserName = prop.getProperty("browser");
		
		String browserName = browser;
		if(browserName.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver", "C:\\Users\\Devjit\\Desktop\\chromedriver_win32\\chromedriver.exe");
			driver = new ChromeDriver();
		}
		
		e_driver = new EventFiringWebDriver(driver);
		handler = new EventHandler();
		e_driver.register(handler);
		driver = e_driver;
		
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIY_WAIT, TimeUnit.SECONDS);
		
		//driver.get(prop.getProperty("url"));
		driver.get(url);
	}
	
	public void WaitForElementVisible(WebElement element, long timeOutInSeconds)
    {

        try
        {
        	WebDriverWait wait = new WebDriverWait(driver, timeOutInSeconds);        	 
        	wait.until(ExpectedConditions.elementToBeClickable(element));

        }
        catch (Exception e)
        {
           e.getStackTrace();
        }
    }
		
}
