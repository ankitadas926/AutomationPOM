package com.danube.qa.util;

import java.io.File;
import java.io.IOException;


import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.danube.qa.base.BaseTest;

public class TestUtil extends BaseTest{
	
	public static long PAGE_LOAD_TIMEOUT = 30;
	public static long IMPLICIY_WAIT = 10;
	public static long EXPLICITLY_WAIT = 10;

	public static void getScreenshot() throws IOException{
		File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		File destFile = new File("C:\\Users\\ADas\\eclipse-workspace\\POMAutomation\\screenshot\\" + System.currentTimeMillis() + ".png");
		FileUtils.copyFile(srcFile, destFile);
 	}
	
}
