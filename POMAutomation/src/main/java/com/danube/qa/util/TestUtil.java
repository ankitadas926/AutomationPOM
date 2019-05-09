package com.danube.qa.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Iterator;

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
	public static String TESTDATA_PATH = "C:\\Users\\ADas\\Documents\\AutomationPOM\\POMAutomation\\src\\main\\java\\com\\danube\\qa\\data\\TestData.xlsx";
	
	//static XSSFWorkbook  workbook;	
	//static XSSFSheet  sheet;
	
	static Workbook workbook;
	static Sheet sheet;
	
	public static void getScreenshot() throws IOException{
		File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		File destFile = new File("C:\\Users\\ADas\\Documents\\AutomationPOM\\POMAutomation\\screenshot" + System.currentTimeMillis() + ".png");
		FileUtils.copyFile(srcFile, destFile);
 	}
	
	public static Object[][] getDataFromExcel(String sheetname) {
		FileInputStream file = null;
		try {
			file = new FileInputStream(TESTDATA_PATH);	
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		try {
			workbook = WorkbookFactory.create(file);
		} catch (EncryptedDocumentException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
		sheet = workbook.getSheet(sheetname);
		System.out.println(sheet.getLastRowNum());
		System.out.println(sheet.getRow(0).getLastCellNum());
		
		Object[][] testData = new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
		for(int i = 0;i<sheet.getLastRowNum();i++) {
			for(int j = 0;j<sheet.getRow(0).getLastCellNum();j++) {
				testData[i][j] = sheet.getRow(i +1).getCell(j);
				System.out.println(testData[i][j]);
			}
		}
		
	return testData;

//		 try {
//			workbook = new XSSFWorkbook(file);
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		 
//		 sheet = workbook.getSheet(sheetname);
//		 
//		 Iterator<Row> rowIterator = sheet.iterator();
//         while (rowIterator.hasNext())
//         {
//             Row row = rowIterator.next();
//             //For each row, iterate through all the columns
//             Iterator<Cell> cellIterator = row.cellIterator();
//              
//             while (cellIterator.hasNext())
//             {
//                 Cell cell = cellIterator.next();
//                 System.out.print(cell.getStringCellValue());
//             }
//             System.out.println("");
//         }
		
	}
	
	
}
