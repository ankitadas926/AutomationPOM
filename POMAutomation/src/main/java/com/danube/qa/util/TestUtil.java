package com.danube.qa.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Iterator;

import org.apache.commons.compress.archivers.dump.InvalidFormatException;
import org.apache.commons.io.FileUtils;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xdgf.util.ObjectFactory;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.annotations.DataProvider;

import com.danube.qa.base.BaseTest;

public class TestUtil extends BaseTest{
	
	public static long PAGE_LOAD_TIMEOUT = 30;
	public static long IMPLICIY_WAIT = 10;
	public static long EXPLICITLY_WAIT = 10;
	public static String TESTDATA_PATH = "C:\\Users\\Devjit\\Documents\\AutomationPOM\\POMAutomation\\src\\main\\java\\com\\danube\\qa\\data\\TestData.xlsx";
	
	//static XSSFWorkbook  workbook;	
	//static XSSFSheet  sheet;
	
	static Workbook book;
	static Sheet sheet;
	
	public static void getScreenshot(String methodName) throws IOException{
		File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		File destFile = new File("C:\\Users\\Devjit\\Documents\\AutomationPOM\\POMAutomation\\screenshot\\" +methodName + ".png");
		FileUtils.copyFile(srcFile, destFile);
 	}
	
	public static Object[][] getDataFromExcel(String sheetName) {
		FileInputStream file = null;
		try {
			file = new FileInputStream(TESTDATA_PATH);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		try {
			book = WorkbookFactory.create(file);
		} catch (InvalidFormatException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		sheet = book.getSheet(sheetName);
		Object[][] data = new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
		// System.out.println(sheet.getLastRowNum() + "--------" +
		// sheet.getRow(0).getLastCellNum());
		for (int i = 0; i < sheet.getLastRowNum(); i++) {
			for (int k = 0; k < sheet.getRow(0).getLastCellNum(); k++) {
				data[i][k] = sheet.getRow(i + 1).getCell(k).toString();
				// System.out.println(data[i][k]);
			}
		}
		return data;
	}

	
}
