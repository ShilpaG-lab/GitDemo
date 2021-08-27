package com.qa.nms.Util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class TestUtil {
	static Xls_Reader reader;
	
	public static String TESTDATA_SHEET_PATH = "./src/main/java/com/qa/nmstestdata/NMS_TestData.xlsx";

	static Workbook book;
	static Sheet sheet;

	public void utilMethod() {

		System.out.println("I m fro Util method");
	}

	public static ArrayList<Object[]> getDataFromExcel() {

		ArrayList<Object[]> myData = new ArrayList<Object[]>();

		// reader=new
		// Xls_Reader("C:\\Users\\AVLVXT744\\eclipse-workspace\\SeleniumProject\\MavenGitRepoDemo\\src\\test\\java\\com\\qa\\nmstestdata\\NMS_TestData.xlsx");

		reader = new Xls_Reader("./src/main/java/com/qa/nmstestdata/NMS_TestData.xlsx");

		for (int rowNum = 2; rowNum <= reader.getRowCount("Request_Data"); rowNum++) {

			String appId = reader.getCellData("Request_Data", "applicationId", rowNum);
			String usId = reader.getCellData("Request_Data", "userId", rowNum);
			String transId = reader.getCellData("Request_Data", "transactionId", rowNum);

			Object ob[] = { appId, usId, transId };

			myData.add(ob);
		}
		return myData;
	}
	
	public static Object[][] getTestData1(String sheetName) {
		FileInputStream file = null;
		try {
			file = new FileInputStream(TESTDATA_SHEET_PATH);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		try {
			book = WorkbookFactory.create(file);
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
